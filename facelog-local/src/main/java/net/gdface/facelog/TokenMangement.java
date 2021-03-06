package net.gdface.facelog;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static net.gdface.facelog.FeatureConfig.*;
import static net.gdface.facelog.db.Constant.*;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.primitives.Bytes;

import gu.simplemq.redis.JedisPoolLazy;
import gu.simplemq.redis.JedisUtils;
import gu.simplemq.redis.RedisFactory;
import gu.simplemq.redis.RedisTable;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.exception.ObjectRetrievalException;
import net.gdface.facelog.db.exception.RuntimeDaoException;
import net.gdface.facelog.ServiceSecurityException.SecurityExceptionType;
import net.gdface.facelog.Token.TokenType;
import net.gdface.utils.FaceUtilits;

/**
 * 令牌管理模块
 * @author guyadong
 *
 */
class TokenMangement implements ServiceConstant {
	/**
	 * 由设备填写的常量字段
	 */
	private static final int[] CONST_FIELDS = {
			FL_DEVICE_ID_PRODUCT_NAME,
			FL_DEVICE_ID_MODEL,
			FL_DEVICE_ID_VENDOR,
			FL_DEVICE_ID_MANUFACTURER,
			FL_DEVICE_ID_MADE_DATE,
			FL_DEVICE_ID_VERSION,
			FL_DEVICE_ID_USED_SDKS,
			FL_DEVICE_ID_SERIAL_NO,
			FL_DEVICE_ID_EXT_BIN,
			FL_DEVICE_ID_EXT_TXT};
	private static final String ACK_PREFIX = "ack_";
	private final DaoManagement dao;
	private final CryptographGenerator cg;
	/**  {@code 设备ID -> token} 映射表 */
	private final RedisTable<Token> deviceTokenTable;
	/**  {@code 人员ID -> token} 映射表 */
	private final RedisTable<Token> personTokenTable;
	/** {@code cmd sn -> 人员ID} */
	private RedisTable<Integer> cmdSnTable;
	/** {@code channel -> 人员ID} */
	private RedisTable<Integer> ackChannelTable;
	/** 是否执行设备令牌验证 */
	private final boolean validateDeviceToken;
	/** 是否执行人员令牌验证 */
	private final boolean validatePersonToken;
	/** 人员令牌失效时间(分钟) */
	private final int personTokenExpire;
	/** 是否拒绝普通人员申请令牌 */
	private final boolean rejectZero;

	/**
	 * @param dao
	 */
	TokenMangement(DaoManagement dao) {
		this.dao = checkNotNull(dao,"dao is null");
		this.cg = this.dao.getCryptographGenerator();
		this.rejectZero = CONFIG.getBoolean(TOKEN_PERSON_REJECTZERO);
		this.validateDeviceToken = CONFIG.getBoolean(TOKEN_DEVICE_VALIDATE);
		this.validatePersonToken = CONFIG.getBoolean(TOKEN_PERSON_VALIDATE);
		this.personTokenExpire =CONFIG.getInt(TOKEN_PERSON_EXPIRE);
		this.deviceTokenTable =  RedisFactory.getTable(TABLE_DEVICE_TOKEN, JedisPoolLazy.getDefaultInstance());
		this.personTokenTable =  RedisFactory.getTable(TABLE_PERSON_TOKEN, JedisPoolLazy.getDefaultInstance());
		this.deviceTokenTable.setKeyHelper(Token.KEY_HELPER);
		this.personTokenTable.setKeyHelper(Token.KEY_HELPER);
		this.personTokenTable.setExpire(personTokenExpire, TimeUnit.MINUTES);
		this.cmdSnTable =  RedisFactory.getTable(TABLE_CMD_SN, JedisPoolLazy.getDefaultInstance());
		this.ackChannelTable =  RedisFactory.getTable(TABLE_ACK_CHANNEL, JedisPoolLazy.getDefaultInstance());
		this.cmdSnTable.setExpire(CONFIG.getInt(TOKEN_CMD_SERIALNO_EXPIRE), TimeUnit.SECONDS);
		this.ackChannelTable.setExpire(CONFIG.getInt(TOKEN_CMD_ACKCHANNEL_EXPIRE), TimeUnit.SECONDS);
		GlobalConfig.logTokenParameters();
	}
	/** 验证MAC地址是否有效(HEX格式,12字符,无分隔符,不区分大小写) */
	protected static final boolean isValidMac(String mac){
		return !Strings.isNullOrEmpty(mac) && mac.matches("^[a-fA-F0-9]{12}$");
	}
	protected static final void checkValidMac(String mac) throws ServiceSecurityException{
		if(!isValidMac(mac)){
			throw new ServiceSecurityException(String.format("INVALID MAC:%s ", mac))
			.setType(SecurityExceptionType.INVALID_MAC);
		}
	}
	/** 验证序列号是否有效 */
	protected boolean isValidSerialNo(String sn){
		return true;
	}
	/** 序列号已经被占用则抛出异常 */
	protected void checkNotOccupiedSerialNo(String sn) throws ServiceSecurityException{
		DeviceBean bean = null == sn ? null : dao.daoGetDeviceByIndexSerialNo(sn);
		if(null != bean){
			throw new ServiceSecurityException(
					String.format("serian no:%s be occupied by device ID[%d] MAC[%s]", sn,bean.getId(),bean.getMac()))
					.setType(SecurityExceptionType.OCCUPIED_SN).setDeviceID(bean.getId());
		}			
	}
	/** 序列号无效则抛出异常 */
	protected void checkValidSerialNo(String sn) throws ServiceSecurityException{
		if(!isValidSerialNo(sn)){
			throw new ServiceSecurityException(String.format("INVALID serial number:%s", sn))
					.setType(SecurityExceptionType.INVALID_SN);
		}
	}
	/** 允许的令牌类型 */
	enum Enable{
		/** 允许所有令牌类型 */ALL,
		/** 只允许人员令牌 */PERSON_ONLY,
		/** 只允许设备令牌 */DEVICE_ONLY,
		/** 只允许root令牌 */ROOT_ONLY;
		
		boolean isValid(TokenMangement tm,Token token){
			TokenOp.VALIDATE.asContextTokenOp();
			switch(this){
			case PERSON_ONLY:
				return tm.isValidPersonToken(token) || tm.isValidRootToken(token);
			case DEVICE_ONLY:
				return tm.isValidDeviceToken(token);
			case ROOT_ONLY:
				return tm.isValidRootToken(token);
			case ALL:
				return tm.isValidPersonToken(token) || tm.isValidDeviceToken(token) || tm.isValidRootToken(token);
			default:
				return false;
			}
		}
		/** 
		 * 验证令牌是否有效,无效抛出异常
		 * @throws ServiceSecurityException 
		 */
		void check(TokenMangement tm,Token token) throws ServiceSecurityException{
			if(isValid(tm,token)){
				return;
			}
			StringBuffer message = new StringBuffer("INVALID TOKEN");
			if(null != token){
				switch(this){
				case PERSON_ONLY:
					message.append(",Person Token required");
					break;
				case DEVICE_ONLY:
					message.append(",Device Token required");
					break;
				case ROOT_ONLY:
					message.append(",root Token required");
					break;
				default:
					break;
				}
			}else{
				message.append(",null token");
			}
			throw new ServiceSecurityException(message.toString())
								.setType(SecurityExceptionType.INVALID_TOKEN);
		}
	}
	boolean isUserToken(Token token){
		return token != null && (TokenType.PERSON.equals(token.getType()) || TokenType.ROOT.equals(token.getType()));
	}
	boolean isDeviceToken(Token token){
		return token != null && TokenType.DEVICE.equals(token.getType()) ;
	}
	boolean isRootToken(Token token){
		return token != null && TokenType.ROOT.equals(token.getType()) ;
	}
	boolean isPersonToken(Token token){
		return token != null && TokenType.PERSON.equals(token.getType()) ;
	}
	/** 验证设备令牌是否有效 */
	boolean isValidDeviceToken(Token token){
		if(validateDeviceToken){
			return null == token 
					? false 
					: TokenType.DEVICE.equals(token.getType()) && token.equals(deviceTokenTable.get(Integer.toString(token.getId())));			
		}else{
			return true;
		}
	}
	/** 验证PERSON/ROOT令牌是否有效 */
	boolean isValidUserToken(Token token){
		if(validatePersonToken){
			return null == token 
					? false 
					: (TokenType.PERSON.equals(token.getType()) || TokenType.ROOT.equals(token.getType()))
						&& token.equals(personTokenTable.get(Integer.toString(token.getId())));
		}else{
			return true;
		}
	}
	/** 验证人员令牌是否有效 */
	boolean isValidPersonToken(Token token){
		if(validatePersonToken){
			return token != null  ? TokenType.PERSON.equals(token.getType()) && isValidUserToken(token) : false;
		}else{
			return true;
		}
	}
	/** 验证root令牌是否有效 */
	boolean isValidRootToken(Token token){
		if(validatePersonToken){
			return TokenType.ROOT.equals(token.getType()) && isValidUserToken(token);
		}else{
			return true;
		}
	}
	/** 验证令牌是否有效 */
	boolean isValidToken(Token token){
		if(token != null){
			switch (token.getType()) {
			case DEVICE:
				return isValidDeviceToken(token);
			case PERSON:
			case ROOT:
				return isValidUserToken(token);
			default:
				break;
			}
		}
		return false;

	}
	/** 检查数据库是否存在指定的设备记录,没有则抛出异常{@link ServiceSecurityException} */
	protected void checkValidDeviceId(Integer deviceId) throws ServiceSecurityException{
		if(!this.dao.daoExistsDevice(deviceId)){
			throw new ServiceSecurityException(String.format("NOT EXISTS device %d", deviceId))
					.setType(SecurityExceptionType.INVALID_DEVICE_ID);
		}
	}
	private static Token makeToken(byte[] source){
		ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
		buffer.asLongBuffer().put(System.nanoTime());
		byte[] md5 = FaceUtilits.getMD5(Bytes.concat(checkNotNull(source),buffer.array()));
		ByteBuffer byteBuffers = ByteBuffer.wrap(md5);
		return new Token(byteBuffers.getInt(), byteBuffers.getInt(),byteBuffers.getInt(),byteBuffers.getInt()).asContextToken();
	}
	private static Token makeToken(Object ...objs){
		checkArgument(null != objs && 0 != objs.length,"objs must not be null or empty");
		StringBuffer buffer = new StringBuffer(64);
		for(Object obj :objs){
			buffer.append(obj);
		}
		return makeToken(buffer.toString().getBytes());
	}
	/**
	 * 计算设备令牌
	 * @param device 设备参数(包括设备ID,MAC地址,序列号),序列号为null则用MAC地址代替
	 * @return 设备访问令牌
	 * @throws IllegalArgumentException 设备ID,MAC地址为{@code null}
	 */
	private static Token makeDeviceTokenOf(DeviceBean device){
		checkArgument(null != device,"device is null");
		checkArgument(
						null != device.getId() 
				&& 	null != device.getMac(),
				"null device argument(id,mac)");
		return makeToken(device.getId(),device.getMac(),
				MoreObjects.firstNonNull(device.getSerialNo(),device.getMac()))
				.asDeviceToken(device.getId());
	}
	private static Token makePersonTokenOf(int personId){
		ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
		buffer.asLongBuffer().put(personId);
		return makeToken(buffer.array()).asPersonToken(personId);
	}
	private static Token makeRootToken(String password){
		ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
		buffer.asLongBuffer().put(System.currentTimeMillis());
		return makeToken(Bytes.concat(password.getBytes(),buffer.array())).asRootToken();
	}
	/**
	 * 从{@link #deviceTokenTable}删除指定设备的令牌
	 * @param deviceId
	 */
	private void removeDeviceTokenOf(int deviceId){
		deviceTokenTable.remove(Integer.toString(deviceId));
	}
	/**
	 * 从{@link #personTokenTable}删除指定人员的令牌
	 * @param personId
	 */
	private void removePersonTokenOf(int personId){
		personTokenTable.remove(Integer.toString(personId));
	}
	/**
	 * 如果{@code token}为设备令牌则返回对应的设备信息对象{@link DeviceBean},否则返回{@code null}
	 * @param token 令牌
	 * @return {@link DeviceBean}对象或{@code null}
	 */
	protected DeviceBean getDeviceOrNull(Token token){
		return (token != null && token.getType() == TokenType.DEVICE) ? dao.daoGetDevice(token.getId()) : null;
	}
	/**
	 * 如果{@code token}为人员令牌则返回对应的人员信息对象{@link PersonBean},否则返回{@code null}
	 * @param token 令牌
	 * @return {@link PersonBean}对象或{@code null}
	 */
	protected PersonBean getPersonOrNull(Token token){
		return (token != null && token.getType() == TokenType.PERSON) ? dao.daoGetPerson(token.getId()) : null;
	}
	/**
	 * 从令牌中获取人员等级
	 * @param token
	 * @return
	 */
	protected PersonRank rankOf(Token token){
		if(token != null && token.getType() == TokenType.ROOT){
			return PersonRank.root;
		}
		PersonBean personBean = getPersonOrNull(token);
		return personBean == null ? PersonRank.person : PersonRank.fromRank(personBean.getRank());
	}
	/**
	 * 人员令牌(token)的等级小于指定的等级(rank)时抛出异常
	 * @param token
	 * @param rank
	 * @throws ServiceSecurityException
	 */
	protected void checkRank(Token token,PersonRank rank) throws ServiceSecurityException{
		if(rankOf(token).ordinal() < checkNotNull(rank,"rank is null").ordinal()){
			throw new ServiceSecurityException("admin rank required",SecurityExceptionType.TOO_LOW_RANK);
		}
	}
	/**
	 * 设备注册
	 * @param newDevice
	 * @return
	 * @throws ServiceSecurityException
	 */
	protected DeviceBean registerDevice(DeviceBean newDevice)
			throws ServiceSecurityException{
		TokenOp.REGISTER.asContextTokenOp();
		checkArgument(null != newDevice,"deviceBean must not be null");
		// 检查是否为新记录，
		checkArgument(newDevice.isNew(),
				"for device registeration the 'newDevice' must be a new record,so the _isNew field must be true ");
		// ID为自增长键，新记录ID字段不能指定，由数据库分配
		checkArgument(
				!newDevice.isModified(FL_DEVICE_ID_ID) 
				|| Objects.equal(0,newDevice.getId()),
				"for device registeration the 'newDevice' must be a new record,so id field must be not be set or be zero");
		// sdk_version字段不可为空
		checkArgument(!Strings.isNullOrEmpty(newDevice.getUsedSdks()), "sdkVersion must not be null or empty");

		// 检查sdk_version是否允许注册
		checkArgument(FEATURE_CONFIG.allValidSdkVersions(newDevice.getUsedSdks()), 
				"UNSUPPORTED SDK Version [%s]",newDevice.getUsedSdks());
		String mac = newDevice.getMac();
    	checkArgument(mac != null && mac.matches("^[\\da-fA-F]{12}$"),"INVALID mac address");
    	mac = mac.toLowerCase();
		DeviceBean dmac = this.dao.daoGetDeviceByIndexMac(mac);
		if(null !=dmac ){
			// 设备已经注册
			boolean oldSnValid = isValidSerialNo(dmac.getSerialNo());
			if(Objects.equal(newDevice.getSerialNo(),dmac.getSerialNo()) && oldSnValid){
				// 序列号一致且有效
				// DO NOTHING
			}else	if(null == newDevice.getSerialNo() && oldSnValid){
				// 原序列号有效就使用原序列号
				newDevice.setSerialNo(dmac.getSerialNo());
			}else{
				checkNotOccupiedSerialNo(newDevice.getSerialNo());
				checkValidSerialNo(newDevice.getSerialNo());
				// 用新序列号替换原记录中无效的序列号
			}
			// 复制新记录中的常量字段
			dmac.copy(newDevice, CONST_FIELDS);			
			return dmac.isModified() ? dao.daoSaveDevice(dmac):dmac;
		}else{
			checkNotOccupiedSerialNo(newDevice.getSerialNo());
			checkValidSerialNo(newDevice.getSerialNo());
			return this.dao.daoSaveDevice(newDevice);
		}
	}
	/**
	 * 设备注销
	 * @param deviceId
	 * @throws ServiceSecurityException
	 */
	protected void unregisterDevice(int deviceId)
			throws ServiceSecurityException{
		TokenOp.UNREGISTER.asContextTokenOp();
		this.dao.daoDeleteDevice(deviceId);
	}
	/**
	 * 申请设备令牌
	 * @param loginDevice 申请信息设备信息，必须提供{@code id, mac, serialNo}字段
	 * @return
	 * @throws ServiceSecurityException
	 */
	protected Token applyDeviceToken(DeviceBean loginDevice)
			throws ServiceSecurityException{
		TokenOp.APPLY.asContextTokenOp();
		checkValidDeviceId(loginDevice.getId());

		DeviceBean device = dao.daoGetDevice(loginDevice.getId());
		if(!Objects.equal(device.getMac(), loginDevice.getMac()) ){
			throw new ServiceSecurityException(
					String.format("MISMATCH MAC:%s", device.getMac()))
				.setType(SecurityExceptionType.INVALID_MAC);
		}
		if(!Objects.equal(device.getSerialNo(), loginDevice.getSerialNo())){
			throw new ServiceSecurityException(
					String.format("MISMATCH Serial Number:%s", device.getSerialNo()))
				.setType(SecurityExceptionType.INVALID_SN);
		}
		// 生成一个新令牌
		Token token = makeDeviceTokenOf(device);
		deviceTokenTable.set(device.getId().toString(), token, false);
		return token;
	}
	/**
	 * 释放设备令牌
	 * @param token 当前持有的令牌
	 * @throws ServiceSecurityException
	 */
	protected void releaseDeviceToken(Token token)
			throws ServiceSecurityException{
		TokenOp.RELEASE.asContextTokenOp();;
		Enable.DEVICE_ONLY.check(this, token);
		removeDeviceTokenOf(token.getId());
	}
	/**
	 * 申请人员访问令牌
	 * @param personId
	 * @param password 
	 * @param isMd5 
	 * @return
	 * @throws ServiceSecurityException
	 * @see #checkValidPassword(String, String, boolean)
	 */
	protected Token applyPersonToken(int personId, String password, boolean isMd5)
			throws ServiceSecurityException{
		TokenOp.APPLY.asContextTokenOp();
		checkValidPassword(Integer.toString(personId), password, isMd5);
		if(CommonConstant.PersonRank.person.equals(CommonConstant.PersonRank.fromRank(dao.daoGetPerson(personId).getRank()))
			&&	rejectZero ){
			// 当配置参数指定不允许普通人员申请令牌时抛出异常
			throw new ServiceSecurityException(
					String.format("REJECTION OF APPLICATION for rank 0 user (id = %d)",personId))
				.setType(SecurityExceptionType.REJECT_APPLY);
		}
		Token token = makePersonTokenOf(personId);
		String key = Integer.toString(personId);
		personTokenTable.set(key, token, false);
		personTokenTable.expire(token);
		return token;
	}
	/**
	 * 释放人员访问令牌
	 * @param token 当前持有的令牌
	 * @throws ServiceSecurityException
	 */
	protected void releasePersonToken(Token token)
			throws ServiceSecurityException{
		TokenOp.RELEASE.asContextTokenOp();

		Enable.PERSON_ONLY.check(this, token);
		removePersonTokenOf(token.getId());
	}
	/**
	 * 申请root访问令牌
	 * @param password root密码
	 * @param isMd5 为{@code false}代表{@code password}为明文,{@code true}指定{@code password}为32位MD5密文(小写)
	 * @return
	 * @throws ServiceSecurityException
	 */
	protected Token applyRootToken(String password, boolean isMd5)
			throws ServiceSecurityException{
		TokenOp.APPLY.asContextTokenOp();
		checkValidPassword(ROOT_NAME,password,isMd5);
		Token token = makeRootToken(password);
		String key = Integer.toString(token.getId());
		personTokenTable.set(key, token, false);
		personTokenTable.expire(token);
		return token;
	}
	/**
	 * 释放root访问令牌
	 * @param token 当前持有的令牌
	 * @throws ServiceSecurityException
	 */
	protected void releaseRootToken(Token token)
			throws ServiceSecurityException{
		TokenOp.RELEASE.asContextTokenOp();

		Enable.ROOT_ONLY.check(this, token);
		removePersonTokenOf(token.getId());
	}
	/**
	 * 验证用户密码是否匹配
	 * @param userId 用户id字符串,root用户id即为{@link CommonConstant#ROOT_NAME}
	 * @param password 用户密码
	 * @param isMd5 为{@code false}代表{@code password}为明文,{@code true}指定{@code password}为32位MD5密文(小写)
	 * @return
	 * @throws RuntimeDaoException 
	 * @throws ServiceSecurityException 
	 * @throws IllegalArgumentException {@code userId} 无效
	 */
	protected boolean isValidPassword(String userId,String password, boolean isMd5) throws RuntimeDaoException, ServiceSecurityException {
		TokenOp.VALIDPWD.asContextTokenOp();
		checkArgument(!Strings.isNullOrEmpty(userId),"INVALID argument,must not be null or empty");
		if(ROOT_NAME.equals(userId)){
			// 从配置文件中读取root密码算出MD5与输入的密码比较
			return cg.cryptograph(CONFIG.getString(ROOT_PASSWORD),false).equals(cg.cryptograph(password,isMd5));
		}else{
			// 从数据库中读取用户密码(已经掺盐加密)与输入的密码比较
			try{
				Integer id = Integer.valueOf(userId);
				String passwordMd5InDb = dao.daoGetPersonChecked(id).getPassword();
				return cg.cryptograph(password,isMd5).equals(passwordMd5InDb);
			}catch(ObjectRetrievalException e){
				throw new ServiceSecurityException(SecurityExceptionType.INVALID_PERSON_ID);
			}catch(NumberFormatException e){
				throw new ServiceSecurityException(SecurityExceptionType.INVALID_PERSON_ID);
			}
		}
	}
	/**
	 * 检查密码是否正确
	 * @param userId
	 * @param password
	 * @param isMd5
	 * @throws ServiceSecurityException 密码不匹配,{@code userId}无效
	 * @see #isValidPassword(String, String, boolean)
	 */
	protected void checkValidPassword(String userId,String password, boolean isMd5) throws ServiceSecurityException{
		if(!isValidPassword(userId, password, isMd5)){
			throw new ServiceSecurityException(
					String.format("INVALID password [%s]for user [%s]",password,userId))
				.setType(SecurityExceptionType.INVALID_PASSWORD);
		}
	}
	/** 
	 * 申请一个唯一的命令序列号 
	 * @param id
	 */
	protected int applyCmdSn(int id){
		int sn = JedisUtils.incr(KEY_CMD_SN);
		String key = Long.toString(sn);
		this.cmdSnTable.set(key, id, false);
		this.cmdSnTable.expire(key);
		return sn;
	}
	/** 申请一个唯一的命令响应通道 
	 * @param id
	 * @param duration 通道有效时间 大于0有效,否则使用默认的有效期*/
	protected String applyAckChannel(int id, int duration){
		String channel = new StringBuffer(ACK_PREFIX)
				.append(JedisUtils.incr(KEY_ACK_SN))
				.toString();
		this.ackChannelTable.set(channel, id, false);
		if(duration>0){
			this.ackChannelTable.expire(channel,duration,TimeUnit.SECONDS);
		}else{
			this.ackChannelTable.expire(channel);
		}
		return channel;
	}
	
	/**
	 * 判断命令序列号是否有效
	 * @param cmdSn
	 * @return
	 */
	protected boolean isValidCmdSn(int cmdSn){
		return this.cmdSnTable.containsKey(Integer.toString(cmdSn));
	}
	/**
	 * 判断命令响应通道是否有效
	 * @param ackChannel
	 * @return
	 */
	protected boolean isValidAckChannel(String ackChannel){
		return this.ackChannelTable.containsKey(ackChannel);
	}
}

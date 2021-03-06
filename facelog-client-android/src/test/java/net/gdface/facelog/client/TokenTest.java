package net.gdface.facelog.client;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

import com.google.common.hash.Hashing;

import net.gdface.facelog.CommonConstant;
import net.gdface.facelog.ServiceSecurityException;
import net.gdface.facelog.Token;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.thrift.IFaceLogThriftClient;
import net.gdface.thrift.ClientFactory;
import net.gdface.thrift.exception.client.BaseServiceRuntimeException;
import net.gdface.utils.NetworkUtil;

/**
 * 令牌相关测试
 * @author guyadong
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TokenTest implements CommonConstant {
    public static final Logger logger = LoggerFactory.getLogger(TokenTest.class);

	private static IFaceLogClient facelogClient;
	private static Token rootToken;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		facelogClient = ClientFactory.builder().setHostAndPort("127.0.0.1", DEFAULT_PORT).build(IFaceLogThriftClient.class,IFaceLogClient.class);
		rootToken = facelogClient.applyRootToken("guyadong", false);

	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		facelogClient.releaseRootToken(rootToken);
	}
	@Test
	public void test1CheckPersonName(){
		try{
			PersonBean person = PersonBean.builder()
					.name("root").build();
			facelogClient.savePerson(person, rootToken);
			assertTrue("root用户名保留机制无效",false);
		}catch(BaseServiceRuntimeException e){
			ExceptionType type = ExceptionType.values()[e.getType()];
			assertTrue("异常类型分类错误",type == ExceptionType.UNCLASSIFIED);
		}
	}
	@Test
	public void test2CheckMd5Password(){
		// 创建普通用户
		String adminpwd = "password";
		PersonBean person = PersonBean.builder()
				.name("黄小明")
				.password(adminpwd)
				.build();
		try{
			// 创建普通用户
			person.setPassword(adminpwd);
			person = facelogClient.savePerson(person, rootToken);
			assertTrue("存入密码明文应该抛出异常",false);
		}catch(BaseServiceRuntimeException e){
			logger.error(e.getMessage());
			ExceptionType type = ExceptionType.values()[e.getType()];
			assertTrue("异常类型分类错误",type == ExceptionType.UNCLASSIFIED);
		}
		try{
			String md5OfPwd= Hashing.md5().hashBytes(adminpwd.getBytes()).toString();
			person.setPassword(md5OfPwd);
			person = facelogClient.savePerson(person, rootToken);
		}catch(BaseServiceRuntimeException e){
			logger.error(e.getServiceStackTraceMessage());
			assertTrue(false);
		}
		try{
			// 以普通用户身份申请令牌
			facelogClient.applyPersonToken(person.getId(), adminpwd, false);
			assertTrue("普通用户不允许申请令牌",false);
		}catch(BaseServiceRuntimeException e){
			logger.error(e.getServiceStackTraceMessage());
			assertTrue(false);
		} catch (ServiceSecurityException e) {
			logger.error(e.getMessage());
			assertTrue(true);
		}
		try{
			// 设置为操作员级别
			person.setRank(PersonRank.operator.rank);
			person = facelogClient.savePerson(person, rootToken);
			// 以操作员级别申请令牌
			Token operatorToken = facelogClient.applyPersonToken(person.getId(), adminpwd, false);
			PersonBean user = PersonBean.builder().reset().name("刘量体").build();
			// 以操作员级别令牌写数据库
			user = facelogClient.savePerson(user, operatorToken);	
			assertTrue(user.equals(facelogClient.getPerson(user.getId())));
		}catch(BaseServiceRuntimeException e){
			logger.error(e.getServiceStackTraceMessage());
			assertTrue(false);
		} catch (ServiceSecurityException e) {
			logger.error(e.getMessage());
			assertTrue(false);
		}
		try{
			// 设置为操作员级别
			person.setRank(PersonRank.operator.rank);
			facelogClient.savePerson(person, rootToken);
			// 以操作员级别申请令牌
			Token operatorToken = facelogClient.applyPersonToken(person.getId(), adminpwd, false);
			PersonBean user = PersonBean.builder().name("刘峰").rank(PersonRank.operator.rank).build();
			// 以操作员级别令牌写数据库
			facelogClient.savePerson(user, operatorToken);	
			assertTrue("权限检查异常,应该不允许创建同级别或高级别帐户",false);
		}catch(BaseServiceRuntimeException e){
			logger.error("{}",ExceptionType.values()[e.getType()]);
			logger.error("{}",e.getMessage());
			assertTrue(ExceptionType.SECURITY_ERROR == ExceptionType.values()[e.getType()]);
		} catch (ServiceSecurityException e) {
			logger.error(e.getMessage());	
		}
	}
	@Test
	public void test3PersonToken() {
		String adminpwd = "adminPassword";
		String md5OfPwd= Hashing.md5().hashBytes(adminpwd.getBytes()).toString();
		PersonBean newPerson = PersonBean.builder()
				.name("admin")
				.rank(PersonRank.admin.rank)
				.password(md5OfPwd)
				.remark("管理员1")
				.build();
		try {
			// 增加一个admin帐户
			newPerson = facelogClient.savePerson(newPerson,rootToken);
			logger.error("person = {}", newPerson.toString());
			PersonBean reRead = facelogClient.getPerson(newPerson.getId());
			assertTrue("数据写入一致性错误",reRead.equals(newPerson));
			assertTrue("时间戳字段没有更新",null != reRead.getCreateTime());
			assertTrue("存入密码没有加盐",!md5OfPwd.equals(reRead.getPassword()));
			// 申请admin令牌
			Token adminToken = facelogClient.applyPersonToken(newPerson.getId(),adminpwd, false);
			Token adminToken2 = facelogClient.applyPersonToken(newPerson.getId(),md5OfPwd, true);
			// 先申请的令牌自动失效
			assertTrue("两次申请令牌不应该一样",!adminToken.equals(adminToken2));
			try{
				facelogClient.releasePersonToken(adminToken);
				assertTrue("无效令牌应该抛出异常",false);
			}catch(ServiceSecurityException e){
				logger.error(e.getMessage());
				assertTrue(true);
			}
			facelogClient.releasePersonToken(adminToken2);
		} catch(BaseServiceRuntimeException e){
			e.printServiceStackTrace();
			assertTrue(e.getMessage(),false);
		}catch (ServiceSecurityException e) {
			logger.error(e.getMessage());
			assertTrue(e.getMessage(),false);
		}
	}
	@Test
	public void test4RegisterDevice(){
		byte[] address = new byte[]{0x20,0x20,0x20,0x20,0x20,0x20};
		try {
			DeviceBean device = DeviceBean.builder().mac(NetworkUtil.formatMac(address, null)).serialNo("12122333").build();
			logger.info(device.toString(true,false));
			device = facelogClient.registerDevice(device);
			Token deviceToken = facelogClient.online(device);
			facelogClient.unregisterDevice(deviceToken);
		} catch(BaseServiceRuntimeException e){
			e.printServiceStackTrace();
			assertTrue(e.getMessage(),false);
		}catch (ServiceSecurityException e) {
			logger.error(e.getType().name());
			assertTrue(e.getMessage(),false);
		}
	}
	@Test
	public void test5SaveServiceConfig(){
		try{
			facelogClient.setProperty("do.test.my.key", "芳华", rootToken);
			facelogClient.saveServiceConfig(rootToken);
		}catch(BaseServiceRuntimeException e){
			e.printServiceStackTrace();
			assertTrue(e.getMessage(),false);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(e.getMessage(),false);
		}
	}
}

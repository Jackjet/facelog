package net.gdface.facelog.client;

import gu.dtalk.client.BaseConsole;
import gu.dtalk.exception.DtalkException;
import gu.dtalk.redis.RedisConfigType;
import gu.simplemq.Channel;
import gu.simplemq.redis.JedisPoolLazy;
import net.gdface.facelog.MQParam;
import net.gdface.facelog.Token;
import net.gdface.facelog.client.dtalk.FacelogRedisConfigProvider;
import net.gdface.facelog.client.dtalk.TokenRequestValidator;
import net.gdface.facelog.client.location.ConnectConfigType;
import net.gdface.facelog.client.location.DefaultCustomConnectConfigProvider;
import net.gdface.facelog.thrift.IFaceLogThriftClient;
import net.gdface.thrift.ClientFactory;
import static net.gdface.facelog.client.ConsoleConfig.CONSOLE_CONFIG;

import java.net.URI;
import java.util.Map;

import static com.google.common.base.Preconditions.*;

public class FacelogConsole extends BaseConsole {

	private static Token token;
	public FacelogConsole(String devmac, RedisConfigType config) {
		super(devmac, config);
	}

	@Override
	protected boolean authorize() {
		String connstr = TokenRequestValidator.encodeReq(token,temminalMac);

		Channel<String> conch = new Channel<>(connchname, String.class);
		syncPublish(conch,connstr);
		if(reqChannel != null){
			System.out.println("TOKEN validate passed");
			return true;
		}
		return false;
	}

	public static void main(String []args){
		System.out.println("Text terminal for Facelog Device is starting(facelog设备交互字符终端启动)");

		CONSOLE_CONFIG.parseCommandLine(args);
		boolean useCustom = 
				   DefaultCustomConnectConfigProvider.initHost(CONSOLE_CONFIG.getServiceHost())
				|| DefaultCustomConnectConfigProvider.initPort(CONSOLE_CONFIG.getServicePort());
		ConnectConfigType type;
		try {
			if(useCustom){
				type = ConnectConfigType.CUSTOM;
				checkArgument(type.testConnect(),"NOT CONNECT TO facelog service %s:%s",
						type.getHost(),type.getPort());
			}else{
				type = ConnectConfigType.lookupRedisConnect();
			}
			IFaceLogClient facelogClient = ClientFactory.builder()
					.setHostAndPort(type.getHost(), type.getPort())
					.setDecorator(RefreshTokenDecorator.makeDecoratorFunction( new UserTokenHelperImpl()))
					.build(IFaceLogThriftClient.class, IFaceLogClient.class);	
			token = facelogClient.applyUserToken(CONSOLE_CONFIG.getUserId(), CONSOLE_CONFIG.getPassword(), false);
			// 获取redis连接参数
			Map<MQParam, String> redisParam = facelogClient.getRedisParameters(token);
			FacelogRedisConfigProvider.setRedisLocation(URI.create(redisParam.get(MQParam.REDIS_URI)));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ;
		}

		RedisConfigType config;
		try {
			config = RedisConfigType.lookupRedisConnect();
		} catch (DtalkException e) {
			System.out.println(e.getMessage());
			return;
		}
		logger.info("use config={}",config.toString());
		// 创建redis连接实例
		JedisPoolLazy.createDefaultInstance( config.readRedisParam() );

		FacelogConsole client = new FacelogConsole(CONSOLE_CONFIG.getMac(), config);
		client.start();

	}
	public static class UserTokenHelperImpl extends TokenHelper {

		public UserTokenHelperImpl() {
		}

		@Override
		public String passwordOf(int id) {
			return CONSOLE_CONFIG.getPassword();
		}

		@Override
		public boolean isHashedPwd() {
			return false;
		}

		@Override
		public void saveFreshedToken(Token token) {
			FacelogConsole.token.assignFrom(token);
		}

	}
}

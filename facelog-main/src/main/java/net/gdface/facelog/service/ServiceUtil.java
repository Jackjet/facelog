package net.gdface.facelog.service;

import java.net.SocketAddress;

import com.facebook.nifty.core.ConnectionContext;
import com.facebook.nifty.core.RequestContext;
import com.facebook.nifty.core.RequestContexts;

/**
 * @author guyadong
 *
 */
public class ServiceUtil {
	private ServiceUtil() {}
	/**
	 * 返回客户端IP地址
	 * @return
	 */
	public static SocketAddress niftyClientAddress(){
		RequestContext request = RequestContexts.getCurrentContext();
		ConnectionContext connect = request.getConnectionContext();
		return connect.getRemoteAddress();	
	}
}

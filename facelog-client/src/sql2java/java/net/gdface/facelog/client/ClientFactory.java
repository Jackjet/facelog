// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// template: client.factory.vm
// ______________________________________________________
package net.gdface.facelog.client;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.nifty.client.NiftyClientChannel;
import com.facebook.nifty.client.NiftyClientConnector;
import com.facebook.swift.service.ThriftClient;
import com.facebook.swift.service.ThriftClientConfig;
import com.facebook.swift.service.ThriftClientManager;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.net.HostAndPort;
import static com.google.common.net.HostAndPort.fromParts;
import static com.google.common.net.HostAndPort.fromString;
import static com.google.common.base.Preconditions.checkNotNull;

import io.airlift.units.Duration;
/**
 * Factory class for creating client instance of IFaceLog<br>
 * Example:<br>
 * <pre>
 * // get a asynchronous instance
 * IFaceLogClientAsync client = ClientFactory.builder()
 * .setHostAndPort("127.0.0.1",9090)
 * .setTimeout(10,TimeUnit.SECONDS)
 * .buildAsync();
 * </pre>
 * @author guyadong
 *
 */
public class ClientFactory {
    private static class Singleton{
        private static final ThriftClientManager clientManager = new ThriftClientManager();    
        static{
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    clientManager.close();
                }});
        }
    }    
    private class HostPortClass{
        final Class<?> clazz;
        final HostAndPort hostAndPort;
        HostPortClass(HostAndPort hostAndPort,Class<?> clazz){
            checkNotNull(hostAndPort, "hostAndPort is null");
            checkNotNull(clazz, "clazz is null");
            this.clazz = clazz;
            this.hostAndPort = hostAndPort;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            HostPortClass that = (HostPortClass) o;

            if (!hostAndPort.equals(that.hostAndPort)) {
                return false;
            }
            if (!clazz.equals(that.clazz)) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = clazz.hashCode();
            result = 31 * result + hostAndPort.hashCode();
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("HostPortClass");
            sb.append("{host='").append(hostAndPort).append('\'');
            sb.append(", class='").append(clazz.getName()).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    private static final Cache<HostPortClass, Object> clientCache = CacheBuilder.newBuilder().softValues().build();
    private ThriftClientManager clientManager; 
    private ThriftClientConfig thriftClientConfig = new ThriftClientConfig();
    private HostAndPort hostAndPort;
    private NiftyClientConnector<? extends NiftyClientChannel> connector;
    private String clientName = ThriftClientManager.DEFAULT_NAME;
    private ClientFactory() {
    }
    public static final ClientFactory builder(){
        return new ClientFactory();
    }
    public ClientFactory setManager(ThriftClientManager clientManager){
        this.clientManager = clientManager;
        return this;
    }
    public ClientFactory setThriftClientConfig(ThriftClientConfig thriftClientConfig) {
        this.thriftClientConfig = thriftClientConfig;
        return this;
    }
    /**
     * set all timeout arguments
     * @param time
     * @param unit
     * @return
     * @see #setConnectTimeout(Duration)
     * @see #setReceiveTimeout(Duration)
     * @see #setReadTimeout(Duration)
     * @see #setWriteTimeout(Duration)
     */
    public ClientFactory setTimeout(Duration timeout){
        setConnectTimeout(timeout);
        setReceiveTimeout(timeout);
        setReadTimeout(timeout);
        setWriteTimeout(timeout);
        return this;
    }
    public ClientFactory setTimeout(long time,TimeUnit unit){
        return setTimeout(new Duration(time,unit));
    }
    public ClientFactory setConnectTimeout(Duration connectTimeout) {
        thriftClientConfig.setConnectTimeout(connectTimeout);
        return this;
    }
    public ClientFactory setReceiveTimeout(Duration receiveTimeout) {
        thriftClientConfig.setReceiveTimeout(receiveTimeout);
        return this;
    }
    public ClientFactory setReadTimeout(Duration readTimeout) {
        thriftClientConfig.setReadTimeout(readTimeout);
        return this;
    }
    public ClientFactory setWriteTimeout(Duration writeTimeout) {
        thriftClientConfig.setWriteTimeout(writeTimeout);
        return this;
    }
    public ClientFactory setSocksProxy(HostAndPort socksProxy) {
        thriftClientConfig.setSocksProxy(socksProxy);
        return this;
    }
    public ClientFactory setMaxFrameSize(int maxFrameSize) {
        thriftClientConfig.setMaxFrameSize(maxFrameSize);
        return this;
    }
    public ClientFactory setHostAndPort(HostAndPort hostAndPort) {
        this.hostAndPort = hostAndPort;
        return this;
    }
    public ClientFactory setHostAndPort(String host,int port) {
        return setHostAndPort(fromParts(host, port));
    }
    public ClientFactory setHostAndPort(String host) {
        return setHostAndPort(fromString(host));
    }
    public ClientFactory setConnector(NiftyClientConnector<? extends NiftyClientChannel> connector) {
        this.connector = connector;
        return this;
    }
    public ClientFactory setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }
    private HostAndPort getHostAndPort(){
        checkNotNull(this.hostAndPort,"hostAndPort is null");
        return this.hostAndPort;
    }
    private NiftyClientConnector<? extends NiftyClientChannel> getConnector(){
        if(null == this.connector){
            this.connector = new FramedClientConnector(this.getHostAndPort());
        }
        return this.connector;
    }
    private ThriftClientManager getClientManager(){
        if(null == this.clientManager)
            this.clientManager = Singleton.clientManager;
        return this.clientManager;
    }

    private <T>T getThriftClient(Class<T> interfaceClass) throws InterruptedException, ExecutionException{
        return new ThriftClient<T>(
                getClientManager(),
                interfaceClass,
                this.thriftClientConfig,
                this.clientName).open(getConnector()).get();
    }
    @SuppressWarnings("unchecked")
    protected<I,O> O  _build(Class<I> interfaceClass,Class<O> destClass){
        try {
            HostPortClass key = new HostPortClass(getHostAndPort(),interfaceClass);
            ConcurrentMap<HostPortClass, Object> map = clientCache.asMap();
            if(!map.containsKey(key)){
                map.putIfAbsent(
                        key, 
                        destClass.getConstructor(interfaceClass).newInstance(getThriftClient(interfaceClass)));
            }
            return (O) map.get(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /** get asynchronous instance of IFaceLog */ 
    public IFaceLogClientAsync  buildAsync(){
        return _build(
                net.gdface.facelog.client.thrift.IFaceLog.Async.class,
                IFaceLogClientAsync.class);
    }
    /** get synchronized instance of IFaceLog */ 
    public IFaceLogClient build(){
        return _build(
                net.gdface.facelog.client.thrift.IFaceLog.class,
                IFaceLogClient.class);
    }
}

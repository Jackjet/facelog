package net.gdface.facelog.decorator;
import net.gdface.thrift.ThriftDecorator;
import net.gdface.thrift.exception.BaseServiceException;

import java.io.PrintStream;
import java.io.PrintWriter;
import com.facebook.swift.codec.ThriftStruct;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftField.Requiredness;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * decorator pattern 装饰者模式代理{@link net.gdface.facelog.ServiceSecurityException}<br>
 * 代理对象必须有默认构造方法,String参数构造方法可选,必须是普通类型,不可以有@ThriftStruct注释<br>
 * 转发所有{@link net.gdface.facelog.ServiceSecurityException}get/set方法到{@link #delegate()}指定的实例,<br>
 * 计算机生成代码(generated by automated tools ThriftServiceDecoratorGenerator @author guyadong)<br>
 * @author guyadong
 *
 */
@ThriftStruct
public final class ServiceSecurityException extends BaseServiceException 
    implements ThriftDecorator<net.gdface.facelog.ServiceSecurityException> {
    private static final long serialVersionUID = 1L;
    private final net.gdface.facelog.ServiceSecurityException delegate;

    public ServiceSecurityException(){
        this(new net.gdface.facelog.ServiceSecurityException());
    }
    public ServiceSecurityException(String message){
        this(new net.gdface.facelog.ServiceSecurityException(message));
    }
    public ServiceSecurityException(net.gdface.facelog.ServiceSecurityException delegate) {
        super(checkNotNull(delegate,"delegate is null").getMessage(),delegate.getCause());
        // 检查被装饰类是否有@ThriftStruct注释
        if(delegate.getClass().isAnnotationPresent(ThriftStruct.class)){
            throw new IllegalArgumentException(
                String.format("NOT ALLOW %s have @ThriftStruct annotation",delegate.getClass().getName()));
        }
        this.delegate = delegate;
    }
    /**
     * 返回被装饰的{@link net.gdface.facelog.ServiceSecurityException}实例
     * @return
     */
    @Override
    public net.gdface.facelog.ServiceSecurityException delegate() {
        return delegate;
    }

    @Override
    public void printStackTrace() {
        delegate().printStackTrace();
    }
    @Override
    public void printStackTrace(PrintStream s) {
        delegate().printStackTrace(s);
    }
    @Override
    public void printStackTrace(PrintWriter s) {
        delegate().printStackTrace(s);
    }
    @Override
    public StackTraceElement[] getStackTrace() {
        return delegate().getStackTrace();
    }
    @Override
    public Throwable initCause(Throwable cause) {
        return delegate().initCause(cause);
    }
    @Override
    public int hashCode() {
        return delegate().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return delegate().equals(obj);
    }
    @Override
    public String toString() {
        return delegate().toString();
    }
}
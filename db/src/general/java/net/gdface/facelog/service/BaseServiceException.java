// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: base.service.exception.java.vm
// ______________________________________________________
package net.gdface.facelog.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

/**
 * service exception abstract class<br>
 * @author guyadong
 *
 */
@ThriftStruct
public abstract class BaseServiceException extends Exception{
    private static final long serialVersionUID = 1L;
    private String message;
    private String causeClass;
    private String serviceStackTraceMessage;
    private String causeField;

    public BaseServiceException() {
        init();
    }
    public BaseServiceException(String message) {
        super(message);
        init();
    }
    public BaseServiceException(String message, Throwable cause) {
        super(message,stripRuntimeShell(cause));
        init();
    }
    public BaseServiceException(Throwable cause) {
        super(stripRuntimeShell(cause));
        init();
    }
    private void init(){
        this.message = getMessage();
        this.causeClass = null == getCause()? null : getCause().getClass().getName();
        this.causeField = null == getCause()? null : getCause().toString();
        fillStackTraceMessage(getCause());
    }
    /**
     * return cause wrapped by {@link RuntimeException}<br>
     * @param e
     * @return
     */
    private static final Throwable stripRuntimeShell(Throwable e){
        if(null != e && null !=e.getCause() && e.getClass() == RuntimeException.class){
            return stripRuntimeShell(e.getCause());
        }
        return e;
    }
    /**
     * save error message to {@link #serviceStackTraceMessage} by calling {@link #printStackTrace(PrintWriter)} 
     * @param cause
     * @see #printStackTrace(PrintWriter)
     */
    private void fillStackTraceMessage(Throwable cause) {
        if (null != cause) {
            StringWriter write = new StringWriter(256);
            PrintWriter pw = new PrintWriter(write);
            cause.printStackTrace(pw);
            serviceStackTraceMessage = write.toString();
        }
    }

    /** return error message from service */
    @Override
    @ThriftField(1)
    public String getMessage() {
        return message;
    }
    @ThriftField
    public void setMessage(String message) {
        this.message = message;
    }
    /** return cause exception class name */
    @ThriftField(2)
    public String getCauseClass() {
        return causeClass;
    }
    @ThriftField
    public void setCauseClass(String causeClass) {
        this.causeClass = causeClass;
    }
    /** return stack trace message from service */
    @ThriftField(3)
    public String getServiceStackTraceMessage() {
        return serviceStackTraceMessage;
    }
    @ThriftField
    public void setServiceStackTraceMessage(String serviceStackTraceMessage) {
        this.serviceStackTraceMessage = serviceStackTraceMessage;
    }
    /** return field value of cause {@link Throwable#toString()},as JSON string */
    @ThriftField(4)
    public String getCauseField() {
        return causeField;
    }
    @ThriftField
    public void setCauseField(String causeField) {
        this.causeField = causeField;
    }
}

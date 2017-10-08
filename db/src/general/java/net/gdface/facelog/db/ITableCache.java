// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db;

import java.util.concurrent.TimeUnit;
import java.util.Collection;
/**
 * 数据库对象缓存接口
 * @param <K> 主键类型(Primary or Unique)
 * @param <B> 数据库记录对象类型(Java Bean)
 * @author guyadong
 */
public interface ITableCache<K, B extends BaseBean<B>> {
    public static final long DEFAULT_CACHE_MAXIMUMSIZE = 10000;
    public static final long DEFAULT_DURATION = 10;
    public static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;
    /**
     * 加载主键(key)指定的记录,如果缓存中没有则从数据库中查询
     * @param key
     * @return
     */
    public B getBean(K key);
    /**
     * 向cache中更新数据
     * @param bean
     * @return
     */
    public void put(B bean);
    /**
     * @param beans
     * @return always beans 
     * @see #put(B) 
     */
    public Collection<B> put(Collection<B> beans);
    /**
     * 向cache中增加数据
     * @param bean
     * @return
     */
    public void putIfAbsent(B bean);
    /**
     * @param beans
     * @return always beans 
     * @see #putIfAbsent(B) 
     */
    public Collection<B> putIfAbsent(Collection<B> beans);
    /**
     * 更新cache已有数据
     * @param bean
     * @return
     */
    public void replace(B bean);
    /**
     * @param beans
     * @return always beans 
     * @see #replace(B) 
     */
    public Collection<B> replace(Collection<B> beans);
    /** 注册侦听器 */
    public void registerListener();
    /** 注销侦听器 */
    public void unregisterListener();
}
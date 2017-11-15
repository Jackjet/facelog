// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.interface.java.vm
// ______________________________________________________
package net.gdface.facelog.db;
import net.gdface.facelog.db.exception.ObjectRetrievalException;
import net.gdface.facelog.db.exception.RuntimeDaoException;

/**
 * Interface to handle database calls (save, load, count, etc...) for the fl_store table.<br>
 * Remarks: 二进制数据存储表
 * @author guyadong
 */
public interface IStoreManager extends TableManager<StoreBean>
{  
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1
    /**
     * Loads a {@link StoreBean} from the fl_store using primary key fields.
     *
     * @param md5 String - PK# 1
     * @return a unique StoreBean or {@code null} if not found
     */
    public StoreBean loadByPrimaryKey(String md5);

    //1.1
    /**
     * Loads a {@link StoreBean} from the fl_store using primary key fields.
     *
     * @param md5 String - PK# 1
     * @return a unique StoreBean
     * @throws ObjectRetrievalException if not found
     */
    public StoreBean loadByPrimaryKeyChecked(String md5) throws ObjectRetrievalException;
    
    //1.4
    /**
     * Returns true if this fl_store contains row with primary key fields.
     * @param md5 String - PK# 1
     * @see #loadByPrimaryKey($keys)
     * @return
     */
    public boolean existsPrimaryKey(String md5);
    //1.4.1
    /**
     * Check duplicated row by primary keys,if row exists throw exception
     * @param md5 String
     * @return 
     * @throws ObjectRetrievalException
     */
    public String checkDuplicate(String md5)throws ObjectRetrievalException;
    //1.8
    /**
     * Loads {@link StoreBean} from the fl_store using primary key fields.
     *
     * @param keys primary keys array
     * @return list of StoreBean
     */
    public java.util.List<StoreBean> loadByPrimaryKey(String... keys);
    //1.9
    /**
     * Loads {@link StoreBean} from the fl_store using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of StoreBean
     */
    public java.util.List<StoreBean> loadByPrimaryKey(java.util.Collection<String> keys);
    //2
    /**
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param md5 String - PK# 1
     * @return the number of deleted rows
     */
    public int deleteByPrimaryKey(String md5);
    //2.2
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys array
     * @return the number of deleted rows
     */
    public int deleteByPrimaryKey(String... keys);
    //2.3
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys collection
     * @return the number of deleted rows
     */
    public int deleteByPrimaryKey(java.util.Collection<String> keys);
    //2.4
    /**
     * Delete beans.<br>
     *
     * @param beans StoreBean collection wille be deleted
     * @return the number of deleted rows
     */
    public int delete(StoreBean... beans);
    //2.5
    /**
     * Delete beans.<br>
     *
     * @param beans StoreBean collection wille be deleted
     * @return the number of deleted rows
     */
    public int delete(java.util.Collection<StoreBean> beans);
 
 
    //45
    /**
     * return a primary key list from {@link StoreBean} array
     * @param beans
     * @return
     */
    public java.util.List<String> toPrimaryKeyList(StoreBean... beans);
    //46
    /**
     * return a primary key list from {@link StoreBean} collection
     * @param beans
     * @return
     */
    public java.util.List<String> toPrimaryKeyList(java.util.Collection<StoreBean> beans);

}

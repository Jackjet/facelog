// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________



package net.gdface.facelog.db.mysql;

import java.util.List;
import java.util.Collection;
import java.util.concurrent.Callable;

import net.gdface.facelog.db.LogLightBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.TableListener;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.log.FlLogLightManager;
import net.gdface.facelog.dborm.log.FlLogLightBean;
import net.gdface.facelog.dborm.log.FlLogLightListener;

/**
 * Handles database calls (save, load, count, etc...) for the fl_log_light table.
 * @author guyadong
 */
public class LogLightManager 
{

    /* set =QUERY for loadUsingTemplate */
    public static final int SEARCH_EXACT = 0;
    /* set %QUERY% for loadLikeTemplate */
    public static final int SEARCH_LIKE = 1;
    /* set %QUERY for loadLikeTemplate */
    public static final int SEARCH_STARTING_LIKE = 2;
    /* set QUERY% for loadLikeTemplate */
    public static final int SEARCH_ENDING_LIKE = 3;

    /**
     * Identify the id field.
     */
    public static final int ID_ID = 0;

    /**
     * Identify the person_id field.
     */
    public static final int ID_PERSON_ID = 1;

    /**
     * Identify the name field.
     */
    public static final int ID_NAME = 2;

    /**
     * Identify the papers_type field.
     */
    public static final int ID_PAPERS_TYPE = 3;

    /**
     * Identify the papers_num field.
     */
    public static final int ID_PAPERS_NUM = 4;

    /**
     * Identify the verify_time field.
     */
    public static final int ID_VERIFY_TIME = 5;

    /**
     * Tablename.
     */
		public static final String TABLE_NAME="fl_log_light";
    /**
     * Contains all the full fields of the fl_log_light table.
     */
    public static final String[] FULL_FIELD_NAMES =
    {
        "fl_log_light.id"
        ,"fl_log_light.person_id"
        ,"fl_log_light.name"
        ,"fl_log_light.papers_type"
        ,"fl_log_light.papers_num"
        ,"fl_log_light.verify_time"
    };

    /**
     * Contains all the fields of the fl_log_light table.
     */
    public static final String[] FIELD_NAMES =
    {
        "id"
        ,"person_id"
        ,"name"
        ,"papers_type"
        ,"papers_num"
        ,"verify_time"
    };
   /**
     * Contains all the primarykey fields of the fl_log_light table.
     */
    public static final String[] PRIMARYKEY_NAMES =
    {
    };
    /**
     * Field that contains the comma separated fields of the fl_log_light table.
     */
    public static final String ALL_FULL_FIELDS = "fl_log_light.id"
                            + ",fl_log_light.person_id"
                            + ",fl_log_light.name"
                            + ",fl_log_light.papers_type"
                            + ",fl_log_light.papers_num"
                            + ",fl_log_light.verify_time";

    /**
     * Field that contains the comma separated fields of the fl_log_light table.
     */
    public static final String ALL_FIELDS = "id"
                            + ",person_id"
                            + ",name"
                            + ",papers_type"
                            + ",papers_num"
                            + ",verify_time";

    public static interface Action{
          void call(LogLightBean bean);
          LogLightBean getBean();
     }

    /**
    * @return tableName
    */
    public String getTableName() {
        return TABLE_NAME;
    }

    /**
    * @return fieldNames
    */
    public String[] getFieldNames() {
        return FIELD_NAMES;
    }

    /**
    * @return primarykeyNames
    */
    public String[] getPrimarykeyNames() {
        return PRIMARYKEY_NAMES;
    }
    private FlLogLightManager nativeManager = FlLogLightManager.getInstance();
    private IDbConverter dbConverter = new DbConverter();
    private IBeanConverter<LogLightBean,FlLogLightBean> beanConverter;
    private static LogLightManager singleton = new LogLightManager();

    /**
     * Get the LogLightManager singleton.
     *
     * @return LogLightManager
     */
    public static LogLightManager getInstance()
    {
        return singleton;
    }
    
    public FlLogLightManager getNativeManager() {
        return nativeManager;
    }

    public void setNativeManager(FlLogLightManager nativeManager) {
        this.nativeManager = nativeManager;
    }
    
    public IDbConverter getDbConverter() {
        return dbConverter;
    }

    public void setDbConverter(IDbConverter dbConverter) {
        if( null == dbConverter)
            throw new NullPointerException();
        this.dbConverter = dbConverter;
        this.beanConverter = this.dbConverter.getLogLightBeanConverter();
    }
    public LogLightBean loadByPrimaryKey(LogLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
    public boolean existsPrimaryKey(LogLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
    public int deleteByPrimaryKey(LogLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
 

    //@Override
    public <T> T[] getImportedBeans(LogLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    //@Override
    public <T> List<T> getImportedBeansAsList(LogLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    //@Override
    public <T> T[] setImportedBeans(LogLightBean bean,T[] importedBeans,String fkName){
        throw new UnsupportedOperationException();
    }    
    //@Override
    public <T extends Collection<LogLightBean>> T setImportedBeans(LogLightBean bean,T importedBeans,String fkName){
        throw new UnsupportedOperationException();
    }
 


 
    //@Override
    public <T> T getReferencedBean(LogLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    //@Override
    public <T> T setReferencedBean(LogLightBean bean,T beanToSet,String fkName){
        throw new UnsupportedOperationException();
    }
     

    //////////////////////////////////////
    // LOAD ALL
    //////////////////////////////////////

    /**
     * Loads all the rows from fl_log_light.
     *
     * @return an array of FlLogLightManager bean
     */
    //5
    public LogLightBean[] loadAll()
    {
        try{
            return this.beanConverter.fromNative(this.nativeManager.loadUsingTemplate(null));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * Loads each row from fl_log_light and dealt with action.
     * @param action  Action object for do something(not null)
     * @return the count dealt by action
     */
    //5-1
    public int loadAll(Action action)
    {
        return this.loadUsingTemplate(null,action);
    }
    /**
     * Loads all the rows from fl_log_light.
     *
     * @return a list of LogLightBean bean
     */
    //5-2
    public List<LogLightBean> loadAllAsList()
    {
        return this.loadUsingTemplateAsList(null);
    }


    /**
     * Loads the given number of rows from fl_log_light, given the start row.
     *
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return an array of FlLogLightManager bean
     */
    //6
    public LogLightBean[] loadAll(int startRow, int numRows)
    {
        return this.loadUsingTemplate(null, startRow, numRows);
    }
    /**
     *  Loads the given number of rows from fl_log_light, given the start row and dealt with action.
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param action  Action object for do something(not null)
     * @return the count dealt by action
     */
    //6-1
    public int loadAll(int startRow, int numRows,Action action)
    {
        return this.loadUsingTemplate(null, startRow, numRows,action);
    }
    /**
     * Loads the given number of rows from fl_log_light, given the start row.
     *
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return a list of FlLogLightManager bean
     */
    //6-2
    public List<LogLightBean> loadAllAsList(int startRow, int numRows)
    {
        return this.loadUsingTemplateAsList(null, startRow, numRows);
    }

    //////////////////////////////////////
    // SQL 'WHERE' METHOD
    //////////////////////////////////////
    /**
     * Retrieves an array of LogLightBean given a sql 'where' clause.
     *
     * @param where the sql 'where' clause
     * @return the resulting LogLightBean table
     */
    //7
    public LogLightBean[] loadByWhere(String where)
    {
        return this.loadByWhere(where, (int[])null);
    }
    /**
     * Retrieves a list of LogLightBean given a sql 'where' clause.
     *
     * @param where the sql 'where' clause
     * @return the resulting LogLightBean table
     */
    //7
    public List<LogLightBean> loadByWhereAsList(String where)
    {
        return this.loadByWhereAsList(where, null);
    }
    /**
     * Retrieves each row of LogLightBean given a sql 'where' clause and dealt with action.
     * @param where the sql 'where' clause
     * @param action  Action object for do something(not null)
     * @return the count dealt by action
     */
    //7-1
    public int loadByWhere(String where,Action action)
    {
        return this.loadByWhere(where, null,action);
    }
    /**
     * Retrieves an array of LogLightBean given a sql where clause, and a list of fields.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'WHERE' clause
     * @param fieldList array of field's ID
     * @return the resulting LogLightBean table
     */
    //8
    public LogLightBean[] loadByWhere(String where, int[] fieldList)
    {
        return this.loadByWhere(where, fieldList, 1, -1);
    }


    /**
     * Retrieves a list of LogLightBean given a sql where clause, and a list of fields.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'WHERE' clause
     * @param fieldList array of field's ID
     * @return the resulting LogLightBean table
     */
    //8
    public List<LogLightBean> loadByWhereAsList(String where, int[] fieldList)
    {
        return this.loadByWhereAsList(where, fieldList, 1, -1);
    }
    /**
     * Retrieves each row of LogLightBean given a sql where clause, and a list of fields,
     * and dealt with action.
     * It is up to you to pass the 'WHERE' in your where clausis.
     * @param where the sql 'WHERE' clause
     * @param fieldList array of field's ID
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //8-1
    public int loadByWhere(String where, int[] fieldList,Action action)
    {
        return this.loadByWhere(where, fieldList, 1, -1,action);
    }

    /**
     * Retrieves an array of LogLightBean given a sql where clause and a list of fields, and startRow and numRows.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param fieldList table of the field's associated constants
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the resulting LogLightBean table
     */
    //9
    public LogLightBean[] loadByWhere(String where, int[] fieldList, int startRow, int numRows)
    {
        return (LogLightBean[]) this.loadByWhereAsList(where, fieldList, startRow, numRows).toArray(new LogLightBean[0]);
    }
    /**
     * Retrieves each row of  LogLightBean given a sql where clause and a list of fields, and startRow and numRows,
     * and dealt wity action.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param fieldList table of the field's associated constants
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //9-1
    public int loadByWhere(String where, int[] fieldList, int startRow, int numRows,Action action)
    {
        return this.loadByWhereForAction(where, fieldList, startRow, numRows,action);
    }

    /**
     * Retrieves a list of LogLightBean given a sql where clause and a list of fields, and startRow and numRows.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param fieldList table of the field's associated constants
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the resulting LogLightBean table
     */
    //9-2
    public List<LogLightBean> loadByWhereAsList(String where, int[] fieldList, int startRow, int numRows)
    {
        try{
            return this.beanConverter.fromNative(this.nativeManager.loadByWhereAsList(where,fieldList,startRow,numRows));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves each row of LogLightBean given a sql where clause and a list of fields, and startRow and numRows,
     * and dealt wity action
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param fieldList table of the field's associated constants
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //9-3
    public int loadByWhereForAction(String where, int[] fieldList, int startRow, int numRows,Action action)
    {
        try{
            return this.nativeManager.loadByWhereForAction(where,fieldList,startRow,numRows,this.toNative(action));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes all rows from fl_log_light table.
     * @return the number of deleted rows.
     */
    //10
    public int deleteAll()
    {
        return this.deleteByWhere("");
    }

    /**
     * Deletes rows from the fl_log_light table using a 'where' clause.
     * It is up to you to pass the 'WHERE' in your where clausis.
     * <br>Attention, if 'WHERE' is omitted it will delete all records.
     *
     * @param where the sql 'where' clause
     * @return the number of deleted rows
     */
    //11
    public int deleteByWhere(String where)
    {
        try{
            return this.nativeManager.deleteByWhere(where);
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }

    //_____________________________________________________________________
    //
    // SAVE
    //_____________________________________________________________________
    /**
     * Saves the LogLightBean bean into the database.
     *
     * @param bean the LogLightBean bean to be saved
     * @return the inserted or updated bean
     */
    //12
    public LogLightBean save(LogLightBean bean)
    {
        if (bean.isNew()) {
            return this.insert(bean);
        } else {
            return this.update(bean);
        }
    }

    /**
     * Insert the LogLightBean bean into the database.
     *
     * @param bean the LogLightBean bean to be saved
     * @return the inserted bean
     */
    //13
    public LogLightBean insert(LogLightBean bean)
    {
        try{
            return this.beanConverter.fromNative(this.nativeManager.insert((FlLogLightBean)this.beanConverter.toNative(bean)));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update the LogLightBean bean record in the database according to the changes.
     *
     * @param bean the LogLightBean bean to be updated
     * @return the updated bean
     */
    //14
    public LogLightBean update(LogLightBean bean)
    {
        try{
            return this.beanConverter.fromNative(this.nativeManager.update((FlLogLightBean)this.beanConverter.toNative(bean)));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves an array of LogLightBean beans into the database.
     *
     * @param beans the LogLightBean bean table to be saved
     * @return the saved LogLightBean array.
     */
    //15
    public LogLightBean[] save(LogLightBean[] beans)
    {
        for (LogLightBean bean : beans) 
        {
            this.save(bean);
        }
        return beans;
    }

    /**
     * Saves a list of LogLightBean beans into the database.
     *
     * @param beans the LogLightBean bean table to be saved
     * @return the saved LogLightBean array.
     */
    //15-2
    public <T extends Collection<LogLightBean>>T save(T beans)
    {
        for (LogLightBean bean : beans) 
        {
            this.save(bean);
        }
        return beans;
    }
    /**
     * Saves an array of LogLightBean beans as transaction into the database.
     *
     * @param beans the LogLightBean bean table to be saved
     * @return the saved LogLightBean array.
     * @see #save(LogLightBean[])
     */
    //15-3
    public LogLightBean[] saveAsTransaction(final LogLightBean[] beans) {
        return this.runAsTransaction(new Callable<LogLightBean[]>(){
            @Override
            public LogLightBean[] call() throws Exception {
                return save(beans);
            }});
    }
    /**
     * Saves a list of LogLightBean beans as transaction into the database.
     *
     * @param beans the LogLightBean bean table to be saved
     * @return the saved LogLightBean array.
     * @see #save(List)
     */
    //15-4
    public <T extends Collection<LogLightBean>> T saveAsTransaction(final T beans){
        return this.runAsTransaction(new Callable<T>(){
            @Override
            public T call() throws Exception {
                return save(beans);
            }});
    }
    /**
     * Insert an array of LogLightBean beans into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     */
    //16
    public LogLightBean[] insert(LogLightBean[] beans)
    {
        return this.save(beans);
    }

    /**
     * Insert a list of LogLightBean beans into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     */
    //16-2
    public <T extends Collection<LogLightBean>> T insert(T beans)
    {
        return this.save(beans);
    }
    
    /**
     * Insert an array of LogLightBean beans as transaction into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     * @see #saveAsTransaction(LogLightBean[])
     */
    //16-3
    public LogLightBean[] insertAsTransaction(LogLightBean[] beans)
    {
        return this.saveAsTransaction(beans);
    }

    /**
     * Insert a list of LogLightBean beans as transaction into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     * @see #saveAsTransaction(List)
     */
    //16-4
    public <T extends Collection<LogLightBean>> T insertAsTransaction(T beans)
    {
        return this.saveAsTransaction(beans);
    }


    /**
     * Updates an array of LogLightBean beans into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     */
    //17
    public LogLightBean[] update(LogLightBean[] beans)
    {
        return this.save(beans);
    }

    /**
     * Updates a list of LogLightBean beans into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     */
    //17-2
    public <T extends Collection<LogLightBean>> T update(T beans)
    {
        return this.save(beans);
    }
    
    /**
     * Updates an array of LogLightBean beans as transaction into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     * @see #saveAsTransaction(LogLightBean[])
     */
    //17-3
    public LogLightBean[] updateAsTransaction(LogLightBean[] beans)
    {
        return this.saveAsTransaction(beans);
    }

    /**
     * Updates a list of LogLightBean beans as transaction into the database.
     *
     * @param beans the LogLightBean bean table to be inserted
     * @return the saved LogLightBean array.
     * @see #saveAsTransaction(List)
     */
    //17-4
    public <T extends Collection<LogLightBean>> T updateAsTransaction(T beans)
    {
        return this.saveAsTransaction(beans);
    }
    
    //_____________________________________________________________________
    //
    // USING TEMPLATE
    //_____________________________________________________________________
    /**
     * Loads a unique LogLightBean bean from a template one giving a c
     *
     * @param bean the LogLightBean bean to look for
     * @return the bean matching the template
     */
    //18
    public LogLightBean loadUniqueUsingTemplate(LogLightBean bean)
    {
        try{
            return this.beanConverter.fromNative(this.nativeManager.loadUniqueUsingTemplate((FlLogLightBean)this.beanConverter.toNative(bean)));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
     }

    /**
     * Loads an array of LogLightBean from a template one.
     *
     * @param bean the LogLightBean template to look for
     * @return all the LogLightBean matching the template
     */
    //19
    public LogLightBean[] loadUsingTemplate(LogLightBean bean)
    {
        return this.loadUsingTemplate(bean, 1, -1);
    }
    /**
     * Loads each row from a template one and dealt with action.
     *
     * @param bean the LogLightBean template to look for
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //19-1
    public int loadUsingTemplate(LogLightBean bean,Action action)
    {
        return this.loadUsingTemplate(bean, 1, -1,action);
    }

    /**
     * Loads a list of LogLightBean from a template one.
     *
     * @param bean the LogLightBean template to look for
     * @return all the LogLightBean matching the template
     */
    //19-2
    public List<LogLightBean> loadUsingTemplateAsList(LogLightBean bean)
    {
        return this.loadUsingTemplateAsList(bean, 1, -1);
    }

    /**
     * Loads an array of LogLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the LogLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return all the LogLightBean matching the template
     */
    //20
    public LogLightBean[] loadUsingTemplate(LogLightBean bean, int startRow, int numRows)
    {
        return this.loadUsingTemplate(bean, startRow, numRows, SEARCH_EXACT);
    }
    /**
     * Loads each row from a template one, given the start row and number of rows and dealt with action.
     *
     * @param bean the LogLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //20-1
    public int loadUsingTemplate(LogLightBean bean, int startRow, int numRows,Action action)
    {
        return this.loadUsingTemplate(bean, null, startRow, numRows,SEARCH_EXACT, action);
    }
    /**
     * Loads a list of LogLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the LogLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return all the LogLightBean matching the template
     */
    //20-2
    public List<LogLightBean> loadUsingTemplateAsList(LogLightBean bean, int startRow, int numRows)
    {
        return this.loadUsingTemplateAsList(bean, startRow, numRows, SEARCH_EXACT);
    }

    /**
     * Loads an array of LogLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the LogLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @return all the LogLightBean matching the template
     */
    //20-3
    public LogLightBean[] loadUsingTemplate(LogLightBean bean, int startRow, int numRows, int searchType)
    {
    	return (LogLightBean[])this.loadUsingTemplateAsList(bean, startRow, numRows, searchType).toArray(new LogLightBean[0]);
    }

    /**
     * Loads a list of LogLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the LogLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @return all the LogLightBean matching the template
     */
    //20-4
    public List<LogLightBean> loadUsingTemplateAsList(LogLightBean beanBase, int startRow, int numRows, int searchType)
    {
        try{
            return this.beanConverter.fromNative(this.nativeManager.loadUsingTemplateAsList((FlLogLightBean)this.beanConverter.toNative(beanBase),startRow,numRows,searchType));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }        
    }
    /**
     * Loads each row from a template one, given the start row and number of rows and dealt with action.
     *
     * @param bean the LogLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //20-5
    public int loadUsingTemplate(LogLightBean beanBase, int[] fieldList, int startRow, int numRows,int searchType, Action action)
    {
        try {
            return this.nativeManager.loadUsingTemplate(this.beanConverter.toNative(beanBase),fieldList,startRow,numRows,searchType,this.toNative(action));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * Deletes rows using a LogLightBean template.
     *
     * @param bean the LogLightBean object(s) to be deleted
     * @return the number of deleted objects
     */
    //21
    public int deleteUsingTemplate(LogLightBean beanBase)
    {
        try{
            return this.nativeManager.deleteUsingTemplate((FlLogLightBean)this.beanConverter.toNative(beanBase));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }



    //_____________________________________________________________________
    //
    // COUNT
    //_____________________________________________________________________

    /**
     * Retrieves the number of rows of the table fl_log_light.
     *
     * @return the number of rows returned
     */
    //24
    public int countAll() 
    {
        return this.countWhere("");
    }

    /**
     * Retrieves the number of rows of the table fl_log_light with a 'where' clause.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the restriction clause
     * @return the number of rows returned
     */
    //25
    public int countWhere(String where)
    {
        try{
            return this.nativeManager.countWhere(where);
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * count the number of elements of a specific LogLightBean bean
     *
     * @param bean the LogLightBean bean to look for ant count
     * @return the number of rows returned
     */
    //27
    public int countUsingTemplate(LogLightBean bean)
    {
        return this.countUsingTemplate(bean, -1, -1);
    }

    /**
     * count the number of elements of a specific LogLightBean bean , given the start row and number of rows.
     *
     * @param bean the LogLightBean template to look for and count
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the number of rows returned
     */
    //20
    public int countUsingTemplate(LogLightBean bean, int startRow, int numRows)
    {
        return this.countUsingTemplate(bean, startRow, numRows, SEARCH_EXACT);
    }

    /**
     * count the number of elements of a specific LogLightBean bean given the start row and number of rows and the search type
     *
     * @param bean the LogLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @return the number of rows returned
     */
    //20
    public int countUsingTemplate(LogLightBean beanBase, int startRow, int numRows, int searchType)
    {
        try{
            return this.nativeManager.countUsingTemplate(this.beanConverter.toNative(beanBase),startRow,numRows,searchType);
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }


    //_____________________________________________________________________
    //
    // LISTENER
    //_____________________________________________________________________

    /**
     * Registers a unique LogLightListener listener.
     */
    //35
    public void registerListener(TableListener listener)
    {
        this.nativeManager.registerListener(this.toNative((LogLightListener)listener));
    }

    private FlLogLightListener toNative(final LogLightListener listener) {
		return null == listener ?null:new FlLogLightListener (){

			@Override
			public void beforeInsert(FlLogLightBean bean) throws DAOException {
				listener.beforeInsert(LogLightManager.this.beanConverter.fromNative(bean));				
			}

			@Override
			public void afterInsert(FlLogLightBean bean) throws DAOException {
				listener.afterInsert(LogLightManager.this.beanConverter.fromNative(bean));
				
			}

			@Override
			public void beforeUpdate(FlLogLightBean bean) throws DAOException {
				listener.beforeUpdate(LogLightManager.this.beanConverter.fromNative(bean));
				
			}

			@Override
			public void afterUpdate(FlLogLightBean bean) throws DAOException {
				listener.afterUpdate(LogLightManager.this.beanConverter.fromNative(bean));
			}

			@Override
			public void beforeDelete(FlLogLightBean bean) throws DAOException {
				listener.beforeDelete(LogLightManager.this.beanConverter.fromNative(bean));
			}

			@Override
			public void afterDelete(FlLogLightBean bean) throws DAOException {
				listener.afterDelete(LogLightManager.this.beanConverter.fromNative(bean));
			}};
	}

    //_____________________________________________________________________
    //
    // UTILS
    //_____________________________________________________________________


    /**
     * return true if @{code column}(case insensitive)is primary key,otherwise return false <br>
     * return false if @{code column} is null or empty 
     * @param column
     * @return
     * @author guyadong
     */
    //43
    public static boolean isPrimaryKey(String column){
        for(String c:PRIMARYKEY_NAMES)if(c.equalsIgnoreCase(column))return true;
        return false;
    }
    
    /**
     * Load all the elements using a SQL statement specifying a list of fields to be retrieved.
     * @param sql the SQL statement for retrieving
     * @param argList the arguments to use fill given prepared statement,may be null
     * @param fieldList table of the field's associated constants
     * @return an array of LogLightBean
     */
    public LogLightBean[] loadBySql(String sql, Object[] argList, int[] fieldList) {
        return loadBySqlAsList(sql, argList, fieldList).toArray(new LogLightBean[0]);
    }
    /**
     * Load all elements using a SQL statement specifying a list of fields to be retrieved.
     * @param sql the SQL statement for retrieving
     * @param argList the arguments to use fill given prepared statement,may be null
     * @param fieldList table of the field's associated constants
     * @return an list of LogLightBean
     */
    public List<LogLightBean> loadBySqlAsList(String sql, Object[] argList, int[] fieldList){
        try{
            return this.beanConverter.fromNative(this.nativeManager.loadBySqlAsList(sql,argList,fieldList));
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }

    
    //@Override
    public <T>T runAsTransaction(Callable<T> fun) {
        try{
            return this.nativeManager.runAsTransaction(fun);
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    //@Override
    public void runAsTransaction(final Runnable fun){
        try{
            this.nativeManager.runAsTransaction(fun);
        }
        catch(DAOException e)
        {
            throw new RuntimeException(e);
        }
    }
    private FlLogLightManager.Action toNative(final Action action){
        return new FlLogLightManager.Action(){

            @Override
            public void call(FlLogLightBean bean) {
                action.call(LogLightManager.this.beanConverter.fromNative(bean));
            }

            @Override
            public FlLogLightBean getBean() {
                return (FlLogLightBean) LogLightManager.this.beanConverter.toNative(action.getBean());
            }};
    }
}

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
import net.gdface.facelog.db.BaseBean;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.LogLightListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.log.FlLogLightManager;
import net.gdface.facelog.dborm.log.FlLogLightBean;
import net.gdface.facelog.dborm.log.FlLogLightListener;
/**
 * Handles database calls (save, load, count, etc...) for the fl_log_light table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.
 * @author guyadong
 */
public class LogLightManager extends TableManager.Adapter<LogLightBean>
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
    private IDbConverter dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<LogLightBean,FlLogLightBean> beanConverter = dbConverter.getLogLightBeanConverter();
    private static LogLightManager singleton = new LogLightManager();

    /**
     * Get the {@link LogLightManager} singleton.
     *
     * @return {@link LogLightManager}
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

    /**
     * set  {@link IDbConverter} as converter used by manager.<br>
     * throw {@link NullPointerException} if {@code dbConverter} is null
     * @param dbConverter
     */
    public synchronized void setDbConverter(IDbConverter dbConverter) {
        if( null == dbConverter)
            throw new NullPointerException();
        this.dbConverter = dbConverter;
        this.beanConverter = this.dbConverter.getLogLightBeanConverter();
    }
    @Override
    public LogLightBean loadByPrimaryKey(LogLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean existsPrimaryKey(LogLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int deleteByPrimaryKey(LogLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
 

    @Override
    public <T extends BaseBean> T[] getImportedBeans(LogLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    @Override
    public <T extends BaseBean> List<T> getImportedBeansAsList(LogLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    @Override
    public <T extends BaseBean> T[] setImportedBeans(LogLightBean bean,T[] importedBeans,String fkName){
        throw new UnsupportedOperationException();
    }    
    @Override
    public <T extends BaseBean,C extends Collection<T>> C setImportedBeans(LogLightBean bean,C importedBeans,String fkName){
        throw new UnsupportedOperationException();
    }
 


 
    @Override
    public <T extends BaseBean> T getReferencedBean(LogLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    @Override
    public <T extends BaseBean> T setReferencedBean(LogLightBean bean,T beanToSet,String fkName){
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
    @Override
    public LogLightBean[] loadAll()
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUsingTemplate(null));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    /**
     * Loads each row from fl_log_light and dealt with action.
     * @param action  Action object for do something(not null)
     * @return the count dealt by action
     */
    //5-1
    @Override
    public int loadAll(Action<LogLightBean> action)
    {
        return this.loadUsingTemplate(null,action);
    }
    /**
     * Loads all the rows from fl_log_light.
     *
     * @return a list of LogLightBean bean
     */
    //5-2
    @Override
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
    @Override
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
    @Override
    public int loadAll(int startRow, int numRows,Action<LogLightBean> action)
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public int loadByWhere(String where,Action<LogLightBean> action)
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
    @Override
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
    @Override
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
    @Override
    public int loadByWhere(String where, int[] fieldList,Action<LogLightBean> action)
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
    @Override
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
    @Override
    public int loadByWhere(String where, int[] fieldList, int startRow, int numRows,Action<LogLightBean> action)
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
    @Override
    public List<LogLightBean> loadByWhereAsList(String where, int[] fieldList, int startRow, int numRows)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByWhereAsList(where,fieldList,startRow,numRows));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
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
    @Override
    public int loadByWhereForAction(String where, int[] fieldList, int startRow, int numRows,Action<LogLightBean> action)
    {
        try{
            return this.nativeManager.loadByWhereForAction(where,fieldList,startRow,numRows,this.toNative(action));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
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
    @Override
    public int deleteByWhere(String where)
    {
        try{
            return this.nativeManager.deleteByWhere(where);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //_____________________________________________________________________
    //
    // SAVE
    //_____________________________________________________________________
    /**
     * Saves the {@link LogLightBean} bean into the database.
     *
     * @param bean the {@link LogLightBean} bean to be saved
     * @return the inserted or updated bean,or null if bean is null
     */
    //12
    @Override
    public LogLightBean save(LogLightBean bean)
    {
        if(null == bean)return null;
        if (bean.isNew()) {
            return this.insert(bean);
        } else {
            return this.update(bean);
        }
    }

    /**
     * Insert the {@link LogLightBean} bean into the database.
     *
     * @param bean the {@link LogLightBean} bean to be saved
     * @return the inserted bean or null if bean is null
     */
    //13
    @Override
    public LogLightBean insert(LogLightBean bean)
    {
        try{
            return this.beanConverter.fromRight(bean,this.nativeManager.insert(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * Update the {@link LogLightBean} bean record in the database according to the changes.
     *
     * @param bean the {@link LogLightBean} bean to be updated
     * @return the updated bean or null if bean is null
     */
    //14
    @Override
    public LogLightBean update(LogLightBean bean)
    {
        try{
            return this.beanConverter.fromRight(bean,this.nativeManager.update(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * Saves an array of {@link LogLightBean} bean into the database.
     *
     * @param beans the {@link LogLightBean} bean table to be saved
     * @return the saved {@link LogLightBean} beans.
     */
    //15
    public LogLightBean[] save(LogLightBean[] beans)
    {
        if(null !=beans){
            for (LogLightBean bean : beans) 
            {
                this.save(bean);
            }
        }
        return beans;
    }

    /**
     * Saves a collection of {@link LogLightBean} bean into the database.
     *
     * @param beans the {@link LogLightBean} bean table to be saved
     * @return the saved {@link LogLightBean} beans.
     */
    //15-2
    @Override
    public <C extends Collection<LogLightBean>> C save(C beans)
    {
        if(null != beans){
            for (LogLightBean bean : beans) 
            {
                this.save(bean);
            }
        }
        return beans;
    }
    /**
     * Saves an array of {@link LogLightBean} bean into the database as transaction.
     *
     * @param beans the {@link LogLightBean} bean table to be saved
     * @return the saved {@link LogLightBean} beans.
     * @see #save(LogLightBean[])
     */
    //15-3
    @Override
    public LogLightBean[] saveAsTransaction(final LogLightBean[] beans) {
        return this.runAsTransaction(new Callable<LogLightBean[]>(){
            @Override
            public LogLightBean[] call() throws Exception {
                return save(beans);
            }});
    }
    /**
     * Saves a collection of {@link LogLightBean} bean into the database as transaction.
     *
     * @param beans the {@link LogLightBean} bean table to be saved
     * @return the saved {@link LogLightBean} beans.
     * @see #save(List)
     */
    //15-4
    @Override
    public <C extends Collection<LogLightBean>> C saveAsTransaction(final C beans){
        return this.runAsTransaction(new Callable<C>(){
            @Override
            public C call() throws Exception {
                return save(beans);
            }});
    }
    /**
     * Insert an array of {@link LogLightBean} bean into the database.
     *
     * @param beans the {@link LogLightBean} bean table to be inserted
     * @return the saved {@link LogLightBean} beans.
     */
    //16
    @Override
    public LogLightBean[] insert(LogLightBean[] beans)
    {
        return this.save(beans);
    }

    /**
     * Insert a collection of {@link LogLightBean} bean into the database.
     *
     * @param beans the {@link LogLightBean} bean table to be inserted
     * @return the saved {@link LogLightBean} beans.
     */
    //16-2
    @Override
    public <C extends Collection<LogLightBean>> C insert(C beans)
    {
        return this.save(beans);
    }
    
    /**
     * Insert an array of {@link LogLightBean} bean into the database as transaction.
     *
     * @param beans the {@link LogLightBean} bean table to be inserted
     * @return the saved {@link LogLightBean} beans.
     * @see #saveAsTransaction(LogLightBean[])
     */
    //16-3
    @Override
    public LogLightBean[] insertAsTransaction(LogLightBean[] beans)
    {
        return this.saveAsTransaction(beans);
    }

    /**
     * Insert a collection of {@link LogLightBean} bean as transaction into the database.
     *
     * @param beans the {@link LogLightBean} bean table to be inserted
     * @return the saved {@link LogLightBean} beans.
     * @see #saveAsTransaction(List)
     */
    //16-4
    @Override
    public <C extends Collection<LogLightBean>> C insertAsTransaction(C beans)
    {
        return this.saveAsTransaction(beans);
    }


    /**
     * Update an array of {@link LogLightBean} bean into the database.
     *
     * @param beans the {@link LogLightBean} bean table to be inserted
     * @return the saved {@link LogLightBean} beans.
     */
    //17
    @Override
    public LogLightBean[] update(LogLightBean[] beans)
    {
        return this.save(beans);
    }

    /**
     * Update a collection of {@link LogLightBean} bean into the database.
     *
     * @param beans the {@link LogLightBean} bean table to be inserted
     * @return the saved {@link LogLightBean} beans.
     */
    //17-2
    @Override
    public <C extends Collection<LogLightBean>> C update(C beans)
    {
        return this.save(beans);
    }
    
    /**
     * Update an array of {@link LogLightBean} bean into the database as transaction.
     *
     * @param beans the {@link LogLightBean} beans table to be inserted
     * @return the saved {@link LogLightBean} beans.
     * @see #saveAsTransaction(LogLightBean[])
     */
    //17-3
    @Override
    public LogLightBean[] updateAsTransaction(LogLightBean[] beans)
    {
        return this.saveAsTransaction(beans);
    }

    /**
     * Update a collection of {@link LogLightBean} bean into the database as transaction.
     *
     * @param beans the {@link LogLightBean} bean table to be inserted
     * @return the saved {@link LogLightBean} beans.
     * @see #saveAsTransaction(List)
     */
    //17-4
    @Override
    public <C extends Collection<LogLightBean>> C updateAsTransaction(C beans)
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
    @Override
    public LogLightBean loadUniqueUsingTemplate(LogLightBean bean)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUniqueUsingTemplate(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
     }

    /**
     * Loads an array of LogLightBean from a template one.
     *
     * @param bean the LogLightBean template to look for
     * @return all the LogLightBean matching the template
     */
    //19
    @Override
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
    @Override
    public int loadUsingTemplate(LogLightBean bean,Action<LogLightBean> action)
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
    @Override
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
    @Override
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
    @Override
    public int loadUsingTemplate(LogLightBean bean, int startRow, int numRows,Action<LogLightBean> action)
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
    @Override
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
    @Override
    public LogLightBean[] loadUsingTemplate(LogLightBean bean, int startRow, int numRows, int searchType)
    {
        return this.loadUsingTemplateAsList(bean, startRow, numRows, searchType).toArray(new LogLightBean[0]);
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
    @Override
    public List<LogLightBean> loadUsingTemplateAsList(LogLightBean bean, int startRow, int numRows, int searchType)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUsingTemplateAsList(this.beanConverter.toRight(bean),startRow,numRows,searchType));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
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
    @Override
    public int loadUsingTemplate(LogLightBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<LogLightBean> action)
    {
        try {
            return this.nativeManager.loadUsingTemplate(this.beanConverter.toRight(bean),fieldList,startRow,numRows,searchType,this.toNative(action));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    /**
     * Deletes rows using a LogLightBean template.
     *
     * @param bean the LogLightBean object(s) to be deleted
     * @return the number of deleted objects
     */
    //21
    @Override
    public int deleteUsingTemplate(LogLightBean bean)
    {
        try{
            return this.nativeManager.deleteUsingTemplate(this.beanConverter.toRight(bean));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }





    /**
     * Retrieves the number of rows of the table fl_log_light with a 'where' clause.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the restriction clause
     * @return the number of rows returned
     */
    //25
    @Override
    public int countWhere(String where)
    {
        try{
            return this.nativeManager.countWhere(where);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
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
    @Override
    public int countUsingTemplate(LogLightBean bean, int startRow, int numRows, int searchType)
    {
        try{
            return this.nativeManager.countUsingTemplate(this.beanConverter.toRight(bean),startRow,numRows,searchType);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }


    //_____________________________________________________________________
    //
    // LISTENER
    //_____________________________________________________________________

    /**
     * Registers a unique {@link LogLightListener} listener.
     */
    //35
    @Override
    public void registerListener(TableListener listener)
    {
        this.nativeManager.registerListener(this.toNative((LogLightListener)listener));
    }

    private FlLogLightListener toNative(final LogLightListener listener) {
        return null == listener ?null:new FlLogLightListener (){

            @Override
            public void beforeInsert(FlLogLightBean bean) throws DAOException {
                listener.beforeInsert(LogLightManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlLogLightBean bean) throws DAOException {
                listener.afterInsert(LogLightManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlLogLightBean bean) throws DAOException {
                listener.beforeUpdate(LogLightManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlLogLightBean bean) throws DAOException {
                listener.afterUpdate(LogLightManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlLogLightBean bean) throws DAOException {
                listener.beforeDelete(LogLightManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlLogLightBean bean) throws DAOException {
                listener.afterDelete(LogLightManager.this.beanConverter.fromRight(bean));
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
    @Override
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
    @Override
    public List<LogLightBean> loadBySqlAsList(String sql, Object[] argList, int[] fieldList){
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadBySqlAsList(sql,argList,fieldList));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    
    @Override
    public <T>T runAsTransaction(Callable<T> fun) {
        try{
            return this.nativeManager.runAsTransaction(fun);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
    @Override
    public void runAsTransaction(final Runnable fun){
        try{
            this.nativeManager.runAsTransaction(fun);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    private FlLogLightManager.Action toNative(final Action<LogLightBean> action){
        if(null == action)
            throw new NullPointerException();
        return new FlLogLightManager.Action(){

            @Override
            public void call(FlLogLightBean bean) {
                action.call(LogLightManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlLogLightBean getBean() {
                return  LogLightManager.this.beanConverter.toRight(action.getBean());
            }};
    }
}

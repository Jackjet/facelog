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

import net.gdface.facelog.db.FaceLightBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.BaseBean;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.face.FlFaceLightManager;
import net.gdface.facelog.dborm.face.FlFaceLightBean;
/**
 * Handles database calls (save, load, count, etc...) for the fl_face_light table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.
 * @author guyadong
 */
public class FaceLightManager implements TableManager<FaceLightBean>
{

    /**
     * Identify the md5 field.
     */
    public static final int ID_MD5 = 0;

    /**
     * Identify the person_id field.
     */
    public static final int ID_PERSON_ID = 1;

    /**
     * Identify the img_md5 field.
     */
    public static final int ID_IMG_MD5 = 2;

    /**
     * Identify the face_left field.
     */
    public static final int ID_FACE_LEFT = 3;

    /**
     * Identify the face_top field.
     */
    public static final int ID_FACE_TOP = 4;

    /**
     * Identify the face_width field.
     */
    public static final int ID_FACE_WIDTH = 5;

    /**
     * Identify the face_height field.
     */
    public static final int ID_FACE_HEIGHT = 6;

    /**
     * Identify the eye_leftx field.
     */
    public static final int ID_EYE_LEFTX = 7;

    /**
     * Identify the eye_lefty field.
     */
    public static final int ID_EYE_LEFTY = 8;

    /**
     * Identify the eye_rightx field.
     */
    public static final int ID_EYE_RIGHTX = 9;

    /**
     * Identify the eye_righty field.
     */
    public static final int ID_EYE_RIGHTY = 10;

    /**
     * Identify the mouth_x field.
     */
    public static final int ID_MOUTH_X = 11;

    /**
     * Identify the mouth_y field.
     */
    public static final int ID_MOUTH_Y = 12;

    /**
     * Identify the nose_x field.
     */
    public static final int ID_NOSE_X = 13;

    /**
     * Identify the nose_y field.
     */
    public static final int ID_NOSE_Y = 14;

    /**
     * Identify the angle_yaw field.
     */
    public static final int ID_ANGLE_YAW = 15;

    /**
     * Identify the angle_pitch field.
     */
    public static final int ID_ANGLE_PITCH = 16;

    /**
     * Identify the angle_roll field.
     */
    public static final int ID_ANGLE_ROLL = 17;

    /**
     * Identify the ext_info field.
     */
    public static final int ID_EXT_INFO = 18;

    /**
     * Identify the create_time field.
     */
    public static final int ID_CREATE_TIME = 19;

    /**
     * Tablename.
     */
        public static final String TABLE_NAME="fl_face_light";
    /**
     * Contains all the full fields of the fl_face_light table.
     */
    public static final String[] FULL_FIELD_NAMES =
    {
        "fl_face_light.md5"
        ,"fl_face_light.person_id"
        ,"fl_face_light.img_md5"
        ,"fl_face_light.face_left"
        ,"fl_face_light.face_top"
        ,"fl_face_light.face_width"
        ,"fl_face_light.face_height"
        ,"fl_face_light.eye_leftx"
        ,"fl_face_light.eye_lefty"
        ,"fl_face_light.eye_rightx"
        ,"fl_face_light.eye_righty"
        ,"fl_face_light.mouth_x"
        ,"fl_face_light.mouth_y"
        ,"fl_face_light.nose_x"
        ,"fl_face_light.nose_y"
        ,"fl_face_light.angle_yaw"
        ,"fl_face_light.angle_pitch"
        ,"fl_face_light.angle_roll"
        ,"fl_face_light.ext_info"
        ,"fl_face_light.create_time"
    };

    /**
     * Contains all the fields of the fl_face_light table.
     */
    public static final String[] FIELD_NAMES =
    {
        "md5"
        ,"person_id"
        ,"img_md5"
        ,"face_left"
        ,"face_top"
        ,"face_width"
        ,"face_height"
        ,"eye_leftx"
        ,"eye_lefty"
        ,"eye_rightx"
        ,"eye_righty"
        ,"mouth_x"
        ,"mouth_y"
        ,"nose_x"
        ,"nose_y"
        ,"angle_yaw"
        ,"angle_pitch"
        ,"angle_roll"
        ,"ext_info"
        ,"create_time"
    };
   /**
     * Contains all the primarykey fields of the fl_face_light table.
     */
    public static final String[] PRIMARYKEY_NAMES =
    {
    };
    /**
     * Field that contains the comma separated fields of the fl_face_light table.
     */
    public static final String ALL_FULL_FIELDS = "fl_face_light.md5"
                            + ",fl_face_light.person_id"
                            + ",fl_face_light.img_md5"
                            + ",fl_face_light.face_left"
                            + ",fl_face_light.face_top"
                            + ",fl_face_light.face_width"
                            + ",fl_face_light.face_height"
                            + ",fl_face_light.eye_leftx"
                            + ",fl_face_light.eye_lefty"
                            + ",fl_face_light.eye_rightx"
                            + ",fl_face_light.eye_righty"
                            + ",fl_face_light.mouth_x"
                            + ",fl_face_light.mouth_y"
                            + ",fl_face_light.nose_x"
                            + ",fl_face_light.nose_y"
                            + ",fl_face_light.angle_yaw"
                            + ",fl_face_light.angle_pitch"
                            + ",fl_face_light.angle_roll"
                            + ",fl_face_light.ext_info"
                            + ",fl_face_light.create_time";

    /**
     * Field that contains the comma separated fields of the fl_face_light table.
     */
    public static final String ALL_FIELDS = "md5"
                            + ",person_id"
                            + ",img_md5"
                            + ",face_left"
                            + ",face_top"
                            + ",face_width"
                            + ",face_height"
                            + ",eye_leftx"
                            + ",eye_lefty"
                            + ",eye_rightx"
                            + ",eye_righty"
                            + ",mouth_x"
                            + ",mouth_y"
                            + ",nose_x"
                            + ",nose_y"
                            + ",angle_yaw"
                            + ",angle_pitch"
                            + ",angle_roll"
                            + ",ext_info"
                            + ",create_time";

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
    
    private FlFaceLightManager nativeManager = FlFaceLightManager.getInstance();
    private IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.face.FlFaceLightBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<FaceLightBean,FlFaceLightBean> beanConverter = dbConverter.getFaceLightBeanConverter();
    private static FaceLightManager singleton = new FaceLightManager();

    /**
     * Get the {@link FaceLightManager} singleton.
     *
     * @return {@link FaceLightManager}
     */
    public static FaceLightManager getInstance()
    {
        return singleton;
    }
   
    public IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.face.FlFaceLightBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.log.FlLogLightBean> getDbConverter() {
        return dbConverter;
    }

    /**
     * set  {@link IDbConverter} as converter used by manager.<br>
     * throw {@link NullPointerException} if {@code dbConverter} is null
     * @param dbConverter
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public synchronized void setDbConverter(IDbConverter dbConverter) {
        if( null == dbConverter)
            throw new NullPointerException();
        this.dbConverter = dbConverter;
        this.beanConverter = this.dbConverter.getFaceLightBeanConverter();
    }
    @Override
    public FaceLightBean loadByPrimaryKey(FaceLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public FaceLightBean loadByPrimaryKey(Object ...keys)
    {
        throw new UnsupportedOperationException();
    }    
    @Override
    public boolean existsPrimaryKey(FaceLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean existsPrimaryKey(Object ...keys)
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int deleteByPrimaryKey(FaceLightBean bean)
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public int deleteByPrimaryKey(Object ...keys)
    {
        throw new UnsupportedOperationException();
    }
 

    @Override
    public <T extends BaseBean> T[] getImportedBeans(FaceLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    @Override
    public <T extends BaseBean> List<T> getImportedBeansAsList(FaceLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    @Override
    public <T extends BaseBean> T[] setImportedBeans(FaceLightBean bean,T[] importedBeans,String fkName){
        throw new UnsupportedOperationException();
    }    
    @Override
    public <T extends BaseBean,C extends Collection<T>> C setImportedBeans(FaceLightBean bean,C importedBeans,String fkName){
        throw new UnsupportedOperationException();
    }
 


 
    @Override
    public <T extends BaseBean> T getReferencedBean(FaceLightBean bean,String fkName){
        throw new UnsupportedOperationException();
    }
    @Override
    public <T extends BaseBean> T setReferencedBean(FaceLightBean bean,T beanToSet,String fkName){
        throw new UnsupportedOperationException();
    }
     

    //////////////////////////////////////
    // LOAD ALL
    //////////////////////////////////////

    /**
     * Loads all the rows from fl_face_light.
     *
     * @return an array of FlFaceLightManager bean
     */
    //5
    @Override
    public FaceLightBean[] loadAll()
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
     * Loads each row from fl_face_light and dealt with action.
     * @param action  Action object for do something(not null)
     * @return the count dealt by action
     */
    //5-1
    @Override
    public int loadAll(Action<FaceLightBean> action)
    {
        return this.loadUsingTemplate(null,action);
    }
    /**
     * Loads all the rows from fl_face_light.
     *
     * @return a list of FaceLightBean bean
     */
    //5-2
    @Override
    public List<FaceLightBean> loadAllAsList()
    {
        return this.loadUsingTemplateAsList(null);
    }


    /**
     * Loads the given number of rows from fl_face_light, given the start row.
     *
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return an array of FlFaceLightManager bean
     */
    //6
    @Override
    public FaceLightBean[] loadAll(int startRow, int numRows)
    {
        return this.loadUsingTemplate(null, startRow, numRows);
    }
    /**
     *  Loads the given number of rows from fl_face_light, given the start row and dealt with action.
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param action  Action object for do something(not null)
     * @return the count dealt by action
     */
    //6-1
    @Override
    public int loadAll(int startRow, int numRows,Action<FaceLightBean> action)
    {
        return this.loadUsingTemplate(null, startRow, numRows,action);
    }
    /**
     * Loads the given number of rows from fl_face_light, given the start row.
     *
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return a list of FlFaceLightManager bean
     */
    //6-2
    @Override
    public List<FaceLightBean> loadAllAsList(int startRow, int numRows)
    {
        return this.loadUsingTemplateAsList(null, startRow, numRows);
    }

    //////////////////////////////////////
    // SQL 'WHERE' METHOD
    //////////////////////////////////////
    /**
     * Retrieves an array of FaceLightBean given a sql 'where' clause.
     *
     * @param where the sql 'where' clause
     * @return the resulting FaceLightBean table
     */
    //7
    @Override
    public FaceLightBean[] loadByWhere(String where)
    {
        return this.loadByWhere(where, (int[])null);
    }
    
    /**
     * Retrieves a list of FaceLightBean given a sql 'where' clause.
     *
     * @param where the sql 'where' clause
     * @return the resulting FaceLightBean table
     */
    //7
    @Override
    public List<FaceLightBean> loadByWhereAsList(String where)
    {
        return this.loadByWhereAsList(where, null);
    }
    /**
     * Retrieves each row of FaceLightBean given a sql 'where' clause and dealt with action.
     * @param where the sql 'where' clause
     * @param action  Action object for do something(not null)
     * @return the count dealt by action
     */
    //7-1
    @Override
    public int loadByWhere(String where,Action<FaceLightBean> action)
    {
        return this.loadByWhere(where, null,action);
    }
    /**
     * Retrieves an array of FaceLightBean given a sql where clause, and a list of fields.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'WHERE' clause
     * @param fieldList array of field's ID
     * @return the resulting FaceLightBean table
     */
    //8
    @Override
    public FaceLightBean[] loadByWhere(String where, int[] fieldList)
    {
        return this.loadByWhere(where, fieldList, 1, -1);
    }


    /**
     * Retrieves a list of FaceLightBean given a sql where clause, and a list of fields.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'WHERE' clause
     * @param fieldList array of field's ID
     * @return the resulting FaceLightBean table
     */
    //8
    @Override
    public List<FaceLightBean> loadByWhereAsList(String where, int[] fieldList)
    {
        return this.loadByWhereAsList(where, fieldList, 1, -1);
    }
    /**
     * Retrieves each row of FaceLightBean given a sql where clause, and a list of fields,
     * and dealt with action.
     * It is up to you to pass the 'WHERE' in your where clausis.
     * @param where the sql 'WHERE' clause
     * @param fieldList array of field's ID
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //8-1
    @Override
    public int loadByWhere(String where, int[] fieldList,Action<FaceLightBean> action)
    {
        return this.loadByWhere(where, fieldList, 1, -1,action);
    }

    /**
     * Retrieves an array of FaceLightBean given a sql where clause and a list of fields, and startRow and numRows.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param fieldList table of the field's associated constants
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the resulting FaceLightBean table
     */
    //9
    @Override
    public FaceLightBean[] loadByWhere(String where, int[] fieldList, int startRow, int numRows)
    {
        return (FaceLightBean[]) this.loadByWhereAsList(where, fieldList, startRow, numRows).toArray(new FaceLightBean[0]);
    }
    /**
     * Retrieves each row of  FaceLightBean given a sql where clause and a list of fields, and startRow and numRows,
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
    public int loadByWhere(String where, int[] fieldList, int startRow, int numRows,Action<FaceLightBean> action)
    {
        return this.loadByWhereForAction(where, fieldList, startRow, numRows,action);
    }

    /**
     * Retrieves a list of FaceLightBean given a sql where clause and a list of fields, and startRow and numRows.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param fieldList table of the field's associated constants
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the resulting FaceLightBean table
     */
    //9-2
    @Override
    public List<FaceLightBean> loadByWhereAsList(String where, int[] fieldList, int startRow, int numRows)
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
     * Retrieves each row of FaceLightBean given a sql where clause and a list of fields, and startRow and numRows,
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
    public int loadByWhereForAction(String where, int[] fieldList, int startRow, int numRows,Action<FaceLightBean> action)
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
     * Deletes all rows from fl_face_light table.
     * @return the number of deleted rows.
     */
    //10
    @Override
    public int deleteAll()
    {
        return this.deleteByWhere("");
    }

    /**
     * Deletes rows from the fl_face_light table using a 'where' clause.
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
     * Saves the {@link FaceLightBean} bean into the database.
     *
     * @param bean the {@link FaceLightBean} bean to be saved
     * @return the inserted or updated bean,or null if bean is null
     */
    //12
    @Override
    public FaceLightBean save(FaceLightBean bean)
    {
        if(null == bean)return null;
        if (bean.isNew()) {
            return this.insert(bean);
        } else {
            return this.update(bean);
        }
    }

    /**
     * Insert the {@link FaceLightBean} bean into the database.
     *
     * @param bean the {@link FaceLightBean} bean to be saved
     * @return the inserted bean or null if bean is null
     */
    //13
    public FaceLightBean insert(FaceLightBean bean)
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
     * Update the {@link FaceLightBean} bean record in the database according to the changes.
     *
     * @param bean the {@link FaceLightBean} bean to be updated
     * @return the updated bean or null if bean is null
     */
    //14
    public FaceLightBean update(FaceLightBean bean)
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
     * Saves an array of {@link FaceLightBean} bean into the database.
     *
     * @param beans the {@link FaceLightBean} bean table to be saved
     * @return the saved {@link FaceLightBean} beans or null if beans is null.
     */
    //15
    public FaceLightBean[] save(FaceLightBean[] beans)
    {
        if(null !=beans){
            for (FaceLightBean bean : beans) 
            {
                this.save(bean);
            }
        }
        return beans;
    }

    /**
     * Saves a collection of {@link FaceLightBean} bean into the database.
     *
     * @param beans the {@link FaceLightBean} bean table to be saved
     * @return the saved {@link FaceLightBean} beans or null if beans is null.
     */
    //15-2
    @Override
    public <C extends Collection<FaceLightBean>> C save(C beans)
    {
        if(null != beans){
            for (FaceLightBean bean : beans) 
            {
                this.save(bean);
            }
        }
        return beans;
    }
    /**
     * Saves an array of {@link FaceLightBean} bean into the database as transaction.
     *
     * @param beans the {@link FaceLightBean} bean table to be saved
     * @return the saved {@link FaceLightBean} beans.
     * @see #save(FaceLightBean[])
     */
    //15-3
    @Override
    public FaceLightBean[] saveAsTransaction(final FaceLightBean[] beans) {
        return this.runAsTransaction(new Callable<FaceLightBean[]>(){
            @Override
            public FaceLightBean[] call() throws Exception {
                return save(beans);
            }});
    }
    /**
     * Saves a collection of {@link FaceLightBean} bean into the database as transaction.
     *
     * @param beans the {@link FaceLightBean} bean table to be saved
     * @return the saved {@link FaceLightBean} beans.
     * @see #save(List)
     */
    //15-4
    @Override
    public <C extends Collection<FaceLightBean>> C saveAsTransaction(final C beans){
        return this.runAsTransaction(new Callable<C>(){
            @Override
            public C call() throws Exception {
                return save(beans);
            }});
    }
    
    //_____________________________________________________________________
    //
    // USING TEMPLATE
    //_____________________________________________________________________
    /**
     * Loads a unique FaceLightBean bean from a template one giving a c
     *
     * @param bean the FaceLightBean bean to look for
     * @return the bean matching the template
     */
    //18
    @Override
    public FaceLightBean loadUniqueUsingTemplate(FaceLightBean bean)
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
     * Loads an array of FaceLightBean from a template one.
     *
     * @param bean the FaceLightBean template to look for
     * @return all the FaceLightBean matching the template
     */
    //19
    @Override
    public FaceLightBean[] loadUsingTemplate(FaceLightBean bean)
    {
        return this.loadUsingTemplate(bean, 1, -1);
    }
    /**
     * Loads each row from a template one and dealt with action.
     *
     * @param bean the FaceLightBean template to look for
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //19-1
    @Override
    public int loadUsingTemplate(FaceLightBean bean,Action<FaceLightBean> action)
    {
        return this.loadUsingTemplate(bean, 1, -1,action);
    }

    /**
     * Loads a list of FaceLightBean from a template one.
     *
     * @param bean the FaceLightBean template to look for
     * @return all the FaceLightBean matching the template
     */
    //19-2
    @Override
    public List<FaceLightBean> loadUsingTemplateAsList(FaceLightBean bean)
    {
        return this.loadUsingTemplateAsList(bean, 1, -1);
    }

    /**
     * Loads an array of FaceLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the FaceLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return all the FaceLightBean matching the template
     */
    //20
    @Override
    public FaceLightBean[] loadUsingTemplate(FaceLightBean bean, int startRow, int numRows)
    {
        return this.loadUsingTemplate(bean, startRow, numRows, SearchType.SEARCH_EXACT);
    }
    /**
     * Loads each row from a template one, given the start row and number of rows and dealt with action.
     *
     * @param bean the FaceLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //20-1
    @Override
    public int loadUsingTemplate(FaceLightBean bean, int startRow, int numRows,Action<FaceLightBean> action)
    {
        return this.loadUsingTemplate(bean, null, startRow, numRows,SearchType.SEARCH_EXACT, action);
    }
    /**
     * Loads a list of FaceLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the FaceLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return all the FaceLightBean matching the template
     */
    //20-2
    @Override
    public List<FaceLightBean> loadUsingTemplateAsList(FaceLightBean bean, int startRow, int numRows)
    {
        return this.loadUsingTemplateAsList(bean, startRow, numRows, SearchType.SEARCH_EXACT);
    }

    /**
     * Loads an array of FaceLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the FaceLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @return all the FaceLightBean matching the template
     */
    //20-3
    @Override
    public FaceLightBean[] loadUsingTemplate(FaceLightBean bean, int startRow, int numRows, SearchType searchType)
    {
        return this.loadUsingTemplateAsList(bean, startRow, numRows, searchType).toArray(new FaceLightBean[0]);
    }

    /**
     * Loads a list of FaceLightBean from a template one, given the start row and number of rows.
     *
     * @param bean the FaceLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @return all the FaceLightBean matching the template
     */
    //20-4
    @Override
    public List<FaceLightBean> loadUsingTemplateAsList(FaceLightBean bean, int startRow, int numRows, SearchType searchType)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUsingTemplateAsList(this.beanConverter.toRight(bean),startRow,numRows,searchType.ordinal()));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }        
    }
    /**
     * Loads each row from a template one, given the start row and number of rows and dealt with action.
     *
     * @param bean the FaceLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @param action Action object for do something(not null)
     * @return the count dealt by action
     */
    //20-5
    @Override
    public int loadUsingTemplate(FaceLightBean bean, int[] fieldList, int startRow, int numRows,SearchType searchType, Action<FaceLightBean> action)
    {
        try {
            return this.nativeManager.loadUsingTemplate(this.beanConverter.toRight(bean),fieldList,startRow,numRows,searchType.ordinal(),this.toNative(action));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    /**
     * Deletes rows using a FaceLightBean template.
     *
     * @param bean the FaceLightBean object(s) to be deleted
     * @return the number of deleted objects
     */
    //21
    @Override
    public int deleteUsingTemplate(FaceLightBean bean)
    {
        try{
            return this.nativeManager.deleteUsingTemplate(this.beanConverter.toRight(bean));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }



    //_____________________________________________________________________
    //
    // COUNT
    //_____________________________________________________________________

    /**
     * Retrieves the number of rows of the table fl_face_light.
     *
     * @return the number of rows returned
     */
    //24
    @Override
    public int countAll() 
    {
        return this.countWhere("");
    }

    /**
     * Retrieves the number of rows of the table fl_face_light with a 'where' clause.
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
     * count the number of elements of a specific FaceLightBean bean
     *
     * @param bean the FaceLightBean bean to look for ant count
     * @return the number of rows returned
     */
    //27
    @Override
    public int countUsingTemplate(FaceLightBean bean)
    {
        return this.countUsingTemplate(bean, -1, -1);
    }

    /**
     * count the number of elements of a specific FaceLightBean bean , given the start row and number of rows.
     *
     * @param bean the FaceLightBean template to look for and count
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the number of rows returned
     */
    //20
    @Override
    public int countUsingTemplate(FaceLightBean bean, int startRow, int numRows)
    {
        return this.countUsingTemplate(bean, startRow, numRows, SearchType.SEARCH_EXACT);
    }

    /**
     * count the number of elements of a specific FaceLightBean bean given the start row and number of rows and the search type
     *
     * @param bean the FaceLightBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param searchType exact ?  like ? starting like ?
     * @return the number of rows returned
     */
    //20
    @Override
    public int countUsingTemplate(FaceLightBean bean, int startRow, int numRows, SearchType searchType)
    {
        try{
            return this.nativeManager.countUsingTemplate(this.beanConverter.toRight(bean),startRow,numRows,searchType.ordinal());
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
     * Registers a unique {@link FaceLightListener} listener.
     */
    //35
    @Override
    public void registerListener(TableListener<FaceLightBean> listener)
    {
        this.nativeManager.registerListener(this.toNative(listener));
    }

    private net.gdface.facelog.dborm.TableListener<FlFaceLightBean> toNative(final TableListener<FaceLightBean> listener) {
        return null == listener ?null:new net.gdface.facelog.dborm.TableListener<FlFaceLightBean> (){

            @Override
            public void beforeInsert(FlFaceLightBean bean) throws DAOException {
                listener.beforeInsert(FaceLightManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlFaceLightBean bean) throws DAOException {
                listener.afterInsert(FaceLightManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlFaceLightBean bean) throws DAOException {
                listener.beforeUpdate(FaceLightManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlFaceLightBean bean) throws DAOException {
                listener.afterUpdate(FaceLightManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlFaceLightBean bean) throws DAOException {
                listener.beforeDelete(FaceLightManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlFaceLightBean bean) throws DAOException {
                listener.afterDelete(FaceLightManager.this.beanConverter.fromRight(bean));
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
     * @return an array of FaceLightBean
     */
    @Override
    public FaceLightBean[] loadBySql(String sql, Object[] argList, int[] fieldList) {
        return loadBySqlAsList(sql, argList, fieldList).toArray(new FaceLightBean[0]);
    }
    /**
     * Load all elements using a SQL statement specifying a list of fields to be retrieved.
     * @param sql the SQL statement for retrieving
     * @param argList the arguments to use fill given prepared statement,may be null
     * @param fieldList table of the field's associated constants
     * @return an list of FaceLightBean
     */
    @Override
    public List<FaceLightBean> loadBySqlAsList(String sql, Object[] argList, int[] fieldList){
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
    private FlFaceLightManager.Action toNative(final Action<FaceLightBean> action){
        if(null == action)
            throw new NullPointerException();
        return new FlFaceLightManager.Action(){

            @Override
            public void call(FlFaceLightBean bean) {
                action.call(FaceLightManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlFaceLightBean getBean() {
                return  FaceLightManager.this.beanConverter.toRight(action.getBean());
            }};
    }
}

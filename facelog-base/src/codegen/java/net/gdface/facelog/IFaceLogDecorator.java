package net.gdface.facelog;
import java.util.List;
import java.util.Map;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.DeviceGroupBean;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.PersonGroupBean;
/**
 * decorator pattern 装饰者模式实现{@link IFaceLog}接口<br>
 * 转发所有{@link IFaceLog}接口方法到{@link #delegate()}指定的实例,<br>
 * unchecked后缀的方法将所有显式申明的异常封装到{@link RuntimeException}抛出<br>
 * 计算机生成代码(generated by automated tools DecoratorGenerator @author guyadong)<br>
 * @author guyadong
 *
 */
public class IFaceLogDecorator implements IFaceLog{
    private final IFaceLog delegate;
    
    public IFaceLogDecorator(IFaceLog delegate) {
        super();
        if(null == delegate){
            throw new NullPointerException("delegate is null");
        }
        this.delegate = delegate;
    }

    /**
     * 返回被装饰的{@link IFaceLog}实例
     * @return
     */
    public IFaceLog delegate() {
        return delegate;
    }    

    @Override
    public FeatureBean addFeature (byte[] feature,Integer personId,List<FaceBean> faecBeans,Token token) throws DuplicateRecordException{
        return delegate().addFeature(feature,personId,faecBeans,token);
    }

    /**
     * {@link IFaceLog#addFeature(byte[],java.lang.Integer,List,Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param feature
     * @param personId
     * @param faecBeans
     * @param token
     * @return FeatureBean
     */
    public FeatureBean addFeatureUnchecked (byte[] feature,Integer personId,List<FaceBean> faecBeans,Token token) {
        try{
            return delegate().addFeature(feature,personId,faecBeans,token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public FeatureBean addFeature (byte[] feature,Integer personId,Map<java.nio.ByteBuffer, FaceBean> faceInfo,Integer deviceId,Token token) throws DuplicateRecordException{
        return delegate().addFeature(feature,personId,faceInfo,deviceId,token);
    }

    /**
     * {@link IFaceLog#addFeature(byte[],java.lang.Integer,Map,java.lang.Integer,Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param feature
     * @param personId
     * @param faceInfo
     * @param deviceId
     * @param token
     * @return FeatureBean
     */
    public FeatureBean addFeatureUnchecked (byte[] feature,Integer personId,Map<java.nio.ByteBuffer, FaceBean> faceInfo,Integer deviceId,Token token) {
        try{
            return delegate().addFeature(feature,personId,faceInfo,deviceId,token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ImageBean addImage (byte[] imageData,Integer deviceId,FaceBean faceBean,Integer personId,Token token) throws DuplicateRecordException{
        return delegate().addImage(imageData,deviceId,faceBean,personId,token);
    }

    /**
     * {@link IFaceLog#addImage(byte[],java.lang.Integer,FaceBean,java.lang.Integer,Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param imageData
     * @param deviceId
     * @param faceBean
     * @param personId
     * @param token
     * @return ImageBean
     */
    public ImageBean addImageUnchecked (byte[] imageData,Integer deviceId,FaceBean faceBean,Integer personId,Token token) {
        try{
            return delegate().addImage(imageData,deviceId,faceBean,personId,token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addLog (LogBean bean,Token token) throws DuplicateRecordException{
         delegate().addLog(bean,token);
    }

    /**
     * {@link IFaceLog#addLog(LogBean,Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param bean
     * @param token
     * @return void
     */
    public void addLogUnchecked (LogBean bean,Token token) {
        try{
             delegate().addLog(bean,token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addLogs (List<LogBean> beans,Token token) throws DuplicateRecordException{
         delegate().addLogs(beans,token);
    }

    /**
     * {@link IFaceLog#addLogs(List,Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param beans
     * @param token
     * @return void
     */
    public void addLogsUnchecked (List<LogBean> beans,Token token) {
        try{
             delegate().addLogs(beans,token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addPermit (int deviceGroupId,int personGroupId,Token token) {
         delegate().addPermit(deviceGroupId,personGroupId,token);
    }

    @Override
    public void addPermit (DeviceGroupBean deviceGroup,PersonGroupBean personGroup,Token token) {
         delegate().addPermit(deviceGroup,personGroup,token);
    }

    @Override
    public String applyAckChannel (Token token) {
        return delegate().applyAckChannel(token);
    }

    @Override
    public String applyAckChannel (Token token,long duration) {
        return delegate().applyAckChannel(token,duration);
    }

    @Override
    public long applyCmdSn (Token token) {
        return delegate().applyCmdSn(token);
    }

    @Override
    public Token applyPersonToken (int personId,String password,boolean isMd5) throws ServiceSecurityException{
        return delegate().applyPersonToken(personId,password,isMd5);
    }

    /**
     * {@link IFaceLog#applyPersonToken(int,java.lang.String,boolean)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param personId
     * @param password
     * @param isMd5
     * @return Token
     */
    public Token applyPersonTokenUnchecked (int personId,String password,boolean isMd5) {
        try{
            return delegate().applyPersonToken(personId,password,isMd5);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Token applyRootToken (String password,boolean isMd5) throws ServiceSecurityException{
        return delegate().applyRootToken(password,isMd5);
    }

    /**
     * {@link IFaceLog#applyRootToken(java.lang.String,boolean)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param password
     * @param isMd5
     * @return Token
     */
    public Token applyRootTokenUnchecked (String password,boolean isMd5) {
        try{
            return delegate().applyRootToken(password,isMd5);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bindBorder (Integer personGroupId,Integer deviceGroupId,Token token) {
         delegate().bindBorder(personGroupId,deviceGroupId,token);
    }

    @Override
    public int countDeviceByWhere (String where) {
        return delegate().countDeviceByWhere(where);
    }

    @Override
    public int countDeviceGroupByWhere (String where) {
        return delegate().countDeviceGroupByWhere(where);
    }

    @Override
    public int countLogByWhere (String where) {
        return delegate().countLogByWhere(where);
    }

    @Override
    public int countLogLightByVerifyTime (long timestamp) {
        return delegate().countLogLightByVerifyTime(timestamp);
    }

    @Override
    public int countLogLightByWhere (String where) {
        return delegate().countLogLightByWhere(where);
    }

    @Override
    public int countPersonByWhere (String where) {
        return delegate().countPersonByWhere(where);
    }

    @Override
    public int countPersonGroupByWhere (String where) {
        return delegate().countPersonGroupByWhere(where);
    }

    @Override
    public int deleteAllFeaturesByPersonId (int personId,boolean deleteImage,Token token) {
        return delegate().deleteAllFeaturesByPersonId(personId,deleteImage,token);
    }

    @Override
    public int deleteDeviceGroup (int deviceGroupId,Token token) {
        return delegate().deleteDeviceGroup(deviceGroupId,token);
    }

    @Override
    public List<String> deleteFeature (String featureMd5,boolean deleteImage,Token token) {
        return delegate().deleteFeature(featureMd5,deleteImage,token);
    }

    @Override
    public int deleteImage (String imageMd5,Token token) {
        return delegate().deleteImage(imageMd5,token);
    }

    @Override
    public int deletePermit (DeviceGroupBean deviceGroup,PersonGroupBean personGroup,Token token) {
        return delegate().deletePermit(deviceGroup,personGroup,token);
    }

    @Override
    public int deletePerson (int personId,Token token) {
        return delegate().deletePerson(personId,token);
    }

    @Override
    public int deletePersonByPapersNum (String papersNum,Token token) {
        return delegate().deletePersonByPapersNum(papersNum,token);
    }

    @Override
    public int deletePersonGroup (int personGroupId,Token token) {
        return delegate().deletePersonGroup(personGroupId,token);
    }

    @Override
    public int deletePersons (List<Integer> personIdList,Token token) {
        return delegate().deletePersons(personIdList,token);
    }

    @Override
    public int deletePersonsByPapersNum (List<String> papersNumlist,Token token) {
        return delegate().deletePersonsByPapersNum(papersNumlist,token);
    }

    @Override
    public void disablePerson (int personId,Token token) {
         delegate().disablePerson(personId,token);
    }

    @Override
    public void disablePerson (List<Integer> personIdList,Token token) {
         delegate().disablePerson(personIdList,token);
    }

    @Override
    public boolean existsDevice (int id) {
        return delegate().existsDevice(id);
    }

    @Override
    public boolean existsFeature (String md5) {
        return delegate().existsFeature(md5);
    }

    @Override
    public boolean existsImage (String md5) {
        return delegate().existsImage(md5);
    }

    @Override
    public boolean existsPerson (int persionId) {
        return delegate().existsPerson(persionId);
    }

    @Override
    public DeviceBean getDevice (int deviceId) {
        return delegate().getDevice(deviceId);
    }

    @Override
    public DeviceGroupBean getDeviceGroup (int deviceGroupId) {
        return delegate().getDeviceGroup(deviceGroupId);
    }

    @Override
    public List<DeviceGroupBean> getDeviceGroups (List<Integer> groupIdList) {
        return delegate().getDeviceGroups(groupIdList);
    }

    @Override
    public List<Integer> getDeviceGroupsBelongs (int deviceId) {
        return delegate().getDeviceGroupsBelongs(deviceId);
    }

    @Override
    public List<Integer> getDeviceGroupsPermit (Integer personGroupId) {
        return delegate().getDeviceGroupsPermit(personGroupId);
    }

    @Override
    public Integer getDeviceIdOfFeature (String featureMd5) {
        return delegate().getDeviceIdOfFeature(featureMd5);
    }

    @Override
    public List<DeviceBean> getDevices (List<Integer> idList) {
        return delegate().getDevices(idList);
    }

    @Override
    public List<Integer> getDevicesOfGroup (int deviceGroupId) {
        return delegate().getDevicesOfGroup(deviceGroupId);
    }

    @Override
    public FeatureBean getFeature (String md5) {
        return delegate().getFeature(md5);
    }

    @Override
    public List<String> getFeatureBeansByPersonId (int personId) {
        return delegate().getFeatureBeansByPersonId(personId);
    }

    @Override
    public byte[] getFeatureBytes (String md5) {
        return delegate().getFeatureBytes(md5);
    }

    @Override
    public List<FeatureBean> getFeatures (List<String> md5) {
        return delegate().getFeatures(md5);
    }

    @Override
    public List<String> getFeaturesOfPerson (int personId) {
        return delegate().getFeaturesOfPerson(personId);
    }

    @Override
    public boolean getGroupPermit (int deviceId,int personGroupId) {
        return delegate().getGroupPermit(deviceId,personGroupId);
    }

    @Override
    public List<Boolean> getGroupPermits (int deviceId,List<Integer> personGroupIdList) {
        return delegate().getGroupPermits(deviceId,personGroupIdList);
    }

    @Override
    public ImageBean getImage (String imageMD5) {
        return delegate().getImage(imageMD5);
    }

    @Override
    public byte[] getImageBytes (String imageMD5) {
        return delegate().getImageBytes(imageMD5);
    }

    @Override
    public List<String> getImagesAssociatedByFeature (String featureMd5) {
        return delegate().getImagesAssociatedByFeature(featureMd5);
    }

    @Override
    public List<LogBean> getLogBeansByPersonId (int personId) {
        return delegate().getLogBeansByPersonId(personId);
    }

    @Override
    public PersonBean getPerson (int personId) {
        return delegate().getPerson(personId);
    }

    @Override
    public PersonBean getPersonByPapersNum (String papersNum) {
        return delegate().getPersonByPapersNum(papersNum);
    }

    @Override
    public PersonGroupBean getPersonGroup (int personGroupId) {
        return delegate().getPersonGroup(personGroupId);
    }

    @Override
    public List<PersonGroupBean> getPersonGroups (List<Integer> groupIdList) {
        return delegate().getPersonGroups(groupIdList);
    }

    @Override
    public List<Integer> getPersonGroupsBelongs (int personId) {
        return delegate().getPersonGroupsBelongs(personId);
    }

    @Override
    public List<Integer> getPersonGroupsPermittedBy (Integer deviceGroupId) {
        return delegate().getPersonGroupsPermittedBy(deviceGroupId);
    }

    @Override
    public boolean getPersonPermit (int deviceId,int personId) {
        return delegate().getPersonPermit(deviceId,personId);
    }

    @Override
    public List<Boolean> getPersonPermits (int deviceId,List<Integer> personIdList) {
        return delegate().getPersonPermits(deviceId,personIdList);
    }

    @Override
    public List<PersonBean> getPersons (List<Integer> idList) {
        return delegate().getPersons(idList);
    }

    @Override
    public List<Integer> getPersonsOfGroup (int personGroupId) {
        return delegate().getPersonsOfGroup(personGroupId);
    }

    @Override
    public String getProperty (String key,Token token) {
        return delegate().getProperty(key,token);
    }

    @Override
    public Map<net.gdface.facelog.MQParam, String> getRedisParameters (Token token) {
        return delegate().getRedisParameters(token);
    }

    @Override
    public Map<String, String> getServiceConfig (Token token) {
        return delegate().getServiceConfig(token);
    }

    @Override
    public List<Integer> getSubDeviceGroup (int deviceGroupId) {
        return delegate().getSubDeviceGroup(deviceGroupId);
    }

    @Override
    public List<Integer> getSubPersonGroup (int personGroupId) {
        return delegate().getSubPersonGroup(personGroupId);
    }

    @Override
    public boolean isDisable (int personId) {
        return delegate().isDisable(personId);
    }

    @Override
    public boolean isLocal () {
        return delegate().isLocal();
    }

    @Override
    public boolean isValidAckChannel (String ackChannel) {
        return delegate().isValidAckChannel(ackChannel);
    }

    @Override
    public boolean isValidCmdSn (long cmdSn) {
        return delegate().isValidCmdSn(cmdSn);
    }

    @Override
    public boolean isValidDeviceToken (Token token) {
        return delegate().isValidDeviceToken(token);
    }

    @Override
    public boolean isValidPassword (String userId,String password,boolean isMd5) {
        return delegate().isValidPassword(userId,password,isMd5);
    }

    @Override
    public boolean isValidPersonToken (Token token) {
        return delegate().isValidPersonToken(token);
    }

    @Override
    public boolean isValidRootToken (Token token) {
        return delegate().isValidRootToken(token);
    }

    @Override
    public List<Integer> listOfParentForDeviceGroup (int deviceGroupId) {
        return delegate().listOfParentForDeviceGroup(deviceGroupId);
    }

    @Override
    public List<Integer> listOfParentForPersonGroup (int personGroupId) {
        return delegate().listOfParentForPersonGroup(personGroupId);
    }

    @Override
    public List<Integer> loadAllPerson () {
        return delegate().loadAllPerson();
    }

    @Override
    public List<DeviceBean> loadDeviceByWhere (String where,int startRow,int numRows) {
        return delegate().loadDeviceByWhere(where,startRow,numRows);
    }

    @Override
    public List<Integer> loadDeviceGroupByWhere (String where,int startRow,int numRows) {
        return delegate().loadDeviceGroupByWhere(where,startRow,numRows);
    }

    @Override
    public List<Integer> loadDeviceGroupIdByWhere (String where) {
        return delegate().loadDeviceGroupIdByWhere(where);
    }

    @Override
    public List<Integer> loadDeviceIdByWhere (String where) {
        return delegate().loadDeviceIdByWhere(where);
    }

    @Override
    public List<String> loadFeatureMd5ByUpdate (long timestamp) {
        return delegate().loadFeatureMd5ByUpdate(timestamp);
    }

    @Override
    public List<LogBean> loadLogByWhere (String where,int startRow,int numRows) {
        return delegate().loadLogByWhere(where,startRow,numRows);
    }

    @Override
    public List<net.gdface.facelog.db.LogLightBean> loadLogLightByVerifyTime (long timestamp,int startRow,int numRows) {
        return delegate().loadLogLightByVerifyTime(timestamp,startRow,numRows);
    }

    @Override
    public List<net.gdface.facelog.db.LogLightBean> loadLogLightByWhere (String where,int startRow,int numRows) {
        return delegate().loadLogLightByWhere(where,startRow,numRows);
    }

    @Override
    public List<net.gdface.facelog.db.PermitBean> loadPermitByUpdate (long timestamp) {
        return delegate().loadPermitByUpdate(timestamp);
    }

    @Override
    public List<PersonBean> loadPersonByWhere (String where,int startRow,int numRows) {
        return delegate().loadPersonByWhere(where,startRow,numRows);
    }

    @Override
    public List<Integer> loadPersonGroupByWhere (String where,int startRow,int numRows) {
        return delegate().loadPersonGroupByWhere(where,startRow,numRows);
    }

    @Override
    public List<Integer> loadPersonGroupIdByWhere (String where) {
        return delegate().loadPersonGroupIdByWhere(where);
    }

    @Override
    public List<Integer> loadPersonIdByUpdateTime (long timestamp) {
        return delegate().loadPersonIdByUpdateTime(timestamp);
    }

    @Override
    public List<Integer> loadPersonIdByWhere (String where) {
        return delegate().loadPersonIdByWhere(where);
    }

    @Override
    public List<Integer> loadUpdatedPersons (long timestamp) {
        return delegate().loadUpdatedPersons(timestamp);
    }

    @Override
    public void offline (Token token) throws ServiceSecurityException{
         delegate().offline(token);
    }

    /**
     * {@link IFaceLog#offline(Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param token
     * @return void
     */
    public void offlineUnchecked (Token token) {
        try{
             delegate().offline(token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Token online (DeviceBean device) throws ServiceSecurityException{
        return delegate().online(device);
    }

    /**
     * {@link IFaceLog#online(DeviceBean)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param device
     * @return Token
     */
    public Token onlineUnchecked (DeviceBean device) {
        try{
            return delegate().online(device);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public DeviceBean registerDevice (DeviceBean newDevice) throws ServiceSecurityException{
        return delegate().registerDevice(newDevice);
    }

    /**
     * {@link IFaceLog#registerDevice(DeviceBean)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param newDevice
     * @return DeviceBean
     */
    public DeviceBean registerDeviceUnchecked (DeviceBean newDevice) {
        try{
            return delegate().registerDevice(newDevice);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void releasePersonToken (Token token) throws ServiceSecurityException{
         delegate().releasePersonToken(token);
    }

    /**
     * {@link IFaceLog#releasePersonToken(Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param token
     * @return void
     */
    public void releasePersonTokenUnchecked (Token token) {
        try{
             delegate().releasePersonToken(token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void releaseRootToken (Token token) throws ServiceSecurityException{
         delegate().releaseRootToken(token);
    }

    /**
     * {@link IFaceLog#releaseRootToken(Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param token
     * @return void
     */
    public void releaseRootTokenUnchecked (Token token) {
        try{
             delegate().releaseRootToken(token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void replaceFeature (Integer personId,String featureMd5,boolean deleteOldFeatureImage,Token token) {
         delegate().replaceFeature(personId,featureMd5,deleteOldFeatureImage,token);
    }

    @Override
    public Integer rootGroupOfDevice (Integer deviceId) {
        return delegate().rootGroupOfDevice(deviceId);
    }

    @Override
    public Integer rootGroupOfPerson (Integer personId) {
        return delegate().rootGroupOfPerson(personId);
    }

    @Override
    public DeviceBean saveDevice (DeviceBean deviceBean,Token token) {
        return delegate().saveDevice(deviceBean,token);
    }

    @Override
    public DeviceGroupBean saveDeviceGroup (DeviceGroupBean deviceGroupBean,Token token) {
        return delegate().saveDeviceGroup(deviceGroupBean,token);
    }

    @Override
    public PersonBean savePerson (PersonBean bean,byte[] idPhoto,byte[] feature,byte[] featureImage,FaceBean featureFaceBean,Integer deviceId,Token token) {
        return delegate().savePerson(bean,idPhoto,feature,featureImage,featureFaceBean,deviceId,token);
    }

    @Override
    public PersonBean savePerson (PersonBean bean,byte[] idPhoto,byte[] feature,List<FaceBean> faceBeans,Token token) {
        return delegate().savePerson(bean,idPhoto,feature,faceBeans,token);
    }

    @Override
    public PersonBean savePerson (PersonBean bean,byte[] idPhoto,byte[] feature,Map<java.nio.ByteBuffer, FaceBean> faceInfo,Integer deviceId,Token token) {
        return delegate().savePerson(bean,idPhoto,feature,faceInfo,deviceId,token);
    }

    @Override
    public PersonBean savePerson (PersonBean bean,byte[] idPhoto,Token token) {
        return delegate().savePerson(bean,idPhoto,token);
    }

    @Override
    public PersonBean savePerson (PersonBean bean,byte[] idPhoto,FeatureBean featureBean,Integer deviceId,Token token) {
        return delegate().savePerson(bean,idPhoto,featureBean,deviceId,token);
    }

    @Override
    public PersonBean savePerson (PersonBean bean,String idPhotoMd5,String featureMd5,Token token) {
        return delegate().savePerson(bean,idPhotoMd5,featureMd5,token);
    }

    @Override
    public PersonBean savePerson (PersonBean bean,Token token) {
        return delegate().savePerson(bean,token);
    }

    @Override
    public PersonGroupBean savePersonGroup (PersonGroupBean personGroupBean,Token token) {
        return delegate().savePersonGroup(personGroupBean,token);
    }

    @Override
    public void savePersons (List<PersonBean> beans,Token token) {
         delegate().savePersons(beans,token);
    }

    @Override
    public int savePersons (Map<java.nio.ByteBuffer, PersonBean> persons,Token token) {
        return delegate().savePersons(persons,token);
    }

    @Override
    public void saveServiceConfig (Token token) {
         delegate().saveServiceConfig(token);
    }

    @Override
    public void setPersonExpiryDate (int personId,long expiryDate,Token token) {
         delegate().setPersonExpiryDate(personId,expiryDate,token);
    }

    @Override
    public void setPersonExpiryDate (List<Integer> personIdList,long expiryDate,Token token) {
         delegate().setPersonExpiryDate(personIdList,expiryDate,token);
    }

    @Override
    public void setProperties (Map<String, String> config,Token token) {
         delegate().setProperties(config,token);
    }

    @Override
    public void setProperty (String key,String value,Token token) {
         delegate().setProperty(key,value,token);
    }

    @Override
    public String taskQueueOf (String task,Token token) {
        return delegate().taskQueueOf(task,token);
    }

    @Override
    public String taskRegister (String task,Token token) {
        return delegate().taskRegister(task,token);
    }

    @Override
    public void unbindBorder (Integer personGroupId,Integer deviceGroupId,Token token) {
         delegate().unbindBorder(personGroupId,deviceGroupId,token);
    }

    @Override
    public void unregisterDevice (int deviceId,Token token) throws ServiceSecurityException{
         delegate().unregisterDevice(deviceId,token);
    }

    /**
     * {@link IFaceLog#unregisterDevice(int,Token)}对应的unchecked方法,
     * 所有显式申明的异常都被封装到{@link RuntimeException}抛出<br>
     * @param deviceId
     * @param token
     * @return void
     */
    public void unregisterDeviceUnchecked (int deviceId,Token token) {
        try{
             delegate().unregisterDevice(deviceId,token);
        } catch(RuntimeException e){
            throw e;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public DeviceBean updateDevice (DeviceBean deviceBean,Token token) {
        return delegate().updateDevice(deviceBean,token);
    }

    @Override
    public String version () {
        return delegate().version();
    }

    @Override
    public Map<String, String> versionInfo () {
        return delegate().versionInfo();
    }
}
// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-06-18T05:57:30.728Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 221:1
package net.gdface.facelog.client.thrift;

import com.microsoft.thrifty.service.ServiceMethodCallback;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import okio.ByteString;

@Generated(
    value = "com.microsoft.thrifty.gen.ThriftyCodeGenerator",
    comments = "https://github.com/microsoft/thrifty"
)
public interface IFaceLog {
  void addFeature(ByteString feature, String featureVersion, Integer personId,
      List<FaceBean> faecBeans, Token token, ServiceMethodCallback<FeatureBean> callback);

  void addFeatureMulti(ByteString feature, String featureVersion, Integer personId,
      Map<ByteString, FaceBean> faceInfo, Token token, ServiceMethodCallback<FeatureBean> callback);

  void addFeatureWithImage(ByteString feature, String featureVersion, Integer personId,
      Boolean asIdPhotoIfAbsent, ByteString featurePhoto, FaceBean faceBean, Token token,
      ServiceMethodCallback<FeatureBean> callback);

  void addImage(ByteString imageData, Integer deviceId, FaceBean faceBean, Integer personId,
      Token token, ServiceMethodCallback<ImageBean> callback);

  void addLog(LogBean logBean, Token token, ServiceMethodCallback<Void> callback);

  void addLogFull(LogBean logBean, FaceBean faceBean, ByteString featureImage, Token token,
      ServiceMethodCallback<Void> callback);

  void addLogs(List<LogBean> beans, Token token, ServiceMethodCallback<Void> callback);

  void addLogsFull(List<LogBean> logBeans, List<FaceBean> faceBeans, List<ByteString> featureImages,
      Token token, ServiceMethodCallback<Void> callback);

  void addPermit(DeviceGroupBean deviceGroup, PersonGroupBean personGroup, Token token,
      ServiceMethodCallback<Void> callback);

  void addPermitById(Integer deviceGroupId, Integer personGroupId, Token token,
      ServiceMethodCallback<Void> callback);

  void applyAckChannel(Token token, ServiceMethodCallback<String> callback);

  void applyAckChannelWithDuration(Integer duration, Token token,
      ServiceMethodCallback<String> callback);

  void applyCmdSn(Token token, ServiceMethodCallback<Long> callback);

  void applyPersonToken(Integer personId, String password, Boolean isMd5,
      ServiceMethodCallback<Token> callback);

  void applyRootToken(String password, Boolean isMd5, ServiceMethodCallback<Token> callback);

  void applyUserToken(Integer userid, String password, Boolean isMd5,
      ServiceMethodCallback<Token> callback);

  void bindBorder(Integer personGroupId, Integer deviceGroupId, Token token,
      ServiceMethodCallback<Void> callback);

  void childListForDeviceGroup(Integer deviceGroupId,
      ServiceMethodCallback<List<Integer>> callback);

  void childListForPersonGroup(Integer personGroupId,
      ServiceMethodCallback<List<Integer>> callback);

  void countDeviceByWhere(String where, ServiceMethodCallback<Integer> callback);

  void countDeviceGroupByWhere(String where, ServiceMethodCallback<Integer> callback);

  void countLogByWhere(String where, ServiceMethodCallback<Integer> callback);

  void countLogLightByVerifyTime(Long timestamp, ServiceMethodCallback<Integer> callback);

  void countLogLightByVerifyTimeTimestr(String timestamp, ServiceMethodCallback<Integer> callback);

  void countLogLightByWhere(String where, ServiceMethodCallback<Integer> callback);

  void countPersonByWhere(String where, ServiceMethodCallback<Integer> callback);

  void countPersonGroupByWhere(String where, ServiceMethodCallback<Integer> callback);

  void deleteAllFeaturesByPersonId(Integer personId, Boolean deleteImage, Token token,
      ServiceMethodCallback<Integer> callback);

  void deleteDeviceGroup(Integer deviceGroupId, Token token,
      ServiceMethodCallback<Integer> callback);

  void deleteFeature(String featureMd5, Boolean deleteImage, Token token,
      ServiceMethodCallback<List<String>> callback);

  void deleteGroupPermitOnDeviceGroup(Integer deviceGroupId, Token token,
      ServiceMethodCallback<Integer> callback);

  void deleteImage(String imageMd5, Token token, ServiceMethodCallback<Integer> callback);

  void deletePermit(DeviceGroupBean deviceGroup, PersonGroupBean personGroup, Token token,
      ServiceMethodCallback<Integer> callback);

  void deletePermitById(Integer deviceGroupId, Integer personGroupId, Token token,
      ServiceMethodCallback<Integer> callback);

  void deletePerson(Integer personId, Token token, ServiceMethodCallback<Integer> callback);

  void deletePersonByPapersNum(String papersNum, Token token,
      ServiceMethodCallback<Integer> callback);

  void deletePersonGroup(Integer personGroupId, Token token,
      ServiceMethodCallback<Integer> callback);

  void deletePersonGroupPermit(Integer personGroupId, Token token,
      ServiceMethodCallback<Integer> callback);

  void deletePersons(List<Integer> personIdList, Token token,
      ServiceMethodCallback<Integer> callback);

  void deletePersonsByPapersNum(List<String> papersNumlist, Token token,
      ServiceMethodCallback<Integer> callback);

  void disablePerson(Integer personId, Integer moveToGroupId, Boolean deletePhoto,
      Boolean deleteFeature, Boolean deleteLog, Token token, ServiceMethodCallback<Void> callback);

  void disablePersonList(List<Integer> personIdList, Token token,
      ServiceMethodCallback<Void> callback);

  void existsDevice(Integer id, ServiceMethodCallback<Boolean> callback);

  void existsFeature(String md5, ServiceMethodCallback<Boolean> callback);

  void existsImage(String md5, ServiceMethodCallback<Boolean> callback);

  void existsPerson(Integer persionId, ServiceMethodCallback<Boolean> callback);

  void getDevice(Integer deviceId, ServiceMethodCallback<DeviceBean> callback);

  void getDeviceGroup(Integer deviceGroupId, ServiceMethodCallback<DeviceGroupBean> callback);

  void getDeviceGroups(List<Integer> groupIdList,
      ServiceMethodCallback<List<DeviceGroupBean>> callback);

  void getDeviceGroupsBelongs(Integer deviceId, ServiceMethodCallback<List<Integer>> callback);

  void getDeviceGroupsPermit(Integer personGroupId, ServiceMethodCallback<List<Integer>> callback);

  void getDeviceGroupsPermittedBy(Integer personGroupId,
      ServiceMethodCallback<List<Integer>> callback);

  void getDeviceIdOfFeature(String featureMd5, ServiceMethodCallback<Integer> callback);

  void getDevices(List<Integer> idList, ServiceMethodCallback<List<DeviceBean>> callback);

  void getDevicesOfGroup(Integer deviceGroupId, ServiceMethodCallback<List<Integer>> callback);

  void getFace(Integer faceId, ServiceMethodCallback<FaceBean> callback);

  void getFeature(String md5, ServiceMethodCallback<FeatureBean> callback);

  void getFeatureBytes(String md5, ServiceMethodCallback<ByteString> callback);

  void getFeatures(List<String> md5, ServiceMethodCallback<List<FeatureBean>> callback);

  void getFeaturesByPersonId(Integer personId, ServiceMethodCallback<List<String>> callback);

  void getFeaturesByPersonIdAndSdkVersion(Integer personId, String sdkVersion,
      ServiceMethodCallback<List<String>> callback);

  void getFeaturesOfPerson(Integer personId, ServiceMethodCallback<List<String>> callback);

  void getGroupPermit(Integer deviceId, Integer personGroupId,
      ServiceMethodCallback<PermitBean> callback);

  void getGroupPermitOnDeviceGroup(Integer deviceGroupId, Integer personGroupId,
      ServiceMethodCallback<PermitBean> callback);

  void getGroupPermits(Integer deviceId, List<Integer> personGroupIdList,
      ServiceMethodCallback<List<PermitBean>> callback);

  void getImage(String imageMD5, ServiceMethodCallback<ImageBean> callback);

  void getImageBytes(String imageMD5, ServiceMethodCallback<ByteString> callback);

  void getImagesAssociatedByFeature(String featureMd5,
      ServiceMethodCallback<List<String>> callback);

  void getLogBeansByPersonId(Integer personId, ServiceMethodCallback<List<LogBean>> callback);

  void getPerson(Integer personId, ServiceMethodCallback<PersonBean> callback);

  void getPersonByPapersNum(String papersNum, ServiceMethodCallback<PersonBean> callback);

  void getPersonGroup(Integer personGroupId, ServiceMethodCallback<PersonGroupBean> callback);

  void getPersonGroups(List<Integer> groupIdList,
      ServiceMethodCallback<List<PersonGroupBean>> callback);

  void getPersonGroupsBelongs(Integer personId, ServiceMethodCallback<List<Integer>> callback);

  void getPersonGroupsPermittedBy(Integer deviceGroupId,
      ServiceMethodCallback<List<Integer>> callback);

  void getPersonPermit(Integer deviceId, Integer personId,
      ServiceMethodCallback<PermitBean> callback);

  void getPersonPermits(Integer deviceId, List<Integer> personIdList,
      ServiceMethodCallback<List<PermitBean>> callback);

  void getPersons(List<Integer> idList, ServiceMethodCallback<List<PersonBean>> callback);

  void getPersonsOfGroup(Integer personGroupId, ServiceMethodCallback<List<Integer>> callback);

  void getProperty(String key, Token token, ServiceMethodCallback<String> callback);

  void getRedisParameters(Token token, ServiceMethodCallback<Map<MQParam, String>> callback);

  void getServiceConfig(Token token, ServiceMethodCallback<Map<String, String>> callback);

  void getSubDeviceGroup(Integer deviceGroupId, ServiceMethodCallback<List<Integer>> callback);

  void getSubPersonGroup(Integer personGroupId, ServiceMethodCallback<List<Integer>> callback);

  void isDisable(Integer personId, ServiceMethodCallback<Boolean> callback);

  void isLocal(ServiceMethodCallback<Boolean> callback);

  void isValidAckChannel(String ackChannel, ServiceMethodCallback<Boolean> callback);

  void isValidCmdSn(Long cmdSn, ServiceMethodCallback<Boolean> callback);

  void isValidDeviceToken(Token token, ServiceMethodCallback<Boolean> callback);

  void isValidPassword(String userId, String password, Boolean isMd5,
      ServiceMethodCallback<Boolean> callback);

  void isValidPersonToken(Token token, ServiceMethodCallback<Boolean> callback);

  void isValidRootToken(Token token, ServiceMethodCallback<Boolean> callback);

  void isValidToken(Token token, ServiceMethodCallback<Boolean> callback);

  void isValidUserToken(Token token, ServiceMethodCallback<Boolean> callback);

  void listOfParentForDeviceGroup(Integer deviceGroupId,
      ServiceMethodCallback<List<Integer>> callback);

  void listOfParentForPersonGroup(Integer personGroupId,
      ServiceMethodCallback<List<Integer>> callback);

  void loadAllPerson(ServiceMethodCallback<List<Integer>> callback);

  void loadDeviceByWhere(String where, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<DeviceBean>> callback);

  void loadDeviceGroupByWhere(String where, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<Integer>> callback);

  void loadDeviceGroupIdByWhere(String where, ServiceMethodCallback<List<Integer>> callback);

  void loadDeviceIdByWhere(String where, ServiceMethodCallback<List<Integer>> callback);

  void loadFeatureMd5ByUpdate(Long timestamp, ServiceMethodCallback<List<String>> callback);

  void loadFeatureMd5ByUpdateTimeStr(String timestamp,
      ServiceMethodCallback<List<String>> callback);

  void loadLogByWhere(String where, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<LogBean>> callback);

  void loadLogLightByVerifyTime(Long timestamp, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<LogLightBean>> callback);

  void loadLogLightByVerifyTimeTimestr(String timestamp, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<LogLightBean>> callback);

  void loadLogLightByWhere(String where, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<LogLightBean>> callback);

  void loadPermitByUpdate(Long timestamp, ServiceMethodCallback<List<PermitBean>> callback);

  void loadPermitByUpdateTimestr(String timestamp,
      ServiceMethodCallback<List<PermitBean>> callback);

  void loadPersonByWhere(String where, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<PersonBean>> callback);

  void loadPersonGroupByWhere(String where, Integer startRow, Integer numRows,
      ServiceMethodCallback<List<Integer>> callback);

  void loadPersonGroupIdByWhere(String where, ServiceMethodCallback<List<Integer>> callback);

  void loadPersonIdByUpdateTime(Long timestamp, ServiceMethodCallback<List<Integer>> callback);

  void loadPersonIdByUpdateTimeTimeStr(String timestamp,
      ServiceMethodCallback<List<Integer>> callback);

  void loadPersonIdByWhere(String where, ServiceMethodCallback<List<Integer>> callback);

  void loadUpdatedPersons(Long timestamp, ServiceMethodCallback<List<Integer>> callback);

  void loadUpdatedPersonsTimestr(String timestamp, ServiceMethodCallback<List<Integer>> callback);

  void offline(Token token, ServiceMethodCallback<Void> callback);

  void online(DeviceBean device, ServiceMethodCallback<Token> callback);

  void registerDevice(DeviceBean newDevice, ServiceMethodCallback<DeviceBean> callback);

  void releasePersonToken(Token token, ServiceMethodCallback<Void> callback);

  void releaseRootToken(Token token, ServiceMethodCallback<Void> callback);

  void releaseUserToken(Token token, ServiceMethodCallback<Void> callback);

  void replaceFeature(Integer personId, String featureMd5, Boolean deleteOldFeatureImage,
      Token token, ServiceMethodCallback<Void> callback);

  void rootGroupOfDevice(Integer deviceId, ServiceMethodCallback<Integer> callback);

  void rootGroupOfPerson(Integer personId, ServiceMethodCallback<Integer> callback);

  void saveDevice(DeviceBean deviceBean, Token token, ServiceMethodCallback<DeviceBean> callback);

  void saveDeviceGroup(DeviceGroupBean deviceGroupBean, Token token,
      ServiceMethodCallback<DeviceGroupBean> callback);

  void savePerson(PersonBean personBean, Token token, ServiceMethodCallback<PersonBean> callback);

  void savePersonFull(PersonBean personBean, ByteString idPhoto, ByteString feature,
      String featureVersion, ByteString featureImage, FaceBean featureFaceBean, Token token,
      ServiceMethodCallback<PersonBean> callback);

  void savePersonGroup(PersonGroupBean personGroupBean, Token token,
      ServiceMethodCallback<PersonGroupBean> callback);

  void savePersonWithPhoto(PersonBean personBean, ByteString idPhoto, Token token,
      ServiceMethodCallback<PersonBean> callback);

  void savePersonWithPhotoAndFeature(PersonBean personBean, ByteString idPhoto,
      FeatureBean featureBean, Token token, ServiceMethodCallback<PersonBean> callback);

  void savePersonWithPhotoAndFeatureMultiFaces(PersonBean personBean, ByteString idPhoto,
      ByteString feature, String featureVersion, List<FaceBean> faceBeans, Token token,
      ServiceMethodCallback<PersonBean> callback);

  void savePersonWithPhotoAndFeatureMultiImage(PersonBean personBean, ByteString idPhoto,
      ByteString feature, String featureVersion, Map<ByteString, FaceBean> faceInfo, Token token,
      ServiceMethodCallback<PersonBean> callback);

  void savePersonWithPhotoAndFeatureSaved(PersonBean personBean, String idPhotoMd5,
      String featureMd5, Token token, ServiceMethodCallback<PersonBean> callback);

  void savePersons(List<PersonBean> persons, Token token, ServiceMethodCallback<Void> callback);

  void savePersonsWithPhoto(Map<ByteString, PersonBean> persons, Token token,
      ServiceMethodCallback<Integer> callback);

  void saveServiceConfig(Token token, ServiceMethodCallback<Void> callback);

  void sdkTaskQueueOf(String task, String sdkVersion, Token token,
      ServiceMethodCallback<String> callback);

  void setPersonExpiryDate(Integer personId, Long expiryDate, Token token,
      ServiceMethodCallback<Void> callback);

  void setPersonExpiryDateList(List<Integer> personIdList, Long expiryDate, Token token,
      ServiceMethodCallback<Void> callback);

  void setPersonExpiryDateTimeStr(Integer personId, String expiryDate, Token token,
      ServiceMethodCallback<Void> callback);

  void setProperties(Map<String, String> config, Token token, ServiceMethodCallback<Void> callback);

  void setProperty(String key, String value, Token token, ServiceMethodCallback<Void> callback);

  void taskQueueOf(String task, Token token, ServiceMethodCallback<String> callback);

  void unbindBorder(Integer personGroupId, Integer deviceGroupId, Token token,
      ServiceMethodCallback<Void> callback);

  void unregisterDevice(Token token, ServiceMethodCallback<Void> callback);

  void updateDevice(DeviceBean deviceBean, Token token, ServiceMethodCallback<DeviceBean> callback);

  void version(ServiceMethodCallback<String> callback);

  void versionInfo(ServiceMethodCallback<Map<String, String>> callback);
}

package net.gdface.facelog;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.LogLightBean;
import net.gdface.facelog.db.PersonBean;

@ThriftService
public interface IFaceLog {

	/**
	 * 返回personId指定的人员记录
	 * @param personId
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	PersonBean getPerson(int personId) throws ServiceRuntime;

	/**
	 * 返回 list 指定的人员记录
	 * @param list 人员id列表
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<PersonBean> getPersons(List<Integer> list) throws ServiceRuntime;

	/**
	 * 根据证件号码返回人员记录
	 * @param papersNum
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	PersonBean getPersonByPapersNum(String papersNum) throws ServiceRuntime;

	/**
	 * 返回 persionId 关联的所有人脸特征记录
	 * @param personId fl_person.id
	 * @return 返回 fl_feature.md5  列表
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<String> getFeatureBeansByPersonId(int personId) throws ServiceRuntime;

	/**
	 * 删除personId指定的人员(person)记录及关联的所有记录
	 * @param personId
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	int deletePerson(int personId) throws ServiceRuntime;

	/**
	 * 删除personIdList指定的人员(person)记录及关联的所有记录
	 * @param personIdList 人员id列表
	 * @return 返回删除的 person 记录数量
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	int deletePersons(List<Integer> personIdList) throws ServiceRuntime;

	/**
	 * 删除papersNum指定的人员(person)记录及关联的所有记录
	 * @param papersNum 证件号码
	 * @return 返回删除的 person 记录数量
	 * @throws ServiceRuntime
	 * @see {@link #deletePerson(int)}
	 */
	@ThriftMethod
	int deletePersonByPapersNum(String papersNum) throws ServiceRuntime;

	/**
	 * 删除papersNum指定的人员(person)记录及关联的所有记录
	 * @param papersNumlist 证件号码列表
	 * @return 返回删除的 person 记录数量
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	int deletePersonsByPapersNum(List<String> papersNumlist) throws ServiceRuntime;

	/**
	 * 判断是否存在personId指定的人员记录
	 * @param persionId
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	boolean existsPerson(int persionId) throws ServiceRuntime;

	/**
	 * 判断 personId 指定的人员记录是否过期
	 * @param personId
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	boolean isDisable(int personId) throws ServiceRuntime;

	/**
	 * 设置 personId 指定的人员为禁止状态
	 * @param personId
	 * @throws ServiceRuntime
	 * @see #setPersonExpiryDate(int, long)
	 */
	@ThriftMethod
	void disablePerson(int personId) throws ServiceRuntime;

	/**
	 * 修改 personId 指定的人员记录的有效期
	 * @param personId
	 * @param expiryDate 失效日期
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	void setPersonExpiryDate(int personId, long expiryDate) throws ServiceRuntime;

	/**
	 * 修改 personIdList 指定的人员记录的有效期
	 * @param personIdList 人员id列表
	 * @param expiryDate 失效日期 
	 * @throws ServiceRuntime
	 */
	void setPersonExpiryDate(List<Integer> personIdList, long expiryDate) throws ServiceRuntime;

	/**
	 * 设置 personIdList 指定的人员为禁止状态
	 * @param personIdList 人员id列表
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("disablePersonList")
	void disablePerson(List<Integer> personIdList) throws ServiceRuntime;

	/**
	 * 返回 persionId 关联的所有日志记录
	 * @param personId fl_person.id
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<LogBean> getLogBeansByPersonId(int personId) throws ServiceRuntime;

	/**
	 * 返回所有人员记录
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<Integer> loadAllPerson() throws ServiceRuntime;

	/**
	 * 返回 where 指定的所有人员记录
	 * @param where SQL条件语句
	 * @return 返回 fl_person.id 列表
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<Integer> loadPersonByWhere(String where) throws ServiceRuntime;

	/**
	 * 保存人员(person)记录
	 * @param bean
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	PersonBean savePerson(PersonBean bean) throws ServiceRuntime;

	/**
	 * 保存人员(person)记录
	 * @param beans 
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("savePersonList")
	void savePerson(List<PersonBean> beans) throws ServiceRuntime;

	/**
	 * 保存人员信息记录
	 * @param bean
	 * @param idPhoto 标准照图像对象,可为null
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("savePersonWithPhoto")
	PersonBean savePerson(PersonBean bean, ByteBuffer idPhoto) throws ServiceRuntime;

	/**
	 * 保存人员信息记录(包含标准照)
	 * @param persons
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("savePersonsWithPhoto")
	Integer savePerson(Map<ByteBuffer, PersonBean> persons) throws ServiceRuntime;

	/**
	 * 保存人员信息记录
	 * @param bean
	 * @param idPhotoMd5 标准照图像对象,可为null
	 * @param featureMd5 用于验证的人脸特征数据对象,可为null
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("savePersonWithPhotoAndFeatureSaved")
	PersonBean savePerson(PersonBean bean, String idPhotoMd5, String featureMd5) throws ServiceRuntime;

	/**
	 * 保存人员信息记录
	 * @param bean
	 * @param idPhoto 标准照图像,可为null
	 * @param featureBean 用于验证的人脸特征数据对象,可为null
	 * @param deviceId 标准照图像来源设备id,可为null
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("savePersonWithPhotoAndFeature")
	PersonBean savePerson(PersonBean bean, ByteBuffer idPhoto, FeatureBean featureBean, Integer deviceId)
			throws ServiceRuntime;

	/**
	 * 保存人员信息记录
	 * @param bean
	 * @param idPhoto 标准照图像,可为null
	 * @param feature 用于验证的人脸特征数据,可为null,不可重复, 参见 {@link #addFeature(ByteBuffer, Integer, List)}
	 * @param faceBeans 参见 {@link #addFeature(ByteBuffer, Integer, List)}
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("savePersonWithPhotoAndFeatureMultiFaces")
	PersonBean savePerson(PersonBean bean, ByteBuffer idPhoto, ByteBuffer feature, List<FaceBean> faceBeans)
			throws ServiceRuntime;

	/**
	 * 保存人员信息记录
	 * @param bean 
	 * @param idPhoto 标准照图像,可为null
	 * @param feature 用于验证的人脸特征数据,可为null 
	 * @param faceInfo 生成特征数据的人脸信息对象(可以是多个人脸对象合成一个特征),可为null
	 * @param deviceId faceInfo 图像来源设备id,可为null 
	 * @return bean 保存的{@link PersonBean}对象
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("savePersonWithPhotoAndFeatureMultiImage")
	PersonBean savePerson(PersonBean bean, ByteBuffer idPhoto, ByteBuffer feature, Map<ByteBuffer, FaceBean> faceInfo,
			Integer deviceId) throws ServiceRuntime;

	/**
	 * 
	 * @param bean 人员信息对象
	 * @param idPhoto 标准照图像
	 * @param feature 人脸特征数据
	 * @param featureImage 提取特征源图像,为null 时,默认使用idPhoto
	 * @param featureFaceBean 人脸位置对象,为null 时,不保存人脸数据
	 * @param deviceBean featureImage来源设备对象
	 * @return
	 */
	@ThriftMethod("savePersonFull")
	PersonBean savePerson(PersonBean bean, ByteBuffer idPhoto, ByteBuffer feature, ByteBuffer featureImage,
			FaceBean featureFaceBean, Integer deviceId) throws ServiceRuntime;

	/**
	 * 替换personId指定的人员记录的人脸特征数据,同时删除原特征数据记录(fl_feature)及关联的fl_face表记录
	 * @param personId 人员记录id
	 * @param featureMd5 人脸特征数据记录id (已经保存在数据库中)
	 * @param deleteOldFeatureImage 是否删除原特征数据记录间接关联的原始图像记录(fl_image)
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	void replaceFeature(Integer personId, String featureMd5, boolean deleteOldFeatureImage) throws ServiceRuntime;

	/**
	 * (主动更新机制实现)<br>
	 * 返回fl_person.update_time字段大于指定时间戳( timestamp )的所有fl_person记录<br>
	 * 同时包含fl_feature更新记录引用的fl_person记录
	 * @param timestamp
	 * @return 返回fl_person.id 列表
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<Integer> loadUpdatePersons(long timestamp) throws ServiceRuntime;

	/**
	 * (主动更新机制实现)<br>
	 * 返回 fl_person.update_time 字段大于指定时间戳( timestamp )的所有fl_person记录
	 * @param timestamp
	 * @return 返回fl_person.id 列表
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<Integer> loadPersonIdByUpdate(long timestamp) throws ServiceRuntime;

	/**
	 * (主动更新机制实现)<br>
	 * 返回 fl_feature.update_time 字段大于指定时间戳( timestamp )的所有fl_feature记录
	 * @param timestamp
	 * @return 返回 fl_feature.md5 列表
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<String> loadFeatureMd5ByUpdate(long timestamp) throws ServiceRuntime;

	/**
	 * 添加一条验证日志记录
	 * @param bean
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	void addLog(LogBean bean) throws ServiceRuntime;

	/**
	 * 添加一组验证日志记录(事务存储)
	 * @param beans
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("addLogList")
	void addLog(List<LogBean> beans) throws ServiceRuntime;
	@ThriftMethod
	List<LogBean> loadLogByWhere(String where, List<Integer> fieldList, int startRow, int numRows)
			throws ServiceRuntime;
	
	@ThriftMethod
	List<LogLightBean> loadLogLightByWhere(String where, int startRow, int numRows) throws ServiceRuntime;
	@ThriftMethod
	int countLogLightWhere(String where) throws ServiceRuntime;
	@ThriftMethod
	int countLogWhere(String where) throws ServiceRuntime;

	/**
	 * 判断md5指定的图像记录是否存在
	 * @param md5
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	boolean existsImage(String md5) throws ServiceRuntime;

	/**
	 * 保存图像数据,如果图像数据已经存在，则抛出异常
	 * @param imageData 图像数据
	 * @param deviceId 图像来源设备id,可为null
	 * @param faceBean 关联的人脸信息对象,可为null
	 * @param personId 关联的人员id(fl_person.id),可为null
	 * @return
	 * @throws ServiceRuntime
	 * @see {@link #_addImage(ByteBuffer, DeviceBean, List, List)}
	 */
	@ThriftMethod
	ImageBean addImage(ByteBuffer imageData, Integer deviceId, FaceBean faceBean, Integer personId)
			throws ServiceRuntime;

	/**
	 * 判断md5指定的特征记录是否存在
	 * @param md5
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	boolean existsFeature(String md5) throws ServiceRuntime;

	/**
	 * 增加一个人脸特征记录，如果记录已经存在则抛出异常
	 * @param feature 特征数据
	 * @param personId 关联的人员id(fl_person.id),可为null
	 * @param faecBeans 生成特征数据的人脸信息对象(可以是多个人脸对象合成一个特征),可为null
	 * @return 保存的人脸特征记录{@link FeatureBean}
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	FeatureBean addFeature(ByteBuffer feature, Integer personId, List<FaceBean> faecBeans) throws ServiceRuntime;

	/**
	 * 增加一个人脸特征记录,特征数据由faceInfo指定的多张图像合成，如果记录已经存在则抛出异常
	 * @param feature 特征数据
	 * @param personId 关联的人员id(fl_person.id),可为null
	 * @param faceInfo 生成特征数据的图像及人脸信息对象(每张图对应一张人脸),可为null
	 * @param deviceId 图像来源设备id,可为null
	 * @return 保存的人脸特征记录{@link FeatureBean}
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("addFeatureMulti")
	FeatureBean addFeature(ByteBuffer feature, Integer personId, Map<ByteBuffer, FaceBean> faceInfo, Integer deviceId)
			throws ServiceRuntime;

	/**
	 * 删除featureMd5指定的特征记录及关联的face记录
	 * @param featureMd5
	 * @param deleteImage 是否删除关联的 image记录
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<String> deleteFeature(String featureMd5, boolean deleteImage) throws ServiceRuntime;

	/**
	 * 删除 personId 关联的所有特征(feature)记录
	 * @param personId
	 * @param deleteImage 是否删除关联的 image记录
	 * @return
	 * @see #deleteFeature(String, boolean)
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	int deleteAllFeaturesByPersonId(int personId, boolean deleteImage) throws ServiceRuntime;

	/**
	 * 根据MD5校验码返回人脸特征数据记录
	 * @param md5
	 * @return 如果数据库中没有对应的数据则返回null
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	FeatureBean getFeature(String md5) throws ServiceRuntime;

	/**
	 * 根据MD5校验码返回人脸特征数据记录
	 * @param md5 md5列表
	 * @return {@link FeatureBean}列表
	 * @throws ServiceRuntime
	 */
	@ThriftMethod("getFeatureList")
	List<FeatureBean> getFeature(List<String> md5) throws ServiceRuntime;

	/**
	 * 根据MD5校验码返回人脸特征数据
	 * @param md5
	 * @return 二进制数据字节数组,如果数据库中没有对应的数据则返回null
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	ByteBuffer getFeatureBytes(String md5) throws ServiceRuntime;

	/**
	 * 根据图像的MD5校验码返回图像数据
	 * @param imageMD5
	 * @return 二进制数据字节数组,如果数据库中没有对应的数据则返回null
	 * @throws ServiceRuntime
	 * @see {@link #getBinary(String)}
	 */
	@ThriftMethod
	ByteBuffer getImageBytes(String imageMD5) throws ServiceRuntime;

	/**
	 * 根据图像的MD5校验码返回图像记录
	 * @param imageMD5
	 * @return {@link ImageBean} ,如果没有对应记录则返回null
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	ImageBean getImage(String imageMD5) throws ServiceRuntime;

	/**
	 * 返回featureMd5的人脸特征记录关联的所有图像记录id(MD5) 
	 * @param featureMd5 人脸特征id(MD5)
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	List<String> getImagesAssociatedByFeature(String featureMd5) throws ServiceRuntime;

	/**
	 * 删除imageMd5指定图像及其缩略图
	 * @param imageMd5
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	int deleteImage(String imageMd5) throws ServiceRuntime;

	/**
	 * 判断id指定的设备记录是否存在
	 * @param id
	 * @return
	 * @throws ServiceRuntime
	 */
	@ThriftMethod
	boolean existsDevice(int id) throws ServiceRuntime;
	@ThriftMethod
	DeviceBean saveDevice(DeviceBean deviceBean) throws ServiceRuntime;
	@ThriftMethod
	DeviceBean getDevice(Integer deviceId) throws ServiceRuntime;
	@ThriftMethod("getDeviceList")
	List<DeviceBean> getDevice(List<Integer> deviceId) throws ServiceRuntime;

}
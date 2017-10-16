// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// template: service.java.vm
// ______________________________________________________


// gu.rpc.thrift.SwiftServiceParser 
// classloader sun.misc.Launcher$AppClassLoader
// classloader.parent sun.misc.Launcher$ExtClassLoader

/*
com.facebook.swift.service.metadata.ThriftServiceMetadata
IFaceLog
0 name: addFeature 
	param 0: feature class java.nio.ByteBuffer
	param 1: personId class java.lang.Integer
	param 2: faecBeans java.util.List<net.gdface.facelog.db.FaceBean>
	return:class net.gdface.facelog.db.FeatureBean
1 name: addFeatureMulti original name: addFeature 
	param 0: feature class java.nio.ByteBuffer
	param 1: personId class java.lang.Integer
	param 2: faceInfo java.util.Map<java.nio.ByteBuffer, net.gdface.facelog.db.FaceBean>
	param 3: deviceId class java.lang.Integer
	return:class net.gdface.facelog.db.FeatureBean
2 name: addImage 
	param 0: imageData class java.nio.ByteBuffer
	param 1: deviceId class java.lang.Integer
	param 2: faceBean class net.gdface.facelog.db.FaceBean
	param 3: personId class java.lang.Integer
	return:class net.gdface.facelog.db.ImageBean
3 name: addLog 
	param 0: bean class net.gdface.facelog.db.LogBean
	return:void
4 name: addLogList original name: addLog 
	param 0: beans java.util.List<net.gdface.facelog.db.LogBean>
	return:void
5 name: countLogLightWhere 
	param 0: where class java.lang.String
	return:int
6 name: countLogWhere 
	param 0: where class java.lang.String
	return:int
7 name: deleteAllFeaturesByPersonId 
	param 0: personId int
	param 1: deleteImage boolean
	return:int
8 name: deleteFeature 
	param 0: featureMd5 class java.lang.String
	param 1: deleteImage boolean
	return:java.util.List<java.lang.String>
9 name: deleteImage 
	param 0: imageMd5 class java.lang.String
	return:int
10 name: deletePerson 
	param 0: personId int
	return:int
11 name: deletePersonByPapersNum 
	param 0: papersNum class java.lang.String
	return:int
12 name: deletePersons 
	param 0: personIdList java.util.List<java.lang.Integer>
	return:int
13 name: deletePersonsByPapersNum 
	param 0: papersNumlist java.util.List<java.lang.String>
	return:int
14 name: disablePerson 
	param 0: personId int
	return:void
15 name: disablePersonList original name: disablePerson 
	param 0: personIdList java.util.List<java.lang.Integer>
	return:void
16 name: existsDevice 
	param 0: id int
	return:boolean
17 name: existsFeature 
	param 0: md5 class java.lang.String
	return:boolean
18 name: existsImage 
	param 0: md5 class java.lang.String
	return:boolean
19 name: existsPerson 
	param 0: persionId int
	return:boolean
20 name: getDevice 
	param 0: deviceId class java.lang.Integer
	return:class net.gdface.facelog.db.DeviceBean
21 name: getDeviceList original name: getDevice 
	param 0: deviceId java.util.List<java.lang.Integer>
	return:java.util.List<net.gdface.facelog.db.DeviceBean>
22 name: getFeature 
	param 0: md5 class java.lang.String
	return:class net.gdface.facelog.db.FeatureBean
23 name: getFeatureBeansByPersonId 
	param 0: personId int
	return:java.util.List<java.lang.String>
24 name: getFeatureBytes 
	param 0: md5 class java.lang.String
	return:class java.nio.ByteBuffer
25 name: getFeatureList original name: getFeature 
	param 0: md5 java.util.List<java.lang.String>
	return:java.util.List<net.gdface.facelog.db.FeatureBean>
26 name: getImage 
	param 0: imageMD5 class java.lang.String
	return:class net.gdface.facelog.db.ImageBean
27 name: getImageBytes 
	param 0: imageMD5 class java.lang.String
	return:class java.nio.ByteBuffer
28 name: getImagesAssociatedByFeature 
	param 0: featureMd5 class java.lang.String
	return:java.util.List<java.lang.String>
29 name: getLogBeansByPersonId 
	param 0: personId int
	return:java.util.List<net.gdface.facelog.db.LogBean>
30 name: getPerson 
	param 0: personId int
	return:class net.gdface.facelog.db.PersonBean
31 name: getPersonByPapersNum 
	param 0: papersNum class java.lang.String
	return:class net.gdface.facelog.db.PersonBean
32 name: getPersons 
	param 0: idList java.util.List<java.lang.Integer>
	return:java.util.List<net.gdface.facelog.db.PersonBean>
33 name: isDisable 
	param 0: personId int
	return:boolean
34 name: loadAllPerson 
	return:java.util.List<java.lang.Integer>
35 name: loadFeatureMd5ByUpdate 
	param 0: timestamp long
	return:java.util.List<java.lang.String>
36 name: loadLogByWhere 
	param 0: where class java.lang.String
	param 1: startRow int
	param 2: numRows int
	return:java.util.List<net.gdface.facelog.db.LogBean>
37 name: loadLogLightByWhere 
	param 0: where class java.lang.String
	param 1: startRow int
	param 2: numRows int
	return:java.util.List<net.gdface.facelog.db.LogLightBean>
38 name: loadPersonByWhere 
	param 0: where class java.lang.String
	return:java.util.List<java.lang.Integer>
39 name: loadPersonIdByUpdate 
	param 0: timestamp long
	return:java.util.List<java.lang.Integer>
40 name: loadUpdatePersons 
	param 0: timestamp long
	return:java.util.List<java.lang.Integer>
41 name: replaceFeature 
	param 0: personId class java.lang.Integer
	param 1: featureMd5 class java.lang.String
	param 2: deleteOldFeatureImage boolean
	return:void
42 name: saveDevice 
	param 0: deviceBean class net.gdface.facelog.db.DeviceBean
	return:class net.gdface.facelog.db.DeviceBean
43 name: savePerson 
	param 0: bean class net.gdface.facelog.db.PersonBean
	return:class net.gdface.facelog.db.PersonBean
44 name: savePersonFull original name: savePerson 
	param 0: bean class net.gdface.facelog.db.PersonBean
	param 1: idPhoto class java.nio.ByteBuffer
	param 2: feature class java.nio.ByteBuffer
	param 3: featureImage class java.nio.ByteBuffer
	param 4: featureFaceBean class net.gdface.facelog.db.FaceBean
	param 5: deviceId class java.lang.Integer
	return:class net.gdface.facelog.db.PersonBean
45 name: savePersonList original name: savePerson 
	param 0: beans java.util.List<net.gdface.facelog.db.PersonBean>
	return:void
46 name: savePersonWithPhoto original name: savePerson 
	param 0: bean class net.gdface.facelog.db.PersonBean
	param 1: idPhoto class java.nio.ByteBuffer
	return:class net.gdface.facelog.db.PersonBean
47 name: savePersonWithPhotoAndFeature original name: savePerson 
	param 0: bean class net.gdface.facelog.db.PersonBean
	param 1: idPhoto class java.nio.ByteBuffer
	param 2: featureBean class net.gdface.facelog.db.FeatureBean
	param 3: deviceId class java.lang.Integer
	return:class net.gdface.facelog.db.PersonBean
48 name: savePersonWithPhotoAndFeatureMultiFaces original name: savePerson 
	param 0: bean class net.gdface.facelog.db.PersonBean
	param 1: idPhoto class java.nio.ByteBuffer
	param 2: feature class java.nio.ByteBuffer
	param 3: faceBeans java.util.List<net.gdface.facelog.db.FaceBean>
	return:class net.gdface.facelog.db.PersonBean
49 name: savePersonWithPhotoAndFeatureMultiImage original name: savePerson 
	param 0: bean class net.gdface.facelog.db.PersonBean
	param 1: idPhoto class java.nio.ByteBuffer
	param 2: feature class java.nio.ByteBuffer
	param 3: faceInfo java.util.Map<java.nio.ByteBuffer, net.gdface.facelog.db.FaceBean>
	param 4: deviceId class java.lang.Integer
	return:class net.gdface.facelog.db.PersonBean
50 name: savePersonWithPhotoAndFeatureSaved original name: savePerson 
	param 0: bean class net.gdface.facelog.db.PersonBean
	param 1: idPhotoMd5 class java.lang.String
	param 2: featureMd5 class java.lang.String
	return:class net.gdface.facelog.db.PersonBean
51 name: savePersonsWithPhoto original name: savePerson 
	param 0: persons java.util.Map<java.nio.ByteBuffer, net.gdface.facelog.db.PersonBean>
	return:class java.lang.Integer
52 name: setPersonExpiryDate 
	param 0: personId int
	param 1: expiryDate long
	return:void
53 name: setPersonExpiryDateList original name: setPersonExpiryDate 
	param 0: personIdList java.util.List<java.lang.Integer>
	param 1: expiryDate long
	return:void

*/

package net.gdface.facelog.client;
import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import static com.google.common.net.HostAndPort.fromParts;

public class IFaceLogClient implements Constant{
    private final ThriftClientManager clientManager = new ThriftClientManager();
    private final net.gdface.facelog.client.thrift.IFaceLog service;
    public IFaceLogClient(String host,int port){
        try{
            service = clientManager.createClient(
                    new FramedClientConnector(fromParts(host, port)),
                    net.gdface.facelog.client.thrift.IFaceLog.class).get();
		    } catch (Exception e) {
		    	throw new RuntimeException(e);
		    }
    }

    public FeatureBean addFeature(byte[] feature,int personId,java.util.List<FaceBean> faecBeans){
        return ThriftConverter.converterFeatureBean.fromRight(service.addFeature(feature,
                personId,
                ThriftConverter.converterFaceBean.toRight(faecBeans)));
    }

    public FeatureBean addFeature(byte[] feature,int personId,java.util.Map<java.nio.ByteBuffer, FaceBean> faceInfo,int deviceId){
        return ThriftConverter.converterFeatureBean.fromRight(service.addFeatureMulti(feature,
                personId,
                ThriftConverter.converterFaceBean.toRightValue(faceInfo),
                deviceId));
    }

    public ImageBean addImage(byte[] imageData,int deviceId,FaceBean faceBean,int personId){
        return ThriftConverter.converterImageBean.fromRight(service.addImage(imageData,
                deviceId,
                ThriftConverter.converterFaceBean.toRight(faceBean),
                personId));
    }

    public void addLog(LogBean bean){
        service.addLog(ThriftConverter.converterLogBean.toRight(bean));
    }

    public void addLog(java.util.List<LogBean> beans){
        service.addLogList(ThriftConverter.converterLogBean.toRight(beans));
    }

    public int countLogLightWhere(String where){
        return service.countLogLightWhere(where);
    }

    public int countLogWhere(String where){
        return service.countLogWhere(where);
    }

    public int deleteAllFeaturesByPersonId(int personId,boolean deleteImage){
        return service.deleteAllFeaturesByPersonId(personId,
                deleteImage);
    }

    public java.util.List<String> deleteFeature(String featureMd5,boolean deleteImage){
        return service.deleteFeature(featureMd5,
                deleteImage);
    }

    public int deleteImage(String imageMd5){
        return service.deleteImage(imageMd5);
    }

    public int deletePerson(int personId){
        return service.deletePerson(personId);
    }

    public int deletePersonByPapersNum(String papersNum){
        return service.deletePersonByPapersNum(papersNum);
    }

    public int deletePersons(java.util.List<Integer> personIdList){
        return service.deletePersons(personIdList);
    }

    public int deletePersonsByPapersNum(java.util.List<String> papersNumlist){
        return service.deletePersonsByPapersNum(papersNumlist);
    }

    public void disablePerson(int personId){
        service.disablePerson(personId);
    }

    public void disablePerson(java.util.List<Integer> personIdList){
        service.disablePersonList(personIdList);
    }

    public boolean existsDevice(int id){
        return service.existsDevice(id);
    }

    public boolean existsFeature(String md5){
        return service.existsFeature(md5);
    }

    public boolean existsImage(String md5){
        return service.existsImage(md5);
    }

    public boolean existsPerson(int persionId){
        return service.existsPerson(persionId);
    }

    public DeviceBean getDevice(int deviceId){
        return ThriftConverter.converterDeviceBean.fromRight(service.getDevice(deviceId));
    }

    public java.util.List<DeviceBean> getDevice(java.util.List<Integer> deviceId){
        return ThriftConverter.converterDeviceBean.fromRight(service.getDeviceList(deviceId));
    }

    public FeatureBean getFeature(String md5){
        return ThriftConverter.converterFeatureBean.fromRight(service.getFeature(md5));
    }

    public java.util.List<String> getFeatureBeansByPersonId(int personId){
        return service.getFeatureBeansByPersonId(personId);
    }

    public byte[] getFeatureBytes(String md5){
        return service.getFeatureBytes(md5);
    }

    public java.util.List<FeatureBean> getFeature(java.util.List<String> md5){
        return ThriftConverter.converterFeatureBean.fromRight(service.getFeatureList(md5));
    }

    public ImageBean getImage(String imageMD5){
        return ThriftConverter.converterImageBean.fromRight(service.getImage(imageMD5));
    }

    public byte[] getImageBytes(String imageMD5){
        return service.getImageBytes(imageMD5);
    }

    public java.util.List<String> getImagesAssociatedByFeature(String featureMd5){
        return service.getImagesAssociatedByFeature(featureMd5);
    }

    public java.util.List<LogBean> getLogBeansByPersonId(int personId){
        return ThriftConverter.converterLogBean.fromRight(service.getLogBeansByPersonId(personId));
    }

    public PersonBean getPerson(int personId){
        return ThriftConverter.converterPersonBean.fromRight(service.getPerson(personId));
    }

    public PersonBean getPersonByPapersNum(String papersNum){
        return ThriftConverter.converterPersonBean.fromRight(service.getPersonByPapersNum(papersNum));
    }

    public java.util.List<PersonBean> getPersons(java.util.List<Integer> idList){
        return ThriftConverter.converterPersonBean.fromRight(service.getPersons(idList));
    }

    public boolean isDisable(int personId){
        return service.isDisable(personId);
    }

    public java.util.List<Integer> loadAllPerson(){
        return service.loadAllPerson();
    }

    public java.util.List<String> loadFeatureMd5ByUpdate(long timestamp){
        return service.loadFeatureMd5ByUpdate(timestamp);
    }

    public java.util.List<LogBean> loadLogByWhere(String where,int startRow,int numRows){
        return ThriftConverter.converterLogBean.fromRight(service.loadLogByWhere(where,
                startRow,
                numRows));
    }

    public java.util.List<LogLightBean> loadLogLightByWhere(String where,int startRow,int numRows){
        return ThriftConverter.converterLogLightBean.fromRight(service.loadLogLightByWhere(where,
                startRow,
                numRows));
    }

    public java.util.List<Integer> loadPersonByWhere(String where){
        return service.loadPersonByWhere(where);
    }

    public java.util.List<Integer> loadPersonIdByUpdate(long timestamp){
        return service.loadPersonIdByUpdate(timestamp);
    }

    public java.util.List<Integer> loadUpdatePersons(long timestamp){
        return service.loadUpdatePersons(timestamp);
    }

    public void replaceFeature(int personId,String featureMd5,boolean deleteOldFeatureImage){
        service.replaceFeature(personId,
                featureMd5,
                deleteOldFeatureImage);
    }

    public DeviceBean saveDevice(DeviceBean deviceBean){
        return ThriftConverter.converterDeviceBean.fromRight(service.saveDevice(ThriftConverter.converterDeviceBean.toRight(deviceBean)));
    }

    public PersonBean savePerson(PersonBean bean){
        return ThriftConverter.converterPersonBean.fromRight(service.savePerson(ThriftConverter.converterPersonBean.toRight(bean)));
    }

    public PersonBean savePerson(PersonBean bean,byte[] idPhoto,byte[] feature,byte[] featureImage,FaceBean featureFaceBean,int deviceId){
        return ThriftConverter.converterPersonBean.fromRight(service.savePersonFull(ThriftConverter.converterPersonBean.toRight(bean),
                idPhoto,
                feature,
                featureImage,
                ThriftConverter.converterFaceBean.toRight(featureFaceBean),
                deviceId));
    }

    public void savePerson(java.util.List<PersonBean> beans){
        service.savePersonList(ThriftConverter.converterPersonBean.toRight(beans));
    }

    public int savePerson(java.util.Map<java.nio.ByteBuffer, PersonBean> persons){
        return service.savePersonsWithPhoto(ThriftConverter.converterPersonBean.toRightValue(persons));
    }

    public PersonBean savePerson(PersonBean bean,byte[] idPhoto){
        return ThriftConverter.converterPersonBean.fromRight(service.savePersonWithPhoto(ThriftConverter.converterPersonBean.toRight(bean),
                idPhoto));
    }

    public PersonBean savePerson(PersonBean bean,byte[] idPhoto,FeatureBean featureBean,int deviceId){
        return ThriftConverter.converterPersonBean.fromRight(service.savePersonWithPhotoAndFeature(ThriftConverter.converterPersonBean.toRight(bean),
                idPhoto,
                ThriftConverter.converterFeatureBean.toRight(featureBean),
                deviceId));
    }

    public PersonBean savePerson(PersonBean bean,byte[] idPhoto,byte[] feature,java.util.List<FaceBean> faceBeans){
        return ThriftConverter.converterPersonBean.fromRight(service.savePersonWithPhotoAndFeatureMultiFaces(ThriftConverter.converterPersonBean.toRight(bean),
                idPhoto,
                feature,
                ThriftConverter.converterFaceBean.toRight(faceBeans)));
    }

    public PersonBean savePerson(PersonBean bean,byte[] idPhoto,byte[] feature,java.util.Map<java.nio.ByteBuffer, FaceBean> faceInfo,int deviceId){
        return ThriftConverter.converterPersonBean.fromRight(service.savePersonWithPhotoAndFeatureMultiImage(ThriftConverter.converterPersonBean.toRight(bean),
                idPhoto,
                feature,
                ThriftConverter.converterFaceBean.toRightValue(faceInfo),
                deviceId));
    }

    public PersonBean savePerson(PersonBean bean,String idPhotoMd5,String featureMd5){
        return ThriftConverter.converterPersonBean.fromRight(service.savePersonWithPhotoAndFeatureSaved(ThriftConverter.converterPersonBean.toRight(bean),
                idPhotoMd5,
                featureMd5));
    }

    public void setPersonExpiryDate(int personId,long expiryDate){
        service.setPersonExpiryDate(personId,
                expiryDate);
    }

    public void setPersonExpiryDate(java.util.List<Integer> personIdList,long expiryDate){
        service.setPersonExpiryDateList(personIdList,
                expiryDate);
    }
}

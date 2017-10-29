// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: impl.dbconverter.java.vm
// ______________________________________________________
package net.gdface.facelog.db.mysql;

import java.util.Vector;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;

import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.DeviceGroupBean;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.JunctionDeviceGroupBean;
import net.gdface.facelog.db.JunctionPersonGroupBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.PersonGroupBean;
import net.gdface.facelog.db.StoreBean;
import net.gdface.facelog.db.LogLightBean;

/**
 * {@link IDbConverter} implemention for MySQL
 * @author guyadong
 *
 */
public class DbConverter implements IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.device.FlDeviceGroupBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.device.FlJunctionDeviceGroupBean,net.gdface.facelog.dborm.person.FlJunctionPersonGroupBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.person.FlPersonGroupBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.log.FlLogLightBean> {
    public static final IBeanConverter<DeviceBean,net.gdface.facelog.dborm.device.FlDeviceBean> converterDeviceBean=new IBeanConverter.AbstractHandle<DeviceBean,net.gdface.facelog.dborm.device.FlDeviceBean>(){

        @Override
        protected void _fromRight(DeviceBean left, net.gdface.facelog.dborm.device.FlDeviceBean right) {
            if(right.checkIdInitialized())
                left.setId(right.getId());
            if(right.checkNameInitialized())
                left.setName(right.getName());
            if(right.checkGroupIdInitialized())
                left.setGroupId(right.getGroupId());
            if(right.checkVersionInitialized())
                left.setVersion(right.getVersion());
            if(right.checkSerialNoInitialized())
                left.setSerialNo(right.getSerialNo());
            if(right.checkMacInitialized())
                left.setMac(right.getMac());
            if(right.checkCreateTimeInitialized())
                left.setCreateTime(right.getCreateTime());
            if(right.checkUpdateTimeInitialized())
                left.setUpdateTime(right.getUpdateTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(DeviceBean left, net.gdface.facelog.dborm.device.FlDeviceBean right) {
            if(left.checkIdInitialized() )
                right.setId(left.getId());
            if(left.checkNameInitialized() )
                right.setName(left.getName());
            if(left.checkGroupIdInitialized() )
                right.setGroupId(left.getGroupId());
            if(left.checkVersionInitialized() )
                right.setVersion(left.getVersion());
            if(left.checkSerialNoInitialized() )
                right.setSerialNo(left.getSerialNo());
            if(left.checkMacInitialized() )
                right.setMac(left.getMac());
// IGNORE field fl_device.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkCreateTimeInitialized() )
//                 right.setCreateTime(left.getCreateTime());
// IGNORE field fl_device.update_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkUpdateTimeInitialized() )
//                 right.setUpdateTime(left.getUpdateTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<DeviceGroupBean,net.gdface.facelog.dborm.device.FlDeviceGroupBean> converterDeviceGroupBean=new IBeanConverter.AbstractHandle<DeviceGroupBean,net.gdface.facelog.dborm.device.FlDeviceGroupBean>(){

        @Override
        protected void _fromRight(DeviceGroupBean left, net.gdface.facelog.dborm.device.FlDeviceGroupBean right) {
            if(right.checkIdInitialized())
                left.setId(right.getId());
            if(right.checkNameInitialized())
                left.setName(right.getName());
            if(right.checkParentInitialized())
                left.setParent(right.getParent());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(DeviceGroupBean left, net.gdface.facelog.dborm.device.FlDeviceGroupBean right) {
            if(left.checkIdInitialized() )
                right.setId(left.getId());
            if(left.checkNameInitialized() )
                right.setName(left.getName());
            if(left.checkParentInitialized() )
                right.setParent(left.getParent());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<FaceBean,net.gdface.facelog.dborm.face.FlFaceBean> converterFaceBean=new IBeanConverter.AbstractHandle<FaceBean,net.gdface.facelog.dborm.face.FlFaceBean>(){

        @Override
        protected void _fromRight(FaceBean left, net.gdface.facelog.dborm.face.FlFaceBean right) {
            if(right.checkIdInitialized())
                left.setId(right.getId());
            if(right.checkImageMd5Initialized())
                left.setImageMd5(right.getImageMd5());
            if(right.checkFaceLeftInitialized())
                left.setFaceLeft(right.getFaceLeft());
            if(right.checkFaceTopInitialized())
                left.setFaceTop(right.getFaceTop());
            if(right.checkFaceWidthInitialized())
                left.setFaceWidth(right.getFaceWidth());
            if(right.checkFaceHeightInitialized())
                left.setFaceHeight(right.getFaceHeight());
            if(right.checkEyeLeftxInitialized())
                left.setEyeLeftx(right.getEyeLeftx());
            if(right.checkEyeLeftyInitialized())
                left.setEyeLefty(right.getEyeLefty());
            if(right.checkEyeRightxInitialized())
                left.setEyeRightx(right.getEyeRightx());
            if(right.checkEyeRightyInitialized())
                left.setEyeRighty(right.getEyeRighty());
            if(right.checkMouthXInitialized())
                left.setMouthX(right.getMouthX());
            if(right.checkMouthYInitialized())
                left.setMouthY(right.getMouthY());
            if(right.checkNoseXInitialized())
                left.setNoseX(right.getNoseX());
            if(right.checkNoseYInitialized())
                left.setNoseY(right.getNoseY());
            if(right.checkAngleYawInitialized())
                left.setAngleYaw(right.getAngleYaw());
            if(right.checkAnglePitchInitialized())
                left.setAnglePitch(right.getAnglePitch());
            if(right.checkAngleRollInitialized())
                left.setAngleRoll(right.getAngleRoll());
            if(right.checkExtInfoInitialized())
                left.setExtInfo(right.getExtInfo());
            if(right.checkFeatureMd5Initialized())
                left.setFeatureMd5(right.getFeatureMd5());
            if(right.checkCreateTimeInitialized())
                left.setCreateTime(right.getCreateTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(FaceBean left, net.gdface.facelog.dborm.face.FlFaceBean right) {
            if(left.checkIdInitialized() )
                right.setId(left.getId());
            if(left.checkImageMd5Initialized() )
                right.setImageMd5(left.getImageMd5());
            if(left.checkFaceLeftInitialized() )
                right.setFaceLeft(left.getFaceLeft());
            if(left.checkFaceTopInitialized() )
                right.setFaceTop(left.getFaceTop());
            if(left.checkFaceWidthInitialized() )
                right.setFaceWidth(left.getFaceWidth());
            if(left.checkFaceHeightInitialized() )
                right.setFaceHeight(left.getFaceHeight());
            if(left.checkEyeLeftxInitialized() )
                right.setEyeLeftx(left.getEyeLeftx());
            if(left.checkEyeLeftyInitialized() )
                right.setEyeLefty(left.getEyeLefty());
            if(left.checkEyeRightxInitialized() )
                right.setEyeRightx(left.getEyeRightx());
            if(left.checkEyeRightyInitialized() )
                right.setEyeRighty(left.getEyeRighty());
            if(left.checkMouthXInitialized() )
                right.setMouthX(left.getMouthX());
            if(left.checkMouthYInitialized() )
                right.setMouthY(left.getMouthY());
            if(left.checkNoseXInitialized() )
                right.setNoseX(left.getNoseX());
            if(left.checkNoseYInitialized() )
                right.setNoseY(left.getNoseY());
            if(left.checkAngleYawInitialized() )
                right.setAngleYaw(left.getAngleYaw());
            if(left.checkAnglePitchInitialized() )
                right.setAnglePitch(left.getAnglePitch());
            if(left.checkAngleRollInitialized() )
                right.setAngleRoll(left.getAngleRoll());
            if(left.checkExtInfoInitialized() )
                right.setExtInfo(left.getExtInfo());
            if(left.checkFeatureMd5Initialized() )
                right.setFeatureMd5(left.getFeatureMd5());
// IGNORE field fl_face.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkCreateTimeInitialized() )
//                 right.setCreateTime(left.getCreateTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<FeatureBean,net.gdface.facelog.dborm.face.FlFeatureBean> converterFeatureBean=new IBeanConverter.AbstractHandle<FeatureBean,net.gdface.facelog.dborm.face.FlFeatureBean>(){

        @Override
        protected void _fromRight(FeatureBean left, net.gdface.facelog.dborm.face.FlFeatureBean right) {
            if(right.checkMd5Initialized())
                left.setMd5(right.getMd5());
            if(right.checkPersonIdInitialized())
                left.setPersonId(right.getPersonId());
            if(right.checkFeatureInitialized())
                left.setFeature(right.getFeature());
            if(right.checkUpdateTimeInitialized())
                left.setUpdateTime(right.getUpdateTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(FeatureBean left, net.gdface.facelog.dborm.face.FlFeatureBean right) {
            if(left.checkMd5Initialized() )
                right.setMd5(left.getMd5());
            if(left.checkPersonIdInitialized() )
                right.setPersonId(left.getPersonId());
            if(left.checkFeatureInitialized() )
                right.setFeature(left.getFeature());
// IGNORE field fl_feature.update_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkUpdateTimeInitialized() )
//                 right.setUpdateTime(left.getUpdateTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<ImageBean,net.gdface.facelog.dborm.image.FlImageBean> converterImageBean=new IBeanConverter.AbstractHandle<ImageBean,net.gdface.facelog.dborm.image.FlImageBean>(){

        @Override
        protected void _fromRight(ImageBean left, net.gdface.facelog.dborm.image.FlImageBean right) {
            if(right.checkMd5Initialized())
                left.setMd5(right.getMd5());
            if(right.checkFormatInitialized())
                left.setFormat(right.getFormat());
            if(right.checkWidthInitialized())
                left.setWidth(right.getWidth());
            if(right.checkHeightInitialized())
                left.setHeight(right.getHeight());
            if(right.checkDepthInitialized())
                left.setDepth(right.getDepth());
            if(right.checkFaceNumInitialized())
                left.setFaceNum(right.getFaceNum());
            if(right.checkThumbMd5Initialized())
                left.setThumbMd5(right.getThumbMd5());
            if(right.checkDeviceIdInitialized())
                left.setDeviceId(right.getDeviceId());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(ImageBean left, net.gdface.facelog.dborm.image.FlImageBean right) {
            if(left.checkMd5Initialized() )
                right.setMd5(left.getMd5());
            if(left.checkFormatInitialized() )
                right.setFormat(left.getFormat());
            if(left.checkWidthInitialized() )
                right.setWidth(left.getWidth());
            if(left.checkHeightInitialized() )
                right.setHeight(left.getHeight());
            if(left.checkDepthInitialized() )
                right.setDepth(left.getDepth());
            if(left.checkFaceNumInitialized() )
                right.setFaceNum(left.getFaceNum());
            if(left.checkThumbMd5Initialized() )
                right.setThumbMd5(left.getThumbMd5());
            if(left.checkDeviceIdInitialized() )
                right.setDeviceId(left.getDeviceId());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<JunctionDeviceGroupBean,net.gdface.facelog.dborm.device.FlJunctionDeviceGroupBean> converterJunctionDeviceGroupBean=new IBeanConverter.AbstractHandle<JunctionDeviceGroupBean,net.gdface.facelog.dborm.device.FlJunctionDeviceGroupBean>(){

        @Override
        protected void _fromRight(JunctionDeviceGroupBean left, net.gdface.facelog.dborm.device.FlJunctionDeviceGroupBean right) {
            if(right.checkDeviceIdInitialized())
                left.setDeviceId(right.getDeviceId());
            if(right.checkGroupIdInitialized())
                left.setGroupId(right.getGroupId());
            if(right.checkCreateTimeInitialized())
                left.setCreateTime(right.getCreateTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(JunctionDeviceGroupBean left, net.gdface.facelog.dborm.device.FlJunctionDeviceGroupBean right) {
            if(left.checkDeviceIdInitialized() )
                right.setDeviceId(left.getDeviceId());
            if(left.checkGroupIdInitialized() )
                right.setGroupId(left.getGroupId());
// IGNORE field fl_junction_device_group.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkCreateTimeInitialized() )
//                 right.setCreateTime(left.getCreateTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<JunctionPersonGroupBean,net.gdface.facelog.dborm.person.FlJunctionPersonGroupBean> converterJunctionPersonGroupBean=new IBeanConverter.AbstractHandle<JunctionPersonGroupBean,net.gdface.facelog.dborm.person.FlJunctionPersonGroupBean>(){

        @Override
        protected void _fromRight(JunctionPersonGroupBean left, net.gdface.facelog.dborm.person.FlJunctionPersonGroupBean right) {
            if(right.checkPersonIdInitialized())
                left.setPersonId(right.getPersonId());
            if(right.checkGroupIdInitialized())
                left.setGroupId(right.getGroupId());
            if(right.checkCreateTimeInitialized())
                left.setCreateTime(right.getCreateTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(JunctionPersonGroupBean left, net.gdface.facelog.dborm.person.FlJunctionPersonGroupBean right) {
            if(left.checkPersonIdInitialized() )
                right.setPersonId(left.getPersonId());
            if(left.checkGroupIdInitialized() )
                right.setGroupId(left.getGroupId());
// IGNORE field fl_junction_person_group.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkCreateTimeInitialized() )
//                 right.setCreateTime(left.getCreateTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<LogBean,net.gdface.facelog.dborm.log.FlLogBean> converterLogBean=new IBeanConverter.AbstractHandle<LogBean,net.gdface.facelog.dborm.log.FlLogBean>(){

        @Override
        protected void _fromRight(LogBean left, net.gdface.facelog.dborm.log.FlLogBean right) {
            if(right.checkIdInitialized())
                left.setId(right.getId());
            if(right.checkPersonIdInitialized())
                left.setPersonId(right.getPersonId());
            if(right.checkDeviceIdInitialized())
                left.setDeviceId(right.getDeviceId());
            if(right.checkVerifyFeatureInitialized())
                left.setVerifyFeature(right.getVerifyFeature());
            if(right.checkCompareFaceInitialized())
                left.setCompareFace(right.getCompareFace());
            if(right.checkSimilartyInitialized())
                left.setSimilarty(right.getSimilarty());
            if(right.checkVerifyTimeInitialized())
                left.setVerifyTime(right.getVerifyTime());
            if(right.checkCreateTimeInitialized())
                left.setCreateTime(right.getCreateTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(LogBean left, net.gdface.facelog.dborm.log.FlLogBean right) {
            if(left.checkIdInitialized() )
                right.setId(left.getId());
            if(left.checkPersonIdInitialized() )
                right.setPersonId(left.getPersonId());
            if(left.checkDeviceIdInitialized() )
                right.setDeviceId(left.getDeviceId());
            if(left.checkVerifyFeatureInitialized() )
                right.setVerifyFeature(left.getVerifyFeature());
            if(left.checkCompareFaceInitialized() )
                right.setCompareFace(left.getCompareFace());
            if(left.checkSimilartyInitialized() )
                right.setSimilarty(left.getSimilarty());
            if(left.checkVerifyTimeInitialized() )
                right.setVerifyTime(left.getVerifyTime());
// IGNORE field fl_log.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkCreateTimeInitialized() )
//                 right.setCreateTime(left.getCreateTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<PersonBean,net.gdface.facelog.dborm.person.FlPersonBean> converterPersonBean=new IBeanConverter.AbstractHandle<PersonBean,net.gdface.facelog.dborm.person.FlPersonBean>(){

        @Override
        protected void _fromRight(PersonBean left, net.gdface.facelog.dborm.person.FlPersonBean right) {
            if(right.checkIdInitialized())
                left.setId(right.getId());
            if(right.checkNameInitialized())
                left.setName(right.getName());
            if(right.checkSexInitialized())
                left.setSex(right.getSex());
            if(right.checkBirthdateInitialized())
                left.setBirthdate(right.getBirthdate());
            if(right.checkPapersTypeInitialized())
                left.setPapersType(right.getPapersType());
            if(right.checkPapersNumInitialized())
                left.setPapersNum(right.getPapersNum());
            if(right.checkImageMd5Initialized())
                left.setImageMd5(right.getImageMd5());
            if(right.checkExpiryDateInitialized())
                left.setExpiryDate(right.getExpiryDate());
            if(right.checkCreateTimeInitialized())
                left.setCreateTime(right.getCreateTime());
            if(right.checkUpdateTimeInitialized())
                left.setUpdateTime(right.getUpdateTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(PersonBean left, net.gdface.facelog.dborm.person.FlPersonBean right) {
            if(left.checkIdInitialized() )
                right.setId(left.getId());
            if(left.checkNameInitialized() )
                right.setName(left.getName());
            if(left.checkSexInitialized() )
                right.setSex(left.getSex());
            if(left.checkBirthdateInitialized() )
                right.setBirthdate(left.getBirthdate());
            if(left.checkPapersTypeInitialized() )
                right.setPapersType(left.getPapersType());
            if(left.checkPapersNumInitialized() )
                right.setPapersNum(left.getPapersNum());
            if(left.checkImageMd5Initialized() )
                right.setImageMd5(left.getImageMd5());
            if(left.checkExpiryDateInitialized() )
                right.setExpiryDate(left.getExpiryDate());
// IGNORE field fl_person.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkCreateTimeInitialized() )
//                 right.setCreateTime(left.getCreateTime());
// IGNORE field fl_person.update_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.checkUpdateTimeInitialized() )
//                 right.setUpdateTime(left.getUpdateTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<PersonGroupBean,net.gdface.facelog.dborm.person.FlPersonGroupBean> converterPersonGroupBean=new IBeanConverter.AbstractHandle<PersonGroupBean,net.gdface.facelog.dborm.person.FlPersonGroupBean>(){

        @Override
        protected void _fromRight(PersonGroupBean left, net.gdface.facelog.dborm.person.FlPersonGroupBean right) {
            if(right.checkIdInitialized())
                left.setId(right.getId());
            if(right.checkNameInitialized())
                left.setName(right.getName());
            if(right.checkParentInitialized())
                left.setParent(right.getParent());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(PersonGroupBean left, net.gdface.facelog.dborm.person.FlPersonGroupBean right) {
            if(left.checkIdInitialized() )
                right.setId(left.getId());
            if(left.checkNameInitialized() )
                right.setName(left.getName());
            if(left.checkParentInitialized() )
                right.setParent(left.getParent());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<StoreBean,net.gdface.facelog.dborm.image.FlStoreBean> converterStoreBean=new IBeanConverter.AbstractHandle<StoreBean,net.gdface.facelog.dborm.image.FlStoreBean>(){

        @Override
        protected void _fromRight(StoreBean left, net.gdface.facelog.dborm.image.FlStoreBean right) {
            if(right.checkMd5Initialized())
                left.setMd5(right.getMd5());
            if(right.checkEncodingInitialized())
                left.setEncoding(right.getEncoding());
            if(right.checkDataInitialized())
                left.setData(right.getData());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(StoreBean left, net.gdface.facelog.dborm.image.FlStoreBean right) {
            if(left.checkMd5Initialized() )
                right.setMd5(left.getMd5());
            if(left.checkEncodingInitialized() )
                right.setEncoding(left.getEncoding());
            if(left.checkDataInitialized() )
                right.setData(left.getData());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final IBeanConverter<LogLightBean,net.gdface.facelog.dborm.log.FlLogLightBean> converterLogLightBean=new IBeanConverter.AbstractHandle<LogLightBean,net.gdface.facelog.dborm.log.FlLogLightBean>(){

        @Override
        protected void _fromRight(LogLightBean left, net.gdface.facelog.dborm.log.FlLogLightBean right) {
            if(right.checkIdInitialized())
                left.setId(right.getId());
            if(right.checkPersonIdInitialized())
                left.setPersonId(right.getPersonId());
            if(right.checkNameInitialized())
                left.setName(right.getName());
            if(right.checkPapersTypeInitialized())
                left.setPapersType(right.getPapersType());
            if(right.checkPapersNumInitialized())
                left.setPapersNum(right.getPapersNum());
            if(right.checkVerifyTimeInitialized())
                left.setVerifyTime(right.getVerifyTime());
            left.setNew(right.isNew());
            left.setModified(right.getModified());
        }

        @Override
        protected void _toRight(LogLightBean left, net.gdface.facelog.dborm.log.FlLogLightBean right) {
            if(left.checkIdInitialized() )
                right.setId(left.getId());
            if(left.checkPersonIdInitialized() )
                right.setPersonId(left.getPersonId());
            if(left.checkNameInitialized() )
                right.setName(left.getName());
            if(left.checkPapersTypeInitialized() )
                right.setPapersType(left.getPapersType());
            if(left.checkPapersNumInitialized() )
                right.setPapersNum(left.getPapersNum());
            if(left.checkVerifyTimeInitialized() )
                right.setVerifyTime(left.getVerifyTime());
            right.setNew(left.isNew());
            right.setModified(left.getModified());
        }};
        
    public static final DbConverter INSTANCE = new DbConverter();
    protected DbConverter() {
    	
    }

    private static final Vector<Object[]> CONVERTERS= new Vector<Object[]>(){
        private static final long serialVersionUID = 1L;
        {
            add(new Object[]{DeviceBean.class, net.gdface.facelog.dborm.device.FlDeviceBean.class, converterDeviceBean});
            add(new Object[]{DeviceGroupBean.class, net.gdface.facelog.dborm.device.FlDeviceGroupBean.class, converterDeviceGroupBean});
            add(new Object[]{FaceBean.class, net.gdface.facelog.dborm.face.FlFaceBean.class, converterFaceBean});
            add(new Object[]{FeatureBean.class, net.gdface.facelog.dborm.face.FlFeatureBean.class, converterFeatureBean});
            add(new Object[]{ImageBean.class, net.gdface.facelog.dborm.image.FlImageBean.class, converterImageBean});
            add(new Object[]{JunctionDeviceGroupBean.class, net.gdface.facelog.dborm.device.FlJunctionDeviceGroupBean.class, converterJunctionDeviceGroupBean});
            add(new Object[]{JunctionPersonGroupBean.class, net.gdface.facelog.dborm.person.FlJunctionPersonGroupBean.class, converterJunctionPersonGroupBean});
            add(new Object[]{LogBean.class, net.gdface.facelog.dborm.log.FlLogBean.class, converterLogBean});
            add(new Object[]{PersonBean.class, net.gdface.facelog.dborm.person.FlPersonBean.class, converterPersonBean});
            add(new Object[]{PersonGroupBean.class, net.gdface.facelog.dborm.person.FlPersonGroupBean.class, converterPersonGroupBean});
            add(new Object[]{StoreBean.class, net.gdface.facelog.dborm.image.FlStoreBean.class, converterStoreBean});
            add(new Object[]{LogLightBean.class, net.gdface.facelog.dborm.log.FlLogLightBean.class, converterLogLightBean});
        }};
    
    private static final <L,R> int getIndex(Class<L> lClass,Class<R> rClass){
            Vector<Integer>find= new Vector<Integer>();
            if(null!=lClass && null != rClass){
                for(int i=0;i<CONVERTERS.size();++i){
                    Object[] converter = CONVERTERS.get(i);
                    if(((Class<?>)converter[0]).isAssignableFrom(lClass) 
                            && ((Class<?>)converter[1]).isAssignableFrom(rClass)){
                        return i;
                    }
                }
            }else if(null != lClass){
                for(int i=0;i<CONVERTERS.size();++i){
                    Object[] converter = CONVERTERS.get(i);
                    if(((Class<?>)converter[0]).isAssignableFrom(lClass) 
                            ){
                        find.add(i);
                    }
                }
            }else if(null != rClass){
                for(int i=0;i<CONVERTERS.size();++i){
                    Object[] converter = CONVERTERS.get(i);
                    if(((Class<?>)converter[1]).isAssignableFrom(rClass)){
                        find.add(i);
                    }
                }
            }
            return  1==find.size() ? find.get(0) : -1;
    }  
        
    @Override
    @SuppressWarnings("unchecked")
    public <L,R>IBeanConverter<L,R>getBeanConverter(Class<L> lClass,Class<R> rClass){
        int index = getIndex(lClass, rClass);
        if(index<0)
            throw new IllegalArgumentException(
                    String.format("not found converter for (%s,%s)"
                            ,null==lClass?"null":lClass.getSimpleName()
                            ,null==rClass?"null":rClass.getSimpleName()));
        return (IBeanConverter<L, R>) CONVERTERS.get(index)[2];
    }
    
    @Override
    public synchronized <L,R>void setBeanConverter(Class<L> lClass,Class<R> rClass,IBeanConverter<L,R>converter){
        if(null == lClass || null == rClass || null == converter)
            throw new NullPointerException();
        Object[] c = new Object[]{lClass,rClass,converter};
        int index = getIndex(lClass, rClass);
        if(index<0){
            CONVERTERS.add(c);
        }else{
            CONVERTERS.set(index, c);
        }
    }
    @Override
    public IBeanConverter<DeviceBean, net.gdface.facelog.dborm.device.FlDeviceBean> getDeviceBeanConverter() {
        return converterDeviceBean;
    }
    @Override
    public IBeanConverter<DeviceGroupBean, net.gdface.facelog.dborm.device.FlDeviceGroupBean> getDeviceGroupBeanConverter() {
        return converterDeviceGroupBean;
    }
    @Override
    public IBeanConverter<FaceBean, net.gdface.facelog.dborm.face.FlFaceBean> getFaceBeanConverter() {
        return converterFaceBean;
    }
    @Override
    public IBeanConverter<FeatureBean, net.gdface.facelog.dborm.face.FlFeatureBean> getFeatureBeanConverter() {
        return converterFeatureBean;
    }
    @Override
    public IBeanConverter<ImageBean, net.gdface.facelog.dborm.image.FlImageBean> getImageBeanConverter() {
        return converterImageBean;
    }
    @Override
    public IBeanConverter<JunctionDeviceGroupBean, net.gdface.facelog.dborm.device.FlJunctionDeviceGroupBean> getJunctionDeviceGroupBeanConverter() {
        return converterJunctionDeviceGroupBean;
    }
    @Override
    public IBeanConverter<JunctionPersonGroupBean, net.gdface.facelog.dborm.person.FlJunctionPersonGroupBean> getJunctionPersonGroupBeanConverter() {
        return converterJunctionPersonGroupBean;
    }
    @Override
    public IBeanConverter<LogBean, net.gdface.facelog.dborm.log.FlLogBean> getLogBeanConverter() {
        return converterLogBean;
    }
    @Override
    public IBeanConverter<PersonBean, net.gdface.facelog.dborm.person.FlPersonBean> getPersonBeanConverter() {
        return converterPersonBean;
    }
    @Override
    public IBeanConverter<PersonGroupBean, net.gdface.facelog.dborm.person.FlPersonGroupBean> getPersonGroupBeanConverter() {
        return converterPersonGroupBean;
    }
    @Override
    public IBeanConverter<StoreBean, net.gdface.facelog.dborm.image.FlStoreBean> getStoreBeanConverter() {
        return converterStoreBean;
    }
    @Override
    public IBeanConverter<LogLightBean, net.gdface.facelog.dborm.log.FlLogLightBean> getLogLightBeanConverter() {
        return converterLogLightBean;
    }
}

// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;

import java.util.Vector;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.BaseBean;

import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.StoreBean;
import net.gdface.facelog.db.FaceLightBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.LogLightBean;
import net.gdface.facelog.dborm.device.FlDeviceBeanBase;
import net.gdface.facelog.dborm.face.FlFaceBeanBase;
import net.gdface.facelog.dborm.image.FlImageBeanBase;
import net.gdface.facelog.dborm.log.FlLogBeanBase;
import net.gdface.facelog.dborm.person.FlPersonBeanBase;
import net.gdface.facelog.dborm.image.FlStoreBeanBase;
import net.gdface.facelog.dborm.face.FlFaceLightBeanBase;
import net.gdface.facelog.dborm.face.FlFeatureBeanBase;
import net.gdface.facelog.dborm.log.FlLogLightBeanBase;

public class DbConverter implements IDbConverter {
    public static final IBeanConverter<DeviceBean,FlDeviceBeanBase> _converterDeviceBean=new IBeanConverter.AbstractHandle<DeviceBean,FlDeviceBeanBase>(){

        @Override
        public DeviceBean fromNative(FlDeviceBeanBase bean) {
            DeviceBean generalBean= new DeviceBean();
            generalBean.isNew(bean.isNew());
            if(bean.getId() != null)
                generalBean.setId(bean.getId());
            if(bean.getName() != null)
                generalBean.setName(bean.getName());
            if(bean.getOnline() != null)
                generalBean.setOnline(bean.getOnline());
            if(bean.getGroupId() != null)
                generalBean.setGroupId(bean.getGroupId());
            if(bean.getVersion() != null)
                generalBean.setVersion(bean.getVersion());
            if(bean.getCreateTime() != null)
                generalBean.setCreateTime(bean.getCreateTime());
            if(bean.getUpdateTime() != null)
                generalBean.setUpdateTime(bean.getUpdateTime());
            return generalBean;
        }

        @Override
        public FlDeviceBeanBase toNative(DeviceBean bean) {
            net.gdface.facelog.dborm.device.FlDeviceBean nativeBean= new net.gdface.facelog.dborm.device.FlDeviceBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getId() != null)
                nativeBean.setId(bean.getId());
            if(bean.getName() != null)
                nativeBean.setName(bean.getName());
            if(bean.getOnline() != null)
                nativeBean.setOnline(bean.getOnline());
            if(bean.getGroupId() != null)
                nativeBean.setGroupId(bean.getGroupId());
            if(bean.getVersion() != null)
                nativeBean.setVersion(bean.getVersion());
// IGNORE field fl_device.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getCreateTime() != null)
//                 nativeBean.setCreateTime(bean.getCreateTime());
// IGNORE field fl_device.update_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getUpdateTime() != null)
//                 nativeBean.setUpdateTime(bean.getUpdateTime());
            return nativeBean;
        }};
        
    public static final IBeanConverter<FaceBean,FlFaceBeanBase> _converterFaceBean=new IBeanConverter.AbstractHandle<FaceBean,FlFaceBeanBase>(){

        @Override
        public FaceBean fromNative(FlFaceBeanBase bean) {
            FaceBean generalBean= new FaceBean();
            generalBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                generalBean.setMd5(bean.getMd5());
            if(bean.getPersonId() != null)
                generalBean.setPersonId(bean.getPersonId());
            if(bean.getImgMd5() != null)
                generalBean.setImgMd5(bean.getImgMd5());
            if(bean.getFaceLeft() != null)
                generalBean.setFaceLeft(bean.getFaceLeft());
            if(bean.getFaceTop() != null)
                generalBean.setFaceTop(bean.getFaceTop());
            if(bean.getFaceWidth() != null)
                generalBean.setFaceWidth(bean.getFaceWidth());
            if(bean.getFaceHeight() != null)
                generalBean.setFaceHeight(bean.getFaceHeight());
            if(bean.getEyeLeftx() != null)
                generalBean.setEyeLeftx(bean.getEyeLeftx());
            if(bean.getEyeLefty() != null)
                generalBean.setEyeLefty(bean.getEyeLefty());
            if(bean.getEyeRightx() != null)
                generalBean.setEyeRightx(bean.getEyeRightx());
            if(bean.getEyeRighty() != null)
                generalBean.setEyeRighty(bean.getEyeRighty());
            if(bean.getMouthX() != null)
                generalBean.setMouthX(bean.getMouthX());
            if(bean.getMouthY() != null)
                generalBean.setMouthY(bean.getMouthY());
            if(bean.getNoseX() != null)
                generalBean.setNoseX(bean.getNoseX());
            if(bean.getNoseY() != null)
                generalBean.setNoseY(bean.getNoseY());
            if(bean.getAngleYaw() != null)
                generalBean.setAngleYaw(bean.getAngleYaw());
            if(bean.getAnglePitch() != null)
                generalBean.setAnglePitch(bean.getAnglePitch());
            if(bean.getAngleRoll() != null)
                generalBean.setAngleRoll(bean.getAngleRoll());
            if(bean.getExtInfo() != null)
                generalBean.setExtInfo(bean.getExtInfo());
            if(bean.getFeature() != null)
                generalBean.setFeature(bean.getFeature());
            if(bean.getCreateTime() != null)
                generalBean.setCreateTime(bean.getCreateTime());
            return generalBean;
        }

        @Override
        public FlFaceBeanBase toNative(FaceBean bean) {
            net.gdface.facelog.dborm.face.FlFaceBean nativeBean= new net.gdface.facelog.dborm.face.FlFaceBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                nativeBean.setMd5(bean.getMd5());
            if(bean.getPersonId() != null)
                nativeBean.setPersonId(bean.getPersonId());
            if(bean.getImgMd5() != null)
                nativeBean.setImgMd5(bean.getImgMd5());
            if(bean.getFaceLeft() != null)
                nativeBean.setFaceLeft(bean.getFaceLeft());
            if(bean.getFaceTop() != null)
                nativeBean.setFaceTop(bean.getFaceTop());
            if(bean.getFaceWidth() != null)
                nativeBean.setFaceWidth(bean.getFaceWidth());
            if(bean.getFaceHeight() != null)
                nativeBean.setFaceHeight(bean.getFaceHeight());
            if(bean.getEyeLeftx() != null)
                nativeBean.setEyeLeftx(bean.getEyeLeftx());
            if(bean.getEyeLefty() != null)
                nativeBean.setEyeLefty(bean.getEyeLefty());
            if(bean.getEyeRightx() != null)
                nativeBean.setEyeRightx(bean.getEyeRightx());
            if(bean.getEyeRighty() != null)
                nativeBean.setEyeRighty(bean.getEyeRighty());
            if(bean.getMouthX() != null)
                nativeBean.setMouthX(bean.getMouthX());
            if(bean.getMouthY() != null)
                nativeBean.setMouthY(bean.getMouthY());
            if(bean.getNoseX() != null)
                nativeBean.setNoseX(bean.getNoseX());
            if(bean.getNoseY() != null)
                nativeBean.setNoseY(bean.getNoseY());
            if(bean.getAngleYaw() != null)
                nativeBean.setAngleYaw(bean.getAngleYaw());
            if(bean.getAnglePitch() != null)
                nativeBean.setAnglePitch(bean.getAnglePitch());
            if(bean.getAngleRoll() != null)
                nativeBean.setAngleRoll(bean.getAngleRoll());
            if(bean.getExtInfo() != null)
                nativeBean.setExtInfo(bean.getExtInfo());
            if(bean.getFeature() != null)
                nativeBean.setFeature(bean.getFeature());
// IGNORE field fl_face.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getCreateTime() != null)
//                 nativeBean.setCreateTime(bean.getCreateTime());
            return nativeBean;
        }};
        
    public static final IBeanConverter<ImageBean,FlImageBeanBase> _converterImageBean=new IBeanConverter.AbstractHandle<ImageBean,FlImageBeanBase>(){

        @Override
        public ImageBean fromNative(FlImageBeanBase bean) {
            ImageBean generalBean= new ImageBean();
            generalBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                generalBean.setMd5(bean.getMd5());
            if(bean.getFormat() != null)
                generalBean.setFormat(bean.getFormat());
            if(bean.getWidth() != null)
                generalBean.setWidth(bean.getWidth());
            if(bean.getHeight() != null)
                generalBean.setHeight(bean.getHeight());
            if(bean.getDepth() != null)
                generalBean.setDepth(bean.getDepth());
            if(bean.getFaceNum() != null)
                generalBean.setFaceNum(bean.getFaceNum());
            if(bean.getThumbMd5() != null)
                generalBean.setThumbMd5(bean.getThumbMd5());
            if(bean.getDeviceId() != null)
                generalBean.setDeviceId(bean.getDeviceId());
            return generalBean;
        }

        @Override
        public FlImageBeanBase toNative(ImageBean bean) {
            net.gdface.facelog.dborm.image.FlImageBean nativeBean= new net.gdface.facelog.dborm.image.FlImageBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                nativeBean.setMd5(bean.getMd5());
            if(bean.getFormat() != null)
                nativeBean.setFormat(bean.getFormat());
            if(bean.getWidth() != null)
                nativeBean.setWidth(bean.getWidth());
            if(bean.getHeight() != null)
                nativeBean.setHeight(bean.getHeight());
            if(bean.getDepth() != null)
                nativeBean.setDepth(bean.getDepth());
            if(bean.getFaceNum() != null)
                nativeBean.setFaceNum(bean.getFaceNum());
            if(bean.getThumbMd5() != null)
                nativeBean.setThumbMd5(bean.getThumbMd5());
            if(bean.getDeviceId() != null)
                nativeBean.setDeviceId(bean.getDeviceId());
            return nativeBean;
        }};
        
    public static final IBeanConverter<LogBean,FlLogBeanBase> _converterLogBean=new IBeanConverter.AbstractHandle<LogBean,FlLogBeanBase>(){

        @Override
        public LogBean fromNative(FlLogBeanBase bean) {
            LogBean generalBean= new LogBean();
            generalBean.isNew(bean.isNew());
            if(bean.getId() != null)
                generalBean.setId(bean.getId());
            if(bean.getPersonId() != null)
                generalBean.setPersonId(bean.getPersonId());
            if(bean.getDeviceId() != null)
                generalBean.setDeviceId(bean.getDeviceId());
            if(bean.getVerifyFace() != null)
                generalBean.setVerifyFace(bean.getVerifyFace());
            if(bean.getCompareFace() != null)
                generalBean.setCompareFace(bean.getCompareFace());
            if(bean.getSimilarty() != null)
                generalBean.setSimilarty(bean.getSimilarty());
            if(bean.getVerifyTime() != null)
                generalBean.setVerifyTime(bean.getVerifyTime());
            if(bean.getCreateTime() != null)
                generalBean.setCreateTime(bean.getCreateTime());
            return generalBean;
        }

        @Override
        public FlLogBeanBase toNative(LogBean bean) {
            net.gdface.facelog.dborm.log.FlLogBean nativeBean= new net.gdface.facelog.dborm.log.FlLogBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getId() != null)
                nativeBean.setId(bean.getId());
            if(bean.getPersonId() != null)
                nativeBean.setPersonId(bean.getPersonId());
            if(bean.getDeviceId() != null)
                nativeBean.setDeviceId(bean.getDeviceId());
            if(bean.getVerifyFace() != null)
                nativeBean.setVerifyFace(bean.getVerifyFace());
            if(bean.getCompareFace() != null)
                nativeBean.setCompareFace(bean.getCompareFace());
            if(bean.getSimilarty() != null)
                nativeBean.setSimilarty(bean.getSimilarty());
            if(bean.getVerifyTime() != null)
                nativeBean.setVerifyTime(bean.getVerifyTime());
// IGNORE field fl_log.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getCreateTime() != null)
//                 nativeBean.setCreateTime(bean.getCreateTime());
            return nativeBean;
        }};
        
    public static final IBeanConverter<PersonBean,FlPersonBeanBase> _converterPersonBean=new IBeanConverter.AbstractHandle<PersonBean,FlPersonBeanBase>(){

        @Override
        public PersonBean fromNative(FlPersonBeanBase bean) {
            PersonBean generalBean= new PersonBean();
            generalBean.isNew(bean.isNew());
            if(bean.getId() != null)
                generalBean.setId(bean.getId());
            if(bean.getGroupId() != null)
                generalBean.setGroupId(bean.getGroupId());
            if(bean.getName() != null)
                generalBean.setName(bean.getName());
            if(bean.getSex() != null)
                generalBean.setSex(bean.getSex());
            if(bean.getBirthdate() != null)
                generalBean.setBirthdate(bean.getBirthdate());
            if(bean.getPapersType() != null)
                generalBean.setPapersType(bean.getPapersType());
            if(bean.getPapersNum() != null)
                generalBean.setPapersNum(bean.getPapersNum());
            if(bean.getPhotoId() != null)
                generalBean.setPhotoId(bean.getPhotoId());
            if(bean.getFaceMd5() != null)
                generalBean.setFaceMd5(bean.getFaceMd5());
            if(bean.getExpiryDate() != null)
                generalBean.setExpiryDate(bean.getExpiryDate());
            if(bean.getCreateTime() != null)
                generalBean.setCreateTime(bean.getCreateTime());
            if(bean.getUpdateTime() != null)
                generalBean.setUpdateTime(bean.getUpdateTime());
            return generalBean;
        }

        @Override
        public FlPersonBeanBase toNative(PersonBean bean) {
            net.gdface.facelog.dborm.person.FlPersonBean nativeBean= new net.gdface.facelog.dborm.person.FlPersonBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getId() != null)
                nativeBean.setId(bean.getId());
            if(bean.getGroupId() != null)
                nativeBean.setGroupId(bean.getGroupId());
            if(bean.getName() != null)
                nativeBean.setName(bean.getName());
            if(bean.getSex() != null)
                nativeBean.setSex(bean.getSex());
            if(bean.getBirthdate() != null)
                nativeBean.setBirthdate(bean.getBirthdate());
            if(bean.getPapersType() != null)
                nativeBean.setPapersType(bean.getPapersType());
            if(bean.getPapersNum() != null)
                nativeBean.setPapersNum(bean.getPapersNum());
            if(bean.getPhotoId() != null)
                nativeBean.setPhotoId(bean.getPhotoId());
            if(bean.getFaceMd5() != null)
                nativeBean.setFaceMd5(bean.getFaceMd5());
            if(bean.getExpiryDate() != null)
                nativeBean.setExpiryDate(bean.getExpiryDate());
// IGNORE field fl_person.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getCreateTime() != null)
//                 nativeBean.setCreateTime(bean.getCreateTime());
// IGNORE field fl_person.update_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getUpdateTime() != null)
//                 nativeBean.setUpdateTime(bean.getUpdateTime());
            return nativeBean;
        }};
        
    public static final IBeanConverter<StoreBean,FlStoreBeanBase> _converterStoreBean=new IBeanConverter.AbstractHandle<StoreBean,FlStoreBeanBase>(){

        @Override
        public StoreBean fromNative(FlStoreBeanBase bean) {
            StoreBean generalBean= new StoreBean();
            generalBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                generalBean.setMd5(bean.getMd5());
            if(bean.getEncoding() != null)
                generalBean.setEncoding(bean.getEncoding());
            if(bean.getData() != null)
                generalBean.setData(bean.getData());
            return generalBean;
        }

        @Override
        public FlStoreBeanBase toNative(StoreBean bean) {
            net.gdface.facelog.dborm.image.FlStoreBean nativeBean= new net.gdface.facelog.dborm.image.FlStoreBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                nativeBean.setMd5(bean.getMd5());
            if(bean.getEncoding() != null)
                nativeBean.setEncoding(bean.getEncoding());
            if(bean.getData() != null)
                nativeBean.setData(bean.getData());
            return nativeBean;
        }};
        
    public static final IBeanConverter<FaceLightBean,FlFaceLightBeanBase> _converterFaceLightBean=new IBeanConverter.AbstractHandle<FaceLightBean,FlFaceLightBeanBase>(){

        @Override
        public FaceLightBean fromNative(FlFaceLightBeanBase bean) {
            FaceLightBean generalBean= new FaceLightBean();
            generalBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                generalBean.setMd5(bean.getMd5());
            if(bean.getPersonId() != null)
                generalBean.setPersonId(bean.getPersonId());
            if(bean.getImgMd5() != null)
                generalBean.setImgMd5(bean.getImgMd5());
            if(bean.getFaceLeft() != null)
                generalBean.setFaceLeft(bean.getFaceLeft());
            if(bean.getFaceTop() != null)
                generalBean.setFaceTop(bean.getFaceTop());
            if(bean.getFaceWidth() != null)
                generalBean.setFaceWidth(bean.getFaceWidth());
            if(bean.getFaceHeight() != null)
                generalBean.setFaceHeight(bean.getFaceHeight());
            if(bean.getEyeLeftx() != null)
                generalBean.setEyeLeftx(bean.getEyeLeftx());
            if(bean.getEyeLefty() != null)
                generalBean.setEyeLefty(bean.getEyeLefty());
            if(bean.getEyeRightx() != null)
                generalBean.setEyeRightx(bean.getEyeRightx());
            if(bean.getEyeRighty() != null)
                generalBean.setEyeRighty(bean.getEyeRighty());
            if(bean.getMouthX() != null)
                generalBean.setMouthX(bean.getMouthX());
            if(bean.getMouthY() != null)
                generalBean.setMouthY(bean.getMouthY());
            if(bean.getNoseX() != null)
                generalBean.setNoseX(bean.getNoseX());
            if(bean.getNoseY() != null)
                generalBean.setNoseY(bean.getNoseY());
            if(bean.getAngleYaw() != null)
                generalBean.setAngleYaw(bean.getAngleYaw());
            if(bean.getAnglePitch() != null)
                generalBean.setAnglePitch(bean.getAnglePitch());
            if(bean.getAngleRoll() != null)
                generalBean.setAngleRoll(bean.getAngleRoll());
            if(bean.getExtInfo() != null)
                generalBean.setExtInfo(bean.getExtInfo());
            if(bean.getCreateTime() != null)
                generalBean.setCreateTime(bean.getCreateTime());
            return generalBean;
        }

        @Override
        public FlFaceLightBeanBase toNative(FaceLightBean bean) {
            net.gdface.facelog.dborm.face.FlFaceLightBean nativeBean= new net.gdface.facelog.dborm.face.FlFaceLightBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                nativeBean.setMd5(bean.getMd5());
            if(bean.getPersonId() != null)
                nativeBean.setPersonId(bean.getPersonId());
            if(bean.getImgMd5() != null)
                nativeBean.setImgMd5(bean.getImgMd5());
            if(bean.getFaceLeft() != null)
                nativeBean.setFaceLeft(bean.getFaceLeft());
            if(bean.getFaceTop() != null)
                nativeBean.setFaceTop(bean.getFaceTop());
            if(bean.getFaceWidth() != null)
                nativeBean.setFaceWidth(bean.getFaceWidth());
            if(bean.getFaceHeight() != null)
                nativeBean.setFaceHeight(bean.getFaceHeight());
            if(bean.getEyeLeftx() != null)
                nativeBean.setEyeLeftx(bean.getEyeLeftx());
            if(bean.getEyeLefty() != null)
                nativeBean.setEyeLefty(bean.getEyeLefty());
            if(bean.getEyeRightx() != null)
                nativeBean.setEyeRightx(bean.getEyeRightx());
            if(bean.getEyeRighty() != null)
                nativeBean.setEyeRighty(bean.getEyeRighty());
            if(bean.getMouthX() != null)
                nativeBean.setMouthX(bean.getMouthX());
            if(bean.getMouthY() != null)
                nativeBean.setMouthY(bean.getMouthY());
            if(bean.getNoseX() != null)
                nativeBean.setNoseX(bean.getNoseX());
            if(bean.getNoseY() != null)
                nativeBean.setNoseY(bean.getNoseY());
            if(bean.getAngleYaw() != null)
                nativeBean.setAngleYaw(bean.getAngleYaw());
            if(bean.getAnglePitch() != null)
                nativeBean.setAnglePitch(bean.getAnglePitch());
            if(bean.getAngleRoll() != null)
                nativeBean.setAngleRoll(bean.getAngleRoll());
            if(bean.getExtInfo() != null)
                nativeBean.setExtInfo(bean.getExtInfo());
// IGNORE field fl_face_light.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getCreateTime() != null)
//                 nativeBean.setCreateTime(bean.getCreateTime());
            return nativeBean;
        }};
        
    public static final IBeanConverter<FeatureBean,FlFeatureBeanBase> _converterFeatureBean=new IBeanConverter.AbstractHandle<FeatureBean,FlFeatureBeanBase>(){

        @Override
        public FeatureBean fromNative(FlFeatureBeanBase bean) {
            FeatureBean generalBean= new FeatureBean();
            generalBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                generalBean.setMd5(bean.getMd5());
            if(bean.getPersonId() != null)
                generalBean.setPersonId(bean.getPersonId());
            if(bean.getImgMd5() != null)
                generalBean.setImgMd5(bean.getImgMd5());
            if(bean.getFeature() != null)
                generalBean.setFeature(bean.getFeature());
            if(bean.getCreateTime() != null)
                generalBean.setCreateTime(bean.getCreateTime());
            return generalBean;
        }

        @Override
        public FlFeatureBeanBase toNative(FeatureBean bean) {
            net.gdface.facelog.dborm.face.FlFeatureBean nativeBean= new net.gdface.facelog.dborm.face.FlFeatureBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getMd5() != null)
                nativeBean.setMd5(bean.getMd5());
            if(bean.getPersonId() != null)
                nativeBean.setPersonId(bean.getPersonId());
            if(bean.getImgMd5() != null)
                nativeBean.setImgMd5(bean.getImgMd5());
            if(bean.getFeature() != null)
                nativeBean.setFeature(bean.getFeature());
// IGNORE field fl_feature.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(bean.getCreateTime() != null)
//                 nativeBean.setCreateTime(bean.getCreateTime());
            return nativeBean;
        }};
        
    public static final IBeanConverter<LogLightBean,FlLogLightBeanBase> _converterLogLightBean=new IBeanConverter.AbstractHandle<LogLightBean,FlLogLightBeanBase>(){

        @Override
        public LogLightBean fromNative(FlLogLightBeanBase bean) {
            LogLightBean generalBean= new LogLightBean();
            generalBean.isNew(bean.isNew());
            if(bean.getId() != null)
                generalBean.setId(bean.getId());
            if(bean.getPersonId() != null)
                generalBean.setPersonId(bean.getPersonId());
            if(bean.getName() != null)
                generalBean.setName(bean.getName());
            if(bean.getPapersType() != null)
                generalBean.setPapersType(bean.getPapersType());
            if(bean.getPapersNum() != null)
                generalBean.setPapersNum(bean.getPapersNum());
            if(bean.getVerifyTime() != null)
                generalBean.setVerifyTime(bean.getVerifyTime());
            return generalBean;
        }

        @Override
        public FlLogLightBeanBase toNative(LogLightBean bean) {
            net.gdface.facelog.dborm.log.FlLogLightBean nativeBean= new net.gdface.facelog.dborm.log.FlLogLightBean();
            nativeBean.isNew(bean.isNew());
            if(bean.getId() != null)
                nativeBean.setId(bean.getId());
            if(bean.getPersonId() != null)
                nativeBean.setPersonId(bean.getPersonId());
            if(bean.getName() != null)
                nativeBean.setName(bean.getName());
            if(bean.getPapersType() != null)
                nativeBean.setPapersType(bean.getPapersType());
            if(bean.getPapersNum() != null)
                nativeBean.setPapersNum(bean.getPapersNum());
            if(bean.getVerifyTime() != null)
                nativeBean.setVerifyTime(bean.getVerifyTime());
            return nativeBean;
        }};
        

    private static final Vector<Object[]> converters= new Vector<Object[]>(){
        private static final long serialVersionUID = 1L;
        {
            add(new Object[]{DeviceBean.class,FlDeviceBeanBase.class,_converterDeviceBean});
            add(new Object[]{FaceBean.class,FlFaceBeanBase.class,_converterFaceBean});
            add(new Object[]{ImageBean.class,FlImageBeanBase.class,_converterImageBean});
            add(new Object[]{LogBean.class,FlLogBeanBase.class,_converterLogBean});
            add(new Object[]{PersonBean.class,FlPersonBeanBase.class,_converterPersonBean});
            add(new Object[]{StoreBean.class,FlStoreBeanBase.class,_converterStoreBean});
            add(new Object[]{FaceLightBean.class,FlFaceLightBeanBase.class,_converterFaceLightBean});
            add(new Object[]{FeatureBean.class,FlFeatureBeanBase.class,_converterFeatureBean});
            add(new Object[]{LogLightBean.class,FlLogLightBeanBase.class,_converterLogLightBean});
        }};
    
    private static final <G extends BaseBean,N> int getIndex(Class<G> gClass,Class<N> nClass){
            Vector<Integer>find= new Vector<Integer>();
            if(null!=gClass && null != nClass){
                for(int i=0;i<converters.size();++i){
                    Object[] converter = converters.get(i);
                    if(((Class<?>)converter[0]).isAssignableFrom(gClass) 
                            && ((Class<?>)converter[1]).isAssignableFrom(nClass)){
                        return i;
                    }
                }
            }else if(null != gClass){
                for(int i=0;i<converters.size();++i){
                    Object[] converter = converters.get(i);
                    if(((Class<?>)converter[0]).isAssignableFrom(gClass) 
                            ){
                        find.add(i);
                    }
                }
            }else if(null != nClass){
                for(int i=0;i<converters.size();++i){
                    Object[] converter = converters.get(i);
                    if(((Class<?>)converter[1]).isAssignableFrom(nClass)){
                        find.add(i);
                    }
                }
            }
            return  1==find.size() ? find.get(0) : -1;
    }  
        
    @Override
    @SuppressWarnings("unchecked")
    public <G extends BaseBean,N>IBeanConverter<G,N>getBeanConverter(Class<G> gClass,Class<N> nClass){
        int index = getIndex(gClass, nClass);
        if(index<0)
            throw new IllegalArgumentException(
                    String.format("not found converter for (%s,%s)"
                            ,null==gClass?"null":gClass.getSimpleName()
                            ,null==nClass?"null":nClass.getSimpleName()));
        return (IBeanConverter<G, N>) converters.get(index)[2];
    }
    
    @Override
    public synchronized <G extends BaseBean,N>void setBeanConverter(Class<G> gClass,Class<N> nClass,IBeanConverter<G,N>converter){
        if(null == gClass || null == nClass || null == converter)
            throw new NullPointerException();
        Object[] c = new Object[]{gClass,nClass,converter};
        int index = getIndex(gClass, nClass);
        if(index<0){
            converters.add(c);
        }else{
            converters.set(index, c);
        }
    }

    @Override
    public IBeanConverter<DeviceBean, FlDeviceBeanBase> getDeviceBeanConverter() {
        return _converterDeviceBean;
    }

    @Override
    public IBeanConverter<FaceBean, FlFaceBeanBase> getFaceBeanConverter() {
        return _converterFaceBean;
    }

    @Override
    public IBeanConverter<ImageBean, FlImageBeanBase> getImageBeanConverter() {
        return _converterImageBean;
    }

    @Override
    public IBeanConverter<LogBean, FlLogBeanBase> getLogBeanConverter() {
        return _converterLogBean;
    }

    @Override
    public IBeanConverter<PersonBean, FlPersonBeanBase> getPersonBeanConverter() {
        return _converterPersonBean;
    }

    @Override
    public IBeanConverter<StoreBean, FlStoreBeanBase> getStoreBeanConverter() {
        return _converterStoreBean;
    }

    @Override
    public IBeanConverter<FaceLightBean, FlFaceLightBeanBase> getFaceLightBeanConverter() {
        return _converterFaceLightBean;
    }

    @Override
    public IBeanConverter<FeatureBean, FlFeatureBeanBase> getFeatureBeanConverter() {
        return _converterFeatureBean;
    }

    @Override
    public IBeanConverter<LogLightBean, FlLogLightBeanBase> getLogLightBeanConverter() {
        return _converterLogLightBean;
    }
}

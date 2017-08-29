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

import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.StoreBean;
import net.gdface.facelog.db.FaceLightBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.LogLightBean;

/**
 * {@link IDbConverter} implemention for MySQL
 * @author guyadong
 *
 */
public class DbConverter implements IDbConverter {
    public static final IBeanConverter<DeviceBean,net.gdface.facelog.dborm.device.FlDeviceBean> _converterDeviceBean=new IBeanConverter.AbstractHandle<DeviceBean,net.gdface.facelog.dborm.device.FlDeviceBean>(){

        @Override
        protected DeviceBean _newInstanceL(){
            return new DeviceBean();
        }

        @Override
        protected net.gdface.facelog.dborm.device.FlDeviceBean _newInstanceR(){
            return new net.gdface.facelog.dborm.device.FlDeviceBean();
        }

        @Override
        protected void _fromRight(DeviceBean left, net.gdface.facelog.dborm.device.FlDeviceBean right) {
            left.isNew(right.isNew());
            if(right.getId() != null)
                left.setId(right.getId());
            if(right.getName() != null)
                left.setName(right.getName());
            if(right.getOnline() != null)
                left.setOnline(right.getOnline());
            if(right.getGroupId() != null)
                left.setGroupId(right.getGroupId());
            if(right.getVersion() != null)
                left.setVersion(right.getVersion());
            if(right.getCreateTime() != null)
                left.setCreateTime(right.getCreateTime());
            if(right.getUpdateTime() != null)
                left.setUpdateTime(right.getUpdateTime());
        }

        @Override
        protected void _toRight(DeviceBean left, net.gdface.facelog.dborm.device.FlDeviceBean right) {
            right.isNew(left.isNew());
            if(left.getId() != null)
                right.setId(left.getId());
            if(left.getName() != null)
                right.setName(left.getName());
            if(left.getOnline() != null)
                right.setOnline(left.getOnline());
            if(left.getGroupId() != null)
                right.setGroupId(left.getGroupId());
            if(left.getVersion() != null)
                right.setVersion(left.getVersion());
// IGNORE field fl_device.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getCreateTime() != null)
//                 right.setCreateTime(left.getCreateTime());
// IGNORE field fl_device.update_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getUpdateTime() != null)
//                 right.setUpdateTime(left.getUpdateTime());
        }};
        
    public static final IBeanConverter<FaceBean,net.gdface.facelog.dborm.face.FlFaceBean> _converterFaceBean=new IBeanConverter.AbstractHandle<FaceBean,net.gdface.facelog.dborm.face.FlFaceBean>(){

        @Override
        protected FaceBean _newInstanceL(){
            return new FaceBean();
        }

        @Override
        protected net.gdface.facelog.dborm.face.FlFaceBean _newInstanceR(){
            return new net.gdface.facelog.dborm.face.FlFaceBean();
        }

        @Override
        protected void _fromRight(FaceBean left, net.gdface.facelog.dborm.face.FlFaceBean right) {
            left.isNew(right.isNew());
            if(right.getMd5() != null)
                left.setMd5(right.getMd5());
            if(right.getPersonId() != null)
                left.setPersonId(right.getPersonId());
            if(right.getImgMd5() != null)
                left.setImgMd5(right.getImgMd5());
            if(right.getFaceLeft() != null)
                left.setFaceLeft(right.getFaceLeft());
            if(right.getFaceTop() != null)
                left.setFaceTop(right.getFaceTop());
            if(right.getFaceWidth() != null)
                left.setFaceWidth(right.getFaceWidth());
            if(right.getFaceHeight() != null)
                left.setFaceHeight(right.getFaceHeight());
            if(right.getEyeLeftx() != null)
                left.setEyeLeftx(right.getEyeLeftx());
            if(right.getEyeLefty() != null)
                left.setEyeLefty(right.getEyeLefty());
            if(right.getEyeRightx() != null)
                left.setEyeRightx(right.getEyeRightx());
            if(right.getEyeRighty() != null)
                left.setEyeRighty(right.getEyeRighty());
            if(right.getMouthX() != null)
                left.setMouthX(right.getMouthX());
            if(right.getMouthY() != null)
                left.setMouthY(right.getMouthY());
            if(right.getNoseX() != null)
                left.setNoseX(right.getNoseX());
            if(right.getNoseY() != null)
                left.setNoseY(right.getNoseY());
            if(right.getAngleYaw() != null)
                left.setAngleYaw(right.getAngleYaw());
            if(right.getAnglePitch() != null)
                left.setAnglePitch(right.getAnglePitch());
            if(right.getAngleRoll() != null)
                left.setAngleRoll(right.getAngleRoll());
            if(right.getExtInfo() != null)
                left.setExtInfo(right.getExtInfo());
            if(right.getFeature() != null)
                left.setFeature(right.getFeature());
            if(right.getCreateTime() != null)
                left.setCreateTime(right.getCreateTime());
        }

        @Override
        protected void _toRight(FaceBean left, net.gdface.facelog.dborm.face.FlFaceBean right) {
            right.isNew(left.isNew());
            if(left.getMd5() != null)
                right.setMd5(left.getMd5());
            if(left.getPersonId() != null)
                right.setPersonId(left.getPersonId());
            if(left.getImgMd5() != null)
                right.setImgMd5(left.getImgMd5());
            if(left.getFaceLeft() != null)
                right.setFaceLeft(left.getFaceLeft());
            if(left.getFaceTop() != null)
                right.setFaceTop(left.getFaceTop());
            if(left.getFaceWidth() != null)
                right.setFaceWidth(left.getFaceWidth());
            if(left.getFaceHeight() != null)
                right.setFaceHeight(left.getFaceHeight());
            if(left.getEyeLeftx() != null)
                right.setEyeLeftx(left.getEyeLeftx());
            if(left.getEyeLefty() != null)
                right.setEyeLefty(left.getEyeLefty());
            if(left.getEyeRightx() != null)
                right.setEyeRightx(left.getEyeRightx());
            if(left.getEyeRighty() != null)
                right.setEyeRighty(left.getEyeRighty());
            if(left.getMouthX() != null)
                right.setMouthX(left.getMouthX());
            if(left.getMouthY() != null)
                right.setMouthY(left.getMouthY());
            if(left.getNoseX() != null)
                right.setNoseX(left.getNoseX());
            if(left.getNoseY() != null)
                right.setNoseY(left.getNoseY());
            if(left.getAngleYaw() != null)
                right.setAngleYaw(left.getAngleYaw());
            if(left.getAnglePitch() != null)
                right.setAnglePitch(left.getAnglePitch());
            if(left.getAngleRoll() != null)
                right.setAngleRoll(left.getAngleRoll());
            if(left.getExtInfo() != null)
                right.setExtInfo(left.getExtInfo());
            if(left.getFeature() != null)
                right.setFeature(left.getFeature());
// IGNORE field fl_face.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getCreateTime() != null)
//                 right.setCreateTime(left.getCreateTime());
        }};
        
    public static final IBeanConverter<ImageBean,net.gdface.facelog.dborm.image.FlImageBean> _converterImageBean=new IBeanConverter.AbstractHandle<ImageBean,net.gdface.facelog.dborm.image.FlImageBean>(){

        @Override
        protected ImageBean _newInstanceL(){
            return new ImageBean();
        }

        @Override
        protected net.gdface.facelog.dborm.image.FlImageBean _newInstanceR(){
            return new net.gdface.facelog.dborm.image.FlImageBean();
        }

        @Override
        protected void _fromRight(ImageBean left, net.gdface.facelog.dborm.image.FlImageBean right) {
            left.isNew(right.isNew());
            if(right.getMd5() != null)
                left.setMd5(right.getMd5());
            if(right.getFormat() != null)
                left.setFormat(right.getFormat());
            if(right.getWidth() != null)
                left.setWidth(right.getWidth());
            if(right.getHeight() != null)
                left.setHeight(right.getHeight());
            if(right.getDepth() != null)
                left.setDepth(right.getDepth());
            if(right.getFaceNum() != null)
                left.setFaceNum(right.getFaceNum());
            if(right.getThumbMd5() != null)
                left.setThumbMd5(right.getThumbMd5());
            if(right.getDeviceId() != null)
                left.setDeviceId(right.getDeviceId());
        }

        @Override
        protected void _toRight(ImageBean left, net.gdface.facelog.dborm.image.FlImageBean right) {
            right.isNew(left.isNew());
            if(left.getMd5() != null)
                right.setMd5(left.getMd5());
            if(left.getFormat() != null)
                right.setFormat(left.getFormat());
            if(left.getWidth() != null)
                right.setWidth(left.getWidth());
            if(left.getHeight() != null)
                right.setHeight(left.getHeight());
            if(left.getDepth() != null)
                right.setDepth(left.getDepth());
            if(left.getFaceNum() != null)
                right.setFaceNum(left.getFaceNum());
            if(left.getThumbMd5() != null)
                right.setThumbMd5(left.getThumbMd5());
            if(left.getDeviceId() != null)
                right.setDeviceId(left.getDeviceId());
        }};
        
    public static final IBeanConverter<LogBean,net.gdface.facelog.dborm.log.FlLogBean> _converterLogBean=new IBeanConverter.AbstractHandle<LogBean,net.gdface.facelog.dborm.log.FlLogBean>(){

        @Override
        protected LogBean _newInstanceL(){
            return new LogBean();
        }

        @Override
        protected net.gdface.facelog.dborm.log.FlLogBean _newInstanceR(){
            return new net.gdface.facelog.dborm.log.FlLogBean();
        }

        @Override
        protected void _fromRight(LogBean left, net.gdface.facelog.dborm.log.FlLogBean right) {
            left.isNew(right.isNew());
            if(right.getId() != null)
                left.setId(right.getId());
            if(right.getPersonId() != null)
                left.setPersonId(right.getPersonId());
            if(right.getDeviceId() != null)
                left.setDeviceId(right.getDeviceId());
            if(right.getVerifyFace() != null)
                left.setVerifyFace(right.getVerifyFace());
            if(right.getCompareFace() != null)
                left.setCompareFace(right.getCompareFace());
            if(right.getSimilarty() != null)
                left.setSimilarty(right.getSimilarty());
            if(right.getVerifyTime() != null)
                left.setVerifyTime(right.getVerifyTime());
            if(right.getCreateTime() != null)
                left.setCreateTime(right.getCreateTime());
        }

        @Override
        protected void _toRight(LogBean left, net.gdface.facelog.dborm.log.FlLogBean right) {
            right.isNew(left.isNew());
            if(left.getId() != null)
                right.setId(left.getId());
            if(left.getPersonId() != null)
                right.setPersonId(left.getPersonId());
            if(left.getDeviceId() != null)
                right.setDeviceId(left.getDeviceId());
            if(left.getVerifyFace() != null)
                right.setVerifyFace(left.getVerifyFace());
            if(left.getCompareFace() != null)
                right.setCompareFace(left.getCompareFace());
            if(left.getSimilarty() != null)
                right.setSimilarty(left.getSimilarty());
            if(left.getVerifyTime() != null)
                right.setVerifyTime(left.getVerifyTime());
// IGNORE field fl_log.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getCreateTime() != null)
//                 right.setCreateTime(left.getCreateTime());
        }};
        
    public static final IBeanConverter<PersonBean,net.gdface.facelog.dborm.person.FlPersonBean> _converterPersonBean=new IBeanConverter.AbstractHandle<PersonBean,net.gdface.facelog.dborm.person.FlPersonBean>(){

        @Override
        protected PersonBean _newInstanceL(){
            return new PersonBean();
        }

        @Override
        protected net.gdface.facelog.dborm.person.FlPersonBean _newInstanceR(){
            return new net.gdface.facelog.dborm.person.FlPersonBean();
        }

        @Override
        protected void _fromRight(PersonBean left, net.gdface.facelog.dborm.person.FlPersonBean right) {
            left.isNew(right.isNew());
            if(right.getId() != null)
                left.setId(right.getId());
            if(right.getGroupId() != null)
                left.setGroupId(right.getGroupId());
            if(right.getName() != null)
                left.setName(right.getName());
            if(right.getSex() != null)
                left.setSex(right.getSex());
            if(right.getBirthdate() != null)
                left.setBirthdate(right.getBirthdate());
            if(right.getPapersType() != null)
                left.setPapersType(right.getPapersType());
            if(right.getPapersNum() != null)
                left.setPapersNum(right.getPapersNum());
            if(right.getPhotoId() != null)
                left.setPhotoId(right.getPhotoId());
            if(right.getFaceMd5() != null)
                left.setFaceMd5(right.getFaceMd5());
            if(right.getExpiryDate() != null)
                left.setExpiryDate(right.getExpiryDate());
            if(right.getCreateTime() != null)
                left.setCreateTime(right.getCreateTime());
            if(right.getUpdateTime() != null)
                left.setUpdateTime(right.getUpdateTime());
        }

        @Override
        protected void _toRight(PersonBean left, net.gdface.facelog.dborm.person.FlPersonBean right) {
            right.isNew(left.isNew());
            if(left.getId() != null)
                right.setId(left.getId());
            if(left.getGroupId() != null)
                right.setGroupId(left.getGroupId());
            if(left.getName() != null)
                right.setName(left.getName());
            if(left.getSex() != null)
                right.setSex(left.getSex());
            if(left.getBirthdate() != null)
                right.setBirthdate(left.getBirthdate());
            if(left.getPapersType() != null)
                right.setPapersType(left.getPapersType());
            if(left.getPapersNum() != null)
                right.setPapersNum(left.getPapersNum());
            if(left.getPhotoId() != null)
                right.setPhotoId(left.getPhotoId());
            if(left.getFaceMd5() != null)
                right.setFaceMd5(left.getFaceMd5());
            if(left.getExpiryDate() != null)
                right.setExpiryDate(left.getExpiryDate());
// IGNORE field fl_person.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getCreateTime() != null)
//                 right.setCreateTime(left.getCreateTime());
// IGNORE field fl_person.update_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getUpdateTime() != null)
//                 right.setUpdateTime(left.getUpdateTime());
        }};
        
    public static final IBeanConverter<StoreBean,net.gdface.facelog.dborm.image.FlStoreBean> _converterStoreBean=new IBeanConverter.AbstractHandle<StoreBean,net.gdface.facelog.dborm.image.FlStoreBean>(){

        @Override
        protected StoreBean _newInstanceL(){
            return new StoreBean();
        }

        @Override
        protected net.gdface.facelog.dborm.image.FlStoreBean _newInstanceR(){
            return new net.gdface.facelog.dborm.image.FlStoreBean();
        }

        @Override
        protected void _fromRight(StoreBean left, net.gdface.facelog.dborm.image.FlStoreBean right) {
            left.isNew(right.isNew());
            if(right.getMd5() != null)
                left.setMd5(right.getMd5());
            if(right.getEncoding() != null)
                left.setEncoding(right.getEncoding());
            if(right.getData() != null)
                left.setData(right.getData());
        }

        @Override
        protected void _toRight(StoreBean left, net.gdface.facelog.dborm.image.FlStoreBean right) {
            right.isNew(left.isNew());
            if(left.getMd5() != null)
                right.setMd5(left.getMd5());
            if(left.getEncoding() != null)
                right.setEncoding(left.getEncoding());
            if(left.getData() != null)
                right.setData(left.getData());
        }};
        
    public static final IBeanConverter<FaceLightBean,net.gdface.facelog.dborm.face.FlFaceLightBean> _converterFaceLightBean=new IBeanConverter.AbstractHandle<FaceLightBean,net.gdface.facelog.dborm.face.FlFaceLightBean>(){

        @Override
        protected FaceLightBean _newInstanceL(){
            return new FaceLightBean();
        }

        @Override
        protected net.gdface.facelog.dborm.face.FlFaceLightBean _newInstanceR(){
            return new net.gdface.facelog.dborm.face.FlFaceLightBean();
        }

        @Override
        protected void _fromRight(FaceLightBean left, net.gdface.facelog.dborm.face.FlFaceLightBean right) {
            left.isNew(right.isNew());
            if(right.getMd5() != null)
                left.setMd5(right.getMd5());
            if(right.getPersonId() != null)
                left.setPersonId(right.getPersonId());
            if(right.getImgMd5() != null)
                left.setImgMd5(right.getImgMd5());
            if(right.getFaceLeft() != null)
                left.setFaceLeft(right.getFaceLeft());
            if(right.getFaceTop() != null)
                left.setFaceTop(right.getFaceTop());
            if(right.getFaceWidth() != null)
                left.setFaceWidth(right.getFaceWidth());
            if(right.getFaceHeight() != null)
                left.setFaceHeight(right.getFaceHeight());
            if(right.getEyeLeftx() != null)
                left.setEyeLeftx(right.getEyeLeftx());
            if(right.getEyeLefty() != null)
                left.setEyeLefty(right.getEyeLefty());
            if(right.getEyeRightx() != null)
                left.setEyeRightx(right.getEyeRightx());
            if(right.getEyeRighty() != null)
                left.setEyeRighty(right.getEyeRighty());
            if(right.getMouthX() != null)
                left.setMouthX(right.getMouthX());
            if(right.getMouthY() != null)
                left.setMouthY(right.getMouthY());
            if(right.getNoseX() != null)
                left.setNoseX(right.getNoseX());
            if(right.getNoseY() != null)
                left.setNoseY(right.getNoseY());
            if(right.getAngleYaw() != null)
                left.setAngleYaw(right.getAngleYaw());
            if(right.getAnglePitch() != null)
                left.setAnglePitch(right.getAnglePitch());
            if(right.getAngleRoll() != null)
                left.setAngleRoll(right.getAngleRoll());
            if(right.getExtInfo() != null)
                left.setExtInfo(right.getExtInfo());
            if(right.getCreateTime() != null)
                left.setCreateTime(right.getCreateTime());
        }

        @Override
        protected void _toRight(FaceLightBean left, net.gdface.facelog.dborm.face.FlFaceLightBean right) {
            right.isNew(left.isNew());
            if(left.getMd5() != null)
                right.setMd5(left.getMd5());
            if(left.getPersonId() != null)
                right.setPersonId(left.getPersonId());
            if(left.getImgMd5() != null)
                right.setImgMd5(left.getImgMd5());
            if(left.getFaceLeft() != null)
                right.setFaceLeft(left.getFaceLeft());
            if(left.getFaceTop() != null)
                right.setFaceTop(left.getFaceTop());
            if(left.getFaceWidth() != null)
                right.setFaceWidth(left.getFaceWidth());
            if(left.getFaceHeight() != null)
                right.setFaceHeight(left.getFaceHeight());
            if(left.getEyeLeftx() != null)
                right.setEyeLeftx(left.getEyeLeftx());
            if(left.getEyeLefty() != null)
                right.setEyeLefty(left.getEyeLefty());
            if(left.getEyeRightx() != null)
                right.setEyeRightx(left.getEyeRightx());
            if(left.getEyeRighty() != null)
                right.setEyeRighty(left.getEyeRighty());
            if(left.getMouthX() != null)
                right.setMouthX(left.getMouthX());
            if(left.getMouthY() != null)
                right.setMouthY(left.getMouthY());
            if(left.getNoseX() != null)
                right.setNoseX(left.getNoseX());
            if(left.getNoseY() != null)
                right.setNoseY(left.getNoseY());
            if(left.getAngleYaw() != null)
                right.setAngleYaw(left.getAngleYaw());
            if(left.getAnglePitch() != null)
                right.setAnglePitch(left.getAnglePitch());
            if(left.getAngleRoll() != null)
                right.setAngleRoll(left.getAngleRoll());
            if(left.getExtInfo() != null)
                right.setExtInfo(left.getExtInfo());
// IGNORE field fl_face_light.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getCreateTime() != null)
//                 right.setCreateTime(left.getCreateTime());
        }};
        
    public static final IBeanConverter<FeatureBean,net.gdface.facelog.dborm.face.FlFeatureBean> _converterFeatureBean=new IBeanConverter.AbstractHandle<FeatureBean,net.gdface.facelog.dborm.face.FlFeatureBean>(){

        @Override
        protected FeatureBean _newInstanceL(){
            return new FeatureBean();
        }

        @Override
        protected net.gdface.facelog.dborm.face.FlFeatureBean _newInstanceR(){
            return new net.gdface.facelog.dborm.face.FlFeatureBean();
        }

        @Override
        protected void _fromRight(FeatureBean left, net.gdface.facelog.dborm.face.FlFeatureBean right) {
            left.isNew(right.isNew());
            if(right.getMd5() != null)
                left.setMd5(right.getMd5());
            if(right.getPersonId() != null)
                left.setPersonId(right.getPersonId());
            if(right.getImgMd5() != null)
                left.setImgMd5(right.getImgMd5());
            if(right.getFeature() != null)
                left.setFeature(right.getFeature());
            if(right.getCreateTime() != null)
                left.setCreateTime(right.getCreateTime());
        }

        @Override
        protected void _toRight(FeatureBean left, net.gdface.facelog.dborm.face.FlFeatureBean right) {
            right.isNew(left.isNew());
            if(left.getMd5() != null)
                right.setMd5(left.getMd5());
            if(left.getPersonId() != null)
                right.setPersonId(left.getPersonId());
            if(left.getImgMd5() != null)
                right.setImgMd5(left.getImgMd5());
            if(left.getFeature() != null)
                right.setFeature(left.getFeature());
// IGNORE field fl_feature.create_time , controlled by 'general.beanconverter.tonative.ignore' in properties file
//             if(left.getCreateTime() != null)
//                 right.setCreateTime(left.getCreateTime());
        }};
        
    public static final IBeanConverter<LogLightBean,net.gdface.facelog.dborm.log.FlLogLightBean> _converterLogLightBean=new IBeanConverter.AbstractHandle<LogLightBean,net.gdface.facelog.dborm.log.FlLogLightBean>(){

        @Override
        protected LogLightBean _newInstanceL(){
            return new LogLightBean();
        }

        @Override
        protected net.gdface.facelog.dborm.log.FlLogLightBean _newInstanceR(){
            return new net.gdface.facelog.dborm.log.FlLogLightBean();
        }

        @Override
        protected void _fromRight(LogLightBean left, net.gdface.facelog.dborm.log.FlLogLightBean right) {
            left.isNew(right.isNew());
            if(right.getId() != null)
                left.setId(right.getId());
            if(right.getPersonId() != null)
                left.setPersonId(right.getPersonId());
            if(right.getName() != null)
                left.setName(right.getName());
            if(right.getPapersType() != null)
                left.setPapersType(right.getPapersType());
            if(right.getPapersNum() != null)
                left.setPapersNum(right.getPapersNum());
            if(right.getVerifyTime() != null)
                left.setVerifyTime(right.getVerifyTime());
        }

        @Override
        protected void _toRight(LogLightBean left, net.gdface.facelog.dborm.log.FlLogLightBean right) {
            right.isNew(left.isNew());
            if(left.getId() != null)
                right.setId(left.getId());
            if(left.getPersonId() != null)
                right.setPersonId(left.getPersonId());
            if(left.getName() != null)
                right.setName(left.getName());
            if(left.getPapersType() != null)
                right.setPapersType(left.getPapersType());
            if(left.getPapersNum() != null)
                right.setPapersNum(left.getPapersNum());
            if(left.getVerifyTime() != null)
                right.setVerifyTime(left.getVerifyTime());
        }};
        
    public static final DbConverter INSTANCE = new DbConverter();
    protected DbConverter() {
    	
    }

    private static final Vector<Object[]> converters= new Vector<Object[]>(){
        private static final long serialVersionUID = 1L;
        {
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
            add(new Object[]{LogLightBean.class,net.gdface.facelog.dborm.log.FlLogLightBean.class,_converterLogLightBean});
        }};
    
    private static final <L,R> int getIndex(Class<L> lClass,Class<R> rClass){
            Vector<Integer>find= new Vector<Integer>();
            if(null!=lClass && null != rClass){
                for(int i=0;i<converters.size();++i){
                    Object[] converter = converters.get(i);
                    if(((Class<?>)converter[0]).isAssignableFrom(lClass) 
                            && ((Class<?>)converter[1]).isAssignableFrom(rClass)){
                        return i;
                    }
                }
            }else if(null != lClass){
                for(int i=0;i<converters.size();++i){
                    Object[] converter = converters.get(i);
                    if(((Class<?>)converter[0]).isAssignableFrom(lClass) 
                            ){
                        find.add(i);
                    }
                }
            }else if(null != rClass){
                for(int i=0;i<converters.size();++i){
                    Object[] converter = converters.get(i);
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
        return (IBeanConverter<L, R>) converters.get(index)[2];
    }
    
    @Override
    public synchronized <L,R>void setBeanConverter(Class<L> lClass,Class<R> rClass,IBeanConverter<L,R>converter){
        if(null == lClass || null == rClass || null == converter)
            throw new NullPointerException();
        Object[] c = new Object[]{lClass,rClass,converter};
        int index = getIndex(lClass, rClass);
        if(index<0){
            converters.add(c);
        }else{
            converters.set(index, c);
        }
    }
    @Override
    public IBeanConverter<DeviceBean, net.gdface.facelog.dborm.device.FlDeviceBean> getDeviceBeanConverter() {
        return _converterDeviceBean;
    }
    @Override
    public IBeanConverter<FaceBean, net.gdface.facelog.dborm.face.FlFaceBean> getFaceBeanConverter() {
        return _converterFaceBean;
    }
    @Override
    public IBeanConverter<ImageBean, net.gdface.facelog.dborm.image.FlImageBean> getImageBeanConverter() {
        return _converterImageBean;
    }
    @Override
    public IBeanConverter<LogBean, net.gdface.facelog.dborm.log.FlLogBean> getLogBeanConverter() {
        return _converterLogBean;
    }
    @Override
    public IBeanConverter<PersonBean, net.gdface.facelog.dborm.person.FlPersonBean> getPersonBeanConverter() {
        return _converterPersonBean;
    }
    @Override
    public IBeanConverter<StoreBean, net.gdface.facelog.dborm.image.FlStoreBean> getStoreBeanConverter() {
        return _converterStoreBean;
    }
    @Override
    public IBeanConverter<FaceLightBean, net.gdface.facelog.dborm.face.FlFaceLightBean> getFaceLightBeanConverter() {
        return _converterFaceLightBean;
    }
    @Override
    public IBeanConverter<FeatureBean, net.gdface.facelog.dborm.face.FlFeatureBean> getFeatureBeanConverter() {
        return _converterFeatureBean;
    }
    @Override
    public IBeanConverter<LogLightBean, net.gdface.facelog.dborm.log.FlLogLightBean> getLogLightBeanConverter() {
        return _converterLogLightBean;
    }
}

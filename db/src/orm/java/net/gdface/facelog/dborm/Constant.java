// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.dborm;
/**
 * constant declare
 * @author guyadong
 */
public interface Constant {    

    /** set =QUERY for loadUsingTemplate */
    public static final int SEARCH_EXACT = 0;
    /** set %QUERY% for loadLikeTemplate */
    public static final int SEARCH_LIKE = 1;
    /** set %QUERY for loadLikeTemplate */
    public static final int SEARCH_STARTING_LIKE = 2;
    /** set QUERY% for loadLikeTemplate */
    public static final int SEARCH_ENDING_LIKE = 3;
    
    //////////////////////////////////////
    // FOREIGN KEY INDEX DECLARE
    //////////////////////////////////////    
    /** foreign key fl_face(img_md5) -> fl_image */
    public static final int FL_FACE_FK_IMG_MD5 = 0;
    /** foreign key fl_face(person_id) -> fl_person */
    public static final int FL_FACE_FK_PERSON_ID = 1;
    /** foreign key fl_image(device_id) -> fl_device */
    public static final int FL_IMAGE_FK_DEVICE_ID = 0;
    /** foreign key fl_image(md5) -> fl_store */
    public static final int FL_IMAGE_FK_MD5 = 1;
    /** foreign key fl_image(thumb_md5) -> fl_store */
    public static final int FL_IMAGE_FK_THUMB_MD5 = 2;
    /** foreign key fl_log(device_id) -> fl_device */
    public static final int FL_LOG_FK_DEVICE_ID = 0;
    /** foreign key fl_log(verify_face) -> fl_face */
    public static final int FL_LOG_FK_VERIFY_FACE = 1;
    /** foreign key fl_log(compare_face) -> fl_face */
    public static final int FL_LOG_FK_COMPARE_FACE = 2;
    /** foreign key fl_log(person_id) -> fl_person */
    public static final int FL_LOG_FK_PERSON_ID = 3;
    /** foreign key fl_person(photo_id) -> fl_image */
    public static final int FL_PERSON_FK_PHOTO_ID = 0;
    //////////////////////////////////////
    // IMPORTED KEY INDEX DECLARE
    //////////////////////////////////////    
    /** imported key fl_image(device_id) -> fl_device */
    public static final int FL_DEVICE_IK_FL_IMAGE_DEVICE_ID = 0;
    /** imported key fl_log(device_id) -> fl_device */
    public static final int FL_DEVICE_IK_FL_LOG_DEVICE_ID = 1;
    /** imported key fl_log(verify_face) -> fl_face */
    public static final int FL_FACE_IK_FL_LOG_VERIFY_FACE = 0;
    /** imported key fl_log(compare_face) -> fl_face */
    public static final int FL_FACE_IK_FL_LOG_COMPARE_FACE = 1;
    /** imported key fl_face(img_md5) -> fl_image */
    public static final int FL_IMAGE_IK_FL_FACE_IMG_MD5 = 0;
    /** imported key fl_person(photo_id) -> fl_image */
    public static final int FL_IMAGE_IK_FL_PERSON_PHOTO_ID = 1;
    /** imported key fl_face(person_id) -> fl_person */
    public static final int FL_PERSON_IK_FL_FACE_PERSON_ID = 0;
    /** imported key fl_log(person_id) -> fl_person */
    public static final int FL_PERSON_IK_FL_LOG_PERSON_ID = 1;
    /** imported key fl_image(md5) -> fl_store */
    public static final int FL_STORE_IK_FL_IMAGE_MD5 = 0;
    /** imported key fl_image(thumb_md5) -> fl_store */
    public static final int FL_STORE_IK_FL_IMAGE_THUMB_MD5 = 1;
    //////////////////////////////////////
    // INDEX INDEX DECLARE
    //////////////////////////////////////    
    /** fl_face index (img_md5) */
    public static final int FL_FACE_INDEX_IMG_MD5 = 0;
    /** fl_face index (person_id) */
    public static final int FL_FACE_INDEX_PERSON_ID = 1;
    /** fl_image index (device_id) */
    public static final int FL_IMAGE_INDEX_DEVICE_ID = 0;
    /** fl_image index (thumb_md5) */
    public static final int FL_IMAGE_INDEX_THUMB_MD5 = 1;
    /** fl_log index (compare_face) */
    public static final int FL_LOG_INDEX_COMPARE_FACE = 0;
    /** fl_log index (device_id) */
    public static final int FL_LOG_INDEX_DEVICE_ID = 1;
    /** fl_log index (person_id) */
    public static final int FL_LOG_INDEX_PERSON_ID = 2;
    /** fl_log index (verify_face) */
    public static final int FL_LOG_INDEX_VERIFY_FACE = 3;
    /** fl_person index (face_md5) */
    public static final int FL_PERSON_INDEX_FACE_MD5 = 0;
    /** fl_person index (papers_num) */
    public static final int FL_PERSON_INDEX_PAPERS_NUM = 1;
    /** fl_person index (photo_id) */
    public static final int FL_PERSON_INDEX_PHOTO_ID = 2;
    /** fl_person index (expiry_date) */
    public static final int FL_PERSON_INDEX_EXPIRY_DATE = 3;
    //////////////////////////////////////
    // COLUMN ID DECLARE
    //////////////////////////////////////    
    /** Identify the fl_device.id field . */
    public static final int FL_DEVICE_ID_ID = 0;
    /** Identify the fl_device.name field . */
    public static final int FL_DEVICE_ID_NAME = 1;
    /** Identify the fl_device.online field . */
    public static final int FL_DEVICE_ID_ONLINE = 2;
    /** Identify the fl_device.group_id field . */
    public static final int FL_DEVICE_ID_GROUP_ID = 3;
    /** Identify the fl_device.version field . */
    public static final int FL_DEVICE_ID_VERSION = 4;
    /** Identify the fl_device.create_time field . */
    public static final int FL_DEVICE_ID_CREATE_TIME = 5;
    /** Identify the fl_device.update_time field . */
    public static final int FL_DEVICE_ID_UPDATE_TIME = 6;
    /** Identify the fl_face.md5 field . */
    public static final int FL_FACE_ID_MD5 = 0;
    /** Identify the fl_face.person_id field . */
    public static final int FL_FACE_ID_PERSON_ID = 1;
    /** Identify the fl_face.img_md5 field . */
    public static final int FL_FACE_ID_IMG_MD5 = 2;
    /** Identify the fl_face.face_left field . */
    public static final int FL_FACE_ID_FACE_LEFT = 3;
    /** Identify the fl_face.face_top field . */
    public static final int FL_FACE_ID_FACE_TOP = 4;
    /** Identify the fl_face.face_width field . */
    public static final int FL_FACE_ID_FACE_WIDTH = 5;
    /** Identify the fl_face.face_height field . */
    public static final int FL_FACE_ID_FACE_HEIGHT = 6;
    /** Identify the fl_face.eye_leftx field . */
    public static final int FL_FACE_ID_EYE_LEFTX = 7;
    /** Identify the fl_face.eye_lefty field . */
    public static final int FL_FACE_ID_EYE_LEFTY = 8;
    /** Identify the fl_face.eye_rightx field . */
    public static final int FL_FACE_ID_EYE_RIGHTX = 9;
    /** Identify the fl_face.eye_righty field . */
    public static final int FL_FACE_ID_EYE_RIGHTY = 10;
    /** Identify the fl_face.mouth_x field . */
    public static final int FL_FACE_ID_MOUTH_X = 11;
    /** Identify the fl_face.mouth_y field . */
    public static final int FL_FACE_ID_MOUTH_Y = 12;
    /** Identify the fl_face.nose_x field . */
    public static final int FL_FACE_ID_NOSE_X = 13;
    /** Identify the fl_face.nose_y field . */
    public static final int FL_FACE_ID_NOSE_Y = 14;
    /** Identify the fl_face.angle_yaw field . */
    public static final int FL_FACE_ID_ANGLE_YAW = 15;
    /** Identify the fl_face.angle_pitch field . */
    public static final int FL_FACE_ID_ANGLE_PITCH = 16;
    /** Identify the fl_face.angle_roll field . */
    public static final int FL_FACE_ID_ANGLE_ROLL = 17;
    /** Identify the fl_face.ext_info field . */
    public static final int FL_FACE_ID_EXT_INFO = 18;
    /** Identify the fl_face.feature field . */
    public static final int FL_FACE_ID_FEATURE = 19;
    /** Identify the fl_face.create_time field . */
    public static final int FL_FACE_ID_CREATE_TIME = 20;
    /** Identify the fl_image.md5 field . */
    public static final int FL_IMAGE_ID_MD5 = 0;
    /** Identify the fl_image.format field . */
    public static final int FL_IMAGE_ID_FORMAT = 1;
    /** Identify the fl_image.width field . */
    public static final int FL_IMAGE_ID_WIDTH = 2;
    /** Identify the fl_image.height field . */
    public static final int FL_IMAGE_ID_HEIGHT = 3;
    /** Identify the fl_image.depth field . */
    public static final int FL_IMAGE_ID_DEPTH = 4;
    /** Identify the fl_image.face_num field . */
    public static final int FL_IMAGE_ID_FACE_NUM = 5;
    /** Identify the fl_image.thumb_md5 field . */
    public static final int FL_IMAGE_ID_THUMB_MD5 = 6;
    /** Identify the fl_image.device_id field . */
    public static final int FL_IMAGE_ID_DEVICE_ID = 7;
    /** Identify the fl_log.id field . */
    public static final int FL_LOG_ID_ID = 0;
    /** Identify the fl_log.person_id field . */
    public static final int FL_LOG_ID_PERSON_ID = 1;
    /** Identify the fl_log.device_id field . */
    public static final int FL_LOG_ID_DEVICE_ID = 2;
    /** Identify the fl_log.verify_face field . */
    public static final int FL_LOG_ID_VERIFY_FACE = 3;
    /** Identify the fl_log.compare_face field . */
    public static final int FL_LOG_ID_COMPARE_FACE = 4;
    /** Identify the fl_log.similarty field . */
    public static final int FL_LOG_ID_SIMILARTY = 5;
    /** Identify the fl_log.verify_time field . */
    public static final int FL_LOG_ID_VERIFY_TIME = 6;
    /** Identify the fl_log.create_time field . */
    public static final int FL_LOG_ID_CREATE_TIME = 7;
    /** Identify the fl_person.id field . */
    public static final int FL_PERSON_ID_ID = 0;
    /** Identify the fl_person.group_id field . */
    public static final int FL_PERSON_ID_GROUP_ID = 1;
    /** Identify the fl_person.name field . */
    public static final int FL_PERSON_ID_NAME = 2;
    /** Identify the fl_person.sex field . */
    public static final int FL_PERSON_ID_SEX = 3;
    /** Identify the fl_person.birthdate field . */
    public static final int FL_PERSON_ID_BIRTHDATE = 4;
    /** Identify the fl_person.papers_type field . */
    public static final int FL_PERSON_ID_PAPERS_TYPE = 5;
    /** Identify the fl_person.papers_num field . */
    public static final int FL_PERSON_ID_PAPERS_NUM = 6;
    /** Identify the fl_person.photo_id field . */
    public static final int FL_PERSON_ID_PHOTO_ID = 7;
    /** Identify the fl_person.face_md5 field . */
    public static final int FL_PERSON_ID_FACE_MD5 = 8;
    /** Identify the fl_person.expiry_date field . */
    public static final int FL_PERSON_ID_EXPIRY_DATE = 9;
    /** Identify the fl_person.create_time field . */
    public static final int FL_PERSON_ID_CREATE_TIME = 10;
    /** Identify the fl_person.update_time field . */
    public static final int FL_PERSON_ID_UPDATE_TIME = 11;
    /** Identify the fl_store.md5 field . */
    public static final int FL_STORE_ID_MD5 = 0;
    /** Identify the fl_store.encoding field . */
    public static final int FL_STORE_ID_ENCODING = 1;
    /** Identify the fl_store.data field . */
    public static final int FL_STORE_ID_DATA = 2;
    /** Identify the fl_face_light.md5 field . */
    public static final int FL_FACE_LIGHT_ID_MD5 = 0;
    /** Identify the fl_face_light.person_id field . */
    public static final int FL_FACE_LIGHT_ID_PERSON_ID = 1;
    /** Identify the fl_face_light.img_md5 field . */
    public static final int FL_FACE_LIGHT_ID_IMG_MD5 = 2;
    /** Identify the fl_face_light.face_left field . */
    public static final int FL_FACE_LIGHT_ID_FACE_LEFT = 3;
    /** Identify the fl_face_light.face_top field . */
    public static final int FL_FACE_LIGHT_ID_FACE_TOP = 4;
    /** Identify the fl_face_light.face_width field . */
    public static final int FL_FACE_LIGHT_ID_FACE_WIDTH = 5;
    /** Identify the fl_face_light.face_height field . */
    public static final int FL_FACE_LIGHT_ID_FACE_HEIGHT = 6;
    /** Identify the fl_face_light.eye_leftx field . */
    public static final int FL_FACE_LIGHT_ID_EYE_LEFTX = 7;
    /** Identify the fl_face_light.eye_lefty field . */
    public static final int FL_FACE_LIGHT_ID_EYE_LEFTY = 8;
    /** Identify the fl_face_light.eye_rightx field . */
    public static final int FL_FACE_LIGHT_ID_EYE_RIGHTX = 9;
    /** Identify the fl_face_light.eye_righty field . */
    public static final int FL_FACE_LIGHT_ID_EYE_RIGHTY = 10;
    /** Identify the fl_face_light.mouth_x field . */
    public static final int FL_FACE_LIGHT_ID_MOUTH_X = 11;
    /** Identify the fl_face_light.mouth_y field . */
    public static final int FL_FACE_LIGHT_ID_MOUTH_Y = 12;
    /** Identify the fl_face_light.nose_x field . */
    public static final int FL_FACE_LIGHT_ID_NOSE_X = 13;
    /** Identify the fl_face_light.nose_y field . */
    public static final int FL_FACE_LIGHT_ID_NOSE_Y = 14;
    /** Identify the fl_face_light.angle_yaw field . */
    public static final int FL_FACE_LIGHT_ID_ANGLE_YAW = 15;
    /** Identify the fl_face_light.angle_pitch field . */
    public static final int FL_FACE_LIGHT_ID_ANGLE_PITCH = 16;
    /** Identify the fl_face_light.angle_roll field . */
    public static final int FL_FACE_LIGHT_ID_ANGLE_ROLL = 17;
    /** Identify the fl_face_light.ext_info field . */
    public static final int FL_FACE_LIGHT_ID_EXT_INFO = 18;
    /** Identify the fl_face_light.create_time field . */
    public static final int FL_FACE_LIGHT_ID_CREATE_TIME = 19;
    /** Identify the fl_feature.md5 field . */
    public static final int FL_FEATURE_ID_MD5 = 0;
    /** Identify the fl_feature.person_id field . */
    public static final int FL_FEATURE_ID_PERSON_ID = 1;
    /** Identify the fl_feature.img_md5 field . */
    public static final int FL_FEATURE_ID_IMG_MD5 = 2;
    /** Identify the fl_feature.feature field . */
    public static final int FL_FEATURE_ID_FEATURE = 3;
    /** Identify the fl_feature.create_time field . */
    public static final int FL_FEATURE_ID_CREATE_TIME = 4;
    /** Identify the fl_log_light.id field . */
    public static final int FL_LOG_LIGHT_ID_ID = 0;
    /** Identify the fl_log_light.person_id field . */
    public static final int FL_LOG_LIGHT_ID_PERSON_ID = 1;
    /** Identify the fl_log_light.name field . */
    public static final int FL_LOG_LIGHT_ID_NAME = 2;
    /** Identify the fl_log_light.papers_type field . */
    public static final int FL_LOG_LIGHT_ID_PAPERS_TYPE = 3;
    /** Identify the fl_log_light.papers_num field . */
    public static final int FL_LOG_LIGHT_ID_PAPERS_NUM = 4;
    /** Identify the fl_log_light.verify_time field . */
    public static final int FL_LOG_LIGHT_ID_VERIFY_TIME = 5;
    //////////////////////////////////////
    // COLUMN NAME DECLARE
    //////////////////////////////////////    
    /** Contains all the full fields of the fl_device table.*/
    public static final String[] FL_DEVICE_FULL_FIELD_NAMES =
    {
        "fl_device.id"
        ,"fl_device.name"
        ,"fl_device.online"
        ,"fl_device.group_id"
        ,"fl_device.version"
        ,"fl_device.create_time"
        ,"fl_device.update_time"
    };
    /** Contains all the full fields of the fl_face table.*/
    public static final String[] FL_FACE_FULL_FIELD_NAMES =
    {
        "fl_face.md5"
        ,"fl_face.person_id"
        ,"fl_face.img_md5"
        ,"fl_face.face_left"
        ,"fl_face.face_top"
        ,"fl_face.face_width"
        ,"fl_face.face_height"
        ,"fl_face.eye_leftx"
        ,"fl_face.eye_lefty"
        ,"fl_face.eye_rightx"
        ,"fl_face.eye_righty"
        ,"fl_face.mouth_x"
        ,"fl_face.mouth_y"
        ,"fl_face.nose_x"
        ,"fl_face.nose_y"
        ,"fl_face.angle_yaw"
        ,"fl_face.angle_pitch"
        ,"fl_face.angle_roll"
        ,"fl_face.ext_info"
        ,"fl_face.feature"
        ,"fl_face.create_time"
    };
    /** Contains all the full fields of the fl_image table.*/
    public static final String[] FL_IMAGE_FULL_FIELD_NAMES =
    {
        "fl_image.md5"
        ,"fl_image.format"
        ,"fl_image.width"
        ,"fl_image.height"
        ,"fl_image.depth"
        ,"fl_image.face_num"
        ,"fl_image.thumb_md5"
        ,"fl_image.device_id"
    };
    /** Contains all the full fields of the fl_log table.*/
    public static final String[] FL_LOG_FULL_FIELD_NAMES =
    {
        "fl_log.id"
        ,"fl_log.person_id"
        ,"fl_log.device_id"
        ,"fl_log.verify_face"
        ,"fl_log.compare_face"
        ,"fl_log.similarty"
        ,"fl_log.verify_time"
        ,"fl_log.create_time"
    };
    /** Contains all the full fields of the fl_person table.*/
    public static final String[] FL_PERSON_FULL_FIELD_NAMES =
    {
        "fl_person.id"
        ,"fl_person.group_id"
        ,"fl_person.name"
        ,"fl_person.sex"
        ,"fl_person.birthdate"
        ,"fl_person.papers_type"
        ,"fl_person.papers_num"
        ,"fl_person.photo_id"
        ,"fl_person.face_md5"
        ,"fl_person.expiry_date"
        ,"fl_person.create_time"
        ,"fl_person.update_time"
    };
    /** Contains all the full fields of the fl_store table.*/
    public static final String[] FL_STORE_FULL_FIELD_NAMES =
    {
        "fl_store.md5"
        ,"fl_store.encoding"
        ,"fl_store.data"
    };
    /** Contains all the full fields of the fl_face_light table.*/
    public static final String[] FL_FACE_LIGHT_FULL_FIELD_NAMES =
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
    /** Contains all the full fields of the fl_feature table.*/
    public static final String[] FL_FEATURE_FULL_FIELD_NAMES =
    {
        "fl_feature.md5"
        ,"fl_feature.person_id"
        ,"fl_feature.img_md5"
        ,"fl_feature.feature"
        ,"fl_feature.create_time"
    };
    /** Contains all the full fields of the fl_log_light table.*/
    public static final String[] FL_LOG_LIGHT_FULL_FIELD_NAMES =
    {
        "fl_log_light.id"
        ,"fl_log_light.person_id"
        ,"fl_log_light.name"
        ,"fl_log_light.papers_type"
        ,"fl_log_light.papers_num"
        ,"fl_log_light.verify_time"
    };

    /** Field that contains the comma separated fields of the fl_device table. */
    public static final String FL_DEVICE_ALL_FIELDS = "id"
                            + ",name"
                            + ",online"
                            + ",group_id"
                            + ",version"
                            + ",create_time"
                            + ",update_time";
    /** Field that contains the comma separated fields of the fl_face table. */
    public static final String FL_FACE_ALL_FIELDS = "md5"
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
                            + ",feature"
                            + ",create_time";
    /** Field that contains the comma separated fields of the fl_image table. */
    public static final String FL_IMAGE_ALL_FIELDS = "md5"
                            + ",format"
                            + ",width"
                            + ",height"
                            + ",depth"
                            + ",face_num"
                            + ",thumb_md5"
                            + ",device_id";
    /** Field that contains the comma separated fields of the fl_log table. */
    public static final String FL_LOG_ALL_FIELDS = "id"
                            + ",person_id"
                            + ",device_id"
                            + ",verify_face"
                            + ",compare_face"
                            + ",similarty"
                            + ",verify_time"
                            + ",create_time";
    /** Field that contains the comma separated fields of the fl_person table. */
    public static final String FL_PERSON_ALL_FIELDS = "id"
                            + ",group_id"
                            + ",name"
                            + ",sex"
                            + ",birthdate"
                            + ",papers_type"
                            + ",papers_num"
                            + ",photo_id"
                            + ",face_md5"
                            + ",expiry_date"
                            + ",create_time"
                            + ",update_time";
    /** Field that contains the comma separated fields of the fl_store table. */
    public static final String FL_STORE_ALL_FIELDS = "md5"
                            + ",encoding"
                            + ",data";
    /** Field that contains the comma separated fields of the fl_face_light table. */
    public static final String FL_FACE_LIGHT_ALL_FIELDS = "md5"
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
    /** Field that contains the comma separated fields of the fl_feature table. */
    public static final String FL_FEATURE_ALL_FIELDS = "md5"
                            + ",person_id"
                            + ",img_md5"
                            + ",feature"
                            + ",create_time";
    /** Field that contains the comma separated fields of the fl_log_light table. */
    public static final String FL_LOG_LIGHT_ALL_FIELDS = "id"
                            + ",person_id"
                            + ",name"
                            + ",papers_type"
                            + ",papers_num"
                            + ",verify_time";
}

// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.util.java.vm
// ______________________________________________________
package net.gdface.facelog.db.mysql;

import java.util.Map;

import net.gdface.facelog.dborm.Manager;
/**
 * static method delegation of native manager {@link Manager}
 * @author guyadong
 *
 */
public class ManagerUtil {
    /**
     * inject properties to  {@link Manager#databaseProperties}
     * @param properties
     */
    public static final void injectProperties(Map<String,String> properties){
        Manager.injectProperties(properties);
    }
}
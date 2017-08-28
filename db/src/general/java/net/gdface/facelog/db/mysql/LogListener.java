// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;

import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.LogBean;

/**
 * Listener that is notified of fl_log table changes.
 * @author guyadong
 */
public interface LogListener extends TableListener
{
    /**
     * This adapter class provides default implementations for the
     * methods described by the {@link LogListener} interface.<br>
     * 
     * @see LogListener
     * @author sql2java
     *
     */
    public static class Adapter implements LogListener{

        @Override
        public void beforeInsert(LogBean bean) {}

        @Override
        public void afterInsert(LogBean bean) {
        }

        @Override
        public void beforeUpdate(LogBean bean) {}

        @Override
        public void afterUpdate(LogBean bean) {}

        @Override
        public void beforeDelete(LogBean bean) {}

        @Override
        public void afterDelete(LogBean bean) {}
    }
    /**
     * Invoked just before inserting a LogBean record into the database.
     *
     * @param bean the LogBean that is about to be inserted
     */
    public void beforeInsert(LogBean bean);


    /**
     * Invoked just after a LogBean record is inserted in the database.
     *
     * @param bean the LogBean that was just inserted
     */
    public void afterInsert(LogBean bean);


    /**
     * Invoked just before updating a LogBean record in the database.
     *
     * @param bean the LogBean that is about to be updated
     */
    public void beforeUpdate(LogBean bean);


    /**
     * Invoked just after updating a LogBean record in the database.
     *
     * @param bean the LogBean that was just updated
     */
    public void afterUpdate(LogBean bean);


    /**
     * Invoked just before deleting a LogBean record in the database.
     *
     * @param bean the LogBean that is about to be deleted
     */
    public void beforeDelete(LogBean bean);


    /**
     * Invoked just after deleting a LogBean record in the database.
     *
     * @param bean the LogBean that was just deleted
     */
    public void afterDelete(LogBean bean);

}

// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Please help us improve this tool by reporting:
// - problems and suggestions to
//   http://sourceforge.net/tracker/?group_id=54687
// - feedbacks and ideas on
//   http://sourceforge.net/forum/forum.php?forum_id=182208
// ______________________________________________________

package net.gdface.facelog.dborm.log;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.TableListener;
/**
 * Listener that is notified of fl_log table changes.
 * @author sql2java
 */
public interface FlLogListener extends TableListener
{
    /**
     * Invoked just before inserting a FlLogBean record into the database.
     *
     * @param bean the FlLogBean that is about to be inserted
     */
    public void beforeInsert(FlLogBean bean) throws DAOException;


    /**
     * Invoked just after a FlLogBean record is inserted in the database.
     *
     * @param bean the FlLogBean that was just inserted
     */
    public void afterInsert(FlLogBean bean) throws DAOException;


    /**
     * Invoked just before updating a FlLogBean record in the database.
     *
     * @param bean the FlLogBean that is about to be updated
     */
    public void beforeUpdate(FlLogBean bean) throws DAOException;


    /**
     * Invoked just after updating a FlLogBean record in the database.
     *
     * @param bean the FlLogBean that was just updated
     */
    public void afterUpdate(FlLogBean bean) throws DAOException;


    /**
     * Invoked just before deleting a FlLogBean record in the database.
     *
     * @param bean the FlLogBean that is about to be deleted
     */
    public void beforeDelete(FlLogBean bean) throws DAOException;


    /**
     * Invoked just after deleting a FlLogBean record in the database.
     *
     * @param bean the FlLogBean that was just deleted
     */
    public void afterDelete(FlLogBean bean) throws DAOException;

}

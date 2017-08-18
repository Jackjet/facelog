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

package net.gdface.facelog.dborm.person;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.TableListener;
/**
 * Listener that is notified of fl_person table changes.
 * @author sql2java
 */
public interface FlPersonListener extends TableListener
{
    /**
     * Invoked just before inserting a FlPersonBean record into the database.
     *
     * @param bean the FlPersonBean that is about to be inserted
     */
    public void beforeInsert(FlPersonBean bean) throws DAOException;


    /**
     * Invoked just after a FlPersonBean record is inserted in the database.
     *
     * @param bean the FlPersonBean that was just inserted
     */
    public void afterInsert(FlPersonBean bean) throws DAOException;


    /**
     * Invoked just before updating a FlPersonBean record in the database.
     *
     * @param bean the FlPersonBean that is about to be updated
     */
    public void beforeUpdate(FlPersonBean bean) throws DAOException;


    /**
     * Invoked just after updating a FlPersonBean record in the database.
     *
     * @param bean the FlPersonBean that was just updated
     */
    public void afterUpdate(FlPersonBean bean) throws DAOException;


    /**
     * Invoked just before deleting a FlPersonBean record in the database.
     *
     * @param bean the FlPersonBean that is about to be deleted
     */
    public void beforeDelete(FlPersonBean bean) throws DAOException;


    /**
     * Invoked just after deleting a FlPersonBean record in the database.
     *
     * @param bean the FlPersonBean that was just deleted
     */
    public void afterDelete(FlPersonBean bean) throws DAOException;

}

// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: comparator.java.vm
// ______________________________________________________
package net.gdface.facelog.dborm.device;

import java.util.Comparator;
import net.gdface.facelog.dborm.Constant;


/**
 * Comparator class is used to sort the FlDeviceGroupBean objects.
 * @author sql2java
 */
public class FlDeviceGroupComparator implements Comparator<FlDeviceGroupBean>,Constant
{
    /**
     * Holds the field on which the comparison is performed.
     */
    private int iType;
    /**
     * Value that will contain the information about the order of the sort: normal or reversal.
     */
    private boolean bReverse;

    /**
     * Constructor class for FlDeviceGroupComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new FlDeviceGroupComparator(Constant.FL_DEVICE_GROUP_ID_ID, bReverse));<code>
     *
     * @param iType the field from which you want to sort
     * <br>
     * Possible values are:
     * <ul>
     *   <li>{@link Constant#FL_DEVICE_GROUP_ID_ID}
     *   <li>{@link Constant#FL_DEVICE_GROUP_ID_NAME}
     *   <li>{@link Constant#FL_DEVICE_GROUP_ID_PARENT}
     * </ul>
     */
    public FlDeviceGroupComparator(int iType)
    {
        this(iType, false);
    }

    /**
     * Constructor class for FlDeviceGroupComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new FlDeviceGroupComparator(Constant.FL_DEVICE_GROUP_ID_ID, bReverse));<code>
     *
     * @param iType the field from which you want to sort.
     * <br>
     * Possible values are:
     * <ul>
     *   <li>{@link Constant#FL_DEVICE_GROUP_ID_ID})
     *   <li>{@link Constant#FL_DEVICE_GROUP_ID_NAME})
     *   <li>{@link Constant#FL_DEVICE_GROUP_ID_PARENT})
     * </ul>
     *
     * @param bReverse set this value to true, if you want to reverse the sorting results
     */
    public FlDeviceGroupComparator(int iType, boolean bReverse)
    {
        this.iType = iType;
        this.bReverse = bReverse;
    }

    @Override
    public int compare(FlDeviceGroupBean b1, FlDeviceGroupBean b2)
    {
        int iReturn = 0;
        switch(iType)
        {
            case FL_DEVICE_GROUP_ID_ID:
                if (b1.getId() == null && b2.getId() != null) {
                    iReturn = -1;
                } else if (b1.getId() == null && b2.getId() == null) {
                    iReturn = 0;
                } else if (b1.getId() != null && b2.getId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getId().compareTo(b2.getId());
                }
                break;
            case FL_DEVICE_GROUP_ID_NAME:
                if (b1.getName() == null && b2.getName() != null) {
                    iReturn = -1;
                } else if (b1.getName() == null && b2.getName() == null) {
                    iReturn = 0;
                } else if (b1.getName() != null && b2.getName() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getName().compareTo(b2.getName());
                }
                break;
            case FL_DEVICE_GROUP_ID_PARENT:
                if (b1.getParent() == null && b2.getParent() != null) {
                    iReturn = -1;
                } else if (b1.getParent() == null && b2.getParent() == null) {
                    iReturn = 0;
                } else if (b1.getParent() != null && b2.getParent() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getParent().compareTo(b2.getParent());
                }
                break;
            default:
                throw new IllegalArgumentException("Type passed for the field is not supported");
        }

        return bReverse ? (-1 * iReturn) : iReturn;
    }}

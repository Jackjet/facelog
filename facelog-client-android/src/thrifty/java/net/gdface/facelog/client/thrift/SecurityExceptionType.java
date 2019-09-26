// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-09-26T03:28:33.469Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 11:1
package net.gdface.facelog.client.thrift;

import javax.annotation.Generated;

@Generated(
    value = "com.microsoft.thrifty.gen.ThriftyCodeGenerator",
    comments = "https://github.com/microsoft/thrifty"
)
public enum SecurityExceptionType {
  UNCLASSIFIED(0),

  INVALID_MAC(1),

  INVALID_SN(2),

  OCCUPIED_SN(3),

  INVALID_TOKEN(4),

  INVALID_DEVICE_ID(5),

  INVALID_PERSON_ID(6),

  INVALID_PASSWORD(7),

  REJECT_APPLY(8),

  ACCESS_DENIED(9),

  TABLE_INSERT_DENIED(10),

  TABLE_UPDATE_DENIED(11),

  TABLE_DELETE_DENIED(12),

  TOO_LOW_RANK(13);

  public final int value;

  SecurityExceptionType(int value) {
    this.value = value;
  }

  public static SecurityExceptionType findByValue(int value) {
    switch (value) {
      case 0: return UNCLASSIFIED;
      case 1: return INVALID_MAC;
      case 2: return INVALID_SN;
      case 3: return OCCUPIED_SN;
      case 4: return INVALID_TOKEN;
      case 5: return INVALID_DEVICE_ID;
      case 6: return INVALID_PERSON_ID;
      case 7: return INVALID_PASSWORD;
      case 8: return REJECT_APPLY;
      case 9: return ACCESS_DENIED;
      case 10: return TABLE_INSERT_DENIED;
      case 11: return TABLE_UPDATE_DENIED;
      case 12: return TABLE_DELETE_DENIED;
      case 13: return TOO_LOW_RANK;
      default: return null;
    }
  }
}

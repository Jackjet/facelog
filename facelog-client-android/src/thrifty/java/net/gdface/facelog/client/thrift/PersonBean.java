// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-04-11T02:37:45.709Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 152:1
package net.gdface.facelog.client.thrift;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.Struct;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.TType;
import com.microsoft.thrifty.ThriftField;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;
import javax.annotation.Generated;
import okio.ByteString;

@Generated(
    value = "com.microsoft.thrifty.gen.ThriftyCodeGenerator",
    comments = "https://github.com/microsoft/thrifty"
)
public final class PersonBean implements Struct {
  public static final Adapter<PersonBean, Builder> ADAPTER = new PersonBeanAdapter();

  @ThriftField(
      fieldId = 1,
      isRequired = true
  )
  public final Boolean _new;

  @ThriftField(
      fieldId = 2,
      isRequired = true
  )
  public final Long modified;

  @ThriftField(
      fieldId = 3,
      isRequired = true
  )
  public final Long initialized;

  @ThriftField(
      fieldId = 4,
      isOptional = true
  )
  public final Integer id;

  @ThriftField(
      fieldId = 5,
      isOptional = true
  )
  public final Integer groupId;

  @ThriftField(
      fieldId = 6,
      isOptional = true
  )
  public final String name;

  @ThriftField(
      fieldId = 7,
      isOptional = true
  )
  public final Integer sex;

  @ThriftField(
      fieldId = 8,
      isOptional = true
  )
  public final Integer rank;

  @ThriftField(
      fieldId = 9,
      isOptional = true
  )
  public final String password;

  @ThriftField(
      fieldId = 10,
      isOptional = true
  )
  public final Long birthdate;

  @ThriftField(
      fieldId = 11,
      isOptional = true
  )
  public final String mobilePhone;

  @ThriftField(
      fieldId = 12,
      isOptional = true
  )
  public final Integer papersType;

  @ThriftField(
      fieldId = 13,
      isOptional = true
  )
  public final String papersNum;

  @ThriftField(
      fieldId = 14,
      isOptional = true
  )
  public final String imageMd5;

  @ThriftField(
      fieldId = 15,
      isOptional = true
  )
  public final Long expiryDate;

  @ThriftField(
      fieldId = 16,
      isOptional = true
  )
  public final String remark;

  @ThriftField(
      fieldId = 17,
      isOptional = true
  )
  public final ByteString extBin;

  @ThriftField(
      fieldId = 18,
      isOptional = true
  )
  public final String extTxt;

  @ThriftField(
      fieldId = 19,
      isOptional = true
  )
  public final Long createTime;

  @ThriftField(
      fieldId = 20,
      isOptional = true
  )
  public final Long updateTime;

  private PersonBean(Builder builder) {
    this._new = builder._new;
    this.modified = builder.modified;
    this.initialized = builder.initialized;
    this.id = builder.id;
    this.groupId = builder.groupId;
    this.name = builder.name;
    this.sex = builder.sex;
    this.rank = builder.rank;
    this.password = builder.password;
    this.birthdate = builder.birthdate;
    this.mobilePhone = builder.mobilePhone;
    this.papersType = builder.papersType;
    this.papersNum = builder.papersNum;
    this.imageMd5 = builder.imageMd5;
    this.expiryDate = builder.expiryDate;
    this.remark = builder.remark;
    this.extBin = builder.extBin;
    this.extTxt = builder.extTxt;
    this.createTime = builder.createTime;
    this.updateTime = builder.updateTime;
  }

  @Override
  @SuppressWarnings({"NumberEquality", "StringEquality"})
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof PersonBean)) return false;
    PersonBean that = (PersonBean) other;
    return (this._new == that._new || this._new.equals(that._new))
        && (this.modified == that.modified || this.modified.equals(that.modified))
        && (this.initialized == that.initialized || this.initialized.equals(that.initialized))
        && (this.id == that.id || (this.id != null && this.id.equals(that.id)))
        && (this.groupId == that.groupId || (this.groupId != null && this.groupId.equals(that.groupId)))
        && (this.name == that.name || (this.name != null && this.name.equals(that.name)))
        && (this.sex == that.sex || (this.sex != null && this.sex.equals(that.sex)))
        && (this.rank == that.rank || (this.rank != null && this.rank.equals(that.rank)))
        && (this.password == that.password || (this.password != null && this.password.equals(that.password)))
        && (this.birthdate == that.birthdate || (this.birthdate != null && this.birthdate.equals(that.birthdate)))
        && (this.mobilePhone == that.mobilePhone || (this.mobilePhone != null && this.mobilePhone.equals(that.mobilePhone)))
        && (this.papersType == that.papersType || (this.papersType != null && this.papersType.equals(that.papersType)))
        && (this.papersNum == that.papersNum || (this.papersNum != null && this.papersNum.equals(that.papersNum)))
        && (this.imageMd5 == that.imageMd5 || (this.imageMd5 != null && this.imageMd5.equals(that.imageMd5)))
        && (this.expiryDate == that.expiryDate || (this.expiryDate != null && this.expiryDate.equals(that.expiryDate)))
        && (this.remark == that.remark || (this.remark != null && this.remark.equals(that.remark)))
        && (this.extBin == that.extBin || (this.extBin != null && this.extBin.equals(that.extBin)))
        && (this.extTxt == that.extTxt || (this.extTxt != null && this.extTxt.equals(that.extTxt)))
        && (this.createTime == that.createTime || (this.createTime != null && this.createTime.equals(that.createTime)))
        && (this.updateTime == that.updateTime || (this.updateTime != null && this.updateTime.equals(that.updateTime)));
  }

  @Override
  public int hashCode() {
    int code = 16777619;
    code ^= this._new.hashCode();
    code *= 0x811c9dc5;
    code ^= this.modified.hashCode();
    code *= 0x811c9dc5;
    code ^= this.initialized.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.id == null) ? 0 : this.id.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.groupId == null) ? 0 : this.groupId.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.name == null) ? 0 : this.name.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.sex == null) ? 0 : this.sex.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.rank == null) ? 0 : this.rank.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.password == null) ? 0 : this.password.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.birthdate == null) ? 0 : this.birthdate.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.mobilePhone == null) ? 0 : this.mobilePhone.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.papersType == null) ? 0 : this.papersType.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.papersNum == null) ? 0 : this.papersNum.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.imageMd5 == null) ? 0 : this.imageMd5.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.expiryDate == null) ? 0 : this.expiryDate.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.remark == null) ? 0 : this.remark.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.extBin == null) ? 0 : this.extBin.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.extTxt == null) ? 0 : this.extTxt.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.createTime == null) ? 0 : this.createTime.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.updateTime == null) ? 0 : this.updateTime.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "PersonBean{_new=" + this._new + ", modified=" + this.modified + ", initialized=" + this.initialized + ", id=" + this.id + ", groupId=" + this.groupId + ", name=" + this.name + ", sex=" + this.sex + ", rank=" + this.rank + ", password=" + this.password + ", birthdate=" + this.birthdate + ", mobilePhone=" + this.mobilePhone + ", papersType=" + this.papersType + ", papersNum=" + this.papersNum + ", imageMd5=" + this.imageMd5 + ", expiryDate=" + this.expiryDate + ", remark=" + this.remark + ", extBin=" + this.extBin + ", extTxt=" + this.extTxt + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<PersonBean> {
    private Boolean _new;

    private Long modified;

    private Long initialized;

    private Integer id;

    private Integer groupId;

    private String name;

    private Integer sex;

    private Integer rank;

    private String password;

    private Long birthdate;

    private String mobilePhone;

    private Integer papersType;

    private String papersNum;

    private String imageMd5;

    private Long expiryDate;

    private String remark;

    private ByteString extBin;

    private String extTxt;

    private Long createTime;

    private Long updateTime;

    public Builder() {
    }

    public Builder(PersonBean struct) {
      this._new = struct._new;
      this.modified = struct.modified;
      this.initialized = struct.initialized;
      this.id = struct.id;
      this.groupId = struct.groupId;
      this.name = struct.name;
      this.sex = struct.sex;
      this.rank = struct.rank;
      this.password = struct.password;
      this.birthdate = struct.birthdate;
      this.mobilePhone = struct.mobilePhone;
      this.papersType = struct.papersType;
      this.papersNum = struct.papersNum;
      this.imageMd5 = struct.imageMd5;
      this.expiryDate = struct.expiryDate;
      this.remark = struct.remark;
      this.extBin = struct.extBin;
      this.extTxt = struct.extTxt;
      this.createTime = struct.createTime;
      this.updateTime = struct.updateTime;
    }

    public Builder _new(Boolean _new) {
      if (_new == null) {
        throw new NullPointerException("Required field '_new' cannot be null");
      }
      this._new = _new;
      return this;
    }

    public Builder modified(Long modified) {
      if (modified == null) {
        throw new NullPointerException("Required field 'modified' cannot be null");
      }
      this.modified = modified;
      return this;
    }

    public Builder initialized(Long initialized) {
      if (initialized == null) {
        throw new NullPointerException("Required field 'initialized' cannot be null");
      }
      this.initialized = initialized;
      return this;
    }

    public Builder id(Integer id) {
      this.id = id;
      return this;
    }

    public Builder groupId(Integer groupId) {
      this.groupId = groupId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder sex(Integer sex) {
      this.sex = sex;
      return this;
    }

    public Builder rank(Integer rank) {
      this.rank = rank;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder birthdate(Long birthdate) {
      this.birthdate = birthdate;
      return this;
    }

    public Builder mobilePhone(String mobilePhone) {
      this.mobilePhone = mobilePhone;
      return this;
    }

    public Builder papersType(Integer papersType) {
      this.papersType = papersType;
      return this;
    }

    public Builder papersNum(String papersNum) {
      this.papersNum = papersNum;
      return this;
    }

    public Builder imageMd5(String imageMd5) {
      this.imageMd5 = imageMd5;
      return this;
    }

    public Builder expiryDate(Long expiryDate) {
      this.expiryDate = expiryDate;
      return this;
    }

    public Builder remark(String remark) {
      this.remark = remark;
      return this;
    }

    public Builder extBin(ByteString extBin) {
      this.extBin = extBin;
      return this;
    }

    public Builder extTxt(String extTxt) {
      this.extTxt = extTxt;
      return this;
    }

    public Builder createTime(Long createTime) {
      this.createTime = createTime;
      return this;
    }

    public Builder updateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    @Override
    public PersonBean build() {
      if (this._new == null) {
        throw new IllegalStateException("Required field '_new' is missing");
      }
      if (this.modified == null) {
        throw new IllegalStateException("Required field 'modified' is missing");
      }
      if (this.initialized == null) {
        throw new IllegalStateException("Required field 'initialized' is missing");
      }
      return new PersonBean(this);
    }

    @Override
    public void reset() {
      this._new = null;
      this.modified = null;
      this.initialized = null;
      this.id = null;
      this.groupId = null;
      this.name = null;
      this.sex = null;
      this.rank = null;
      this.password = null;
      this.birthdate = null;
      this.mobilePhone = null;
      this.papersType = null;
      this.papersNum = null;
      this.imageMd5 = null;
      this.expiryDate = null;
      this.remark = null;
      this.extBin = null;
      this.extTxt = null;
      this.createTime = null;
      this.updateTime = null;
    }
  }

  private static final class PersonBeanAdapter implements Adapter<PersonBean, Builder> {
    @Override
    public void write(Protocol protocol, PersonBean struct) throws IOException {
      protocol.writeStructBegin("PersonBean");
      protocol.writeFieldBegin("_new", 1, TType.BOOL);
      protocol.writeBool(struct._new);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("modified", 2, TType.I64);
      protocol.writeI64(struct.modified);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("initialized", 3, TType.I64);
      protocol.writeI64(struct.initialized);
      protocol.writeFieldEnd();
      if (struct.id != null) {
        protocol.writeFieldBegin("id", 4, TType.I32);
        protocol.writeI32(struct.id);
        protocol.writeFieldEnd();
      }
      if (struct.groupId != null) {
        protocol.writeFieldBegin("groupId", 5, TType.I32);
        protocol.writeI32(struct.groupId);
        protocol.writeFieldEnd();
      }
      if (struct.name != null) {
        protocol.writeFieldBegin("name", 6, TType.STRING);
        protocol.writeString(struct.name);
        protocol.writeFieldEnd();
      }
      if (struct.sex != null) {
        protocol.writeFieldBegin("sex", 7, TType.I32);
        protocol.writeI32(struct.sex);
        protocol.writeFieldEnd();
      }
      if (struct.rank != null) {
        protocol.writeFieldBegin("rank", 8, TType.I32);
        protocol.writeI32(struct.rank);
        protocol.writeFieldEnd();
      }
      if (struct.password != null) {
        protocol.writeFieldBegin("password", 9, TType.STRING);
        protocol.writeString(struct.password);
        protocol.writeFieldEnd();
      }
      if (struct.birthdate != null) {
        protocol.writeFieldBegin("birthdate", 10, TType.I64);
        protocol.writeI64(struct.birthdate);
        protocol.writeFieldEnd();
      }
      if (struct.mobilePhone != null) {
        protocol.writeFieldBegin("mobilePhone", 11, TType.STRING);
        protocol.writeString(struct.mobilePhone);
        protocol.writeFieldEnd();
      }
      if (struct.papersType != null) {
        protocol.writeFieldBegin("papersType", 12, TType.I32);
        protocol.writeI32(struct.papersType);
        protocol.writeFieldEnd();
      }
      if (struct.papersNum != null) {
        protocol.writeFieldBegin("papersNum", 13, TType.STRING);
        protocol.writeString(struct.papersNum);
        protocol.writeFieldEnd();
      }
      if (struct.imageMd5 != null) {
        protocol.writeFieldBegin("imageMd5", 14, TType.STRING);
        protocol.writeString(struct.imageMd5);
        protocol.writeFieldEnd();
      }
      if (struct.expiryDate != null) {
        protocol.writeFieldBegin("expiryDate", 15, TType.I64);
        protocol.writeI64(struct.expiryDate);
        protocol.writeFieldEnd();
      }
      if (struct.remark != null) {
        protocol.writeFieldBegin("remark", 16, TType.STRING);
        protocol.writeString(struct.remark);
        protocol.writeFieldEnd();
      }
      if (struct.extBin != null) {
        protocol.writeFieldBegin("extBin", 17, TType.STRING);
        protocol.writeBinary(struct.extBin);
        protocol.writeFieldEnd();
      }
      if (struct.extTxt != null) {
        protocol.writeFieldBegin("extTxt", 18, TType.STRING);
        protocol.writeString(struct.extTxt);
        protocol.writeFieldEnd();
      }
      if (struct.createTime != null) {
        protocol.writeFieldBegin("createTime", 19, TType.I64);
        protocol.writeI64(struct.createTime);
        protocol.writeFieldEnd();
      }
      if (struct.updateTime != null) {
        protocol.writeFieldBegin("updateTime", 20, TType.I64);
        protocol.writeI64(struct.updateTime);
        protocol.writeFieldEnd();
      }
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public PersonBean read(Protocol protocol, Builder builder) throws IOException {
      protocol.readStructBegin();
      while (true) {
        FieldMetadata field = protocol.readFieldBegin();
        if (field.typeId == TType.STOP) {
          break;
        }
        switch (field.fieldId) {
          case 1: {
            if (field.typeId == TType.BOOL) {
              boolean value = protocol.readBool();
              builder._new(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 2: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.modified(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 3: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.initialized(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 4: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.id(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 5: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.groupId(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 6: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.name(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 7: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.sex(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 8: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.rank(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 9: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.password(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 10: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.birthdate(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 11: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.mobilePhone(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 12: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.papersType(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 13: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.papersNum(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 14: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.imageMd5(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 15: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.expiryDate(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 16: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.remark(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 17: {
            if (field.typeId == TType.STRING) {
              ByteString value = protocol.readBinary();
              builder.extBin(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 18: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.extTxt(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 19: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.createTime(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 20: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.updateTime(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          default: {
            ProtocolUtil.skip(protocol, field.typeId);
          }
          break;
        }
        protocol.readFieldEnd();
      }
      protocol.readStructEnd();
      return builder.build();
    }

    @Override
    public PersonBean read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}

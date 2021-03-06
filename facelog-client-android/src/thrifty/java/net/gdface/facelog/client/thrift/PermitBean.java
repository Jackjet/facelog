// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-09-23T07:19:09.738Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 141:1
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
public final class PermitBean implements Struct {
  public static final Adapter<PermitBean, Builder> ADAPTER = new PermitBeanAdapter();

  @ThriftField(
      fieldId = 1,
      isRequired = true
  )
  public final Boolean _new;

  @ThriftField(
      fieldId = 2,
      isRequired = true
  )
  public final Integer modified;

  @ThriftField(
      fieldId = 3,
      isRequired = true
  )
  public final Integer initialized;

  @ThriftField(
      fieldId = 4,
      isOptional = true
  )
  public final Integer deviceGroupId;

  @ThriftField(
      fieldId = 5,
      isOptional = true
  )
  public final Integer personGroupId;

  @ThriftField(
      fieldId = 6,
      isOptional = true
  )
  public final String schedule;

  @ThriftField(
      fieldId = 7,
      isOptional = true
  )
  public final String passLimit;

  @ThriftField(
      fieldId = 8,
      isOptional = true
  )
  public final String remark;

  @ThriftField(
      fieldId = 9,
      isOptional = true
  )
  public final ByteString extBin;

  @ThriftField(
      fieldId = 10,
      isOptional = true
  )
  public final String extTxt;

  @ThriftField(
      fieldId = 11,
      isOptional = true
  )
  public final Long createTime;

  private PermitBean(Builder builder) {
    this._new = builder._new;
    this.modified = builder.modified;
    this.initialized = builder.initialized;
    this.deviceGroupId = builder.deviceGroupId;
    this.personGroupId = builder.personGroupId;
    this.schedule = builder.schedule;
    this.passLimit = builder.passLimit;
    this.remark = builder.remark;
    this.extBin = builder.extBin;
    this.extTxt = builder.extTxt;
    this.createTime = builder.createTime;
  }

  @Override
  @SuppressWarnings({"NumberEquality", "StringEquality"})
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof PermitBean)) return false;
    PermitBean that = (PermitBean) other;
    return (this._new == that._new || this._new.equals(that._new))
        && (this.modified == that.modified || this.modified.equals(that.modified))
        && (this.initialized == that.initialized || this.initialized.equals(that.initialized))
        && (this.deviceGroupId == that.deviceGroupId || (this.deviceGroupId != null && this.deviceGroupId.equals(that.deviceGroupId)))
        && (this.personGroupId == that.personGroupId || (this.personGroupId != null && this.personGroupId.equals(that.personGroupId)))
        && (this.schedule == that.schedule || (this.schedule != null && this.schedule.equals(that.schedule)))
        && (this.passLimit == that.passLimit || (this.passLimit != null && this.passLimit.equals(that.passLimit)))
        && (this.remark == that.remark || (this.remark != null && this.remark.equals(that.remark)))
        && (this.extBin == that.extBin || (this.extBin != null && this.extBin.equals(that.extBin)))
        && (this.extTxt == that.extTxt || (this.extTxt != null && this.extTxt.equals(that.extTxt)))
        && (this.createTime == that.createTime || (this.createTime != null && this.createTime.equals(that.createTime)));
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
    code ^= (this.deviceGroupId == null) ? 0 : this.deviceGroupId.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.personGroupId == null) ? 0 : this.personGroupId.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.schedule == null) ? 0 : this.schedule.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.passLimit == null) ? 0 : this.passLimit.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.remark == null) ? 0 : this.remark.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.extBin == null) ? 0 : this.extBin.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.extTxt == null) ? 0 : this.extTxt.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.createTime == null) ? 0 : this.createTime.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "PermitBean{_new=" + this._new + ", modified=" + this.modified + ", initialized=" + this.initialized + ", deviceGroupId=" + this.deviceGroupId + ", personGroupId=" + this.personGroupId + ", schedule=" + this.schedule + ", passLimit=" + this.passLimit + ", remark=" + this.remark + ", extBin=" + this.extBin + ", extTxt=" + this.extTxt + ", createTime=" + this.createTime + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<PermitBean> {
    private Boolean _new;

    private Integer modified;

    private Integer initialized;

    private Integer deviceGroupId;

    private Integer personGroupId;

    private String schedule;

    private String passLimit;

    private String remark;

    private ByteString extBin;

    private String extTxt;

    private Long createTime;

    public Builder() {
    }

    public Builder(PermitBean struct) {
      this._new = struct._new;
      this.modified = struct.modified;
      this.initialized = struct.initialized;
      this.deviceGroupId = struct.deviceGroupId;
      this.personGroupId = struct.personGroupId;
      this.schedule = struct.schedule;
      this.passLimit = struct.passLimit;
      this.remark = struct.remark;
      this.extBin = struct.extBin;
      this.extTxt = struct.extTxt;
      this.createTime = struct.createTime;
    }

    public Builder _new(Boolean _new) {
      if (_new == null) {
        throw new NullPointerException("Required field '_new' cannot be null");
      }
      this._new = _new;
      return this;
    }

    public Builder modified(Integer modified) {
      if (modified == null) {
        throw new NullPointerException("Required field 'modified' cannot be null");
      }
      this.modified = modified;
      return this;
    }

    public Builder initialized(Integer initialized) {
      if (initialized == null) {
        throw new NullPointerException("Required field 'initialized' cannot be null");
      }
      this.initialized = initialized;
      return this;
    }

    public Builder deviceGroupId(Integer deviceGroupId) {
      this.deviceGroupId = deviceGroupId;
      return this;
    }

    public Builder personGroupId(Integer personGroupId) {
      this.personGroupId = personGroupId;
      return this;
    }

    public Builder schedule(String schedule) {
      this.schedule = schedule;
      return this;
    }

    public Builder passLimit(String passLimit) {
      this.passLimit = passLimit;
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

    @Override
    public PermitBean build() {
      if (this._new == null) {
        throw new IllegalStateException("Required field '_new' is missing");
      }
      if (this.modified == null) {
        throw new IllegalStateException("Required field 'modified' is missing");
      }
      if (this.initialized == null) {
        throw new IllegalStateException("Required field 'initialized' is missing");
      }
      return new PermitBean(this);
    }

    @Override
    public void reset() {
      this._new = null;
      this.modified = null;
      this.initialized = null;
      this.deviceGroupId = null;
      this.personGroupId = null;
      this.schedule = null;
      this.passLimit = null;
      this.remark = null;
      this.extBin = null;
      this.extTxt = null;
      this.createTime = null;
    }
  }

  private static final class PermitBeanAdapter implements Adapter<PermitBean, Builder> {
    @Override
    public void write(Protocol protocol, PermitBean struct) throws IOException {
      protocol.writeStructBegin("PermitBean");
      protocol.writeFieldBegin("_new", 1, TType.BOOL);
      protocol.writeBool(struct._new);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("modified", 2, TType.I32);
      protocol.writeI32(struct.modified);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("initialized", 3, TType.I32);
      protocol.writeI32(struct.initialized);
      protocol.writeFieldEnd();
      if (struct.deviceGroupId != null) {
        protocol.writeFieldBegin("deviceGroupId", 4, TType.I32);
        protocol.writeI32(struct.deviceGroupId);
        protocol.writeFieldEnd();
      }
      if (struct.personGroupId != null) {
        protocol.writeFieldBegin("personGroupId", 5, TType.I32);
        protocol.writeI32(struct.personGroupId);
        protocol.writeFieldEnd();
      }
      if (struct.schedule != null) {
        protocol.writeFieldBegin("schedule", 6, TType.STRING);
        protocol.writeString(struct.schedule);
        protocol.writeFieldEnd();
      }
      if (struct.passLimit != null) {
        protocol.writeFieldBegin("passLimit", 7, TType.STRING);
        protocol.writeString(struct.passLimit);
        protocol.writeFieldEnd();
      }
      if (struct.remark != null) {
        protocol.writeFieldBegin("remark", 8, TType.STRING);
        protocol.writeString(struct.remark);
        protocol.writeFieldEnd();
      }
      if (struct.extBin != null) {
        protocol.writeFieldBegin("extBin", 9, TType.STRING);
        protocol.writeBinary(struct.extBin);
        protocol.writeFieldEnd();
      }
      if (struct.extTxt != null) {
        protocol.writeFieldBegin("extTxt", 10, TType.STRING);
        protocol.writeString(struct.extTxt);
        protocol.writeFieldEnd();
      }
      if (struct.createTime != null) {
        protocol.writeFieldBegin("createTime", 11, TType.I64);
        protocol.writeI64(struct.createTime);
        protocol.writeFieldEnd();
      }
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public PermitBean read(Protocol protocol, Builder builder) throws IOException {
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
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.modified(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 3: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.initialized(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 4: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.deviceGroupId(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 5: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.personGroupId(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 6: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.schedule(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 7: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.passLimit(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 8: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.remark(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 9: {
            if (field.typeId == TType.STRING) {
              ByteString value = protocol.readBinary();
              builder.extBin(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 10: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.extTxt(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 11: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.createTime(value);
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
    public PermitBean read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}

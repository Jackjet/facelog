// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-06-18T05:57:30.691Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 191:1
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

@Generated(
    value = "com.microsoft.thrifty.gen.ThriftyCodeGenerator",
    comments = "https://github.com/microsoft/thrifty"
)
public final class LogLightBean implements Struct {
  public static final Adapter<LogLightBean, Builder> ADAPTER = new LogLightBeanAdapter();

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
  public final Integer id;

  @ThriftField(
      fieldId = 5,
      isOptional = true
  )
  public final Integer personId;

  @ThriftField(
      fieldId = 6,
      isOptional = true
  )
  public final String name;

  @ThriftField(
      fieldId = 7,
      isOptional = true
  )
  public final Integer papersType;

  @ThriftField(
      fieldId = 8,
      isOptional = true
  )
  public final String papersNum;

  @ThriftField(
      fieldId = 9,
      isOptional = true
  )
  public final Long verifyTime;

  private LogLightBean(Builder builder) {
    this._new = builder._new;
    this.modified = builder.modified;
    this.initialized = builder.initialized;
    this.id = builder.id;
    this.personId = builder.personId;
    this.name = builder.name;
    this.papersType = builder.papersType;
    this.papersNum = builder.papersNum;
    this.verifyTime = builder.verifyTime;
  }

  @Override
  @SuppressWarnings({"NumberEquality", "StringEquality"})
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof LogLightBean)) return false;
    LogLightBean that = (LogLightBean) other;
    return (this._new == that._new || this._new.equals(that._new))
        && (this.modified == that.modified || this.modified.equals(that.modified))
        && (this.initialized == that.initialized || this.initialized.equals(that.initialized))
        && (this.id == that.id || (this.id != null && this.id.equals(that.id)))
        && (this.personId == that.personId || (this.personId != null && this.personId.equals(that.personId)))
        && (this.name == that.name || (this.name != null && this.name.equals(that.name)))
        && (this.papersType == that.papersType || (this.papersType != null && this.papersType.equals(that.papersType)))
        && (this.papersNum == that.papersNum || (this.papersNum != null && this.papersNum.equals(that.papersNum)))
        && (this.verifyTime == that.verifyTime || (this.verifyTime != null && this.verifyTime.equals(that.verifyTime)));
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
    code ^= (this.personId == null) ? 0 : this.personId.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.name == null) ? 0 : this.name.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.papersType == null) ? 0 : this.papersType.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.papersNum == null) ? 0 : this.papersNum.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.verifyTime == null) ? 0 : this.verifyTime.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "LogLightBean{_new=" + this._new + ", modified=" + this.modified + ", initialized=" + this.initialized + ", id=" + this.id + ", personId=" + this.personId + ", name=" + this.name + ", papersType=" + this.papersType + ", papersNum=" + this.papersNum + ", verifyTime=" + this.verifyTime + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<LogLightBean> {
    private Boolean _new;

    private Integer modified;

    private Integer initialized;

    private Integer id;

    private Integer personId;

    private String name;

    private Integer papersType;

    private String papersNum;

    private Long verifyTime;

    public Builder() {
    }

    public Builder(LogLightBean struct) {
      this._new = struct._new;
      this.modified = struct.modified;
      this.initialized = struct.initialized;
      this.id = struct.id;
      this.personId = struct.personId;
      this.name = struct.name;
      this.papersType = struct.papersType;
      this.papersNum = struct.papersNum;
      this.verifyTime = struct.verifyTime;
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

    public Builder id(Integer id) {
      this.id = id;
      return this;
    }

    public Builder personId(Integer personId) {
      this.personId = personId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
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

    public Builder verifyTime(Long verifyTime) {
      this.verifyTime = verifyTime;
      return this;
    }

    @Override
    public LogLightBean build() {
      if (this._new == null) {
        throw new IllegalStateException("Required field '_new' is missing");
      }
      if (this.modified == null) {
        throw new IllegalStateException("Required field 'modified' is missing");
      }
      if (this.initialized == null) {
        throw new IllegalStateException("Required field 'initialized' is missing");
      }
      return new LogLightBean(this);
    }

    @Override
    public void reset() {
      this._new = null;
      this.modified = null;
      this.initialized = null;
      this.id = null;
      this.personId = null;
      this.name = null;
      this.papersType = null;
      this.papersNum = null;
      this.verifyTime = null;
    }
  }

  private static final class LogLightBeanAdapter implements Adapter<LogLightBean, Builder> {
    @Override
    public void write(Protocol protocol, LogLightBean struct) throws IOException {
      protocol.writeStructBegin("LogLightBean");
      protocol.writeFieldBegin("_new", 1, TType.BOOL);
      protocol.writeBool(struct._new);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("modified", 2, TType.I32);
      protocol.writeI32(struct.modified);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("initialized", 3, TType.I32);
      protocol.writeI32(struct.initialized);
      protocol.writeFieldEnd();
      if (struct.id != null) {
        protocol.writeFieldBegin("id", 4, TType.I32);
        protocol.writeI32(struct.id);
        protocol.writeFieldEnd();
      }
      if (struct.personId != null) {
        protocol.writeFieldBegin("personId", 5, TType.I32);
        protocol.writeI32(struct.personId);
        protocol.writeFieldEnd();
      }
      if (struct.name != null) {
        protocol.writeFieldBegin("name", 6, TType.STRING);
        protocol.writeString(struct.name);
        protocol.writeFieldEnd();
      }
      if (struct.papersType != null) {
        protocol.writeFieldBegin("papersType", 7, TType.I32);
        protocol.writeI32(struct.papersType);
        protocol.writeFieldEnd();
      }
      if (struct.papersNum != null) {
        protocol.writeFieldBegin("papersNum", 8, TType.STRING);
        protocol.writeString(struct.papersNum);
        protocol.writeFieldEnd();
      }
      if (struct.verifyTime != null) {
        protocol.writeFieldBegin("verifyTime", 9, TType.I64);
        protocol.writeI64(struct.verifyTime);
        protocol.writeFieldEnd();
      }
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public LogLightBean read(Protocol protocol, Builder builder) throws IOException {
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
              builder.id(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 5: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.personId(value);
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
              builder.papersType(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 8: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.papersNum(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 9: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.verifyTime(value);
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
    public LogLightBean read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}

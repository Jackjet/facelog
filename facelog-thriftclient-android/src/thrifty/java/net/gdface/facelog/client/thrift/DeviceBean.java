// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-01-23T03:13:59.428Z
// Source: J:\facelog\facelog-thriftservice\IFaceLog.thrift at 128:1
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
public final class DeviceBean implements Struct {
  public static final Adapter<DeviceBean, Builder> ADAPTER = new DeviceBeanAdapter();

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
  public final String version;

  @ThriftField(
      fieldId = 8,
      isOptional = true
  )
  public final String serialNo;

  @ThriftField(
      fieldId = 9,
      isOptional = true
  )
  public final String mac;

  @ThriftField(
      fieldId = 10,
      isOptional = true
  )
  public final String remark;

  @ThriftField(
      fieldId = 11,
      isOptional = true
  )
  public final Long createTime;

  @ThriftField(
      fieldId = 12,
      isOptional = true
  )
  public final Long updateTime;

  private DeviceBean(Builder builder) {
    this._new = builder._new;
    this.modified = builder.modified;
    this.initialized = builder.initialized;
    this.id = builder.id;
    this.groupId = builder.groupId;
    this.name = builder.name;
    this.version = builder.version;
    this.serialNo = builder.serialNo;
    this.mac = builder.mac;
    this.remark = builder.remark;
    this.createTime = builder.createTime;
    this.updateTime = builder.updateTime;
  }

  @Override
  @SuppressWarnings({"NumberEquality", "StringEquality"})
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof DeviceBean)) return false;
    DeviceBean that = (DeviceBean) other;
    return (this._new == that._new || this._new.equals(that._new))
        && (this.modified == that.modified || this.modified.equals(that.modified))
        && (this.initialized == that.initialized || this.initialized.equals(that.initialized))
        && (this.id == that.id || (this.id != null && this.id.equals(that.id)))
        && (this.groupId == that.groupId || (this.groupId != null && this.groupId.equals(that.groupId)))
        && (this.name == that.name || (this.name != null && this.name.equals(that.name)))
        && (this.version == that.version || (this.version != null && this.version.equals(that.version)))
        && (this.serialNo == that.serialNo || (this.serialNo != null && this.serialNo.equals(that.serialNo)))
        && (this.mac == that.mac || (this.mac != null && this.mac.equals(that.mac)))
        && (this.remark == that.remark || (this.remark != null && this.remark.equals(that.remark)))
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
    code ^= (this.version == null) ? 0 : this.version.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.serialNo == null) ? 0 : this.serialNo.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.mac == null) ? 0 : this.mac.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.remark == null) ? 0 : this.remark.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.createTime == null) ? 0 : this.createTime.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.updateTime == null) ? 0 : this.updateTime.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "DeviceBean{_new=" + this._new + ", modified=" + this.modified + ", initialized=" + this.initialized + ", id=" + this.id + ", groupId=" + this.groupId + ", name=" + this.name + ", version=" + this.version + ", serialNo=" + this.serialNo + ", mac=" + this.mac + ", remark=" + this.remark + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<DeviceBean> {
    private Boolean _new;

    private Long modified;

    private Long initialized;

    private Integer id;

    private Integer groupId;

    private String name;

    private String version;

    private String serialNo;

    private String mac;

    private String remark;

    private Long createTime;

    private Long updateTime;

    public Builder() {
    }

    public Builder(DeviceBean struct) {
      this._new = struct._new;
      this.modified = struct.modified;
      this.initialized = struct.initialized;
      this.id = struct.id;
      this.groupId = struct.groupId;
      this.name = struct.name;
      this.version = struct.version;
      this.serialNo = struct.serialNo;
      this.mac = struct.mac;
      this.remark = struct.remark;
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

    public Builder version(String version) {
      this.version = version;
      return this;
    }

    public Builder serialNo(String serialNo) {
      this.serialNo = serialNo;
      return this;
    }

    public Builder mac(String mac) {
      this.mac = mac;
      return this;
    }

    public Builder remark(String remark) {
      this.remark = remark;
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
    public DeviceBean build() {
      if (this._new == null) {
        throw new IllegalStateException("Required field '_new' is missing");
      }
      if (this.modified == null) {
        throw new IllegalStateException("Required field 'modified' is missing");
      }
      if (this.initialized == null) {
        throw new IllegalStateException("Required field 'initialized' is missing");
      }
      return new DeviceBean(this);
    }

    @Override
    public void reset() {
      this._new = null;
      this.modified = null;
      this.initialized = null;
      this.id = null;
      this.groupId = null;
      this.name = null;
      this.version = null;
      this.serialNo = null;
      this.mac = null;
      this.remark = null;
      this.createTime = null;
      this.updateTime = null;
    }
  }

  private static final class DeviceBeanAdapter implements Adapter<DeviceBean, Builder> {
    @Override
    public void write(Protocol protocol, DeviceBean struct) throws IOException {
      protocol.writeStructBegin("DeviceBean");
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
      if (struct.version != null) {
        protocol.writeFieldBegin("version", 7, TType.STRING);
        protocol.writeString(struct.version);
        protocol.writeFieldEnd();
      }
      if (struct.serialNo != null) {
        protocol.writeFieldBegin("serialNo", 8, TType.STRING);
        protocol.writeString(struct.serialNo);
        protocol.writeFieldEnd();
      }
      if (struct.mac != null) {
        protocol.writeFieldBegin("mac", 9, TType.STRING);
        protocol.writeString(struct.mac);
        protocol.writeFieldEnd();
      }
      if (struct.remark != null) {
        protocol.writeFieldBegin("remark", 10, TType.STRING);
        protocol.writeString(struct.remark);
        protocol.writeFieldEnd();
      }
      if (struct.createTime != null) {
        protocol.writeFieldBegin("createTime", 11, TType.I64);
        protocol.writeI64(struct.createTime);
        protocol.writeFieldEnd();
      }
      if (struct.updateTime != null) {
        protocol.writeFieldBegin("updateTime", 12, TType.I64);
        protocol.writeI64(struct.updateTime);
        protocol.writeFieldEnd();
      }
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public DeviceBean read(Protocol protocol, Builder builder) throws IOException {
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
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.version(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 8: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.serialNo(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 9: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.mac(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 10: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.remark(value);
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
          case 12: {
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
    public DeviceBean read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}

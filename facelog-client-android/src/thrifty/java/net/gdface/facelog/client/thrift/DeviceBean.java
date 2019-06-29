// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-06-29T09:17:16.192Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 99:1
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
  public final String productName;

  @ThriftField(
      fieldId = 8,
      isOptional = true
  )
  public final String model;

  @ThriftField(
      fieldId = 9,
      isOptional = true
  )
  public final String vendor;

  @ThriftField(
      fieldId = 10,
      isOptional = true
  )
  public final String manufacturer;

  @ThriftField(
      fieldId = 11,
      isOptional = true
  )
  public final Long madeDate;

  @ThriftField(
      fieldId = 12,
      isOptional = true
  )
  public final String version;

  @ThriftField(
      fieldId = 13,
      isOptional = true
  )
  public final String usedSdks;

  @ThriftField(
      fieldId = 14,
      isOptional = true
  )
  public final String serialNo;

  @ThriftField(
      fieldId = 15,
      isOptional = true
  )
  public final String mac;

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

  private DeviceBean(Builder builder) {
    this._new = builder._new;
    this.modified = builder.modified;
    this.initialized = builder.initialized;
    this.id = builder.id;
    this.groupId = builder.groupId;
    this.name = builder.name;
    this.productName = builder.productName;
    this.model = builder.model;
    this.vendor = builder.vendor;
    this.manufacturer = builder.manufacturer;
    this.madeDate = builder.madeDate;
    this.version = builder.version;
    this.usedSdks = builder.usedSdks;
    this.serialNo = builder.serialNo;
    this.mac = builder.mac;
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
    if (!(other instanceof DeviceBean)) return false;
    DeviceBean that = (DeviceBean) other;
    return (this._new == that._new || this._new.equals(that._new))
        && (this.modified == that.modified || this.modified.equals(that.modified))
        && (this.initialized == that.initialized || this.initialized.equals(that.initialized))
        && (this.id == that.id || (this.id != null && this.id.equals(that.id)))
        && (this.groupId == that.groupId || (this.groupId != null && this.groupId.equals(that.groupId)))
        && (this.name == that.name || (this.name != null && this.name.equals(that.name)))
        && (this.productName == that.productName || (this.productName != null && this.productName.equals(that.productName)))
        && (this.model == that.model || (this.model != null && this.model.equals(that.model)))
        && (this.vendor == that.vendor || (this.vendor != null && this.vendor.equals(that.vendor)))
        && (this.manufacturer == that.manufacturer || (this.manufacturer != null && this.manufacturer.equals(that.manufacturer)))
        && (this.madeDate == that.madeDate || (this.madeDate != null && this.madeDate.equals(that.madeDate)))
        && (this.version == that.version || (this.version != null && this.version.equals(that.version)))
        && (this.usedSdks == that.usedSdks || (this.usedSdks != null && this.usedSdks.equals(that.usedSdks)))
        && (this.serialNo == that.serialNo || (this.serialNo != null && this.serialNo.equals(that.serialNo)))
        && (this.mac == that.mac || (this.mac != null && this.mac.equals(that.mac)))
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
    code ^= (this.productName == null) ? 0 : this.productName.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.model == null) ? 0 : this.model.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.vendor == null) ? 0 : this.vendor.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.manufacturer == null) ? 0 : this.manufacturer.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.madeDate == null) ? 0 : this.madeDate.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.version == null) ? 0 : this.version.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.usedSdks == null) ? 0 : this.usedSdks.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.serialNo == null) ? 0 : this.serialNo.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.mac == null) ? 0 : this.mac.hashCode();
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
    return "DeviceBean{_new=" + this._new + ", modified=" + this.modified + ", initialized=" + this.initialized + ", id=" + this.id + ", groupId=" + this.groupId + ", name=" + this.name + ", productName=" + this.productName + ", model=" + this.model + ", vendor=" + this.vendor + ", manufacturer=" + this.manufacturer + ", madeDate=" + this.madeDate + ", version=" + this.version + ", usedSdks=" + this.usedSdks + ", serialNo=" + this.serialNo + ", mac=" + this.mac + ", remark=" + this.remark + ", extBin=" + this.extBin + ", extTxt=" + this.extTxt + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<DeviceBean> {
    private Boolean _new;

    private Integer modified;

    private Integer initialized;

    private Integer id;

    private Integer groupId;

    private String name;

    private String productName;

    private String model;

    private String vendor;

    private String manufacturer;

    private Long madeDate;

    private String version;

    private String usedSdks;

    private String serialNo;

    private String mac;

    private String remark;

    private ByteString extBin;

    private String extTxt;

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
      this.productName = struct.productName;
      this.model = struct.model;
      this.vendor = struct.vendor;
      this.manufacturer = struct.manufacturer;
      this.madeDate = struct.madeDate;
      this.version = struct.version;
      this.usedSdks = struct.usedSdks;
      this.serialNo = struct.serialNo;
      this.mac = struct.mac;
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

    public Builder groupId(Integer groupId) {
      this.groupId = groupId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder productName(String productName) {
      this.productName = productName;
      return this;
    }

    public Builder model(String model) {
      this.model = model;
      return this;
    }

    public Builder vendor(String vendor) {
      this.vendor = vendor;
      return this;
    }

    public Builder manufacturer(String manufacturer) {
      this.manufacturer = manufacturer;
      return this;
    }

    public Builder madeDate(Long madeDate) {
      this.madeDate = madeDate;
      return this;
    }

    public Builder version(String version) {
      this.version = version;
      return this;
    }

    public Builder usedSdks(String usedSdks) {
      this.usedSdks = usedSdks;
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
      this.productName = null;
      this.model = null;
      this.vendor = null;
      this.manufacturer = null;
      this.madeDate = null;
      this.version = null;
      this.usedSdks = null;
      this.serialNo = null;
      this.mac = null;
      this.remark = null;
      this.extBin = null;
      this.extTxt = null;
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
      if (struct.productName != null) {
        protocol.writeFieldBegin("productName", 7, TType.STRING);
        protocol.writeString(struct.productName);
        protocol.writeFieldEnd();
      }
      if (struct.model != null) {
        protocol.writeFieldBegin("model", 8, TType.STRING);
        protocol.writeString(struct.model);
        protocol.writeFieldEnd();
      }
      if (struct.vendor != null) {
        protocol.writeFieldBegin("vendor", 9, TType.STRING);
        protocol.writeString(struct.vendor);
        protocol.writeFieldEnd();
      }
      if (struct.manufacturer != null) {
        protocol.writeFieldBegin("manufacturer", 10, TType.STRING);
        protocol.writeString(struct.manufacturer);
        protocol.writeFieldEnd();
      }
      if (struct.madeDate != null) {
        protocol.writeFieldBegin("madeDate", 11, TType.I64);
        protocol.writeI64(struct.madeDate);
        protocol.writeFieldEnd();
      }
      if (struct.version != null) {
        protocol.writeFieldBegin("version", 12, TType.STRING);
        protocol.writeString(struct.version);
        protocol.writeFieldEnd();
      }
      if (struct.usedSdks != null) {
        protocol.writeFieldBegin("usedSdks", 13, TType.STRING);
        protocol.writeString(struct.usedSdks);
        protocol.writeFieldEnd();
      }
      if (struct.serialNo != null) {
        protocol.writeFieldBegin("serialNo", 14, TType.STRING);
        protocol.writeString(struct.serialNo);
        protocol.writeFieldEnd();
      }
      if (struct.mac != null) {
        protocol.writeFieldBegin("mac", 15, TType.STRING);
        protocol.writeString(struct.mac);
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
              builder.productName(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 8: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.model(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 9: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.vendor(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 10: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.manufacturer(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 11: {
            if (field.typeId == TType.I64) {
              long value = protocol.readI64();
              builder.madeDate(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 12: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.version(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 13: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.usedSdks(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 14: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.serialNo(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 15: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.mac(value);
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
    public DeviceBean read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}

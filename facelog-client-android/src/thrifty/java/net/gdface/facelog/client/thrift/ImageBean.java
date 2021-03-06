// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-09-23T07:19:09.732Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 70:1
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
public final class ImageBean implements Struct {
  public static final Adapter<ImageBean, Builder> ADAPTER = new ImageBeanAdapter();

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
  public final String md5;

  @ThriftField(
      fieldId = 5,
      isOptional = true
  )
  public final String format;

  @ThriftField(
      fieldId = 6,
      isOptional = true
  )
  public final Integer width;

  @ThriftField(
      fieldId = 7,
      isOptional = true
  )
  public final Integer height;

  @ThriftField(
      fieldId = 8,
      isOptional = true
  )
  public final Integer depth;

  @ThriftField(
      fieldId = 9,
      isOptional = true
  )
  public final Integer faceNum;

  @ThriftField(
      fieldId = 10,
      isOptional = true
  )
  public final String thumbMd5;

  @ThriftField(
      fieldId = 11,
      isOptional = true
  )
  public final Integer deviceId;

  private ImageBean(Builder builder) {
    this._new = builder._new;
    this.modified = builder.modified;
    this.initialized = builder.initialized;
    this.md5 = builder.md5;
    this.format = builder.format;
    this.width = builder.width;
    this.height = builder.height;
    this.depth = builder.depth;
    this.faceNum = builder.faceNum;
    this.thumbMd5 = builder.thumbMd5;
    this.deviceId = builder.deviceId;
  }

  @Override
  @SuppressWarnings({"NumberEquality", "StringEquality"})
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof ImageBean)) return false;
    ImageBean that = (ImageBean) other;
    return (this._new == that._new || this._new.equals(that._new))
        && (this.modified == that.modified || this.modified.equals(that.modified))
        && (this.initialized == that.initialized || this.initialized.equals(that.initialized))
        && (this.md5 == that.md5 || (this.md5 != null && this.md5.equals(that.md5)))
        && (this.format == that.format || (this.format != null && this.format.equals(that.format)))
        && (this.width == that.width || (this.width != null && this.width.equals(that.width)))
        && (this.height == that.height || (this.height != null && this.height.equals(that.height)))
        && (this.depth == that.depth || (this.depth != null && this.depth.equals(that.depth)))
        && (this.faceNum == that.faceNum || (this.faceNum != null && this.faceNum.equals(that.faceNum)))
        && (this.thumbMd5 == that.thumbMd5 || (this.thumbMd5 != null && this.thumbMd5.equals(that.thumbMd5)))
        && (this.deviceId == that.deviceId || (this.deviceId != null && this.deviceId.equals(that.deviceId)));
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
    code ^= (this.md5 == null) ? 0 : this.md5.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.format == null) ? 0 : this.format.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.width == null) ? 0 : this.width.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.height == null) ? 0 : this.height.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.depth == null) ? 0 : this.depth.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.faceNum == null) ? 0 : this.faceNum.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.thumbMd5 == null) ? 0 : this.thumbMd5.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.deviceId == null) ? 0 : this.deviceId.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "ImageBean{_new=" + this._new + ", modified=" + this.modified + ", initialized=" + this.initialized + ", md5=" + this.md5 + ", format=" + this.format + ", width=" + this.width + ", height=" + this.height + ", depth=" + this.depth + ", faceNum=" + this.faceNum + ", thumbMd5=" + this.thumbMd5 + ", deviceId=" + this.deviceId + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<ImageBean> {
    private Boolean _new;

    private Integer modified;

    private Integer initialized;

    private String md5;

    private String format;

    private Integer width;

    private Integer height;

    private Integer depth;

    private Integer faceNum;

    private String thumbMd5;

    private Integer deviceId;

    public Builder() {
    }

    public Builder(ImageBean struct) {
      this._new = struct._new;
      this.modified = struct.modified;
      this.initialized = struct.initialized;
      this.md5 = struct.md5;
      this.format = struct.format;
      this.width = struct.width;
      this.height = struct.height;
      this.depth = struct.depth;
      this.faceNum = struct.faceNum;
      this.thumbMd5 = struct.thumbMd5;
      this.deviceId = struct.deviceId;
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

    public Builder md5(String md5) {
      this.md5 = md5;
      return this;
    }

    public Builder format(String format) {
      this.format = format;
      return this;
    }

    public Builder width(Integer width) {
      this.width = width;
      return this;
    }

    public Builder height(Integer height) {
      this.height = height;
      return this;
    }

    public Builder depth(Integer depth) {
      this.depth = depth;
      return this;
    }

    public Builder faceNum(Integer faceNum) {
      this.faceNum = faceNum;
      return this;
    }

    public Builder thumbMd5(String thumbMd5) {
      this.thumbMd5 = thumbMd5;
      return this;
    }

    public Builder deviceId(Integer deviceId) {
      this.deviceId = deviceId;
      return this;
    }

    @Override
    public ImageBean build() {
      if (this._new == null) {
        throw new IllegalStateException("Required field '_new' is missing");
      }
      if (this.modified == null) {
        throw new IllegalStateException("Required field 'modified' is missing");
      }
      if (this.initialized == null) {
        throw new IllegalStateException("Required field 'initialized' is missing");
      }
      return new ImageBean(this);
    }

    @Override
    public void reset() {
      this._new = null;
      this.modified = null;
      this.initialized = null;
      this.md5 = null;
      this.format = null;
      this.width = null;
      this.height = null;
      this.depth = null;
      this.faceNum = null;
      this.thumbMd5 = null;
      this.deviceId = null;
    }
  }

  private static final class ImageBeanAdapter implements Adapter<ImageBean, Builder> {
    @Override
    public void write(Protocol protocol, ImageBean struct) throws IOException {
      protocol.writeStructBegin("ImageBean");
      protocol.writeFieldBegin("_new", 1, TType.BOOL);
      protocol.writeBool(struct._new);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("modified", 2, TType.I32);
      protocol.writeI32(struct.modified);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("initialized", 3, TType.I32);
      protocol.writeI32(struct.initialized);
      protocol.writeFieldEnd();
      if (struct.md5 != null) {
        protocol.writeFieldBegin("md5", 4, TType.STRING);
        protocol.writeString(struct.md5);
        protocol.writeFieldEnd();
      }
      if (struct.format != null) {
        protocol.writeFieldBegin("format", 5, TType.STRING);
        protocol.writeString(struct.format);
        protocol.writeFieldEnd();
      }
      if (struct.width != null) {
        protocol.writeFieldBegin("width", 6, TType.I32);
        protocol.writeI32(struct.width);
        protocol.writeFieldEnd();
      }
      if (struct.height != null) {
        protocol.writeFieldBegin("height", 7, TType.I32);
        protocol.writeI32(struct.height);
        protocol.writeFieldEnd();
      }
      if (struct.depth != null) {
        protocol.writeFieldBegin("depth", 8, TType.I32);
        protocol.writeI32(struct.depth);
        protocol.writeFieldEnd();
      }
      if (struct.faceNum != null) {
        protocol.writeFieldBegin("faceNum", 9, TType.I32);
        protocol.writeI32(struct.faceNum);
        protocol.writeFieldEnd();
      }
      if (struct.thumbMd5 != null) {
        protocol.writeFieldBegin("thumbMd5", 10, TType.STRING);
        protocol.writeString(struct.thumbMd5);
        protocol.writeFieldEnd();
      }
      if (struct.deviceId != null) {
        protocol.writeFieldBegin("deviceId", 11, TType.I32);
        protocol.writeI32(struct.deviceId);
        protocol.writeFieldEnd();
      }
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public ImageBean read(Protocol protocol, Builder builder) throws IOException {
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
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.md5(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 5: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.format(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 6: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.width(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 7: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.height(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 8: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.depth(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 9: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.faceNum(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 10: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.thumbMd5(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 11: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.deviceId(value);
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
    public ImageBean read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}

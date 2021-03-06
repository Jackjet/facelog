// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2019-09-23T07:19:09.730Z
// Source: J:\facelog\facelog-service\IFaceLog.thrift at 19:1
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
public final class FaceBean implements Struct {
  public static final Adapter<FaceBean, Builder> ADAPTER = new FaceBeanAdapter();

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
  public final String imageMd5;

  @ThriftField(
      fieldId = 6,
      isOptional = true
  )
  public final Integer faceLeft;

  @ThriftField(
      fieldId = 7,
      isOptional = true
  )
  public final Integer faceTop;

  @ThriftField(
      fieldId = 8,
      isOptional = true
  )
  public final Integer faceWidth;

  @ThriftField(
      fieldId = 9,
      isOptional = true
  )
  public final Integer faceHeight;

  @ThriftField(
      fieldId = 10,
      isOptional = true
  )
  public final Integer eyeLeftx;

  @ThriftField(
      fieldId = 11,
      isOptional = true
  )
  public final Integer eyeLefty;

  @ThriftField(
      fieldId = 12,
      isOptional = true
  )
  public final Integer eyeRightx;

  @ThriftField(
      fieldId = 13,
      isOptional = true
  )
  public final Integer eyeRighty;

  @ThriftField(
      fieldId = 14,
      isOptional = true
  )
  public final Integer mouthX;

  @ThriftField(
      fieldId = 15,
      isOptional = true
  )
  public final Integer mouthY;

  @ThriftField(
      fieldId = 16,
      isOptional = true
  )
  public final Integer noseX;

  @ThriftField(
      fieldId = 17,
      isOptional = true
  )
  public final Integer noseY;

  @ThriftField(
      fieldId = 18,
      isOptional = true
  )
  public final Integer angleYaw;

  @ThriftField(
      fieldId = 19,
      isOptional = true
  )
  public final Integer anglePitch;

  @ThriftField(
      fieldId = 20,
      isOptional = true
  )
  public final Integer angleRoll;

  @ThriftField(
      fieldId = 21,
      isOptional = true
  )
  public final ByteString extInfo;

  @ThriftField(
      fieldId = 22,
      isOptional = true
  )
  public final String featureMd5;

  private FaceBean(Builder builder) {
    this._new = builder._new;
    this.modified = builder.modified;
    this.initialized = builder.initialized;
    this.id = builder.id;
    this.imageMd5 = builder.imageMd5;
    this.faceLeft = builder.faceLeft;
    this.faceTop = builder.faceTop;
    this.faceWidth = builder.faceWidth;
    this.faceHeight = builder.faceHeight;
    this.eyeLeftx = builder.eyeLeftx;
    this.eyeLefty = builder.eyeLefty;
    this.eyeRightx = builder.eyeRightx;
    this.eyeRighty = builder.eyeRighty;
    this.mouthX = builder.mouthX;
    this.mouthY = builder.mouthY;
    this.noseX = builder.noseX;
    this.noseY = builder.noseY;
    this.angleYaw = builder.angleYaw;
    this.anglePitch = builder.anglePitch;
    this.angleRoll = builder.angleRoll;
    this.extInfo = builder.extInfo;
    this.featureMd5 = builder.featureMd5;
  }

  @Override
  @SuppressWarnings({"NumberEquality", "StringEquality"})
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof FaceBean)) return false;
    FaceBean that = (FaceBean) other;
    return (this._new == that._new || this._new.equals(that._new))
        && (this.modified == that.modified || this.modified.equals(that.modified))
        && (this.initialized == that.initialized || this.initialized.equals(that.initialized))
        && (this.id == that.id || (this.id != null && this.id.equals(that.id)))
        && (this.imageMd5 == that.imageMd5 || (this.imageMd5 != null && this.imageMd5.equals(that.imageMd5)))
        && (this.faceLeft == that.faceLeft || (this.faceLeft != null && this.faceLeft.equals(that.faceLeft)))
        && (this.faceTop == that.faceTop || (this.faceTop != null && this.faceTop.equals(that.faceTop)))
        && (this.faceWidth == that.faceWidth || (this.faceWidth != null && this.faceWidth.equals(that.faceWidth)))
        && (this.faceHeight == that.faceHeight || (this.faceHeight != null && this.faceHeight.equals(that.faceHeight)))
        && (this.eyeLeftx == that.eyeLeftx || (this.eyeLeftx != null && this.eyeLeftx.equals(that.eyeLeftx)))
        && (this.eyeLefty == that.eyeLefty || (this.eyeLefty != null && this.eyeLefty.equals(that.eyeLefty)))
        && (this.eyeRightx == that.eyeRightx || (this.eyeRightx != null && this.eyeRightx.equals(that.eyeRightx)))
        && (this.eyeRighty == that.eyeRighty || (this.eyeRighty != null && this.eyeRighty.equals(that.eyeRighty)))
        && (this.mouthX == that.mouthX || (this.mouthX != null && this.mouthX.equals(that.mouthX)))
        && (this.mouthY == that.mouthY || (this.mouthY != null && this.mouthY.equals(that.mouthY)))
        && (this.noseX == that.noseX || (this.noseX != null && this.noseX.equals(that.noseX)))
        && (this.noseY == that.noseY || (this.noseY != null && this.noseY.equals(that.noseY)))
        && (this.angleYaw == that.angleYaw || (this.angleYaw != null && this.angleYaw.equals(that.angleYaw)))
        && (this.anglePitch == that.anglePitch || (this.anglePitch != null && this.anglePitch.equals(that.anglePitch)))
        && (this.angleRoll == that.angleRoll || (this.angleRoll != null && this.angleRoll.equals(that.angleRoll)))
        && (this.extInfo == that.extInfo || (this.extInfo != null && this.extInfo.equals(that.extInfo)))
        && (this.featureMd5 == that.featureMd5 || (this.featureMd5 != null && this.featureMd5.equals(that.featureMd5)));
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
    code ^= (this.imageMd5 == null) ? 0 : this.imageMd5.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.faceLeft == null) ? 0 : this.faceLeft.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.faceTop == null) ? 0 : this.faceTop.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.faceWidth == null) ? 0 : this.faceWidth.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.faceHeight == null) ? 0 : this.faceHeight.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.eyeLeftx == null) ? 0 : this.eyeLeftx.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.eyeLefty == null) ? 0 : this.eyeLefty.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.eyeRightx == null) ? 0 : this.eyeRightx.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.eyeRighty == null) ? 0 : this.eyeRighty.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.mouthX == null) ? 0 : this.mouthX.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.mouthY == null) ? 0 : this.mouthY.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.noseX == null) ? 0 : this.noseX.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.noseY == null) ? 0 : this.noseY.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.angleYaw == null) ? 0 : this.angleYaw.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.anglePitch == null) ? 0 : this.anglePitch.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.angleRoll == null) ? 0 : this.angleRoll.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.extInfo == null) ? 0 : this.extInfo.hashCode();
    code *= 0x811c9dc5;
    code ^= (this.featureMd5 == null) ? 0 : this.featureMd5.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "FaceBean{_new=" + this._new + ", modified=" + this.modified + ", initialized=" + this.initialized + ", id=" + this.id + ", imageMd5=" + this.imageMd5 + ", faceLeft=" + this.faceLeft + ", faceTop=" + this.faceTop + ", faceWidth=" + this.faceWidth + ", faceHeight=" + this.faceHeight + ", eyeLeftx=" + this.eyeLeftx + ", eyeLefty=" + this.eyeLefty + ", eyeRightx=" + this.eyeRightx + ", eyeRighty=" + this.eyeRighty + ", mouthX=" + this.mouthX + ", mouthY=" + this.mouthY + ", noseX=" + this.noseX + ", noseY=" + this.noseY + ", angleYaw=" + this.angleYaw + ", anglePitch=" + this.anglePitch + ", angleRoll=" + this.angleRoll + ", extInfo=" + this.extInfo + ", featureMd5=" + this.featureMd5 + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<FaceBean> {
    private Boolean _new;

    private Integer modified;

    private Integer initialized;

    private Integer id;

    private String imageMd5;

    private Integer faceLeft;

    private Integer faceTop;

    private Integer faceWidth;

    private Integer faceHeight;

    private Integer eyeLeftx;

    private Integer eyeLefty;

    private Integer eyeRightx;

    private Integer eyeRighty;

    private Integer mouthX;

    private Integer mouthY;

    private Integer noseX;

    private Integer noseY;

    private Integer angleYaw;

    private Integer anglePitch;

    private Integer angleRoll;

    private ByteString extInfo;

    private String featureMd5;

    public Builder() {
    }

    public Builder(FaceBean struct) {
      this._new = struct._new;
      this.modified = struct.modified;
      this.initialized = struct.initialized;
      this.id = struct.id;
      this.imageMd5 = struct.imageMd5;
      this.faceLeft = struct.faceLeft;
      this.faceTop = struct.faceTop;
      this.faceWidth = struct.faceWidth;
      this.faceHeight = struct.faceHeight;
      this.eyeLeftx = struct.eyeLeftx;
      this.eyeLefty = struct.eyeLefty;
      this.eyeRightx = struct.eyeRightx;
      this.eyeRighty = struct.eyeRighty;
      this.mouthX = struct.mouthX;
      this.mouthY = struct.mouthY;
      this.noseX = struct.noseX;
      this.noseY = struct.noseY;
      this.angleYaw = struct.angleYaw;
      this.anglePitch = struct.anglePitch;
      this.angleRoll = struct.angleRoll;
      this.extInfo = struct.extInfo;
      this.featureMd5 = struct.featureMd5;
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

    public Builder imageMd5(String imageMd5) {
      this.imageMd5 = imageMd5;
      return this;
    }

    public Builder faceLeft(Integer faceLeft) {
      this.faceLeft = faceLeft;
      return this;
    }

    public Builder faceTop(Integer faceTop) {
      this.faceTop = faceTop;
      return this;
    }

    public Builder faceWidth(Integer faceWidth) {
      this.faceWidth = faceWidth;
      return this;
    }

    public Builder faceHeight(Integer faceHeight) {
      this.faceHeight = faceHeight;
      return this;
    }

    public Builder eyeLeftx(Integer eyeLeftx) {
      this.eyeLeftx = eyeLeftx;
      return this;
    }

    public Builder eyeLefty(Integer eyeLefty) {
      this.eyeLefty = eyeLefty;
      return this;
    }

    public Builder eyeRightx(Integer eyeRightx) {
      this.eyeRightx = eyeRightx;
      return this;
    }

    public Builder eyeRighty(Integer eyeRighty) {
      this.eyeRighty = eyeRighty;
      return this;
    }

    public Builder mouthX(Integer mouthX) {
      this.mouthX = mouthX;
      return this;
    }

    public Builder mouthY(Integer mouthY) {
      this.mouthY = mouthY;
      return this;
    }

    public Builder noseX(Integer noseX) {
      this.noseX = noseX;
      return this;
    }

    public Builder noseY(Integer noseY) {
      this.noseY = noseY;
      return this;
    }

    public Builder angleYaw(Integer angleYaw) {
      this.angleYaw = angleYaw;
      return this;
    }

    public Builder anglePitch(Integer anglePitch) {
      this.anglePitch = anglePitch;
      return this;
    }

    public Builder angleRoll(Integer angleRoll) {
      this.angleRoll = angleRoll;
      return this;
    }

    public Builder extInfo(ByteString extInfo) {
      this.extInfo = extInfo;
      return this;
    }

    public Builder featureMd5(String featureMd5) {
      this.featureMd5 = featureMd5;
      return this;
    }

    @Override
    public FaceBean build() {
      if (this._new == null) {
        throw new IllegalStateException("Required field '_new' is missing");
      }
      if (this.modified == null) {
        throw new IllegalStateException("Required field 'modified' is missing");
      }
      if (this.initialized == null) {
        throw new IllegalStateException("Required field 'initialized' is missing");
      }
      return new FaceBean(this);
    }

    @Override
    public void reset() {
      this._new = null;
      this.modified = null;
      this.initialized = null;
      this.id = null;
      this.imageMd5 = null;
      this.faceLeft = null;
      this.faceTop = null;
      this.faceWidth = null;
      this.faceHeight = null;
      this.eyeLeftx = null;
      this.eyeLefty = null;
      this.eyeRightx = null;
      this.eyeRighty = null;
      this.mouthX = null;
      this.mouthY = null;
      this.noseX = null;
      this.noseY = null;
      this.angleYaw = null;
      this.anglePitch = null;
      this.angleRoll = null;
      this.extInfo = null;
      this.featureMd5 = null;
    }
  }

  private static final class FaceBeanAdapter implements Adapter<FaceBean, Builder> {
    @Override
    public void write(Protocol protocol, FaceBean struct) throws IOException {
      protocol.writeStructBegin("FaceBean");
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
      if (struct.imageMd5 != null) {
        protocol.writeFieldBegin("imageMd5", 5, TType.STRING);
        protocol.writeString(struct.imageMd5);
        protocol.writeFieldEnd();
      }
      if (struct.faceLeft != null) {
        protocol.writeFieldBegin("faceLeft", 6, TType.I32);
        protocol.writeI32(struct.faceLeft);
        protocol.writeFieldEnd();
      }
      if (struct.faceTop != null) {
        protocol.writeFieldBegin("faceTop", 7, TType.I32);
        protocol.writeI32(struct.faceTop);
        protocol.writeFieldEnd();
      }
      if (struct.faceWidth != null) {
        protocol.writeFieldBegin("faceWidth", 8, TType.I32);
        protocol.writeI32(struct.faceWidth);
        protocol.writeFieldEnd();
      }
      if (struct.faceHeight != null) {
        protocol.writeFieldBegin("faceHeight", 9, TType.I32);
        protocol.writeI32(struct.faceHeight);
        protocol.writeFieldEnd();
      }
      if (struct.eyeLeftx != null) {
        protocol.writeFieldBegin("eyeLeftx", 10, TType.I32);
        protocol.writeI32(struct.eyeLeftx);
        protocol.writeFieldEnd();
      }
      if (struct.eyeLefty != null) {
        protocol.writeFieldBegin("eyeLefty", 11, TType.I32);
        protocol.writeI32(struct.eyeLefty);
        protocol.writeFieldEnd();
      }
      if (struct.eyeRightx != null) {
        protocol.writeFieldBegin("eyeRightx", 12, TType.I32);
        protocol.writeI32(struct.eyeRightx);
        protocol.writeFieldEnd();
      }
      if (struct.eyeRighty != null) {
        protocol.writeFieldBegin("eyeRighty", 13, TType.I32);
        protocol.writeI32(struct.eyeRighty);
        protocol.writeFieldEnd();
      }
      if (struct.mouthX != null) {
        protocol.writeFieldBegin("mouthX", 14, TType.I32);
        protocol.writeI32(struct.mouthX);
        protocol.writeFieldEnd();
      }
      if (struct.mouthY != null) {
        protocol.writeFieldBegin("mouthY", 15, TType.I32);
        protocol.writeI32(struct.mouthY);
        protocol.writeFieldEnd();
      }
      if (struct.noseX != null) {
        protocol.writeFieldBegin("noseX", 16, TType.I32);
        protocol.writeI32(struct.noseX);
        protocol.writeFieldEnd();
      }
      if (struct.noseY != null) {
        protocol.writeFieldBegin("noseY", 17, TType.I32);
        protocol.writeI32(struct.noseY);
        protocol.writeFieldEnd();
      }
      if (struct.angleYaw != null) {
        protocol.writeFieldBegin("angleYaw", 18, TType.I32);
        protocol.writeI32(struct.angleYaw);
        protocol.writeFieldEnd();
      }
      if (struct.anglePitch != null) {
        protocol.writeFieldBegin("anglePitch", 19, TType.I32);
        protocol.writeI32(struct.anglePitch);
        protocol.writeFieldEnd();
      }
      if (struct.angleRoll != null) {
        protocol.writeFieldBegin("angleRoll", 20, TType.I32);
        protocol.writeI32(struct.angleRoll);
        protocol.writeFieldEnd();
      }
      if (struct.extInfo != null) {
        protocol.writeFieldBegin("extInfo", 21, TType.STRING);
        protocol.writeBinary(struct.extInfo);
        protocol.writeFieldEnd();
      }
      if (struct.featureMd5 != null) {
        protocol.writeFieldBegin("featureMd5", 22, TType.STRING);
        protocol.writeString(struct.featureMd5);
        protocol.writeFieldEnd();
      }
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public FaceBean read(Protocol protocol, Builder builder) throws IOException {
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
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.imageMd5(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 6: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.faceLeft(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 7: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.faceTop(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 8: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.faceWidth(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 9: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.faceHeight(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 10: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.eyeLeftx(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 11: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.eyeLefty(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 12: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.eyeRightx(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 13: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.eyeRighty(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 14: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.mouthX(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 15: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.mouthY(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 16: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.noseX(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 17: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.noseY(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 18: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.angleYaw(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 19: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.anglePitch(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 20: {
            if (field.typeId == TType.I32) {
              int value = protocol.readI32();
              builder.angleRoll(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 21: {
            if (field.typeId == TType.STRING) {
              ByteString value = protocol.readBinary();
              builder.extInfo(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 22: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.featureMd5(value);
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
    public FaceBean read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}

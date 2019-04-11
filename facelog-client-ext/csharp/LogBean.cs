/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Threading.Tasks;
using Thrift;
using Thrift.Collections;
using System.Runtime.Serialization;
using Thrift.Protocol;
using Thrift.Transport;


#if !SILVERLIGHT
[Serializable]
#endif
public partial class LogBean : TBase
{

  public bool _new { get; set; }

  public long Modified { get; set; }

  public long Initialized { get; set; }

  public int? Id { get; set; }

  public int? PersonId { get; set; }

  public int? DeviceId { get; set; }

  public string VerifyFeature { get; set; }

  public int? CompareFace { get; set; }

  public int? VerifyStatus { get; set; }

  public double? Similarty { get; set; }

  public long? VerifyTime { get; set; }

  public long? CreateTime { get; set; }

  public LogBean() {
  }

  public LogBean(bool _new, long modified, long initialized) : this() {
    this._new = _new;
    this.Modified = modified;
    this.Initialized = initialized;
  }

  public void Read (TProtocol iprot)
  {
    iprot.IncrementRecursionDepth();
    try
    {
      bool isset__new = false;
      bool isset_modified = false;
      bool isset_initialized = false;
      TField field;
      iprot.ReadStructBegin();
      while (true)
      {
        field = iprot.ReadFieldBegin();
        if (field.Type == TType.Stop) { 
          break;
        }
        switch (field.ID)
        {
          case 1:
            if (field.Type == TType.Bool) {
              _new = iprot.ReadBool();
              isset__new = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 2:
            if (field.Type == TType.I64) {
              Modified = iprot.ReadI64();
              isset_modified = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 3:
            if (field.Type == TType.I64) {
              Initialized = iprot.ReadI64();
              isset_initialized = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 4:
            if (field.Type == TType.I32) {
              Id = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 5:
            if (field.Type == TType.I32) {
              PersonId = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 6:
            if (field.Type == TType.I32) {
              DeviceId = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 7:
            if (field.Type == TType.String) {
              VerifyFeature = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 8:
            if (field.Type == TType.I32) {
              CompareFace = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 9:
            if (field.Type == TType.I32) {
              VerifyStatus = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 10:
            if (field.Type == TType.Double) {
              Similarty = iprot.ReadDouble();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 11:
            if (field.Type == TType.I64) {
              VerifyTime = iprot.ReadI64();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 12:
            if (field.Type == TType.I64) {
              CreateTime = iprot.ReadI64();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          default: 
            TProtocolUtil.Skip(iprot, field.Type);
            break;
        }
        iprot.ReadFieldEnd();
      }
      iprot.ReadStructEnd();
      if (!isset__new)
        throw new TProtocolException(TProtocolException.INVALID_DATA, "required field _new not set");
      if (!isset_modified)
        throw new TProtocolException(TProtocolException.INVALID_DATA, "required field Modified not set");
      if (!isset_initialized)
        throw new TProtocolException(TProtocolException.INVALID_DATA, "required field Initialized not set");
    }
    finally
    {
      iprot.DecrementRecursionDepth();
    }
  }

  public void Write(TProtocol oprot) {
    oprot.IncrementRecursionDepth();
    try
    {
      TStruct struc = new TStruct("LogBean");
      oprot.WriteStructBegin(struc);
      TField field = new TField();
      field.Name = "_new";
      field.Type = TType.Bool;
      field.ID = 1;
      oprot.WriteFieldBegin(field);
      oprot.WriteBool(_new);
      oprot.WriteFieldEnd();
      field.Name = "modified";
      field.Type = TType.I64;
      field.ID = 2;
      oprot.WriteFieldBegin(field);
      oprot.WriteI64(Modified);
      oprot.WriteFieldEnd();
      field.Name = "initialized";
      field.Type = TType.I64;
      field.ID = 3;
      oprot.WriteFieldBegin(field);
      oprot.WriteI64(Initialized);
      oprot.WriteFieldEnd();
      if (Id != null) {
        field.Name = "id";
        field.Type = TType.I32;
        field.ID = 4;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(Id.Value);
        oprot.WriteFieldEnd();
      }
      if (PersonId != null) {
        field.Name = "personId";
        field.Type = TType.I32;
        field.ID = 5;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(PersonId.Value);
        oprot.WriteFieldEnd();
      }
      if (DeviceId != null) {
        field.Name = "deviceId";
        field.Type = TType.I32;
        field.ID = 6;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(DeviceId.Value);
        oprot.WriteFieldEnd();
      }
      if (VerifyFeature != null) {
        field.Name = "verifyFeature";
        field.Type = TType.String;
        field.ID = 7;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(VerifyFeature);
        oprot.WriteFieldEnd();
      }
      if (CompareFace != null) {
        field.Name = "compareFace";
        field.Type = TType.I32;
        field.ID = 8;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(CompareFace.Value);
        oprot.WriteFieldEnd();
      }
      if (VerifyStatus != null) {
        field.Name = "verifyStatus";
        field.Type = TType.I32;
        field.ID = 9;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(VerifyStatus.Value);
        oprot.WriteFieldEnd();
      }
      if (Similarty != null) {
        field.Name = "similarty";
        field.Type = TType.Double;
        field.ID = 10;
        oprot.WriteFieldBegin(field);
        oprot.WriteDouble(Similarty.Value);
        oprot.WriteFieldEnd();
      }
      if (VerifyTime != null) {
        field.Name = "verifyTime";
        field.Type = TType.I64;
        field.ID = 11;
        oprot.WriteFieldBegin(field);
        oprot.WriteI64(VerifyTime.Value);
        oprot.WriteFieldEnd();
      }
      if (CreateTime != null) {
        field.Name = "createTime";
        field.Type = TType.I64;
        field.ID = 12;
        oprot.WriteFieldBegin(field);
        oprot.WriteI64(CreateTime.Value);
        oprot.WriteFieldEnd();
      }
      oprot.WriteFieldStop();
      oprot.WriteStructEnd();
    }
    finally
    {
      oprot.DecrementRecursionDepth();
    }
  }

  public override string ToString() {
    StringBuilder __sb = new StringBuilder("LogBean(");
    __sb.Append(", _new: ");
    __sb.Append(_new);
    __sb.Append(", Modified: ");
    __sb.Append(Modified);
    __sb.Append(", Initialized: ");
    __sb.Append(Initialized);
    if (Id != null) {
      __sb.Append(", Id: ");
      __sb.Append(Id);
    }
    if (PersonId != null) {
      __sb.Append(", PersonId: ");
      __sb.Append(PersonId);
    }
    if (DeviceId != null) {
      __sb.Append(", DeviceId: ");
      __sb.Append(DeviceId);
    }
    if (VerifyFeature != null) {
      __sb.Append(", VerifyFeature: ");
      __sb.Append(VerifyFeature);
    }
    if (CompareFace != null) {
      __sb.Append(", CompareFace: ");
      __sb.Append(CompareFace);
    }
    if (VerifyStatus != null) {
      __sb.Append(", VerifyStatus: ");
      __sb.Append(VerifyStatus);
    }
    if (Similarty != null) {
      __sb.Append(", Similarty: ");
      __sb.Append(Similarty);
    }
    if (VerifyTime != null) {
      __sb.Append(", VerifyTime: ");
      __sb.Append(VerifyTime);
    }
    if (CreateTime != null) {
      __sb.Append(", CreateTime: ");
      __sb.Append(CreateTime);
    }
    __sb.Append(")");
    return __sb.ToString();
  }

}


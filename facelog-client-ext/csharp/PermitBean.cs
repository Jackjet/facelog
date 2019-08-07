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
public partial class PermitBean : TBase
{

  public bool _new { get; set; }

  public int Modified { get; set; }

  public int Initialized { get; set; }

  public int? DeviceGroupId { get; set; }

  public int? PersonGroupId { get; set; }

  public string Schedule { get; set; }

  public string PassLimit { get; set; }

  public string Remark { get; set; }

  public byte[] ExtBin { get; set; }

  public string ExtTxt { get; set; }

  public long? CreateTime { get; set; }

  public PermitBean() {
  }

  public PermitBean(bool _new, int modified, int initialized) : this() {
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
            if (field.Type == TType.I32) {
              Modified = iprot.ReadI32();
              isset_modified = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 3:
            if (field.Type == TType.I32) {
              Initialized = iprot.ReadI32();
              isset_initialized = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 4:
            if (field.Type == TType.I32) {
              DeviceGroupId = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 5:
            if (field.Type == TType.I32) {
              PersonGroupId = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 6:
            if (field.Type == TType.String) {
              Schedule = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 7:
            if (field.Type == TType.String) {
              PassLimit = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 8:
            if (field.Type == TType.String) {
              Remark = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 9:
            if (field.Type == TType.String) {
              ExtBin = iprot.ReadBinary();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 10:
            if (field.Type == TType.String) {
              ExtTxt = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 11:
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
      TStruct struc = new TStruct("PermitBean");
      oprot.WriteStructBegin(struc);
      TField field = new TField();
      field.Name = "_new";
      field.Type = TType.Bool;
      field.ID = 1;
      oprot.WriteFieldBegin(field);
      oprot.WriteBool(_new);
      oprot.WriteFieldEnd();
      field.Name = "modified";
      field.Type = TType.I32;
      field.ID = 2;
      oprot.WriteFieldBegin(field);
      oprot.WriteI32(Modified);
      oprot.WriteFieldEnd();
      field.Name = "initialized";
      field.Type = TType.I32;
      field.ID = 3;
      oprot.WriteFieldBegin(field);
      oprot.WriteI32(Initialized);
      oprot.WriteFieldEnd();
      if (DeviceGroupId != null) {
        field.Name = "deviceGroupId";
        field.Type = TType.I32;
        field.ID = 4;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(DeviceGroupId.Value);
        oprot.WriteFieldEnd();
      }
      if (PersonGroupId != null) {
        field.Name = "personGroupId";
        field.Type = TType.I32;
        field.ID = 5;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(PersonGroupId.Value);
        oprot.WriteFieldEnd();
      }
      if (Schedule != null) {
        field.Name = "schedule";
        field.Type = TType.String;
        field.ID = 6;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(Schedule);
        oprot.WriteFieldEnd();
      }
      if (PassLimit != null) {
        field.Name = "passLimit";
        field.Type = TType.String;
        field.ID = 7;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(PassLimit);
        oprot.WriteFieldEnd();
      }
      if (Remark != null) {
        field.Name = "remark";
        field.Type = TType.String;
        field.ID = 8;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(Remark);
        oprot.WriteFieldEnd();
      }
      if (ExtBin != null) {
        field.Name = "extBin";
        field.Type = TType.String;
        field.ID = 9;
        oprot.WriteFieldBegin(field);
        oprot.WriteBinary(ExtBin);
        oprot.WriteFieldEnd();
      }
      if (ExtTxt != null) {
        field.Name = "extTxt";
        field.Type = TType.String;
        field.ID = 10;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(ExtTxt);
        oprot.WriteFieldEnd();
      }
      if (CreateTime != null) {
        field.Name = "createTime";
        field.Type = TType.I64;
        field.ID = 11;
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
    StringBuilder __sb = new StringBuilder("PermitBean(");
    __sb.Append(", _new: ");
    __sb.Append(_new);
    __sb.Append(", Modified: ");
    __sb.Append(Modified);
    __sb.Append(", Initialized: ");
    __sb.Append(Initialized);
    if (DeviceGroupId != null) {
      __sb.Append(", DeviceGroupId: ");
      __sb.Append(DeviceGroupId);
    }
    if (PersonGroupId != null) {
      __sb.Append(", PersonGroupId: ");
      __sb.Append(PersonGroupId);
    }
    if (Schedule != null) {
      __sb.Append(", Schedule: ");
      __sb.Append(Schedule);
    }
    if (PassLimit != null) {
      __sb.Append(", PassLimit: ");
      __sb.Append(PassLimit);
    }
    if (Remark != null) {
      __sb.Append(", Remark: ");
      __sb.Append(Remark);
    }
    if (ExtBin != null) {
      __sb.Append(", ExtBin: ");
      __sb.Append(ExtBin);
    }
    if (ExtTxt != null) {
      __sb.Append(", ExtTxt: ");
      __sb.Append(ExtTxt);
    }
    if (CreateTime != null) {
      __sb.Append(", CreateTime: ");
      __sb.Append(CreateTime);
    }
    __sb.Append(")");
    return __sb.ToString();
  }

}


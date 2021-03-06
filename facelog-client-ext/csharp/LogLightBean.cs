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
public partial class LogLightBean : TBase
{

  public bool _new { get; set; }

  public int Modified { get; set; }

  public int Initialized { get; set; }

  public int? Id { get; set; }

  public int? PersonId { get; set; }

  public string Name { get; set; }

  public int? PapersType { get; set; }

  public string PapersNum { get; set; }

  public long? VerifyTime { get; set; }

  public int? Direction { get; set; }

  public LogLightBean() {
  }

  public LogLightBean(bool _new, int modified, int initialized) : this() {
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
            if (field.Type == TType.String) {
              Name = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 7:
            if (field.Type == TType.I32) {
              PapersType = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 8:
            if (field.Type == TType.String) {
              PapersNum = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 9:
            if (field.Type == TType.I64) {
              VerifyTime = iprot.ReadI64();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 10:
            if (field.Type == TType.I32) {
              Direction = iprot.ReadI32();
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
      TStruct struc = new TStruct("LogLightBean");
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
      if (Name != null) {
        field.Name = "name";
        field.Type = TType.String;
        field.ID = 6;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(Name);
        oprot.WriteFieldEnd();
      }
      if (PapersType != null) {
        field.Name = "papersType";
        field.Type = TType.I32;
        field.ID = 7;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(PapersType.Value);
        oprot.WriteFieldEnd();
      }
      if (PapersNum != null) {
        field.Name = "papersNum";
        field.Type = TType.String;
        field.ID = 8;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(PapersNum);
        oprot.WriteFieldEnd();
      }
      if (VerifyTime != null) {
        field.Name = "verifyTime";
        field.Type = TType.I64;
        field.ID = 9;
        oprot.WriteFieldBegin(field);
        oprot.WriteI64(VerifyTime.Value);
        oprot.WriteFieldEnd();
      }
      if (Direction != null) {
        field.Name = "direction";
        field.Type = TType.I32;
        field.ID = 10;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(Direction.Value);
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
    StringBuilder __sb = new StringBuilder("LogLightBean(");
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
    if (Name != null) {
      __sb.Append(", Name: ");
      __sb.Append(Name);
    }
    if (PapersType != null) {
      __sb.Append(", PapersType: ");
      __sb.Append(PapersType);
    }
    if (PapersNum != null) {
      __sb.Append(", PapersNum: ");
      __sb.Append(PapersNum);
    }
    if (VerifyTime != null) {
      __sb.Append(", VerifyTime: ");
      __sb.Append(VerifyTime);
    }
    if (Direction != null) {
      __sb.Append(", Direction: ");
      __sb.Append(Direction);
    }
    __sb.Append(")");
    return __sb.ToString();
  }

}


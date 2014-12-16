/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.linkedin.pinot.common.request;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Selection
 * 
 */
public class Selection implements org.apache.thrift.TBase<Selection, Selection._Fields>, java.io.Serializable, Cloneable, Comparable<Selection> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Selection");

  private static final org.apache.thrift.protocol.TField SELECTION_COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("selectionColumns", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField SELECTION_SORT_SEQUENCE_FIELD_DESC = new org.apache.thrift.protocol.TField("selectionSortSequence", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField OFFSET_FIELD_DESC = new org.apache.thrift.protocol.TField("offset", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("size", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SelectionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SelectionTupleSchemeFactory());
  }

  private List<String> selectionColumns; // optional
  private List<SelectionSort> selectionSortSequence; // optional
  private int offset; // optional
  private int size; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SELECTION_COLUMNS((short)1, "selectionColumns"),
    SELECTION_SORT_SEQUENCE((short)2, "selectionSortSequence"),
    OFFSET((short)3, "offset"),
    SIZE((short)4, "size");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SELECTION_COLUMNS
          return SELECTION_COLUMNS;
        case 2: // SELECTION_SORT_SEQUENCE
          return SELECTION_SORT_SEQUENCE;
        case 3: // OFFSET
          return OFFSET;
        case 4: // SIZE
          return SIZE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __OFFSET_ISSET_ID = 0;
  private static final int __SIZE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.SELECTION_COLUMNS,_Fields.SELECTION_SORT_SEQUENCE,_Fields.OFFSET,_Fields.SIZE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SELECTION_COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("selectionColumns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.SELECTION_SORT_SEQUENCE, new org.apache.thrift.meta_data.FieldMetaData("selectionSortSequence", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SelectionSort.class))));
    tmpMap.put(_Fields.OFFSET, new org.apache.thrift.meta_data.FieldMetaData("offset", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SIZE, new org.apache.thrift.meta_data.FieldMetaData("size", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Selection.class, metaDataMap);
  }

  public Selection() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Selection(Selection other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSelectionColumns()) {
      List<String> __this__selectionColumns = new ArrayList<String>(other.selectionColumns);
      this.selectionColumns = __this__selectionColumns;
    }
    if (other.isSetSelectionSortSequence()) {
      List<SelectionSort> __this__selectionSortSequence = new ArrayList<SelectionSort>(other.selectionSortSequence.size());
      for (SelectionSort other_element : other.selectionSortSequence) {
        __this__selectionSortSequence.add(new SelectionSort(other_element));
      }
      this.selectionSortSequence = __this__selectionSortSequence;
    }
    this.offset = other.offset;
    this.size = other.size;
  }

  public Selection deepCopy() {
    return new Selection(this);
  }

  @Override
  public void clear() {
    this.selectionColumns = null;
    this.selectionSortSequence = null;
    setOffsetIsSet(false);
    this.offset = 0;
    setSizeIsSet(false);
    this.size = 0;
  }

  public int getSelectionColumnsSize() {
    return (this.selectionColumns == null) ? 0 : this.selectionColumns.size();
  }

  public java.util.Iterator<String> getSelectionColumnsIterator() {
    return (this.selectionColumns == null) ? null : this.selectionColumns.iterator();
  }

  public void addToSelectionColumns(String elem) {
    if (this.selectionColumns == null) {
      this.selectionColumns = new ArrayList<String>();
    }
    this.selectionColumns.add(elem);
  }

  public List<String> getSelectionColumns() {
    return this.selectionColumns;
  }

  public void setSelectionColumns(List<String> selectionColumns) {
    this.selectionColumns = selectionColumns;
  }

  public void unsetSelectionColumns() {
    this.selectionColumns = null;
  }

  /** Returns true if field selectionColumns is set (has been assigned a value) and false otherwise */
  public boolean isSetSelectionColumns() {
    return this.selectionColumns != null;
  }

  public void setSelectionColumnsIsSet(boolean value) {
    if (!value) {
      this.selectionColumns = null;
    }
  }

  public int getSelectionSortSequenceSize() {
    return (this.selectionSortSequence == null) ? 0 : this.selectionSortSequence.size();
  }

  public java.util.Iterator<SelectionSort> getSelectionSortSequenceIterator() {
    return (this.selectionSortSequence == null) ? null : this.selectionSortSequence.iterator();
  }

  public void addToSelectionSortSequence(SelectionSort elem) {
    if (this.selectionSortSequence == null) {
      this.selectionSortSequence = new ArrayList<SelectionSort>();
    }
    this.selectionSortSequence.add(elem);
  }

  public List<SelectionSort> getSelectionSortSequence() {
    return this.selectionSortSequence;
  }

  public void setSelectionSortSequence(List<SelectionSort> selectionSortSequence) {
    this.selectionSortSequence = selectionSortSequence;
  }

  public void unsetSelectionSortSequence() {
    this.selectionSortSequence = null;
  }

  /** Returns true if field selectionSortSequence is set (has been assigned a value) and false otherwise */
  public boolean isSetSelectionSortSequence() {
    return this.selectionSortSequence != null;
  }

  public void setSelectionSortSequenceIsSet(boolean value) {
    if (!value) {
      this.selectionSortSequence = null;
    }
  }

  public int getOffset() {
    return this.offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
    setOffsetIsSet(true);
  }

  public void unsetOffset() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __OFFSET_ISSET_ID);
  }

  /** Returns true if field offset is set (has been assigned a value) and false otherwise */
  public boolean isSetOffset() {
    return EncodingUtils.testBit(__isset_bitfield, __OFFSET_ISSET_ID);
  }

  public void setOffsetIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __OFFSET_ISSET_ID, value);
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
    setSizeIsSet(true);
  }

  public void unsetSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  /** Returns true if field size is set (has been assigned a value) and false otherwise */
  public boolean isSetSize() {
    return EncodingUtils.testBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  public void setSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SIZE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SELECTION_COLUMNS:
      if (value == null) {
        unsetSelectionColumns();
      } else {
        setSelectionColumns((List<String>)value);
      }
      break;

    case SELECTION_SORT_SEQUENCE:
      if (value == null) {
        unsetSelectionSortSequence();
      } else {
        setSelectionSortSequence((List<SelectionSort>)value);
      }
      break;

    case OFFSET:
      if (value == null) {
        unsetOffset();
      } else {
        setOffset((Integer)value);
      }
      break;

    case SIZE:
      if (value == null) {
        unsetSize();
      } else {
        setSize((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SELECTION_COLUMNS:
      return getSelectionColumns();

    case SELECTION_SORT_SEQUENCE:
      return getSelectionSortSequence();

    case OFFSET:
      return Integer.valueOf(getOffset());

    case SIZE:
      return Integer.valueOf(getSize());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SELECTION_COLUMNS:
      return isSetSelectionColumns();
    case SELECTION_SORT_SEQUENCE:
      return isSetSelectionSortSequence();
    case OFFSET:
      return isSetOffset();
    case SIZE:
      return isSetSize();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Selection)
      return this.equals((Selection)that);
    return false;
  }

  public boolean equals(Selection that) {
    if (that == null)
      return false;

    boolean this_present_selectionColumns = true && this.isSetSelectionColumns();
    boolean that_present_selectionColumns = true && that.isSetSelectionColumns();
    if (this_present_selectionColumns || that_present_selectionColumns) {
      if (!(this_present_selectionColumns && that_present_selectionColumns))
        return false;
      if (!this.selectionColumns.equals(that.selectionColumns))
        return false;
    }

    boolean this_present_selectionSortSequence = true && this.isSetSelectionSortSequence();
    boolean that_present_selectionSortSequence = true && that.isSetSelectionSortSequence();
    if (this_present_selectionSortSequence || that_present_selectionSortSequence) {
      if (!(this_present_selectionSortSequence && that_present_selectionSortSequence))
        return false;
      if (!this.selectionSortSequence.equals(that.selectionSortSequence))
        return false;
    }

    boolean this_present_offset = true && this.isSetOffset();
    boolean that_present_offset = true && that.isSetOffset();
    if (this_present_offset || that_present_offset) {
      if (!(this_present_offset && that_present_offset))
        return false;
      if (this.offset != that.offset)
        return false;
    }

    boolean this_present_size = true && this.isSetSize();
    boolean that_present_size = true && that.isSetSize();
    if (this_present_size || that_present_size) {
      if (!(this_present_size && that_present_size))
        return false;
      if (this.size != that.size)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Selection other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSelectionColumns()).compareTo(other.isSetSelectionColumns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSelectionColumns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.selectionColumns, other.selectionColumns);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSelectionSortSequence()).compareTo(other.isSetSelectionSortSequence());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSelectionSortSequence()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.selectionSortSequence, other.selectionSortSequence);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOffset()).compareTo(other.isSetOffset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOffset()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.offset, other.offset);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSize()).compareTo(other.isSetSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.size, other.size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Selection(");
    boolean first = true;

    if (isSetSelectionColumns()) {
      sb.append("selectionColumns:");
      if (this.selectionColumns == null) {
        sb.append("null");
      } else {
        sb.append(this.selectionColumns);
      }
      first = false;
    }
    if (isSetSelectionSortSequence()) {
      if (!first) sb.append(", ");
      sb.append("selectionSortSequence:");
      if (this.selectionSortSequence == null) {
        sb.append("null");
      } else {
        sb.append(this.selectionSortSequence);
      }
      first = false;
    }
    if (isSetOffset()) {
      if (!first) sb.append(", ");
      sb.append("offset:");
      sb.append(this.offset);
      first = false;
    }
    if (isSetSize()) {
      if (!first) sb.append(", ");
      sb.append("size:");
      sb.append(this.size);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SelectionStandardSchemeFactory implements SchemeFactory {
    public SelectionStandardScheme getScheme() {
      return new SelectionStandardScheme();
    }
  }

  private static class SelectionStandardScheme extends StandardScheme<Selection> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Selection struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SELECTION_COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list44 = iprot.readListBegin();
                struct.selectionColumns = new ArrayList<String>(_list44.size);
                for (int _i45 = 0; _i45 < _list44.size; ++_i45)
                {
                  String _elem46;
                  _elem46 = iprot.readString();
                  struct.selectionColumns.add(_elem46);
                }
                iprot.readListEnd();
              }
              struct.setSelectionColumnsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SELECTION_SORT_SEQUENCE
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list47 = iprot.readListBegin();
                struct.selectionSortSequence = new ArrayList<SelectionSort>(_list47.size);
                for (int _i48 = 0; _i48 < _list47.size; ++_i48)
                {
                  SelectionSort _elem49;
                  _elem49 = new SelectionSort();
                  _elem49.read(iprot);
                  struct.selectionSortSequence.add(_elem49);
                }
                iprot.readListEnd();
              }
              struct.setSelectionSortSequenceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // OFFSET
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.offset = iprot.readI32();
              struct.setOffsetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.size = iprot.readI32();
              struct.setSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Selection struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.selectionColumns != null) {
        if (struct.isSetSelectionColumns()) {
          oprot.writeFieldBegin(SELECTION_COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.selectionColumns.size()));
            for (String _iter50 : struct.selectionColumns)
            {
              oprot.writeString(_iter50);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.selectionSortSequence != null) {
        if (struct.isSetSelectionSortSequence()) {
          oprot.writeFieldBegin(SELECTION_SORT_SEQUENCE_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.selectionSortSequence.size()));
            for (SelectionSort _iter51 : struct.selectionSortSequence)
            {
              _iter51.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetOffset()) {
        oprot.writeFieldBegin(OFFSET_FIELD_DESC);
        oprot.writeI32(struct.offset);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSize()) {
        oprot.writeFieldBegin(SIZE_FIELD_DESC);
        oprot.writeI32(struct.size);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SelectionTupleSchemeFactory implements SchemeFactory {
    public SelectionTupleScheme getScheme() {
      return new SelectionTupleScheme();
    }
  }

  private static class SelectionTupleScheme extends TupleScheme<Selection> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Selection struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSelectionColumns()) {
        optionals.set(0);
      }
      if (struct.isSetSelectionSortSequence()) {
        optionals.set(1);
      }
      if (struct.isSetOffset()) {
        optionals.set(2);
      }
      if (struct.isSetSize()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSelectionColumns()) {
        {
          oprot.writeI32(struct.selectionColumns.size());
          for (String _iter52 : struct.selectionColumns)
          {
            oprot.writeString(_iter52);
          }
        }
      }
      if (struct.isSetSelectionSortSequence()) {
        {
          oprot.writeI32(struct.selectionSortSequence.size());
          for (SelectionSort _iter53 : struct.selectionSortSequence)
          {
            _iter53.write(oprot);
          }
        }
      }
      if (struct.isSetOffset()) {
        oprot.writeI32(struct.offset);
      }
      if (struct.isSetSize()) {
        oprot.writeI32(struct.size);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Selection struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list54 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.selectionColumns = new ArrayList<String>(_list54.size);
          for (int _i55 = 0; _i55 < _list54.size; ++_i55)
          {
            String _elem56;
            _elem56 = iprot.readString();
            struct.selectionColumns.add(_elem56);
          }
        }
        struct.setSelectionColumnsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list57 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.selectionSortSequence = new ArrayList<SelectionSort>(_list57.size);
          for (int _i58 = 0; _i58 < _list57.size; ++_i58)
          {
            SelectionSort _elem59;
            _elem59 = new SelectionSort();
            _elem59.read(iprot);
            struct.selectionSortSequence.add(_elem59);
          }
        }
        struct.setSelectionSortSequenceIsSet(true);
      }
      if (incoming.get(2)) {
        struct.offset = iprot.readI32();
        struct.setOffsetIsSet(true);
      }
      if (incoming.get(3)) {
        struct.size = iprot.readI32();
        struct.setSizeIsSet(true);
      }
    }
  }

}

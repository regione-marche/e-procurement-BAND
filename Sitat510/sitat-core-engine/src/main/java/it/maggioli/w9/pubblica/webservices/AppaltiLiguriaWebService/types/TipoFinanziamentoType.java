/**
 * TipoFinanziamentoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlValue;

public class TipoFinanziamentoType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TipoFinanziamentoType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public TipoFinanziamentoType() {}
    
    public static final java.lang.String _A = "A";
    public static final java.lang.String _B = "B";
    public static final java.lang.String _C01 = "C01";
    public static final java.lang.String _C02 = "C02";
    public static final java.lang.String _C03 = "C03";
    public static final java.lang.String _C04 = "C04";
    public static final java.lang.String _C05 = "C05";
    public static final java.lang.String _C06 = "C06";
    public static final java.lang.String _D = "D";
    public static final java.lang.String _E = "E";
    public static final java.lang.String _F = "F";
    public static final java.lang.String _G = "G";
    public static final java.lang.String _H = "H";
    public static final java.lang.String _I = "I";
    public static final TipoFinanziamentoType A = new TipoFinanziamentoType(_A);
    public static final TipoFinanziamentoType B = new TipoFinanziamentoType(_B);
    public static final TipoFinanziamentoType C01 = new TipoFinanziamentoType(_C01);
    public static final TipoFinanziamentoType C02 = new TipoFinanziamentoType(_C02);
    public static final TipoFinanziamentoType C03 = new TipoFinanziamentoType(_C03);
    public static final TipoFinanziamentoType C04 = new TipoFinanziamentoType(_C04);
    public static final TipoFinanziamentoType C05 = new TipoFinanziamentoType(_C05);
    public static final TipoFinanziamentoType C06 = new TipoFinanziamentoType(_C06);
    public static final TipoFinanziamentoType D = new TipoFinanziamentoType(_D);
    public static final TipoFinanziamentoType E = new TipoFinanziamentoType(_E);
    public static final TipoFinanziamentoType F = new TipoFinanziamentoType(_F);
    public static final TipoFinanziamentoType G = new TipoFinanziamentoType(_G);
    public static final TipoFinanziamentoType H = new TipoFinanziamentoType(_H);
    public static final TipoFinanziamentoType I = new TipoFinanziamentoType(_I);
    
    @XmlValue
    public java.lang.String getValue() { return _value_;}
    public static TipoFinanziamentoType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TipoFinanziamentoType enumeration = (TipoFinanziamentoType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TipoFinanziamentoType fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TipoFinanziamentoType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoFinanziamentoType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

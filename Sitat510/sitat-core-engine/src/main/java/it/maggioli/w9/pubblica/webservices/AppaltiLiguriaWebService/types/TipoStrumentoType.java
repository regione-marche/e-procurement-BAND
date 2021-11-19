/**
 * TipoStrumentoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlValue;

public class TipoStrumentoType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TipoStrumentoType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public TipoStrumentoType() {}
    
    public static final java.lang.String _A01 = "A01";
    public static final java.lang.String _A02 = "A02";
    public static final java.lang.String _A03 = "A03";
    public static final java.lang.String _A04 = "A04";
    public static final java.lang.String _A05 = "A05";
    public static final java.lang.String _A06 = "A06";
    public static final java.lang.String _B01 = "B01";
    public static final java.lang.String _B02 = "B02";
    public static final java.lang.String _B03 = "B03";
    public static final java.lang.String _B04 = "B04";
    public static final java.lang.String _B05 = "B05";
    public static final java.lang.String _B06 = "B06";
    public static final java.lang.String _B07 = "B07";
    public static final java.lang.String _B09 = "B09";
    public static final java.lang.String _B10 = "B10";
    public static final java.lang.String _B11 = "B11";
    public static final java.lang.String _B12 = "B12";
    public static final java.lang.String _B13 = "B13";
    public static final java.lang.String _B14 = "B14";
    public static final java.lang.String _B15 = "B15";
    public static final java.lang.String _C01 = "C01";
    public static final java.lang.String _C02 = "C02";
    public static final java.lang.String _C03 = "C03";
    public static final java.lang.String _C04 = "C04";
    public static final java.lang.String _C05 = "C05";
    public static final java.lang.String _C06 = "C06";
    public static final java.lang.String _C07 = "C07";
    public static final java.lang.String _D01 = "D01";
    public static final java.lang.String _D02 = "D02";
    public static final java.lang.String _E01 = "E01";
    public static final TipoStrumentoType A01 = new TipoStrumentoType(_A01);
    public static final TipoStrumentoType A02 = new TipoStrumentoType(_A02);
    public static final TipoStrumentoType A03 = new TipoStrumentoType(_A03);
    public static final TipoStrumentoType A04 = new TipoStrumentoType(_A04);
    public static final TipoStrumentoType A05 = new TipoStrumentoType(_A05);
    public static final TipoStrumentoType A06 = new TipoStrumentoType(_A06);
    public static final TipoStrumentoType B01 = new TipoStrumentoType(_B01);
    public static final TipoStrumentoType B02 = new TipoStrumentoType(_B02);
    public static final TipoStrumentoType B03 = new TipoStrumentoType(_B03);
    public static final TipoStrumentoType B04 = new TipoStrumentoType(_B04);
    public static final TipoStrumentoType B05 = new TipoStrumentoType(_B05);
    public static final TipoStrumentoType B06 = new TipoStrumentoType(_B06);
    public static final TipoStrumentoType B07 = new TipoStrumentoType(_B07);
    public static final TipoStrumentoType B09 = new TipoStrumentoType(_B09);
    public static final TipoStrumentoType B10 = new TipoStrumentoType(_B10);
    public static final TipoStrumentoType B11 = new TipoStrumentoType(_B11);
    public static final TipoStrumentoType B12 = new TipoStrumentoType(_B12);
    public static final TipoStrumentoType B13 = new TipoStrumentoType(_B13);
    public static final TipoStrumentoType B14 = new TipoStrumentoType(_B14);
    public static final TipoStrumentoType B15 = new TipoStrumentoType(_B15);
    public static final TipoStrumentoType C01 = new TipoStrumentoType(_C01);
    public static final TipoStrumentoType C02 = new TipoStrumentoType(_C02);
    public static final TipoStrumentoType C03 = new TipoStrumentoType(_C03);
    public static final TipoStrumentoType C04 = new TipoStrumentoType(_C04);
    public static final TipoStrumentoType C05 = new TipoStrumentoType(_C05);
    public static final TipoStrumentoType C06 = new TipoStrumentoType(_C06);
    public static final TipoStrumentoType C07 = new TipoStrumentoType(_C07);
    public static final TipoStrumentoType D01 = new TipoStrumentoType(_D01);
    public static final TipoStrumentoType D02 = new TipoStrumentoType(_D02);
    public static final TipoStrumentoType E01 = new TipoStrumentoType(_E01);
    
    @XmlValue
    public java.lang.String getValue() { return _value_;}
    public static TipoStrumentoType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TipoStrumentoType enumeration = (TipoStrumentoType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TipoStrumentoType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(TipoStrumentoType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoStrumentoType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

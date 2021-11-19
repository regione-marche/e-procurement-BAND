/**
 * ClasseImportoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlValue;

public class ClasseImportoType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ClasseImportoType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public ClasseImportoType() {}
    
    public static final java.lang.String _I = "I";
    public static final java.lang.String _II = "II";
    public static final java.lang.String _III = "III";
    public static final java.lang.String _IIIB = "IIIB";
    public static final java.lang.String _IV = "IV";
    public static final java.lang.String _IVB = "IVB";
    public static final java.lang.String _V = "V";
    public static final java.lang.String _VI = "VI";
    public static final java.lang.String _VII = "VII";
    public static final java.lang.String _VIII = "VIII";
    public static final ClasseImportoType I = new ClasseImportoType(_I);
    public static final ClasseImportoType II = new ClasseImportoType(_II);
    public static final ClasseImportoType III = new ClasseImportoType(_III);
    public static final ClasseImportoType IIIB = new ClasseImportoType(_IIIB);
    public static final ClasseImportoType IV = new ClasseImportoType(_IV);
    public static final ClasseImportoType IVB = new ClasseImportoType(_IVB);
    public static final ClasseImportoType V = new ClasseImportoType(_V);
    public static final ClasseImportoType VI = new ClasseImportoType(_VI);
    public static final ClasseImportoType VII = new ClasseImportoType(_VII);
    public static final ClasseImportoType VIII = new ClasseImportoType(_VIII);
    
    @XmlValue
    public java.lang.String getValue() { return _value_;}
    public static ClasseImportoType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ClasseImportoType enumeration = (ClasseImportoType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ClasseImportoType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ClasseImportoType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ClasseImportoType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

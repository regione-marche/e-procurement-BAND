/**
 * Condizioni.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlValue;

public class Condizioni  implements java.io.Serializable {
    private java.lang.String ID_CONDIZIONE;

    public Condizioni() {
    }

    public Condizioni(
           java.lang.String ID_CONDIZIONE) {
           this.ID_CONDIZIONE = ID_CONDIZIONE;
    }


    /**
     * Gets the ID_CONDIZIONE value for this Condizioni.
     * 
     * @return ID_CONDIZIONE
     */
    public java.lang.String getID_CONDIZIONE() {
        return ID_CONDIZIONE;
    }


    /**
     * Sets the ID_CONDIZIONE value for this Condizioni.
     * 
     * @param ID_CONDIZIONE
     */
    @XmlValue
    public void setID_CONDIZIONE(java.lang.String ID_CONDIZIONE) {
        this.ID_CONDIZIONE = ID_CONDIZIONE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Condizioni)) return false;
        Condizioni other = (Condizioni) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID_CONDIZIONE==null && other.getID_CONDIZIONE()==null) || 
             (this.ID_CONDIZIONE!=null &&
              this.ID_CONDIZIONE.equals(other.getID_CONDIZIONE())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getID_CONDIZIONE() != null) {
            _hashCode += getID_CONDIZIONE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Condizioni.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Condizioni"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_CONDIZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_CONDIZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

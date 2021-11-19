/**
 * SezioneSospensioni.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneSospensioni  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione[] DATI_SOSPENSIONI;

    public SezioneSospensioni() {
    }

    public SezioneSospensioni(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione[] DATI_SOSPENSIONI) {
           this.DATI_SOSPENSIONI = DATI_SOSPENSIONI;
    }


    /**
     * Gets the DATI_SOSPENSIONI value for this SezioneSospensioni.
     * 
     * @return DATI_SOSPENSIONI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione[] getDATI_SOSPENSIONI() {
        return DATI_SOSPENSIONI;
    }


    /**
     * Sets the DATI_SOSPENSIONI value for this SezioneSospensioni.
     * 
     * @param DATI_SOSPENSIONI
     */
    public void setDATI_SOSPENSIONI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione[] DATI_SOSPENSIONI) {
        this.DATI_SOSPENSIONI = DATI_SOSPENSIONI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneSospensioni)) return false;
        SezioneSospensioni other = (SezioneSospensioni) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_SOSPENSIONI==null && other.getDATI_SOSPENSIONI()==null) || 
             (this.DATI_SOSPENSIONI!=null &&
              java.util.Arrays.equals(this.DATI_SOSPENSIONI, other.getDATI_SOSPENSIONI())));
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
        if (getDATI_SOSPENSIONI() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDATI_SOSPENSIONI());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDATI_SOSPENSIONI(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SezioneSospensioni.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSospensioni"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_SOSPENSIONI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_SOSPENSIONI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSospensione"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiSospensione"));
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

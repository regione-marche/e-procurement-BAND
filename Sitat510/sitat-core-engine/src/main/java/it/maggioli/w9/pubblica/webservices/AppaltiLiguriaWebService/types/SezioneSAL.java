/**
 * SezioneSAL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneSAL  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento[] DATI_SAL;

    public SezioneSAL() {
    }

    public SezioneSAL(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento[] DATI_SAL) {
           this.DATI_SAL = DATI_SAL;
    }


    /**
     * Gets the DATI_SAL value for this SezioneSAL.
     * 
     * @return DATI_SAL
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento[] getDATI_SAL() {
        return DATI_SAL;
    }


    /**
     * Sets the DATI_SAL value for this SezioneSAL.
     * 
     * @param DATI_SAL
     */
    public void setDATI_SAL(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento[] DATI_SAL) {
        this.DATI_SAL = DATI_SAL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneSAL)) return false;
        SezioneSAL other = (SezioneSAL) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_SAL==null && other.getDATI_SAL()==null) || 
             (this.DATI_SAL!=null &&
              java.util.Arrays.equals(this.DATI_SAL, other.getDATI_SAL())));
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
        if (getDATI_SAL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDATI_SAL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDATI_SAL(), i);
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
        new org.apache.axis.description.TypeDesc(SezioneSAL.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSAL"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_SAL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_SAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAvanzamento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiAvanzamento"));
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

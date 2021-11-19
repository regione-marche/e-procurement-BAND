/**
 * SezioneConclusione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneConclusione  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiConclusione DATI_CONCLUSIONE;

    public SezioneConclusione() {
    }

    public SezioneConclusione(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiConclusione DATI_CONCLUSIONE) {
           this.DATI_CONCLUSIONE = DATI_CONCLUSIONE;
    }


    /**
     * Gets the DATI_CONCLUSIONE value for this SezioneConclusione.
     * 
     * @return DATI_CONCLUSIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiConclusione getDATI_CONCLUSIONE() {
        return DATI_CONCLUSIONE;
    }


    /**
     * Sets the DATI_CONCLUSIONE value for this SezioneConclusione.
     * 
     * @param DATI_CONCLUSIONE
     */
    public void setDATI_CONCLUSIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiConclusione DATI_CONCLUSIONE) {
        this.DATI_CONCLUSIONE = DATI_CONCLUSIONE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneConclusione)) return false;
        SezioneConclusione other = (SezioneConclusione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_CONCLUSIONE==null && other.getDATI_CONCLUSIONE()==null) || 
             (this.DATI_CONCLUSIONE!=null &&
              this.DATI_CONCLUSIONE.equals(other.getDATI_CONCLUSIONE())));
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
        if (getDATI_CONCLUSIONE() != null) {
            _hashCode += getDATI_CONCLUSIONE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SezioneConclusione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneConclusione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_CONCLUSIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_CONCLUSIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiConclusione"));
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

/**
 * Contratto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types")
public class Contratto  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiEnte DATI_ENTE;
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiGeneraliContratto DATI_GENERALI_CONTRATTO;

    public Contratto() {
    }

    public Contratto(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiEnte DATI_ENTE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiGeneraliContratto DATI_GENERALI_CONTRATTO) {
           this.DATI_ENTE = DATI_ENTE;
           this.DATI_GENERALI_CONTRATTO = DATI_GENERALI_CONTRATTO;
    }


    /**
     * Gets the DATI_ENTE value for this Contratto.
     * 
     * @return DATI_ENTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiEnte getDATI_ENTE() {
        return DATI_ENTE;
    }


    /**
     * Sets the DATI_ENTE value for this Contratto.
     * 
     * @param DATI_ENTE
     */
    public void setDATI_ENTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiEnte DATI_ENTE) {
        this.DATI_ENTE = DATI_ENTE;
    }


    /**
     * Gets the DATI_GENERALI_CONTRATTO value for this Contratto.
     * 
     * @return DATI_GENERALI_CONTRATTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiGeneraliContratto getDATI_GENERALI_CONTRATTO() {
        return DATI_GENERALI_CONTRATTO;
    }


    /**
     * Sets the DATI_GENERALI_CONTRATTO value for this Contratto.
     * 
     * @param DATI_GENERALI_CONTRATTO
     */
    public void setDATI_GENERALI_CONTRATTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiGeneraliContratto DATI_GENERALI_CONTRATTO) {
        this.DATI_GENERALI_CONTRATTO = DATI_GENERALI_CONTRATTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Contratto)) return false;
        Contratto other = (Contratto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_ENTE==null && other.getDATI_ENTE()==null) || 
             (this.DATI_ENTE!=null &&
              this.DATI_ENTE.equals(other.getDATI_ENTE()))) &&
            ((this.DATI_GENERALI_CONTRATTO==null && other.getDATI_GENERALI_CONTRATTO()==null) || 
             (this.DATI_GENERALI_CONTRATTO!=null &&
              this.DATI_GENERALI_CONTRATTO.equals(other.getDATI_GENERALI_CONTRATTO())));
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
        if (getDATI_ENTE() != null) {
            _hashCode += getDATI_ENTE().hashCode();
        }
        if (getDATI_GENERALI_CONTRATTO() != null) {
            _hashCode += getDATI_GENERALI_CONTRATTO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Contratto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Contratto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_ENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_ENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiEnte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_GENERALI_CONTRATTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_GENERALI_CONTRATTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiGeneraliContratto"));
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

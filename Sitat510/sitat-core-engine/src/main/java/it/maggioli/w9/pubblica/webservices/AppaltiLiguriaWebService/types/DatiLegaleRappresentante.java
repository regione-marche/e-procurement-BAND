/**
 * DatiLegaleRappresentante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiLegaleRappresentante  implements java.io.Serializable {
    private java.lang.String COGNOME;

    private java.lang.String NOME;

    private java.lang.String CODICE_FISCALE;

    public DatiLegaleRappresentante() {
    }

    public DatiLegaleRappresentante(
           java.lang.String COGNOME,
           java.lang.String NOME,
           java.lang.String CODICE_FISCALE) {
           this.COGNOME = COGNOME;
           this.NOME = NOME;
           this.CODICE_FISCALE = CODICE_FISCALE;
    }


    /**
     * Gets the COGNOME value for this DatiLegaleRappresentante.
     * 
     * @return COGNOME
     */
    public java.lang.String getCOGNOME() {
        return COGNOME;
    }


    /**
     * Sets the COGNOME value for this DatiLegaleRappresentante.
     * 
     * @param COGNOME
     */
    public void setCOGNOME(java.lang.String COGNOME) {
        this.COGNOME = COGNOME;
    }


    /**
     * Gets the NOME value for this DatiLegaleRappresentante.
     * 
     * @return NOME
     */
    public java.lang.String getNOME() {
        return NOME;
    }


    /**
     * Sets the NOME value for this DatiLegaleRappresentante.
     * 
     * @param NOME
     */
    public void setNOME(java.lang.String NOME) {
        this.NOME = NOME;
    }


    /**
     * Gets the CODICE_FISCALE value for this DatiLegaleRappresentante.
     * 
     * @return CODICE_FISCALE
     */
    public java.lang.String getCODICE_FISCALE() {
        return CODICE_FISCALE;
    }


    /**
     * Sets the CODICE_FISCALE value for this DatiLegaleRappresentante.
     * 
     * @param CODICE_FISCALE
     */
    public void setCODICE_FISCALE(java.lang.String CODICE_FISCALE) {
        this.CODICE_FISCALE = CODICE_FISCALE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiLegaleRappresentante)) return false;
        DatiLegaleRappresentante other = (DatiLegaleRappresentante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.COGNOME==null && other.getCOGNOME()==null) || 
             (this.COGNOME!=null &&
              this.COGNOME.equals(other.getCOGNOME()))) &&
            ((this.NOME==null && other.getNOME()==null) || 
             (this.NOME!=null &&
              this.NOME.equals(other.getNOME()))) &&
            ((this.CODICE_FISCALE==null && other.getCODICE_FISCALE()==null) || 
             (this.CODICE_FISCALE!=null &&
              this.CODICE_FISCALE.equals(other.getCODICE_FISCALE())));
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
        if (getCOGNOME() != null) {
            _hashCode += getCOGNOME().hashCode();
        }
        if (getNOME() != null) {
            _hashCode += getNOME().hashCode();
        }
        if (getCODICE_FISCALE() != null) {
            _hashCode += getCODICE_FISCALE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiLegaleRappresentante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiLegaleRappresentante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COGNOME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "COGNOME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NOME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NOME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODICE_FISCALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CODICE_FISCALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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

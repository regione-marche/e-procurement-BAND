/**
 * Pubblicazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class Pubblicazione  implements java.io.Serializable {
    private java.util.Calendar DATA_GUCE;

    private java.util.Calendar DATA_GURI;

    private java.util.Calendar DATA_BUR;

    private java.util.Calendar DATA_ALBO;

    private java.lang.Long QUOTIDIANI_NAZ;

    private java.lang.Long QUOTIDIANI_REG;

    private java.lang.Long QUOTIDIANI_LOC;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PROFILO_COMMITTENTE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SITO_MINISTERO_INF_TRASP;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SITO_OSSERVATORIO_CP;

    public Pubblicazione() {
    }

    public Pubblicazione(
           java.util.Calendar DATA_GUCE,
           java.util.Calendar DATA_GURI,
           java.util.Calendar DATA_BUR,
           java.util.Calendar DATA_ALBO,
           java.lang.Long QUOTIDIANI_NAZ,
           java.lang.Long QUOTIDIANI_REG,
           java.lang.Long QUOTIDIANI_LOC,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PROFILO_COMMITTENTE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SITO_MINISTERO_INF_TRASP,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SITO_OSSERVATORIO_CP) {
           this.DATA_GUCE = DATA_GUCE;
           this.DATA_GURI = DATA_GURI;
           this.DATA_BUR = DATA_BUR;
           this.DATA_ALBO = DATA_ALBO;
           this.QUOTIDIANI_NAZ = QUOTIDIANI_NAZ;
           this.QUOTIDIANI_REG = QUOTIDIANI_REG;
           this.QUOTIDIANI_LOC = QUOTIDIANI_LOC;
           this.PROFILO_COMMITTENTE = PROFILO_COMMITTENTE;
           this.SITO_MINISTERO_INF_TRASP = SITO_MINISTERO_INF_TRASP;
           this.SITO_OSSERVATORIO_CP = SITO_OSSERVATORIO_CP;
    }


    /**
     * Gets the DATA_GUCE value for this Pubblicazione.
     * 
     * @return DATA_GUCE
     */
    public java.util.Calendar getDATA_GUCE() {
        return DATA_GUCE;
    }


    /**
     * Sets the DATA_GUCE value for this Pubblicazione.
     * 
     * @param DATA_GUCE
     */
    public void setDATA_GUCE(java.util.Calendar DATA_GUCE) {
        this.DATA_GUCE = DATA_GUCE;
    }


    /**
     * Gets the DATA_GURI value for this Pubblicazione.
     * 
     * @return DATA_GURI
     */
    public java.util.Calendar getDATA_GURI() {
        return DATA_GURI;
    }


    /**
     * Sets the DATA_GURI value for this Pubblicazione.
     * 
     * @param DATA_GURI
     */
    public void setDATA_GURI(java.util.Calendar DATA_GURI) {
        this.DATA_GURI = DATA_GURI;
    }


    /**
     * Gets the DATA_BUR value for this Pubblicazione.
     * 
     * @return DATA_BUR
     */
    public java.util.Calendar getDATA_BUR() {
        return DATA_BUR;
    }


    /**
     * Sets the DATA_BUR value for this Pubblicazione.
     * 
     * @param DATA_BUR
     */
    public void setDATA_BUR(java.util.Calendar DATA_BUR) {
        this.DATA_BUR = DATA_BUR;
    }


    /**
     * Gets the DATA_ALBO value for this Pubblicazione.
     * 
     * @return DATA_ALBO
     */
    public java.util.Calendar getDATA_ALBO() {
        return DATA_ALBO;
    }


    /**
     * Sets the DATA_ALBO value for this Pubblicazione.
     * 
     * @param DATA_ALBO
     */
    public void setDATA_ALBO(java.util.Calendar DATA_ALBO) {
        this.DATA_ALBO = DATA_ALBO;
    }


    /**
     * Gets the QUOTIDIANI_NAZ value for this Pubblicazione.
     * 
     * @return QUOTIDIANI_NAZ
     */
    public java.lang.Long getQUOTIDIANI_NAZ() {
        return QUOTIDIANI_NAZ;
    }


    /**
     * Sets the QUOTIDIANI_NAZ value for this Pubblicazione.
     * 
     * @param QUOTIDIANI_NAZ
     */
    public void setQUOTIDIANI_NAZ(java.lang.Long QUOTIDIANI_NAZ) {
        this.QUOTIDIANI_NAZ = QUOTIDIANI_NAZ;
    }


    /**
     * Gets the QUOTIDIANI_REG value for this Pubblicazione.
     * 
     * @return QUOTIDIANI_REG
     */
    public java.lang.Long getQUOTIDIANI_REG() {
        return QUOTIDIANI_REG;
    }


    /**
     * Sets the QUOTIDIANI_REG value for this Pubblicazione.
     * 
     * @param QUOTIDIANI_REG
     */
    public void setQUOTIDIANI_REG(java.lang.Long QUOTIDIANI_REG) {
        this.QUOTIDIANI_REG = QUOTIDIANI_REG;
    }


    /**
     * Gets the QUOTIDIANI_LOC value for this Pubblicazione.
     * 
     * @return QUOTIDIANI_LOC
     */
    public java.lang.Long getQUOTIDIANI_LOC() {
        return QUOTIDIANI_LOC;
    }


    /**
     * Sets the QUOTIDIANI_LOC value for this Pubblicazione.
     * 
     * @param QUOTIDIANI_LOC
     */
    public void setQUOTIDIANI_LOC(java.lang.Long QUOTIDIANI_LOC) {
        this.QUOTIDIANI_LOC = QUOTIDIANI_LOC;
    }


    /**
     * Gets the PROFILO_COMMITTENTE value for this Pubblicazione.
     * 
     * @return PROFILO_COMMITTENTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getPROFILO_COMMITTENTE() {
        return PROFILO_COMMITTENTE;
    }


    /**
     * Sets the PROFILO_COMMITTENTE value for this Pubblicazione.
     * 
     * @param PROFILO_COMMITTENTE
     */
    public void setPROFILO_COMMITTENTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PROFILO_COMMITTENTE) {
        this.PROFILO_COMMITTENTE = PROFILO_COMMITTENTE;
    }


    /**
     * Gets the SITO_MINISTERO_INF_TRASP value for this Pubblicazione.
     * 
     * @return SITO_MINISTERO_INF_TRASP
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getSITO_MINISTERO_INF_TRASP() {
        return SITO_MINISTERO_INF_TRASP;
    }


    /**
     * Sets the SITO_MINISTERO_INF_TRASP value for this Pubblicazione.
     * 
     * @param SITO_MINISTERO_INF_TRASP
     */
    public void setSITO_MINISTERO_INF_TRASP(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SITO_MINISTERO_INF_TRASP) {
        this.SITO_MINISTERO_INF_TRASP = SITO_MINISTERO_INF_TRASP;
    }


    /**
     * Gets the SITO_OSSERVATORIO_CP value for this Pubblicazione.
     * 
     * @return SITO_OSSERVATORIO_CP
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getSITO_OSSERVATORIO_CP() {
        return SITO_OSSERVATORIO_CP;
    }


    /**
     * Sets the SITO_OSSERVATORIO_CP value for this Pubblicazione.
     * 
     * @param SITO_OSSERVATORIO_CP
     */
    public void setSITO_OSSERVATORIO_CP(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SITO_OSSERVATORIO_CP) {
        this.SITO_OSSERVATORIO_CP = SITO_OSSERVATORIO_CP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pubblicazione)) return false;
        Pubblicazione other = (Pubblicazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATA_GUCE==null && other.getDATA_GUCE()==null) || 
             (this.DATA_GUCE!=null &&
              this.DATA_GUCE.equals(other.getDATA_GUCE()))) &&
            ((this.DATA_GURI==null && other.getDATA_GURI()==null) || 
             (this.DATA_GURI!=null &&
              this.DATA_GURI.equals(other.getDATA_GURI()))) &&
            ((this.DATA_BUR==null && other.getDATA_BUR()==null) || 
             (this.DATA_BUR!=null &&
              this.DATA_BUR.equals(other.getDATA_BUR()))) &&
            ((this.DATA_ALBO==null && other.getDATA_ALBO()==null) || 
             (this.DATA_ALBO!=null &&
              this.DATA_ALBO.equals(other.getDATA_ALBO()))) &&
            ((this.QUOTIDIANI_NAZ==null && other.getQUOTIDIANI_NAZ()==null) || 
             (this.QUOTIDIANI_NAZ!=null &&
              this.QUOTIDIANI_NAZ.equals(other.getQUOTIDIANI_NAZ()))) &&
            ((this.QUOTIDIANI_REG==null && other.getQUOTIDIANI_REG()==null) || 
             (this.QUOTIDIANI_REG!=null &&
              this.QUOTIDIANI_REG.equals(other.getQUOTIDIANI_REG()))) &&
            ((this.QUOTIDIANI_LOC==null && other.getQUOTIDIANI_LOC()==null) || 
             (this.QUOTIDIANI_LOC!=null &&
              this.QUOTIDIANI_LOC.equals(other.getQUOTIDIANI_LOC()))) &&
            ((this.PROFILO_COMMITTENTE==null && other.getPROFILO_COMMITTENTE()==null) || 
             (this.PROFILO_COMMITTENTE!=null &&
              this.PROFILO_COMMITTENTE.equals(other.getPROFILO_COMMITTENTE()))) &&
            ((this.SITO_MINISTERO_INF_TRASP==null && other.getSITO_MINISTERO_INF_TRASP()==null) || 
             (this.SITO_MINISTERO_INF_TRASP!=null &&
              this.SITO_MINISTERO_INF_TRASP.equals(other.getSITO_MINISTERO_INF_TRASP()))) &&
            ((this.SITO_OSSERVATORIO_CP==null && other.getSITO_OSSERVATORIO_CP()==null) || 
             (this.SITO_OSSERVATORIO_CP!=null &&
              this.SITO_OSSERVATORIO_CP.equals(other.getSITO_OSSERVATORIO_CP())));
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
        if (getDATA_GUCE() != null) {
            _hashCode += getDATA_GUCE().hashCode();
        }
        if (getDATA_GURI() != null) {
            _hashCode += getDATA_GURI().hashCode();
        }
        if (getDATA_BUR() != null) {
            _hashCode += getDATA_BUR().hashCode();
        }
        if (getDATA_ALBO() != null) {
            _hashCode += getDATA_ALBO().hashCode();
        }
        if (getQUOTIDIANI_NAZ() != null) {
            _hashCode += getQUOTIDIANI_NAZ().hashCode();
        }
        if (getQUOTIDIANI_REG() != null) {
            _hashCode += getQUOTIDIANI_REG().hashCode();
        }
        if (getQUOTIDIANI_LOC() != null) {
            _hashCode += getQUOTIDIANI_LOC().hashCode();
        }
        if (getPROFILO_COMMITTENTE() != null) {
            _hashCode += getPROFILO_COMMITTENTE().hashCode();
        }
        if (getSITO_MINISTERO_INF_TRASP() != null) {
            _hashCode += getSITO_MINISTERO_INF_TRASP().hashCode();
        }
        if (getSITO_OSSERVATORIO_CP() != null) {
            _hashCode += getSITO_OSSERVATORIO_CP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pubblicazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Pubblicazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_GUCE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_GUCE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_GURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_GURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_BUR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_BUR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_ALBO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_ALBO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("QUOTIDIANI_NAZ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "QUOTIDIANI_NAZ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("QUOTIDIANI_REG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "QUOTIDIANI_REG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("QUOTIDIANI_LOC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "QUOTIDIANI_LOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROFILO_COMMITTENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PROFILO_COMMITTENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SITO_MINISTERO_INF_TRASP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SITO_MINISTERO_INF_TRASP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SITO_OSSERVATORIO_CP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SITO_OSSERVATORIO_CP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
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

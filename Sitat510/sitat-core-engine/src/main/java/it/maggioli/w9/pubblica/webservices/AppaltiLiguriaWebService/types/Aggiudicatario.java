/**
 * Aggiudicatario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class Aggiudicatario  implements java.io.Serializable {
    private java.lang.String TIPOLOGIA_SOGGETTO;

    private java.lang.String RUOLO;

    private java.lang.String FLAG_AVVALIMENTO;

    private java.lang.Long ID_GRUPPO;

    private java.lang.String MOTIVO_AVVALIMENTO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario_avv;

    public Aggiudicatario() {
    }

    public Aggiudicatario(
           java.lang.String TIPOLOGIA_SOGGETTO,
           java.lang.String RUOLO,
           java.lang.String FLAG_AVVALIMENTO,
           java.lang.Long ID_GRUPPO,
           java.lang.String MOTIVO_AVVALIMENTO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario_avv) {
           this.TIPOLOGIA_SOGGETTO = TIPOLOGIA_SOGGETTO;
           this.RUOLO = RUOLO;
           this.FLAG_AVVALIMENTO = FLAG_AVVALIMENTO;
           this.ID_GRUPPO = ID_GRUPPO;
           this.MOTIVO_AVVALIMENTO = MOTIVO_AVVALIMENTO;
           this.aggiudicatario = aggiudicatario;
           this.aggiudicatario_avv = aggiudicatario_avv;
    }


    /**
     * Gets the TIPOLOGIA_SOGGETTO value for this Aggiudicatario.
     * 
     * @return TIPOLOGIA_SOGGETTO
     */
    public java.lang.String getTIPOLOGIA_SOGGETTO() {
        return TIPOLOGIA_SOGGETTO;
    }


    /**
     * Sets the TIPOLOGIA_SOGGETTO value for this Aggiudicatario.
     * 
     * @param TIPOLOGIA_SOGGETTO
     */
    public void setTIPOLOGIA_SOGGETTO(java.lang.String TIPOLOGIA_SOGGETTO) {
        this.TIPOLOGIA_SOGGETTO = TIPOLOGIA_SOGGETTO;
    }


    /**
     * Gets the RUOLO value for this Aggiudicatario.
     * 
     * @return RUOLO
     */
    public java.lang.String getRUOLO() {
        return RUOLO;
    }


    /**
     * Sets the RUOLO value for this Aggiudicatario.
     * 
     * @param RUOLO
     */
    public void setRUOLO(java.lang.String RUOLO) {
        this.RUOLO = RUOLO;
    }


    /**
     * Gets the FLAG_AVVALIMENTO value for this Aggiudicatario.
     * 
     * @return FLAG_AVVALIMENTO
     */
    public java.lang.String getFLAG_AVVALIMENTO() {
        return FLAG_AVVALIMENTO;
    }


    /**
     * Sets the FLAG_AVVALIMENTO value for this Aggiudicatario.
     * 
     * @param FLAG_AVVALIMENTO
     */
    public void setFLAG_AVVALIMENTO(java.lang.String FLAG_AVVALIMENTO) {
        this.FLAG_AVVALIMENTO = FLAG_AVVALIMENTO;
    }


    /**
     * Gets the ID_GRUPPO value for this Aggiudicatario.
     * 
     * @return ID_GRUPPO
     */
    public java.lang.Long getID_GRUPPO() {
        return ID_GRUPPO;
    }


    /**
     * Sets the ID_GRUPPO value for this Aggiudicatario.
     * 
     * @param ID_GRUPPO
     */
    public void setID_GRUPPO(java.lang.Long ID_GRUPPO) {
        this.ID_GRUPPO = ID_GRUPPO;
    }


    /**
     * Gets the MOTIVO_AVVALIMENTO value for this Aggiudicatario.
     * 
     * @return MOTIVO_AVVALIMENTO
     */
    public java.lang.String getMOTIVO_AVVALIMENTO() {
        return MOTIVO_AVVALIMENTO;
    }


    /**
     * Sets the MOTIVO_AVVALIMENTO value for this Aggiudicatario.
     * 
     * @param MOTIVO_AVVALIMENTO
     */
    public void setMOTIVO_AVVALIMENTO(java.lang.String MOTIVO_AVVALIMENTO) {
        this.MOTIVO_AVVALIMENTO = MOTIVO_AVVALIMENTO;
    }


    /**
     * Gets the aggiudicatario value for this Aggiudicatario.
     * 
     * @return aggiudicatario
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari getAggiudicatario() {
        return aggiudicatario;
    }


    /**
     * Sets the aggiudicatario value for this Aggiudicatario.
     * 
     * @param aggiudicatario
     */
    public void setAggiudicatario(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario) {
        this.aggiudicatario = aggiudicatario;
    }


    /**
     * Gets the aggiudicatario_avv value for this Aggiudicatario.
     * 
     * @return aggiudicatario_avv
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari getAggiudicatario_avv() {
        return aggiudicatario_avv;
    }


    /**
     * Sets the aggiudicatario_avv value for this Aggiudicatario.
     * 
     * @param aggiudicatario_avv
     */
    public void setAggiudicatario_avv(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario_avv) {
        this.aggiudicatario_avv = aggiudicatario_avv;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Aggiudicatario)) return false;
        Aggiudicatario other = (Aggiudicatario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.TIPOLOGIA_SOGGETTO==null && other.getTIPOLOGIA_SOGGETTO()==null) || 
             (this.TIPOLOGIA_SOGGETTO!=null &&
              this.TIPOLOGIA_SOGGETTO.equals(other.getTIPOLOGIA_SOGGETTO()))) &&
            ((this.RUOLO==null && other.getRUOLO()==null) || 
             (this.RUOLO!=null &&
              this.RUOLO.equals(other.getRUOLO()))) &&
            ((this.FLAG_AVVALIMENTO==null && other.getFLAG_AVVALIMENTO()==null) || 
             (this.FLAG_AVVALIMENTO!=null &&
              this.FLAG_AVVALIMENTO.equals(other.getFLAG_AVVALIMENTO()))) &&
            ((this.ID_GRUPPO==null && other.getID_GRUPPO()==null) || 
             (this.ID_GRUPPO!=null &&
              this.ID_GRUPPO.equals(other.getID_GRUPPO()))) &&
            ((this.MOTIVO_AVVALIMENTO==null && other.getMOTIVO_AVVALIMENTO()==null) || 
             (this.MOTIVO_AVVALIMENTO!=null &&
              this.MOTIVO_AVVALIMENTO.equals(other.getMOTIVO_AVVALIMENTO()))) &&
            ((this.aggiudicatario==null && other.getAggiudicatario()==null) || 
             (this.aggiudicatario!=null &&
              this.aggiudicatario.equals(other.getAggiudicatario()))) &&
            ((this.aggiudicatario_avv==null && other.getAggiudicatario_avv()==null) || 
             (this.aggiudicatario_avv!=null &&
              this.aggiudicatario_avv.equals(other.getAggiudicatario_avv())));
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
        if (getTIPOLOGIA_SOGGETTO() != null) {
            _hashCode += getTIPOLOGIA_SOGGETTO().hashCode();
        }
        if (getRUOLO() != null) {
            _hashCode += getRUOLO().hashCode();
        }
        if (getFLAG_AVVALIMENTO() != null) {
            _hashCode += getFLAG_AVVALIMENTO().hashCode();
        }
        if (getID_GRUPPO() != null) {
            _hashCode += getID_GRUPPO().hashCode();
        }
        if (getMOTIVO_AVVALIMENTO() != null) {
            _hashCode += getMOTIVO_AVVALIMENTO().hashCode();
        }
        if (getAggiudicatario() != null) {
            _hashCode += getAggiudicatario().hashCode();
        }
        if (getAggiudicatario_avv() != null) {
            _hashCode += getAggiudicatario_avv().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Aggiudicatario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Aggiudicatario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPOLOGIA_SOGGETTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TIPOLOGIA_SOGGETTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RUOLO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "RUOLO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_AVVALIMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_AVVALIMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_GRUPPO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_GRUPPO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOTIVO_AVVALIMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MOTIVO_AVVALIMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggiudicatario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "aggiudicatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicatari"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggiudicatario_avv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "aggiudicatario_avv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicatari"));
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

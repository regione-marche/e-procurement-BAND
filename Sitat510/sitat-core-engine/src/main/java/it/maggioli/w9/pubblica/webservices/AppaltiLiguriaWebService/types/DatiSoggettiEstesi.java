/**
 * DatiSoggettiEstesi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiSoggettiEstesi  implements java.io.Serializable {
    private java.lang.String ID_RUOLO;

    private java.lang.String CIG_PROG_ESTERNA;

    private java.util.Calendar DATA_AFF_PROG_ESTERNA;

    private java.util.Calendar DATA_CONS_PROG_ESTERNA;

    private java.lang.String SEZIONE;

    private java.lang.Double COSTO_PROGETTO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagCollaudatoreType FLAG_COLLAUDATORE;

    private java.lang.Double IMPORTO_COLLAUDATORE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile responsabile;

    public DatiSoggettiEstesi() {
    }

    public DatiSoggettiEstesi(
           java.lang.String ID_RUOLO,
           java.lang.String CIG_PROG_ESTERNA,
           java.util.Calendar DATA_AFF_PROG_ESTERNA,
           java.util.Calendar DATA_CONS_PROG_ESTERNA,
           java.lang.String SEZIONE,
           java.lang.Double COSTO_PROGETTO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagCollaudatoreType FLAG_COLLAUDATORE,
           java.lang.Double IMPORTO_COLLAUDATORE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile responsabile) {
           this.ID_RUOLO = ID_RUOLO;
           this.CIG_PROG_ESTERNA = CIG_PROG_ESTERNA;
           this.DATA_AFF_PROG_ESTERNA = DATA_AFF_PROG_ESTERNA;
           this.DATA_CONS_PROG_ESTERNA = DATA_CONS_PROG_ESTERNA;
           this.SEZIONE = SEZIONE;
           this.COSTO_PROGETTO = COSTO_PROGETTO;
           this.FLAG_COLLAUDATORE = FLAG_COLLAUDATORE;
           this.IMPORTO_COLLAUDATORE = IMPORTO_COLLAUDATORE;
           this.responsabile = responsabile;
    }


    /**
     * Gets the ID_RUOLO value for this DatiSoggettiEstesi.
     * 
     * @return ID_RUOLO
     */
    public java.lang.String getID_RUOLO() {
        return ID_RUOLO;
    }


    /**
     * Sets the ID_RUOLO value for this DatiSoggettiEstesi.
     * 
     * @param ID_RUOLO
     */
    public void setID_RUOLO(java.lang.String ID_RUOLO) {
        this.ID_RUOLO = ID_RUOLO;
    }


    /**
     * Gets the CIG_PROG_ESTERNA value for this DatiSoggettiEstesi.
     * 
     * @return CIG_PROG_ESTERNA
     */
    public java.lang.String getCIG_PROG_ESTERNA() {
        return CIG_PROG_ESTERNA;
    }


    /**
     * Sets the CIG_PROG_ESTERNA value for this DatiSoggettiEstesi.
     * 
     * @param CIG_PROG_ESTERNA
     */
    public void setCIG_PROG_ESTERNA(java.lang.String CIG_PROG_ESTERNA) {
        this.CIG_PROG_ESTERNA = CIG_PROG_ESTERNA;
    }


    /**
     * Gets the DATA_AFF_PROG_ESTERNA value for this DatiSoggettiEstesi.
     * 
     * @return DATA_AFF_PROG_ESTERNA
     */
    public java.util.Calendar getDATA_AFF_PROG_ESTERNA() {
        return DATA_AFF_PROG_ESTERNA;
    }


    /**
     * Sets the DATA_AFF_PROG_ESTERNA value for this DatiSoggettiEstesi.
     * 
     * @param DATA_AFF_PROG_ESTERNA
     */
    public void setDATA_AFF_PROG_ESTERNA(java.util.Calendar DATA_AFF_PROG_ESTERNA) {
        this.DATA_AFF_PROG_ESTERNA = DATA_AFF_PROG_ESTERNA;
    }


    /**
     * Gets the DATA_CONS_PROG_ESTERNA value for this DatiSoggettiEstesi.
     * 
     * @return DATA_CONS_PROG_ESTERNA
     */
    public java.util.Calendar getDATA_CONS_PROG_ESTERNA() {
        return DATA_CONS_PROG_ESTERNA;
    }


    /**
     * Sets the DATA_CONS_PROG_ESTERNA value for this DatiSoggettiEstesi.
     * 
     * @param DATA_CONS_PROG_ESTERNA
     */
    public void setDATA_CONS_PROG_ESTERNA(java.util.Calendar DATA_CONS_PROG_ESTERNA) {
        this.DATA_CONS_PROG_ESTERNA = DATA_CONS_PROG_ESTERNA;
    }


    /**
     * Gets the SEZIONE value for this DatiSoggettiEstesi.
     * 
     * @return SEZIONE
     */
    public java.lang.String getSEZIONE() {
        return SEZIONE;
    }


    /**
     * Sets the SEZIONE value for this DatiSoggettiEstesi.
     * 
     * @param SEZIONE
     */
    public void setSEZIONE(java.lang.String SEZIONE) {
        this.SEZIONE = SEZIONE;
    }


    /**
     * Gets the COSTO_PROGETTO value for this DatiSoggettiEstesi.
     * 
     * @return COSTO_PROGETTO
     */
    public java.lang.Double getCOSTO_PROGETTO() {
        return COSTO_PROGETTO;
    }


    /**
     * Sets the COSTO_PROGETTO value for this DatiSoggettiEstesi.
     * 
     * @param COSTO_PROGETTO
     */
    public void setCOSTO_PROGETTO(java.lang.Double COSTO_PROGETTO) {
        this.COSTO_PROGETTO = COSTO_PROGETTO;
    }


    /**
     * Gets the FLAG_COLLAUDATORE value for this DatiSoggettiEstesi.
     * 
     * @return FLAG_COLLAUDATORE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagCollaudatoreType getFLAG_COLLAUDATORE() {
        return FLAG_COLLAUDATORE;
    }


    /**
     * Sets the FLAG_COLLAUDATORE value for this DatiSoggettiEstesi.
     * 
     * @param FLAG_COLLAUDATORE
     */
    public void setFLAG_COLLAUDATORE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagCollaudatoreType FLAG_COLLAUDATORE) {
        this.FLAG_COLLAUDATORE = FLAG_COLLAUDATORE;
    }


    /**
     * Gets the IMPORTO_COLLAUDATORE value for this DatiSoggettiEstesi.
     * 
     * @return IMPORTO_COLLAUDATORE
     */
    public java.lang.Double getIMPORTO_COLLAUDATORE() {
        return IMPORTO_COLLAUDATORE;
    }


    /**
     * Sets the IMPORTO_COLLAUDATORE value for this DatiSoggettiEstesi.
     * 
     * @param IMPORTO_COLLAUDATORE
     */
    public void setIMPORTO_COLLAUDATORE(java.lang.Double IMPORTO_COLLAUDATORE) {
        this.IMPORTO_COLLAUDATORE = IMPORTO_COLLAUDATORE;
    }


    /**
     * Gets the responsabile value for this DatiSoggettiEstesi.
     * 
     * @return responsabile
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile getResponsabile() {
        return responsabile;
    }


    /**
     * Sets the responsabile value for this DatiSoggettiEstesi.
     * 
     * @param responsabile
     */
    public void setResponsabile(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile responsabile) {
        this.responsabile = responsabile;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiSoggettiEstesi)) return false;
        DatiSoggettiEstesi other = (DatiSoggettiEstesi) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID_RUOLO==null && other.getID_RUOLO()==null) || 
             (this.ID_RUOLO!=null &&
              this.ID_RUOLO.equals(other.getID_RUOLO()))) &&
            ((this.CIG_PROG_ESTERNA==null && other.getCIG_PROG_ESTERNA()==null) || 
             (this.CIG_PROG_ESTERNA!=null &&
              this.CIG_PROG_ESTERNA.equals(other.getCIG_PROG_ESTERNA()))) &&
            ((this.DATA_AFF_PROG_ESTERNA==null && other.getDATA_AFF_PROG_ESTERNA()==null) || 
             (this.DATA_AFF_PROG_ESTERNA!=null &&
              this.DATA_AFF_PROG_ESTERNA.equals(other.getDATA_AFF_PROG_ESTERNA()))) &&
            ((this.DATA_CONS_PROG_ESTERNA==null && other.getDATA_CONS_PROG_ESTERNA()==null) || 
             (this.DATA_CONS_PROG_ESTERNA!=null &&
              this.DATA_CONS_PROG_ESTERNA.equals(other.getDATA_CONS_PROG_ESTERNA()))) &&
            ((this.SEZIONE==null && other.getSEZIONE()==null) || 
             (this.SEZIONE!=null &&
              this.SEZIONE.equals(other.getSEZIONE()))) &&
            ((this.COSTO_PROGETTO==null && other.getCOSTO_PROGETTO()==null) || 
             (this.COSTO_PROGETTO!=null &&
              this.COSTO_PROGETTO.equals(other.getCOSTO_PROGETTO()))) &&
            ((this.FLAG_COLLAUDATORE==null && other.getFLAG_COLLAUDATORE()==null) || 
             (this.FLAG_COLLAUDATORE!=null &&
              this.FLAG_COLLAUDATORE.equals(other.getFLAG_COLLAUDATORE()))) &&
            ((this.IMPORTO_COLLAUDATORE==null && other.getIMPORTO_COLLAUDATORE()==null) || 
             (this.IMPORTO_COLLAUDATORE!=null &&
              this.IMPORTO_COLLAUDATORE.equals(other.getIMPORTO_COLLAUDATORE()))) &&
            ((this.responsabile==null && other.getResponsabile()==null) || 
             (this.responsabile!=null &&
              this.responsabile.equals(other.getResponsabile())));
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
        if (getID_RUOLO() != null) {
            _hashCode += getID_RUOLO().hashCode();
        }
        if (getCIG_PROG_ESTERNA() != null) {
            _hashCode += getCIG_PROG_ESTERNA().hashCode();
        }
        if (getDATA_AFF_PROG_ESTERNA() != null) {
            _hashCode += getDATA_AFF_PROG_ESTERNA().hashCode();
        }
        if (getDATA_CONS_PROG_ESTERNA() != null) {
            _hashCode += getDATA_CONS_PROG_ESTERNA().hashCode();
        }
        if (getSEZIONE() != null) {
            _hashCode += getSEZIONE().hashCode();
        }
        if (getCOSTO_PROGETTO() != null) {
            _hashCode += getCOSTO_PROGETTO().hashCode();
        }
        if (getFLAG_COLLAUDATORE() != null) {
            _hashCode += getFLAG_COLLAUDATORE().hashCode();
        }
        if (getIMPORTO_COLLAUDATORE() != null) {
            _hashCode += getIMPORTO_COLLAUDATORE().hashCode();
        }
        if (getResponsabile() != null) {
            _hashCode += getResponsabile().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiSoggettiEstesi.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSoggettiEstesi"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_RUOLO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_RUOLO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CIG_PROG_ESTERNA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CIG_PROG_ESTERNA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_AFF_PROG_ESTERNA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_AFF_PROG_ESTERNA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_CONS_PROG_ESTERNA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_CONS_PROG_ESTERNA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COSTO_PROGETTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "COSTO_PROGETTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_COLLAUDATORE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_COLLAUDATORE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagCollaudatoreType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_COLLAUDATORE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_COLLAUDATORE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsabile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "responsabile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiResponsabile"));
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

/**
 * DatiRecesso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiRecesso  implements java.io.Serializable {
    private java.util.Calendar DATA_TERMINE;

    private java.util.Calendar DATA_CONSEGNA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagTCType FLAG_TIPO_COMUNICAZIONE;

    private long DURATA_SOSP;

    private java.lang.String MOTIVO_SOSP;

    private java.util.Calendar DATA_IST_RECESSO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_ACCOLTA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_TARDIVA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RIPRESA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVA;

    private java.lang.Double IMPORTO_SPESE;

    private java.lang.Double IMPORTO_ONERI;

    private java.lang.Long GG_RITARDO;

    public DatiRecesso() {
    }

    public DatiRecesso(
           java.util.Calendar DATA_TERMINE,
           java.util.Calendar DATA_CONSEGNA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagTCType FLAG_TIPO_COMUNICAZIONE,
           long DURATA_SOSP,
           java.lang.String MOTIVO_SOSP,
           java.util.Calendar DATA_IST_RECESSO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_ACCOLTA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_TARDIVA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RIPRESA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVA,
           java.lang.Double IMPORTO_SPESE,
           java.lang.Double IMPORTO_ONERI,
           java.lang.Long GG_RITARDO) {
           this.DATA_TERMINE = DATA_TERMINE;
           this.DATA_CONSEGNA = DATA_CONSEGNA;
           this.FLAG_TIPO_COMUNICAZIONE = FLAG_TIPO_COMUNICAZIONE;
           this.DURATA_SOSP = DURATA_SOSP;
           this.MOTIVO_SOSP = MOTIVO_SOSP;
           this.DATA_IST_RECESSO = DATA_IST_RECESSO;
           this.FLAG_ACCOLTA = FLAG_ACCOLTA;
           this.FLAG_TARDIVA = FLAG_TARDIVA;
           this.FLAG_RIPRESA = FLAG_RIPRESA;
           this.FLAG_RISERVA = FLAG_RISERVA;
           this.IMPORTO_SPESE = IMPORTO_SPESE;
           this.IMPORTO_ONERI = IMPORTO_ONERI;
           this.GG_RITARDO = GG_RITARDO;
    }


    /**
     * Gets the DATA_TERMINE value for this DatiRecesso.
     * 
     * @return DATA_TERMINE
     */
    public java.util.Calendar getDATA_TERMINE() {
        return DATA_TERMINE;
    }


    /**
     * Sets the DATA_TERMINE value for this DatiRecesso.
     * 
     * @param DATA_TERMINE
     */
    public void setDATA_TERMINE(java.util.Calendar DATA_TERMINE) {
        this.DATA_TERMINE = DATA_TERMINE;
    }


    /**
     * Gets the DATA_CONSEGNA value for this DatiRecesso.
     * 
     * @return DATA_CONSEGNA
     */
    public java.util.Calendar getDATA_CONSEGNA() {
        return DATA_CONSEGNA;
    }


    /**
     * Sets the DATA_CONSEGNA value for this DatiRecesso.
     * 
     * @param DATA_CONSEGNA
     */
    public void setDATA_CONSEGNA(java.util.Calendar DATA_CONSEGNA) {
        this.DATA_CONSEGNA = DATA_CONSEGNA;
    }


    /**
     * Gets the FLAG_TIPO_COMUNICAZIONE value for this DatiRecesso.
     * 
     * @return FLAG_TIPO_COMUNICAZIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagTCType getFLAG_TIPO_COMUNICAZIONE() {
        return FLAG_TIPO_COMUNICAZIONE;
    }


    /**
     * Sets the FLAG_TIPO_COMUNICAZIONE value for this DatiRecesso.
     * 
     * @param FLAG_TIPO_COMUNICAZIONE
     */
    public void setFLAG_TIPO_COMUNICAZIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagTCType FLAG_TIPO_COMUNICAZIONE) {
        this.FLAG_TIPO_COMUNICAZIONE = FLAG_TIPO_COMUNICAZIONE;
    }


    /**
     * Gets the DURATA_SOSP value for this DatiRecesso.
     * 
     * @return DURATA_SOSP
     */
    public long getDURATA_SOSP() {
        return DURATA_SOSP;
    }


    /**
     * Sets the DURATA_SOSP value for this DatiRecesso.
     * 
     * @param DURATA_SOSP
     */
    public void setDURATA_SOSP(long DURATA_SOSP) {
        this.DURATA_SOSP = DURATA_SOSP;
    }


    /**
     * Gets the MOTIVO_SOSP value for this DatiRecesso.
     * 
     * @return MOTIVO_SOSP
     */
    public java.lang.String getMOTIVO_SOSP() {
        return MOTIVO_SOSP;
    }


    /**
     * Sets the MOTIVO_SOSP value for this DatiRecesso.
     * 
     * @param MOTIVO_SOSP
     */
    public void setMOTIVO_SOSP(java.lang.String MOTIVO_SOSP) {
        this.MOTIVO_SOSP = MOTIVO_SOSP;
    }


    /**
     * Gets the DATA_IST_RECESSO value for this DatiRecesso.
     * 
     * @return DATA_IST_RECESSO
     */
    public java.util.Calendar getDATA_IST_RECESSO() {
        return DATA_IST_RECESSO;
    }


    /**
     * Sets the DATA_IST_RECESSO value for this DatiRecesso.
     * 
     * @param DATA_IST_RECESSO
     */
    public void setDATA_IST_RECESSO(java.util.Calendar DATA_IST_RECESSO) {
        this.DATA_IST_RECESSO = DATA_IST_RECESSO;
    }


    /**
     * Gets the FLAG_ACCOLTA value for this DatiRecesso.
     * 
     * @return FLAG_ACCOLTA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_ACCOLTA() {
        return FLAG_ACCOLTA;
    }


    /**
     * Sets the FLAG_ACCOLTA value for this DatiRecesso.
     * 
     * @param FLAG_ACCOLTA
     */
    public void setFLAG_ACCOLTA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_ACCOLTA) {
        this.FLAG_ACCOLTA = FLAG_ACCOLTA;
    }


    /**
     * Gets the FLAG_TARDIVA value for this DatiRecesso.
     * 
     * @return FLAG_TARDIVA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_TARDIVA() {
        return FLAG_TARDIVA;
    }


    /**
     * Sets the FLAG_TARDIVA value for this DatiRecesso.
     * 
     * @param FLAG_TARDIVA
     */
    public void setFLAG_TARDIVA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_TARDIVA) {
        this.FLAG_TARDIVA = FLAG_TARDIVA;
    }


    /**
     * Gets the FLAG_RIPRESA value for this DatiRecesso.
     * 
     * @return FLAG_RIPRESA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_RIPRESA() {
        return FLAG_RIPRESA;
    }


    /**
     * Sets the FLAG_RIPRESA value for this DatiRecesso.
     * 
     * @param FLAG_RIPRESA
     */
    public void setFLAG_RIPRESA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RIPRESA) {
        this.FLAG_RIPRESA = FLAG_RIPRESA;
    }


    /**
     * Gets the FLAG_RISERVA value for this DatiRecesso.
     * 
     * @return FLAG_RISERVA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_RISERVA() {
        return FLAG_RISERVA;
    }


    /**
     * Sets the FLAG_RISERVA value for this DatiRecesso.
     * 
     * @param FLAG_RISERVA
     */
    public void setFLAG_RISERVA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVA) {
        this.FLAG_RISERVA = FLAG_RISERVA;
    }


    /**
     * Gets the IMPORTO_SPESE value for this DatiRecesso.
     * 
     * @return IMPORTO_SPESE
     */
    public java.lang.Double getIMPORTO_SPESE() {
        return IMPORTO_SPESE;
    }


    /**
     * Sets the IMPORTO_SPESE value for this DatiRecesso.
     * 
     * @param IMPORTO_SPESE
     */
    public void setIMPORTO_SPESE(java.lang.Double IMPORTO_SPESE) {
        this.IMPORTO_SPESE = IMPORTO_SPESE;
    }


    /**
     * Gets the IMPORTO_ONERI value for this DatiRecesso.
     * 
     * @return IMPORTO_ONERI
     */
    public java.lang.Double getIMPORTO_ONERI() {
        return IMPORTO_ONERI;
    }


    /**
     * Sets the IMPORTO_ONERI value for this DatiRecesso.
     * 
     * @param IMPORTO_ONERI
     */
    public void setIMPORTO_ONERI(java.lang.Double IMPORTO_ONERI) {
        this.IMPORTO_ONERI = IMPORTO_ONERI;
    }


    /**
     * Gets the GG_RITARDO value for this DatiRecesso.
     * 
     * @return GG_RITARDO
     */
    public java.lang.Long getGG_RITARDO() {
        return GG_RITARDO;
    }


    /**
     * Sets the GG_RITARDO value for this DatiRecesso.
     * 
     * @param GG_RITARDO
     */
    public void setGG_RITARDO(java.lang.Long GG_RITARDO) {
        this.GG_RITARDO = GG_RITARDO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiRecesso)) return false;
        DatiRecesso other = (DatiRecesso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATA_TERMINE==null && other.getDATA_TERMINE()==null) || 
             (this.DATA_TERMINE!=null &&
              this.DATA_TERMINE.equals(other.getDATA_TERMINE()))) &&
            ((this.DATA_CONSEGNA==null && other.getDATA_CONSEGNA()==null) || 
             (this.DATA_CONSEGNA!=null &&
              this.DATA_CONSEGNA.equals(other.getDATA_CONSEGNA()))) &&
            ((this.FLAG_TIPO_COMUNICAZIONE==null && other.getFLAG_TIPO_COMUNICAZIONE()==null) || 
             (this.FLAG_TIPO_COMUNICAZIONE!=null &&
              this.FLAG_TIPO_COMUNICAZIONE.equals(other.getFLAG_TIPO_COMUNICAZIONE()))) &&
            this.DURATA_SOSP == other.getDURATA_SOSP() &&
            ((this.MOTIVO_SOSP==null && other.getMOTIVO_SOSP()==null) || 
             (this.MOTIVO_SOSP!=null &&
              this.MOTIVO_SOSP.equals(other.getMOTIVO_SOSP()))) &&
            ((this.DATA_IST_RECESSO==null && other.getDATA_IST_RECESSO()==null) || 
             (this.DATA_IST_RECESSO!=null &&
              this.DATA_IST_RECESSO.equals(other.getDATA_IST_RECESSO()))) &&
            ((this.FLAG_ACCOLTA==null && other.getFLAG_ACCOLTA()==null) || 
             (this.FLAG_ACCOLTA!=null &&
              this.FLAG_ACCOLTA.equals(other.getFLAG_ACCOLTA()))) &&
            ((this.FLAG_TARDIVA==null && other.getFLAG_TARDIVA()==null) || 
             (this.FLAG_TARDIVA!=null &&
              this.FLAG_TARDIVA.equals(other.getFLAG_TARDIVA()))) &&
            ((this.FLAG_RIPRESA==null && other.getFLAG_RIPRESA()==null) || 
             (this.FLAG_RIPRESA!=null &&
              this.FLAG_RIPRESA.equals(other.getFLAG_RIPRESA()))) &&
            ((this.FLAG_RISERVA==null && other.getFLAG_RISERVA()==null) || 
             (this.FLAG_RISERVA!=null &&
              this.FLAG_RISERVA.equals(other.getFLAG_RISERVA()))) &&
            ((this.IMPORTO_SPESE==null && other.getIMPORTO_SPESE()==null) || 
             (this.IMPORTO_SPESE!=null &&
              this.IMPORTO_SPESE.equals(other.getIMPORTO_SPESE()))) &&
            ((this.IMPORTO_ONERI==null && other.getIMPORTO_ONERI()==null) || 
             (this.IMPORTO_ONERI!=null &&
              this.IMPORTO_ONERI.equals(other.getIMPORTO_ONERI()))) &&
            ((this.GG_RITARDO==null && other.getGG_RITARDO()==null) || 
             (this.GG_RITARDO!=null &&
              this.GG_RITARDO.equals(other.getGG_RITARDO())));
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
        if (getDATA_TERMINE() != null) {
            _hashCode += getDATA_TERMINE().hashCode();
        }
        if (getDATA_CONSEGNA() != null) {
            _hashCode += getDATA_CONSEGNA().hashCode();
        }
        if (getFLAG_TIPO_COMUNICAZIONE() != null) {
            _hashCode += getFLAG_TIPO_COMUNICAZIONE().hashCode();
        }
        _hashCode += new Long(getDURATA_SOSP()).hashCode();
        if (getMOTIVO_SOSP() != null) {
            _hashCode += getMOTIVO_SOSP().hashCode();
        }
        if (getDATA_IST_RECESSO() != null) {
            _hashCode += getDATA_IST_RECESSO().hashCode();
        }
        if (getFLAG_ACCOLTA() != null) {
            _hashCode += getFLAG_ACCOLTA().hashCode();
        }
        if (getFLAG_TARDIVA() != null) {
            _hashCode += getFLAG_TARDIVA().hashCode();
        }
        if (getFLAG_RIPRESA() != null) {
            _hashCode += getFLAG_RIPRESA().hashCode();
        }
        if (getFLAG_RISERVA() != null) {
            _hashCode += getFLAG_RISERVA().hashCode();
        }
        if (getIMPORTO_SPESE() != null) {
            _hashCode += getIMPORTO_SPESE().hashCode();
        }
        if (getIMPORTO_ONERI() != null) {
            _hashCode += getIMPORTO_ONERI().hashCode();
        }
        if (getGG_RITARDO() != null) {
            _hashCode += getGG_RITARDO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiRecesso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiRecesso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_TERMINE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_TERMINE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_CONSEGNA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_CONSEGNA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_TIPO_COMUNICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_TIPO_COMUNICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagTCType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DURATA_SOSP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DURATA_SOSP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOTIVO_SOSP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MOTIVO_SOSP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_IST_RECESSO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_IST_RECESSO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_ACCOLTA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_ACCOLTA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_TARDIVA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_TARDIVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_RIPRESA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_RIPRESA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_RISERVA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_RISERVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_SPESE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_SPESE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_ONERI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_ONERI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GG_RITARDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "GG_RITARDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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

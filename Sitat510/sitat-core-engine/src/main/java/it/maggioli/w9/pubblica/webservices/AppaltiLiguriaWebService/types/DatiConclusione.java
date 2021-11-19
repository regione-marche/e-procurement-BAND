/**
 * DatiConclusione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiConclusione  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_INTERR_ANTICIPATA;

    private java.lang.String ID_MOTIVO_INTERR;

    private java.lang.String ID_MOTIVO_RISOL;

    private java.util.Calendar DATA_RISOLUZIONE;

    private java.lang.String FLAG_ONERI;

    private java.lang.Double ONERI_RISOLUZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_POLIZZA;

    private java.util.Calendar DATA_VERB_CONSEGNA_AVVIO;

    private java.util.Calendar DATA_TERMINE_CONTRATTUALE;

    private long NUM_INFORTUNI;

    private java.util.Calendar DATA_ULTIMAZIONE;

    private long NUM_INF_PERM;

    private long NUM_INF_MORT;

    private java.lang.Double ORE_LAVORATE;

    private java.lang.Long NUM_GIORNI_PROROGA;

    public DatiConclusione() {
    }

    public DatiConclusione(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_INTERR_ANTICIPATA,
           java.lang.String ID_MOTIVO_INTERR,
           java.lang.String ID_MOTIVO_RISOL,
           java.util.Calendar DATA_RISOLUZIONE,
           java.lang.String FLAG_ONERI,
           java.lang.Double ONERI_RISOLUZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_POLIZZA,
           java.util.Calendar DATA_VERB_CONSEGNA_AVVIO,
           java.util.Calendar DATA_TERMINE_CONTRATTUALE,
           long NUM_INFORTUNI,
           java.util.Calendar DATA_ULTIMAZIONE,
           long NUM_INF_PERM,
           long NUM_INF_MORT,
           java.lang.Double ORE_LAVORATE,
           java.lang.Long NUM_GIORNI_PROROGA) {
           this.FLAG_INTERR_ANTICIPATA = FLAG_INTERR_ANTICIPATA;
           this.ID_MOTIVO_INTERR = ID_MOTIVO_INTERR;
           this.ID_MOTIVO_RISOL = ID_MOTIVO_RISOL;
           this.DATA_RISOLUZIONE = DATA_RISOLUZIONE;
           this.FLAG_ONERI = FLAG_ONERI;
           this.ONERI_RISOLUZIONE = ONERI_RISOLUZIONE;
           this.FLAG_POLIZZA = FLAG_POLIZZA;
           this.DATA_VERB_CONSEGNA_AVVIO = DATA_VERB_CONSEGNA_AVVIO;
           this.DATA_TERMINE_CONTRATTUALE = DATA_TERMINE_CONTRATTUALE;
           this.NUM_INFORTUNI = NUM_INFORTUNI;
           this.DATA_ULTIMAZIONE = DATA_ULTIMAZIONE;
           this.NUM_INF_PERM = NUM_INF_PERM;
           this.NUM_INF_MORT = NUM_INF_MORT;
           this.ORE_LAVORATE = ORE_LAVORATE;
           this.NUM_GIORNI_PROROGA = NUM_GIORNI_PROROGA;
    }


    /**
     * Gets the FLAG_INTERR_ANTICIPATA value for this DatiConclusione.
     * 
     * @return FLAG_INTERR_ANTICIPATA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_INTERR_ANTICIPATA() {
        return FLAG_INTERR_ANTICIPATA;
    }


    /**
     * Sets the FLAG_INTERR_ANTICIPATA value for this DatiConclusione.
     * 
     * @param FLAG_INTERR_ANTICIPATA
     */
    public void setFLAG_INTERR_ANTICIPATA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_INTERR_ANTICIPATA) {
        this.FLAG_INTERR_ANTICIPATA = FLAG_INTERR_ANTICIPATA;
    }


    /**
     * Gets the ID_MOTIVO_INTERR value for this DatiConclusione.
     * 
     * @return ID_MOTIVO_INTERR
     */
    public java.lang.String getID_MOTIVO_INTERR() {
        return ID_MOTIVO_INTERR;
    }


    /**
     * Sets the ID_MOTIVO_INTERR value for this DatiConclusione.
     * 
     * @param ID_MOTIVO_INTERR
     */
    public void setID_MOTIVO_INTERR(java.lang.String ID_MOTIVO_INTERR) {
        this.ID_MOTIVO_INTERR = ID_MOTIVO_INTERR;
    }


    /**
     * Gets the ID_MOTIVO_RISOL value for this DatiConclusione.
     * 
     * @return ID_MOTIVO_RISOL
     */
    public java.lang.String getID_MOTIVO_RISOL() {
        return ID_MOTIVO_RISOL;
    }


    /**
     * Sets the ID_MOTIVO_RISOL value for this DatiConclusione.
     * 
     * @param ID_MOTIVO_RISOL
     */
    public void setID_MOTIVO_RISOL(java.lang.String ID_MOTIVO_RISOL) {
        this.ID_MOTIVO_RISOL = ID_MOTIVO_RISOL;
    }


    /**
     * Gets the DATA_RISOLUZIONE value for this DatiConclusione.
     * 
     * @return DATA_RISOLUZIONE
     */
    public java.util.Calendar getDATA_RISOLUZIONE() {
        return DATA_RISOLUZIONE;
    }


    /**
     * Sets the DATA_RISOLUZIONE value for this DatiConclusione.
     * 
     * @param DATA_RISOLUZIONE
     */
    public void setDATA_RISOLUZIONE(java.util.Calendar DATA_RISOLUZIONE) {
        this.DATA_RISOLUZIONE = DATA_RISOLUZIONE;
    }


    /**
     * Gets the FLAG_ONERI value for this DatiConclusione.
     * 
     * @return FLAG_ONERI
     */
    public java.lang.String getFLAG_ONERI() {
        return FLAG_ONERI;
    }


    /**
     * Sets the FLAG_ONERI value for this DatiConclusione.
     * 
     * @param FLAG_ONERI
     */
    public void setFLAG_ONERI(java.lang.String FLAG_ONERI) {
        this.FLAG_ONERI = FLAG_ONERI;
    }


    /**
     * Gets the ONERI_RISOLUZIONE value for this DatiConclusione.
     * 
     * @return ONERI_RISOLUZIONE
     */
    public java.lang.Double getONERI_RISOLUZIONE() {
        return ONERI_RISOLUZIONE;
    }


    /**
     * Sets the ONERI_RISOLUZIONE value for this DatiConclusione.
     * 
     * @param ONERI_RISOLUZIONE
     */
    public void setONERI_RISOLUZIONE(java.lang.Double ONERI_RISOLUZIONE) {
        this.ONERI_RISOLUZIONE = ONERI_RISOLUZIONE;
    }


    /**
     * Gets the FLAG_POLIZZA value for this DatiConclusione.
     * 
     * @return FLAG_POLIZZA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_POLIZZA() {
        return FLAG_POLIZZA;
    }


    /**
     * Sets the FLAG_POLIZZA value for this DatiConclusione.
     * 
     * @param FLAG_POLIZZA
     */
    public void setFLAG_POLIZZA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_POLIZZA) {
        this.FLAG_POLIZZA = FLAG_POLIZZA;
    }


    /**
     * Gets the DATA_VERB_CONSEGNA_AVVIO value for this DatiConclusione.
     * 
     * @return DATA_VERB_CONSEGNA_AVVIO
     */
    public java.util.Calendar getDATA_VERB_CONSEGNA_AVVIO() {
        return DATA_VERB_CONSEGNA_AVVIO;
    }


    /**
     * Sets the DATA_VERB_CONSEGNA_AVVIO value for this DatiConclusione.
     * 
     * @param DATA_VERB_CONSEGNA_AVVIO
     */
    public void setDATA_VERB_CONSEGNA_AVVIO(java.util.Calendar DATA_VERB_CONSEGNA_AVVIO) {
        this.DATA_VERB_CONSEGNA_AVVIO = DATA_VERB_CONSEGNA_AVVIO;
    }


    /**
     * Gets the DATA_TERMINE_CONTRATTUALE value for this DatiConclusione.
     * 
     * @return DATA_TERMINE_CONTRATTUALE
     */
    public java.util.Calendar getDATA_TERMINE_CONTRATTUALE() {
        return DATA_TERMINE_CONTRATTUALE;
    }


    /**
     * Sets the DATA_TERMINE_CONTRATTUALE value for this DatiConclusione.
     * 
     * @param DATA_TERMINE_CONTRATTUALE
     */
    public void setDATA_TERMINE_CONTRATTUALE(java.util.Calendar DATA_TERMINE_CONTRATTUALE) {
        this.DATA_TERMINE_CONTRATTUALE = DATA_TERMINE_CONTRATTUALE;
    }


    /**
     * Gets the NUM_INFORTUNI value for this DatiConclusione.
     * 
     * @return NUM_INFORTUNI
     */
    public long getNUM_INFORTUNI() {
        return NUM_INFORTUNI;
    }


    /**
     * Sets the NUM_INFORTUNI value for this DatiConclusione.
     * 
     * @param NUM_INFORTUNI
     */
    public void setNUM_INFORTUNI(long NUM_INFORTUNI) {
        this.NUM_INFORTUNI = NUM_INFORTUNI;
    }


    /**
     * Gets the DATA_ULTIMAZIONE value for this DatiConclusione.
     * 
     * @return DATA_ULTIMAZIONE
     */
    public java.util.Calendar getDATA_ULTIMAZIONE() {
        return DATA_ULTIMAZIONE;
    }


    /**
     * Sets the DATA_ULTIMAZIONE value for this DatiConclusione.
     * 
     * @param DATA_ULTIMAZIONE
     */
    public void setDATA_ULTIMAZIONE(java.util.Calendar DATA_ULTIMAZIONE) {
        this.DATA_ULTIMAZIONE = DATA_ULTIMAZIONE;
    }


    /**
     * Gets the NUM_INF_PERM value for this DatiConclusione.
     * 
     * @return NUM_INF_PERM
     */
    public long getNUM_INF_PERM() {
        return NUM_INF_PERM;
    }


    /**
     * Sets the NUM_INF_PERM value for this DatiConclusione.
     * 
     * @param NUM_INF_PERM
     */
    public void setNUM_INF_PERM(long NUM_INF_PERM) {
        this.NUM_INF_PERM = NUM_INF_PERM;
    }


    /**
     * Gets the NUM_INF_MORT value for this DatiConclusione.
     * 
     * @return NUM_INF_MORT
     */
    public long getNUM_INF_MORT() {
        return NUM_INF_MORT;
    }


    /**
     * Sets the NUM_INF_MORT value for this DatiConclusione.
     * 
     * @param NUM_INF_MORT
     */
    public void setNUM_INF_MORT(long NUM_INF_MORT) {
        this.NUM_INF_MORT = NUM_INF_MORT;
    }


    /**
     * Gets the ORE_LAVORATE value for this DatiConclusione.
     * 
     * @return ORE_LAVORATE
     */
    public java.lang.Double getORE_LAVORATE() {
        return ORE_LAVORATE;
    }


    /**
     * Sets the ORE_LAVORATE value for this DatiConclusione.
     * 
     * @param ORE_LAVORATE
     */
    public void setORE_LAVORATE(java.lang.Double ORE_LAVORATE) {
        this.ORE_LAVORATE = ORE_LAVORATE;
    }


    /**
     * Gets the NUM_GIORNI_PROROGA value for this DatiConclusione.
     * 
     * @return NUM_GIORNI_PROROGA
     */
    public java.lang.Long getNUM_GIORNI_PROROGA() {
        return NUM_GIORNI_PROROGA;
    }


    /**
     * Sets the NUM_GIORNI_PROROGA value for this DatiConclusione.
     * 
     * @param NUM_GIORNI_PROROGA
     */
    public void setNUM_GIORNI_PROROGA(java.lang.Long NUM_GIORNI_PROROGA) {
        this.NUM_GIORNI_PROROGA = NUM_GIORNI_PROROGA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiConclusione)) return false;
        DatiConclusione other = (DatiConclusione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FLAG_INTERR_ANTICIPATA==null && other.getFLAG_INTERR_ANTICIPATA()==null) || 
             (this.FLAG_INTERR_ANTICIPATA!=null &&
              this.FLAG_INTERR_ANTICIPATA.equals(other.getFLAG_INTERR_ANTICIPATA()))) &&
            ((this.ID_MOTIVO_INTERR==null && other.getID_MOTIVO_INTERR()==null) || 
             (this.ID_MOTIVO_INTERR!=null &&
              this.ID_MOTIVO_INTERR.equals(other.getID_MOTIVO_INTERR()))) &&
            ((this.ID_MOTIVO_RISOL==null && other.getID_MOTIVO_RISOL()==null) || 
             (this.ID_MOTIVO_RISOL!=null &&
              this.ID_MOTIVO_RISOL.equals(other.getID_MOTIVO_RISOL()))) &&
            ((this.DATA_RISOLUZIONE==null && other.getDATA_RISOLUZIONE()==null) || 
             (this.DATA_RISOLUZIONE!=null &&
              this.DATA_RISOLUZIONE.equals(other.getDATA_RISOLUZIONE()))) &&
            ((this.FLAG_ONERI==null && other.getFLAG_ONERI()==null) || 
             (this.FLAG_ONERI!=null &&
              this.FLAG_ONERI.equals(other.getFLAG_ONERI()))) &&
            ((this.ONERI_RISOLUZIONE==null && other.getONERI_RISOLUZIONE()==null) || 
             (this.ONERI_RISOLUZIONE!=null &&
              this.ONERI_RISOLUZIONE.equals(other.getONERI_RISOLUZIONE()))) &&
            ((this.FLAG_POLIZZA==null && other.getFLAG_POLIZZA()==null) || 
             (this.FLAG_POLIZZA!=null &&
              this.FLAG_POLIZZA.equals(other.getFLAG_POLIZZA()))) &&
            ((this.DATA_VERB_CONSEGNA_AVVIO==null && other.getDATA_VERB_CONSEGNA_AVVIO()==null) || 
             (this.DATA_VERB_CONSEGNA_AVVIO!=null &&
              this.DATA_VERB_CONSEGNA_AVVIO.equals(other.getDATA_VERB_CONSEGNA_AVVIO()))) &&
            ((this.DATA_TERMINE_CONTRATTUALE==null && other.getDATA_TERMINE_CONTRATTUALE()==null) || 
             (this.DATA_TERMINE_CONTRATTUALE!=null &&
              this.DATA_TERMINE_CONTRATTUALE.equals(other.getDATA_TERMINE_CONTRATTUALE()))) &&
            this.NUM_INFORTUNI == other.getNUM_INFORTUNI() &&
            ((this.DATA_ULTIMAZIONE==null && other.getDATA_ULTIMAZIONE()==null) || 
             (this.DATA_ULTIMAZIONE!=null &&
              this.DATA_ULTIMAZIONE.equals(other.getDATA_ULTIMAZIONE()))) &&
            this.NUM_INF_PERM == other.getNUM_INF_PERM() &&
            this.NUM_INF_MORT == other.getNUM_INF_MORT() &&
            ((this.ORE_LAVORATE==null && other.getORE_LAVORATE()==null) || 
             (this.ORE_LAVORATE!=null &&
              this.ORE_LAVORATE.equals(other.getORE_LAVORATE()))) &&
            ((this.NUM_GIORNI_PROROGA==null && other.getNUM_GIORNI_PROROGA()==null) || 
             (this.NUM_GIORNI_PROROGA!=null &&
              this.NUM_GIORNI_PROROGA.equals(other.getNUM_GIORNI_PROROGA())));
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
        if (getFLAG_INTERR_ANTICIPATA() != null) {
            _hashCode += getFLAG_INTERR_ANTICIPATA().hashCode();
        }
        if (getID_MOTIVO_INTERR() != null) {
            _hashCode += getID_MOTIVO_INTERR().hashCode();
        }
        if (getID_MOTIVO_RISOL() != null) {
            _hashCode += getID_MOTIVO_RISOL().hashCode();
        }
        if (getDATA_RISOLUZIONE() != null) {
            _hashCode += getDATA_RISOLUZIONE().hashCode();
        }
        if (getFLAG_ONERI() != null) {
            _hashCode += getFLAG_ONERI().hashCode();
        }
        if (getONERI_RISOLUZIONE() != null) {
            _hashCode += getONERI_RISOLUZIONE().hashCode();
        }
        if (getFLAG_POLIZZA() != null) {
            _hashCode += getFLAG_POLIZZA().hashCode();
        }
        if (getDATA_VERB_CONSEGNA_AVVIO() != null) {
            _hashCode += getDATA_VERB_CONSEGNA_AVVIO().hashCode();
        }
        if (getDATA_TERMINE_CONTRATTUALE() != null) {
            _hashCode += getDATA_TERMINE_CONTRATTUALE().hashCode();
        }
        _hashCode += new Long(getNUM_INFORTUNI()).hashCode();
        if (getDATA_ULTIMAZIONE() != null) {
            _hashCode += getDATA_ULTIMAZIONE().hashCode();
        }
        _hashCode += new Long(getNUM_INF_PERM()).hashCode();
        _hashCode += new Long(getNUM_INF_MORT()).hashCode();
        if (getORE_LAVORATE() != null) {
            _hashCode += getORE_LAVORATE().hashCode();
        }
        if (getNUM_GIORNI_PROROGA() != null) {
            _hashCode += getNUM_GIORNI_PROROGA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiConclusione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiConclusione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_INTERR_ANTICIPATA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_INTERR_ANTICIPATA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_MOTIVO_INTERR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_MOTIVO_INTERR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_MOTIVO_RISOL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_MOTIVO_RISOL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_RISOLUZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_RISOLUZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_ONERI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_ONERI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ONERI_RISOLUZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ONERI_RISOLUZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_POLIZZA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_POLIZZA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_VERB_CONSEGNA_AVVIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERB_CONSEGNA_AVVIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_TERMINE_CONTRATTUALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_TERMINE_CONTRATTUALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_INFORTUNI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_INFORTUNI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_ULTIMAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_ULTIMAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_INF_PERM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_INF_PERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_INF_MORT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_INF_MORT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORE_LAVORATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ORE_LAVORATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_GIORNI_PROROGA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_GIORNI_PROROGA"));
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

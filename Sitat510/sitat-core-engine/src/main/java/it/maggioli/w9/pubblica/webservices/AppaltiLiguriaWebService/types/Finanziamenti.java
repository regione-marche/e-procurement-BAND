/**
 * Finanziamenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class Finanziamenti  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoFinanziamentoType ID_FINANZIAMENTO;

    private double IMPORTO_FINANZIAMENTO;

    public Finanziamenti() {
    }

    public Finanziamenti(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoFinanziamentoType ID_FINANZIAMENTO,
           double IMPORTO_FINANZIAMENTO) {
           this.ID_FINANZIAMENTO = ID_FINANZIAMENTO;
           this.IMPORTO_FINANZIAMENTO = IMPORTO_FINANZIAMENTO;
    }


    /**
     * Gets the ID_FINANZIAMENTO value for this Finanziamenti.
     * 
     * @return ID_FINANZIAMENTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoFinanziamentoType getID_FINANZIAMENTO() {
        return ID_FINANZIAMENTO;
    }


    /**
     * Sets the ID_FINANZIAMENTO value for this Finanziamenti.
     * 
     * @param ID_FINANZIAMENTO
     */
    public void setID_FINANZIAMENTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoFinanziamentoType ID_FINANZIAMENTO) {
        this.ID_FINANZIAMENTO = ID_FINANZIAMENTO;
    }


    /**
     * Gets the IMPORTO_FINANZIAMENTO value for this Finanziamenti.
     * 
     * @return IMPORTO_FINANZIAMENTO
     */
    public double getIMPORTO_FINANZIAMENTO() {
        return IMPORTO_FINANZIAMENTO;
    }


    /**
     * Sets the IMPORTO_FINANZIAMENTO value for this Finanziamenti.
     * 
     * @param IMPORTO_FINANZIAMENTO
     */
    public void setIMPORTO_FINANZIAMENTO(double IMPORTO_FINANZIAMENTO) {
        this.IMPORTO_FINANZIAMENTO = IMPORTO_FINANZIAMENTO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Finanziamenti)) return false;
        Finanziamenti other = (Finanziamenti) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID_FINANZIAMENTO==null && other.getID_FINANZIAMENTO()==null) || 
             (this.ID_FINANZIAMENTO!=null &&
              this.ID_FINANZIAMENTO.equals(other.getID_FINANZIAMENTO()))) &&
            this.IMPORTO_FINANZIAMENTO == other.getIMPORTO_FINANZIAMENTO();
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
        if (getID_FINANZIAMENTO() != null) {
            _hashCode += getID_FINANZIAMENTO().hashCode();
        }
        _hashCode += new Double(getIMPORTO_FINANZIAMENTO()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Finanziamenti.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Finanziamenti"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_FINANZIAMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_FINANZIAMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoFinanziamentoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_FINANZIAMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_FINANZIAMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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

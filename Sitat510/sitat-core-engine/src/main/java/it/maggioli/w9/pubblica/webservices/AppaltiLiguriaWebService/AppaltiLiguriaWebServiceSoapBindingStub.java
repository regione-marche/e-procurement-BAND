/**
 * AppaltiLiguriaWebServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService;

import org.apache.commons.lang.StringUtils;

import it.eldasoft.utils.properties.ConfigManager;

public class AppaltiLiguriaWebServiceSoapBindingStub extends org.apache.axis.client.Stub implements it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.AppaltiLiguriaWebService_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[1];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("invioContratto");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contratto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Contratto"), it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Contratto.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "JAXBException"),
                      "it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.JAXBException",
                      new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "JAXBException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "CheckVerifyFault"),
                      "it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean",
                      new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "checkFaultBean"), 
                      true
                     ));
        _operations[0] = oper;

    }

    public AppaltiLiguriaWebServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AppaltiLiguriaWebServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AppaltiLiguriaWebServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "checkFaultBean");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "JAXBException");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.JAXBException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Aggiudicatario");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CategoriaType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Categorie");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ClasseImportoType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Condizioni");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Condizioni.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Contratto");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Contratto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CPVSecondari");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CPVSecondari.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAccordo");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicatari");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicazione");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAvanzamento");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiCollaudo");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiCollaudo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiComuni");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuni.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiComuniEstesi");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuniEstesi.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiConclusione");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiConclusione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiEnte");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiEnte.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiGeneraliContratto");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiGeneraliContratto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiInizio");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiInizio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiLegaleRappresentante");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiLegaleRappresentante.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiRecesso");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiResponsabile");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSoggettiEstesi");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSospensione");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSubappalto");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiVariante");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiVariante.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Finanziamenti");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagCollaudatoreType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagCollaudatoreType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagEsitoCollaudoType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagEsitoCollaudoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagImportiType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagRitardoType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagRitardoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSingoloCommissioneType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSingoloCommissioneType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSOType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagTCType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagTCType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagVarianteType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagVarianteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaAggiudicatari");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Aggiudicatario");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Aggiudicatari");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaCategorie");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Categorie");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Categorie");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaCondizioni");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Condizioni[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Condizioni");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_Condizioni");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaCPVSecondari");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CPVSecondari[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CPVSecondari");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_CPVSecondari");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiAccordiBonari");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAccordo");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiAccordiBonari");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiAvanzamento");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAvanzamento");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiAvanzamento");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiRitardiRecessi");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiRecesso");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiRitardiRecessi");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiSoggettiEstesi");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSoggettiEstesi");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiSoggettiEstesi");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiSospensione");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSospensione");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiSospensione");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiSubappalto");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSubappalto");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiSubappalto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiVariante");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiVariante[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiVariante");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiVariante");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaFinanziamenti");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Finanziamenti");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Finanziamenti");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaMotiviVariante");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MotiviVariante");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_MotiviVariante");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaOfferenti");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Offerente");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Offerenti");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaTipologiaFS");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaFS[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipologiaFS");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_TipologiaFS");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaTipologiaL");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaL[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipologiaL");
            qName2 = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_TipologiaL");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MotiviVariante");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Offerente");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Pubblicazione");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneAccordiBonari");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAccordiBonari.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneAggiudicazione");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAggiudicazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneCollaudo");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneCollaudo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneConclusione");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneConclusione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneInizio");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneInizio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneRitardiRecessi");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneRitardiRecessi.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSAL");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSAL.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSospensioni");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSospensioni.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSubappalti");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSubappalti.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneVarianti");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneVarianti.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "StipulaInizio");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.StipulaInizio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoFinanziamentoType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoFinanziamentoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipologiaFS");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaFS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipologiaL");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaL.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoSchedaType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoSchedaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoStrumentoType");
            cachedSerQNames.add(qName);
            cls = it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public java.lang.String invioContratto(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Contratto contratto) throws java.rmi.RemoteException, it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.JAXBException, it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:invioContratto");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/AppaltiLiguriaWebService.wsdl", "invioContratto"));

        // Personalizzazione per aggiungere nel header HTTP una coppia chiave-valore
        // necessaria per l'autenticazione OAuth2 sul servizio
        String httpHeaderTokenName = ConfigManager.getValore("it.eldasoft.appaltiLiguria.httpHeader.tokenName");
        String httpHeaderTokenValue = ConfigManager.getValore("it.eldasoft.appaltiLiguria.httpHeader.tokenValue");
        
        if (StringUtils.isNotEmpty(httpHeaderTokenName) && StringUtils.isNotEmpty(httpHeaderTokenValue)) {
          _call.setProperty(org.apache.axis.client.Call.SESSION_MAINTAIN_PROPERTY, new Boolean(true));
          _call.setProperty(org.apache.axis.transport.http.HTTPConstants.HEADER_COOKIE2, 
              "\r\n" + httpHeaderTokenName + ": " + httpHeaderTokenValue);
        }
        
        setRequestHeaders(_call);
        setAttachments(_call);
 		try {
	        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {contratto});
	        if (_resp instanceof java.rmi.RemoteException) {
    	        throw (java.rmi.RemoteException)_resp;
        	} else {
            	extractAttachments(_call);
            	try {
                	return (java.lang.String) _resp;
            	} catch (java.lang.Exception _exception) {
                	return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            	}
        	}
  		} catch (org.apache.axis.AxisFault axisFaultException) {
    		if (axisFaultException.detail != null) {
        		if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              		throw (java.rmi.RemoteException) axisFaultException.detail;
         		}
        		if (axisFaultException.detail instanceof it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.JAXBException) {
              		throw (it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.JAXBException) axisFaultException.detail;
	         	}
        		if (axisFaultException.detail instanceof it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean) {
              		throw (it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean) axisFaultException.detail;
         		}
   			}
  			throw axisFaultException;
		}
    }

}

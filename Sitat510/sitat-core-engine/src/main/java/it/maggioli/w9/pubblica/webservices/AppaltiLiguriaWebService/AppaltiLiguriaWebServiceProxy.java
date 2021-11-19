package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService;

public class AppaltiLiguriaWebServiceProxy implements it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.AppaltiLiguriaWebService_PortType {
  private String _endpoint = null;
  private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.AppaltiLiguriaWebService_PortType appaltiLiguriaWebService_PortType = null;
  
  public AppaltiLiguriaWebServiceProxy() {
    _initAppaltiLiguriaWebServiceProxy();
  }
  
  public AppaltiLiguriaWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAppaltiLiguriaWebServiceProxy();
  }
  
  private void _initAppaltiLiguriaWebServiceProxy() {
    try {
      appaltiLiguriaWebService_PortType = (new it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.AppaltiLiguriaWebService_ServiceLocator()).getAppaltiLiguriaPort();
      if (appaltiLiguriaWebService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)appaltiLiguriaWebService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)appaltiLiguriaWebService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (appaltiLiguriaWebService_PortType != null)
      ((javax.xml.rpc.Stub)appaltiLiguriaWebService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.AppaltiLiguriaWebService_PortType getAppaltiLiguriaWebService_PortType() {
    if (appaltiLiguriaWebService_PortType == null)
      _initAppaltiLiguriaWebServiceProxy();
    return appaltiLiguriaWebService_PortType;
  }
  
  public java.lang.String invioContratto(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Contratto contratto) throws java.rmi.RemoteException, it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.JAXBException, it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean{
    if (appaltiLiguriaWebService_PortType == null)
      _initAppaltiLiguriaWebServiceProxy();
    return appaltiLiguriaWebService_PortType.invioContratto(contratto);
  }
  
  
}
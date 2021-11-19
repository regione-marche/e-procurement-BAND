
<%
  /*
   * Created on: 04/08/2009
   *
   * Copyright (c) EldaSoft S.p.A.
   * Tutti i diritti sono riservati.
   *
   * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
   * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
   * aver prima formalizzato un accordo specifico con EldaSoft.
   */
%>
<%@ taglib uri="http://www.eldasoft.it/genetags" prefix="gene"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="key" value='${key}' scope="request" />

<%-- <c:set var="codiceGara" value='${gene:getValCampo(key,"CODGARA")}'/> --%>
<%-- <c:set var="numeroPubblicazione" value='${gene:getValCampo(key,"NUM_PUBB")}' /> --%>
<%-- <c:set var="tipoPubblicazione" value='${gene:getValCampo(key,"TIPDOC")}' /> --%>

<c:set var="codiceGara" value='578430'/>
<c:set var="numeroPubblicazione" value='1' />
<c:set var="tipoPubblicazione" value='55' />
<%
  /* Dati generali del lavoro */
%>

LINK

<a href="javascript:caricaPubblicazioni();" title="CARICA PUBBLICAZIONI" tabindex="1503">Carica PUBBLICAZIONI</a>

<gene:javaScript>
		function caricaPubblicazioni() {
			bloccaRichiesteServer();
			document.location.href="${pageContext.request.contextPath}/ApriPagina.do?href=w9/w9pubblicazioni/w9pubblicazioni-scheda.jsp&key=${key}";
		}
</gene:javaScript>
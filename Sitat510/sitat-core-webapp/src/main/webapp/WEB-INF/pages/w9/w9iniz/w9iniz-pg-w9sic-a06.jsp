
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

<%/* Dati generali del lavoro */%>
<gene:formScheda entita="W9INIZ" gestisciProtezioni="true" gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9INIZ" >
	
	<gene:redefineInsert name="schedaNuovo" />
	<gene:redefineInsert name="pulsanteNuovo" />
			
	<c:if test='${permessoUser lt 4}' >
		<gene:redefineInsert name="schedaModifica" />
		<gene:redefineInsert name="pulsanteModifica" />
	</c:if>
	
	<c:set var="key" value='${key}' scope="request" />
	<gene:campoScheda campo="CODGARA" visibile="false" defaultValue='${gene:getValCampo(key,"CODGARA")}' value='${gene:getValCampo(key,"CODGARA")}'/>
	<gene:campoScheda campo="CODLOTT" visibile="false" defaultValue='${gene:getValCampo(key,"CODLOTT")}' value='${gene:getValCampo(key,"CODLOTT")}' />
	<gene:campoScheda campo="NUM_INIZ" visibile="false" defaultValue='${gene:getValCampo(key,"NUM_INIZ")}' value='${gene:getValCampo(key,"NUM_INIZ")}'/>

	<gene:campoScheda entita="W9SIC" campo="CODGARA" visibile="false" where="W9INIZ.CODGARA = W9SIC.CODGARA AND W9INIZ.CODLOTT = W9SIC.CODLOTT AND W9SIC.NUM_SIC = 1"/>
	<gene:campoScheda entita="W9SIC" campo="CODLOTT" visibile="false" />
	<gene:campoScheda entita="W9SIC" campo="NUM_SIC" visibile="false" />
	<gene:campoScheda entita="W9SIC" campo="PIANSCIC" />
	<gene:campoScheda entita="W9SIC" campo="DIROPE" />
	<gene:campoScheda entita="W9SIC" campo="TUTOR" />

	<!-- campi per  W9FASI-->
	<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
		where="W9FASI.CODGARA = W9INIZ.CODGARA AND W9FASI.CODLOTT = W9INIZ.CODLOTT" />
	<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false" value="${codlott}"
		where="W9FASI.CODGARA = W9INIZ.CODGARA AND W9FASI.CODLOTT = W9INIZ.CODLOTT" />
	<gene:campoScheda campo="FASE_ESECUZIONE" entita="W9FASI" visibile="false" value="${flusso}"/>
	<gene:campoScheda campo="NUM" entita="W9FASI" visibile="false" />	
		
		

	<gene:campoScheda>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
	</gene:campoScheda>
</gene:formScheda>
<gene:javaScript>
</gene:javaScript>
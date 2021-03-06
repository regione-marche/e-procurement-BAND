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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<gene:template file="scheda-template.jsp" gestisciProtezioni="true"	schema="W9" idMaschera="W9ACCO-scheda">
	<c:set var="key" value='${key}' scope="request" />
	<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}' />
	<c:set var="codlott" value='${gene:getValCampo(key,"CODLOTT")}' />
	<c:set var="flusso" value='8' scope="request" />
	<c:set var="key1" value='${gene:getValCampo(key,"CODGARA")}' scope="request" />
	<c:set var="key2" value='${gene:getValCampo(key,"CODLOTT")}' scope="request" />
	<c:set var="key3" value='${gene:getValCampo(key,"NUM_ACCO")}' scope="request" />
	
	<c:set var="permessoUser" value='${gene:callFunction3("it.eldasoft.w9.tags.funzioni.GetPermessoUserFunction",pageContext,key,"W9ACCO")}' scope="request" />
	
	<gene:setString name="titoloMaschera" value='${gene:if("NUOVO"==modo, "Nuovo Accordo bonario", "Accordo bonario")}' />
	
	<gene:redefineInsert name="corpo">
			<gene:formScheda entita="W9ACCO" gestisciProtezioni="true" gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9ACCO" >

			<gene:redefineInsert name="schedaNuovo" />
			<gene:redefineInsert name="pulsanteNuovo" />

			<c:if test='${permessoUser lt 4}' >
				<gene:redefineInsert name="schedaModifica" />
				<gene:redefineInsert name="pulsanteModifica" />
			</c:if>

			<gene:gruppoCampi idProtezioni="GEN">
				<gene:campoScheda>
					<td colspan="2"><b>Accordo bonario </b></td>
				</gene:campoScheda>
					<gene:campoScheda campo="CODGARA" visibile="false" value="${codgara}" />
					<gene:campoScheda campo="CODLOTT" visibile="false" value="${codlott}"  />
					<gene:campoScheda campo="NUM_ACCO"  modificabile="false" visibile="${modoAperturaScheda ne 'NUOVO'}"/>
					<gene:campoScheda campo="DATA_ACCORDO" />
					<gene:campoScheda campo="DATA_INIZIO_ACC" />
					<gene:campoScheda campo="DATA_FINE_ACC" />
					<gene:campoScheda campo="ONERI_DERIVANTI" />
					<gene:campoScheda campo="NUM_RISERVE" />
			</gene:gruppoCampi>
			
		<!-- campi per  W9FASI-->
		<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
			where="W9FASI.CODGARA = W9ACCO.CODGARA AND W9FASI.CODLOTT = W9ACCO.CODLOTT" />
		<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false" value="${codlott}"  
			where="W9FASI.CODGARA = W9ACCO.CODGARA AND W9FASI.CODLOTT = W9ACCO.CODLOTT"/>
		<gene:campoScheda campo="FASE_ESECUZIONE" entita="W9FASI" visibile="false" value="${flusso}"/>
		<gene:campoScheda campo="NUM" entita="W9FASI" visibile="false" />	
			
			<gene:campoScheda>
				<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
			</gene:campoScheda>
		</gene:formScheda>
	</gene:redefineInsert>
	<gene:redefineInsert name="addToAzioni">
		<jsp:include page="../commons/addtodocumenti-validazione.jsp" />
	</gene:redefineInsert>
<gene:javaScript>
	function popupValidazione(flusso,key1,key2,key3) {
	  var comando = "href=w9/commons/popup-validazione-generale.jsp";
	  comando = comando + "&flusso=" + flusso;
	  comando = comando + "&key1=" + key1;
	  comando = comando + "&key2=" + key2;
	  comando = comando + "&key3=" + key3;
	  openPopUpCustom(comando, "validazione", 500, 650, "yes", "yes");
  }
  
  <c:if test='${modo eq "MODIFICA"}' >
		<c:set var="localkey" value='${codgara};${codlott};${flusso};${key3}' scope="request" />
		<jsp:include page="/WEB-INF/pages/w9/commons/controlloJsFaseDaReinviare.jsp" />
	</c:if>
  
</gene:javaScript>
</gene:template>
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

<gene:template file="scheda-template.jsp" gestisciProtezioni="true"	schema="W9" idMaschera="W9RITA-scheda">
	<c:set var="key" value='${key}' scope="request" />
	<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}' />
	<c:set var="codlott" value='${gene:getValCampo(key,"CODLOTT")}' />
	<c:set var="flusso" value='10' scope="request" />

	<c:set var="key1" value='${gene:getValCampo(key,"CODGARA")}' scope="request" />
	<c:set var="key2" value='${gene:getValCampo(key,"CODLOTT")}' scope="request" />
	<c:set var="key3" value='${gene:getValCampo(key,"NUM_RITA")}' scope="request" />
	
	<c:set var="permessoUser" value='${gene:callFunction3("it.eldasoft.w9.tags.funzioni.GetPermessoUserFunction",pageContext,key,"W9RITA")}' scope="request" />
	
	<gene:setString name="titoloMaschera" value='${gene:if("NUOVO"==modo, "Nuova Istanza di recesso", "Istanza di recesso")}' />
	
	<gene:redefineInsert name="corpo">
		<gene:formScheda entita="W9RITA" gestisciProtezioni="true" gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9RITA"
						plugin="it.eldasoft.w9.tags.gestori.plugin.GestoreW9RITA">
			
			<gene:redefineInsert name="schedaNuovo" />
			<gene:redefineInsert name="pulsanteNuovo" />
			
			<c:if test='${permessoUser lt 4}' >
				<gene:redefineInsert name="schedaModifica" />
				<gene:redefineInsert name="pulsanteModifica" />
			</c:if>
			
			<gene:gruppoCampi idProtezioni="GEN">
				<gene:campoScheda>
					<td colspan="2"><b>Ritardo o sospensione nella consegna</b></td>
				</gene:campoScheda>
				<gene:campoScheda campo="CODGARA" visibile="false" value="${codgara}" />
				<gene:campoScheda campo="CODLOTT" visibile="false" value="${codlott}"  />
				<gene:campoScheda campo="NUM_RITA"  modificabile="false" visibile="${modoAperturaScheda ne 'NUOVO'}"/>
				
				<gene:campoScheda campo="DATA_TERMINE" />
				<gene:campoScheda campo="DATA_CONSEGNA" defaultValue="${requestScope.initDataConsegna}" />
				
				<gene:campoScheda campo="TIPO_COMUN" /> <!-- Tabellato W3z07 -->
				<gene:campoScheda campo="RITARDO" />
				<gene:campoScheda campo="DURATA_SOSP" />
				<gene:campoScheda campo="MOTIVO_SOSP" /> 
				<gene:campoScheda>
					<td colspan="2"><b>Istanza di recesso </b></td>
				</gene:campoScheda>
				<gene:campoScheda campo="DATA_IST_RECESSO" />
				<gene:campoScheda campo="FLAG_ACCOLTA" />
				<gene:campoScheda campo="FLAG_TARDIVA" />
				<gene:campoScheda campo="FLAG_RIPRESA" />
				<gene:campoScheda campo="FLAG_RISERVA" />
				<gene:campoScheda campo="IMPORTO_SPESE" />
				<gene:campoScheda campo="IMPORTO_ONERI" />
			</gene:gruppoCampi>
		<!-- campi per  W9FASI-->
			<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
				where="W9FASI.CODGARA = W9RITA.CODGARA AND W9FASI.CODLOTT = W9RITA.CODLOTT" />
			<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false" value="${codlott}"  
				where="W9FASI.CODGARA = W9RITA.CODGARA AND W9FASI.CODLOTT = W9RITA.CODLOTT"/>
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
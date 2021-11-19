<%
	/*
	 * Created on: 12/04/2011
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
<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}'></c:set>
<c:set var="codlott" value='${gene:getValCampo(key,"CODLOTT")}'></c:set>
<c:set var="numappa" value='${gene:getValCampo(key,"NUM_APPA")}'></c:set>
<%
	/* Dati generali del lavoro */
%>

<gene:formScheda entita="W9APPA" gestisciProtezioni="true"
	plugin="it.eldasoft.w9.tags.gestori.plugin.GestoreW9APPA"
	gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9APPA">
	
	<gene:redefineInsert name="schedaNuovo" />
	<gene:redefineInsert name="pulsanteNuovo" />
	
	<gene:redefineInsert name="addToAzioni">
		<jsp:include page="../commons/addtodocumenti-validazione.jsp" />
	</gene:redefineInsert>
	
	<c:if test='${permessoUser lt 4}' >
		<gene:redefineInsert name="schedaModifica" />
		<gene:redefineInsert name="pulsanteModifica" />
	</c:if>
	
	<c:set var="jspPath" value='w9appa-pg-dettaglioFase-a21.jsp' scope="request" />
	<gene:gruppoCampi idProtezioni="GEN">
		<gene:campoScheda>
			<td colspan="2"><b>Dati economici dell'adesione </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="CODGARA" visibile="false" value='${gene:getValCampo(key,"CODGARA")}' />
		<gene:campoScheda campo="CODLOTT" visibile="false" value='${gene:getValCampo(key,"CODLOTT")}' />
		<gene:campoScheda campo="NUM_APPA" visibile="false" value='${gene:getValCampo(key,"NUM_APPA")}' />
		<gene:campoScheda campo="COD_STRUMENTO" />
		<gene:campoScheda campo="IMPORTO_LAVORI" />
		<gene:campoScheda campo="IMPORTO_SERVIZI" />
		<gene:campoScheda campo="IMPORTO_FORNITURE" />
		<gene:campoScheda campo="IMPORTO_SUBTOTALE" modificabile="false" >
			<gene:calcoloCampoScheda 
   				funzione='toMoney(sommaCampi(new Array("#W9APPA_IMPORTO_LAVORI#","#W9APPA_IMPORTO_SERVIZI#","#W9APPA_IMPORTO_FORNITURE#")))' 
  				elencocampi="W9APPA_IMPORTO_LAVORI;W9APPA_IMPORTO_SERVIZI;W9APPA_IMPORTO_FORNITURE"/>
		</gene:campoScheda>

		<gene:campoScheda campo="IMPORTO_ATTUAZIONE_SICUREZZA" />
		<gene:campoScheda campo="IMPORTO_PROGETTAZIONE" />
		<gene:campoScheda campo="IMP_NON_ASSOG" />

		<gene:campoScheda campo="IMPORTO_COMPL_APPALTO" modificabile="false" visibile="false">
			<gene:calcoloCampoScheda funzione='toMoney(sommaCampi(new Array("#W9APPA_IMPORTO_SUBTOTALE#","#W9APPA_IMPORTO_ATTUAZIONE_SICUREZZA#","#W9APPA_IMPORTO_PROGETTAZIONE#","#W9APPA_IMP_NON_ASSOG#")' elencocampi="W9APPA_IMPORTO_SUBTOTALE;W9APPA_IMPORTO_ATTUAZIONE_SICUREZZA;W9APPA_IMPORTO_PROGETTAZIONE;W9APPA_IMP_NON_ASSOG"/>
		</gene:campoScheda>
		<gene:campoScheda campo="IMPORTO_COMPL_INTERVENTO" modificabile="false" visibile="false">
			<gene:calcoloCampoScheda funzione='toMoney("#W9APPA_IMPORTO_COMPL_APPALTO#")'	elencocampi="W9APPA_IMPORTO_COMPL_APPALTO"/>
		</gene:campoScheda>	
		
		<gene:campoScheda>
			<td colspan="2"><b>Aggiudicazione / affidamento </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="PERC_RIBASSO_AGG" />
		<gene:campoScheda campo="PERC_OFF_AUMENTO" />
		<gene:campoScheda campo="IMPORTO_AGGIUDICAZIONE"   defaultValue="${requestScope.initImportoAggiu}" />
		<gene:campoScheda campo="DATA_VERB_AGGIUDICAZIONE" defaultValue="${requestScope.initDataVerbAggiu}" />
		
		<gene:campoScheda campo="FLAG_RICH_SUBAPPALTO" />
		
		<gene:campoScheda campo="TIPO_ATTO" />
		<gene:campoScheda campo="DATA_ATTO" />
		<gene:campoScheda campo="NUMERO_ATTO" />
	</gene:gruppoCampi>
	
	<!-- campi per  W9FASI-->
	<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
		where="W9FASI.CODGARA=W9APPA.CODGARA AND W9FASI.CODLOTT=W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=12" />
	<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false"  value="${codlott}" 
		where="W9FASI.CODGARA=W9APPA.CODGARA AND W9FASI.CODLOTT=W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=12"/>
	<gene:campoScheda campo="FASE_ESECUZIONE" entita="W9FASI" defaultValue="${flusso}" visibile="false" 
		where="W9FASI.CODGARA = W9APPA.CODGARA AND W9FASI.CODLOTT = W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=12"/>
	<gene:campoScheda campo="NUM" entita="W9FASI" visibile="false" 
		where="W9FASI.CODGARA = W9APPA.CODGARA AND W9FASI.CODLOTT = W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=12"/>	
	
	<gene:campoScheda>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
	</gene:campoScheda>
</gene:formScheda>

<gene:redefineInsert name="head">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/browser.js"></script>
</gene:redefineInsert>

<gene:javaScript>
	function sommaCampi(valori)	{
		var i, ret=0;
		for(i=0;i < valori.length;i++){
			if(valori[i]!=""){
		    ret += eval(valori[i]);
		  }
		}
	  return eval(ret).toFixed(2);
 	}
</gene:javaScript>
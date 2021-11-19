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
	
	<c:set var="key" value='${key}' scope="request" />
	<c:set var="jspPath" value='w9appa-pg-dettaglioFase-a04.jsp' scope="request" />

	<gene:gruppoCampi idProtezioni="GEN">
		<gene:campoScheda>
			<td colspan="2"><b>Dati economici dell'appalto </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="CODLOTT" visibile="false" value='${gene:getValCampo(key,"CODLOTT")}' />
		<gene:campoScheda campo="CODGARA" value='${gene:getValCampo(key,"CODGARA")}' visibile="false" />
		<gene:campoScheda campo="NUM_APPA" defaultValue="1" value='1' visibile="false" />
		<gene:campoScheda campo="ASTA_ELETTRONICA" />
		<gene:campoScheda campo="FIN_REGIONALE" />
		<gene:campoScheda campo="FLAG_LIVELLO_PROGETTUALE" />
		<gene:campoScheda campo="IMPORTO_SUBTOTALE" />
		<gene:campoScheda campo="IMPORTO_ATTUAZIONE_SICUREZZA" />
		<gene:campoScheda campo="FLAG_SICUREZZA" />
		<gene:campoScheda campo="IMPORTO_COMPL_APPALTO" modificabile="false" >
			<gene:calcoloCampoScheda 
   				funzione='toMoney(sommaCampi(new Array("#W9APPA_IMPORTO_SUBTOTALE#","#W9APPA_IMPORTO_ATTUAZIONE_SICUREZZA#")))' 
  				elencocampi="W9APPA_IMPORTO_SUBTOTALE;W9APPA_IMPORTO_ATTUAZIONE_SICUREZZA" />
		</gene:campoScheda>
		
		<gene:campoScheda campo="IVA" defaultValue="${requestScope.iva}"/>
		<gene:campoScheda campo="IMPORTO_IVA">
			<gene:calcoloCampoScheda 
   				funzione='toMoney(calcoloIva("#W9APPA_IMPORTO_COMPL_APPALTO#","#W9APPA_IVA#"))' 
  				elencocampi="W9APPA_IMPORTO_COMPL_APPALTO;W9APPA_IVA" />
		</gene:campoScheda>
		<gene:campoScheda campo="ALTRE_SOMME" />
		<gene:campoScheda campo="IMPORTO_DISPOSIZIONE" modificabile="false" defaultValue="0">
			<gene:calcoloCampoScheda 
   				funzione='noZero(toMoney(sommaCampi(new Array("#W9APPA_IMPORTO_IVA#","#W9APPA_ALTRE_SOMME#"))))' 
  				elencocampi="W9APPA_IMPORTO_IVA;W9APPA_ALTRE_SOMME" />
		</gene:campoScheda>
		<gene:campoScheda campo="IMPORTO_COMPL_INTERVENTO" modificabile="false" >
			<gene:calcoloCampoScheda 
   				funzione='toMoney(sommaCampi(new Array("#W9APPA_IMPORTO_COMPL_APPALTO#","#W9APPA_IMPORTO_DISPOSIZIONE#")))' 
  				elencocampi="W9APPA_IMPORTO_COMPL_APPALTO;W9APPA_IMPORTO_DISPOSIZIONE" />
		</gene:campoScheda>
		<gene:campoScheda campo="FLAG_IMPORTI" />
		
		<gene:campoScheda campo="PERC_RIBASSO_AGG" />
		<gene:campoScheda campo="PERC_OFF_AUMENTO" />
		<gene:campoScheda campo="IMPORTO_AGGIUDICAZIONE"   defaultValue="${requestScope.initImportoAggiu}" />
		<gene:campoScheda campo="DATA_VERB_AGGIUDICAZIONE" defaultValue="${requestScope.initDataVerbAggiu}" />
		
		<gene:campoScheda campo="TIPO_ATTO" defaultValue="${requestScope.initTipoAtto}" />
		<gene:campoScheda campo="DATA_ATTO" defaultValue="${requestScope.initDataAtto}" /> 
		<gene:campoScheda campo="NUMERO_ATTO" defaultValue="${requestScope.initNumeroAtto}" />
		
		<gene:campoScheda campo="DATA_STIPULA" defaultValue="${requestScope.initDataStipula}" />
		<gene:campoScheda campo="DURATA_CON" defaultValue="${requestScope.initDurataContratto}" />

		<!-- campi per  W9FASI-->
		<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
			where="W9FASI.CODGARA=W9APPA.CODGARA AND W9FASI.CODLOTT=W9APPA.CODLOTT  and W9FASI.FASE_ESECUZIONE=987" />
		<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false"  value="${codlott}" 
			where="W9FASI.CODGARA=W9APPA.CODGARA AND W9FASI.CODLOTT=W9APPA.CODLOTT  and W9FASI.FASE_ESECUZIONE=987"/>
		<gene:campoScheda campo="FASE_ESECUZIONE" entita="W9FASI" defaultValue="${flusso}" visibile="false" 
			where="W9FASI.CODGARA = W9APPA.CODGARA AND W9FASI.CODLOTT = W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=987"/>
		<gene:campoScheda campo="NUM" entita="W9FASI" visibile="false" 
			where="W9FASI.CODGARA = W9APPA.CODGARA AND W9FASI.CODLOTT = W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=987"/>	
			
	</gene:gruppoCampi>

	<gene:campoScheda>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
	</gene:campoScheda>
</gene:formScheda>

<gene:redefineInsert name="head">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/browser.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/date.js"></script>
</gene:redefineInsert>
<gene:javaScript>
	
	function sommaCampi(valori) {
		var i, ret=0;
		for(i=0;i < valori.length;i++){
			if(valori[i]!=""){
		    ret += eval(valori[i]);
		  }
		}
	  return eval(ret).toFixed(2);
 	}

	function noZero(valore) {
	 	if (valore.val == 0) 
	 	  return "0.00";
	 	else
	 	  return valore;
	}

	function calcoloIva(valore, iva) {
		var result = 0;
		if (valore != "" && iva != "") {
			result = eval(valore) * eval(iva) / 100;
		}
		return eval(result).toFixed(2);
 	}
</gene:javaScript>
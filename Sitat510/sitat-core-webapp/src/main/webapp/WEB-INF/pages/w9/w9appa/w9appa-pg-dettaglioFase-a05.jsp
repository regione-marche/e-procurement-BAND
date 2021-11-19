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
<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}'></c:set>
<c:set var="codlott" value='${gene:getValCampo(key,"CODLOTT")}'></c:set>
<c:set var="numappa" value='${gene:getValCampo(key,"NUM_APPA")}'></c:set>

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

	<c:set var="jspPath" value='w9appa-pg-dettaglioFase-a05.jsp' scope="request" />
	<gene:gruppoCampi idProtezioni="GEN">
		<gene:campoScheda>
			<td colspan="2"><b>Dati economici dell'appalto </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="CODGARA" visibile="false" value='${gene:getValCampo(key,"CODGARA")}' />
		<gene:campoScheda campo="CODLOTT" visibile="false" value='${gene:getValCampo(key,"CODLOTT")}'/>
		<gene:campoScheda campo="NUM_APPA" visibile="false" defaultValue="1" value='1' />
		<gene:campoScheda campo="VER_SIMOG" entita="W9GARA" visibile="false" where="W9APPA.CODGARA=W9GARA.CODGARA" />
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
		<gene:campoScheda campo="FLAG_SICUREZZA" />
		<gene:campoScheda campo="IMPORTO_PROGETTAZIONE" />
		<gene:campoScheda campo="IMP_NON_ASSOG" />
		<gene:campoScheda campo="IMPORTO_COMPL_APPALTO" modificabile="false" >
			<gene:calcoloCampoScheda 
   				funzione='toMoney(sommaCampi(new Array("#W9APPA_IMPORTO_SUBTOTALE#","#W9APPA_IMPORTO_ATTUAZIONE_SICUREZZA#","#W9APPA_IMPORTO_PROGETTAZIONE#","#W9APPA_IMP_NON_ASSOG#")))' 
  				elencocampi="W9APPA_IMPORTO_SUBTOTALE;W9APPA_IMPORTO_ATTUAZIONE_SICUREZZA;W9APPA_IMPORTO_PROGETTAZIONE;W9APPA_IMP_NON_ASSOG"/>
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
		<gene:campoScheda campo="IMPORTO_COMPL_INTERVENTO"
			modificabile="false" >
			<gene:calcoloCampoScheda 
   				funzione='toMoney(sommaCampi(new Array("#W9APPA_IMPORTO_COMPL_APPALTO#","#W9APPA_IMPORTO_DISPOSIZIONE#")))' 
				elencocampi="W9APPA_IMPORTO_COMPL_APPALTO;W9APPA_IMPORTO_DISPOSIZIONE;"/>
		</gene:campoScheda>
		<gene:campoScheda campo="FLAG_IMPORTI" />
		<gene:campoScheda campo="OPERE_URBANIZ_SCOMPUTO" />
		<gene:campoScheda campo="FLAG_LIVELLO_PROGETTUALE" />
		<gene:campoScheda campo="MODALITA_RIAGGIUDICAZIONE" visibile="false" />
		
		<gene:campoScheda>
			<td colspan="2"><b>Dati procedurali dell'appalto </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="REQUISITI_SETT_SPEC" visibile="${isFlagEnteSpeciale}" />
		<gene:campoScheda campo="FLAG_ACCORDO_QUADRO" />
		<gene:campoScheda campo="PROCEDURA_ACC" />
		<gene:campoScheda campo="PREINFORMAZIONE" />
		<gene:campoScheda campo="TERMINE_RIDOTTO" />
		<gene:campoScheda campo="ID_MODO_INDIZIONE" visibile="${isFlagEnteSpeciale && datiRiga.W9GARA_VER_SIMOG eq 1}" />
		<gene:campoScheda campo="VERIFICA_CAMPIONE" />
		<gene:campoScheda campo="FIN_REGIONALE" />
		<gene:campoScheda>
			<td colspan="2"><b>Inviti ed offerte / soglia di anomalia </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="DATA_MANIF_INTERESSE" />
		<gene:campoScheda campo="NUM_MANIF_INTERESSE" />
		<gene:campoScheda campo="DATA_SCADENZA_RICHIESTA_INVITO" visibile="${(idSceltaContraente eq 2) or (idSceltaContraente eq 9)}" />
		<gene:campoScheda campo="NUM_IMPRESE_RICHIEDENTI" visibile="${(idSceltaContraente eq 2) or (idSceltaContraente eq 9)}" />
		<gene:campoScheda campo="DATA_INVITO" visibile="${idSceltaContraente ne 1}" />
		<gene:campoScheda campo="NUM_IMPRESE_INVITATE" visibile="${idSceltaContraente ne 1}" />
		<gene:campoScheda campo="DATA_SCADENZA_PRES_OFFERTA" />
		
		<gene:campoScheda campo="NUM_IMPRESE_OFFERENTI" />
		<gene:campoScheda campo="NUM_OFFERTE_AMMESSE" />
		<gene:campoScheda campo="NUM_OFFERTE_ESCLUSE" />
		<gene:campoScheda campo="NUM_OFFERTE_FUORI_SOGLIA" />
		<gene:campoScheda campo="NUM_IMP_ESCL_INSUF_GIUST" />
		<gene:campoScheda campo="OFFERTA_MASSIMO" >
			<gene:checkCampoScheda funzione='confrontaOfferte()' obbligatorio="true" onsubmit="false" messaggio="Offerta massima deve essere maggiore dell'offerta minima"/>
		</gene:campoScheda>
		<gene:campoScheda campo="OFFERTA_MINIMA" >
			<gene:checkCampoScheda funzione='confrontaOfferte()' obbligatorio="true" onsubmit="false" messaggio="Offerta minima deve essere minore dell'offerta massima"/>
		</gene:campoScheda>
		<gene:campoScheda campo="VAL_SOGLIA_ANOMALIA" />
		<gene:campoScheda campo="ASTA_ELETTRONICA" />

		<gene:campoScheda>
			<td colspan="2"><b>Aggiudicazione / affidamento </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="PERC_RIBASSO_AGG" />
		<gene:campoScheda campo="PERC_OFF_AUMENTO" />
		<gene:campoScheda campo="IMPORTO_AGGIUDICAZIONE"   defaultValue="${requestScope.initImportoAggiu}" />
		<gene:campoScheda campo="DATA_VERB_AGGIUDICAZIONE" defaultValue="${requestScope.initDataVerbAggiu}" />

		<gene:campoScheda campo="TIPO_ATTO" defaultValue="${requestScope.initTipoAtto}" />
		<gene:campoScheda campo="DATA_ATTO" defaultValue="${requestScope.initDataAtto}" /> 
		<gene:campoScheda campo="NUMERO_ATTO" defaultValue="${requestScope.initNumeroAtto}" />

		<gene:campoScheda campo="FLAG_RICH_SUBAPPALTO" />

	</gene:gruppoCampi>
	
	
	<!-- campi per  W9FASI-->
	<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
		where="W9FASI.CODGARA=W9APPA.CODGARA AND W9FASI.CODLOTT=W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=1" />
	<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false"  value="${codlott}" 
		where="W9FASI.CODGARA=W9APPA.CODGARA AND W9FASI.CODLOTT=W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=1"/>
	<gene:campoScheda campo="FASE_ESECUZIONE" entita="W9FASI" defaultValue="${flusso}" visibile="false" 
		where="W9FASI.CODGARA = W9APPA.CODGARA AND W9FASI.CODLOTT = W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=1"/>
	<gene:campoScheda campo="NUM" entita="W9FASI" visibile="false" 
		where="W9FASI.CODGARA = W9APPA.CODGARA AND W9FASI.CODLOTT = W9APPA.CODLOTT and W9FASI.FASE_ESECUZIONE=1"/>	
		
	<gene:fnJavaScriptScheda funzione='gestioneVisibilitaCampiDaModoIndizione("#W9APPA_ID_MODO_INDIZIONE#")' elencocampi="W9APPA_ID_MODO_INDIZIONE" esegui="true" />
		
	<gene:fnJavaScriptScheda funzione='gestioneVisibilitaCampiDaNumOfferteAmmesse("#W9APPA_NUM_OFFERTE_AMMESSE#")' elencocampi="W9APPA_NUM_OFFERTE_AMMESSE" esegui="true" />

	<gene:campoScheda>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
	</gene:campoScheda>
</gene:formScheda>

<gene:redefineInsert name="head">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/browser.js"></script>
</gene:redefineInsert>
<gene:javaScript>
	
	function sommaCampi(valori)
	 	{
		  var i, ret=0;
		  for(i=0;i < valori.length;i++){
		   if(valori[i]!=""){
		    ret += eval(valori[i]);
		   }
		  }
		  	return eval(ret).toFixed(2);
 		}
 
 	function noZero(valore)
	 	{
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
 	
	function gestioneVisibilitaCampiDaModoIndizione(idModoIndizione) {
		var idSceltaContraente = new Number(${idSceltaContraente});
		//alert("idSceltaContraente = " + idSceltaContraente);
		//alert("Test1: " + (idSceltaContraente >= 3) + "\nTest2: " + (idModoIndizione == 1) + "\nTest3: " + (idSceltaContraente >= 3 && idModoIndizione == 1));
		
		if (idSceltaContraente == 1) {
			showObj("rowW9APPA_DATA_SCADENZA_RICHIESTA_INVITO", false);
			showObj("rowW9APPA_NUM_IMPRESE_RICHIEDENTI", false);
			showObj("rowW9APPA_DATA_INVITO", false);
			//showObj("rowW9APPA_NUM_IMPRESE_INVITATE", false);

			setValue("W9APPA_DATA_SCADENZA_RICHIESTA_INVITO", "");
			setValue("W9APPA_NUM_IMPRESE_RICHIEDENTI", "");
			setValue("W9APPA_DATA_INVITO", "");
			//setValue("W9APPA_NUM_IMPRESE_INVITATE", "");
		} else {
			showObj("rowW9APPA_DATA_SCADENZA_RICHIESTA_INVITO", true);
			showObj("rowW9APPA_NUM_IMPRESE_RICHIEDENTI", true);
			showObj("rowW9APPA_DATA_INVITO", true);
			//showObj("rowW9APPA_NUM_IMPRESE_INVITATE", true);
		}
	}
	
	function gestioneVisibilitaCampiDaNumOfferteAmmesse(numeroOfferteAmmesse) {
		if (numeroOfferteAmmesse >= 5) {
			showObj("rowW9APPA_VAL_SOGLIA_ANOMALIA", true);
			showObj("rowW9APPA_NUM_OFFERTE_FUORI_SOGLIA", true);
		} else {
			showObj("rowW9APPA_VAL_SOGLIA_ANOMALIA", false);
			showObj("rowW9APPA_NUM_OFFERTE_FUORI_SOGLIA", false);
			setValue("W9APPA_VAL_SOGLIA_ANOMALIA", "");
			setValue("W9APPA_NUM_OFFERTE_FUORI_SOGLIA", "");
		}
	}
	
	function confrontaOfferte() {
		var offertaMassimo = getValue("W9APPA_OFFERTA_MASSIMO");
		var offertaMinima = getValue("W9APPA_OFFERTA_MINIMA");
		if (new Number(offertaMassimo).valueOf() < new Number(offertaMinima).valueOf())
			return false;
		else
			return true;
	}

</gene:javaScript>
<jsp:include page="/WEB-INF/pages/commons/defaultValues.jsp" />
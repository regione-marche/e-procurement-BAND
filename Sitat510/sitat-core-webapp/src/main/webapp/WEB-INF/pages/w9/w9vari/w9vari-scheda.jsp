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

<gene:template file="scheda-template.jsp" gestisciProtezioni="true"
	schema="W9" idMaschera="W9VARI-scheda">
	<c:set var="key" value='${key}' scope="request" />
	<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}' />
	<c:set var="codlott" value='${gene:getValCampo(key,"CODLOTT")}' />
	<c:set var="flusso" value='7' scope="request" />
	<c:set var="key1" value='${gene:getValCampo(key,"CODGARA")}' scope="request" />
	<c:set var="key2" value='${gene:getValCampo(key,"CODLOTT")}' scope="request" />
	<c:set var="key3" value='${gene:getValCampo(key,"NUM_VARI")}' scope="request" />

	<c:set var="permessoUser" value='${gene:callFunction3("it.eldasoft.w9.tags.funzioni.GetPermessoUserFunction",pageContext,key,"W9VARI")}' scope="request" />

	<gene:setString name="titoloMaschera" value='${gene:if("NUOVO"==modo, "Nuova Modifica contrattuale", "Modifica contrattuale")}' />

	<gene:redefineInsert name="corpo">
		<gene:formScheda entita="W9VARI" gestisciProtezioni="true" plugin="it.eldasoft.w9.tags.gestori.plugin.GestoreW9VARI"
			gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9VARI">

			<gene:redefineInsert name="schedaNuovo" />
			<gene:redefineInsert name="pulsanteNuovo" />

			<c:if test='${permessoUser lt 4}' >
				<gene:redefineInsert name="schedaModifica" />
				<gene:redefineInsert name="pulsanteModifica" />
			</c:if>

			<gene:gruppoCampi idProtezioni="GEN">
				<gene:campoScheda>
					<td colspan="2"><b>Modifica contrattuale </b></td>
				</gene:campoScheda>
				<gene:campoScheda campo="CODGARA" visibile="false"
					value="${codgara}" />
				<gene:campoScheda campo="CODLOTT" visibile="false"
					value="${codlott}" />
				<gene:campoScheda campo="NUM_VARI" modificabile="false"
					visibile="${modoAperturaScheda ne 'NUOVO'}" />
				<gene:campoScheda campo="DATA_VERB_APPR" />
				<gene:campoScheda campo="FLAG_VARIANTE" />
				<gene:campoScheda campo="QUINTO_OBBLIGO" />
				<gene:campoScheda>
					<td colspan="2"><b>Motivazioni della modifica contrattuale</b></td>
				</gene:campoScheda>
				<c:if test="${fn:length(datiTabellatoList) >0}">
					<c:forEach begin="0" end="${fn:length(datiTabellatoList)-1}" var="indiceTab">
						<c:set var="valore"></c:set>
						<c:if test='${modo ne "NUOVO"}'>
							<c:set var="valore"
								value='${gene:callFunction3("it.eldasoft.w9.tags.funzioni.VerificaMotivoDaTabellatoFunction", pageContext, key, datiTabellatoList[indiceTab][0])}'></c:set>
						</c:if>
						<gene:campoScheda campoFittizio="true" entita="W9MOTI"
							campo="ID_MOTIVO_VAR_${indiceTab+1}"
							title="${datiTabellatoList[indiceTab][1]}"
							definizione="N5;0;;SN;" value="${valore}" />
						<gene:campoScheda campoFittizio="true" entita="W9MOTI"
							campo="VALORE_ID_MOTIVO_VAR_${indiceTab+1}"
							title="${datiTabellatoList[indiceTab][1]}"
							value="${datiTabellatoList[indiceTab][0]}"
							definizione="N5;0;;;" visibile="false" />
					</c:forEach>
				</c:if>
				<gene:campoScheda campo="ALTRE_MOTIVAZIONI" />
				<gene:campoScheda campo="CIG_NUOVA_PROC" >
					<gene:checkCampoScheda funzione='checkCodiceCIG()' obbligatorio="true" onsubmit="false" messaggio="Codice CIG o SmartCIG non valido" />
				</gene:campoScheda>
				<gene:campoScheda>
					<td colspan="2"><b>Atti aggiuntivi/sottomissione </b></td>
				</gene:campoScheda>
				<gene:campoScheda campo="DATA_ATTO_AGGIUNTIVO" />
				<gene:campoScheda campo="NUM_GIORNI_PROROGA" />
				<gene:campoScheda>
					<td colspan="2"><b>Quadro economico</b></td>
				</gene:campoScheda>
				<gene:campoScheda campo="FLAG_IMPORTI" />
				<gene:campoScheda campo="IMP_RIDET_LAVORI" />
				<gene:campoScheda campo="IMP_RIDET_SERVIZI" />
				<gene:campoScheda campo="IMP_RIDET_FORNIT" />
				<gene:campoScheda campo="IMP_SUBTOTALE" modificabile="false" >
					<gene:calcoloCampoScheda 
   						funzione='toMoney(sommaCampi(new Array("#W9VARI_IMP_RIDET_LAVORI#","#W9VARI_IMP_RIDET_SERVIZI#","#W9VARI_IMP_RIDET_FORNIT#")))' 
  						elencocampi="W9VARI_IMP_RIDET_LAVORI;W9VARI_IMP_RIDET_SERVIZI;W9VARI_IMP_RIDET_FORNIT" />
				</gene:campoScheda>
				<gene:campoScheda campo="IMP_SICUREZZA" />
				<gene:campoScheda campo="FLAG_SICUREZZA" />
				<gene:campoScheda campo="IMP_PROGETTAZIONE" />
				<gene:campoScheda campo="IMP_NON_ASSOG" />
				<gene:campoScheda campo="IMP_COMPL_APPALTO" modificabile="false" >
					<gene:calcoloCampoScheda 
   						funzione='toMoney(sommaCampi(new Array("#W9VARI_IMP_SUBTOTALE#","#W9VARI_IMP_SICUREZZA#","#W9VARI_IMP_PROGETTAZIONE#","#W9VARI_IMP_NON_ASSOG#")))' 
  						elencocampi="W9VARI_IMP_SUBTOTALE;W9VARI_IMP_SICUREZZA;W9VARI_IMP_PROGETTAZIONE;W9VARI_IMP_NON_ASSOG" />
				</gene:campoScheda>
				<gene:campoScheda campo="IMP_DISPOSIZIONE" />
				<gene:campoScheda campo="IMP_COMPL_INTERVENTO" modificabile="false" >
					<gene:calcoloCampoScheda 
   						funzione='toMoney(sommaCampi(new Array("#W9VARI_IMP_COMPL_APPALTO#","#W9VARI_IMP_DISPOSIZIONE#")))' 
  						elencocampi="W9VARI_IMP_COMPL_APPALTO;W9VARI_IMP_DISPOSIZIONE" />
				</gene:campoScheda>
			</gene:gruppoCampi>

			<!-- campi per  W9FASI-->
			<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
				where="W9FASI.CODGARA = W9VARI.CODGARA AND W9FASI.CODLOTT = W9VARI.CODLOTT" />
			<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false" value="${codlott}"  
				where="W9FASI.CODGARA = W9VARI.CODGARA AND W9FASI.CODLOTT = W9VARI.CODLOTT"/>
			<gene:campoScheda campo="FASE_ESECUZIONE" entita="W9FASI" visibile="false" value="${flusso}"/>
			<gene:campoScheda campo="NUM" entita="W9FASI" visibile="false" />	

			<gene:campoScheda>
				<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
			</gene:campoScheda>
			
			<gene:fnJavaScriptScheda funzione='gestioneCigNuovaProcedura()' elencocampi="W9MOTI_ID_MOTIVO_VAR_7" esegui="true" />
			
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
  
	function sommaCampi(valori) {
	  var i, ret=0;
	  for(i=0;i < valori.length;i++){
	   if(valori[i]!=""){
	    ret += eval(valori[i]);
	   }
	  }
	  return eval(ret).toFixed(2);
	}
 		
 	function isStringaNumerica(str) {
 		var oggettoEspressioneRegolare = new RegExp("^[0-9]{7}$");
		return oggettoEspressioneRegolare.test(str);
 	}
 	
 	function isStringaEsadecimale(str) {
 		var oggettoEspressioneRegolare = new RegExp("^[a-fA-F0-9]{3}$");
		return oggettoEspressioneRegolare.test(str);
 	}

	// leftPad della stringa str, con il carattere padStr, con lunghezza len
 	function leftPadFunction(str, padStr, len) {
		while (str.length < len) {
			str = padStr + str;
		}
		return str;
	}

	// Validazione formale del codiceCIG o dello SmartCIG
	function checkCodiceCIG() {
		var codiceCIG = getValue("W9VARI_CIG_NUOVA_PROC");
		var result = false;
		if (codiceCIG.length == 10) {
			if (codiceCIG != "0000000000") {
				var primi7CaratteriCIG = codiceCIG.substring(0,7);
				var ultimi3CaratteriCIG = codiceCIG.substring(7).toUpperCase();
				
				if (isStringaNumerica(primi7CaratteriCIG) && isStringaEsadecimale(ultimi3CaratteriCIG)) {
					var oper1 = parseInt(primi7CaratteriCIG);
					var resto = (oper1 * 211) % 4091;
					var strResto = leftPadFunction(resto.toString(16),'0',3).toUpperCase();
					
					if (ultimi3CaratteriCIG == strResto) {
						result = true;
					}
				}
			}
		} else if (codiceCIG.length == 0) {
			result = true;
		}
 		return result;
 	}

	function gestioneCigNuovaProcedura() {
		<c:choose>
			<c:when test="${modo eq 'VISUALIZZA'}" >
				showObj("rowW9VARI_CIG_NUOVA_PROC", ${motivoVariante18 eq "1"});
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test='${requestScope.versioneSimog eq 2}' >
						var prorogaTecnica = getValue("W9MOTI_ID_MOTIVO_VAR_7");
						if ("1" == prorogaTecnica) {
							showObj("rowW9VARI_CIG_NUOVA_PROC", true);							
						} else {
							showObj("rowW9VARI_CIG_NUOVA_PROC", false);
							setValue("W9VARI_CIG_NUOVA_PROC", "");
						}
					</c:when>
					<c:otherwise>
						showObj("rowW9VARI_CIG_NUOVA_PROC", false);
					</c:otherwise>
				</c:choose>		
			</c:otherwise>
		</c:choose>
	}

 	<c:if test='${modo eq "MODIFICA"}' >
		<c:set var="localkey" value='${codgara};${codlott};${flusso};${key3}' scope="request" />
		<jsp:include page="/WEB-INF/pages/w9/commons/controlloJsFaseDaReinviare.jsp" />
	</c:if>
 		
</gene:javaScript>

</gene:template>
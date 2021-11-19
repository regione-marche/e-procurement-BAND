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
<gene:template file="scheda-template.jsp" gestisciProtezioni="true" schema="W9" idMaschera="W9SUBA-scheda">
	<c:set var="key" value='${key}' scope="request" />
	<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}' />
	<c:set var="codlott" value='${gene:getValCampo(key,"CODLOTT")}' />
	<c:set var="flusso" value='9' scope="request" />
	<c:set var="key1" value='${gene:getValCampo(key,"CODGARA")}' scope="request" />
	<c:set var="key2" value='${gene:getValCampo(key,"CODLOTT")}' scope="request" />
	<c:set var="key3" value='${gene:getValCampo(key,"NUM_SUBA")}' scope="request" />
	
	<c:set var="permessoUser" value='${gene:callFunction3("it.eldasoft.w9.tags.funzioni.GetPermessoUserFunction",pageContext,key,"W9SUBA")}' scope="request" />
	
	<gene:setString name="titoloMaschera" value='${gene:if("NUOVO"==modo, "Nuovo Subappalto", "Subappalto")}' />
	
	<gene:redefineInsert name="corpo">
		<gene:formScheda entita="W9SUBA" plugin="it.eldasoft.w9.tags.gestori.plugin.GestoreW9SUBA"
			gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9SUBA" gestisciProtezioni="true" >
			
			<gene:redefineInsert name="schedaNuovo" />
			<gene:redefineInsert name="pulsanteNuovo" />
			
			<c:if test='${permessoUser lt 4}' >
				<gene:redefineInsert name="schedaModifica" />
				<gene:redefineInsert name="pulsanteModifica" />
			</c:if>
			
			<gene:gruppoCampi idProtezioni="GEN">
				<gene:campoScheda>
					<td colspan="2"><b>Subappalto</b></td>
				</gene:campoScheda>
				<gene:campoScheda campo="CODGARA" visibile="false" value="${codgara}" />
				<gene:campoScheda campo="CODLOTT" visibile="false" value="${codlott}" />
				<gene:campoScheda campo="NUM_SUBA" modificabile="false" visibile="${modoAperturaScheda ne 'NUOVO'}" />
				<gene:campoScheda campo="OGGETTO_SUBAPPALTO" />
				
				<gene:archivio titolo="Imprese" obbligatorio="true"
					lista='${gene:if(gene:checkProt( pageContext,"COLS.MOD.W9.W9SUBA.CODIMP"),"gene/impr/impr-lista-popup.jsp","")}'
					scheda='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","GENE.ImprScheda"),"gene/impr/impr-scheda.jsp","")}'
					schedaPopUp='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","GENE.ImprScheda"),"gene/impr/impr-scheda-popup.jsp","")}'
					campi="IMPR.CODIMP;IMPR.NOMEST" chiave="W9SUBA_CODIMP_AGGIUDICATRICE" 
					where="IMPR.CODIMP in (select CODIMP from W9AGGI where CODGARA=${codgara} and CODLOTT=${codlott})"
					formName="formImprese">
					<gene:campoScheda campo="CODIMP_AGGIUDICATRICE" visibile="false" defaultValue="${requestScope.CODIMPAGGIU}" />
					<gene:campoScheda campo="NOMEST" entita="IMPR" where="IMPR.CODIMP=W9SUBA.CODIMP_AGGIUDICATRICE" title="Denom. impresa aggiudicatrice" definizione="T61"
					defaultValue="${requestScope.NOMIMPAGGIU}" visibile="${requestScope.numImpreseAggiudicatarie ne 1}" />
				</gene:archivio>
				
				<gene:campoScheda campo="IMPORTO_PRESUNTO" />
				<gene:campoScheda campo="DATA_AUTORIZZAZIONE" />
				<gene:archivio titolo="Imprese" obbligatorio="true"
					lista='${gene:if(gene:checkProt( pageContext,"COLS.MOD.W9.W9SUBA.CODIMP"),"gene/impr/impr-lista-popup.jsp","")}'
					scheda='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","GENE.ImprScheda"),"gene/impr/impr-scheda.jsp","")}'
					schedaPopUp='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","GENE.ImprScheda"),"gene/impr/impr-scheda-popup.jsp","")}'
					campi="IMPR.CODIMP;IMPR.NOMEST" chiave="W9SUBA_CODIMP" 
					formName="formImprese1">
					<gene:campoScheda campo="CODIMP" visibile="false" />
					<gene:campoScheda campo="NOMEST1" campoFittizio="true" title="Denom. impresa subappaltatrice" definizione="T61" value="${nomeimpr}" />
				</gene:archivio>
				<gene:campoScheda campo="IMPORTO_EFFETTIVO" />
				<gene:campoScheda campo="ID_CATEGORIA" />

				<gene:campoScheda campo="ID_CPV"
					href='javascript:formCPV(${!(modoAperturaScheda eq "VISUALIZZA")})'
					modificabile="false" speciale="true">
					<c:if test='${modoAperturaScheda ne "VISUALIZZA"}'>
						<gene:popupCampo titolo="Dettaglio codice CODCPV"
							href="formCPV(${modoAperturaScheda ne 'VISUALIZZA'})" />
					</c:if>
				</gene:campoScheda>
				<gene:campoScheda campo="CPVDESC" title="Descrizione CPV"
					value="${cpvdescr}" campoFittizio="true" modificabile="false"
					definizione="T150" />

			</gene:gruppoCampi>
			<!-- campi per  W9FASI-->
			<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
				where="W9FASI.CODGARA = W9SUBA.CODGARA AND W9FASI.CODLOTT = W9SUBA.CODLOTT" />
			<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false" value="${codlott}"  
				where="W9FASI.CODGARA = W9SUBA.CODGARA AND W9FASI.CODLOTT = W9SUBA.CODLOTT"/>
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
	function formCPV(modifica){
		openPopUpCustom("href=commons/descriz-codice-cpv.jsp&key=" + document.forms[0].key.value + "&keyParent=" + document.forms[0].keyParent.value + "&modo="+(modifica ? "MODIFICA":"VISUALIZZA")+"&campo=W9SUBA_ID_CPV&campoDescr=CPVDESC&valore="+ (getValue("W9SUBA_ID_CPV") == "" ? "45000000-7" : getValue("W9SUBA_ID_CPV"))+"&valoreDescr="+ (getValue("CPVDESC") == "" ? "Lavori di costruzione" : getValue("CPVDESC")), "formCPV", 700, 300, 1, 1);
	}
	
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
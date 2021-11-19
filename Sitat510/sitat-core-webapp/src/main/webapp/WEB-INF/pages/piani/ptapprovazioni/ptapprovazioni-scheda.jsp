<%
  /*
   * Created on 11-gen-2018
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

<c:set var="idUtente" value="${sessionScope.profiloUtente.id}" />
<c:set var="nomeUtente" value="${sessionScope.profiloUtente.nome}" />

<!--  	//Raccolta fabbisogni: modifiche per prototipo dicembre 2018 -->
<!-- 	//vedi Raccolta fabbisogni.docx (mail da Lelio 26/11/2018) -->		
<c:set var="fabbisogni" value="${param.fabbisogni}" />
<c:set var="funzionalita" value="${param.funzionalita}" />
<c:set var="contri_PT" value="${param.contri_PT}" />
<c:set var="conint_PT" value="${param.conint_PT}" />



<gene:template file="scheda-template.jsp" gestisciProtezioni="true" schema="PIANI" idMaschera="PTAPPROVAZIONI-scheda">
	<gene:redefineInsert name="corpo">
		<gene:setString name="titoloMaschera" value='Approvazione del fabbisogno' />

		<gene:formScheda entita="PTAPPROVAZIONI" gestisciProtezioni="true" gestore="it.eldasoft.sil.pt.tags.gestori.submit.GestoreApprovazioni" >

			<gene:campoScheda campo="CONINT" visibile="false" />
			<gene:campoScheda campo="NUMAPPR" visibile="false" />
			<gene:campoScheda campo="DATAAPPR" modificabile="false"/>
			<gene:campoScheda campo="SYSAPPR" defaultValue='${idUtente}' visibile="false" />
			<gene:campoScheda campo="UTENTEAPPR" defaultValue='${nomeUtente}' visibile="false" />
			<gene:campoScheda campo="FASEAPPR" visibile="true" defaultValue="${gene:if(fn:contains(funzionalita, 'RDP'),3,1)}" modificabile="false"/>
			<gene:campoScheda campo="ESITOAPPR" obbligatorio="true" defaultValue="${gene:if(funzionalita eq 'RDP_RimuoviRichiediRevisione',3,null)}" modificabile="${gene:if(funzionalita eq 'RDP_RimuoviRichiediRevisione',false,true)}"/>
			<gene:campoScheda campo="NOTEAPPR" >
				<gene:checkCampoScheda funzione='!("##" == "" && "#PTAPPROVAZIONI_ESITOAPPR#" > 1)' obbligatorio="true" messaggio="Specificare una nota." 
										onsubmit="true"/> 
			</gene:campoScheda>
			<gene:fnJavaScriptScheda funzione='gestioneBottoni()' elencocampi="PTAPPROVAZIONI_ESITOAPPR" esegui="true"/>

			<!--  	//Raccolta fabbisogni: modifiche per prototipo dicembre 2018 -->
			<!-- 	//vedi Raccolta fabbisogni.docx (mail da Lelio 26/11/2018) -->		
			<input type="hidden" name="fabbisogni" id="fabbisogni" value="${fabbisogni}" />
			<input type="hidden" name="funzionalita" id="funzionalita" value="${funzionalita}" />	
			<input type="hidden" name="contri_PT" id="contri_PT" value="${contri_PT}" />	
			<input type="hidden" name="conint_PT" id="conint_PT" value="${conint_PT}" />	

			<gene:redefineInsert name="schedaNuovo" />

			<gene:redefineInsert name="schedaConferma" />


			<gene:campoScheda>
				<tr>
					<td class="comandi-dettaglio" colSpan="2">						
						<INPUT id="bottone_Valida" type="button" class="bottone-azione" value="Continua" title="Continua" onclick="javascript:validazione();">&nbsp;
						<INPUT id="bottone_Conferma" type="button" class="bottone-azione" value="Conferma" title="Conferma" onclick="javascript:schedaConferma();">&nbsp;
						<INPUT type="button" class="bottone-azione" value="Annulla" title="Annulla" onclick="javascript:schedaAnnulla()">&nbsp;
					</td>
				</tr>		
			</gene:campoScheda>
			
			
		</gene:formScheda>
		
		<gene:javaScript>
			initDataAppr();
		
			<!--  	//Raccolta fabbisogni: modifiche per prototipo dicembre 2018 -->
			<!-- 	//vedi Raccolta fabbisogni.docx (mail da Lelio 26/11/2018) -->				
			impostaEsitoAppr();
	
			document.forms[0].jspPathTo.value="piani/ptapprovazioni/ptapprovazioni-conclusione-funzionalita.jsp";

			<!--  	//Raccolta fabbisogni: modifiche per prototipo dicembre 2018 -->
			<!-- 	//vedi Raccolta fabbisogni.docx (mail da Lelio 26/11/2018) -->		
			function impostaEsitoAppr() {
				var funzionalita = $('#funzionalita').val();
				switch(funzionalita) {
				    case "RDP_RichiediRevisioneRespingi":
				        $("#PTAPPROVAZIONI_ESITOAPPR option[value='1']").remove();
				        break;
				}
			}
			
			function gestioneBottoni() {
				var funzionalita = $('#funzionalita').val();
				var esito = getValue("PTAPPROVAZIONI_ESITOAPPR");
				showObj("bottone_Valida", false);
				showObj("bottone_Conferma", true);
				if(funzionalita == "RAF_ApprovaRespingi" && esito == 1){
					showObj("bottone_Valida", true);
					showObj("bottone_Conferma", false);
				}
			}

			function initDataAppr() {
			
				var dataOggi = new Date();
				var giorno = dataOggi.getDate();
				if(giorno < 10){
					giorno = "0" + giorno;
				}
				var mese = dataOggi.getMonth() + 1;
				if(mese < 10){
					mese = "0" + mese;
				}
				var anno = dataOggi.getFullYear();
				var oggi = giorno + "/" + mese + "/" + anno;
				setValue("PTAPPROVAZIONI_DATAAPPR",oggi);
			
			}			


			//Raccolta fabbisogni: aprile 2019. Controllo dei dati inseriti sulla proposta/fabbisogno(TAB_CONTROLLI).		
			function validazione(){
					var comando = "href=piani/commons/popup-validazione-fabbisogni.jsp";
					comando = comando + "&fabbisogni="+$('#fabbisogni').val();
					comando = comando + "&codFunzione=INOLTRO_RDP";
					comando = comando + "&invio=conferma";
					openPopUpCustom(comando, "validazione", 500, 650, 1, 1);
			}
		
		
		

		</gene:javaScript>
		
	</gene:redefineInsert>	
</gene:template>

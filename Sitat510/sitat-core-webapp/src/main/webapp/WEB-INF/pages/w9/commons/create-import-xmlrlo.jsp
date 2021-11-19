
<%
	/*
	 * Created on 15-lug-2008
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
<gene:template file="scheda-template.jsp">

	<c:set var="key" value="${param.key}" />
	<gene:setString name="titoloMaschera" value='Scegli operazione' />
	<c:if test='${!empty esito}'>
		<gene:setString name="titoloMaschera" value='Elaborazione file report Osservatorio Contratti Pubblici' />
	</c:if>
	<gene:redefineInsert name="documentiAzioni"></gene:redefineInsert>
	<gene:redefineInsert name="corpo">
		<table class="lista">
			<c:if test="${empty esito}">
				<tr>
					<td>
						<form method="post" enctype="multipart/form-data" name="formImportfile" action="${pageContext.request.contextPath}/w9/ImportXMLRLO.do">
							<table class="dettaglio-notab">
								<tr>
									<td class="valore-dato" colspan="2"><input type="radio" name="tipo" id="create" value="1" checked="checked"> <b>Genera il file xml della scheda per l'osservatorio contratti pubblici</b></td>
								</tr>
								<tr>
									<td class="valore-dato" colspan="2"><input type="radio" name="tipo" id="report" value="1" > <b>Carica il risultato dell'importazione, allega qui la scheda report <input type="file" name="selezioneFile" size="55" onclick="document.getElementById('report').checked='checked';" onkeydown="return bloccaCaratteriDaTastiera(event);"></b></td>
								</tr>
							</table>
						</form>			
					</td>
				</tr>
			</c:if>
			
			<c:if test="${!empty esito}">
				<gene:set name="titoloGenerico" value="${titolo}" />
				<gene:set name="listaGenericaControlli" value="${listaControlli}" />
				<gene:set name="numeroErrori" value="${numeroErrori}" />
				<gene:set name="numeroWarning" value="${numeroWarning}" />
				
				<c:choose>
		
				<c:when test="${!empty listaControlli}">
					<jsp:include page="../commons/popup-validazione-interno.jsp" />	
				</c:when>
				
				<c:otherwise>
					<tr>
						<td>
							<b>${titoloGenerico}</b>
							<br>&nbsp;<br>
							<b>Codice Unico Intervento associato correttamente.</b>
							<br>&nbsp;<br>
						</td>
					</tr>
				</c:otherwise>
				</c:choose>
			</c:if>
				
			<tr class="comandi-dettaglio">
				<td class="comandi-dettaglio" colspan="2">
					<c:if test="${empty esito}">
						<input type="button" value="Prosegui" title="Prosegui" class="bottone-azione" onclick="javascript:prosegui();"/>&nbsp;
					</c:if>
					<input type="button" value="Indietro" title="Indietro" class="bottone-azione" onclick="javascript:annulla();"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>

	</gene:redefineInsert>
	<gene:javaScript>
	
		function prosegui() {
			if (document.getElementById("create").checked) {
				generaXML();
			} else if (document.getElementById("report").checked) {
				importa();
			}
		}
		
		function annulla() {
			historyVaiIndietroDi(1);
		}
	
		function generaXML(){
			var comando = "href=w9/commons/popup-validazione-xmlrlo.jsp?key=${key}&crea=ok";
			openPopUpCustom(comando, "validazione", 500, 650, "yes", "yes");
		}
		
		function importa(){

			if(document.formImportfile.selezioneFile) {
			var nomeCompletoFile = "" + document.formImportfile.selezioneFile.value;
			if(nomeCompletoFile != ""){
				if(nomeCompletoFile.substr(nomeCompletoFile.lastIndexOf('.')+1).toUpperCase() == "XML") {
					bloccaRichiesteServer();
					setTimeout("document.formImportfile.submit()", 150);
				} else {
					alert("Il file selezionato non &egrave; nel formato valido. Deve avere estensione XML");
					document.formImportfile.selezioneFile.value = "";
				}
			}
			if (document.formImportfile.selezioneFile.value == "") {
				alert("Deve essere indicato il file da importare.");				
			}
			}

		}

	</gene:javaScript>
</gene:template>



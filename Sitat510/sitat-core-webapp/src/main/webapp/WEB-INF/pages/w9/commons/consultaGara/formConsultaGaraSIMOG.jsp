<%
/*
 * Created on 10-nov-2011
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */
%>
<%@ page language="java" import="it.eldasoft.utils.properties.ConfigManager" %>

<%@ taglib uri="http://www.eldasoft.it/genetags" prefix="gene"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://www.eldasoft.it/tags" prefix="elda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="existCredenziali" value='${gene:callFunction("it.eldasoft.w9.tags.funzioni.ExistCredenzialiUserSimogFunction",pageContext)}' />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form method="post" name="formConsultaGara" action="${pageContext.request.contextPath}/w9/ConsultaGara.do" >
	<table class="dettaglio-notab">

		<c:if test='${not empty requestScope.errorMsgDettaglio}' >
			<tr id="erroreConsultaGara" >
				<td colspan="2" class="valore-dato">
					<br>
					<a href="javascript:visualizzaErroriPerDebug();" alt="Dettaglio dell'errore per assistenza tecnica">Dettaglio dell'errore per assistenza tecnica</a><br>
					<div id="erroriPerDebug" style="display: none" >
						<br>
							<c:out value="${requestScope.errorMsgDettaglio}" escapeXml="false" />
						<br>
					</div>
					<br>
				</td>
			</tr>
			<c:remove var="sessionConsultaGaraLottiBean" scope="session" />
		</c:if>

	<c:choose>
		<c:when test='${not empty sessionScope.sessionConsultaGaraLottiBean}'>
		
			<tr>
				<td colspan="2" class="valore-dato">
					<br>
					<b>Importazione della gara con Numero Gara ANAC = ${sessionScope.sessionConsultaGaraLottiBean.idAvGara}</b>
					<br><br>
					<br><br>
					<div id="progressbar"></div>
					<br>
					<center>
						${(sessionScope.sessionConsultaGaraLottiBean.numeroLottiImportati + sessionScope.sessionConsultaGaraLottiBean.numeroLottiEsistenti + sessionScope.sessionConsultaGaraLottiBean.numeroLottiNonImportati)} / ${sessionScope.sessionConsultaGaraLottiBean.numeroTotaleLotti}
					</center>
					<br>
				</td>
			</tr>

			<html:hidden property="metodo" value="aggiornaSchedaGara" />

	    <tr>
	      <td class="comandi-dettaglio" colSpan="2">
	    <c:choose>
	      <c:when test='${not empty newMetodo}'> 
	      	<html:hidden property="metodo" value="${newMetodo}" />
	      </c:when>
	      <c:otherwise>
	      	<html:hidden property="metodo" value="verificaDati" />
	      </c:otherwise>
	    </c:choose>
	    	<c:if test='${empty requestScope.bloccaOperazione}' >
	      	<INPUT type="button" class="bottone-azione" value="Carica lotto" title="Carica lotto" onclick="javascript:confermaInvio();" >
	        &nbsp;
	      </c:if>
	      	<INPUT type="button" class="bottone-azione" value="Annulla" title="Annulla" onclick="javascript:annulla();" >
	        &nbsp;
	      </td>
	    </tr>

		</c:when>
		<c:otherwise>

	    <tr>
	      <td class="etichetta-dato">Numero Gara ANAC</td>
	      <td class="valore-dato">
	      	<input type="text" id="codiceGara" name="codiceGara" onchange="validaIDGara()" styleClass="testo" size="8" maxlength="7" value="${requestScope.valoreCodiceGara}"/>
				</td>
	    </tr>	
	    <tr>
	      <td class="etichetta-dato">Codice CIG</td>
	      <td class="valore-dato"> 
	      	<input type="text" id="codiceCIG" name="codiceCIG" onchange="validaCIG()" styleClass="testo" size="12" maxlength="10" value="${requestScope.valoreCodiceCIG}"/>
	      	Inserire * per indicare tutti i CIG
	      </td>
	    </tr>
	    <input type="hidden" name="existCredenziali" value="${existCredenziali}" />
		<c:if test="${existCredenziali eq 'no' and gene:checkProt(pageContext, 'FUNZ.VIS.ALT.W9.INVIISIMOG')}">
			
			<gene:callFunction obj="it.eldasoft.w9.tags.funzioni.GetSIMOGLAUserFunction" />
			<c:choose>
				<c:when test="${empty simoguser}">
					<tr>
						<td class="valore-dato" colspan="2">
							<br>
							Indicare le <b>credenziali</b> per l'accesso al servizio di LoaderAppalto SIMOG.
							<br>
							<br>
						</td>
					</tr>
					<tr>
						<td class="etichetta-dato">Utente/Password</td>
						<td class="valore-dato">
							<input type="text" name="simoguser" id="simoguser" size="15" value="${requestScope.valoreSimogUser}"/>
							<input type="password" name="simogpass" id="simogpass" size="15" value="${requestScope.valoreSimogPass}" onfocus="javascript:resetPassword();" onclick="javascript:resetPassword();"/>
						</td>
					</tr>
					<c:if test="${empty requestScope.valoreSimogUser}">
						<input type="hidden" id="recuperauser" name="recuperauser" value="0" />
						<input type="hidden" id="recuperapassword" name="recuperapassword" value="0" />
					</c:if>
					<c:if test="${not empty requestScope.valoreSimogUser}">
						<input type="hidden" id="recuperauser" name="recuperauser" value="${requestScope.valoreRecuperaUser}" />
						<input type="hidden" id="recuperapassword" name="recuperapassword" value="${requestScope.valoreRecuperaPassword}" />
					</c:if>
				</c:when>
				<c:otherwise>
					<tr>
						<td class="valore-dato" colspan="2">
							<br>
							Le <b>credenziali</b> per l'accesso al servizio sono state recuperate dalla precedente richiesta.
							<br>
							<br>
						</td>
					</tr>
					<tr>	
						<td class="etichetta-dato">Utente/Password</td>
						<td class="valore-dato">
							<c:if test="${empty requestScope.valoreSimogUser}">
								<input type="text" name="simoguser" id="simoguser" size="15" value="${simoguser}" onchange="javascript:resetRecuperaUser();"/>
								<input type="password" name="simogpass" id="simogpass" size="15" value="................"  onfocus="javascript:resetPassword();" onclick="javascript:resetPassword();" onchange="javascript:resetRecuperaPassword();"/>
							</c:if>
							<c:if test="${not empty requestScope.valoreSimogUser}">
								<input type="text" name="simoguser" id="simoguser" size="15" value="${requestScope.valoreSimogUser}" onchange="javascript:resetRecuperaUser();"/>
								<input type="password" name="simogpass" id="simogpass" size="15" value="${requestScope.valoreSimogPass}"  onfocus="javascript:resetPassword();" onclick="javascript:resetPassword();" onchange="javascript:resetRecuperaPassword();"/>
							</c:if>
						</td>
					</tr>
					<c:if test="${empty requestScope.valoreSimogUser}">
						<input type="hidden" id="recuperauser" name="recuperauser" value="1" />
						<input type="hidden" id="recuperapassword" name="recuperapassword" value="1" />
					</c:if>
					<c:if test="${not empty requestScope.valoreSimogUser}">
						<input type="hidden" id="recuperauser" name="recuperauser" value="${requestScope.valoreRecuperaUser}" />
						<input type="hidden" id="recuperapassword" name="recuperapassword" value="${requestScope.valoreRecuperaPassword}" />
					</c:if>	
				</c:otherwise>
			</c:choose>

			<tr>
				<td class="etichetta-dato">Memorizza le credenziali</td>
				<td class="valore-dato">
					<c:if test="${empty requestScope.valoreSimogUser}">
						<input type="checkbox" id="memorizza" name="memorizza" value="memorizza" checked="checked"/>
					</c:if>
					<c:if test="${not empty requestScope.valoreSimogUser and requestScope.valoreMemorizza eq 'memorizza'}">
						<input type="checkbox" id="memorizza" name="memorizza" value="memorizza" checked="checked"/>
					</c:if>
					<c:if test="${not empty requestScope.valoreSimogUser and requestScope.valoreMemorizza ne 'memorizza'}">
						<input type="checkbox" id="memorizza" name="memorizza" value="memorizza"/>
					</c:if>
										
				</td>
			</tr>	
		</c:if>
	    <tr>
	      <td class="comandi-dettaglio" colSpan="2">
	    <c:choose>
	      <c:when test='${not empty newMetodo}'> 
	      	<html:hidden property="metodo" value="${newMetodo}" />
	      </c:when>
	      <c:otherwise>
	      	<html:hidden property="metodo" value="verificaDati" />
	      </c:otherwise>
	    </c:choose>
	    	<c:if test='${empty requestScope.bloccaOperazione}' >
	      	<INPUT type="button" class="bottone-azione" value="Carica lotto" title="Carica lotto" onclick="javascript:confermaInvio();" >
	        &nbsp;
	      </c:if>
	      	<INPUT type="button" class="bottone-azione" value="Annulla" title="Annulla" onclick="javascript:annulla();" >
	        &nbsp;
	      </td>
	    </tr>

		</c:otherwise>
	</c:choose>

	</table>
</form>

<script type="text/javascript">
	function resetRecuperaUser() {
		document.getElementById('recuperauser').value = "0";
	}
	
	function resetRecuperaPassword() {
		document.getElementById('recuperapassword').value = "0";
	}
	
	function resetPassword() {
		document.getElementById('simogpass').value = "";
	}	
	
	function confermaInvio(){
		var invia = "true";
		<c:if test="${empty simoguser and existCredenziali eq 'no' and gene:checkProt(pageContext, 'FUNZ.VIS.ALT.W9.INVIISIMOG')}">
			var simoguser = document.getElementById('simoguser');
			if (simoguser.value == "") {
				alert("Inserire l'utente");
				invia = "false";
			}
				
			var simogpass = document.getElementById('simogpass');			
			if (invia == "true" && simogpass.value == "") {
				alert("Inserire la password");
				invia = "false";
			}
		</c:if>
		if (invia == "true") {
			gestisciSubmit();
		}
	}
	
<c:choose>
	<c:when test='${not empty sessionScope.sessionConsultaGaraLottiBean}'>

		$(document).ready(function () {
				bloccaRichiesteServer();
				setTimeout("document.formConsultaGara.submit();", 350);
		});
	
		$(function() {
		  $( "#progressbar" ).progressbar({
		    value: ${100 *(sessionScope.sessionConsultaGaraLottiBean.numeroLottiImportati + sessionScope.sessionConsultaGaraLottiBean.numeroLottiEsistenti + sessionScope.sessionConsultaGaraLottiBean.numeroLottiNonImportati) / sessionScope.sessionConsultaGaraLottiBean.numeroTotaleLotti} 
		  }); //.delay( 250 );
		});

	</c:when>
	<c:otherwise>

		$(document).ready(function () {
			var numeroLottiCaricati = "${valoreNumeroLottiCaricati}";
			var stringaMessaggio = "Il codice gara indicato e' gia'presente in archivio \r\n e contiene ${valoreNumeroLottiCaricati} CIG correttamente caricati. \r\n Proseguire con l'operazione?"
			if (numeroLottiCaricati != "" && numeroLottiCaricati > 0) {
				var r = confirm(stringaMessaggio);
				if (r != true) {
					document.location.href="${contextPath}/w9/ConsultaGara.do?metodo=inizializza";
				}
			}
		});
		
	</c:otherwise>
</c:choose>
</script>
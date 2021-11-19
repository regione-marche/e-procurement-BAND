<%
/*
 * Created on 15-12-2009
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */
 
 // PAGINA CHE CONTIENE L'ISTANZA DELLA SOTTOPARTE DELLA PAGINA DI EDIT DEL
 // DETTAGLIO DEI DATI GENERALI DI UN ACCOUNT CONTENENTE LA SEZIONE RELATIVA
 // ALLE SOTTOSEZIONI DELLA PAGINA STESSA.
 // QUESTA PAGINA E' STATA RIDEFINITA NEL PROGETTO SITAT109 PER UNA
 // PERSONALIZZAZIONE DELL'EDIT DEI DATI GENERALI DELL'ACCOUNT.
%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.eldasoft.it/genetags" prefix="gene"%>

<c:set var="listaOpzioniUtenteSys" value="${fn:join(accountForm.opzioniUtenteSys,'#')}#" />
<c:set var="account" value="${accountForm}"/>

<c:set var="moduloFabbisogniAttivo" value='${gene:callFunction("it.eldasoft.gene.tags.functions.GetPropertyFunction", "it.eldasoft.pt.moduloFabbisogniAttivo")}' />

	<tr>
		<td colspan="2">
			<b>Configurazione contratti</b>
		</td>
	</tr>
	<tr>
		<td class="etichetta-dato">Privilegi dell'utente sui contratti</td>
		<td class="valore-dato">
			<select name="abilitazioneLavori">
			<option value="" <c:if test="${empty account.abilitazioneLavori}">selected="selected"</c:if>>&nbsp;</option>
			<option value="A" <c:if test="${account.abilitazioneLavori eq 'A'}">selected="selected"</c:if>>Responsabile (Accesso completo su tutti i contratti)</option>
			<option value="C" <c:if test="${account.abilitazioneLavori eq 'C'}">selected="selected"</c:if>>Compilatore (Accesso su tutti i contratti senza facoltà di invio)</option>
			<option value="U" <c:if test="${account.abilitazioneLavori eq 'U'}">selected="selected"</c:if>>Utente (Accesso consentito solo ai propri contratti)</option>
			</select>
		</td>
	</tr>
	
	<c:if test="${moduloFabbisogniAttivo eq '1'}">
		<tr>
			<td colspan="2">
				<b>Configurazione di accesso alle richieste di acquisto/intervento</b>
			</td>
		</tr>
		<tr>
			<td class="etichetta-dato">Privilegi dell'utente</td>
			<td class="valore-dato">
				<select name="abilitazioneGare">
					<option value="" <c:if test="${empty account.abilitazioneGare}">selected="selected"</c:if>>&nbsp;</option>
					<option value="A" <c:if test="${account.abilitazioneGare eq 'A'}">selected="selected"</c:if>>Responsabile (accesso consentito a tutti i dati)</option>
					<option value="U" <c:if test="${account.abilitazioneGare eq 'U'}">selected="selected"</c:if>>Utente (accesso consentito solo ai dati assegnati)</option>
				</select>
			</td>
		</tr>
	</c:if>

<% 
// Valori di default dei campi SYSLIV, SYSLIG, SYSABG, SYSLIC e SYSABC
// della tabella USRSYS
%>

<c:if test='${not empty account.livelloLavori}'>
	<input type="hidden" name="livelloLavori" value="${account.livelloLavori}"/>
</c:if>
<c:if test='${not empty account.livelloGare}'>
	<input type="hidden" name="livelloGare" value="${account.livelloGare}"/>
</c:if>
<%-- <c:if test='${not empty account.abilitazioneGare}'> --%>
<%-- 	<input type="hidden" name="abilitazioneGare" value="${account.abilitazioneGare}"/> --%>
<%-- </c:if> --%>
<c:if test='${not empty account.livelloContratti}'>
	<input type="hidden" name="livelloContratti" value="${account.livelloContratti}"/>
</c:if>
<c:if test='${not empty account.abilitazioneContratti}'>
	<input type="hidden" name="abilitazioneContratti" value="${account.abilitazioneContratti}"/>
</c:if>

<script type="text/javascript">
<!--
// funzione richiamata per eseguire i controlli di obbligatorieta' sulla sezione.
// aggiungere eventuali controlli di obbligatorieta' del caso 
function eseguiControlliSezioneCustomSalva() {
	return true;
}


//document.getElementById("rowAbilitaFunzioniAvanzate").style.display = "none";
//if (document.getElementById("rowNascondiMenuStrumenti")) document.getElementById("rowNascondiMenuStrumenti").style.display = "none";

-->
</script>

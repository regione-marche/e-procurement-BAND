<%
/*
 * Created on 10-nov-2010
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.eldasoft.it/tags" prefix="elda" %>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/controlliFormali.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/forms.js"></script>

<script type="text/javascript">
<!--
	var regularexp = new RegExp('^[a-zA-Z0-9]+$');

	function validaIDGara() {
		var codiceGara = trimStringa(document.getElementById("codiceGara").value);
		if (codiceGara != "") {
			if (!regularexp.test(codiceGara)) {
				alert("Il codice gara non e' nel formato previsto. Indicare solo lettere e numeri");
				document.getElementById("codiceGara").focus();
			}
		}		
	}
	
	function validaCIG() {
		var codiceCIG = trimStringa(document.getElementById("codiceCIG").value);
		if (codiceCIG != "") {
			if (codiceCIG != "*" && !regularexp.test(codiceCIG)) {
				alert("Codice CIG non e' nel formato previsto.\nIndicare solo lettere e numeri oppure '*'");
				document.getElementById("codiceCIG").focus();
			}
		}
	}

	function gestisciSubmit() {
		var codiceCIG = trimStringa(document.getElementById("codiceCIG").value);
		var codiceGara = trimStringa(document.getElementById("codiceGara").value);
		
		if (codiceCIG == "" && codiceGara == "") {
			alert("Valorizzare almeno il codice CIG per continuare");
		} else if (codiceCIG == "*" && codiceGara == "") {
			alert("Valorizzare anche il codice gara per continuare");
		} else if (codiceGara != "" && codiceCIG == "") {
			alert("Valorizzare anche il Codice CIG per continuare");
		} else {
			document.getElementById("codiceCIG").value = codiceCIG.toUpperCase();
			document.getElementById("codiceGara").value = codiceGara.toUpperCase();
			bloccaRichiesteServer();
			document.formConsultaGara.submit();
		}
	}
  
  function annulla() {
	  document.location.href = '../Home.do';
  }

  function visualizzaErroriPerDebug(){
		var obj = document.getElementById("erroriPerDebug");
		if(isObjShow("erroriPerDebug"))
			showObj("erroriPerDebug", false);
		else
			showObj("erroriPerDebug", true);
	}
  
	function richiestaConferma() {
<c:choose>
	<c:when test='${requestScope.richiestaConfermaCreaNuovaGara eq 1}'>
		if(confirm("La gara specificata non esiste in archivio.\nSi desidera creare una nuova gara?")) {
			bloccaRichiesteServer();
			document.formConsultaGara.submit();	
		} else {
			document.getElementById("codiceCIG").value = "";
			document.getElementById("codiceGara").value = "";
			document.formConsultaGara.metodo.value = "verificaDati";
		}
	</c:when>
	<c:when test='${requestScope.richiestaConfermaCreaNuovaGara eq 2}'>
		bloccaRichiesteServer();
		document.formConsultaGara.submit();	
	</c:when>
</c:choose>
	}
	
-->
</script>
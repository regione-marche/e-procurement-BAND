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

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://www.eldasoft.it/tags" prefix="elda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="dettaglio-notab">
   <tr>
     <td colspan="2">
     	<br>
     	Importazione dati eseguita correttamente.
     	<br>
     	Proseguire con l'importazione degli altri eventuali lotti e poi con il completamento dei dati e l'invio dell'anagrafica gara/lotti all'osservatorio.
     	<br><br>
     </td>
   </tr>
   <tr>
     <td class="comandi-dettaglio" colSpan="2">
     	<INPUT type="button" class="bottone-azione" value="Nuovo caricamento lotto" title="Nuovo caricamento lotto" onclick="javascript:nuovoCaricamento();" >
       &nbsp;
     	<INPUT type="button" class="bottone-azione" value="Annulla" title="Annulla" onclick="javascript:annulla();" >
       &nbsp;
     </td>
   </tr>
</table>

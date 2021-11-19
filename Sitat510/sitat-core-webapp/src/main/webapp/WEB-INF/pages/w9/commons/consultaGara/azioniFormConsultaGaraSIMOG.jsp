<%/*
   * Created on 11-nov-2011
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
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://www.eldasoft.it/tags" prefix="elda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<tr>
		<td class="titolomenulaterale">Consulta gara: Azioni</td>
	</tr>
<c:if test='${empty requestScope.bloccaOperazione}' >
	<tr>
		<td class="vocemenulaterale"><a href="javascript:gestisciSubmit();"	tabindex="1500">Carica lotto</a></td>
	</tr>
</c:if>
	<tr>
		<td class="vocemenulaterale"><a href="javascript:annulla();" tabindex="1501">Annulla</a></td>
	</tr>

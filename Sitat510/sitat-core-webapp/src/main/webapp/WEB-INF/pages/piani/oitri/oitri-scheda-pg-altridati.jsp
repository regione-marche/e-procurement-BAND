<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.eldasoft.it/genetags" prefix="gene"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.eldasoft.it/tags" prefix="elda"%>


<gene:formScheda entita="OITRI" gestisciProtezioni="true"
	plugin="it.eldasoft.sil.pt.tags.gestori.plugin.GestoreOITRI"
	gestore="it.eldasoft.sil.pt.tags.gestori.submit.GestoreOITRI">

	<gene:campoScheda campo="CONTRI" value ="${contri}" visibile="false" />
	<gene:campoScheda campo="NUMOI" visibile="false" />	
	
	<gene:campoScheda>
		<td colspan="2"><b>Localizzazione</b></td>
	</gene:campoScheda>

	<gene:archivio titolo="Comuni" chiave="" where="" formName="" inseribile="false" 
		lista="gene/commons/istat-comuni-lista-popup.jsp" scheda=""
		schedaPopUp="" 
		campi="TABSCHE.TABCOD3;TB1.TABCOD3;TABSCHE.TABDESC">
		<gene:campoScheda entita="OITRI" campo="ISTAT" definizione="T9" title="Codice ISTAT"  />
		<gene:campoScheda campo="PROVINCIA" campoFittizio="true" definizione="T2;0;Agx15;;S3COPROVIN" title="Provincia" value="${descrProvincia}" />
		<gene:campoScheda campo="COMUNE" campoFittizio="true" definizione="T120" title="Comune" value="${descrComune}" />
	</gene:archivio>

	<gene:campoScheda campo="NUTS" visibile="true" >
		<gene:popupCampo titolo="Dettaglio codice NUTS" href="formNUTS('${modo}','OITRI_NUTS')" />
	</gene:campoScheda>
	
	<gene:campoScheda>
		<td colspan="2"><b>Dati dell'intervento</b></td>
	</gene:campoScheda>
	<gene:campoScheda campo="SEZINT" visibile="true" />
	<gene:campoScheda campo="INTERV" visibile="true" />

	<gene:campoScheda>
		<td colspan="2"><b>Descrizione dell'opera</b></td>
	</gene:campoScheda>
	<gene:campoScheda campo="REQ_CAP" visibile="true" />
	<gene:campoScheda campo="REQ_PRGE" visibile="true" />
	<gene:campoScheda campo="DIM_UM" visibile="true" />
	<gene:campoScheda campo="DIM_QTA" visibile="true" />

	<gene:campoScheda>
		<td colspan="2"><b>Fonti di finanziamento</b></td>
	</gene:campoScheda>
	<gene:campoScheda campo="SPONSORIZZAZIONE" visibile="true" />
	<gene:campoScheda campo="FINANZA_PROGETTO" visibile="true" />
	<gene:campoScheda campo="COSTO" visibile="true" />
	<gene:campoScheda campo="FINANZIAMENTO" visibile="true" />
	
	<gene:campoScheda>
		<td colspan="2"><b>Tipologia copertura finanziaria</b></td>
	</gene:campoScheda>
	<gene:campoScheda campo="COP_STATALE" visibile="true" />
	<gene:campoScheda campo="COP_REGIONALE" visibile="true" />
	<gene:campoScheda campo="COP_PROVINCIALE" visibile="true" />
	<gene:campoScheda campo="COP_COMUNALE" visibile="true" />
	<gene:campoScheda campo="COP_ALTRAPUBBLICA" visibile="true" />
	<gene:campoScheda campo="COP_COMUNITARIA" visibile="true" />
	<gene:campoScheda campo="COP_PRIVATA" visibile="true" />

	<c:if test='${modificabile eq "no"}' >
		<gene:redefineInsert name="schedaNuovo" />
		<gene:redefineInsert name="schedaModifica" />
		<gene:redefineInsert name="pulsanteNuovo" />
		<gene:redefineInsert name="pulsanteModifica" />
	</c:if>
	<gene:campoScheda>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
	</gene:campoScheda>

	<gene:javaScript>
	function formNUTS(modifica, campo) {
			openPopUpCustom("href=gene/tabnuts/dettaglio-codice-nuts.jsp&key=" + document.forms[0].key.value + 
				"&keyParent=" + document.forms[0].keyParent.value + "&modo=" + (modifica ? "MODIFICA":"VISUALIZZA") + 
				"&campo="+campo+"&valore="+ getValue(campo), "formNUTS", 700, 300, 1, 1);
		}
	</gene:javaScript>
</gene:formScheda>
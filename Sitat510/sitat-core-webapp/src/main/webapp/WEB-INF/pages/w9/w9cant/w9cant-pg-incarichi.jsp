<%
/*
 * Created on: 18/12/2012
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<gene:formScheda entita="W9CANT" gestisciProtezioni="true" plugin="it.eldasoft.w9.tags.gestori.plugin.GestoreW9CANT" gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9CANT"
	where='W9CANT.CODGARA=#W9CANT.CODGARA# AND W9CANT.CODLOTT=#W9CANT.CODLOTT# AND W9CANT.NUM_CANT=#W9CANT.NUM_CANT#' >
	
	<gene:redefineInsert name="schedaNuovo" />
	<gene:redefineInsert name="pulsanteNuovo" />
	<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}' />
	<c:set var="codlott" value='${gene:getValCampo(key,"CODLOTT")}' />
	<c:set var="num" value='${gene:getValCampo(key,"NUM_CANT")}' />
	
	<c:if test='${permessoUser lt 4}' >
		<gene:redefineInsert name="schedaModifica" />
		<gene:redefineInsert name="pulsanteModifica" />
	</c:if>
	
	<gene:campoScheda campo="CODLOTT" visibile="false" />
	<gene:campoScheda campo="CODGARA" visibile="false" />
	<gene:campoScheda campo="NUM_CANT" visibile="false" />
					
	<gene:campoScheda entita="W9INCA" campo="CODGARA" where="W9INCA.CODGARA = ${codgara} and W9INCA.CODLOTT = ${codlott} and W9INCA.NUM = ${num}" visibile="false" />
	<gene:campoScheda entita="W9INCA" campo="CODLOTT" where="W9INCA.CODGARA = ${codgara} and W9INCA.CODLOTT = ${codlott} and W9INCA.NUM = ${num}" visibile="false" />
	<gene:campoScheda entita="W9INCA" campo="NUM" where="W9INCA.CODGARA = ${codgara} and W9INCA.CODLOTT = ${codlott} and W9INCA.NUM = ${num}" visibile="false" />
	
	<!-- campi per  W9FASI-->
		<gene:campoScheda campo="CODGARA" entita="W9FASI" visibile="false" value="${codgara}"
			where="W9FASI.CODGARA = W9CANT.CODGARA AND W9FASI.CODLOTT = W9CANT.CODLOTT" />
		<gene:campoScheda campo="CODLOTT" entita="W9FASI" visibile="false" value="${codlott}"
			where="W9FASI.CODGARA = W9CANT.CODGARA AND W9FASI.CODLOTT = W9CANT.CODLOTT" />
		<gene:campoScheda campo="FASE_ESECUZIONE" entita="W9FASI" visibile="false" value="${flusso}"/>
		<gene:campoScheda campo="NUM" entita="W9FASI" visibile="false" />	
		
	<!-- scheda multipla -->
	<c:set var="keyW9inca" value="${key};W9INCA.SEZIONE=T:NP" scope="request"/>
	<c:if test='${modo ne "NUOVO"}' >
		<gene:callFunction obj="it.eldasoft.w9.tags.funzioni.GetIncarichiProfessionaliFunction" parametro="${key};SEZIONE=T:NP" />
	</c:if>

	<jsp:include page="/WEB-INF/pages/commons/interno-scheda-multipla.jsp" >
		<jsp:param name="entita" value='W9INCA'/>
		<jsp:param name="chiave" value='${gene:getValCampo(key, "CODGARA")};${gene:getValCampo(key, "CODLOTT")};${gene:getValCampo(key, "NUM_CANT")}'/>
		<jsp:param name="nomeAttributoLista" value='listaIncarichiProfessionali' />
		<jsp:param name="idProtezioni" value="W9INCA" />
		<jsp:param name="jspDettaglioSingolo" value="/WEB-INF/pages/w9/incarichi_professionali/incarichi_professionali.jsp" />
		<jsp:param name="arrayCampi" value="'W9INCA_CODGARA_','W9INCA_CODLOTT_','W9INCA_NUM_','W9INCA_SEZIONE_','W9INCA_NUM_INCA_','W9INCA_CODTEC_','TECNI_NOMTEC_','W9INCA_ID_RUOLO_','W9INCA_CIG_PROG_ESTERNA_','W9INCA_DATA_AFF_PROG_ESTERNA_','W9INCA_DATA_CONS_PROG_ESTERNA_'" />
		<jsp:param name="arrayVisibilitaCampi" value="false,false,false,false,false,false,true,true,false,false,false" />
		<jsp:param name="usaContatoreLista" value="true"/>
		<jsp:param name="sezioneListaVuota" value="true"/>
		<jsp:param name="titoloSezione" value="Incarichi professionali" />
		<jsp:param name="titoloNuovaSezione" value="Nuovo Incarico professionale" />
		<jsp:param name="descEntitaVociLink" value="incarichi professionali" />
		<jsp:param name="msgRaggiuntoMax" value="e incarichi professionali" />
	</jsp:include>	
	
	<gene:campoScheda>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
	</gene:campoScheda>
</gene:formScheda>
<gene:javaScript>
</gene:javaScript>
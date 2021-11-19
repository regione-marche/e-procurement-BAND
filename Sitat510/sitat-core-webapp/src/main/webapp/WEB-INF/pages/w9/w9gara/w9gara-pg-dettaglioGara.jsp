
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

<%
	/* Dati generali del lavoro */
%>

<c:set var="codgara" value='${gene:getValCampo(key,"CODGARA")}' />
<c:if test="${modoAperturaScheda ne 'NUOVO'}">
	<c:set var="listaExistsFasiInteraGara" value='${gene:callFunction2("it.eldasoft.w9.tags.funzioni.ListaExistsFasiInteraGaraFunction", pageContext, codgara)}' />
</c:if>

<gene:formScheda entita="W9GARA" gestisciProtezioni="true" plugin="it.eldasoft.w9.tags.gestori.plugin.GestoreW9GARA"
	gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9GARA">

	<gene:redefineInsert name="addToAzioni" >
		<jsp:include page="azioniComuni-schedaGara.jsp" />
		<c:if test='${(requestScope.isSAconPermessi or sessionScope.utenteProfilo.abilitazioneStd eq "A") and modo eq "VISUALIZZA"}'>
			<tr>
				<td class="vocemenulaterale">
					<c:if test='${isNavigazioneDisattiva ne "1"}'>
						<a href="javascript:permessiAccesso();" title="Permessi accesso" tabindex="1504">
					</c:if>
						Permessi accesso
					<c:if test='${isNavigazioneDisattiva ne "1"}'></a></c:if>
				</td>
			</tr>
		</c:if>
	</gene:redefineInsert>
	
	<gene:gruppoCampi idProtezioni="GEN">
		<gene:campoScheda>
			<td colspan="2"><b>Dati generali della Gara </b></td>
		</gene:campoScheda>
		<gene:campoScheda campo="CODGARA" visibile="false" />
		<gene:campoScheda campo="OGGETTO" obbligatorio="true" />
		<gene:campoScheda campo="SITUAZIONE" modificabile="false" />
		<gene:campoScheda campo="VER_SIMOG" visibile="false" />
		<gene:campoScheda campo="PROV_DATO" defaultValue="1" modificabile="false" />
		<gene:campoScheda campo="IDAVGARA" modificabile="true" />
		<gene:campoScheda campo="FLAG_ENTE_SPECIALE" />
		<gene:campoScheda campo="ID_MODO_INDIZIONE" />

<c:choose>
	<c:when test='${modo ne "NUOVO"}'>
		<gene:campoScheda campo="TIPO_APP" gestore="it.eldasoft.w9.tags.gestori.decoratori.GestoreCampoW9GaraTipoApp" >
			<gene:checkCampoScheda 
			funzione='controllaTIPO_APP(${fase_1},${fase_987},${fase_12},${fase_2},${fase_986},${fase_11})' 
			messaggio='La modalit&agrave; di realizzazione specificata non &egrave; compatibile con le fasi gi&agrave; create' 
			obbligatorio="true" />	
		</gene:campoScheda>
	</c:when>
	<c:otherwise>
		<gene:campoScheda campo="TIPO_APP" gestore="it.eldasoft.w9.tags.gestori.decoratori.GestoreCampoW9GaraTipoApp" />
	</c:otherwise>
</c:choose>
		
		<gene:campoScheda campo="CIG_ACCQUADRO" />
		<gene:campoScheda campo="SOMMA_URGENZA" />
		<gene:campoScheda campo="IMPDIS" visibile="false" />
		<gene:campoScheda campo="IMPORTO_GARA" />
		<gene:campoScheda campo="NLOTTI" modificabile="false" />
		<gene:campoScheda campo="DATA_PUBBLICAZIONE" />
		<gene:archivio titolo="TECNICI"
			lista='${gene:if(gene:checkProt(pageContext, "COLS.MOD.W9.W9GARA.RESPRO"),"gene/tecni/tecni-lista-popup.jsp","")}'
			scheda='${gene:if(gene:checkProtObj( pageContext, "MASC.VIS","GENE.SchedaTecni"),"gene/tecni/tecni-scheda.jsp","")}'
			schedaPopUp='${gene:if(gene:checkProtObj( pageContext, "MASC.VIS","GENE.SchedaTecni"),"gene/tecni/tecni-scheda-popup.jsp","")}'
			campi="TECNI.CODTEC;TECNI.NOMTEC" chiave="W9GARA_RUP" >
			<gene:campoScheda campo="RUP" defaultValue="${idTecnico}"
				visibile="false" />
			<gene:campoScheda campo="NOMTEC" entita="TECNI"
				defaultValue="${nomeTecnico}" where="TECNI.CODTEC=W9GARA.RUP"
				modificabile="${sessionScope.profiloUtente.abilitazioneStd eq 'A' || gene:checkProt(pageContext, 'FUNZ.VIS.ALT.W9.W9SCP')}"
				title="RUP" visibile="true">
			</gene:campoScheda>
		</gene:archivio>
		<gene:campoScheda campo="RIC_ALLUV" defaultValue="2" />
		<gene:campoScheda campo="CAM" />
		<gene:campoScheda campo="SISMA" />
		<gene:campoScheda>
			<td colspan="2"><b>Stazione appaltante</b></td>
		</gene:campoScheda>
		<gene:archivio titolo="STAZIONE APPALTANTE" lista=""
			scheda='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","GENE.SchedaUffint"),"gene/uffint/uffint-scheda.jsp","")}'
			schedaPopUp='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","GENE.SchedaUffint"),"gene/uffint/uffint-scheda-popup.jsp","")}'
			campi="UFFINT.CODEIN;UFFINT.NOMEIN" chiave="W9GARA_CODEIN" where=""
			formName="formStazApp">
			<gene:campoScheda campo="CODEIN" visibile="false"
				defaultValue="${sessionScope.uffint}" />
			<gene:campoScheda campo="NOMEIN" entita="UFFINT"
				defaultValue="${nomein}" where="UFFINT.CODEIN = W9GARA.CODEIN"
				modificabile="false" title="Stazione appaltante" />
		</gene:archivio>
		<c:if test='${gene:checkProt(pageContext, "COLS.VIS.W9.W9GARA.IDCC")}'>
		<gene:archivio titolo="Centri di Costo"
			lista='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","W9.ListaCentri"),"w9/centricosto/centricosto-lista-popup.jsp","")}'
			scheda='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","W9.SchedaCentri"),"w9/centricosto/centricosto-scheda.jsp","")}'
			schedaPopUp='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","W9.SchedaCentri"),"w9/centricosto/centricosto-scheda-popup.jsp","")}'
			where="CENTRICOSTO.CODEIN = '${sessionScope.uffint}'"
			campi="CENTRICOSTO.IDCENTRO;CENTRICOSTO.CODCENTRO;CENTRICOSTO.DENOMCENTRO"
			chiave="W9GARA_IDCC">
			<gene:campoScheda campo="IDCC" visibile="false" />
			<gene:campoScheda campo="CODCENTRO" entita="CENTRICOSTO"
				where="CENTRICOSTO.IDCENTRO=W9GARA.IDCC" modificabile='${gene:checkProt(pageContext, "COLS.MOD.W9.W9GARA.IDCC")}'
				title="Codice del Centro di Costo" definizione="T40" />
			<gene:campoScheda campo="DENOMCENTRO_1" entita="CENTRICOSTO" value="${denomcentro}"
				modificabile='${gene:checkProt(pageContext, "COLS.MOD.W9.W9GARA.IDCC")}'
				title="Denominazione del Centro di Costo" campoFittizio="true" definizione="T250;0;;;DENOMCENTRO" />
		</gene:archivio>
		</c:if>
		<gene:archivio titolo="Ufficio/area di pertinenza"
			lista='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","W9.ListaUffici"),"w9/uffici/uffici-lista-popup.jsp","")}'
			scheda='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","W9.SchedaUffici"),"w9/uffici/uffici-scheda.jsp","")}'
			schedaPopUp='${gene:if(gene:checkProtObj( pageContext,"MASC.VIS","W9.SchedaUffici"),"w9/uffici/uffici-scheda-popup.jsp","")}'
			where="UFFICI.CODEIN = '${sessionScope.uffint}'"
			campi="UFFICI.ID;UFFICI.DENOM"
			chiave="W9GARA_IDUFFICIO">
			<gene:campoScheda campo="IDUFFICIO" visibile="false" />
			<gene:campoScheda campo="DENOM" entita="UFFICI"
				where="UFFICI.ID=W9GARA.IDUFFICIO" modificabile='${gene:checkProt(pageContext, "COLS.MOD.W9.W9GARA.IDUFFICIO")}'
				title="Ufficio/area di pertinenza" definizione="T250" />
		</gene:archivio>
		
		<gene:campoScheda campo="INDSEDE" defaultValue="${indirizzoSede}" />
		<gene:campoScheda campo="COMSEDE" defaultValue="${comuneSede}" />
		<gene:campoScheda campo="PROSEDE" defaultValue="${provinciaSede}" />
		
		<gene:campoScheda campo="DURATA_ACCQUADRO" />
		
		<gene:campoScheda campo="FLAG_SA_AGENTE" defaultValue="2"/>
		<gene:campoScheda campo="ID_TIPOLOGIA_SA" />
		<gene:campoScheda campo="DENOM_SA_AGENTE" />
		<gene:campoScheda campo="CF_SA_AGENTE" />
		<gene:campoScheda campo="TIPOLOGIA_PROCEDURA" />
		<gene:campoScheda campo="FLAG_CENTRALE_STIPULA" />
		<input type="hidden" name="keys" id="keys" value="" /> 
	</gene:gruppoCampi>

	<gene:fnJavaScriptScheda
		funzione='bloccaCampoNomein("#W9GARA_FLAG_SA_AGENTE#")'
		elencocampi="W9GARA_FLAG_SA_AGENTE" esegui="true" />
	<gene:fnJavaScriptScheda
		funzione="gestioneTIPO_APP('#W9GARA_TIPO_APP#')" elencocampi="W9GARA_TIPO_APP" esegui="true" />	
	<gene:fnJavaScriptScheda
		funzione="gestioneFLAG_ENTE_SPECIALE('#W9GARA_FLAG_ENTE_SPECIALE#')" elencocampi="W9GARA_FLAG_ENTE_SPECIALE" esegui="true" />
	
	<jsp:include
		page="/WEB-INF/pages/gene/attributi/sezione-attributi-generici.jsp">
		<jsp:param name="entitaParent" value="W9GARA" />
	</jsp:include>

	<gene:campoScheda>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiScheda.jsp" />
	</gene:campoScheda>
</gene:formScheda>
<gene:javaScript>
	
	function bloccaCampoNomein(valore) {
		var vis = (valore==1);

		showObj("rowW9GARA_ID_TIPOLOGIA_SA", vis);
		showObj("rowW9GARA_DENOM_SA_AGENTE", vis);
		showObj("rowW9GARA_CF_SA_AGENTE", vis);
		showObj("rowW9GARA_TIPOLOGIA_PROCEDURA", vis);
		showObj("rowW9GARA_FLAG_CENTRALE_STIPULA", vis);
		
		if (!vis)	{
			setValue("W9GARA_ID_TIPOLOGIA_SA", "");
			setValue("W9GARA_DENOM_SA_AGENTE", "");
			setValue("W9GARA_CF_SA_AGENTE", "");
			setValue("W9GARA_TIPOLOGIA_PROCEDURA", "");
			setValue("W9GARA_FLAG_CENTRALE_STIPULA", "");
		}
	}
	
	function gestioneTIPO_APP(value) {
		var visible = (value==2 || value==11);
	
		document.getElementById("rowW9GARA_CIG_ACCQUADRO").style.display = (visible ? '':'none');
		if (!visible) {
			document.forms[0].W9GARA_CIG_ACCQUADRO.value='';
		}
		
		visibile = (value==9 || value==17 || value==18);
		showObj("rowW9GARA_DURATA_ACCQUADRO", visibile);
		if (!visibile) {
			setValue("W9GARA_DURATA_ACCQUADRO", "");
		}
	}
	
	function gestioneFLAG_ENTE_SPECIALE(value) {
		var visibile = (value == 'S');
		showObj("rowW9GARA_ID_MODO_INDIZIONE", visibile);
	}
	
	function popupValidazione(flusso,key1,key2,key3) {
	   var comando = "href=w9/commons/popup-validazione-generale.jsp";
	   comando = comando + "&flusso=" + flusso;
	   comando = comando + "&key1=" + key1;
	   comando = comando + "&key2=" + key2;
	   comando = comando + "&key3=" + key3;
	   openPopUpCustom(comando, "validazione", 500, 650, "yes", "yes");
	}
	
<c:if test='${modo ne "NUOVO"}'>
	function controllaTIPO_APP(fase_1, fase_987, fase_12, fase_2, fase_986, fase_11) {
		var tipo_app = getValue("W9GARA_TIPO_APP");
		if (tipo_app == 11 && (fase_1 || fase_987)) {
			return false;
		}
		if (tipo_app != 11 && fase_12) {
			return false;
		}
		if (tipo_app == 9 && (fase_2 || fase_986)) {
			return false;
		}
		if (tipo_app != 9 && fase_11) {
			return false;
		}
		return true;
	}

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	function permessiAccesso() {
		document.location.href="${pageContext.request.contextPath}/ApriPagina.do?href=w9/w9permessi/w9permessi-scheda.jsp&codgara="+getValue("W9GARA_CODGARA");
	}
</c:if>

</gene:javaScript>
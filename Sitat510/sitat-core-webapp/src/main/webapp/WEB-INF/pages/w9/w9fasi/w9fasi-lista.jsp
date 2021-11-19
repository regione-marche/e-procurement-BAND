<%
  /*
   * Created on 03/08/2009
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

<c:set var="visualizzaLink" value='${gene:checkProt(pageContext, "MASC.VIS.W9.W9FASI-scheda")}' />
<c:set var="key" value='${key}' scope="request" />
<c:set var="eliminabili" value="false" />
<c:set var="prot" value='${gene:checkProtFunz(pageContext, "INS", "INS")}'/>
<c:set var="createXMLRLO" value='${gene:checkProt(pageContext,"FUNZ.VIS.ALT.W9.XML-RLO")}'/>

<c:set var="attivaNuovo" value='${gene:callFunction2("it.eldasoft.w9.tags.funzioni.VerificaPermessiFasiFlussiFunction",pageContext,key)}' />
<gene:callFunction obj="it.eldasoft.w9.tags.funzioni.InitListaFlussiLottoFunction" parametro="${key}" />

<c:set var="dbms" value="${gene:callFunction('it.eldasoft.gene.tags.utils.functions.GetTipoDBFunction', pageContext)}" />

<c:choose>
	<c:when test='${"ORA" eq dbms}' >
		<c:set var="joinTab1" value="TAB1.TAB1TIP=W9FASI.FASE_ESECUZIONE AND TAB1.TAB1COD='W3020'" />
	</c:when>
	<c:otherwise>
		<c:set var="joinTab1" value="TAB1.TAB1TIP = W9FASI.FASE_ESECUZIONE AND TAB1.TAB1COD = 'W3020'" />
	</c:otherwise>
</c:choose>

<table class="dettaglio-tab-lista">
<c:choose>
	<c:when test="${attivaNuovo eq false}">
		<tr>
			<td align="center">
				<br>
				Nessuna comunicazione prevista per questa tipologia di lotto
				<br><br>
			</td>
		</tr>
		<tr>
			<td class="comandi-dettaglio" colSpan="2">&nbsp;</td>
		</tr>
	</c:when>
	<c:otherwise>

		<gene:set name="titoloMenu">
			<jsp:include page="/WEB-INF/pages/commons/iconeCheckUncheck.jsp" />
		</gene:set>
		<tr>
			<td>
				<gene:formLista entita="W9FASI" where="W9FASI.CODGARA = #W9LOTT.CODGARA# and W9FASI.CODLOTT=#W9LOTT.CODLOTT#" 
					pagesize="20" tableclass="datilista" sortColumn="3;4" gestisciProtezioni="true"
					gestore="it.eldasoft.w9.tags.gestori.submit.GestoreW9FASI" >
					
					<c:set var="key01" value='${gene:getValCampo(key,"CODGARA") }' />
					<c:set var="key02" value='${gene:getValCampo(key,"CODLOTT") }' />
					<c:set var="link" value='${gene:callFunction2("it.eldasoft.w9.tags.funzioni.GetRedirectFunction",pageContext,chiaveRigaJava)}' />
					
					<c:set var="chiaveFlussiInserimento"
					value='W9FLUSSI.KEY03=N:${gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE")};W9FLUSSI.KEY04=N:${gene:getValCampo(chiaveRigaJava,"NUM")}'> </c:set>
					<c:set var="tipoInvio" value="1" />
					<c:if test='${datiRiga.W9FLUSSI_IDFLUSSO ne "" && datiRiga.W9FLUSSI_TINVIO2 gt 0 && datiRiga.W9FASI_DAEXPORT eq "2" and (datiRiga.W9XML_NUM_ERRORE eq "" or datiRiga.W9XML_NUM_ERRORE eq 0)}'>
						<c:set var="tipoInvio" value="2" />
					</c:if>
					<c:if test='${datiRiga.W9FLUSSI_IDFLUSSO ne "" && datiRiga.W9FASI_DAEXPORT eq "1" and (datiRiga.W9XML_NUM_ERRORE eq "" or datiRiga.W9XML_NUM_ERRORE eq 0)}'>
						<c:set var="tipoInvio" value="3" />
					</c:if>
					
					<gene:campoLista title="Opzioni<center>${titoloMenu}</center>" width="50">
						<c:set var="ctrlProp" value='${gene:callFunction2("it.eldasoft.w9.tags.funzioni.VerificaFlussiPropedeuticiFunction", pageContext, chiaveRigaJava) }' />
						<c:if test='${! gene:checkProt(pageContext, "FUNZ.VIS.ALT.W9.INVIISIMOG")}'>
							<c:set var="ctrlProp" value="${ctrlProp and not (empty requestScope.numeroFasiDelLotto or empty requestScope.numeroFlussiAnagraficaGara)}" />
						</c:if>
							
					<c:if test="${currentRow >= 0}">
						<gene:PopUp variableJs="rigaPopUpMenu${currentRow}" onClick="chiaveRiga='${chiaveRigaJava}'">
							<c:if test='${gene:checkProt(pageContext, "MASC.VIS.W9.W9FASI-scheda")}'>
								<gene:PopUpItemResource
										resource="popupmenu.tags.lista.visualizza"
										title="Visualizza fase/evento"
										href="javascript:creaLink('${link}','${chiaveRigaJava}', '');" />
							</c:if>
							<c:set var="cancellaFaseSimog" value='${gene:callFunction2("it.eldasoft.w9.tags.funzioni.IsFaseSimogEliminabileFunction",pageContext, chiaveRiga)}' />
							<c:set var="cancellaFase" value='${gene:callFunction3("it.eldasoft.w9.tags.funzioni.IsEliminabileFunction",pageContext, chiaveRiga,"W9FASI")}' />
							<c:set var="permessoFase" value='${gene:callFunction3("it.eldasoft.w9.tags.funzioni.GetPermessoUserFunction",pageContext,chiaveRiga,"W9FASI")}' />
							<c:set var="utenteAbilitato" value="no" />
							
							<c:if test='${sessionScope.profiloUtente.abilitazioneStd eq "A"}'>
								<c:set var="utenteAbilitato" value="si" />
							</c:if>

							<c:if test='${userIsRup ne "si" && sessionScope.profiloUtente.abilitazioneStd ne "C" && (permessoFase eq 3 or permessoFase eq 5) }'>
								<c:set var="utenteAbilitato" value="si" />
							</c:if>

							<c:if test='${userIsRup eq "si" && (permessoFase eq 3 or permessoFase eq 5) }'>
								<c:set var="utenteAbilitato" value="si" />
							</c:if>
              				
							<c:if test='${gene:checkProtFunz(pageContext, "MOD", "MOD") && permessoFase ge 4}'>
								<gene:PopUpItemResource
										resource="popupmenu.tags.lista.modifica"
										title="Modifica fase/evento"
										href="javascript:creaLink('${link}','${chiaveRigaJava}', '&modo=MODIFICA')" />
							</c:if>
							<c:if test='${gene:checkProtFunz(pageContext, "DEL","DEL") && empty situazioneCollaudo && (cancellaFase eq "si" and (empty datiRiga.W9FLUSSI_TINVIO2 || datiRiga.W9FLUSSI_TINVIO2 gt 0 || datiRiga.W9FLUSSI_TINVIO2 eq -2)) && permessoFase ge 4}'>
								<gene:PopUpItemResource resource="popupmenu.tags.lista.elimina" title="Elimina fase/evento" />
								<input type="checkbox" name="keys" value="${chiaveRigaJava}" />
								<c:set var="eliminabili" value="true" />
							</c:if>
							<c:if test='${gene:checkProtFunz(pageContext, "DEL","DEL") && (tipoInvio eq "2" || tipoInvio eq "3") && utenteAbilitato eq "si"}'>
								<c:if test='${cancellaFaseSimog eq "si"}'>
									<gene:PopUpItemResource resource=""
										title="Elimina fase/evento" href="javascript:paginaEliminaFase('${chiaveFlussiInserimento}', '${tipoInvio}')"/>
								</c:if>
							</c:if>
						</gene:PopUp>
					</c:if>
	
					</gene:campoLista>
				<%
				  // Campi veri e propri
				%>
				<gene:campoLista campo="FASE_ESECUZIONE" headerClass="sortable" width="440"
					href="javascript:creaLink('${link}','${chiaveRigaJava}', '');" />				

				<gene:campoLista campo="TAB1NORD" entita="TAB1" where="${joinTab1}" visibile="false" />

				<gene:campoLista campo="NUM" headerClass="sortable" width="100" />
				<gene:campoLista campo="IDFLUSSO" visibile="false" entita="W9FLUSSI"    
						where="W9FLUSSI.KEY01=W9FASI.CODGARA AND W9FLUSSI.KEY02=W9FASI.CODLOTT AND W9FLUSSI.KEY03=W9FASI.FASE_ESECUZIONE AND W9FLUSSI.KEY04=W9FASI.NUM and W9FLUSSI.TINVIO2 > 0 and
								Not exists (Select 1 from W9XML where W9XML.CODGARA=W9FASI.CODGARA AND W9XML.CODLOTT=W9FASI.CODLOTT AND W9XML.IDFLUSSO=W9FLUSSI.IDFLUSSO and W9XML.NUM_ERRORE>0)"
						headerClass="sortable" width="80" />
				<gene:campoLista campo="TINVIO2" visibile="false" entita="W9FLUSSI"    
						where="W9FLUSSI.KEY01=W9FASI.CODGARA AND W9FLUSSI.KEY02=W9FASI.CODLOTT AND W9FLUSSI.KEY03=W9FASI.FASE_ESECUZIONE AND W9FLUSSI.KEY04=W9FASI.NUM and W9FLUSSI.TINVIO2 > 0 and
								Not exists (Select 1 from W9XML where W9XML.CODGARA=W9FASI.CODGARA AND W9XML.CODLOTT=W9FASI.CODLOTT AND W9XML.IDFLUSSO=W9FLUSSI.IDFLUSSO and W9XML.NUM_ERRORE>0)"
						headerClass="sortable" width="80" />
				<gene:campoLista campo="DAEXPORT" visibile="false" entita="W9FASI" />
				
				<gene:campoLista campo="NUM_ERRORE" visibile="false" entita="W9XML" from="W9FLUSSI"
						where="W9FLUSSI.KEY01=W9FASI.CODGARA AND W9FLUSSI.KEY02=W9FASI.CODLOTT AND W9FLUSSI.KEY03=W9FASI.FASE_ESECUZIONE AND W9FLUSSI.KEY04=W9FASI.NUM and W9FLUSSI.TINVIO2 > 0 and
								Not exists (Select 1 from W9XML where W9XML.CODGARA=W9FASI.CODGARA AND W9XML.CODLOTT=W9FASI.CODLOTT AND W9XML.IDFLUSSO=W9FLUSSI.IDFLUSSO and W9XML.NUM_ERRORE>0)"
						headerClass="sortable" width="80" />
				
			<c:if test="${prot && gene:checkProt(pageContext, 'FUNZ.VIS.ALT.W9.W9FASI-lista.NuovoInvio')}">
				<gene:campoLista title="Azione" width="60"><center>
							
					<c:choose>
						<c:when test='${utenteAbilitato eq "no"}'>
							<img src="${pageContext.request.contextPath}/img/no_flag.gif" title="Utente senza permesso di effettuare l'invio" />
						</c:when>
						<c:when test='${empty situazioneCollaudo && ctrlProp eq "false" && tipoInvio ne "2"}'>  <!-- busta grigia -->
							<img src="${pageContext.request.contextPath}/img/invioFlussoBN.png"	title="Invio non possibile" />
						</c:when>
						<c:when test='${(empty situazioneCollaudo) && tipoInvio eq "1" && utenteAbilitato eq "si" && !lottoInRichiesteDiCancellazione}'> <!-- busta blu -->
							<a href="javascript:paginaSelezioneNuovoFlusso('${chiaveFlussiInserimento}', '${tipoInvio}')"
								title="Invio da effettuare"> <img src="${pageContext.request.contextPath}/img/invioFlussoInAttesa.png" /> </a>
						</c:when>
						<c:when test='${!(empty situazioneCollaudo) && tipoInvio eq "1" && utenteAbilitato eq "si" && !lottoInRichiesteDiCancellazione}'>
							<img src="${pageContext.request.contextPath}/img/invioFlussoBN.png"	title="Invio non possibile per monitoraggio terminato sul lotto" /> 
						</c:when>
						<c:when test='${(tipoInvio eq "1" || tipoInvio eq "3") && utenteAbilitato eq "si" && lottoInRichiesteDiCancellazione}'>
							<img src="${pageContext.request.contextPath}/img/invioFlussoBN.png"	title="Invio non possibile per richieste di cancellazioni pendenti" /> 
						</c:when>
						<c:when test='${tipoInvio eq "2" && utenteAbilitato eq "si"}'> <!-- busta verde -->
							<c:if test='${!lottoInRichiesteDiCancellazione}'>
								<a href="javascript:paginaSelezioneNuovoFlusso('${chiaveFlussiInserimento}', '${tipoInvio}')"
									title="Invio gi&agrave; effettuato"> <img src="${pageContext.request.contextPath}/img/invioFlusso.png" /> </a>
							</c:if>
							<c:if test='${lottoInRichiesteDiCancellazione}'>
								<img src="${pageContext.request.contextPath}/img/invioFlussoBN.png"	title="Invio non possibile per richieste di cancellazioni pendenti" />
							</c:if>
						</c:when>
						<c:when test='${tipoInvio eq "3" && utenteAbilitato eq "si" && !lottoInRichiesteDiCancellazione}'> <!-- busta rossa -->
							<a href="javascript:paginaSelezioneNuovoFlusso('${chiaveFlussiInserimento}', '2')"
								title="Rettifica da inviare"> <img src="${pageContext.request.contextPath}/img/invioRettificaFlusso.png" /> </a>
						</c:when>
						<c:otherwise>
							<img src="${pageContext.request.contextPath}/img/no_flag.gif" title="Utente senza permesso di effettuare l'invio" />
						</c:otherwise>							
					</c:choose>
					<c:if test='${createXMLRLO}'>
						<c:if test='${(gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 1 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 2 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 3 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 4 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 5 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 6 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 7 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 8 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 9 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 10 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 987 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 11 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 12 || gene:getValCampo(chiaveRigaJava,"FASE_ESECUZIONE") eq 985) }'>
							<a href="javascript:creaXmlRLO('${chiaveRigaJava}')"
								title="Crea XML Regione Lombardia"> <img src="${pageContext.request.contextPath}/img/exportXML.gif" /> </a>
						</c:if>
					</c:if>
				</center></gene:campoLista>
			</c:if>
			</gene:formLista></td>
		</tr>
		
		<c:choose>
			<c:when test='${(empty situazioneCollaudo) && prot && !lottoInRichiesteDiCancellazione && (abilitaCreaNuovaFase or sessionScope.profiloUtente.abilitazioneStd eq "A" or sessionScope.profiloUtente.abilitazioneStd eq "C")}'>
				<gene:redefineInsert name="listaNuovo">
					<td class="vocemenulaterale">
						<a href="javascript:creaNuovo('${key}')" title="Inserisci" tabindex="1501">Nuovo</a>
					</td>
				</gene:redefineInsert>
				
				<gene:redefineInsert name="pulsanteListaInserisci">
					<INPUT type="button" class="bottone-azione"
						title='${gene:resource("label.tags.template.lista.listaPageNuovo")}'
						value="Nuovo" onclick="javascript:creaNuovo('${key}');">
				</gene:redefineInsert>
			</c:when>
			<c:otherwise>
				<gene:redefineInsert name="listaNuovo" />
				
				<gene:redefineInsert name="pulsanteListaInserisci" />
			</c:otherwise>
		</c:choose>

		<c:if test='${eliminabili eq false}'>
			<gene:redefineInsert name="pulsanteListaEliminaSelezione" />
			<gene:redefineInsert name="listaEliminaSelezione" />
		</c:if>
		<tr>
			<jsp:include page="/WEB-INF/pages/commons/pulsantiLista.jsp" />
		</tr>

	</c:otherwise>
</c:choose>
</table>

<gene:javaScript>
	function creaLink(pag,keyup,modo) {
		if (pag.indexOf("w9imprese") >= 0) {
			
			var chiave = keyup.split(";");
			
			var codGara = chiave[0].split(":")[1];
			var codLott = chiave[1].split(":")[1];
			
			document.location.href = "${pageContext.request.contextPath}/w9/ListaW9Imprese.do?metodo=visualizza&codGara=" + codGara + "&codLott=" + codLott;
			// nel passaggio alla liste delle imprese invitate/partecipanti 
			// se pgLastSort e' valorizzato la pagina va in errore
			//document.forms[0].pgLastSort.value = null;
					
		} else {
			// per w9appa aggiungere una variabile che determini il tipo (a04,a05,a21) 
			var keyW9APPA = "";
			if (pag.indexOf("w9appa-scheda-a04") >= 0) {
				pag = pag.replace(/w9appa-scheda-a04/,"w9appa-scheda");
				keyW9APPA = "keyW9APPA=A04&";
			}
			if (pag.indexOf("w9appa-scheda-a05") >= 0) {
				pag = pag.replace(/w9appa-scheda-a05/,"w9appa-scheda");
				keyW9APPA = "keyW9APPA=A05&";
			}
			if (pag.indexOf("w9appa-scheda-a21") >= 0) {
				pag = pag.replace(/w9appa-scheda-a21/,"w9appa-scheda");
				keyW9APPA = "keyW9APPA=A21&";
			}
			var action="${pageContext.request.contextPath}/ApriPagina.do?" + keyW9APPA + "href=w9/" + pag + modo;
			document.forms[0].key.value=pag.substring(pag.indexOf('?chiave=') + 8);
			document.forms[0].action=action;
			document.forms[0].activePage.value="0";
			document.forms[0].submit();
		}
	}
	
	function creaNuovo(key) {
		document.location.href = '${pageContext.request.contextPath}/w9/SelezionaNuovaFase.do?key=' + key;
	}

	function paginaSelezioneNuovoFlusso(chiave, tipoInvio) {
		document.forms[0].key.value='W9FLUSSI.AREA=N:1;W9FLUSSI.KEY01=N:${key01};W9FLUSSI.KEY02=N:${key02};'+chiave+';W9FLUSSI.TINVIO2=N:'+tipoInvio;
		document.forms[0].metodo.value="nuovo";
		document.forms[0].activePage.value="0";
		document.forms[0].pathScheda.value="w9/w9flussi/w9flussi-scheda.jsp";
		document.forms[0].submit();
	}
	
	function paginaEliminaFase(chiave, tipoInvio) {
		document.forms[0].key.value='W9FLUSSI.AREA=N:1;W9FLUSSI.KEY01=N:${key01};W9FLUSSI.KEY02=N:${key02};'+chiave+';W9FLUSSI.TINVIO2=N:'+tipoInvio;
		document.forms[0].metodo.value="nuovo";
		document.forms[0].activePage.value="0";
		document.forms[0].pathScheda.value="w9/w9fasi/w9fasi-elimina-scheda.jsp";
		document.forms[0].submit();
	}
	
	function creaXmlSitar(key) {
		var comando = "href=w9/commons/popup-validazione-xml-sitar.jsp?key=" + key;
		openPopUpCustom(comando, "validazione", 500, 650, "yes", "yes");
	}
	
	function creaXmlRLO(key) {
		document.location.href = '${pageContext.request.contextPath}/ApriPagina.do?href=w9/commons/create-import-xmlrlo.jsp?key=' + key
	}

</gene:javaScript>
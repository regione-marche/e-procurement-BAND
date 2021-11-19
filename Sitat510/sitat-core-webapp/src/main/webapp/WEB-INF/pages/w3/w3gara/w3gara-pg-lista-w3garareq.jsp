
<%
	/*
	 * Created on 23-Apr-2008
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

<c:set var="stato_simog_gara" value='${gene:callFunction2("it.eldasoft.sil.w3.tags.funzioni.GetStatoSimogW3GaraFunction",pageContext,numgara)}' />
<c:set var="idgara" value='${gene:callFunction2("it.eldasoft.sil.w3.tags.funzioni.GetIdGaraW3GaraFunction",pageContext,numgara)}' />
<c:set var="entita" value="W3GARAREQ" />
<c:set var="numgara" value='${gene:getValCampo(key,"NUMGARA")}' scope="request" />
<c:set var="numreq" value='0' scope="request" />


<gene:set name="titoloMenu">
	<jsp:include page="/WEB-INF/pages/commons/iconeCheckUncheck.jsp" />
</gene:set>
<table class="dettaglio-tab-lista">
	<tr>
		<td>
		<gene:formLista entita="W3GARAREQ" pagesize="20" sortColumn="2"
			where="W3GARAREQ.NUMGARA = #W3GARA.NUMGARA#" tableclass="datilista"
			gestisciProtezioni="true" gestore="it.eldasoft.sil.w3.tags.gestori.submit.GestoreW3GARAREQ">
			
			<gene:campoLista title="Opzioni <br><center>${titoloMenu}</center>" width="50">
				<c:if test="${currentRow >= 0}">
					<gene:PopUp variableJs="rigaPopUpMenu${currentRow}" onClick="chiaveRiga='${chiaveRigaJava}'">
						<gene:PopUpItemResource resource="popupmenu.tags.lista.visualizza" title="Visualizza requisito" />
						<c:if test='${gene:checkProtFunz(pageContext, "MOD","MOD")}'>
							<c:if test="${!(stato_simog_gara eq '5' or stato_simog_gara eq '6' or stato_simog_gara eq '7') and !(datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '59' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '60' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '61' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '62' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '63' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '64' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '65' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '66' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '67' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '68' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '69' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '70' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '71' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '72' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '73' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '74' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '34' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '35')}">
									<gene:PopUpItemResource resource="popupmenu.tags.lista.modifica"
										title="Modifica requisito" />
							</c:if>
						</c:if>
						<c:if test='${gene:checkProtFunz(pageContext, "DEL","DEL")}'>
							<c:if test="${!(stato_simog_gara eq '5' or stato_simog_gara eq '6' or stato_simog_gara eq '7') and !(datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '59' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '60' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '61' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '62' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '63' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '64' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '65' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '66' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '67' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '68' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '69' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '70' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '71' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '72' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '73' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '74' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '34' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '35')}">
									<gene:PopUpItemResource resource="popupmenu.tags.lista.elimina"
										title="Elimina requisito" />
							</c:if>
						</c:if>
					</gene:PopUp>
					<c:if test='${gene:checkProtFunz(pageContext, "DEL","LISTADELSEL")}'>
						<c:choose>
							<c:when test="${!(stato_simog_gara eq '5' or stato_simog_gara eq '6' or stato_simog_gara eq '7') and !(datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '59' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '60' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '61' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '62' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '63' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '64' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '65' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '66' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '67' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '68' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '69' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '70' or	datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '71' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '72' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '73' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '74' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '34' or datiRiga.W3GARAREQ_CODICE_DETTAGLIO eq '35')}">
								<input type="checkbox" name="keys" value="${chiaveRiga}" />
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="keys" value="${chiaveRiga}" disabled="disabled"/>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:if>
			
			</gene:campoLista>
			
			<gene:campoLista campo="NUMGARA" visibile="false"/>
			<gene:campoLista title="N." campo="NUMREQ" width="30" href="javascript:chiaveRiga='${chiaveRigaJava}';listaVisualizza();" />
			<gene:campoLista title="Requisito" campo="CODICE_DETTAGLIO" gestore="it.eldasoft.sil.w3.tags.funzioni.decoratori.campi.GestoreCampoW3TABREQ"
				href="javascript:chiaveRiga='${chiaveRigaJava}';listaVisualizza();"/>
		</gene:formLista>
		</td>
	</tr>

	<c:if test="${currentRow == 0 or stato_simog_gara eq '5' or stato_simog_gara eq '6' or stato_simog_gara eq '7'}">
		<gene:redefineInsert name="pulsanteListaInserisci"/>
		<gene:redefineInsert name="pulsanteListaEliminaSelezione"/>
		<gene:redefineInsert name="listaNuovo"/>
		<gene:redefineInsert name="listaEliminaSelezione"/>
	</c:if>
	<gene:redefineInsert name="addToDocumenti" >
		<c:if test='${gene:checkProt(pageContext, "FUNZ.VIS.ALT.W3.richiesteSIMOG")}'>
		<c:if test="${currentRow != 0 and (stato_simog_gara eq '2' or stato_simog_gara eq '3' or stato_simog_gara eq '4') and idgara ne ''}">
			<jsp:include page="/WEB-INF/pages/w3/commons/addtodocumenti-requisiti-gara.jsp" />
			<tr>
				<c:choose>
			        <c:when test='${isNavigazioneDisattiva ne "1"}'>
			          <td class="vocemenulaterale">
						<a href="javascript:popupRichiestaRequisiti('${numgara}', '${numreq}', '${idgara}');" title="Invia, a SIMOG, richiesta requisiti du gara" tabindex="1513">
							Invia richiesta requisiti gara
						</a>
					  </td>
			        </c:when>
				    <c:otherwise>
				       <td>
						 Invia richiesta requisiti gara
					   </td>
				    </c:otherwise>
				</c:choose>
			</tr>
		</c:if>
		</c:if>
	</gene:redefineInsert>
	
	
	<tr>
		<jsp:include page="/WEB-INF/pages/commons/pulsantiListaPage.jsp" />
	</tr>


</table>

<gene:javaScript>
	

</gene:javaScript>	





package it.eldasoft.w9.tags.funzioni;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.commons.web.domain.CostantiGenerali;
import it.eldasoft.gene.commons.web.domain.ProfiloUtente;
import it.eldasoft.gene.tags.utils.AbstractFunzioneTag;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.w9.common.SituazioneGaraLotto;

import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * Function per determinare il numero di fasi/eventi associati al lotto di gara.
 * Determina anche se l'invio e' consentito.
 * 
 * @author Luca.Giacomazzo
 */
public class InitListaFlussiLottoFunction extends AbstractFunzioneTag {

  public InitListaFlussiLottoFunction() {
    super(1, new Class[] { String.class });
  }

  @Override
  public String function(PageContext pageContext, Object[] params) throws JspException {

    SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager",
        pageContext, SqlManager.class);

    String key = (String) params[0];
    String[] tmp = key.split(";");
    try {
      Long codgara = new Long(tmp[0].substring(tmp[0].indexOf(':') + 1));
      Long codlotto = new Long(tmp[1].substring(tmp[1].indexOf(':') + 1));
      String tipoAppalto = (String) sqlManager.getObject(
              "select TIPO_CONTRATTO from w9lott where CODGARA=? and CODLOTT=?",
              new Object[]{ codgara, codlotto});
      if (tipoAppalto != null) {
          this.getRequest().setAttribute("tipoAppalto", tipoAppalto);
        }
      
      Long situazione = (Long) sqlManager.getObject("select SITUAZIONE from w9lott where CODGARA=? and CODLOTT=?",
              new Object[]{ codgara, codlotto});
      if (situazione != null && situazione.intValue() == SituazioneGaraLotto.SITUAZIONE_RICHIESTA_CANCELLAZIONE.getSituazione()) {
          this.getRequest().setAttribute("lottoInRichiesteDiCancellazione",  Boolean.TRUE);
      } else {
    	  this.getRequest().setAttribute("lottoInRichiesteDiCancellazione",  Boolean.FALSE);
      }
      
      Long numeroFasi = (Long) sqlManager.getObject(
          "select count(*) from w9fasi where CODGARA=? and CODLOTT=?",
          new Object[]{ codgara, codlotto});

      if (numeroFasi != null && numeroFasi.longValue() != 0) {
        this.getRequest().setAttribute("numeroFasiDelLotto", numeroFasi);
      }
      Long numeroFlussiAnagraficaGara = (Long) sqlManager.getObject(
          "select count(*) from w9flussi where key01=? and key03=988",
          new Object[]{ codgara } );

      if (numeroFlussiAnagraficaGara != null && numeroFlussiAnagraficaGara.longValue() != 0) {
        this.getRequest().setAttribute("numeroFlussiAnagraficaGara", numeroFlussiAnagraficaGara);
      }
      
      // Estrazione del numero di macrofasi sulle quali l'utente loggato ha permessi di
      // lettura/scrittura (permesso >=4). Se tale numero e' maggiore di zero, allora
      // nella lista si possono visualizzare il pulsante 'Nuovo' ed il link 'Nuovo' per
      // creare una nuova fase, altrimenti vanno nascosti.
      
      /*String ufficioIntestatario = (String) pageContext.getSession().getAttribute(
          CostantiGenerali.UFFICIO_INTESTATARIO_ATTIVO);*/
      ProfiloUtente profiloUtente = (ProfiloUtente) pageContext.getSession().getAttribute(
          CostantiGenerali.PROFILO_UTENTE_SESSIONE);
      
      Long numeroMacroFasiModificabili = (Long) sqlManager.getObject(
          "select count(w.PERMESSO) from V_W9PERMESSI w " +
           "where w.CODGARA = ? " +
             "and w.PERMESSO >= 4 " +
             "and w.RUOLO in ( " +
                 "select r.ID_RUOLO from V_RUOLOTECNICO r " +
                  "where r.CODGARA = ? " +
                    "and r.CODLOTT = ? " +
                    "and r.SYSCON = ?)",
                    //"and r.CODTEC in (select CODTEC FROM TECNI WHERE SYSCON = ? and CGENTEI = ?))",
             new Object[]{ codgara, codgara, codlotto, new Long(profiloUtente.getId()) } );
      
      if (numeroMacroFasiModificabili > 0) {
        this.getRequest().setAttribute("abilitaCreaNuovaFase", Boolean.TRUE);
      } else {
        this.getRequest().setAttribute("abilitaCreaNuovaFase", Boolean.FALSE);
      }
      
    } catch (SQLException e) {
      throw new JspException("Errore nel determinare se l'utente puo' creare nuove fasi.", e);
    }
    return null;
  }

}
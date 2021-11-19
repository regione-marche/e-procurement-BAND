package it.eldasoft.w9.tags.funzioni;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.tags.utils.AbstractFunzioneTag;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.w9.bl.W9AggiudicatarieManager;
import it.eldasoft.w9.common.CostantiW9;
import it.eldasoft.w9.utils.UtilitySITAT;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class W9AppaPgImpreseFunction extends AbstractFunzioneTag {

	public W9AppaPgImpreseFunction() {
		super(3, new Class[] { PageContext.class, String.class });
	}

	@Override
	public String function(PageContext pageContext, final Object[] params) throws JspException {

		// recupero tutti i valori necessari alla visualizzazione della lista
		W9AggiudicatarieManager w9AggiudicatarieManager = (W9AggiudicatarieManager) UtilitySpring.getBean("w9AggiudicatarieManager", pageContext, W9AggiudicatarieManager.class);

		Long codiceGara = null;
		Long numAppa = null;
		Long codiceLotto = null;

		String tempKey = (String) params[1];

		codiceGara = new Long(tempKey.split(";")[0].split(":")[1]);
		numAppa = new Long(tempKey.split(";")[1].split(":")[1]);
		codiceLotto = new Long(tempKey.split(";")[2].split(":")[1]);

		List<Vector<?>> risultatoListaW9Aggiudicatarie = new Vector<Vector<?>>();
		try {
			risultatoListaW9Aggiudicatarie = w9AggiudicatarieManager.getListaW9Aggiudicatarie(pageContext, codiceGara, numAppa, codiceLotto);
		} catch (SQLException e) {
			throw new JspException("Errore nel recupero dei dati dal database.", e);

		} catch (GestoreException e) {
			throw new JspException("Errore nel nell'esecuzione della function.", e);
		}

		pageContext.setAttribute("risultatoListaW9Aggiudicatarie", risultatoListaW9Aggiudicatarie, PageContext.REQUEST_SCOPE);

		// determino la presenza della fase di partecipazione delle imprese
		// e pongo il risultato nella request come attributo
		String resultStringISDEL = null;

		SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager", pageContext, SqlManager.class);

		try {
			if (UtilitySITAT.existsFase(codiceGara, codiceLotto, 101, sqlManager)) {
				resultStringISDEL = "presenteListaPartecipanti";
			}
		} catch (SQLException e) {
			throw new JspException("Errore nell'estrarre fase partecipante ", e);
		}

		this.getRequest().setAttribute("isFasePartecipante", resultStringISDEL);

		// determino se la gara e' in una fase di accordo quadro
		String resultStringISAQ = null;
		String sqlQuery = "select tipo_app from w9gara where codgara = ?";

		try {
			if (UtilitySITAT.isSAQ(codiceGara, sqlManager)) {
				resultStringISAQ = "isAccordoQuadro";
			}
		} catch (SQLException e) {
			throw new JspException("Errore nel recupero dei dati dal database.", e);
		}

		this.getRequest().setAttribute("isAccordoQuadro", resultStringISAQ);

		return null;
	}

}

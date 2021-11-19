package it.eldasoft.w9.tags.gestori.decoratori;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.jsp.PageContext;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.datautils.DataColumn;
import it.eldasoft.gene.db.domain.Tabellato;
import it.eldasoft.gene.tags.decorators.campi.AbstractGestoreCampo;
import it.eldasoft.utils.spring.UtilitySpring;

public class GestoreW9LottIdModoGara extends AbstractGestoreCampo {

  @Override
  public String gestisciDaTrova(Vector arg0, DataColumn arg1, String arg2, SqlManager arg3) {
    return null;
  }

  @Override
  public String getClasseEdit() {
    return null;
  }

  @Override
  public String getClasseVisua() {
    return null;
  }

  @Override
  public String getHTML(boolean arg0, boolean arg1) {
    return null;
  }

  @Override
  public String getValore(String arg0) {
    return null;
  }

  @Override
  public String getValorePerVisualizzazione(String arg0) {
    return null;
  }

  @Override
  public String getValorePreUpdateDB(String arg0) {
    return null;
  }

  @Override
  protected void initGestore() {
    this.getCampo().setTipo("EN5");
    this.getCampo().getValori().clear();
    
    this.getCampo().addValore("", "");
    
    HashMap datiRiga = (HashMap) this.getPageContext().getAttribute("datiRiga",
        PageContext.REQUEST_SCOPE);

    if (datiRiga != null) {
      SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager",
          this.getPageContext(), SqlManager.class);
      
      String versioneSimog = (String) datiRiga.get("W9GARA_VER_SIMOG");
      List<Tabellato> listaTabellati = null;
      try {
        if ("1".equals(versioneSimog)) {
          listaTabellati = (List<Tabellato>) sqlManager.getElencoTabellati(
              "select TAB1TIP, TAB1DESC from TAB1 where TAB1COD='W3007' and TAB1TIP <= 2 order by TAB1TIP asc", null);
        } else {
          listaTabellati = (List<Tabellato>) sqlManager.getElencoTabellati(
              "select TAB1TIP, TAB1DESC from TAB1 where TAB1COD='W3007' and TAB1ARC is null order by TAB1TIP asc", null);
        }
        if (listaTabellati != null && listaTabellati.size() > 0) {
          for (int i=0; i < listaTabellati.size(); i++) {
            Tabellato tabellato = listaTabellati.get(i);
            this.getCampo().addValore(tabellato.getTipoTabellato(), tabellato.getDescTabellato());
          }
        }
      } catch (SQLException sqle) {
        
      }
    }
  }

  @Override
  public String postHTML(boolean arg0, boolean arg1) {
    return null;
  }

  @Override
  public String preHTML(boolean arg0, boolean arg1) {
    return null;
  }

}

package it.eldasoft.sil.pt.tags.funzioni;

import it.eldasoft.gene.tags.utils.AbstractFunzioneTag;
import it.eldasoft.utils.properties.ConfigManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;

public class GetCfgNormaFunction extends AbstractFunzioneTag {

  public GetCfgNormaFunction() {
	super(2, new Class[] { PageContext.class, String.class });
  }

  @Override
  public String function(PageContext pageContext, Object[] arg1) throws JspException {
	  
	String normaCfgLavori = ConfigManager.getValore("it.eldasoft.pt.norma.lavori");
	String normaCfgFornitureSerivzi = ConfigManager.getValore("it.eldasoft.pt.norma.fornitureServizi");
	
	if (StringUtils.isNotEmpty(normaCfgFornitureSerivzi)) {
		pageContext.setAttribute("normaForSer", normaCfgFornitureSerivzi);
	}

	if (StringUtils.isNotEmpty(normaCfgLavori)) {
	  return normaCfgLavori;
	} else {	
	  return null;
	}
  }

}

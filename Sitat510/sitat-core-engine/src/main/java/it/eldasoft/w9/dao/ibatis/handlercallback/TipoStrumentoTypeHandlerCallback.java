package it.eldasoft.w9.dao.ibatis.handlercallback;

import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType;

import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang.StringUtils;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * Classe di callback per estrarre con ibatis campi di tipo stringa in oggetti di tipo
 * it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType.
 * 
 * @author Luca.Giacomazzo
 */
public class TipoStrumentoTypeHandlerCallback implements TypeHandlerCallback {

  @Override
  public Object getResult(ResultGetter getter) throws SQLException {
    String str = getter.getString();
    Object flag = null;
    if (StringUtils.isNotEmpty(str)) {
      flag = TipoStrumentoType.fromString(str);
    }
    return flag;
  }

  @Override
  public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
    // Questo metodo non e' stato implementato correttamente perche' non si usa il campo
    // come parametro in una PreparedStatement. 
    if (parameter == null) { 
      setter.setNull(Types.VARCHAR); 
    } else { 
      setter.setString(((TipoStrumentoType) parameter).getValue());
    }
  }

  @Override
  public Object valueOf(String str) {
    Object result = str;
    if (StringUtils.isNotEmpty(str)) {
      result = TipoStrumentoType.fromString(str);
    }
    return result;
  }

}

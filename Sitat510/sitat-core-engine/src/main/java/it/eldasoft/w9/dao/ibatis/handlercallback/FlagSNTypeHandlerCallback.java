package it.eldasoft.w9.dao.ibatis.handlercallback;

import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang.StringUtils;

import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * Classe di callback per estrarre con ibatis campi di tipo Si/No (di tipo stringa) in oggetti
 * di tipo it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType. 
 * 
 * @author Luca.Giacomazzo
 */
public class FlagSNTypeHandlerCallback implements TypeHandlerCallback {

  @Override
  public Object getResult(ResultGetter getter) throws SQLException {
    Object flag = null;
    String str = getter.getString();
    if (StringUtils.isNotEmpty(str)) {
      if ("1".equals(str)) {
        flag = FlagSNType.S;
      } else if ("2".equals(str)) {
        flag = FlagSNType.N;
      }
    }
    return flag;
  }

  @Override
  public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
    if (parameter == null) { 
      setter.setNull(Types.VARCHAR); 
    } else { 
      if (FlagSNType.S.equals(parameter)) {
        setter.setString("1");
      } else if (FlagSNType.N.equals(parameter)) {
        setter.setString("2");
      }
    }
  }

  @Override
  public Object valueOf(String str) {
    Object result = str;
    if (StringUtils.isNotEmpty(str)) {
      if ("1".equals(str) || "S".equals(str)) {
        result = FlagSNType.S;
      } else if ("2".equals(str) || "N".equals(str)) {
        result = FlagSNType.N;
      }
    }
    return result;
  }
 
}

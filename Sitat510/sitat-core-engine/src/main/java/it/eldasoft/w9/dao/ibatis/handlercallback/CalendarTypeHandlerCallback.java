package it.eldasoft.w9.dao.ibatis.handlercallback;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import org.apache.commons.lang.time.DateUtils;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

public class CalendarTypeHandlerCallback implements TypeHandlerCallback {

  @Override
  public Object getResult(ResultGetter getter) throws SQLException {
    Date date = getter.getDate();
    Calendar calendar = null;

    if (date != null) {
      int offset = Math.abs(date.getTimezoneOffset());
      java.util.Date datadata = DateUtils.addMinutes(date, offset);
      calendar = Calendar.getInstance();
      calendar.setTime(datadata);
    }
    return calendar;
  }

  @Override
  public void setParameter(ParameterSetter arg0, Object arg1)
      throws SQLException {
    // TODO Auto-generated method stub

  }

  @Override
  public Object valueOf(String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

}

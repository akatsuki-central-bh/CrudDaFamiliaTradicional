package Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MillisToTime {
  public static String convert(long millis){
    Date date = new Date(millis);
    DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    return formatter.format(date);
  }
}

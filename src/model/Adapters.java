package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapters {
 /**
  * Clase utilizada para obtener la fecha 
  * cuando se use en el XML 
  *
  */
	public static class LocalDateTimeBind extends XmlAdapter<String, LocalDateTime> {

        @Override
        public LocalDateTime unmarshal(String val) {
            return LocalDateTime.parse(val, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS"));
        }

        @Override
        public String marshal(LocalDateTime localDateTime) {
            return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS"));
        }
    }
}

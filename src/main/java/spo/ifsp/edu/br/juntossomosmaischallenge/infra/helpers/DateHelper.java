package spo.ifsp.edu.br.juntossomosmaischallenge.infra.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static Date getDateFromString(String date) throws Exception {
        date = date.replaceAll("T", " ").replaceAll("Z", "");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
    }
}

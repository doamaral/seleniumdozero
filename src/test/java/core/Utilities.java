package core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {
    public static Date getTodayDatePlusDays(int dias){
        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DAY_OF_MONTH, dias);
        return calendario.getTime();
    }

    public static String getSimplifiedFormatDate(Date data){
        DateFormat formatacao = new SimpleDateFormat("dd/MM/YYYY");
        return formatacao.format(data);
    }
}

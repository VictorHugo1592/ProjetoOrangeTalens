package br.com.zuporange.veiculo;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class DiaDaSemana {

	public static String getDiaDaSemana(){
        return new DateFormatSymbols().getWeekdays()[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)];
    }
	
}

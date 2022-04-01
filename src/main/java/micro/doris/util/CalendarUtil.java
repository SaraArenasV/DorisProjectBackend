package micro.doris.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class CalendarUtil {




    public  static String todayString(){
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);

        return formattedDate;
    }


    public  static Date todayDate(){
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        return dateObj;
    }



}

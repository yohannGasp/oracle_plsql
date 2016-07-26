/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.util.Calendar;

/**
 *
 * @author akulov_ev
 */
public class util1 {

    public static String normal_date(String in) {
        String str;
        str = in;
        if (str.length() == 1) {
            str = "0" + str;
        }
        return str;
    }

    //первое число прошлого месяца
    public static String firstDataLastMonth() {
        //return "01." + normal_date(String.valueOf(Calendar.getInstance().get(Calendar.MONTH))) + "." + Calendar.getInstance().get(Calendar.YEAR);
        return "11.07.2016";
    }

    //вчерашняя дата
    public static String Yesteday() {
        Calendar today = Calendar.getInstance();
        if (today.get(Calendar.DAY_OF_WEEK) == 2) {
            today.add(Calendar.DAY_OF_MONTH, -3); //пятница

        } else {
            today.add(Calendar.DAY_OF_MONTH, -1); //вчерашняя дата
        }
        today.add(Calendar.MONTH, 1);         // выправляем месяц
        return normal_date(String.valueOf(today.get(Calendar.DAY_OF_MONTH))) + "." + normal_date(String.valueOf(today.get(Calendar.MONTH))) + "." + today.get(Calendar.YEAR);
    }

}

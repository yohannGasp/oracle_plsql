/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author akulov_ev
 */
public class bib_balance implements CFT_Interface {

    @Override
    public void to_file(String fileName) {
        String str;
        String[] param = new String[6];
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "Cp866");) {
            //Calendar c1 = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) - 1, 1);//первое число прошлого месяца
            Calendar c1 = new GregorianCalendar(2016,6,1);//первое число прошлого месяца
            Calendar today = Calendar.getInstance();
            if (today.get(Calendar.DAY_OF_WEEK) == 2) {
                today.add(Calendar.DAY_OF_MONTH, -3); //пятница

            } else {
                today.add(Calendar.DAY_OF_MONTH, -1); //вчерашняя дата
            }
            while (c1.before(today)) {
                GregorianCalendar c2 = (GregorianCalendar) c1.clone();
                String day1 = util1.normal_date(String.valueOf(c2.get(Calendar.DAY_OF_MONTH)));
                String mon  = util1.normal_date(String.valueOf(c2.get(Calendar.MONTH)+1));
                String date_1 = day1 + "." + mon + "." + c2.get(Calendar.YEAR);

                GregorianCalendar c3 = (GregorianCalendar) c2.clone();
                c3.add(GregorianCalendar.DAY_OF_MONTH, 1); // прибавляем дату для процедуры
                // правильнее вычитать дату
                String day2 = util1.normal_date(String.valueOf(c3.get(Calendar.DAY_OF_MONTH)));
                String mon2 = util1.normal_date(String.valueOf(c3.get(Calendar.MONTH)+1));
                String date_2 = day2 + "." + mon2 + "." + c3.get(Calendar.YEAR);
                System.out.println(date_1 + " " + date_2);
                param[0] = date_1;
                param[1] = date_2;
                param[2] = date_1;
                param[3] = date_2;
                param[4] = date_1;
                param[5] = date_1;
                //ResultSet rs = Taisu.db.ResultSetPS(Taisu.db.SELECT_BALANCE_SQL, param);
                ResultSet rs = Taisu.db.ExecProcPS(Taisu.db.SELECT_BALANCE_SQL, param);
                while (rs.next()) {
                    try (Formatter fmt = new Formatter(Locale.ENGLISH)) {
                        str = fmt.format("%s\t"
                                + "%s\t"
                                + "%s\t"
                                + "%s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)).toString();
                        //System.out.println(str);
                    }
                    if ((rs.getString(1).equals("40701810000000002385") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40701810100000002395") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40701810200000002428") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40701810300000002386") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40701810300000002412") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40701810500000002393") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40701810700000002397") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40701810900000002456") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002371") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002407") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002410") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002436") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002449") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002465") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002478") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810000000002481") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002349") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002365") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002378") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002381") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002404") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002420") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002433") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002459") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002462") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810100000002488") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810200000002359") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810200000002388") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810200000002391") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810200000002414") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810200000002443") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810200000002485") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810300000002398") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810300000002440") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810300000002482") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810400000002379") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810400000002382") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810400000002418") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810400000002421") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810400000002450") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810400000002463") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810500000002389") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810500000002392") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810500000002415") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810500000002431") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810500000002460") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810500000002473") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810600000002373") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810600000002441") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810600000002467") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810600000002470") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810700000002338") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810700000002406") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810700000002419") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810700000002435") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810700000002448") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810700000002464") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810700000002480") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002364") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002416") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002429") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002432") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002445") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002458") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002461") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810800000002474") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002361") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002374") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002387") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002400") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002439") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002442") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002455") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702810900000002468") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840000000042398") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840000000042424") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840100000022373") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840100000042379") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840400000042419") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840700000022391") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840800000022398") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840900000042375") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702840900000042414") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978000000042419") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978500000042414") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978600000022431") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978600000042398") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978600000042424") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978700000042379") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978800000022419") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978800000022435") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978800000022480") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978800000042415") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978800000042431") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40702978900000042373") & rs.getString(5).equals("000-05"))
                            | (rs.getString(1).equals("40802810100000000542") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840000000022415") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840000000022431") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840200000022419") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840200000022435") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840200000022480") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840200000042415") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840200000042431") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840300000042373") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840400000022442") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840400000042435") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840400000042480") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840500000022436") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840500000022449") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840500000022478") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840500000022481") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840600000022365") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840600000042442") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840700000022414") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840700000042436") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840700000042449") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840700000042478") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840700000042481") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840800000042365") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840900000022379") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702840900000042391") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978000000022442") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978000000042435") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978000000042480") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978100000022436") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978100000022449") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978100000022478") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978100000022481") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978200000022365") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978200000042442") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978300000022391") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978300000022414") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978300000042436") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978300000042449") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978300000042478") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978300000042481") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978400000022398") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978400000042365") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978500000022379") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978500000042375") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978500000042391") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978600000022415") & rs.getString(5).equals("000-05")) |
                            (rs.getString(1).equals("40702978700000022373") & rs.getString(5).equals("000-05"))) {
                        continue;
                    }

                    writer.write(str);
                }
                c1.add(GregorianCalendar.DAY_OF_MONTH, 1);
                writer.flush();
            }
            System.out.println("2. balance ");
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }

    }

}

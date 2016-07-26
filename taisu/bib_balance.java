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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author akulov_ev
 */
public class bib_balance implements CFT_Interface {

    public List<String> bad_acct = new ArrayList<>();

    public bib_balance() {
        bad_acct.add("40701810000000002385");
        bad_acct.add("40701810100000002395");
        bad_acct.add("40701810200000002428");
        bad_acct.add("40701810300000002386");
        bad_acct.add("40701810300000002412");
        bad_acct.add("40701810500000002393");
        bad_acct.add("40701810700000002397");
        bad_acct.add("40701810900000002456");
        bad_acct.add("40702810000000002371");
        bad_acct.add("40702810000000002407");
        bad_acct.add("40702810000000002410");
        bad_acct.add("40702810000000002436");
        bad_acct.add("40702810000000002449");
        bad_acct.add("40702810000000002465");
        bad_acct.add("40702810000000002478");
        bad_acct.add("40702810000000002481");
        bad_acct.add("40702810100000002349");
        bad_acct.add("40702810100000002365");
        bad_acct.add("40702810100000002378");
        bad_acct.add("40702810100000002381");
        bad_acct.add("40702810100000002404");
        bad_acct.add("40702810100000002420");
        bad_acct.add("40702810100000002433");
        bad_acct.add("40702810100000002459");
        bad_acct.add("40702810100000002462");
        bad_acct.add("40702810100000002488");
        bad_acct.add("40702810200000002359");
        bad_acct.add("40702810200000002388");
        bad_acct.add("40702810200000002391");
        bad_acct.add("40702810200000002414");
        bad_acct.add("40702810200000002443");
        bad_acct.add("40702810200000002485");
        bad_acct.add("40702810300000002398");
        bad_acct.add("40702810300000002440");
        bad_acct.add("40702810300000002482");
        bad_acct.add("40702810400000002379");
        bad_acct.add("40702810400000002382");
        bad_acct.add("40702810400000002418");
        bad_acct.add("40702810400000002421");
        bad_acct.add("40702810400000002450");
        bad_acct.add("40702810400000002463");
        bad_acct.add("40702810500000002389");
        bad_acct.add("40702810500000002392");
        bad_acct.add("40702810500000002415");
        bad_acct.add("40702810500000002431");
        bad_acct.add("40702810500000002460");
        bad_acct.add("40702810500000002473");
        bad_acct.add("40702810600000002373");
        bad_acct.add("40702810600000002441");
        bad_acct.add("40702810600000002467");
        bad_acct.add("40702810600000002470");
        bad_acct.add("40702810700000002338");
        bad_acct.add("40702810700000002406");
        bad_acct.add("40702810700000002419");
        bad_acct.add("40702810700000002435");
        bad_acct.add("40702810700000002448");
        bad_acct.add("40702810700000002464");
        bad_acct.add("40702810700000002480");
        bad_acct.add("40702810800000002364");
        bad_acct.add("40702810800000002416");
        bad_acct.add("40702810800000002429");
        bad_acct.add("40702810800000002432");
        bad_acct.add("40702810800000002445");
        bad_acct.add("40702810800000002458");
        bad_acct.add("40702810800000002461");
        bad_acct.add("40702810800000002474");
        bad_acct.add("40702810900000002361");
        bad_acct.add("40702810900000002374");
        bad_acct.add("40702810900000002387");
        bad_acct.add("40702810900000002400");
        bad_acct.add("40702810900000002439");
        bad_acct.add("40702810900000002442");
        bad_acct.add("40702810900000002455");
        bad_acct.add("40702810900000002468");
        bad_acct.add("40702840000000042398");
        bad_acct.add("40702840000000042424");
        bad_acct.add("40702840100000022373");
        bad_acct.add("40702840100000042379");
        bad_acct.add("40702840400000042419");
        bad_acct.add("40702840700000022391");
        bad_acct.add("40702840800000022398");
        bad_acct.add("40702840900000042375");
        bad_acct.add("40702840900000042414");
        bad_acct.add("40702978000000042419");
        bad_acct.add("40702978500000042414");
        bad_acct.add("40702978600000022431");
        bad_acct.add("40702978600000042398");
        bad_acct.add("40702978600000042424");
        bad_acct.add("40702978700000042379");
        bad_acct.add("40702978800000022419");
        bad_acct.add("40702978800000022435");
        bad_acct.add("40702978800000022480");
        bad_acct.add("40702978800000042415");
        bad_acct.add("40702978800000042431");
        bad_acct.add("40702978900000042373");
        bad_acct.add("40802810100000000542");
        bad_acct.add("40702840000000022415");
        bad_acct.add("40702840000000022431");
        bad_acct.add("40702840200000022419");
        bad_acct.add("40702840200000022435");
        bad_acct.add("40702840200000022480");
        bad_acct.add("40702840200000042415");
        bad_acct.add("40702840200000042431");
        bad_acct.add("40702840300000042373");
        bad_acct.add("40702840400000022442");
        bad_acct.add("40702840400000042435");
        bad_acct.add("40702840400000042480");
        bad_acct.add("40702840500000022436");
        bad_acct.add("40702840500000022449");
        bad_acct.add("40702840500000022478");
        bad_acct.add("40702840500000022481");
        bad_acct.add("40702840600000022365");
        bad_acct.add("40702840600000042442");
        bad_acct.add("40702840700000022414");
        bad_acct.add("40702840700000042436");
        bad_acct.add("40702840700000042449");
        bad_acct.add("40702840700000042478");
        bad_acct.add("40702840700000042481");
        bad_acct.add("40702840800000042365");
        bad_acct.add("40702840900000022379");
        bad_acct.add("40702840900000042391");
        bad_acct.add("40702978000000022442");
        bad_acct.add("40702978000000042435");
        bad_acct.add("40702978000000042480");
        bad_acct.add("40702978100000022436");
        bad_acct.add("40702978100000022449");
        bad_acct.add("40702978100000022478");
        bad_acct.add("40702978100000022481");
        bad_acct.add("40702978200000022365");
        bad_acct.add("40702978200000042442");
        bad_acct.add("40702978300000022391");
        bad_acct.add("40702978300000022414");
        bad_acct.add("40702978300000042436");
        bad_acct.add("40702978300000042449");
        bad_acct.add("40702978300000042478");
        bad_acct.add("40702978300000042481");
        bad_acct.add("40702978400000022398");
        bad_acct.add("40702978400000042365");
        bad_acct.add("40702978500000022379");
        bad_acct.add("40702978500000042375");
        bad_acct.add("40702978500000042391");
        bad_acct.add("40702978600000022415");
        bad_acct.add("91203810700000000516");
        bad_acct.add("40702978700000022373");
    }

    @Override
    public void to_file(String fileName) {
        String str;
        String[] param = new String[6];
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "Cp866");) {
            //Calendar c1 = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) - 1, 1);//первое число прошлого месяца
            Calendar c1 = new GregorianCalendar(2016,6,11);//первое число прошлого месяца
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
                    if (bad_acct.contains(rs.getString(1)) & rs.getString(5).equals("000-05")) {
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

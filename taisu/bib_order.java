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
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author akulov_ev
 */
public class bib_order implements CFT_Interface {

    @Override
    public void to_file(String fileName) {
        String str = "";
        String[] param = new String[2];
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "Cp866");) {
            param[0] = util1.firstDataLastMonth() + " 00:00:00";
            param[1] = util1.Yesteday() + " 23:59:59";
            ResultSet rs = Taisu.db.ResultSetPS(Taisu.db.SELECT_ORDER_SQL, param);
            while (rs.next()) {
                try (Formatter fmt = new Formatter(Locale.ENGLISH)) {
                    str = fmt.format("%s\t" /* уник. номер */
                            + "%s\t" /* дебет       */
                            + "%s\t" /* кредит      */
                            + "%s\t" /* дебет       */
                            + "%s\t" /* кредит      */
                            + "%s\t" /* дата проводки */
                            + "%s\t" /* сумма в валюте счета */
                            + "%s\t" /* сумма в рублях */
                            + "%s\t" /* сумма в валюте счета */
                            + "%s\t" /* сумма в рублях */
                            + "%s\t" /* Назначение */
                            + "%s\t" /* Номер кредитного договора */
                            + "%s\t" /* Тип кредита */
                            + "%s" /* Номер депозита */
                            + "%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                            rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)).toString();
                }
                writer.write(str);
            }
            System.out.println("7. order " + param[0] + " - " + param[1]);
            writer.flush();
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }
    }

}

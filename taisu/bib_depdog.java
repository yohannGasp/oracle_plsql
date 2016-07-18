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
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author akulov_ev
 */
public class bib_depdog implements CFT_Interface{

    @Override
    public void to_file(String fileName) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "Cp866");) {
            ResultSet rs = Taisu.db.ExecProc(Taisu.db.SELECT_DEPDOG_SQL);
            while (rs.next()) {
                String str;
                try (Formatter fmt = new Formatter(Locale.ENGLISH)) {
                    str = fmt.format("%3s\t" /* подразделение */
                            + "%-20s\t" /* подразделение */
                            + "%5s\t" /* конто         */
                            + "%3s\t" /* код валюты */
                            + "%s\t" /* номер счета */
                            + "%-100s\t" /* вид депозита */
                            + "%s\t" /* номер договора */
                            + "%28.12f\t" /* пр. ставка */
                            + "%s\t" /* дата открытия */
                            + "%s\t"
                            + "%28.12f\t" /* входящий остаток вал сч */
                            + "%28.12f\t" /* входящий остаток рубли */
                            + "%s\t" /* дата закрытия    ??? */
                            + "%5s\t" /* количество дней до окончания */
                            + "%s\t" /* номер клиента банкир */
                            + "%7.0f\t" /* номер клиента  убрать 1 символ */
                            + "%s\t" /* дата ввода условий до последней пролонгации */
                            + "%s\t" /* дата реального закрытия договора ??? */
                            + "%7.0f\t" /* номер пролонгации */
                            + "%7.0f\t" /* код типового договора убрать 1 символ */
                            + "%7s\t" /* общий срок договора */
                            + "%7s\t" /* первоначальный срок договора ??? */
                            + "%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getString(9),
                            rs.getString(10), rs.getFloat(11), rs.getFloat(12), rs.getString(13), rs.getString(14),
                            rs.getString(15).trim(),rs.getFloat(16), rs.getString(17), rs.getString(18), rs.getFloat(19), rs.getFloat(20),
                            rs.getString(21), rs.getString(22)).toString();
                }
                writer.write(str);
            }

            System.out.println("4. deposit");
            writer.flush();
        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }

    }

}

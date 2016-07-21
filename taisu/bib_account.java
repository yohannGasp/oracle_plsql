/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import static taisu.Taisu.BIB_ACCOUNT;

/**
 *
 * @author akulov_ev
 */
public class bib_account extends DB implements CFT_Interface {

    public List<String> lines = new ArrayList<>();

    @Override
    public void to_file(String fileName) {
        String[] param = new String[3];
        ArrayList asd = new ArrayList();
        try {
            param[0] = util1.firstDataLastMonth();
            param[1] = util1.firstDataLastMonth();
            param[2] = util1.firstDataLastMonth();
            //param[1] = util1.Yesteday();
            ResultSet rs = Taisu.db.ResultSetPS(Taisu.db.SELECT_ACCOUNT_SQL, param);
                try (Formatter fmt = new Formatter(fileName, "Cp866")) {
                    while (rs.next()) {
                        if ((rs.getString(1).equals("40701810000000002385") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40701810100000002395") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40701810200000002428") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40701810300000002386") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40701810300000002412") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40701810500000002393") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40701810700000002397") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40701810900000002456") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002371") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002407") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002410") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002436") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002449") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002465") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002478") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810000000002481") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002349") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002365") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002378") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002381") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002404") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002420") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002433") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002459") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002462") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810100000002488") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810200000002359") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810200000002388") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810200000002391") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810200000002414") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810200000002443") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810200000002485") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810300000002398") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810300000002440") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810300000002482") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810400000002379") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810400000002382") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810400000002418") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810400000002421") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810400000002450") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810400000002463") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810500000002389") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810500000002392") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810500000002415") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810500000002431") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810500000002460") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810500000002473") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810600000002373") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810600000002441") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810600000002467") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810600000002470") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810700000002338") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810700000002406") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810700000002419") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810700000002435") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810700000002448") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810700000002464") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810700000002480") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002364") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002416") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002429") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002432") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002445") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002458") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002461") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810800000002474") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002361") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002374") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002387") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002400") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002439") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002442") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002455") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702810900000002468") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840000000042398") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840000000042424") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840100000022373") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840100000042379") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840400000042419") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840700000022391") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840800000022398") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840900000042375") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702840900000042414") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978000000042419") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978500000042414") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978600000022431") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978600000042398") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978600000042424") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978700000042379") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978800000022419") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978800000022435") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978800000022480") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978800000042415") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978800000042431") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40702978900000042373") & rs.getString(12).equals("5")) |
                            (rs.getString(1).equals("40802810100000000542") & rs.getString(12).equals("5")) |
                                    (rs.getString(1).equals("40702840000000022415") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840000000022431") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840200000022419") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840200000022435") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840200000022480") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840200000042415") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840200000042431") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840300000042373") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840400000022442") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840400000042435") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840400000042480") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840500000022436") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840500000022449") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840500000022478") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840500000022481") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840600000022365") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840600000042442") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840700000022414") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840700000042436") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840700000042449") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840700000042478") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840700000042481") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840800000042365") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840900000022379") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702840900000042391") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978000000022442") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978000000042435") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978000000042480") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978100000022436") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978100000022449") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978100000022478") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978100000022481") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978200000022365") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978200000042442") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978300000022391") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978300000022414") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978300000042436") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978300000042449") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978300000042478") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978300000042481") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978400000022398") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978400000042365") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978500000022379") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978500000042375") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978500000042391") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978600000022415") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("91203810700000000516") & rs.getString(12).equals("5"))
                                    | (rs.getString(1).equals("40702978700000022373") & rs.getString(12).equals("5"))) {
                            continue;
                        }
                        fmt.format("%s\t"    /* номер счета */
                            + "%s\t"           /* наименование счета */
                            + "%s\t"           /* номер счета */
                            + "%s\t"           /* дата открытия */
                            + "%s\t"           /* дата закрытия */
                            + "%s\t"           /* код валюты */
                            + "%s\t"           /* номер клиента банкир*/
                            + "%s\t"           /* номер клиента */
                            + "%s\t"           /* номер кредита */
                            + "%s\t"           /* тип кредита */
                            + "%s\t"           /* депозит */
                            + "%s\t"           /* номер отделения Число */
                            + "%s"             /* субконто */
                            + "%n", rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
                            rs.getString(6),rs.getString(7).trim(), rs.getString(8), rs.getString(9),
                            rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)).toString();
                    }
                }
            System.out.println("8. account " + param[0] + " - ");
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }

    }

    public boolean checkDouble() {
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(BIB_ACCOUNT), "Cp866"))) {
            String line;
            String acct;
            while ((line = reader.readLine()) != null) {
                acct = line.substring(0, 20).trim();
                if (lines.contains(acct)) {
                    System.out.println("ACCT " + acct);
                    result = true;
                    break;
                } else {
                    lines.add(acct);
                    result = false;
                }

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }


}

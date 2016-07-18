/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Formatter;

/**
 *
 * @author akulov_ev
 */
public class bib_client implements CFT_Interface {

    String normal(String str) {
        if (str != null) {
            str = str.trim();
        } else {
            str = "";
        }
        return str;
    }

    @Override
    public void to_file(String fileName) {
        try {
            ResultSet rs = Taisu.db.ResultSet(Taisu.db.SELECT_CLIENT_SQL);
            try (Formatter fmt = new Formatter(fileName, "Cp866")) {
                while (rs.next()) {
                    fmt.format("%s\t" // код банкира
                            + "%s\t" // ID
                            + "%s\t" // c_name
                            + "%s\t" // type_cl
                            + "%s\t" // c_inn
                            + "%s\t" // c_name
                            + "%s\t" // family
                            + "%s\t" // name_
                            + "%s\t" // lastName
                            + "%s\t" // Sex
                            + "%s" // Full name client
                            + "%n", rs.getString(1).trim(), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9).trim(), rs.getString(10),
                            rs.getString(11));
                }
            }
            System.out.println("3. client");
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }
    }
}

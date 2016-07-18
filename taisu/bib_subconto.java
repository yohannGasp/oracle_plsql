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
public class bib_subconto implements CFT_Interface {

    @Override
    public void to_file(String fileName) {
        try {
            ResultSet rs = Taisu.db.ResultSet(Taisu.db.SELECT_SUBCONTO_SQL);
            try (Formatter fmt = new Formatter(fileName, "Cp866")) {
                while (rs.next()) {
                    fmt.format("%s\t"
                            + "%s\t"
                            + "%-250s"
                            + "%n", rs.getString(1), rs.getString(2), rs.getString(3)).toString();
                }
            }
            System.out.println("1. subconto");
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }

    }
}

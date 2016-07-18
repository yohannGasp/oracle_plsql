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
public class bib_kredpos implements CFT_Interface{

    @Override
    public void to_file(String fileName) {
        try {
            ResultSet rs = Taisu.db.ResultSet(Taisu.db.SELECT_KREDPOS_SQL);
            try (Formatter fmt = new Formatter(fileName, "Cp866")) {
                while (rs.next()) {
                    fmt.format("%s\t" // ID
                            + "%s\t"  // Название ПОС
                            + "%s\t"  // Группа риска ПОС
                            + "%s\t"  // Процент резерва ПОС
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%s\t"  //
                            + "%n", rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(),
                                    rs.getString(5).trim(), rs.getString(6).trim(), rs.getString(7).trim(), rs.getString(8).trim(),
                                    rs.getString(9).trim(), rs.getString(10).trim(), rs.getString(11).trim(), rs.getString(12).trim(),
                                    rs.getString(13).trim(), rs.getString(14).trim());
                }
            }
            System.out.println("6. kredpos");
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }

    }

}

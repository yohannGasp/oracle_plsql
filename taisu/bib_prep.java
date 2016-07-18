/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.sql.SQLException;

/**
 *
 * @author akulov_ev
 */
public class bib_prep implements CFT_Interface {

    @Override
    public void to_file(String fileName) {
    }

    public void start_code(){
        try {
            Taisu.db.ExecProc(Taisu.db.PREP_SQL);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("0. inserting dogs");
    }

    public void finish_code(){
        try {
            Taisu.db.ExecProc(Taisu.db.FINISH_SQL);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("clear table");
    }
}

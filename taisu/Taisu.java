/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * connect to oracle
 *
 * @author akulov_ev (c) 2016
 */
public class Taisu {
    public static final String DIR = "out\\";
    public static final String BIB_ACCOUNT = "d:\\" + DIR + "bib_account.txt";
    public static final String BIB_BALANCE = "d:\\" + DIR + "bib_balance.txt";
    public static final String BIB_CLIENT = "d:\\" + DIR + "bib_client.txt";
    public static final String BIB_DEPDOG = "d:\\" + DIR + "bib_depdog.txt";
    public static final String BIB_KREDDOG = "d:\\" + DIR + "bib_kreddog.txt";
    public static final String BIB_KREDPOS = "d:\\" + DIR + "bib_kredpos.txt";
    public static final String BIB_ORDER = "d:\\" + DIR + "bib_order.txt";
    public static final String BIB_SUBCONTO = "d:\\" + DIR + "bib_subconto.txt";

    static DB db;


    public static void main(String[] args) throws IOException, ParseException, SQLException {
        db = new DB();
        db.Connection();
        db.queryAll();
        bib_prep bp = new bib_prep();
        bp.start_code();

        new bib_subconto().to_file(BIB_SUBCONTO); // ok
        new bib_client().to_file(BIB_CLIENT);     // ok
        new bib_depdog().to_file(BIB_DEPDOG);     // ok
        new bib_kreddog().to_file(BIB_KREDDOG);   // ok
        new bib_kredpos().to_file(BIB_KREDPOS);   // ok
        //new bib_order().to_file(BIB_ORDER);       // ok
        new bib_balance().to_file(BIB_BALANCE);   // ok
        new bib_account().to_file(BIB_ACCOUNT);   // ok

        bp.finish_code();
        db.Close();
        System.out.println("--------------------- ok ---------------------");
    }
}
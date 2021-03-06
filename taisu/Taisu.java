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
    public static final String DIR = "C:\\taisu\\out\\";
    public static final String ARCHIVE = "d:\\Archive\\";
    public static final String BIB_ACCOUNT  = DIR + "bib_account.txt";
    public static final String BIB_BALANCE  = DIR + "bib_balance.txt";
    public static final String BIB_CLIENT   = DIR + "bib_client.txt";
    public static final String BIB_DEPDOG   = DIR + "bib_depdog.txt";
    public static final String BIB_KREDDOG  = DIR + "bib_kreddog.txt";
    public static final String BIB_KREDPOS  = DIR + "bib_kredpos.txt";
    public static final String BIB_ORDER    = DIR + "bib_order.txt";
    public static final String BIB_SUBCONTO = DIR + "bib_subconto.txt";

    static DB db;

    public static void main(String[] args) throws IOException, ParseException, SQLException, InterruptedException {

        db = new DB(args[0]);
        db.Connection();
        db.queryAll();
        bib_prep bp = new bib_prep();
        bp.start_code();// заполняем временные таблицы

        new SubcontoThread();                       // ok
        new ClientsThread();                        // ok
        new DepdogThread();                         // ok
        new KreddogThread();                        // ok
        new KredPosThread();                        // ok
        new bib_order().to_file(BIB_ORDER);         // ok
        new bib_balance().to_file(BIB_BALANCE);     // ok
        new bib_account().to_file(BIB_ACCOUNT);     // ok

        bp.finish_code(); //чистим временные таблицы
        db.Close();
        System.out.println("-------------- ok --------------");
        Thread.sleep(5000);

        if (new bib_account().checkDouble()) {
            System.out.println("DOUBLE DOUBLE DOUBLE !!!! ");
        }

    }
}

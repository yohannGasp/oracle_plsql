/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

/**
 *
 * @author akulov_ev
 */
public class DB {

    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@172.25.1.50:1521:BIB_PROD";
    //private static final String CONNECTION_LOGIN = "sys as sysdba";
    private static final String CONNECTION_LOGIN = "ibs";
    //private static final String CONNECTION_PASSWORD = "sys";
    private static final String CONNECTION_PASSWORD = "ibs1223";

    private Connection conn;

    public String SELECT_ACCOUNT_SQL = "";
    public String SELECT_BALANCE_SQL = "";
    public String SELECT_CLIENT_SQL = "";
    public String SELECT_DEPDOG_SQL = "";
    public String SELECT_KREDDOG_SQL = "";
    public String SELECT_KREDPOS_SQL = "";
    public String SELECT_ORDER_SQL = "";
    public String PREP_SQL = "";
    public String FINISH_SQL = "";
    public String SELECT_SUBCONTO_SQL = "";

    private final static String currentDir = "d:\\проекты\\Выгрузка_Тайсу\\taisu\\src\\taisu\\sql\\";

    /* Singletone */
    Connection Connection() throws SQLException {
        if (this.conn == null) {
            java.sql.DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            this.conn = java.sql.DriverManager.getConnection(CONNECTION_STRING, CONNECTION_LOGIN, CONNECTION_PASSWORD);
            System.out.println("Connected to database!");
        }
        return this.conn;
    }

    /**
     * querySet
     *
     * @param Select_SQL - string query
     * @return ResultSet
     * @throws java.sql.SQLException
     */
    public ResultSet ResultSet(String Select_SQL) {
        ResultSet result = null;
        try {
            Statement statement = Connection().createStatement();
            result = statement.executeQuery(Select_SQL);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    /**
     * querySet for parameters
     *
     * @param Select_SQL - string query and parameters
     * @return ResultSet
     * @throws java.sql.SQLException
     */
    public ResultSet ResultSetPS(String Select_SQL,String[] param) throws SQLException {
        PreparedStatement pstmt = Connection().prepareStatement(Select_SQL);
        for (int i = 0; i < param.length; i++) {
            pstmt.setString(i+1,param[i]);
        }
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    /**
     * exec procedure in oracle
     *
     * @param SQL
     * @return ResultSet
     * @throws java.sql.SQLException
     */
    public ResultSet ExecProc(String SQL) throws SQLException {
        ResultSet result = null;
        try {
            Statement stmt = Connection().createStatement();
            stmt.executeQuery(SQL);
            if (stmt.getMoreResults()) {
                result = stmt.getResultSet();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    /**
     * close connection
     * @throws java.sql.SQLException
     */
    public void Close() throws SQLException{
        if (this.conn != null) {
            this.conn.close();
            System.out.println("disconnected database!");
        }
    }

    /**
     * queryfromFile
     *
     * @param fileName
     * @return String
     */
    private String queryfromFile(String fileName) {
        String Result = "";
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                Result += (char) c;
            }
        } catch (IOException ex) {
            Result += ex.getMessage();
        }
        return Result;
    }

    /**
     * queryAll
     */
    public void queryAll() {
        SELECT_ACCOUNT_SQL = queryfromFile(currentDir + "bib_account.sql");
        SELECT_BALANCE_SQL = queryfromFile(currentDir + "bib_balance.sql");
        SELECT_CLIENT_SQL = queryfromFile(currentDir + "bib_client.sql");
        SELECT_DEPDOG_SQL = queryfromFile(currentDir + "bib_depdog.sql");
        SELECT_KREDDOG_SQL = queryfromFile(currentDir + "bib_kreddog.sql");
        SELECT_KREDPOS_SQL = queryfromFile(currentDir + "bib_kredpos.sql");
        SELECT_ORDER_SQL = queryfromFile(currentDir + "bib_order.sql");
        PREP_SQL = queryfromFile(currentDir + "bib_prep.sql");
        FINISH_SQL = queryfromFile(currentDir + "finish.sql");
        SELECT_SUBCONTO_SQL = queryfromFile(currentDir + "bib_subconto.sql");
    }

    /*
    * universal function write to file
    * to_file
    * db.to_file(BIB_SUBCONTO, db.SELECT_SUBCONTO_SQL,new int[]{5,5,250}); // причесать
    */
    public void to_file(String fileName, String SQL,int[] column) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "Cp866");) {
            String st="";
            for (int i = 0; i < column.length; i++) {
                st += "%-"+column[i]+"s\t";
            }
            st += "%n";
            ResultSet rs = ResultSet(SQL);
            while (rs.next()) {
                String str="";
                try (Formatter fmt = new Formatter()) {
                    switch (column.length) {
                        case (1):str = fmt.format(st, rs.getString(1)).toString();break;
                        case (2):str = fmt.format(st, rs.getString(1), rs.getString(2)).toString();break;
                        case (3):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3)).toString();break;
                        case (4):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)).toString();break;
                        case (5):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)).toString();break;
                        case (6):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)).toString();break;
                        case (7):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)).toString();break;
                        case (8):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)).toString();break;
                        case (9):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)).toString();break;
                        case (10):str = fmt.format(st, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)).toString();break;
                    }
                }
                writer.write(str);
            }
            writer.flush();
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }

    }

}

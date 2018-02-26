package org.haohhxx.wechat.data;

import java.net.URL;
import java.sql.*;

/**
 * Created by admin on 2018/2/26.
 *
 */
public class SQLiteJDBC {
    public static void main( String args[] ) {
        URL url = SQLiteJDBC.class.getClassLoader().getResource("./db/");
        String file = url.getPath();
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:"+file+"dialog.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
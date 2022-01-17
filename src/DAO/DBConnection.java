package DAO;

import java.sql.*;

public class DBConnection {

    private static final DBConnection instance = new DBConnection();

    public DBConnection getInstance(){
        return instance;
    }

    public Connection getDBConnection(){
        final String DBNAME = "FinalTest";
        final String USER = "sa";
        final String PASS = "toiyeuban";
      //  var url = "jdbc:sqlserver://localhost:1433;databaseName = " +
        //        DBNAME + ";user = " + USER + ";pass = " + PASS + ";";
        String url = "jdbc:sqlserver://localhost:1433;databaseName = " + DBNAME;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,USER,PASS);
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}

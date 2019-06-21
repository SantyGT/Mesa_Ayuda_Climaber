
package com.demojsf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
    private static final String URL="jdbc:mysql://localhost:3306/solicitudes_cmb";
    private static final String USER="root";
    private static final String PASSWORD="estudiante";
    private static transient Connection connection=null;
    
    public static Connection getConnect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);
      return connection;
    }
    
}

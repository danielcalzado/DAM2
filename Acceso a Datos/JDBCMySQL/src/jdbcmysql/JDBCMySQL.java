/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbcmysql;


import java.sql.*;

/**
 *
 * @author profesor
 */
public class JDBCMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/empdept", "root", "");
        System.out.println("Conectado: " + !con.isClosed());
        con.close();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcmysql;

import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author profesor
 */
public class ActualizarSalarios {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost/empdept", "root", "");
            con.setAutoCommit(false);
            
            Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM EMP";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                double porcentaje = 0;
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                LocalDate hiredate = rs.getDate("hiredate").toLocalDate();
                double sal = rs.getDouble("sal");
                int deptno = rs.getInt("deptno");
                
                if (job.equals("MANAGER")) {
                    porcentaje = 10;
                } else if (hiredate.isBefore(LocalDate.of(1981, 9, 1))) {
                    porcentaje = 15;
                } else if (job.equals("ANALYST") && deptno == 20) {
                    porcentaje = 5;
                } else if (job.equals("SALESMAN")) {
                    porcentaje = 8;
                }
                
                if (porcentaje > 0) {
                    double calculo = sal * (1 + porcentaje / 100);
                    rs.updateDouble("sal", calculo);
                    rs.updateRow();
                }
                System.out.println(porcentaje + "%: " + ename);
                
            }
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // cerrar la conexion
        }
    }
}

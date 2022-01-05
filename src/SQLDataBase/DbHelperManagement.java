/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQLDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AFSAR
 */
public class DbHelperManagement {
    private String userName = "root";
    private String userPassword = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/factoryPersonnelPayrollSystem";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,userName,userPassword);
    }

    public void showErrorMassage(SQLException exception){
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error code: " + exception.getErrorCode());
    }
}

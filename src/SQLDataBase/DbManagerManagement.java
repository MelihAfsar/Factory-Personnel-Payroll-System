package SQLDataBase;

import factory.personnel.payroll.system.Employee;
import factory.personnel.payroll.system.Management;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*@author AFSAR*/
public class DbManagerManagement {
    public ArrayList<Management> selectDemo() throws SQLException {
        DbHelperManagement helper = new DbHelperManagement();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Management> managements = null;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id,name,surname,age"
                    + ",eMail,department,address,userName,userPassword from personnelmanagement.management");
            managements = new ArrayList<Management>();
            while (resultSet.next()) {
                managements.add(new Management(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("eMail"),
                        resultSet.getString("department"),
                        resultSet.getString("address"),
                        resultSet.getString("userName"),
                        resultSet.getString("userPassword")));              
            }
            System.out.println(managements.size());
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            connection.close();
            System.out.println("Connection closed.");
        }
        return managements;
    }
}

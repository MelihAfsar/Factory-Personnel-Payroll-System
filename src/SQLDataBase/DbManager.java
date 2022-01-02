package SQLDataBase;
/*@author AFSAR*/
import factory.personnel.payroll.system.Employee;
import java.sql.*;
import java.util.ArrayList;

public class DbManager {
    public static void deleteDemo()throws SQLException{
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            String sql = "delete from factoryPersonnelPayrollSystem.employee where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 8);
            int result = statement.executeUpdate();
            System.out.println("Personnel deleted.");
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("Connection closed.");
        }
    }
    
    public static ArrayList<Employee> selectDemo() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Employee> employees = null;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id,name,surname,gender,age"
                    + ",eMail,department,address,salary,grossSalary,tax,hourlyWage,workingHours from employee");
            employees = new ArrayList<Employee>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getString("eMail"),
                        resultSet.getString("department"),
                        resultSet.getString("address"),
                        resultSet.getDouble("salary"),
                        resultSet.getDouble("grossSalary"),
                        resultSet.getDouble("tax"),
                        resultSet.getDouble("hourlyWage"),
                        resultSet.getInt("workingHours")));                       
            }
            System.out.println(employees.size());
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            connection.close();
            System.out.println("Connection closed.");
        }
        return employees;
    }

    public static void insertData() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            String sql = "insert into factoryPersonnelPayrollSystem.employee(id,name,surname,gender,age"
                    + ",eMail,department,address,salary,grossSalary,tax,hourlyWage,workingHours) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,5);
            statement.setString(2,"Hakan");
            statement.setString(3,"Çelik");
            statement.setString(4,"male");
            statement.setInt(5,26);
            statement.setString(6,"hknclk@outlook.com");
            statement.setString(7,"Nakliye");
            statement.setString(8,"Karacabey");
            statement.setDouble(9,0.0);
            statement.setDouble(10,16000.0);
            statement.setDouble(11,0.0);
            statement.setDouble(12,40.0);
            statement.setInt(13,200);
            
            int result = statement.executeUpdate();
            System.out.println("Personnel added");
        } catch (SQLException exception) {
            System.out.println("You cannot add personnel with the same id !!!");
            helper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("Connection closed.");
        }
    }
    
    public static void updateData() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            String sql = "update factoryPersonnelPayrollSystem.employee set address= 'Orhaneli', tax=10.0 where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 2);
            int result = statement.executeUpdate();
            System.out.println("Personnel updated");
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("Connection closed.");
        }
    }
}




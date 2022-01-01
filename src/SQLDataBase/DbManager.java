package SQLDataBase;
/* @author AFSAR*/
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
            String sql = "delete from city where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4082);
            int result = statement.executeUpdate();
            System.out.println("Kayit Silindi");
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("Bağlanti kapatildi.");
        }
    }
/** Employee constructor a göre yazılacak.
    public static void selectDemo() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from Country");
            ArrayList<Employee> employees = new ArrayList<Employee>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(employees.size());
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            connection.close();
            System.out.println("Bağlanti kapatildi.");
        }
    }
*/
    public static void insertData() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            String sql = "insert into world.city(Name,Countrycode,District,Population) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Düzce4");
            statement.setString(2, "TUR");
            statement.setString(3, "TURKEY");
            statement.setInt(4, 90000);
            int result = statement.executeUpdate();
            System.out.println("Kayit Eklendi");
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("Bağlanti kapatildi.");
        }
    }
    
    public static void updateData() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            String sql = "update city set population=101, district='TUR' where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4082);
            int result = statement.executeUpdate();
            System.out.println("Kayit Güncellendi");
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("Bağlanti kapatildi.");
        }
    }
}




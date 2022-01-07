package factory.personnel.payroll.system;

import SQLDataBase.DbManager;
import java.sql.SQLException;
import java.util.ArrayList;
/*@author AFSAR*/
public class PersonManager {
    DbManager dbManager;
    
    public int[] totalPersonnelCounter(){
        dbManager = new DbManager();
        int[] total = new int[3];
        int totalPersonnel = 0;
        int totalFemalePersonnel = 0;
        int totalMalePersonnel = 0;
        try {    
             ArrayList<Employee> employees = dbManager.selectDemo();
             for (Employee employee: employees) {
                 if(employee.getGender().equals("female")){
                    totalFemalePersonnel +=1;
                    totalPersonnel +=1;
                 }
                 else{
                    totalMalePersonnel +=1;
                    totalPersonnel +=1;
                 }
             }
         } catch (SQLException ex) {}
        
        total[0] = totalPersonnel;
        total[1] = totalFemalePersonnel;
        total[2] = totalMalePersonnel;
        return total;
    } 
    
    public double totalSalaryPaid(){
        dbManager = new DbManager();
        double total = 0;
        try {    
             ArrayList<Employee> employees = dbManager.selectDemo();
             for (Employee employee: employees) {
                    total += employee.getSalary();
                }
            }catch (SQLException ex) {}
        return total;
    } 
}

package factory.personnel.payroll.system;
/*@author AFSAR*/
public class ManagementManager extends PersonManager{
    public static double salaryCalculator(double wageHourly, int hoursWorking, double salaryTax){
        double salary = 0;
        salary = ((wageHourly * hoursWorking) + salaryTax)*0.7;
        return salary;
    }
}

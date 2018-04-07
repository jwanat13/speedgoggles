/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author mjb6723
 */
public abstract class Employee {
    
    private final String firstName;
    private final String lastName;
    private final String ssn;
    
    
    public Employee(String fName, String lName, String socialSecurityNumber){
        firstName = fName;
        lastName = lName;
        ssn = socialSecurityNumber;
        
    }
    
    abstract public double earnings();
    abstract void raise(double percent);
    
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getSSN(){
        return this.ssn;
    }
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CommissionEmployee employee1 = new CommissionEmployee("Fred", "Jones", "111-11-1111", 2000.0, .05);
        BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Sue", "Smith", "222-22-2222", 3000.0, .05, 300);
        SalariedEmployee employee3 = new SalariedEmployee("Sha", "Yang", "333-33-3333", 1150.0);
        HourlyEmployee employee4 = new HourlyEmployee("Ian", "Tanning", "444-44-4444", 15.0, 50);
        HourlyEmployee employee5 = new HourlyEmployee("Angela", "Domchek", "555-55-5555", 20.0, 40);
        
        System.out.println("Employee information.");
        System.out.printf("%s%s%s%s%s%n", employee1, employee2, employee3, employee4, employee5);
        
        Employee[] employeeList = new Employee[]{employee1,employee2,employee3,employee4,employee5 };
        for(Employee element : employeeList){
            if(element instanceof SalariedEmployee){
                element.raise(.04);
            }
            else{
                element.raise(.02);
            }
        }
        System.out.println("Employee information after raises.");
        System.out.printf("%s%s%s%s%s", employee1, employee2, employee3, employee4, employee5);
        
    }
    
}










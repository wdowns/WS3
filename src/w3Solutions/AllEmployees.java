package w3Solutions;

import java.util.ArrayList;
/**
 *  The class is used to represent all Employees working for a company
 *  in an ArrayList of Employee.
 *  @author: Manfred Kerber
 *  @version: 2015-10-19
 */
public class AllEmployees {

    private ArrayList<Employee> allEmployees;

    /**
     *  The constructor does not have any arguments, since initially
     *  it is represented by the empty ArrayList of Employee.
     */
    public AllEmployees(){
        allEmployees = new ArrayList<Employee>();
    }

    /**
     *  The method adds an employee to the list of all Employees.
     *  Note, it does NOT check whether the employee is already in the list.
     *  @param employee The employee to be added to the list of all employees.
     */
    public void add(Employee employee){
        this.allEmployees.add(employee);
    }

    /**
     *  The method deletes an employee from the list of all Employees.
     *  Note, it does NOT check whether the employee is in the list.
     *  @param employee The employee to be deleted from the list of all employees.
     */
    public void delete(Employee employee){
        this.allEmployees.remove(employee);
    }

    /**
     *  The average monthly salary is computed by adding up all
     *  monthly salaries paid in the company and dividing the result
     *  by the total number of months that people have worked in the
     *  company.
     *  @return The average monthly salary paid in the company.
     */
    public double averageMonthlySalary(){
        double totalSalaries = 0.0;
        int totalMonths = 0;
        for (int i = 0; i < this.allEmployees.size(); i++){
            totalSalaries += this.allEmployees.get(i).annualSalary();
            totalMonths += this.allEmployees.get(i).monthsWorked();
        }
        //System.out.println("totalSalaries: " + totalSalaries);
        //System.out.println("totalMonths: " + totalMonths);
        return totalSalaries/totalMonths;
    }

    /**
     *  @return The list of all employees of the company as a string.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < this.allEmployees.size(); i++){
            result += this.allEmployees.get(i).toString() + "\n";
        }
        return result;
    }
    

    /*
     *  A main method with some test examples.
     */
    public static void main(String[] args) {
        double[] salaryMary = {1000, 1000, 1000,
                               0, 0, 0,
                               0, 0, 0,
                               0, 0, 1500};
        double[] salaryJohn = {1100, 1100, 1100,
                               1100, 1100, 1100,
                               1100, 1100, 1100,
                               1100, 1100, 1100};
        
        Employee mary = new Employee("Mary Smith", "CS Bham", salaryMary);
        Employee john = new Employee("John Smith", "CS Bham", salaryJohn);

        System.out.println(mary);

        System.out.println("**********************************************");
        AllEmployees acme = new AllEmployees();
        System.out.println("Empty employees list.");
        System.out.println(acme);
        System.out.println("**********************************************");
        acme.delete(mary);
        System.out.println("mary 'deleted' from empty list.");
        System.out.println(acme);
        System.out.println("**********************************************");
        acme.add(mary);
        System.out.println("mary added to list.");
        System.out.println(acme);
        System.out.println("**********************************************");
        acme.add(john);
        System.out.println("john added to list.");
        System.out.println(acme);
        System.out.println("**********************************************");
        acme.delete(mary);
        System.out.println("mary deleted from list.");
        System.out.println(acme);
        System.out.println("**********************************************");
        acme.add(mary);
        System.out.println("**********************************************");
        System.out.println("mary added to list.");
        System.out.println(acme);
        System.out.println("average monthly salary");
        System.out.println(acme.averageMonthlySalary());
    }
}

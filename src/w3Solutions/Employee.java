package w3Solutions;

/**
 *  The class is used to represent information about Employees in form
 *  of their name, address, and 12 monthly salaries given in an array
 *  of double.
 *  @author: Manfred Kerber
 *  @version: 2015-10-19
 */
public class Employee {

    private String name;
    private String address;
    private double[] salaries;

    /**
     * @param name The name of the employee.
     * @param address The address of the employee.
     * @param salaries The 12 monthly salaries of the employee as an array.
     *
     */
    public Employee(String name, String address, double[] salaries){
        this.name = name;
        this.address = address;
        this.salaries = salaries;
    }

    /**
     * @return The name of the employee.
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return The address of the employee.
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * @return The 12 monthly salaries of the employee as an array.
     *
     */
    public double[] getSalaries(){
        return this.salaries;
    }

    /**
     * @param name The new name of the employee.
     *
     */
    public void setName(String name){
         this.name = name;
    }

    /**
     * @param address The new address of the employee.
     *
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * @param salaries The new 12 monthly salaries of the employee as an array.
     *
     */
    public void setSalaries(double[] salaries){
        this.salaries = salaries;
    }

    /**
     * @return The total annual salary of the employee.
     */
    public double annualSalary() {
        double result = 0.0;
        for (double salary : this.salaries) {
            result += salary;
        }
        return result;
    }

    /**
     * @return The number of months the employee worked for the
     * company, that is, the number of months the employee had a
     * salary greater than 0.
     */
    public int monthsWorked() {
        int result = 0;
        for (double salary : this.salaries) {
            if (salary > 0) {
                result++;
            }
        }
        return result;
    }
    
    /**
     *  @param a A one dimensional array of type double.
     *  @return A string to print the array.
     */
    public static String toString(double[] a){
        String result = "";
	for (int i=0; i < a.length; i++){
	    result += a[i] + " ";
	}
        return result;
    }

    /**
     *  @return A String form for an employee consisting of name,
     *  address, and the 12 monthly salaries.
     */
    public String toString(){
        return this.getName() + " @ " + this.getAddress() + " earning " +
            toString(salaries);
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
                               1100, 1110, 1100,
                               1100, 1100, 1100};

    Employee mary = new Employee("Mary Smith", "CS Bham", salaryMary);
    Employee john = new Employee("John Smith", "CS Bham", salaryJohn);
    
    System.out.println(mary);
    System.out.println(mary.annualSalary());
    System.out.println(mary.monthsWorked());
    System.out.println(john);
    System.out.println(john.annualSalary());
    System.out.println(john.monthsWorked());
    }
}

import java.util.Arrays;

/** 
 *@author William Downs
 * @date 02/11/15
 */

/**
 * (a) An Employee is represented by their name (of type String), address (of type
 * String), and the 12 month salaries they receive during the tax year (of type
 * double[]). Write a class public class Employee with the usual ingredients (field
 * variables as specified above, constructor, getters, setters, and a toString 
 * method.
 */
public class Employee {

   private String name; // Instance fields
   private String address;
   private double [] salaries;
   
   
   public Employee (String name, String address, double[] salaries){// Constructor
	   
	   this.name = name; // Global names
	   this.address = address;
	   this.salaries = salaries;
	   
   }


public String getName() { // Getters
	return name;
}

public void setName(String name) { // Setters
	this.name = name;
}

public String getAddress() {
	return address;		
}

public void setAddress(String address) {
	this.address = address;
}

public double[] getSalaries() {
	return salaries;
}

public void setSalaries(double[] salaries) {
	this.salaries = salaries;
}
public double annualSalary() {
	double totalSalary = 0.0;
	for (double s : salaries ){
		totalSalary += s;
	}
	return 0.0;
	
}
public int monthsWorked() {
	
	return 0;

}
@Override
public String toString() { // toString method
	return "Empoyee [name=" + name + ", address=" + address + ", salaries="
			+ Arrays.toString(salaries) + "]";
     }
}




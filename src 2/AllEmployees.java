import java.util.ArrayList;
    /**
	 * (b) Write a class public class AllEmployees, which is used to represent the
	 * employees on the payroll of a company. Use a variable ArrayList<Empoloyee>
	 * allEmployees for the representation of the employees of the company. In 
	 * addition to a constructor and a toString method write the following methods:
	 */
	public class AllEmployees{
		
		private ArrayList<Employee> allEmployees; // Definition
		
			
			public AllEmployees (){ // Constructor
				
				// Instantiation
				allEmployees = new ArrayList<>(); // Diamond operator
			}

			public ArrayList<Employee> getAllEmployees() {
				return allEmployees;
			}

			public void setAllEmployees(ArrayList<Employee> allEmployees) {
				this.allEmployees = allEmployees;
			}

			@Override
			public String toString() {
				return "AllEmployees [allEmployees=" + allEmployees + "]";
			}
			
		public void add(Employee employee) {
			
			allEmployees.add(employee);
			
		}
		public void delete(Employee employee){
			allEmployees.remove(employee);
		}
		
		public double averageMonthlySalary(){
			double totalAnnualSalary = 0.0; 
			double		totalMonthlySalary = 0.0;
			
			for (Employee e : allEmployees){
				totalAnnualSalary += e.annualSalary();
			    totalMonthlySalary += e.monthsWorked();
			}
		
		return  totalAnnualSalary / totalMonthlySalary;
				
		}		
   }


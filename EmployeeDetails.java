package project;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeDetails implements CommonDetails,Comparator<Employee> {

	private List<Employee> employees;
	private Scanner scanner;
	
	
	public EmployeeDetails(List<Employee> employees, Scanner scanner) {	
		this.employees = employees;
		this.scanner = scanner;
	}
     @Override
	public void add() {
		Employee e = readEmployeeDetails();
		if(Objects.nonNull(e))
			employees.add(e);
	}
	
	private Employee readEmployeeDetails() {
		System.out.println("Enter the employee id");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the employee name");
		String name = scanner.nextLine();
		
		System.out.println("Enter the employee salary");
		double salary = scanner.nextDouble();
		
		System.out.println("Enter the employee mobile number");
		long mobile = scanner.nextLong();
		
		System.out.println("Enter the empployee email");
		String email = scanner.next();
		
		//check if email is valid
		if(!email.contains("@")) {
			System.out.println("Invalid Email, Idiot enter proper email id");
			return null;
		}			
		
		return new Employee(id, name, salary, mobile, email);
	}
	 @Override
	public void remove() {
		System.out.print("Enter Employee ID to remove: ");
	    int empId = scanner.nextInt();
	    scanner.nextLine(); 

	    boolean removed = false;

	    for(Employee emp : employees) {
            if (emp.getId() == empId) {
            	employees.remove(empId);
	            System.out.println("Employee with ID " + empId + " removed successfully!");
	            removed = true;
	            break;
	        }
	    }

	    if (!removed) {
	    	try {
        		throw new InvailIdException("ID "+ empId + " not found" );
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
	    }
	}
	 @Override
	public void display() {
		System.out.println("id+\tname\tsalary\tmobile\temail");
		System.out.println("-------------------------------------------------");
		
		for(Employee e : employees) {
			System.out.println(e);
		}
		
	}
	 @Override
	public void sort() {
		    System.out.println("Choose sorting order:");
		    System.out.println("1. Ascending");
		    System.out.println("2. Descending");
		    sortOrder = scanner.nextInt();
		    System.out.println("Choose sorting criteria:");
		    System.out.println("1. ID");
		    System.out.println("2. Name");
		    System.out.println("3. Salary");
		    sortCriteria = scanner.nextInt();
		    employees.sort(this);
		    System.out.println("Employees after sorting:");
		    display();
		    
	}
	 
	
	 @Override
	public void update() {
		System.out.println("1.Mobile\n2Email");
		System.out.println("Enter your choice");
		int ch = scanner.nextInt();
		
		
		if (ch == 1) {
		System.out.print("Enter Employee ID to update Mobile: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Mobile Number: ");
        long newMobile = scanner.nextLong();
     
        boolean found = false;
        for(Employee emp : employees) {
            if (emp.getId() == empId) {
            	emp.setMobile(newMobile);
                System.out.println("Mobile updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
        	try {
        		throw new InvailIdException("ID "+ empId  + "not found" );
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
            
            
        }
	}
    
    else if (ch == 2) {
        System.out.print("Enter Employee ID to update Email: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new Email: ");
        String newEmail = scanner.nextLine();

        boolean found = false;
        for(Employee emp : employees) {
            if (emp.getId() == empId) {
            	emp.setEmail(newEmail);
                System.out.println("Email updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found!");
        }
    } 
    else {
        System.out.println("Invalid choice");
    }
}
	 private int sortOrder ;
	 private int sortCriteria ;
	 @Override
	 public int compare(Employee o1, Employee o2) {
		    int result = 0;

		    switch (sortCriteria) {
		        case 1:
		            result = Integer.compare(o1.getId(), o2.getId());
		            break;
		        case 2:
		            result = o1.getName().compareTo(o2.getName());
		            break;
		        case 3:
		            result = Double.compare(o1.getSalary(), o2.getSalary());
		            break;
		        default:
		            throw new IllegalArgumentException("Invalid sorting criteria");
		    }

		    if (sortOrder == 2) {
		        result = -result;
		    }

		    return result;
		}

}

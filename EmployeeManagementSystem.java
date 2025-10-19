package project;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EmployeeDetails details = new EmployeeDetails(new ArrayList<Employee>(), scanner);
		
		while(true) {
			System.out.println("1.Add\n2.Remove\n3.Update\n4.Display\n5.Sort\n6.Exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			
			switch(choice) {
				case 1: details.add();
						break;
						
				case 2: details.remove();
						break;
						
				case 3: details.update();
						break;
						
				case 4: details.display();
						break;
						
				case 5: details.sort();
						break;
						
				case 6: System.exit(0);
				
				default : System.out.println("Invalid Choice");	
			}
		}
	}
}

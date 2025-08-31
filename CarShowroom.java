package project;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CarShowroom  {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	CarServiceScript car = new CarServiceScript(new ArrayList<Map<String,Object>>(), sc);
	
	while(true) {
		System.out.println("1.Add\n2.Remove\n3.update\n4.view\n5.sort\n6.Exit");
		System.out.println("Enter your choice");
		int ch= sc.nextInt();
		switch (ch) {
		case 1: car.addCar();
			break;
		case 2: car.removeCar();
			break;
		case 3: car.updateCar();
			break;
		case 4: car.viewCar();
			break;
		case 5: car.sortCar();
			break;
		case 6: System.exit(0);	
		default:
			System.out.println("Invalid choice");
		}
	}
}
}

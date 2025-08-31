package project;


import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarServiceScript implements CarService {

	List<Map<String, Object>> map;
	Scanner sc ;
	public CarServiceScript(List<Map<String, Object>> map, Scanner sc) {
		super();
		this.map = map;
		this.sc = sc;
	}

	
	
	@Override
	public void addCar() {
		Map<String, Object> Car= readDetails();
		map.add(Car);
		
	}

	 @Override
	    public void removeCar() {
	        System.out.print("Enter Car Number to remove: ");
	        String carNo = sc.next();
            boolean removed=false;
	        Iterator<Map<String, Object>> it = map.iterator();
	        while (it.hasNext()) {
	            Map<String, Object> car = it.next();
	            if (car.get("num").equals(carNo)) {
	                it.remove();  
	                removed = true;
	                break; 
	            }
	        }


	        if (removed) {
	            System.out.println("Car removed successfully!");
	        } else {
	            System.out.println("Car not found!");
	        }
	    }

	    @Override
	    public void updateCar() {
	        System.out.print("Enter Car Number to update: ");
	        String carNo = sc.next();
	        boolean found = false;
	        for (Map<String, Object> car : map) {
	            if (car.get("num").equals(carNo)) {
	                System.out.print("Enter new Price: ");
	                double newPrice = sc.nextDouble();
	                car.put("price", newPrice);

	                System.out.print("Enter new Color: ");
	                String newColor = sc.next();
	                car.put("color", newColor);

	                found = true;
	                System.out.println("Car details updated successfully!");
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("Car not found!");
	        }
	    }

	    @Override
	    public void viewCar() {
	        if (map.isEmpty()) {
	            System.out.println("No cars available!");
	            return;
	        }

	        System.out.println("----- Car Details -----");
	        for (Map<String, Object> car : map) {
	            for (Map.Entry<String, Object> entry : car.entrySet()) {
	                System.out.println(entry.getKey() + " : " + entry.getValue());
	            }
	            System.out.println("-----------------------");
	        }
	    }
	    	@Override
	    	public void sortCar() {
	    	    if (map.isEmpty()) {
	    	        System.out.println("No cars available to sort!");
	    	        return;
	    	    }
	    	    System.out.println("1.Number\n2.Price\n3.Color");
	    	    System.out.println("Enter the choice");
	    	    int ch=sc.nextInt();
	    	
	    	    switch(ch)
	    	    {
	    	    case 1: Collections.sort(map, new Comparator<Map<String, Object>>() {
	    	                @Override
	    	                public int compare(Map<String, Object> c1, Map<String, Object> c2) {
	    	                    return c1.get("num").toString().compareTo(c2.get("num").toString());
	    	                }
	    	            });
	    	    case 2:Collections.sort(map, new Comparator<Map<String, Object>>() {
	                @Override
	                public int compare(Map<String, Object> c1, Map<String, Object> c2) {
	                    return c1.get("price").toString().compareTo(c2.get("price").toString());
	                }
	            });
	    	    case 3:Collections.sort(map, new Comparator<Map<String, Object>>() {
	                @Override
	                public int compare(Map<String, Object> c1, Map<String, Object> c2) {
	                    return c1.get("color").toString().compareTo(c2.get("color").toString());
	                }
	            });
	    	            
	    	    }    
	    	    
	    	    System.out.println("cars after sorting");
	    	    viewCar();
	    	       
	        }

	        
	public Map<String, Object> readDetails() {
		System.out.println("Enter the Car Number");
		String num = sc.next();
		System.out.println("Enter the Car Name");
		String name = sc.next();
		System.out.println("Enter the Car color");
		String color = sc.next();
		System.out.println("Enter the Car brand");
		String brand = sc.next();
		System.out.println("Enter the Car price");
		double price = sc.nextDouble();
		System.out.println("Enter the Car year");
		int year = sc.nextInt();
		Map<String, Object> Car = new LinkedHashMap<String, Object>();
		Car.put("num", num);
		Car.put("name", name);
		Car.put("color", color);
		Car.put("brand", brand);
		Car.put("price", price);
		Car.put("year", year);
		
		return Car;
	}



	

}

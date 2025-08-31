package project;


public class Car {
   private String num;
   private String name;
   private String color;
   private String brand;
   private Double price;
   private Integer year;

public Car(String num, String name, String color, String brand, Double price, Integer year) {
	super();
	this.num = num;
	this.name = name;
	this.color = color;
	this.brand = brand;
	this.price = price;
	this.year = year;
}

public String getNum() {
	return num;
}

public void setNum(String num) {
	this.num = num;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Integer getYear() {
	return year;
}

public void setYear(Integer year) {
	this.year = year;
}

@Override
public String toString() {
	return "Car [num=" + num + ", name=" + name + ", color=" + color + ", brand=" + brand + ", price=" + price
			+ ", year=" + year + "]";
}

}

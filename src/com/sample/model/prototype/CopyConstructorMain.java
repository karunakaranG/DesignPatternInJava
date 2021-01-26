package com.sample.model.prototype;

class Addres{
	public String streetAddress,city,country;

	public Addres(String streetAddress, String city, String country) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
	}
	
	public Addres(Addres other) {
		this(other.streetAddress,other.city,other.country);
	}

	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", city=" + city + ", country=" + country + "]";
	}
	
	
}

class Employee{
	public String name;
	public Addres address;
	public Employee(String name, Addres address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Employee(Employee emp) {
		name=emp.name;
		address=new Addres(emp.address);
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}
	
	
	
}

public class CopyConstructorMain {

	public static void main(String[] args) {
		Employee john = new Employee("john",new Addres("123 London road","London","UK"));
		Employee chris=new Employee(john);
		chris.name="chris";
		chris.address.country="IN";
		System.out.println(john);
		System.out.println(chris);
	}

}

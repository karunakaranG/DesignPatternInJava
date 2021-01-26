package com.sample.model.prototype;

import java.util.Arrays;
//deep copy if module gets large then cloneable makes little complicated  so dont use for object cpy

//shallow copy
class Address implements Cloneable{
	public String streetName;
	public int houseNumber;
	
	public Address(String streetName, int houseNumber) {
		super();
		this.streetName = streetName;
		this.houseNumber = houseNumber;
	}

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", houseNumber=" + houseNumber + "]";
	}
	
	//deep copy
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Address(streetName,houseNumber);
	}
	
}

class Person implements Cloneable{
	public String [] names;
	
	public Address address;

	public Person(String[] names, Address address) {
		super();
		this.names = names;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Person(names.clone(),(Address)address.clone());
	}
	
	
	
}
public class DontUseClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		
   Person john =new Person(new String[] {"john","smith"},new Address("London road",123));
	
	Person jane =(Person)john.clone();
	jane.names[0]="jane";
	jane.address.houseNumber=124;
	
	System.out.println(john);
	System.out.println(jane);
	}

}

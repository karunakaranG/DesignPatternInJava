package com.sample.model.creational.builder;

//builder inheritance with recursive generics

class Person{
	private String name;
	private String position;
	
	Person(){
		
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", position=" + position + "]";
	}
	
}
//person builder gone a take a type argument but that type argument must be some inherited feature of person builder

class PersonBuilder<SELF extends PersonBuilder<SELF>>{
	protected Person p=new Person();
	
	//As we are providing an argument of Employee Builder in line 56 PersonBuilder we use SELF as to indicate EmployeeBUilder
	public SELF addPersonName(String name) {
		p.setName(name);
		return self();
	}
	public Person getPerson() {
		return p;
	}
	
	protected SELF self() {
		return (SELF)this;
	}
}

//As a recursive call we are providing Employee builder as a argument for person builder
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
	
	public EmployeeBuilder workAs(String workPosition) {
		p.setPosition(workPosition);
		return self();
	}
	
	protected EmployeeBuilder self() {
		return this;
	}
	
}
public class FluentBuilderInheritence {
	

	public static void main(String[] args) {
		
		EmployeeBuilder pd=new EmployeeBuilder();
		pd.addPersonName("karuna")
		.workAs("software developer");
		System.out.println(pd.getPerson().toString());

	}

}

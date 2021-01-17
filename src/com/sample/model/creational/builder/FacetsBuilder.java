package com.sample.model.creational.builder;

class Person1{

	//address
	public String streetAddress,pinCode,state;
	
	//location
	public String companyName,position;
	public int annualIncome;
	
	
	@Override
	public String toString() {
		return "Person [streetAddress=" + streetAddress + ", pinCode=" + pinCode + ", state=" + state + ", companyName="
				+ companyName + ", position=" + position + ", annualIncome=" + annualIncome + "]";
	}
	
	
}

//builder facade
class PersonBuilder1
{
// the object we're going to build
protected Person1 person = new Person1(); // reference!

public PersonJobBuilder works()
{
 return new PersonJobBuilder(person);
}

public PersonAddressBuilder lives()
{
 return new PersonAddressBuilder(person);
}

public Person1 build()
{
 return person;
}
}


class PersonJobBuilder extends PersonBuilder1
{
  public PersonJobBuilder(Person1 person)
  {
    this.person = person;
  }

  public PersonJobBuilder at(String companyName)
  {
    person.companyName = companyName;
    return this;
  }

  public PersonJobBuilder asA(String position)
  {
    person.position = position;
    return this;
  }

  public PersonJobBuilder earning(int annualIncome)
  {
    person.annualIncome = annualIncome;
    return this;
  }
}


class PersonAddressBuilder extends PersonBuilder1
{
  public PersonAddressBuilder(Person1 person)
  {
    this.person = person;
  }

  public PersonAddressBuilder at(String streetAddress)
  {
    person.streetAddress = streetAddress;
    return this;
  }

  public PersonAddressBuilder withPostcode(String pincode)
  {
    person.pinCode = pincode;
    return this;
  }

  public PersonAddressBuilder in(String state)
  {
    person.state = state;
    return this;
  }
}




public class FacetsBuilder {
	
	  public static void main(String[] args)
	  {
	    PersonBuilder1 pb = new PersonBuilder1();
	    Person1 person = pb
	      .lives()
	        .at("123 London Road")
	        .in("London")
	        .withPostcode("SW12BC")
	      .works()
	        .at("Fabrikam")
	        .asA("Engineer")
	        .earning(123000)
	      .build();
	    System.out.println(person);
	  }

}

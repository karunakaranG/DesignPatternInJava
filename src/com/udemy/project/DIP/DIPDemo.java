package com.udemy.project.DIP;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// A. High-level modules should not depend on low-level modules. 
// Both should depend on abstractions.

// B. Abstractions should not depend on details. 
// Details should depend on abstractions.

enum Relationship
{
  PARENT,
  CHILD,
  SIBLING
}

class Person
{
  public String name;
  // dob etc.


  public Person(String name) {
    this.name = name;
  }
}

class PersonInfo{
	public Person person1;
	public Relationship relationship;
	public Person person2;
	
	public PersonInfo(Person p1,Relationship r1,Person p2) {
		this.person1=p1;
		this.relationship=r1;
		this.person2=p2;
	}

	@Override
	public String toString() {
		return "PersonInfo [person1=" + person1 + ", relationship=" + relationship + ", person2=" + person2 + "]";
	}
	
}

interface RelationshipBrowser
{
  List<PersonInfo> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser
{
	 // Triplet class requires javatuples
	  private List<PersonInfo> relations = new ArrayList<>();

	
  public List<PersonInfo> findAllChildrenOf(String name) {

    return relations.stream()
      .filter(x -> x.person1.name.equals(name)
              && x.relationship == Relationship.PARENT).collect(Collectors.toList());
  }

 
  public List<PersonInfo> getRelations() {
    return relations;
  }

  public void addParentAndChild(Person parent, Person child)
  {
	  
    relations.add(new PersonInfo(parent, Relationship.PARENT, child));
    relations.add(new PersonInfo(child, Relationship.CHILD, parent));
  }
}

class NewRelationship implements RelationshipBrowser{

	@Override
	public List<PersonInfo> findAllChildrenOf(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Research
{
	public Research(Relationships relationships) { 
		// high-level: find all ofjohn's children 
		List<PersonInfo> relations =
		relationships.getRelations();
		relations.stream().filter(x -> x.person1.name.equals("John") && x.relationship == Relationship.PARENT)
				.forEach(ch -> System.out.println("John has a child called " + ch.person2.name));
	}

  public Research(RelationshipBrowser browser)
  {
	 
    List<PersonInfo> children = browser.findAllChildrenOf("John");
    System.out.println(children.toString());
    for (PersonInfo child : children)
      System.out.println("John has a child called " + child.person2.name);
  }
}

class DIPDemo
{
  public static void main(String[] args)
  {
    Person parent = new Person("John");
    Person child1 = new Person("Chris");
    Person child2 = new Person("Matt");

    // low-level module
    Relationships relationships = new Relationships();
    relationships.addParentAndChild(parent, child1);
    relationships.addParentAndChild(parent, child2);
    
    //By passing the interface you are creating the opportunity to pass all the classes which implements the interface.
    //In our case we are passing two difference object which implements RelationshipBrowser
    NewRelationship newrelation= new NewRelationship();
    new Research(relationships);
    new Research(newrelation);
  }
}

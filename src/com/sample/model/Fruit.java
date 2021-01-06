package com.sample.model;

public class Fruit implements Comparable<Object>{
	
	private String name;
	private String description;
	private int price;
	private int quantity;
	
	
	
	public Fruit(String name, String description, int price, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Fruit [name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
	  @Override public int compareTo(Object o) { Fruit obj=(Fruit)o; return
	  this.price-obj.price; }
	 
	

}

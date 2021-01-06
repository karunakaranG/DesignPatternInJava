package com.udemy.project.OCP;

public class SizeSpecification implements Specification<Product> {
	
	private Size s1;
	
	SizeSpecification(Size s2){
		this.s1=s2;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return this.s1==item.size;
	}
	
	

}

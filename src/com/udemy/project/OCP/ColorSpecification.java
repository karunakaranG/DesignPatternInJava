package com.udemy.project.OCP;

public class ColorSpecification implements Specification<Product>{
	
	private Color color;
	
	public ColorSpecification(Color color){
		this.color=color;
	}

	

	@Override
	public boolean isSatisfied(Product item) {
		return this.color==item.color;
	}

}

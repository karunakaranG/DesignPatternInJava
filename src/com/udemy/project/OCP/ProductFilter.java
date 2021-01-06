package com.udemy.project.OCP;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {
	
	public static Stream<Product> productFilterByColor(List<Product>products, Color color) {
		
		return products.stream().filter(p -> (p.color==color));
		
	}
	
	public static Stream<Product> productFilterBySize(List<Product>products,Size size){
		return products.stream().filter(p -> (p.size==size));
	}

}

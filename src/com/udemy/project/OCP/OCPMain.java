package com.udemy.project.OCP;

import java.util.ArrayList;
import java.util.List;

public class OCPMain {

	public static void main(String[] args) {
		Product apple=new Product("apple",Color.RED,Size.MEDIUM);
		Product papaya=new Product("papaya",Color.GREEN,Size.SMALL);
		Product dress=new Product("cloths",Color.BLUE,Size.LARGE);
		
		List<Product> products=List.of(apple,papaya,dress);
		//ProductFilter.productFilterByColor(products, Color.BLUE).forEach(a -> {System.out.println(a.toString());});
		//ProductFilter.productFilterBySize(products, Size.SMALL).forEach(a -> {System.out.println(a.toString());});
	
		BetterFilter b=new BetterFilter();
		b.filter(products, new AndSpecification<>(
		        new ColorSpecification(Color.BLUE),
		        new SizeSpecification(Size.LARGE)
		      )).forEach(c -> {System.out.println(c.toString());});
	
	}

}

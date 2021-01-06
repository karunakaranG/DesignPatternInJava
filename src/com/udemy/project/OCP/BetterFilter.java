package com.udemy.project.OCP;

import java.util.List;
import java.util.stream.Stream;

public class BetterFilter implements Filter<Product> {

	@Override
	public  Stream<Product> filter(List<Product> item, Specification<Product> s) {
		return item.stream().filter(p -> s.isSatisfied(p));
		
	}

	

}

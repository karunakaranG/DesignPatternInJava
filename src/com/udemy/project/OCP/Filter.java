package com.udemy.project.OCP;

import java.util.List;
import java.util.stream.Stream;

public interface Filter <T>{
	
	public Stream<T> filter(List<T> item, Specification <T> s);

}

package com.udemy.project.OCP;

public class AndSpecification<T> implements Specification<T>{

	  private Specification<T> color, size;

	  public AndSpecification(Specification<T> color, Specification<T> size) {
	    this.color = color;
	    this.size = size;
	  }

	  @Override
	  public boolean isSatisfied(T item) {
	    return color.isSatisfied(item) && size.isSatisfied(item);
	  }

	

}

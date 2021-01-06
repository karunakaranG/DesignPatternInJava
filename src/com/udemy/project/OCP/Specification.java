package com.udemy.project.OCP;

public interface Specification <T>{

	public boolean isSatisfied(T item);
}

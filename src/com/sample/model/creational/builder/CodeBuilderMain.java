package com.sample.model.creational.builder;

public class CodeBuilderMain {

	public static void main(String[] args) {
		CodeBuilder cb =new CodeBuilder("Person").addField("name","String").addField("age","int");
		System.out.println(cb.toString());
		
		HashMapCodeBuilder hmcb =new HashMapCodeBuilder("Person").addField("name","String").addField("age","int");
		System.out.println(hmcb);
	}

}

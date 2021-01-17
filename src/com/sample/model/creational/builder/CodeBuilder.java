package com.sample.model.creational.builder;

import java.util.ArrayList;
import java.util.Collections;

class CodeElement{
	public String name,type;
	
	public ArrayList<CodeElement> elements =new ArrayList<>();
	
	private final int indentSize =2;
	
	private final String newLine=System.lineSeparator();
	
	public CodeElement() {
		
	}
	
	public CodeElement(String name, String type) {
		this.name=name;
		this.type=type;
	}
	

	private String toStringImpl() {
		
		StringBuilder sb= new StringBuilder();
		String indentspace = String.join("",Collections.nCopies(indentSize," "));
		sb.append(String.format("%s %s %s %s","public","class",name,newLine));
		sb.append(String.format("%s %s","{",newLine));
		
		
		for(CodeElement e: elements) {
			sb.append(String.format("%s %s %s %s",indentspace,e.type,e.name+";",newLine));
		}
		
		sb.append(String.format("%s %s","}",newLine));
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return toStringImpl();
	}
	
	
}

public class CodeBuilder {
	
	private String rootName;
	CodeElement root=new CodeElement();

    public CodeBuilder(String className)
    {
    	this.rootName=className;
		root.name=className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
    	CodeElement e = new CodeElement(name, type);
	    root.elements.add(e);
	    return this;
    }
    
    @Override
    public String toString()
    {
    	return root.toString();
    }

}

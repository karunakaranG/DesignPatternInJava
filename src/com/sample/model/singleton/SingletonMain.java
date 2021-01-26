package com.sample.model.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BasicSingleton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9101627139033192913L;

	private static final BasicSingleton INSTANCE=new BasicSingleton(); 
	
	private int value=0;
	
	
	private BasicSingleton() {
		
	}
	
	public static BasicSingleton getInstance() {
		return INSTANCE;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	//solution to singleton while serialization
	//we are giving hint to jvm while serialization read object through the instance
	protected Object readResolve() {
		return INSTANCE;
	}
	
	
	
}
public class SingletonMain {

	//problem 1 : using reflection you can defect the private constructor and create the object
	//problem 2 : using serialization -> when we deserialize the object it will call the constructor to build the class 
	
	
	static void saveToFile(BasicSingleton singleton,String filename) throws Exception {
		
		try(FileOutputStream fileout=new FileOutputStream(filename);
			ObjectOutputStream out=new ObjectOutputStream(fileout))
		{
			out.writeObject(singleton);
		}
		
	}
	
	
	static BasicSingleton readFromFile(String fileName) throws Exception{
		try(FileInputStream fileIn=new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fileIn)){
			return (BasicSingleton) in.readObject();
		}
	}
	public static void main(String[] args) throws Exception{
		BasicSingleton bs=BasicSingleton.getInstance();
		bs.setValue(111);
		//System.out.println(bs.getValue());
		String fileName="singleton.bin";
		saveToFile(bs,fileName);
		bs.setValue(222);
		BasicSingleton bs1=readFromFile(fileName);
		System.out.println(bs == bs1);
		System.out.println(bs.getValue());
		System.out.println(bs1.getValue());
		
	}

}

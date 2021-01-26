package com.sample.model.singleton;

import java.io.File;
import java.io.IOException;

class StaticBlockSingleton{
	
	private static StaticBlockSingleton instance;
	
	private StaticBlockSingleton() throws IOException {
		System.out.println("Singleton is intializing");
		File.createTempFile(".", ".");
	}
	
	static {
		try {
			instance = new StaticBlockSingleton();
		}
		catch(Exception e) {
			System.err.println("Failed to create singleton");
		}
	}
	
	public static StaticBlockSingleton getInstance() {
		return instance;
	}
}
public class StaticBlockSingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

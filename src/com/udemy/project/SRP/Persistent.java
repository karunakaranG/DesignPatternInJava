package com.udemy.project.SRP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Persistent {
	
	//save to a file
	//load from file
	//load from url
	
	public void saveToFile(Journel j, String fileName){
		
		try(FileOutputStream o=new FileOutputStream(new File(fileName))){
			
			ObjectOutputStream out=new ObjectOutputStream(o);
			out.writeObject(j);
			out.close();
		}catch(FileNotFoundException ex) {
			System.out.println("File not found in your workspace");
		}catch(IOException ex) {
			System.out.println("Unable to perform IO Operation inside file");
		}
		
	}

}

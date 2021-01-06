package com.udemy.project.SRP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JournelMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Journel j=new Journel();
		j.addJournel("I am fucked up");
		j.addJournel("Need to improve a lot");
		j.addJournel("Have a persistent Goal in my Life");
		System.out.println(j.toString());
		
		Persistent p =new Persistent();
		String fileName="c:\\temp\\journal.txt";
		p.saveToFile(j, fileName);
		
		Runtime.getRuntime().exec("notepad.exe " + fileName);

	}

}

package com.udemy.project.SRP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Journel implements Serializable{
	
	
	private static final long serialVersionUID = 2716834519951327475L;
	
	public final List<String> journels =new ArrayList<String>();
	public static int count=0;
	
	public void addJournel(String s) {
		journels.add(" "+(++count)+" : "+ s);
	}
	public void removeJournel(int index) {
		journels.remove(index);
	}
	@Override
	public String toString() {
		return String.join(System.lineSeparator(), journels);
	}

}

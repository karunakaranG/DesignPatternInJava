package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.sample.model.Fruit;

public class SampleProject {
	public static List<Fruit> getFruitsFilterByPrice(List<Fruit> fruits){
		return fruits.stream().filter(f->f.getPrice()>20).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		List<Fruit> fruits=new ArrayList<Fruit>();
		
		fruits.add(new Fruit("orange","orange desc",30,9));
		fruits.add(new Fruit("lemon","lemon desc",45,5));
		fruits.add(new Fruit("pomogranate","pomogranate desc",20,3));
		fruits.add(new Fruit("apple","apple desc",70,2));
		//Collections.sort(fruits,new SortByName());
		//Collections.sort(fruits,(o1,o2)-> {return o1.getPrice()-o2.getPrice();});
		//Comparator<Fruit> cmp=Comparator.comparing(Fruit::getName);
		//Collections.sort(fruits,cmp);
		//fruits.forEach(f->System.out.println(f));
		List<Fruit> FilterFruit=getFruitsFilterByPrice(fruits);
		FilterFruit.forEach(System.out::println);
	}

}



class SortByName implements Comparator<Fruit>{

	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

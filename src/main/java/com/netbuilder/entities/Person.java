package com.netbuilder.entities;

import java.util.ArrayList;

public class Person {
	private String name;
	private Person mother;
	private Person father;
	private String gender;
	 ArrayList<Person> parents = new ArrayList<>(2);
	 ArrayList<Person> offspring = new ArrayList<>();
	 
	 public Person() {
	}
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}
	public Person getFather() {
		return father;
	}
	public void setFather(Person father) {
		this.father = father;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	 
}
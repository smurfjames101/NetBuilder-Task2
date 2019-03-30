package com.netbuilder.entities;

import java.util.ArrayList;

public class Person {
	String name;
	Person mother;
	Person father;
	String gender;
	ArrayList<Person> parents = new ArrayList<>(2);
	ArrayList<Person> offspring = new ArrayList<>();
}
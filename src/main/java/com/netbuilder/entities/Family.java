package com.netbuilder.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Family {
	ArrayList<Person> people = new ArrayList<>();

	public Person findPerson(String name) {
		for (Person person : people) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	public boolean setParent(String childName, String parentName) {
		// Prevent Grandfather Paradox...
		if (childName.equals(parentName)) {
			return false;
		}
		Person child = findPerson(childName);
		Person parent = findPerson(parentName);
		// Prevented Error With Child Not Existing
		if (child == null) {
			child = new Person();
			child.setName(childName);
			child.setGender("undefined");
			people.add(child);
		}
		// Prevented Error With Parent Not Existing
		if (parent == null) {
			parent = new Person();
			parent.setName(parentName);
			parent.setGender("undefined");
			people.add(parent);
		}
		parent.offspring.add(child);
		child.parents.add(parent);
		return true;
	}

	public boolean isMale(String name) {
		Person person = findPerson(name);

		if (person.getGender().equals("male")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFemale(String name) {
		Person person = findPerson(name);

		if (person.getGender().equals("female")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean male(String name) {
		Person person = findPerson(name);
		if (person == null) {
			person = new Person();
			person.setName(name);
			person.setGender("male");
			people.add(person);
			return true;
		} else if (person.getGender().contentEquals("undefined")) { // If name has no set gender

			if (person.offspring.size() > 0)// find offspring, if they have them
			{
				for (Person parent : person.offspring.get(0).parents) // find them and check
				{
					if (parent.getGender().equals("male") && !parent.getName().equals(name))
						// if they are male and not the parent you are wanting to check
					{
						person.setGender("female");// if the other parent is male, this name must be female
						return false;
					}
				}
			}

			person.setGender("male");
			return true;

		} else if (!person.getGender().equals("male")) {
			return false;
		}
		return true;
	}

	public boolean female(String name) {
		Person person = findPerson(name);

		if (person == null) {
			person = new Person();
			person.setName(name);
			person.setGender("female");
			people.add(person);
			return true;
		}
		else if (person.getGender().contentEquals("undefined")) { // If name has no set gender

			if (person.offspring.size() > 0)// find offspring, if they have them
			{
				for (Person parent : person.offspring.get(0).parents) // find them and check
				{
					if (parent.getGender().equals("female") && !parent.getName().equals(name))
						// if they are female and not the parent you are wanting to check
					{
						person.setGender("male");// if the other parent is female, this name must be male
						return false;
					}
				}
			}

			person.setGender("female");
			return true;
		}
		else if (!person.getGender().equals("female")) { //All else Fails, make them female

			return false;
		}
		return true;
	}

	public String getParents(String name) {
		String[] outputArray1 = new String[2];
		ArrayList<Person> result = new ArrayList<>();
		for (Person person : findPerson(name).parents) {
			result.add(person);
		}
		for (int count = 0; count < findPerson(name).parents.size(); count++) {
			outputArray1[count] = result.get(count).getName();
		}
		// Sorting by First Letter Of Parents
		String firstParent = outputArray1[0];
		String secondParent = outputArray1[1];
		int asciiNum = Character.codePointAt(firstParent, 0);
		int asciiNum2 = Character.codePointAt(secondParent, 0);
		if (asciiNum < asciiNum2) {
			outputArray1[0] = firstParent;
			outputArray1[1] = secondParent;
		} else {
			outputArray1[0] = secondParent;
			outputArray1[1] = firstParent;
		}

		return Arrays.toString(outputArray1);
	}

	public String getChildren(String name) {
		// Dynamic Array Allocation
		int arraySize = findPerson(name).offspring.size();

		String[] outputArray2 = new String[arraySize];
		int count = 0;
		for (Person person : findPerson(name).offspring) {
			outputArray2[count] = person.getName();
			count++;
		}
		// Output For Visual Purposes
		return Arrays.toString(outputArray2);
	}
}

package com.netbuilder.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Family {
	ArrayList<Person> people = new ArrayList<>();

	public Person findPerson(String name) {
		for (Person person : people) {
			if (person.name.equals(name)) {
				return person;
			}
		}
		return null;
	}

	public boolean setParent(String childName, String parentName) {
		Person child = findPerson(childName);
		Person parent = findPerson(parentName);
		// Prevented Error With Child Not Existing
		if (child == null) {
			child = new Person();
			child.name = childName;
			child.gender = "undefined";
			people.add(child);
		}
		// Prevented Error With Parent Not Existing
		if (parent == null) {
			parent = new Person();
			parent.name = parentName;
			parent.gender = "undefined";
			people.add(parent);
		}
		parent.offspring.add(child);
		child.parents.add(parent);
		return true;
	}
    public boolean isMale(String name) {
        Person person =  findPerson(name);

        if (person.gender.equals("male")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFemale(String name) {
        Person person = findPerson(name);

        if (person.gender.equals("female")) {
            return true;
        } else {
            return false;
        }
    }

	public void getParents(String name) {
		String[] outputArray1 = new String[2];
		int count = 0;

		for (Person person : findPerson(name).parents) {
			outputArray1[count] = person.name;
			count++;
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
		// Output For Visual Purposes
		System.out.println(Arrays.toString(outputArray1));
	}

	public void getChildren(String name) {
		//Dynamic Array Allocation
		int arraySize = findPerson(name).offspring.size();

		String[] outputArray2 = new String[arraySize];
		int count = 0;
		for (Person person : findPerson(name).offspring) {
			outputArray2[count] = person.name;
			count++;
		}
		// Output For Visual Purposes
		System.out.println(Arrays.toString(outputArray2));
	}
}

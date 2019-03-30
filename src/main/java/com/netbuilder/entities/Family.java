package com.netbuilder.entities;

import java.util.ArrayList;

public class Family {
    ArrayList<Person> peopleList = new ArrayList<>();
    public Person findPerson(String name) {
        for (Person person:peopleList) {
            if (person.name.equals(name)) {
                return person;
            }
        }
        return null;
    }
    public boolean setParent(String childName, String parentName) {
        Person child = findPerson(childName);
        Person parent = findPerson(parentName);
        parent.offspring.add(child);
        child.parents.add(parent);
        return true;
    }
}

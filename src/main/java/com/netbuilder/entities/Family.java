package com.netbuilder.entities;

import java.util.ArrayList;

public class Family {
    ArrayList<Person> people = new ArrayList<>();
    public Person findPerson(String name) {
        for (Person person:people) {
            if (person.name.equals(name)) {
                return person;
            }
        }
        return null;
    }
    public boolean setParent(String childName, String parentName) {
        Person child = findPerson(childName);
        Person parent = findPerson(parentName);
        //Prevented Error With Child Not Existing
        if (child == null) {
            child = new Person();
            child.name = childName;
            child.gender = "undefined";
            people.add(child);
        }
        //Prevented Error With Parent Not Existing
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
    public void getParents(String name) {
        String[] outputArray1 = new String[2];
        int count = 0;

        for (Person person:findPerson(name).parents) {
            outputArray1[count] = person.name;
            count++;
        }
     }
}

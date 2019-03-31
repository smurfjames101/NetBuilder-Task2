package com.netbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.entities.Family;
import com.netbuilder.entities.Person;
import com.netbuilder.main.Constants;

public class FamilyTest {

	public static Family family;
	public Constants constants;
	public Person mockPerson;
	@BeforeClass
	public static void setup(){
		family = new Family();
		family.setParent("Frank", "Morgan");
		family.setParent("Frank", "Dylan");
        family.male("Dylan"); 
        family.setParent("Joy", "Frank"); 
        family.male("Frank");
        family.setParent("July", "Morgan"); 
        family.getChildren("Morgan"); 
        family.setParent("Jennifer", "Morgan"); 
        family.getChildren("Morgan"); 
        family.getChildren("Dylan"); 
        family.getParents("Frank");
        family.setParent("Frank", "Frank"); 
	}

	@Test
	public void setParentTest() {
		assertTrue(family.setParent("Frank", "Morgan"));
		assertTrue(family.setParent("Frank", "Dylan"));
		assertTrue(family.setParent("Joy", "Frank")); 
		assertTrue(family.setParent("July", "Morgan"));
		assertFalse(family.setParent("Frank", "Frank"));
		assertTrue(family.setParent("Jennifer", "Morgan"));
	}
	@Test
	public void maleTest() {
		assertTrue(family.male("Dylan"));
		assertTrue(family.male("Frank"));
        assertFalse(family.male("Morgan")); 
	}
	@Test
	public void getChildrenTest() {
		assertEquals("[Frank, July]",family.getChildren("Morgan"));
		assertEquals("[Frank, Jennifer, July]]",family.getChildren("Morgan")); 
        assertEquals("[Frank]",family.getChildren("Dylan"));
	}
	@Test
	public void getParentsTest() {
		assertEquals("[Dylan,Morgan]",family.getParents("Frank"));
	}
}

package com.netbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.entities.Family;
import com.netbuilder.entities.Person;
import com.netbuilder.main.Constants;

public class FamilyTest {

	public Family family;
	public Constants constants;
	public Person mockPerson;
	@Before
	public void setup(){
		family = new Family();
	}

	@Test
	public void familyTest() {
		assertTrue(family.setParent("Frank", "Morgan"));
		assertTrue(family.setParent("Frank", "Dylan"));
		assertTrue(family.male("Dylan"));
		assertTrue(family.setParent("Joy", "Frank")); 
		assertTrue(family.male("Frank"));
        assertFalse(family.male("Morgan")); 
		assertTrue(family.setParent("July", "Morgan"));
		assertEquals("[Frank, July]",family.getChildren("Morgan"));
		assertTrue(family.setParent("Jennifer", "Morgan"));		
		assertEquals("[Frank, July, Jennifer]",family.getChildren("Morgan")); 
        assertEquals("[Frank]",family.getChildren("Dylan"));
        assertEquals("[Dylan, Morgan]",family.getParents("Frank"));
		assertFalse(family.setParent("Frank", "Frank"));
	}
}

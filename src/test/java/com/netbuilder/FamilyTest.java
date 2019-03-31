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
		this.family = new Family();
		this.constants = new Constants();
	}

	@Test
	public void familyTest() {
		assertTrue(family.setParent("Frank", "Morgan"));
		assertTrue(family.setParent("Frank", "Dylan"));
		assertTrue(family.female("Anna"));
		assertTrue(family.male("Dylan"));
		assertFalse(family.female("Dylan"));
		assertTrue(family.setParent("Joy", "Frank")); 
		assertTrue(family.male("Frank"));
		assertFalse(family.female("Frank"));
        assertFalse(family.male("Morgan"));
        assertTrue(family.female("Morgan"));
		assertTrue(family.setParent("July", "Morgan"));
		assertEquals("[Frank, July]",family.getChildren("Morgan"));
		assertTrue(family.setParent("Jennifer", "Morgan"));		
		assertEquals("[Frank, July, Jennifer]",family.getChildren("Morgan")); 
        assertEquals("[Frank]",family.getChildren("Dylan"));
        assertEquals("[Dylan, Morgan]",family.getParents("Frank"));
		assertFalse(family.setParent("Frank", "Frank"));
		
		assertTrue(family.isFemale("Morgan"));
		assertFalse(family.isFemale("Dylan"));
		
		assertTrue(family.isMale("Dylan"));
		assertFalse(family.isMale("Morgan"));
	}
}

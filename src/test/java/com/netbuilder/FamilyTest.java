package com.netbuilder;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.netbuilder.entities.Family;
import com.netbuilder.main.Constants;

public class FamilyTest {

	Family family;
	Constants constants;
	@Test
	public void findPersonTest() {
		//PersonNotFound
		assertNull(family.findPerson(constants.MOCK_PERSON_NAME));
	}
	@Test
	public void setParentTest() {
		assertTrue(family.setParent(constants.MOCK_CHILD_NAME, constants.MOCK_PARENT_NAME));
	}
	
	
}

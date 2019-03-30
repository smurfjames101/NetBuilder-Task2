package com.netbuilder;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.netbuilder.entities.Family;
import com.netbuilder.main.Constants;

public class FamilyTest {

	Family family;
	Constants constants;
	@Test
	public void findPerson() {
		//PersonNotFound
		assertNull(family.findPerson(constants.MOCK_PERSON_NAME));
	}
}

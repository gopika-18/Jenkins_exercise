package org.knime.devops.exercise;

import org.junit.Assert.assertEquals;
import org.junit.Test;

public class sampleTest {
	@Test
	void succeedingTest() {
		assertEquals( "Test fails on purpose", "Test fails on purpose");// does nothing on purpose
	}
	
	
	@Test
	void failingTest() {
		assertEquals(1, 2, "Test fails on purpose");
	}	
}

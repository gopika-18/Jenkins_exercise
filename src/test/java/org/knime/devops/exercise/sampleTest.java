package org.knime.devops.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class sampleTest {
	@Test
	void test1() {
		system.out.println("Hello World");
	}
	@Test
	void succeedingTest() {
		assertEquals(1, 2, "Test fails on purpose");// does nothing on purpose
	}
	
	
	@Test
	void failingTest() {
		assertEquals(1, 2, "Test fails on purpose");
	}	
}

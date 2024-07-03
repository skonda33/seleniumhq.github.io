/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package junit5.example.sivajunit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils mu = null;
	TestInfo tinfo;
	TestReporter treport;

	@BeforeEach
	void setUp(TestInfo tinfo, TestReporter treport) {
		this.tinfo = tinfo;
		this.treport = treport;
		mu = new MathUtils();
	}

	@AfterEach
	void tearDown() {
		mu = null;
	}

	@Nested
	@DisplayName("testing add func")
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class AddTesing {
		@Test
		@DisplayName("test positve")
		void testAddingPositiveNumbers() {
			int expec = 4;
			int actual = mu.add(2, 2);
			assertEquals(expec, actual, () -> "adding positve" + expec + "and" + actual + " numbers not working");
		}

		@Test
		@DisplayName("test negetive")
		// @DisplayNameGeneration(DisplayNameGenerator.class ,simple)
		void testAddingNegetiveNumbers() {
			assertEquals(-4, mu.add(-2, -2), "adding negative numbers not working");
		}

	}

	@RepeatedTest(12)
	@DisplayName("adding 2 numbers")
	void add() {
		Assumptions.assumeTrue(true);
		int add = mu.add(2, 2);
		assertEquals(4, add);
		treport.publishEntry(tinfo.getDisplayName());
		assertAll(() -> assertEquals(4, mu.add(2, 2)), () -> assertEquals(-4, mu.add(-2, -2)

		));
	}

	@Test
	@DisplayName("area of a circle with radius")
	void area() {
		double area = mu.area(5);
		assertEquals(78.53981633974483, area, "expected area is not equal to actual");
	}

	@RepeatedTest(12)
	@DisplayName("area of a circle with radius")
	void areaRepition(RepetitionInfo info) {
		int currentRepetition = info.getCurrentRepetition();
		double area = mu.area(5);
		assertEquals(78.53981633974483, area, "expected area is not equal to actual");
	}

	@Test
	void testDivide() {
		assertEquals(5, mu.divide(1));
	}

	@Test
	void testDivideException() {

		assertThrows(ArithmeticException.class, () -> mu.divide(0), "execption throwed");

	}
}

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




import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("testDisplayNameAtClass")
class Siva1StandardTests {

	@BeforeAll
	static void testBeforeAll() {
	}


	@AfterAll
	static void testAfterAll() {
	}

	@BeforeEach
	void testBeforeEach() {
	}

	@AfterEach
	void testAfterEach() {

	}

	@Test
	void testTest() {

	}

	@Test
	@Disabled("this is disabled test")
	void testTestDisabled() {

	}

	@Test
	@DisplayName("testDisplayNameAtMethod")
	void testDisplayNameAtMethod() {

	}



}



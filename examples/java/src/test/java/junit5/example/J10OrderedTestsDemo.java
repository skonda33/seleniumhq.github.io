/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package junit5.example;

// tag::user_guide[]


import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
//@TestMethodOrder(DisplayName.class)
//@TestMethodOrder(MethodName.class)
class J10OrderedTestsDemo {

	@Test
	@Order(1)
	void nullValues() {
		// perform assertions against null values
	}

	@Test
	@Order(2)
	void emptyValues() {
		// perform assertions against empty values
	}

	@Test
	@Order(3)
	void validValues() {
		// perform assertions against valid values
	}

}
// end::user_guide[]

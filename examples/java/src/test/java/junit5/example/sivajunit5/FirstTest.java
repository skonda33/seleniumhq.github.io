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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FirstTest {

	@Test
	void test() {
	}

	@Test
	@DisplayName("siva test @DisplayName")
	void test1() {
	}

	@Test
	@DisplayName("siva test addition")
	@ParameterizedTest(name = "For example, year {0} is not supported.")
	@ValueSource(ints = { -1, -4 })
	int testAddition(int a, int b) {

		return 0;
	}

}

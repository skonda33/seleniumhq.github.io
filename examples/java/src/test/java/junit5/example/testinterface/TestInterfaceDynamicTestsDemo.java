/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package junit5.example.testinterface;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static junit5.example.util.StringUtils.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

// @formatter:off
// tag::user_guide[]
interface TestInterfaceDynamicTestsDemo {

	@TestFactory
	default Stream<DynamicTest> dynamicTestsForPalindromes() {
		return Stream.of("racecar", "radar", "mom", "dad")
			.map(text -> dynamicTest(text, () -> assertTrue(isPalindrome(text))));
	}

}
// end::user_guide[]
// @formatter:on

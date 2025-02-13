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

import junit5.example.util.Calculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class J5HamcrestAssertionsDemo {

	private final Calculator calculator = new Calculator();

	@Test
	void assertWithHamcrestMatcher() {
		assertThat(calculator.subtract(4, 1), is(equalTo(3)));
	}

}
// end::user_guide[]

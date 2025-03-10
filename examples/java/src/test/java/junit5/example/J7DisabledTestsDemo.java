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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class J7DisabledTestsDemo {

	@Disabled("Disabled until bug #42 has been resolved")
	@Test
	void testWillBeSkipped() {
	}

	@Test
	void testWillBeExecuted() {
	}

}
// end::user_guide[]

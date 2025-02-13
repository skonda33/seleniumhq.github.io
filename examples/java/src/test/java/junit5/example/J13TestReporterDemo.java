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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.HashMap;
import java.util.Map;

@Execution(ExecutionMode.SAME_THREAD)
// tag::user_guide[]
class J13TestReporterDemo {

	@Test
	void reportSingleValue(TestReporter testReporter) {
		testReporter.publishEntry("a status message");
	}

	@Test
	void reportKeyValuePair(TestReporter testReporter) {
		testReporter.publishEntry("a key",
								  "a value");
	}

	@Test
	void reportMultipleKeyValuePairs(TestReporter testReporter) {
		Map<String, String> values = new HashMap<>();
		values.put("user name",
				   "dk38");
		values.put("award year",
				   "1974");

		testReporter.publishEntry(values);
	}

}
// end::user_guide[]

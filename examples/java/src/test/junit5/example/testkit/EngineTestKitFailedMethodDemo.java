/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package junit5.example.testkit;

// @formatter:off
// tag::user_guide[]

import junit5.example.ExampleTestCase;
import org.junit.jupiter.api.Test;
import org.junit.platform.testkit.engine.EngineTestKit;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.testkit.engine.EventConditions.event;
import static org.junit.platform.testkit.engine.EventConditions.finishedWithFailure;
import static org.junit.platform.testkit.engine.EventConditions.test;
import static org.junit.platform.testkit.engine.TestExecutionResultConditions.instanceOf;
import static org.junit.platform.testkit.engine.TestExecutionResultConditions.message;

class EngineTestKitFailedMethodDemo {

	@Test
	void verifyJupiterMethodFailed() {
		EngineTestKit.engine("junit-jupiter") // <1>
			.selectors(selectClass(ExampleTestCase.class)) // <2>
			.execute() // <3>
			.testEvents() // <4>
			.assertThatEvents().haveExactly(1, // <5>
				event(test("failingTest"),
					finishedWithFailure(
						instanceOf(ArithmeticException.class), message("/ by zero"))));
	}

}
// end::user_guide[]
// @formatter:on

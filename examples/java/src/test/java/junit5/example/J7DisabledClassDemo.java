/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

/*

@siva notes
@Disabled is not @Inherited. Consequently,
if you wish to disable a class whose superclass is @Disabled, you must redeclare @Disabled on the subclass.
 */

package junit5.example;

// tag::user_guide[]
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//@Disabled is not @Inherited. Consequently,
// if you wish to disable a class whose superclass is @Disabled,
// you must redeclare @Disabled on the subclass.


@Disabled("Disabled until bug #99 has been fixed")
class J7DisabledClassDemo {

	@Test
	void testWillBeSkipped() {
	}

}
// end::user_guide[]

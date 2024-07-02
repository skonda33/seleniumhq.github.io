/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package junit5.example.callbacks;

// tag::user_guide[]

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static junit5.example.callbacks.Logger.afterAllMethod;
import static junit5.example.callbacks.Logger.afterEachMethod;
import static junit5.example.callbacks.Logger.beforeAllMethod;
import static junit5.example.callbacks.Logger.beforeEachMethod;
import static junit5.example.callbacks.Logger.beforeAllMethod;

/**
 * Abstract base class for tests that use the database.
 */
abstract class AbstractDatabaseTests {

	@BeforeAll
	static void createDatabase() {
		beforeAllMethod(AbstractDatabaseTests.class.getSimpleName() + ".createDatabase()");
	}

	@BeforeEach
	void connectToDatabase() {
		beforeEachMethod(AbstractDatabaseTests.class.getSimpleName() + ".connectToDatabase()");
	}

	@AfterEach
	void disconnectFromDatabase() {
		afterEachMethod(AbstractDatabaseTests.class.getSimpleName() + ".disconnectFromDatabase()");
	}

	@AfterAll
	static void destroyDatabase() {
		afterAllMethod(AbstractDatabaseTests.class.getSimpleName() + ".destroyDatabase()");
	}

}
// end::user_guide[]

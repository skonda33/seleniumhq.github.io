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

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static junit5.example.callbacks.Logger.afterEachCallback;
import static junit5.example.callbacks.Logger.beforeEachCallback;

public class Extension2 implements BeforeEachCallback, AfterEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) {
		beforeEachCallback(this);
	}

	@Override
	public void afterEach(ExtensionContext context) {
		afterEachCallback(this);
	}

}
// end::user_guide[]

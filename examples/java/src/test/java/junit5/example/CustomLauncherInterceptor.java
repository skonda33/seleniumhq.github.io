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

import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.platform.launcher.LauncherInterceptor;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomLauncherInterceptor implements LauncherInterceptor {

	private final URLClassLoader customClassLoader;

	public CustomLauncherInterceptor() throws Exception {
		ClassLoader parent = Thread.currentThread().getContextClassLoader();
		customClassLoader = new URLClassLoader(new URL[] { URI.create("some.jar").toURL() }, parent);
	}


	public <T> T intercept(InvocationInterceptor.Invocation<T> invocation) {
		Thread currentThread = Thread.currentThread();
		ClassLoader originalClassLoader = currentThread.getContextClassLoader();
		currentThread.setContextClassLoader(customClassLoader);
		try {
			return invocation.proceed();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			currentThread.setContextClassLoader(originalClassLoader);
		}
	}

	@Override
	public <T> T intercept(Invocation<T> invocation) {
		return null;
	}

	@Override
	public void close() {
		try {
			customClassLoader.close();
		}
		catch (IOException e) {
			throw new UncheckedIOException("Failed to close custom class loader", e);
		}
	}
}
// end::user_guide[]

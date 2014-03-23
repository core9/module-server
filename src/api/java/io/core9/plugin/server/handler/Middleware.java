package io.core9.plugin.server.handler;

import io.core9.plugin.server.request.Request;

public interface Middleware {
	/**
	 * Handle the logic
	 */
	public void handle(Request request);
}

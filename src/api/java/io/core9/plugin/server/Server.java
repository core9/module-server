package io.core9.plugin.server;

import io.core9.plugin.server.handler.Middleware;

public interface Server {

	/**
	 * Register on a specific path
	 */
	void use(String pattern, Middleware middleware);

	/**
	 * Register a binding on a virtualhost
	 * @param vhost
	 * @param pattern
	 * @param middleware
	 */
	void use(VirtualHost vhost, String pattern, Middleware middleware);
	
	/**
	 * Deregister a binding on all vhosts
	 * @param pattern
	 */
	void deregister(String pattern);
	
	/**
	 * Deregister a binding on a vhost
	 * @param vhost
	 * @param pattern
	 */
	void deregister(VirtualHost vhost, String pattern);
	
}

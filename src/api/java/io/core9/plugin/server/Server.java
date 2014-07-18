package io.core9.plugin.server;

import io.core9.core.executor.Executor;
import io.core9.core.plugin.Core9Plugin;
import io.core9.plugin.server.handler.Middleware;

public interface Server extends Core9Plugin, Executor, VirtualHostProcessor {

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
	
	/**
	 * Remove a VirtualHost from the server
	 * @param vhost
	 */
	void remove(VirtualHost vhost);
	
	/**
	 * Create a Cookie with a value
	 * @param name
	 * @param value
	 * @return
	 */
	Cookie newCookie(String name, String value);
	
	/**
	 * Create a Cookie without a value
	 * @param name
	 * @return
	 */
	Cookie newCookie(String name);
	
}

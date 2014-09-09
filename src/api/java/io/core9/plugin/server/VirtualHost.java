package io.core9.plugin.server;

import java.io.Serializable;
import java.util.Map;

public interface VirtualHost extends Serializable {
	
	/**
	 * Get the hostname
	 * @return
	 */
	String getHostname();

	/**
	 * Set the hostname
	 * @param hostname
	 * @return
	 */
	VirtualHost setHostname(String hostname);
	
	/**
	 * Get the context
	 * @return
	 */
	Map<String,Object> getContext();
	
	/**
	 * Set the context
	 * @param context
	 * @return
	 */
	VirtualHost setContext(Map<String,Object> context);
	
	/**
	 * Add to the context
	 * @param name
	 * @param value
	 * @return
	 */
	<R> R putContext(String name, R value);
	
	/**
	 * Get from the context
	 * @param name
	 * @return
	 */
	<R> R getContext(String name);

	/**
	 * Get from the context
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	<R> R getContext(String name, R defaultValue);

}

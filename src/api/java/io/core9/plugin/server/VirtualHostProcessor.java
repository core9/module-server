package io.core9.plugin.server;

public interface VirtualHostProcessor {
	
	/**
	 * A marker to process the VirtualHosts
	 * @param vhosts
	 */
	void addVirtualHost(VirtualHost vhost);
	
	/**
	 * Remove a virtualhost
	 * @param vhost
	 */
	void removeVirtualHost(VirtualHost vhost);
}

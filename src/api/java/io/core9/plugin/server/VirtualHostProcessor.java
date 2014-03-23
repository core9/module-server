package io.core9.plugin.server;

public interface VirtualHostProcessor {
	
	/**
	 * A marker to process the VirtualHosts (on boot)
	 * @param vhosts
	 */
	void process(VirtualHost[] vhosts);
}

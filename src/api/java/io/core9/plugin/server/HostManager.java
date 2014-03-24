package io.core9.plugin.server;

import java.util.Map;

import io.core9.core.plugin.Core9Plugin;

public interface HostManager extends Core9Plugin {
	
	/**
	 * Add a virtualhost to the system
	 * @param vhost
	 * @return
	 */
	HostManager addVirtualHost(VirtualHost vhost);
	
	/**
	 * @return an array of virtualhosts
	 */
	VirtualHost[] getVirtualHosts();
	
	/**
	 * Return the Vhosts with the hostname as index
	 * @return
	 */
	Map<String,VirtualHost> getVirtualHostsByHostname();
}

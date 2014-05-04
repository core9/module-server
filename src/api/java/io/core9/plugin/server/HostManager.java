package io.core9.plugin.server;

import io.core9.core.boot.BootStrategy;
import io.core9.core.plugin.Core9Plugin;
import io.core9.plugin.server.handler.Middleware;

import java.net.UnknownHostException;
import java.util.Map;

public interface HostManager extends Core9Plugin, BootStrategy {
	
	/**
	 * Add a virtualhost to the system
	 * @param vhost
	 * @return
	 * @throws UnknownHostException 
	 */
	HostManager addVirtualHost(VirtualHost vhost) throws UnknownHostException;
	
	/**
	 * @return an array of virtualhosts
	 */
	VirtualHost[] getVirtualHosts();
	
	/**
	 * Refresh the vhosts
	 * @return
	 */
	VirtualHost[] refreshVirtualHosts();
	
	/**
	 * Return the Vhosts with the hostname as index
	 * @return
	 */
	Map<String,VirtualHost> getVirtualHostsByHostname();
	
	/**
	 * Return the server aliases
	 * @return
	 */
	Map<String,String> getURLAliases();
	
	/**
	 * Return the installation procedure middleware
	 * @return
	 */
	Middleware getInstallationProcedure();
}

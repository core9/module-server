package io.core9.plugin.server;

import io.core9.core.boot.BootStrategy;
import io.core9.core.executor.Executor;
import io.core9.core.plugin.Core9Plugin;

import java.net.UnknownHostException;
import java.util.Map;

public interface HostManager extends Core9Plugin, BootStrategy, Executor {
	
	/**
	 * Add a virtualhost to the system
	 * @param vhost
	 * @return
	 * @throws UnknownHostException 
	 */
	HostManager addVirtualHost(VirtualHost vhost);
	
	/**
	 * Remove a VirtualHost
	 * @param vhost
	 * @return
	 * @throws UnknownHostException
	 */
	HostManager removeVirtualHost(VirtualHost vhost);
	
	/**
	 * @return an array of virtualhosts
	 */
	VirtualHost[] getVirtualHosts();
	
	/**
	 * Refresh the vhosts
	 * @return
	 */
	HostManager refreshVirtualHosts();
	
	/**
	 * Return the Vhosts with the hostname as index
	 * @return
	 */
	Map<String,VirtualHost> getVirtualHostsByHostname();

	/**
	 * Return the URL alias from the vhost
	 * @param vhost
	 * @param path
	 * @return
	 */
	String getURLAlias(VirtualHost vhost, String path);

}

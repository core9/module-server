package io.core9.plugin.server;

import java.util.HashMap;
import java.util.Map;

public class VirtualHost {
	private String hostname;
	private Map<String,Object> context;
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	public Map<String,Object> getContext() {
		return this.context;
	}
	
	public void setContext(Map<String,Object> context) {
		this.context = context;
	}
	
	@SuppressWarnings("unchecked")
	public <R> R putContext(String name, R value) {
		return (R) this.context.put(name, value);
	}
	
	@SuppressWarnings("unchecked")
	public <R> R getContext(String name) {
		return (R) this.context.get(name);
	}

	public <R> R getContext(String name, R defaultValue) {
        if (context.containsKey(name)) {
            return getContext(name);
        } else {
            return defaultValue;
        }
	}

	public VirtualHost(String hostname) {
		this.setHostname(hostname);
		this.context = new HashMap<String, Object>();
	}
}

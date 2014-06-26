package io.core9.plugin.server.request;

import io.core9.plugin.server.Cookie;
import io.core9.plugin.server.VirtualHost;

import java.util.List;
import java.util.Map;

import rx.Observable;

public interface Request {

	/**
	 * Return the path
	 * @return
	 */
	String getPath();
	
	/**
	 * Get all set params
	 * @return
	 */
	Map<String,Object> getParams();
	
	/**
	 * Get the response (wrapped) object
	 * @return
	 */
	Response getResponse();
	
	/**
	 * Get the request method (GET,POST,PUT etc)
	 * @return
	 */
	Method getMethod();
	
	/**
	 * Get the request body
	 */
	Observable<String> getBody();
	
	/**
	 * Return the request body as a map
	 */
	Observable<Map<String, Object>> getBodyAsMap();
	
	/**
	 * Return the request body as a list
	 */
	Observable<List<Object>> getBodyAsList();
	
	/**
	 * Get the request context
	 */
	Map<String, Object> getContext();
	
	/**
	 * Get a property from the context
	 */
	<R> R getContext(String name, R defaultVal);
	
	/**
	 * Get a property from the context
	 */
	<R> R getContext(String name);
	
	/**
	 * Add a property to the context
	 */
	<R> R putContext(String name, R value);
	
	/**
	 * Return the virtual host
	 */
	VirtualHost getVirtualHost();
	
	/**
	 * Return a cookie by name
	 * @param name
	 * @return
	 */
	Cookie getCookie(String name);
	
	/**
	 * Return all cookies by name
	 * @param name
	 * @return
	 */
	List<Cookie> getAllCookies(String name);
	
	/**
	 * Set the cookies
	 * @param cookies
	 */
	void setCookies(List<Cookie> cookies);
	
	/**
	 * Get the hostname
	 */
	String getHostname();
}

package io.core9.plugin.server.request;

import io.core9.plugin.server.Cookie;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Response {
	
	/**
	 * Get the template for the response
	 * @return
	 */
	String getTemplate();
	
	/**
	 * Set the template name, template enginge should handle the real templating
	 * @param string
	 */
	Response setTemplate(String string);
	
	/**
	 * Get all values for the response
	 * @return
	 */
	Map<String,Object> getValues();
	
	/**
	 * Add a single value
	 * @param key
	 * @param value
	 */
	void addValue(String key, Object value);
	
	/**
	 * Add multiple values
	 * @param values
	 */
	void addValues(Map<String,Object> values);
	
	/**
	 * Add as server status
	 */
	Response setStatusCode(int code);
	
	/**
	 * Set a status message
	 */
	Response setStatusMessage(String message);
	
	/**
	 * Get the status code
	 */
	int getStatusCode();
	
	/**
	 * Send a string to the request
	 * @param chunk
	 */
	void end(String chunk);
	
	/**
	 * End the request
	 */
	void end();
	
	/**
	 * Send a file
	 */
	Response sendFile(String filename);
	
	/**
	 * Send binary data
	 */
	Response sendBinary(byte[] data);
	
	/**
	 * Send JSON data
	 */
	void sendJsonMap(Map<String, Object> map);
	
	/**
	 * Send JSON data
	 */
	void sendJsonArray(List<? extends Object> list);
	
	/**
	 * Send JSON data
	 * @param list
	 */
	void sendJsonArray(Set<? extends Object> list);
	
	/**
	 * Send redirect
	 * @param int
	 * @param String
	 */
	void sendRedirect(int status, String url);
	
	/**
	 * Set header
	 */
	Response putHeader(String name, String value);
	
	/**
	 * Set a cookie
	 * @param cookie
	 */
	Response addCookie(Cookie cookie);
}

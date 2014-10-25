package io.core9.plugin.server.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

public final class RequestUtils {
	
	private static final Logger LOG = Logger.getLogger(RequestUtils.class);
	private static final Map<String,String> LOCALIZED_MESSAGES = new HashMap<String, String>(); 
	
	public static final String GLOBAL_MESSAGES_KEY 			  = "messages";
	public static final String VIRTUALHOST_CONTEXT_LOCALE_KEY = "locale";

	/**
	 * Put a message on the global scope
	 * @param req
	 * @param message
	 */
	public static void addMessage(Request req, String message) {
		putMessageOnGlobals(req, getLocalizedMessage(req, message));
	}

	/**
	 * Put a formatted message on the global scope
	 * TODO: add Locale support
	 * @param req
	 * @param message
	 * @param args
	 */
	public static void addMessage(Request req, String message, Object... args) {
	   addMessage(req, getLocalizedMessage(req, message, args));
	}
	
	/**
	 * Add a translation to the localized messages
	 * TODO Retrieve translations from DB
	 * @param locale
	 * @param message
	 * @param localizedMessage
	 */
	public static void addLocalizedMessage(String locale, String message, String localizedMessage) {
		LOCALIZED_MESSAGES.put(locale + ":" + message, localizedMessage);
	}
	
	/**
	 * Return a translated message
	 * @param req
	 * @param message
	 * @return
	 */
	public static String getLocalizedMessage(Request req, String message) {
		String locale = req.getVirtualHost().getContext(VIRTUALHOST_CONTEXT_LOCALE_KEY);
		if(locale != null) {
			return LOCALIZED_MESSAGES.getOrDefault(locale + ":" + message, message);
		}
		return message;
	}
	
	/**
	 * Return a translated message
	 * @param req
	 * @param message
	 * @return
	 */
	public static String getLocalizedMessage(Request req, String message, Object... args) {
		String locale = req.getVirtualHost().getContext(VIRTUALHOST_CONTEXT_LOCALE_KEY);
		if(locale != null) {
			return String.format(new Locale(locale.substring(0, 2), locale.substring(3, 5)), LOCALIZED_MESSAGES.getOrDefault(locale + ":" + message, message), args);
		}
		return String.format(LOCALIZED_MESSAGES.getOrDefault(locale + ":" + message, message), args);
	}
		
	@SuppressWarnings("unchecked")
	private static void putMessageOnGlobals(Request req, String message) {
		Object retrieved = req.getResponse().getGlobals().get(GLOBAL_MESSAGES_KEY);
		List<String> messages = null;
		if(retrieved == null) {
			messages = new ArrayList<String>();
			req.getResponse().addGlobal(GLOBAL_MESSAGES_KEY, messages);
		} else if(retrieved instanceof List<?>) {
			messages = (List<String>) retrieved;
		}
		if(messages != null && !messages.contains(message)) {
			messages.add(message);
		} else {
			LOG.error("Couldn't set message, the global key \"" + GLOBAL_MESSAGES_KEY + "\" is already set.");
		}
	}
}

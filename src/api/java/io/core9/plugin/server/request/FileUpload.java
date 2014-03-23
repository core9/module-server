package io.core9.plugin.server.request;

public interface FileUpload {
	String getFilename();
	String getContentType();
	String getFilepath();
}

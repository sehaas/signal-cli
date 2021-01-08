package org.asamk.signal.manager;

import java.io.File;

public class UserAlreadyExists extends Exception {

	private static final long serialVersionUID = -7510835170738786382L;

	private final String username;
	private final File fileName;

	public UserAlreadyExists(String username, File fileName) {
		this.username = username;
		this.fileName = fileName;
	}

	public String getUsername() {
		return username;
	}

	public File getFileName() {
		return fileName;
	}
}

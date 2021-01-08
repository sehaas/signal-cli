package org.asamk.signal.manager.groups;

public class GroupIdFormatException extends Exception {

	private static final long serialVersionUID = 6600166607252848249L;

	public GroupIdFormatException(String groupId, Throwable e) {
		super("Failed to decode groupId (must be base64) \"" + groupId + "\": " + e.getMessage(), e);
	}
}

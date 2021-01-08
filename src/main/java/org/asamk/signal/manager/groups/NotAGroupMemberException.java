package org.asamk.signal.manager.groups;

public class NotAGroupMemberException extends Exception {

	private static final long serialVersionUID = -4755628340820636307L;

	public NotAGroupMemberException(GroupId groupId, String groupName) {
		super("User is not a member in group: " + groupName + " (" + groupId.toBase64() + ")");
	}
}

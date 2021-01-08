package org.asamk.signal.manager.groups;

public class GroupNotFoundException extends Exception {

	private static final long serialVersionUID = 6995030334511092609L;

	public GroupNotFoundException(GroupId groupId) {
		super("Group not found: " + groupId.toBase64());
	}
}

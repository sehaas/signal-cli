package org.asamk.signal.manager;

public class AttachmentInvalidException extends Exception {

	private static final long serialVersionUID = 6103493871612744187L;

	public AttachmentInvalidException(String message) {
		super(message);
	}

	public AttachmentInvalidException(String attachment, Exception e) {
		super(attachment + ": " + e.getMessage());
	}
}

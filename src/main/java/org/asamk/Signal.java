package org.asamk;

import java.util.List;

import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.exceptions.DBusExecutionException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.messages.DBusSignal;

/**
 * DBus interface for the org.asamk.Signal service. Including emitted Signals
 * and returned Errors.
 */
public interface Signal extends DBusInterface {

	long sendMessage(String message, List<String> attachments, String recipient)
			throws Error.AttachmentInvalid, Error.Failure, Error.InvalidNumber;

	long sendMessage(String message, List<String> attachments, List<String> recipients) throws Error.AttachmentInvalid,
			Error.Failure, Error.InvalidNumber, Error.UnregisteredUser, Error.UntrustedIdentity;

	void sendEndSessionMessage(List<String> recipients)
			throws Error.Failure, Error.InvalidNumber, Error.UnregisteredUser, Error.UntrustedIdentity;

	long sendGroupMessage(String message, List<String> attachments, byte[] groupId) throws Error.GroupNotFound,
			Error.Failure, Error.AttachmentInvalid, Error.UnregisteredUser, Error.UntrustedIdentity;

	String getContactName(String number) throws Error.InvalidNumber;

	void setContactName(String number, String name) throws Error.InvalidNumber;

	void setContactBlocked(String number, boolean blocked) throws Error.InvalidNumber;

	void setGroupBlocked(byte[] groupId, boolean blocked) throws Error.GroupNotFound;

	List<byte[]> getGroupIds();

	String getGroupName(byte[] groupId);

	List<String> getGroupMembers(byte[] groupId);

	byte[] updateGroup(byte[] groupId, String name, List<String> members, String avatar) throws Error.AttachmentInvalid,
			Error.Failure, Error.InvalidNumber, Error.GroupNotFound, Error.UnregisteredUser, Error.UntrustedIdentity;

	boolean isRegistered();

	class MessageReceived extends DBusSignal {

		private final long timestamp;
		private final String sender;
		private final byte[] groupId;
		private final String message;
		private final List<String> attachments;

		public MessageReceived(String objectpath, long timestamp, String sender, byte[] groupId, String message,
				List<String> attachments) throws DBusException {
			super(objectpath, timestamp, sender, groupId, message, attachments);
			this.timestamp = timestamp;
			this.sender = sender;
			this.groupId = groupId;
			this.message = message;
			this.attachments = attachments;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public String getSender() {
			return sender;
		}

		public byte[] getGroupId() {
			return groupId;
		}

		public String getMessage() {
			return message;
		}

		public List<String> getAttachments() {
			return attachments;
		}
	}

	class ReceiptReceived extends DBusSignal {

		private final long timestamp;
		private final String sender;

		public ReceiptReceived(String objectpath, long timestamp, String sender) throws DBusException {
			super(objectpath, timestamp, sender);
			this.timestamp = timestamp;
			this.sender = sender;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public String getSender() {
			return sender;
		}
	}

	class SyncMessageReceived extends DBusSignal {

		private final long timestamp;
		private final String source;
		private final String destination;
		private final byte[] groupId;
		private final String message;
		private final List<String> attachments;

		public SyncMessageReceived(String objectpath, long timestamp, String source, String destination, byte[] groupId,
				String message, List<String> attachments) throws DBusException {
			super(objectpath, timestamp, source, destination, groupId, message, attachments);
			this.timestamp = timestamp;
			this.source = source;
			this.destination = destination;
			this.groupId = groupId;
			this.message = message;
			this.attachments = attachments;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public String getSource() {
			return source;
		}

		public String getDestination() {
			return destination;
		}

		public byte[] getGroupId() {
			return groupId;
		}

		public String getMessage() {
			return message;
		}

		public List<String> getAttachments() {
			return attachments;
		}
	}

	interface Error {

		class AttachmentInvalid extends DBusExecutionException {

			private static final long serialVersionUID = 4282168652039523924L;

			public AttachmentInvalid(final String message) {
				super(message);
			}
		}

		class Failure extends DBusExecutionException {

			private static final long serialVersionUID = 3122393657816867350L;

			public Failure(final String message) {
				super(message);
			}
		}

		class GroupNotFound extends DBusExecutionException {

			private static final long serialVersionUID = -5642949781534599741L;

			public GroupNotFound(final String message) {
				super(message);
			}
		}

		class InvalidNumber extends DBusExecutionException {

			private static final long serialVersionUID = 1022041367734807881L;

			public InvalidNumber(final String message) {
				super(message);
			}
		}

		class UnregisteredUser extends DBusExecutionException {

			private static final long serialVersionUID = -2656644074560613152L;

			public UnregisteredUser(final String message) {
				super(message);
			}
		}

		class UntrustedIdentity extends DBusExecutionException {

			private static final long serialVersionUID = 4728804065079779197L;

			public UntrustedIdentity(final String message) {
				super(message);
			}
		}
	}
}

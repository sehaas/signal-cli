package org.asamk.signal.json;

import java.util.ArrayList;
import java.util.List;

import org.asamk.Signal;
import org.asamk.signal.manager.Manager;
import org.whispersystems.signalservice.api.messages.multidevice.ReadMessage;
import org.whispersystems.signalservice.api.messages.multidevice.SignalServiceSyncMessage;
import org.whispersystems.signalservice.api.push.SignalServiceAddress;

enum JsonSyncMessageType {
	CONTACTS_SYNC, GROUPS_SYNC, REQUEST_SYNC
}

class JsonSyncMessage {

	JsonSyncDataMessage sentMessage;
	List<String> blockedNumbers;
	List<ReadMessage> readMessages;
	JsonSyncMessageType type;

	JsonSyncMessage(SignalServiceSyncMessage syncMessage, Manager m) {
		if (syncMessage.getSent().isPresent()) {
			this.sentMessage = new JsonSyncDataMessage(syncMessage.getSent().get(), m);
		}
		if (syncMessage.getBlockedList().isPresent()) {
			this.blockedNumbers = new ArrayList<>(syncMessage.getBlockedList().get().getAddresses().size());
			for (SignalServiceAddress address : syncMessage.getBlockedList().get().getAddresses()) {
				this.blockedNumbers.add(address.getLegacyIdentifier());
			}
		}
		if (syncMessage.getRead().isPresent()) {
			this.readMessages = syncMessage.getRead().get();
		}

		if (syncMessage.getContacts().isPresent()) {
			this.type = JsonSyncMessageType.CONTACTS_SYNC;
		} else if (syncMessage.getGroups().isPresent()) {
			this.type = JsonSyncMessageType.GROUPS_SYNC;
		} else if (syncMessage.getRequest().isPresent()) {
			this.type = JsonSyncMessageType.REQUEST_SYNC;
		}
	}

	JsonSyncMessage(Signal.SyncMessageReceived messageReceived) {
		sentMessage = new JsonSyncDataMessage(messageReceived);
	}
}

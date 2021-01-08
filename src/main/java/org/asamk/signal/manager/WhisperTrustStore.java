package org.asamk.signal.manager;

import java.io.InputStream;

import org.whispersystems.signalservice.api.push.TrustStore;

class WhisperTrustStore implements TrustStore {

	@Override
	public InputStream getKeyStoreInputStream() {
		return WhisperTrustStore.class.getResourceAsStream("whisper.store");
	}

	@Override
	public String getKeyStorePassword() {
		return "whisper";
	}
}

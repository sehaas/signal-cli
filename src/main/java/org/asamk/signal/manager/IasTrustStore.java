package org.asamk.signal.manager;

import java.io.InputStream;

import org.whispersystems.signalservice.api.push.TrustStore;

class IasTrustStore implements TrustStore {

	@Override
	public InputStream getKeyStoreInputStream() {
		return IasTrustStore.class.getResourceAsStream("ias.store");
	}

	@Override
	public String getKeyStorePassword() {
		return "whisper";
	}
}

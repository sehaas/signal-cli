package org.asamk.signal.manager.helper;

import java.io.IOException;

import org.signal.zkgroup.groups.GroupSecretParams;
import org.whispersystems.signalservice.api.groupsv2.GroupsV2AuthorizationString;

public interface GroupAuthorizationProvider {

	GroupsV2AuthorizationString getAuthorizationForToday(GroupSecretParams groupSecretParams) throws IOException;
}

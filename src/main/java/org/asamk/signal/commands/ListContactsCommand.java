package org.asamk.signal.commands;

import java.util.List;

import org.asamk.signal.manager.Manager;
import org.asamk.signal.manager.storage.contacts.ContactInfo;

import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;

public class ListContactsCommand implements LocalCommand {

    @Override
    public void attachToSubparser(final Subparser subparser) {
    }

    @Override
    public int handleCommand(final Namespace ns, final Manager m) {
        if (!m.isRegistered()) {
            System.err.println("User is not registered.");
            return 1;
        }
        List<ContactInfo> contacts = m.getContacts();
        for (ContactInfo c : contacts) {
            System.out.println(String.format("Number: %s Name: %s  Blocked: %b", c.number, c.name, c.blocked));
        }
        return 0;
    }
}

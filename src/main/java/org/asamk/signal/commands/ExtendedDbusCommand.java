package org.asamk.signal.commands;

import org.asamk.Signal;
import org.freedesktop.dbus.connections.impl.DBusConnection;

import net.sourceforge.argparse4j.inf.Namespace;

public interface ExtendedDbusCommand extends Command {

    int handleCommand(Namespace ns, Signal signal, DBusConnection dbusconnection);
}

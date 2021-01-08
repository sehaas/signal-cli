package org.asamk.signal.commands;

import org.asamk.signal.manager.ProvisioningManager;

import net.sourceforge.argparse4j.inf.Namespace;

public interface ProvisioningCommand extends Command {

    int handleCommand(Namespace ns, ProvisioningManager m);
}

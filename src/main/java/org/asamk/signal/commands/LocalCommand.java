package org.asamk.signal.commands;

import org.asamk.signal.manager.Manager;

import net.sourceforge.argparse4j.inf.Namespace;

public interface LocalCommand extends Command {

	int handleCommand(Namespace ns, Manager m);
}

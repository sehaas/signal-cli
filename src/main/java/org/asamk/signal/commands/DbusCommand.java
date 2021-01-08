package org.asamk.signal.commands;

import org.asamk.Signal;

import net.sourceforge.argparse4j.inf.Namespace;

public interface DbusCommand extends Command {

	int handleCommand(Namespace ns, Signal signal);
}

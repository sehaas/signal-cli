package org.asamk.signal.commands;

import java.io.File;
import java.io.IOException;

import org.asamk.signal.manager.Manager;
import org.asamk.signal.manager.StickerPackInvalidException;

import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;

public class UploadStickerPackCommand implements LocalCommand {

	@Override
	public void attachToSubparser(final Subparser subparser) {
		subparser.addArgument("path")
				.help("The path of the manifest.json or a zip file containing the sticker pack you wish to upload.");
	}

	@Override
	public int handleCommand(final Namespace ns, final Manager m) {
		try {
			File path = new File(ns.getString("path"));
			String url = m.uploadStickerPack(path);
			System.out.println(url);
			return 0;
		} catch (IOException e) {
			System.err.println("Upload error: " + e.getMessage());
			return 3;
		} catch (StickerPackInvalidException e) {
			System.err.println("Invalid sticker pack: " + e.getMessage());
			return 3;
		}
	}
}

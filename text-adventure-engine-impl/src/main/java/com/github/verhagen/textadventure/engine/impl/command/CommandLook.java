package com.github.verhagen.textadventure.engine.impl.command;

import com.github.verhagen.textadventure.engine.domain.IObjectVisitor;
import com.github.verhagen.textadventure.engine.domain.IPlayer;

public class CommandLook extends AbstractCommand {
	
	public CommandLook() {
		super("look", "Look around, or at a specific item.", (String)null);
	}

	@Override
	public void execute(IPlayer player, IObjectVisitor visitor, String argument) {
		player.getLocation().accept(visitor);
	}

}

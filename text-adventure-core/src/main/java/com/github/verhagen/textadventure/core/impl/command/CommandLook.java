package com.github.verhagen.textadventure.core.impl.command;

import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.IPlayer;

public class CommandLook extends AbstractCommand {
	
	public CommandLook() {
		super("look", (String)null);
	}

	@Override
	public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
		player.getLocation().accept(visitor);
	}

}

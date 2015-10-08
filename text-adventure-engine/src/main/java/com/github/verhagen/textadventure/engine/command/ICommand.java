package com.github.verhagen.textadventure.engine.command;

import java.util.Set;

import com.github.verhagen.textadventure.engine.domain.IObjectVisitor;
import com.github.verhagen.textadventure.engine.domain.IPlayer;

public interface ICommand {

	String getName();

	Set<String> getAliases();

	String getDescription();
	
	void execute(final IPlayer player, final IObjectVisitor visitor, final String argument);

}

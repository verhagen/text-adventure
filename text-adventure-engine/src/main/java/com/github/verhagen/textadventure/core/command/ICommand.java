package com.github.verhagen.textadventure.core.command;

import java.util.Set;

import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.IPlayer;

public interface ICommand {

	String getName();

	Set<String> getAliases();

	String getDescription();
	
	void execute(final IPlayer player, final IObjectVisitor visitor, final String argument);

}

package com.github.verhagen.textadventure.core.impl.command;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.command.ICommand;
import com.github.verhagen.textadventure.core.command.ICommandRegistery;

public class CommandRegistery implements ICommandRegistery {
	private SortedMap<String, ICommand> commands = new TreeMap<>();

	@Override
	public void register(ICommand command) {
		if (exists(command)) {
			throw new TextAdventureRuntimeException("The command '" + command.getName() 
					+ "', which is added to the registery has a name or alias, which is"
					+ " already used in the registery.");
		}
		
		commands.put(command.getName(), command);
		for (String alias : command.getAliases()) {
		    commands.put(alias, command);
		}
	}

	public Boolean exists(ICommand command) {
		if (exists(command.getName())) {
			return Boolean.TRUE;
		}
		
		for (String alias : command.getAliases()) {
			if (exists(alias)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public Boolean exists(final String nameOrAlias) {
		return commands.containsKey(nameOrAlias);
	}

	@Override
	public ICommand get(final String nameOrAlias) {
		return commands.get(nameOrAlias);
	}

}

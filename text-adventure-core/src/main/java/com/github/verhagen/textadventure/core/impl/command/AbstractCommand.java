package com.github.verhagen.textadventure.core.impl.command;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.github.verhagen.textadventure.core.command.ICommand;

public abstract class AbstractCommand implements ICommand {
	private final String name;
	private final String description;
	private final Set<String> aliases;

	public AbstractCommand(final String name, final String aliases) {
		this(name, null, split(aliases));
	}
	public AbstractCommand(final String name, final Set<String> aliases) {
		this(name, null, aliases);
	}
	public AbstractCommand(final String name, final String description, String aliases) {
		this(name, description, split(aliases));
	}
	public AbstractCommand(final String name, final String description, final Set<String> aliases) {
		this.name = name;
		this.description = description;
		if (aliases == null) {
			this.aliases = Collections.emptySet();
		}
		else {
			this.aliases = aliases;
		}
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Set<String> getAliases() {
		return aliases;
	}

	private static TreeSet<String> split(String aliases) {
		if (aliases == null) {
			return null;
		}

		// FIXME split incoming aliases string
		return new TreeSet<String>();
	}

}

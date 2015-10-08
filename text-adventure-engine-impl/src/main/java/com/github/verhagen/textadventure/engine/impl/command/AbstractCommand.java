package com.github.verhagen.textadventure.engine.impl.command;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.github.verhagen.textadventure.engine.command.ICommand;

public abstract class AbstractCommand implements ICommand {
	private final String name;
	private final String description;
	private final Set<String> aliases;

	public AbstractCommand(final String name, final String aliases) {
		this(name, null, split(aliases));
	}
//	public AbstractCommand(final String name, final Set<String> aliases) {
//		this(name, null, aliases);
//	}
	public AbstractCommand(final String name, final String description, final String aliases) {
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

	private static Set<String> split(String aliasesStr) {
    	if (aliasesStr == null || aliasesStr.trim().length() == 0) {
    	    return null;
    	}

        SortedSet<String> aliases = new TreeSet<>();
        for (String alias : aliasesStr.split(",")) {
            String cleanAlias = alias.trim();
            if (cleanAlias.length() > 0) {
            	aliases.add(cleanAlias);
            }
        }
		
		return aliases;
	}

}

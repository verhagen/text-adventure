package com.github.verhagen.textadventure.core.command;

public interface ICommandRegistery {

	void register(final ICommand command);
	
	ICommand get(final String nameOrAlias);

    Boolean exists(final String nameOrAlias);

}

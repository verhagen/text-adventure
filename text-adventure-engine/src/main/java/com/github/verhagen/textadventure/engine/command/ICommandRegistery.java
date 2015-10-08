package com.github.verhagen.textadventure.engine.command;

public interface ICommandRegistery {

	void register(final ICommand command);
	
	ICommand get(final String nameOrAlias);

    Boolean exists(final String nameOrAlias);

}

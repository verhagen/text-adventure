package com.github.verhagen.textadventure.core.domain;

import com.github.verhagen.textadventure.core.command.ICommand;

public interface IWorld extends IObject {

	void start(final IPlayer player);

	String execute(final ICommand command, final String argument);

}

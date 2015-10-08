package com.github.verhagen.textadventure.engine.domain;

import com.github.verhagen.textadventure.engine.command.ICommand;

public interface IWorld extends IObject {

	void start(final IPlayer player);

	String execute(final ICommand command, final String argument);

}

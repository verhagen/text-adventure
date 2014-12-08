package com.github.verhagen.textadventure.core.domain;

import com.github.verhagen.textadventure.core.command.ICommand;

public interface IWorld extends IObject {

	String execute(final ICommand command, final String[] args);

	void start(final IPlayer player);

}

package com.github.verhagen.textadventure.core.command;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.IPlayer;
import com.github.verhagen.textadventure.core.impl.command.AbstractCommand;
import com.github.verhagen.textadventure.core.impl.command.CommandLook;
import com.github.verhagen.textadventure.core.impl.command.CommandRegistery;

public class CommandRegisteryTest {

	@Test
	public void registerLook() {
		CommandRegistery commandRegistery = new CommandRegistery();
		commandRegistery.register(new CommandLook());
		
		ICommand command = commandRegistery.get("look");
		assertNotNull(command, "The command should not be null, but contain the 'look' command.");
		assertEquals(command.getName(), "look");
	}

	@Test
	public void registerNotExists() {
		CommandRegistery commandRegistery = new CommandRegistery();
		assertFalse(commandRegistery.exists("look"));
		assertFalse(commandRegistery.exists(new CommandLook()));
	}

	@Test(expectedExceptions = TextAdventureRuntimeException.class)
	public void alreadyExists() {
		CommandRegistery commandRegistery = new CommandRegistery();
		commandRegistery.register(new CommandLook());
		commandRegistery.register(new CommandLook());
	}

}

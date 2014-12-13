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

    @Test(expectedExceptions = TextAdventureRuntimeException.class)
    public void aliasAlreadyExists() {
        CommandRegistery commandRegistery = new CommandRegistery();
        commandRegistery.register(new CommandInventory());
        commandRegistery.register(new CommandInspect());
    }

	@Test
	public void newCommandInventory() {
		ICommand command = new CommandInventory();
		assertEquals(command.getName(), "inventory");
	}

	@Test
	public void newCommandWalk() {
		ICommand command = new CommandWalk();
		assertEquals(command.getName(), "walk");
		assertTrue(command.getAliases().contains("g"), "Expecting alias 'g'.");
		assertTrue(command.getAliases().contains("goto"), "Expecting alias 'goto'.");
	}

	@Test
	public void newCommandGet() {
		ICommand command = new CommandGet();
		assertEquals(command.getName(), "get");
	}

	@Test
	public void newCommandPut() {
		ICommand command = new CommandPut();
		assertEquals(command.getName(), "put");
	}

	
	// Inner classes

    class CommandInventory extends AbstractCommand {
    	public CommandInventory() {
    		super("inventory", "Shows your inventory.", "i");
    	}
    
    	@Override
    	public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
    		// nothing
    	}
    }
    

    class CommandInspect extends AbstractCommand {
        public CommandInspect() {
            super("inspect", "Inspects an item.", "i");
        }
    
        @Override
        public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
            // nothing
        }
    }
    
    
    class CommandWalk extends AbstractCommand {
    	public CommandWalk() {
    		super("walk", "Walk in a direction.", "g, goto, ,");
    	}
    
    	@Override
    	public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
    		// nothing
    	}
    }
    
    
    class CommandGet extends AbstractCommand {
    	public CommandGet() {
    		super("get", null, "");
    	}
    
    	@Override
    	public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
    		// nothing
    	}
    }
    
    
    class CommandPut extends AbstractCommand {
    	public CommandPut() {
    		super("put", "p");
    	}
    
    	@Override
    	public void execute(IPlayer player, IObjectVisitor visitor, String[] args) {
    		// nothing
    	}
    }


}

package com.github.verhagen.textadventure.core.command;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.domain.IWorld;
import com.github.verhagen.textadventure.core.impl.command.CommandGet;
import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.World;

public class CommandGetTest {

    @Test
    public void getMap() {
        IWorld world = CommandLookTest.createWorld();
        world = CommandLookTest.createWorld((World)world, new Item("map", "A map that shows the labyrinth."));
        CommandGet get = new CommandGet();
        String result = world.execute(get, "map");
        
        assertEquals(result, "You took the map");
    }

    @Test
    public void getNothingNull() {
        IWorld world = CommandLookTest.createWorld();
        world = CommandLookTest.createWorld((World)world, new Item("map", "A map that shows the labyrinth."));
        CommandGet get = new CommandGet();
        String result = world.execute(get, null);
        
        assertEquals(result, "What should be taken?");
    }

    @Test
    public void getNothingEmptyString() {
        IWorld world = CommandLookTest.createWorld();
        world = CommandLookTest.createWorld((World)world, new Item("map", "A map that shows the labyrinth."));
        CommandGet get = new CommandGet();
        String result = world.execute(get, "");
        
        assertEquals(result, "What should be taken?");
    }

    @Test
    public void getNothingSpaces() {
        IWorld world = CommandLookTest.createWorld();
        world = CommandLookTest.createWorld((World)world, new Item("map", "A map that shows the labyrinth."));
        CommandGet get = new CommandGet();
        String result = world.execute(get, "  ");
        
        assertEquals(result, "What should be taken?");
    }

}

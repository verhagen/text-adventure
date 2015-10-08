package com.github.verhagen.textadventure.core.command;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.domain.IWorld;
import com.github.verhagen.textadventure.core.impl.command.CommandGet;
import com.github.verhagen.textadventure.core.impl.command.CommandInventory;
import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.World;

public class CommandInventoryTest {

    @Test
    public void carryingNothing() {
        IWorld world = CommandLookTest.createWorld();
        CommandInventory inventory = new CommandInventory();

        String expected = "You are not carrying anything.";
        
        String result = world.execute(inventory, null);
        assertEquals(result, expected);
    }
    

    @Test
    public void carryingBook() {
        IWorld world = CommandLookTest.createWorld();
        world = CommandLookTest.createWorld((World)world, new Item("map", "A map that shows the labyrinth."));
        CommandGet get = new CommandGet();
        String result = world.execute(get, "map");
 
        String expected = "You took the map";
        assertEquals(result, expected);

        CommandInventory inventory = new CommandInventory();
        expected = "Inventory Items: map";
        
        result = world.execute(inventory, null);
        assertEquals(result, expected);
    }

    @Test
    public void tryGetSomethingThatIsNotThere() {
        IWorld world = CommandLookTest.createWorld();
        CommandGet get = new CommandGet();
        String result = world.execute(get, "book");
 
        String expected = "Nothing here that looks like a book";
        assertEquals(result, expected);
    }
}

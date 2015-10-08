package com.github.verhagen.textadventure.engine.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.impl.domain.Item;
import com.github.verhagen.textadventure.engine.impl.domain.Player;

public class PlayerTest {

	@Test
	public void createTintin() {
		Player player = new Player("tintin", "Tintin");
		
		assertEquals(player.getId(), "tintin");
		assertEquals(player.getName(), "Tintin");
	}


	@Test
	public void carryItems() {
		Player player = new Player("tintin", "Tintin");
		assertFalse(player.contains("book"));
		assertTrue(player.isEmpty());
		
		player.add(createBook());
		assertTrue(player.contains("book"));
		assertFalse(player.isEmpty());
		Set<IItem> items = player.getItems();
		assertEquals(items.size(), 1, "There should be 1 book in the set.");
		
		IItem book = player.remove("book");
		assertEquals(book.getId(), "book");
		assertEquals(book.getName(), "book");
		assertEquals(book.getDescription(), "Explorers on the moon");
		
		IItem note = createNote();
		assertFalse(player.contains(note), "Player should not carry a note.");
	}

    @Test
    public void dropItem() {
        Player player = new Player("tintin", "Tintin");
        assertFalse(player.contains("book"));
        assertTrue(player.isEmpty());
        
        IItem note = createNote();
        player.remove(note);
    }

	private IItem createBook() {
		return new Item("book", "Explorers on the moon");
	}

    private IItem createNote() {
        return new Item("note", "Nice little yellow note, with some text on it.");
    }
}

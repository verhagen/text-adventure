package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.Location;

public class LocationTest {
	private final String name = "Hall";
	private final String description = "There is a front door on the south and a door on the east.";
	
	@Test
	public void locationNameAndDescription() {
		ILocation room = createHall();
		assertEquals(room.getId(), name.toLowerCase());
		assertEquals(room.getName(), name);
		assertEquals(room.getDescription(), description);
	}
	
	@Test
	public void roomContainsBook() {
		ILocation hall = createHall();
		assertTrue(hall.isEmpty());

		IItem book = createBook();
		hall.add(book);
		assertFalse(hall.isEmpty());
		assertTrue(hall.contains(book), "There should eb a book in the hall.");
		assertTrue(hall.contains(book.getId()), "There should eb a book in the hall.");
		assertFalse(hall.isEmpty(), "Hall should not be empty.");

		Set<IItem> items = hall.getItems();
		assertFalse(items.isEmpty(), "There should be a book in the items collection.");
		assertEquals(items.size(), 1, "Only the book should be in the collection");
		assertEquals(items.iterator().next().getName(), "book");
		assertEquals(items.iterator().next().getDescription(), "The Hitchhiker's Guide to the Galaxy");

		IItem item = hall.remove("book");
		assertNotNull(item, "The item, should be the book");
		assertEquals(item.getName(), "book");
		assertEquals(item.getDescription(), "The Hitchhiker's Guide to the Galaxy");
		
		assertTrue(hall.isEmpty(), "Nothing should be anymore in the hall.");

		IItem key = createKey();
		hall.add(key);
		assertFalse(hall.isEmpty(), "The key is in the hall.");
		
		hall.remove(key);
		assertTrue(hall.isEmpty(), "Nothing should be anymore in the hall.");
	}

	private ILocation createHall() {
		return createRoom(name, description);
	}

	private ILocation createRoom(String name, String description) {
		return new Location(name, description);
	}

	private IItem createBook() {
		return new Item("book", "The Hitchhiker's Guide to the Galaxy");
	}

	private IItem createKey() {
		return new Item("key", "An old rusty key");
	}

}

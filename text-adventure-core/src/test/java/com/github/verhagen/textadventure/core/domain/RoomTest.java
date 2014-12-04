package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.Room;

public class RoomTest {
	private final String name = "Hall";
	private final String description = "There is a front door on the south and a door on the east.";
	
	@Test
	public void roomNameAndDescription() {
		IRoom room = createHall();
		assertEquals(room.getId(), name.toLowerCase());
		assertEquals(room.getName(), name);
		assertEquals(room.getDescription(), description);
	}
	
	@Test
	public void roomContainsBook() {
		IRoom hall = createHall();
		IItem book = createBook();
		hall.add(book);
		
		assertTrue(hall.contains(book), "There should eb a book in the hall.");
		assertTrue(hall.contains(book.getId()), "There should eb a book in the hall.");
		assertFalse(hall.isEmpty(), "Hall should not be empty.");
	}

	private Room createHall() {
		return createRoom(name, description);
	}

	private Room createRoom(String name, String description) {
		return new Room(name, description);
	}

	private IItem createBook() {
		return new Item("book", "The Hitchhiker's Guide to the Galaxy");
	}

}

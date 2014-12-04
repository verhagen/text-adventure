package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.impl.domain.Room;

public class RoomTest {
	
	@Test
	public void roomNameAndDescription() {
		String name = "Hall";
		String description = "There is a front door on the south and a door on the east.";
		IRoom room = new Room(name, description);
		assertEquals(room.getId(), name.toLowerCase());
		assertEquals(room.getName(), name);
		assertEquals(room.getDescription(), description);
	}
}

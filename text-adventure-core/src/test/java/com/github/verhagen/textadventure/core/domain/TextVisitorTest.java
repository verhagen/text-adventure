package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.Room;
import com.github.verhagen.textadventure.core.impl.domain.TextVisitor;

public class TextVisitorTest {

	@Test
	public void visitEmptyHall() {
		String description = "There is a front door on the south and a door on the east.";
		IRoom hall = new Room("hall", description);
		
		TextVisitor visitor = new TextVisitor();
		hall.accept(visitor);
		
		assertEquals(visitor.asText(), description);
	}

	@Test
	public void visitHallWithABook() {
		String description = "There is a front door on the south and a door on the east.";
		String title = "TRS-80 Assembly-Language Programming";
		IRoom hall = new Room("hall", description);
		IItem book = new Item("book", title);
		hall.add(book);

		TextVisitor visitor = new TextVisitor();
		hall.accept(visitor);
		
		assertEquals(visitor.asText(), description + "Items: " + book.getName());
	}

}

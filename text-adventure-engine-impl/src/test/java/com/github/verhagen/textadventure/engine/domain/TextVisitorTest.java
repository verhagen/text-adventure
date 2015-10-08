package com.github.verhagen.textadventure.engine.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.domain.ILocation;
import com.github.verhagen.textadventure.engine.impl.domain.Item;
import com.github.verhagen.textadventure.engine.impl.domain.Location;
import com.github.verhagen.textadventure.engine.impl.domain.TextVisitor;

public class TextVisitorTest {

	@Test
	public void visitEmptyHall() {
		String description = "There is a front door on the south and a door on the east.";
		ILocation hall = new Location("hall", description);

		TextVisitor visitor = new TextVisitor();
		hall.accept(visitor);

		assertEquals(visitor.asText(), "You are in a hall. " + description);
	}

	@Test
	public void visitHallWithABook() {
		String description = "There is a front door on the south and a door on the east.";
		String title = "TRS-80 Assembly-Language Programming";
		ILocation hall = new Location("hall", description);
		IItem book = new Item("book", title);
		hall.add(book);

		TextVisitor visitor = new TextVisitor();
		hall.accept(visitor);

		assertEquals(visitor.asText(), "You are in a hall. " + description + " Items: " + book.getName());
	}

}

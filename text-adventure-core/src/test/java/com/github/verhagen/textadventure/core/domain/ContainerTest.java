package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.impl.domain.Container;
import com.github.verhagen.textadventure.core.impl.domain.Item;

public class ContainerTest {

	@Test
	public void addBookAndRemoveAsItem() {
		IContainer container = new Container();
		assertTrue(container.isEmpty(), "The container should be empty.");
		Item book = new Item("book", null);
		container.add(book);
		
		assertFalse(container.isEmpty(), "The container should not be empty.");
		IItem something = container.remove(book);
		assertEquals(something, book);
		assertTrue(container.isEmpty(), "The container should be empty.");
	}

	@Test
	public void addBookAndRemoveAsId() {
		IContainer container = new Container();
		assertTrue(container.isEmpty(), "The container should be empty.");
		Item book = new Item("book", null);
		container.add(book);
		
		assertFalse(container.isEmpty(), "The container should not be empty.");
		IItem something = container.remove("book");
		assertEquals(something, book);
		assertTrue(container.isEmpty(), "The container should be empty.");
	}

}

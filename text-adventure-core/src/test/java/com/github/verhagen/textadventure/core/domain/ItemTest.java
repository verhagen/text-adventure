package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.impl.domain.Item;

public class ItemTest {

	@Test
	public void couch() {
		String name = "couch";
		String description = "It is old dark red, but still good looking, Chesterfield.";
		IItem key = new Item(name, description);

		assertEquals(key.getName(), name);
		assertEquals(key.getDescription(), description);
		assertFalse(key.isPorable(), "The key should not be portable.");
		assertFalse(key.isContainer(), "The key should not be a container.");
	}

	@Test
	public void key() {
		String name = "key";
		String description = "Old rusty key.";
		IItem key = new Item(name, description, Boolean.TRUE, Boolean.FALSE);

		assertEquals(key.getName(), name);
		assertEquals(key.getDescription(), description);
		assertTrue(key.isPorable(), "The key should be portable.");
		assertFalse(key.isContainer(), "The key should not be a container.");
	}

	@Test
	public void cabinet() {
		String name = "cabinet";
		String description = "The cabinet has seen better days.";
		IItem cabinet = new Item(name, description, Boolean.FALSE, Boolean.TRUE);

		assertEquals(cabinet.getName(), name);
		assertEquals(cabinet.getDescription(), description);
		assertFalse(cabinet.isPorable(), "The cabinet should not be portable.");
		assertTrue(cabinet.isContainer(), "The cabinet should be a container.");
	}

	@Test
	public void backpack() {
		String name = "backpack";
		String description = "It is a black leader backpack.";
		IItem backpack = new Item(name, description, Boolean.TRUE, Boolean.TRUE);

		assertEquals(backpack.getName(), name);
		assertEquals(backpack.getDescription(), description);
		assertTrue(backpack.isPorable(), "The backpack should be portable.");
		assertTrue(backpack.isContainer(), "The backpack should be a container.");
	}

}

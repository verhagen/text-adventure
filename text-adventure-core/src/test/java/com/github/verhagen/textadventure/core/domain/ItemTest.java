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
		IItem couch = new Item(name, description);

		assertEquals(couch.getId(), name);
		assertEquals(couch.getName(), name);
		assertEquals(couch.getDescription(), description);
		assertFalse(couch.isPorable(), "The key should not be portable.");
		assertFalse(couch.isContainer(), "The key should not be a container.");
	}

	@Test
	public void key() {
		String name = "key";
		String description = "Old rusty key.";
		IItem key = new Item(null, name, description, Boolean.TRUE, Boolean.FALSE);

		assertEquals(key.getId(), name);
		assertEquals(key.getName(), name);
		assertEquals(key.getDescription(), description);
		assertTrue(key.isPorable(), "The key should be portable.");
		assertFalse(key.isContainer(), "The key should not be a container.");
	}

	@Test
	public void cabinet() {
		String name = "cabinet";
		String description = "The cabinet has seen better days.";
		IItem cabinet = new Item(null, name, description, Boolean.FALSE, Boolean.TRUE);

		assertEquals(cabinet.getId(), name);
		assertEquals(cabinet.getName(), name);
		assertEquals(cabinet.getDescription(), description);
		assertFalse(cabinet.isPorable(), "The cabinet should not be portable.");
		assertTrue(cabinet.isContainer(), "The cabinet should be a container.");
	}

	@Test
	public void backpack() {
		String name = "backpack";
		String description = "It is a black leader backpack.";
		IItem backpack = new Item(null, name, description, Boolean.TRUE, Boolean.TRUE);

		assertEquals(backpack.getId(), name);
		assertEquals(backpack.getName(), name);
		assertEquals(backpack.getDescription(), description);
		assertTrue(backpack.isPorable(), "The backpack should be portable.");
		assertTrue(backpack.isContainer(), "The backpack should be a container.");
	}


	@Test
	public void couchTwo() {
		String name = "couch";
		String idA = name + "-large";
		String idB = name + "-small";
		String description = "It is old dark red, but still good looking, Chesterfield.";
		IItem couchA = new Item(idA, name, description);
		IItem couchB = new Item(idB, name, description);

		assertEquals(couchA.getId(), idA);
		assertEquals(couchA.getName(), name);
		assertEquals(couchA.getDescription(), description);

		assertEquals(couchB.getId(), idB);
		assertEquals(couchB.getName(), name);
		assertEquals(couchB.getDescription(), description);
	}

}

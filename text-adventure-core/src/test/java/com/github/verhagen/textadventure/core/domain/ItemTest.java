package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.NullContainer;

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
		IItem key = new Item(name, description, Boolean.TRUE, Boolean.FALSE);

		assertEquals(key.getId(), name);
		assertEquals(key.getName(), name);
		assertEquals(key.getDescription(), description);
		assertTrue(key.isPorable(), "The key should be portable.");
		assertFalse(key.isContainer(), "The key should not be a container.");
	}

	@Test(expectedExceptions = NullContainer.ContainerException.class)
	public void keyCanNotHoldItems() {
		IItem key = new Item(null, "key", null, Boolean.TRUE, Boolean.FALSE);
		key.contains("box");
		key.isEmpty();
		key.getItems();
		key.add(createBook());
	}
	
	@Test(expectedExceptions = NullContainer.ContainerException.class)
	public void keyCanNotHoldItemsToRemove() {
		IItem key = new Item(null, "key", null, Boolean.TRUE, Boolean.FALSE);
		key.contains("box");
		key.contains(new Item("box", null));
		key.isEmpty();
		key.remove("box");
		key.add(createBook());
	}
	
	@Test(expectedExceptions = NullContainer.ContainerException.class)
	public void keyCanNotHoldItemsToRemoveBox() {
		IItem key = new Item(null, "key", null, Boolean.TRUE, Boolean.FALSE);
		key.contains("box");
		key.isEmpty();
		key.remove(new Item("box", null));
		key.add(createBook());
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
	public void cabinetCanHoldItems() {
		IItem cabinet = new Item(null, "cabinet", null, Boolean.FALSE, Boolean.TRUE);
		assertTrue(cabinet.isEmpty(), "The cabinet should be empty.");
		
		cabinet.add(createBook());
		assertFalse(cabinet.isEmpty(), "The cabinet should not be empty.");
		
		Set<IItem> items = cabinet.getItems();
		assertFalse(items.isEmpty(), "There should be a book in the items collection.");
		assertEquals(items.size(), 1, "Only the book should be in the collection");
		IItem item = items.iterator().next();
		assertEquals(item.getName(), "book");
		assertEquals(item.getDescription(), "TRS-80 Assembly-Language Programming");

		IItem book = cabinet.remove(item);
		assertTrue(cabinet.isEmpty(), "The cabinet should be empty.");
		
		cabinet.add(book);
		assertFalse(cabinet.isEmpty(), "The cabinet should not be empty.");
		assertTrue(cabinet.contains(book));
		assertTrue(cabinet.contains("book"));

		IItem sameBook = cabinet.remove("book");
		assertTrue(cabinet.isEmpty(), "The cabinet should be empty.");
		assertFalse(cabinet.contains("book"));
		
		assertEquals(book, sameBook);
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

	private Item createBook() {
		return new Item("book", "TRS-80 Assembly-Language Programming");
	}

}

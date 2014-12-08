package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.impl.command.WorldRegistery;
import com.github.verhagen.textadventure.core.impl.domain.Location;
import com.github.verhagen.textadventure.core.impl.domain.World;

public class WorldRegisteryTest {
	
	@Test
	public void register() {
		WorldRegistery worldRegistery = new WorldRegistery();
		worldRegistery.register(createWorld());

		assertTrue(worldRegistery.exists("the house quest"));
		assertFalse(worldRegistery.exists("kings quest"));

		IWorld world = worldRegistery.get("the house quest");
		assertNotNull(world, "Expected to find world.");
		assertEquals(world.getId(), "the house quest");
		assertEquals(world.getName(), "The house quest");
		assertEquals(world.getDescription(), "Find your way out of the house.");
	}

	@Test(expectedExceptions = TextAdventureRuntimeException.class)
	public void unknownWorld() {
		WorldRegistery worldRegistery = new WorldRegistery();
		worldRegistery.get("adventure");
	}

	private IWorld createWorld() {
		World world = new World("The house quest", "Find your way out of the house.");
		world.add(createKitchen());
		ILocation hall = createHall();
		world.add(hall);
		world.add(createLiving());
		world.setStartLocation(hall.getId());
		return world;
	}

	private ILocation createKitchen() {
		return new Location("kitchen", "The kitchen is clean.");
	}

	private ILocation createHall() {
		return new Location("hall", "The hall is a little dark.");
	}

	private ILocation createLiving() {
		return new Location("living", "It is nice tidy here.");
	}
	
}

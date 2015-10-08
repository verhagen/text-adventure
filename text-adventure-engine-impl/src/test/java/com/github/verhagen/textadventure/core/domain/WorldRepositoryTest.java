package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.impl.domain.Location;
import com.github.verhagen.textadventure.core.impl.domain.World;
import com.github.verhagen.textadventure.core.impl.domain.WorldRepository;

public class WorldRepositoryTest {
	
	@Test
	public void register() {
		WorldRepository worldRepo = new WorldRepository();
		worldRepo.register(createWorld());

		assertTrue(worldRepo.exists("the house quest"));
		assertFalse(worldRepo.exists("kings quest"));

		assertNotNull(worldRepo.getWorlds());
        assertEquals(worldRepo.getWorlds().size(), 1);
        assertEquals(worldRepo.getWorlds().iterator().next().getId(), "the house quest");
		
		IWorld world = worldRepo.get("the house quest");
		assertNotNull(world, "Expected to find world.");
		assertEquals(world.getId(), "the house quest");
		assertEquals(world.getName(), "The house quest");
		assertEquals(world.getDescription(), "Find your way out of the house.");
	}

	@Test(expectedExceptions = TextAdventureRuntimeException.class)
	public void unknownWorld() {
		WorldRepository worldRegistery = new WorldRepository();
		worldRegistery.get("adventure");
	}


	public WorldRepository createWorldRepository() {
		WorldRepository worldRepo = new WorldRepository();
		worldRepo.register(createWorld());
		return worldRepo;
	}

	private IWorld createWorld() {
		World world = new World("The house quest", "Find your way out of the house.");
		world.add(createKitchen());
		ILocation hall = createHall();
		hall.add(ItemTest.createBook());
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

package com.github.verhagen.textadventure.core.domain;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.impl.domain.Location;
import com.github.verhagen.textadventure.core.impl.domain.Player;
import com.github.verhagen.textadventure.core.impl.domain.World;

public class WorldTest {

	@Test(expectedExceptions = TextAdventureRuntimeException.class)
	public void noLocations() {
		IWorld world = new World(null, "sample", null);
		world.start(createPlayer());
	}

	@Test
	public void addAndGetLocation() {
		World world = createWorld();
		
		Map<String, ILocation> locations = world.getLocations();
		assertEquals(locations.size(), 2, "This world should have 2 locations.");
		Iterator<String> iter = locations.keySet().iterator();
		String locationId = iter.next();
		assertEquals(world.get(locationId).getDescription(), "The kitchen looks clean and tidy.");
		locationId = iter.next();
		assertEquals(world.get(locationId).getDescription(), "There are some chairs and a sofa. In the corner stand a television.");
	}

	private World createWorld() {
		World world = new World(null, "Kitchen and Living", null);
		world.add(createKitchen());
		world.add(createLiving());
		world.start(createPlayer());
		return world;
	}

	private ILocation createKitchen() {
		return new Location("kitchen", "The kitchen looks clean and tidy.");
	}

	private ILocation createLiving() {
		return new Location("living", "There are some chairs and a sofa. In the corner stand a television.");
	}

	private IPlayer createPlayer() {
		return new Player("indiana.jones-lucasfilm.com", "Indiana Jones");
	}

}
package com.github.verhagen.textadventure.core;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Set;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.domain.IWorld;
import com.github.verhagen.textadventure.core.domain.WorldRepositoryTest;
import com.github.verhagen.textadventure.core.impl.domain.WorldRepository;

public class GameEngineTest {

	@Test
	public void startGameEngine() {
		WorldRepository worldRepo = new WorldRepositoryTest().createWorldRepository();
		GameEngine gameEngine = new GameEngine(worldRepo);
		
		Set<IWorld> worlds = gameEngine.getWorlds();
		assertFalse(worlds.isEmpty(), "The game-engine should come with at least one world.");
		IWorld world = worlds.iterator().next();
		Account james = new Account("James", "james@adventure.com");
        gameEngine.start(world.getId(), james);
		
		String result = gameEngine.execute(james, "get key");
		assertEquals(result, "You pick-up a key.");
	}

	@Test(expectedExceptions = TextAdventureRuntimeException.class)
	public void startGameEngineNoWorlds() {
		GameEngine gameEngine = new GameEngine(new WorldRepository());
		gameEngine.start("house-quest", new Account("James", "james@adventure.com"));
	}

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void startGameEngineNoUser() {
        GameEngine gameEngine = new GameEngine(new WorldRepository());
        gameEngine.start("house-quest", null);
    }

}

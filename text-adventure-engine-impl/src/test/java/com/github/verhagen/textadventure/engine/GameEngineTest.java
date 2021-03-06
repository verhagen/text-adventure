package com.github.verhagen.textadventure.engine;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Set;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.engine.Account;
import com.github.verhagen.textadventure.engine.GameEngine;
import com.github.verhagen.textadventure.engine.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.engine.domain.IWorld;
import com.github.verhagen.textadventure.engine.domain.WorldRepositoryTest;
import com.github.verhagen.textadventure.engine.impl.domain.WorldRepository;

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
		assertEquals(result, "Nothing here that looks like a key");

		result = gameEngine.execute(james, "get book");
        assertEquals(result, "You took the book");
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

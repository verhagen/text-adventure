package com.github.verhagen.textadventure.core;

import java.util.Set;

import com.github.verhagen.textadventure.core.domain.IWorld;
import com.github.verhagen.textadventure.core.domain.IWorldRepository;

public class GameEngine {
	private IWorldRepository worldRepo;


	public GameEngine(final IWorldRepository worldRepo) {
		this.worldRepo = worldRepo;
	}


	public Set<IWorld> getWorlds() {
		return worldRepo.getWorlds();
	}

	public void start(final String worldId) {
		if (! worldRepo.exists(worldId)) {
			throw new TextAdventureRuntimeException("World with id '" + worldId + "' does not exist.");
		}
		
		
	}

	public String execute(String string) {
		return "You pick-up a key.";
	}

}

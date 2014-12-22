package com.github.verhagen.textadventure.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.github.verhagen.textadventure.core.command.ICommandRegistery;
import com.github.verhagen.textadventure.core.domain.IWorld;
import com.github.verhagen.textadventure.core.domain.IWorldRepository;

public class GameEngine {
    private PlayerFactory playerFactory = GameBeans.getPlayerFactory();
    private ICommandRegistery commandRegistery = GameBeans.getCommandRegistery();
	private IWorldRepository worldRepo;
	private Map<Account, IWorld> worldPerUser = new HashMap<>();


	public GameEngine(final IWorldRepository worldRepo) {
		this.worldRepo = worldRepo;
	}


	public Set<IWorld> getWorlds() {
		return worldRepo.getWorlds();
	}

	public IWorld start(final String worldId, Account user) {
	    if (user == null) {
	        throw new IllegalArgumentException("Argument 'user' is required.");
	    }
		if (! worldRepo.exists(worldId)) {
			throw new TextAdventureRuntimeException("World with id '" + worldId + "' does not exist.");
		}
		
		IWorld world = worldRepo.get(worldId);
		world.start(playerFactory.create(user));
		worldPerUser.put(user, world);
		return world;
	}

	public String execute(Account account, String commandStr) {
	    String commandName = commandStr.substring(0, commandStr.indexOf(' '));
	    Boolean commandExists = commandRegistery.exists(commandName);
	    if (commandExists) {
	        return worldPerUser.get(account).execute(commandRegistery.get(commandName), commandStr.substring(commandStr.indexOf(' ')));
	    }
	    return "Not sure what to do.";
	}

}

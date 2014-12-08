package com.github.verhagen.textadventure.core.impl.command;

import java.util.Map;
import java.util.TreeMap;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.domain.IWorld;
import com.github.verhagen.textadventure.core.domain.IWorldRegistery;

public class WorldRegistery implements IWorldRegistery {
	private Map<String, IWorld> worlds = new TreeMap<>();

	public void register(IWorld world) {
		worlds.put(world.getId(), world);
	}

	@Override
	public Boolean exists(final String id) {
		if (worlds.containsKey(id)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public IWorld get(final String id) {
		if (! worlds.containsKey(id)) {
			throw new TextAdventureRuntimeException("There is not world with id '" + id + "'.");
		}
		return worlds.get(id);
	}

}
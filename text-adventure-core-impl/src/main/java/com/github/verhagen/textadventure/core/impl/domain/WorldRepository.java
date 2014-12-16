package com.github.verhagen.textadventure.core.impl.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.domain.IWorld;
import com.github.verhagen.textadventure.core.domain.IWorldRepository;

public class WorldRepository implements IWorldRepository {
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

    @Override
    public Set<IWorld> getWorlds() {
        return Collections.unmodifiableSet(new HashSet<IWorld>(worlds.values()));
    }

}

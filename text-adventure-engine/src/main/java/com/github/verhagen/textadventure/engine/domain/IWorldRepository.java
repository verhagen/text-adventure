package com.github.verhagen.textadventure.engine.domain;

import java.util.Set;

public interface IWorldRepository {

    Set<IWorld> getWorlds();

	Boolean exists(final String id);

	IWorld get(final String id);

}

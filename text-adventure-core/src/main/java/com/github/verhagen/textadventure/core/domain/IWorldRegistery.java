package com.github.verhagen.textadventure.core.domain;

import java.util.Set;

public interface IWorldRegistery {

    Set<IWorld> getWorlds();

	Boolean exists(final String id);

	IWorld get(final String id);

}

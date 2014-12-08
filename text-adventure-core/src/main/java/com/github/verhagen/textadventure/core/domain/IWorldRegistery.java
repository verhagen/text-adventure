package com.github.verhagen.textadventure.core.domain;

public interface IWorldRegistery {

	Boolean exists(String id);

	IWorld get(String id);

}

package com.github.verhagen.textadventure.core.domain;

public interface IContainer {

	Boolean isEmpty();

	Boolean contains(final String id);

	Boolean contains(final IItem item);

	void add(final IItem item);

	IItem remove(final IItem item);

	IItem remove(final String id);

}

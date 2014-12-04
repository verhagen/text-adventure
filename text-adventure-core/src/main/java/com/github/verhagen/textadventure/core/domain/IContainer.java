package com.github.verhagen.textadventure.core.domain;

import java.util.Set;

public interface IContainer {

	Boolean isEmpty();

	Boolean contains(final String id);

	Boolean contains(final IItem item);

	void add(final IItem item);

	IItem remove(final IItem item);

	IItem remove(final String id);

	Set<IItem> getItems();

}

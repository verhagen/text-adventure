package com.github.verhagen.textadventure.engine.impl.domain;

import java.util.Set;

import com.github.verhagen.textadventure.engine.domain.IContainer;
import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.domain.ILocation;
import com.github.verhagen.textadventure.engine.domain.IObjectVisitor;

public final class Location extends Object implements ILocation {
	private IContainer container = new Container();

	public Location(final String name, final String description) {
		this(name, description, null);
	}
    public Location(final String name, final String description, Set<String> aliases) {
        super(null, name, description, aliases);
    }

	@Override
	public Boolean isEmpty() {
		return container.isEmpty();
	}

	@Override
	public Boolean contains(String id) {
		return container.contains(id);
	}

	@Override
	public Boolean contains(IItem item) {
		return container.contains(item);
	}

	@Override
	public void add(IItem item) {
		container.add(item);
	}

	@Override
	public IItem remove(String id) {
		return container.remove(id);
	}

	@Override
	public IItem remove(IItem item) {
		return container.remove(item);
	}

	@Override
	public Set<IItem> getItems() {
		return container.getItems();
	}

	@Override
	public void accept(IObjectVisitor visitor) {
		visitor.accept(this);
		visitor.accept(container);
	}

}

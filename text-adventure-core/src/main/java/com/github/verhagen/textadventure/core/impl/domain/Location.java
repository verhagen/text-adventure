package com.github.verhagen.textadventure.core.impl.domain;

import java.util.Set;

import com.github.verhagen.textadventure.core.domain.IContainer;
import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.ILocation;

public final class Location extends Object implements ILocation {
	private IContainer container = new Container();

	public Location(String name, String description) {
		super(name, description);
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

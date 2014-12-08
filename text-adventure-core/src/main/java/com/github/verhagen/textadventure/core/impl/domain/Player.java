package com.github.verhagen.textadventure.core.impl.domain;

import java.util.Set;

import com.github.verhagen.textadventure.core.domain.IContainer;
import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.ILocation;
import com.github.verhagen.textadventure.core.domain.IPlayer;

public class Player implements IPlayer {
	private final String id;
	private final String name;
	private final IContainer container = new Container();
	private ILocation location;
	

	public Player(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ILocation getLocation() {
		return location;
	}

	@Override
	public void get(final String id) {
		if (getLocation().contains(id)) {
			IItem item = getLocation().remove(id);
			add(item);
		}
	}

	@Override
	public void drop(final String id) {
		if (contains(id)) {
			IItem item = remove(id);
			getLocation().add(item);
		}
	}

	@Override
	public void setLocation(final ILocation location) {
		this.location = location;
	}

	
	// Container methods
	
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
	public IItem remove(IItem item) {
		return container.remove(item);
	}

	@Override
	public IItem remove(String id) {
		return container.remove(id);
	}

	@Override
	public Set<IItem> getItems() {
		return container.getItems();
	}

}

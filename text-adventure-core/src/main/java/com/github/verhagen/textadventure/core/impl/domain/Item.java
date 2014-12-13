package com.github.verhagen.textadventure.core.impl.domain;

import java.util.Set;

import com.github.verhagen.textadventure.core.domain.IContainer;
import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IObjectVisitor;

public final class Item extends Object implements IItem, Comparable<IItem> {
	private final Boolean isPortable;
	private final Boolean isContainer;
	private final IContainer container;

	public Item(final String name, final String description) {
		this(null, name, description);
	}
	public Item(final String id, final String name, final String description) {
		this(id, name, description, Boolean.FALSE, Boolean.FALSE);
	}
	public Item(final String name, final String description,
			final Boolean isPortable, final Boolean isContainer) {
		this(null, name, description, isPortable, isContainer);
	}
    public Item(final String id, final String name, final String description,
            final Boolean isPortable, final Boolean isContainer) {
        this(id, name, description, isPortable, isContainer, null);
    }
	public Item(final String id, final String name, final String description,
			final Boolean isPortable, final Boolean isContainer, final Set<String> aliases) {
		super(id, name, description, aliases);
		this.isPortable = isPortable;
		this.isContainer = isContainer;
		if (isContainer) {
			this.container = new Container();
		}
		else {
			this.container = new NullContainer();
		}
	}

	@Override
	public Boolean isPorable() {
		return isPortable;
	}

	@Override
	public Boolean isContainer() {
		return isContainer;
	}

	@Override
	public void accept(IObjectVisitor visitor) {
		visitor.accept(this);
	}
	@Override
	public int compareTo(IItem otherItem) {
		return this.getId().compareTo(otherItem.getName());
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

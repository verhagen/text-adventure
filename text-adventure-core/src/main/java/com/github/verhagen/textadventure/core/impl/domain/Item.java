package com.github.verhagen.textadventure.core.impl.domain;

import com.github.verhagen.textadventure.core.domain.IItem;

public final class Item extends Object implements IItem {
	private final Boolean isPortable;
	private final Boolean isContainer;

	public Item(final String name, final String description) {
		this(name, description, Boolean.FALSE, Boolean.FALSE);
	}
	public Item(final String name, final String description,
			final Boolean isPortable, final Boolean isContainer) {
		super(name, description);
		this.isPortable = isPortable;
		this.isContainer = isContainer;
	}

	@Override
	public Boolean isPorable() {
		return isPortable;
	}

	@Override
	public Boolean isContainer() {
		return isContainer;
	}

}

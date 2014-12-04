package com.github.verhagen.textadventure.core.impl.domain;

import com.github.verhagen.textadventure.core.domain.IObject;

public abstract class Object implements IObject {
	private final String name;
	private final String description;


	public Object(final String name, final String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
}

package com.github.verhagen.textadventure.core.impl.domain;

import com.github.verhagen.textadventure.core.domain.IObject;

public abstract class Object implements IObject {
	private final String id;
	private final String name;
	private final String description;


	public Object(final String name, final String description) {
		this(null, name, description);
	}
	public Object(final String id, final String name, final String description) {
		if (id != null) {
			this.id = id;
		}
		else {
			this.id = name.toLowerCase();
		}
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	
}

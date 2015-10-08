package com.github.verhagen.textadventure.engine.impl.domain;

import java.util.Collections;
import java.util.Set;

import com.github.verhagen.textadventure.engine.domain.IObject;

public abstract class Object implements IObject {
	private final String id;
	private final String name;
	private final Set<String> aliases;
	private final String description;


	public Object(final String name, final String description) {
		this(null, name, description);
	}
    public Object(final String id, final String name, final String description) {
        this(id, name, description, null);
    }
	public Object(final String id, final String name, final String description, final Set<String> aliases) {
		if (id != null) {
			this.id = id;
		}
		else {
			this.id = name.toLowerCase();
		}
		this.name = name;
		
		if (aliases != null) {
		    this.aliases = aliases;
		}
		else {
		    this.aliases = Collections.emptySet();
		}
		
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
    public Set<String> getAliases() {
        return aliases;
    }

    @Override
	public String getDescription() {
		return description;
	}

}

package com.github.verhagen.textadventure.core.impl.domain;

import java.util.HashMap;
import java.util.Map;

import com.github.verhagen.textadventure.core.domain.IContainer;
import com.github.verhagen.textadventure.core.domain.IItem;

public class Container implements IContainer {
	private Map<String, IItem> content = new HashMap<>();

	@Override
	public Boolean isEmpty() {
		return content.isEmpty();
	}

	@Override
	public Boolean contains(String id) {
		return content.containsKey(id);
	}

	@Override
	public Boolean contains(IItem item) {
		return contains(item.getId());
	}

	@Override
	public void add(IItem item) {
		content.put(item.getId(), item);
	}

	@Override
	public IItem remove(String id) {
		if (contains(id)) {
			return content.remove(id);
		}
		return null;
	}

	@Override
	public IItem remove(IItem item) {
		return remove(item.getId());
	}

}

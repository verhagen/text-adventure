package com.github.verhagen.textadventure.core.impl.domain;

import java.util.Set;

import com.github.verhagen.textadventure.core.domain.IContainer;
import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.IRoom;

public class TextVisitor implements IObjectVisitor {
	private StringBuilder bldr = new StringBuilder();


	@Override
	public void accept(IItem item) {
		bldr.append(item.getName());
	}

	@Override
	public void accept(IRoom room) {
		bldr.append(room.getDescription());
	}

	@Override
	public void accept(IContainer container) {
		if (! container.isEmpty()) {
			bldr.append("Items: ");
			for (IItem item : container.getItems()) {
				item.accept(this);
			}
		}
	}

	public String asText() {
		return bldr.toString();
	}
}

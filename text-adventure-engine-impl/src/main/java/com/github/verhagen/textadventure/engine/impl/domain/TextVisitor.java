package com.github.verhagen.textadventure.engine.impl.domain;

import com.github.verhagen.textadventure.engine.domain.IContainer;
import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.domain.ILocation;
import com.github.verhagen.textadventure.engine.domain.IObjectVisitor;

public class TextVisitor implements IObjectVisitor {
	private StringBuilder bldr = new StringBuilder();


    @Override
    public void append(String text) {
        bldr.append(text);
    }


	@Override
	public void accept(IItem item) {
		bldr.append(item.getName());
	}

	@Override
	public void accept(ILocation room) {
		bldr.append("You are in a " + room.getName() + ".");
		if (room.getDescription() != null) {
			bldr.append(" ");
			bldr.append(room.getDescription());
		}
	}

	@Override
	public void accept(IContainer container) {
		if (! container.isEmpty()) {
			bldr.append(" ");
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

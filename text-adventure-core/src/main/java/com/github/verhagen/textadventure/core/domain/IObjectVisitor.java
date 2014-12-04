package com.github.verhagen.textadventure.core.domain;

public interface IObjectVisitor {

	void accept(IItem item);

	void accept(IRoom room);

	void accept(IContainer container);

}

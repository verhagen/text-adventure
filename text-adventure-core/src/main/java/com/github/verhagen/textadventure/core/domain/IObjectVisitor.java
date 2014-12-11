package com.github.verhagen.textadventure.core.domain;

public interface IObjectVisitor {

	void accept(IItem item);

	void accept(ILocation room);

	void accept(IContainer container);

    void append(String string);

}

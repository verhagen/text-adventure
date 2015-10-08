package com.github.verhagen.textadventure.core.domain;

import java.util.Set;

public interface IItem extends IObject, IContainer {
	
	Boolean isPorable();
	
	Boolean isContainer();

	Set<String> getAttributeNames();

	void addAttribute(IAttribute<?> attribute);
	
	IAttribute<?> getAttribute(final String name);

}

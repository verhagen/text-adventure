package com.github.verhagen.textadventure.core.domain;

import java.util.Set;

public interface IObject {
	
	String getId();

	String getName();
	
	Set<String> getAliases();
	
	String getDescription();

	void accept(final IObjectVisitor visitor);

}

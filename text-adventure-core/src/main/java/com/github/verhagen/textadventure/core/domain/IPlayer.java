package com.github.verhagen.textadventure.core.domain;

public interface IPlayer extends IContainer {

	String getId();

	String getName();
	
	ILocation getLocation();

	void get(String id);
	
	void drop(String id);

	void setLocation(ILocation startLocation);

}

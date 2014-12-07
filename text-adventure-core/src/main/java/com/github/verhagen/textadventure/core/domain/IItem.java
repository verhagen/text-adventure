package com.github.verhagen.textadventure.core.domain;

public interface IItem extends IObject, IContainer {
	
	Boolean isPorable();
	
	Boolean isContainer();

}

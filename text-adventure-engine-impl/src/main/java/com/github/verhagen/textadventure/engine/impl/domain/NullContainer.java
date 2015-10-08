package com.github.verhagen.textadventure.engine.impl.domain;

import java.util.Collections;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.textadventure.engine.domain.IContainer;
import com.github.verhagen.textadventure.engine.domain.IItem;

public final class NullContainer implements IContainer {
	private final Logger logger = LoggerFactory.getLogger(NullContainer.class);

	@Override
	public Boolean isEmpty() {
		logger.info("The " + NullContainer.class.getSimpleName() + " should never be called!");
		return Boolean.TRUE;
	}

	@Override
	public Boolean contains(String id) {
		logger.info("The " + NullContainer.class.getSimpleName() + " should never be called!");
		return Boolean.FALSE;
	}

	@Override
	public Boolean contains(IItem item) {
		logger.info("The " + NullContainer.class.getSimpleName() + " should never be called!");
		return Boolean.FALSE;
	}

	@Override
	public void add(IItem item) {
		throw new ContainerException();
	}

	@Override
	public IItem remove(IItem item) {
		throw new ContainerException();
	}

	@Override
	public IItem remove(String id) {
		throw new ContainerException();
	}

	@Override
	public Set<IItem> getItems() {
		logger.info("The " + NullContainer.class.getSimpleName() + " should never be called!");
		return Collections.emptySet();
	}


	public final class ContainerException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public ContainerException() {
			super("This is not a container. It can not hold anything.");
		}
		
	}

}

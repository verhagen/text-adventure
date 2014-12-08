package com.github.verhagen.textadventure.core.impl.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.textadventure.core.TextAdventureRuntimeException;
import com.github.verhagen.textadventure.core.command.ICommand;
import com.github.verhagen.textadventure.core.domain.ILocation;
import com.github.verhagen.textadventure.core.domain.IObjectVisitor;
import com.github.verhagen.textadventure.core.domain.IPlayer;
import com.github.verhagen.textadventure.core.domain.IWorld;

public class World extends Object implements IWorld {
	private final Logger logger = LoggerFactory.getLogger(World.class);
	
	private String startLocationId;
	private Map<String, ILocation> locations = new TreeMap<>();
	private IPlayer player;

	
	public World(String id, String name, String description) {
		super(id, name, description);
	}

	public World(String name, String description) {
		super(name, description);
	}

	public void add(ILocation location) {
		locations.put(location.getId(), location);
	}

	public Map<String, ILocation> getLocations() {
		return Collections.unmodifiableMap(locations);
	}

	public ILocation get(String id) {
		return locations.get(id);
	}

	public ILocation getStartLocation() {
		if (startLocationId == null) {
			if (locations.size() == 0) {
				throw new TextAdventureRuntimeException("This world '" + getName() 
							+ "', does not contain any locations.");
			}
			ILocation location = locations.values().iterator().next();
			startLocationId = location.getId();
			logger.warn("No startLocationId was set, will use '" + 
					location.getName() + "'.");
		}
		return get(startLocationId);
	}

	@Override
	public String execute(ICommand command, String[] args) {
		TextVisitor visitor = new TextVisitor();
		command.execute(player, visitor, args);
		return visitor.asText();
	}

	@Override
	public void accept(IObjectVisitor visitor) {
		logger.info("The visitor does currently nothing.");
	}

	public void start(final IPlayer player) {
		this.player = player;
		this.player.setLocation(getStartLocation());
	}

}

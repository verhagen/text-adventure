package com.github.verhagen.textadventure.core.command;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.domain.IPlayer;
import com.github.verhagen.textadventure.core.impl.command.CommandLook;
import com.github.verhagen.textadventure.core.impl.domain.Location;
import com.github.verhagen.textadventure.core.impl.domain.Player;
import com.github.verhagen.textadventure.core.impl.domain.World;

public class CommandLookTest {

	@Test
	public void look() {
		World world = new World(null, "Indiana Jones and the Emperor's Tomb", null);
		world.add(new Location("londen-center", "In the distance you see the big bang."));
		world.start(createPlayer());
		ICommand look = new CommandLook();
		String expected = "You are in a londen-center. In the distance you see the big bang.";
		
		String result = world.execute(look, null);
		assertEquals(result, expected);
	}


	private IPlayer createPlayer() {
		return new Player("indiana.jones-lucasfilm.com", "Indiana Jones");
	}

}

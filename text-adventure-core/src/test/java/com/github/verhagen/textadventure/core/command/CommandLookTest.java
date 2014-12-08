package com.github.verhagen.textadventure.core.command;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IPlayer;
import com.github.verhagen.textadventure.core.impl.command.CommandLook;
import com.github.verhagen.textadventure.core.impl.domain.Item;
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

	@Test
	public void lookAtTomb() {
		World world = new World(null, "Emperor's Tomb", null);
		Location crypt = createCrypt();
		IItem tomb = createTomb();
		crypt.add(tomb);
		world.add(crypt);
		world.start(createPlayer());
		ICommand look = new CommandLook();
		// FIXME Correct feedback, does not include tomb description
		String expected = "You are in a crypt. The crypt is cold and dark. A slight beam of light, shows that the tomb stands in the middle of the room."
				+ " Items: tomb";
		
		String result = world.execute(look, new String[] { tomb.getName() });
		assertEquals(result, expected);
	}

	private Location createCrypt() {
		return new Location("crypt", "The crypt is cold and dark. A slight beam of light, shows that the tomb stands in the middle of the room.");
	}

	private IItem createTomb() {
		return new Item("tomb", "The tomb has lots of amazing egravings.");
	}

	private IPlayer createPlayer() {
		return new Player("indiana.jones-lucasfilm.com", "Indiana Jones");
	}

}

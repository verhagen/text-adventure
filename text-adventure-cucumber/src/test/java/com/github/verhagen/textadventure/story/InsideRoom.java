package com.github.verhagen.textadventure.story;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IRoom;
import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.Room;
import com.github.verhagen.textadventure.core.impl.domain.TextVisitor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InsideRoom {
	private IRoom room;
	private Map<String, IItem> items = new HashMap<>(); 

	@Given("^a room called hall$")
	public void aRoomCalledHall() {
		System.out.println("[In the hall]");

		room = new Room("hall", "This is the hall.");
		items.put("book", new Item("book", "TRS-80 Color Computer Programs"));
		items.put("key", new Item("key", "A cylinder key"));
	}
	
	@When("^the command '(.*?)' is given$")
	public void theCommandIsGiven(String command) {
		System.out.println("[Command: '" + command + "']");
	}
	
	@When("^add item '(.*?)' is given$")
	public void addItemIsGiven(String item) {
		System.out.println("[add item: '" + item + "']");

		room.add(items.get(item));
	}

	@Then("^the description should be '(.*?)'$")
	public void theDescriptionShouldBe(String description) {
		System.out.println("[Expected description: '" + description + "']");

		TextVisitor visitor = new TextVisitor();
		room.accept(visitor);
		
		assertThat(visitor.asText(), equalTo(description));
	}
}

package com.github.verhagen.textadventure.story;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.domain.ILocation;
import com.github.verhagen.textadventure.engine.impl.domain.Item;
import com.github.verhagen.textadventure.engine.impl.domain.Location;
import com.github.verhagen.textadventure.engine.impl.domain.TextVisitor;

public class ItemInRoomSteps {
	private ILocation room;
	private Map<String, IItem> items = new HashMap<>(); 
	
	@Given("a room called hall")
	public void givenARoomCalledHall() {
		room = new Location("hall", "There is some light comming in the hall, through a window next to the front door.");
		items.put("book", new Item("book", "TRS-80 Color Computer Programs"));
		items.put("key", new Item("key", "A cylinder key"));
	}

	@When("add item $item is given")
	public void addItemIsGiven(String item) {
		room.add(items.get(item));
	}

	@Then("the description should be $description")
	public void thenTheDescriptionShouldBe(String description) {
		TextVisitor visitor = new TextVisitor();
		room.accept(visitor);
		
		assertThat(visitor.asText(), equalTo(description));
	}

	@When("the command $command is given")
	public void whenTheCommandLookIsGiven(String command) {
		//
	}

}
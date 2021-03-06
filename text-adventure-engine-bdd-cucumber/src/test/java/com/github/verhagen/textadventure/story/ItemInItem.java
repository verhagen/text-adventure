package com.github.verhagen.textadventure.story;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.github.verhagen.textadventure.engine.domain.IItem;
import com.github.verhagen.textadventure.engine.domain.ILocation;
import com.github.verhagen.textadventure.engine.impl.domain.Item;
import com.github.verhagen.textadventure.engine.impl.domain.Location;
import com.github.verhagen.textadventure.engine.impl.domain.TextVisitor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ItemInItem {
	private ILocation room = new Location("hallway", null);
	private IItem cabinet = new Item("cabinet", null, Boolean.FALSE, Boolean.TRUE);
	private IItem box = new Item("box", null, Boolean.TRUE, Boolean.TRUE);
	private IItem key = new Item("key", null, Boolean.TRUE, Boolean.FALSE);
	
	public ItemInItem() {
		room.add(cabinet);
		cabinet.add(box);
		box.add(key);
	}


	@Then("^the feedback should be '(.*?)'$")
	public void thenTheFeedbackShouldBe(String feedback) {
		TextVisitor visitor = new TextVisitor();
		room.accept(visitor);
		
		assertThat(visitor.asText(), equalTo(feedback));
	}

	@Given("^there is a room '(.*?)' with a '(.*?)'.$")
	public void givenThereIsARoomWithAItem(String room, String item) {
		// TODO
		System.out.println("Room '" + room + "' with a '" + item + "'");
	}

}

package com.github.verhagen.textadventure.story;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import com.github.verhagen.textadventure.core.domain.IItem;
import com.github.verhagen.textadventure.core.domain.IRoom;
import com.github.verhagen.textadventure.core.impl.domain.Item;
import com.github.verhagen.textadventure.core.impl.domain.Room;

public class ItemInItemSteps {
	private IRoom room = new Room("hallway", null);
	private IItem cabinet = new Item("cabinet", null, Boolean.FALSE, Boolean.TRUE);
//	private IItem box = new Item("box", null, Boolean.TRUE, Boolean.TRUE);
//	private IItem key = new Item("key", null, Boolean.TRUE, Boolean.FALSE);
	
	public ItemInItemSteps() {
		room.add(cabinet);
//		cabinet.add(box);
//		box.add(key);
	}


	@Then("the feedback should be $feedback")
	public void thenTheFeedbackShouldBe(String feedback) {
		// TODO
		System.out.println("Feedback '" + feedback + "'");
	}

	@Given("there is a room $room with a $item.")
	public void givenThereIsARoomWithAItem(String room, String item) {
		// TODO
		System.out.println("Room '" + room + "' with a '" + item + "'");
	}

}
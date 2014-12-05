package com.github.verhagen.textadventure.story;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InsideRoom {

	@Given("a room called hall")
	public void aRoomCalledHall() {
		System.out.println("In the hall");
	}
	
	@When("the command (\\w) is given")
	public void theCommandIsGiven(String command) {
		System.out.println("Command: '" + command + "'");
	}
	
	@When("add item (\\w) is given")
	public void addItemIsGiven(String item) {
		System.out.println("add item: '" + item + "'");
	}

	@Then("the description should be")
	public void theDescriptionShouldBe(String description) {
		System.out.println("Expected description: '" + description + "'");
	}
}

package com.github.verhagen.textadventure.feature;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.verhagen.textadventure.step.ItemInRoomSteps;

@RunWith(SerenityRunner.class)
public class ItemInRoomFeature {

    @Steps
    ItemInRoomSteps player;

    @Test
    public void ss() {
        // Given
        player.is_in_the_room_called("hall");
        // When
        player.gives_command("look");
        // Then
        player.reads_description("You are in a hall. There is some light coming in the hall, through a window next to the front door.");
        
        // When
        player.adds_item("book");
        // Then
        player.reads_description("You are in a hall. There is some light coming in the hall, through a window next to the front door. Items: book");
    }
    
}

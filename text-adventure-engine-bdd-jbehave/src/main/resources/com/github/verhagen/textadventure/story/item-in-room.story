Items in a Room

Narrative: When inside a room (or at a location) you get information about the
    location and see the items, that are there.
					 
Scenario: Start with an empty hall. Then add a book. 
    And when looking in the hall, the book should be seen.
Given a room called hall
When the command look is given
Then the description should be
You are in a hall. There is some light comming in the hall, through a window next to the front door.
When add item book is given
Then the description should be
You are in a hall. There is some light comming in the hall, through a window next to the front door. Items: book

Scenario: Start with an empty hall. Then add a key. 
    And when looking in the hall, the key should be seen.
Given a room called hall
When the command look is given
When add item key is given
Then the description should be
You are in a hall. There is some light comming in the hall, through a window next to the front door. Items: key


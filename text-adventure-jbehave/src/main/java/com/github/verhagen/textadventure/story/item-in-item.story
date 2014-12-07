Items can contain items

Narrative:
A cabinet is located in a room.
You can not get the cabinet.
A cabinet can contain a box, which can contain a key.
You can get the box.
Once the box is in your inventory, you can get the key. 
					 
Scenario:  A scenario is a collection of executable steps of different type
Given there is a room hallway with a cabinet.
#When the command inventory is given
#Then the feedback should be You are carrying nothing.
When the command look is given
Then the feedback should be You are in a hallway. Items: cabinet

Scenario:
#When the command get cabinet is given
#Then the feedback should be The cabinet is to heavy.
#When the command look cabinet is given
#Then the feedback should be There is a box inside the cabinet

Scenario:  Another scenario exploring different combination of events
#Given there is a room hallway with a cabinet.
#When the command get box is given
#Then the feedback should be I do not see a box
#When the command look cabinet is given
#Then the feedback should be There is a box inside the cabinet
#When the command get box is given
#Then the feedback should be 
#When the command get key is given
#When the command look box is given
#Then the feedback should be There is a key inside
#When the command get key is given
#When the command inventory is given
#Then the feedback should be You are carrying these items: box; key

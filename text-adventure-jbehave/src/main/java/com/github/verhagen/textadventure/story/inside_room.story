Inside a Room

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario: A scenario is a collection of executable steps of different type
Given a room called hall
When the command look is given
Then the description should be
This is the hall.
When add item book is given
Then the description should be
This is the hall.Items: book


Given a room called hall
When the command look is given
When add item key is given
Then the description should be
This is the hall.Items: key


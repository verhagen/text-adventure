Feature: Room
Scenario: A scenario is a collection of executable steps of different type

Given a room called hall
When the command "look" is given
Then the description should be "This is the hall."
#This is the hall.
When add item "book" is given
Then the description should be "This is the hall.Items: book"
#This is the hall.Items: book


Given a room called hall
When the command "look" is given
When add item "key" is given
Then the description should be "This is the hall.Items: key"
#

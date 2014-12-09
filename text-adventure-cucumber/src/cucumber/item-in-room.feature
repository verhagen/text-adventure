Feature: Items in a Room

Scenario: A scenario is a collection of executable steps of different type

Given a room called hall
When the command 'look' is given
Then the description should be 'You are in a hall. There is some light comming in the hall, through a window next to the front door.'
#This is the hall.
When add item 'book' is given
Then the description should be 'You are in a hall. There is some light comming in the hall, through a window next to the front door. Items: book'
#This is the hall.Items: book


Given a room called hall
When the command 'look' is given
When add item 'key' is given
Then the description should be 'You are in a hall. There is some light comming in the hall, through a window next to the front door. Items: key'
#

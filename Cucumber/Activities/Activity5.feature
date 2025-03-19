@activity5
Feature: Login Test

Scenario Outline: Testing with Data from Scenario
Given User is on Login page
When User enters the "<Usernames>" and "<Passwords>"
Then Read the page title and confirmation message1
And Close the Browser1

Examples:
|	Usernames	|		Passwords	|
| admin			|		password	|
| admins		|		password	|

@activity2
Feature: Login Test

Scenario: Testing Login
Given User is on login page
When User enters Username and Password
Then Read the Title and Confirmation message
And Close the browser
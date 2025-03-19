@activity3
 Feature: Testing with Tags
 
@SimpleAlert @SmokeTest
Scenario: Testing with Simple Alert
Given User is on the alert page
When User clicks the simple alert button
Then Alert opens
And Read the Text from it and print it
And Close the alert
And Read the result text
And Close Browser

@ConfirmAlert
Scenario: Testing with Confirm Alert
Given User is on the alert page
When User clicks the Confirm alert button
Then Alert opens
And Read the Text from it and print it
And Close the alert with Cancel
And Read the result text
And Close Browser

@PromptAlert
Scenario Outline: Testing with Prompt Alert
Given User is on the alert page
When User clicks the Prompt Alert button
Then Alert opens
And Read the Text from it and print it
And Write a custom message in it
And Close the alert
And Read the result text
And Close Browser

#Author: zakir
#Date: 09/26/2022
#Gherkin

Feature: Login functionality
Description: Testing the login functionality
Background: 
Given user is in login page
@Amazon5236
Scenario: login using standard user credentials

Given user is in login page
When user insert standard user in the user name text box
And user insert password in the password text box
And user click on the login button
Then user able to login

@mehdi @sanity @smoke
Scenario: login using problem user credentials

#Given user is in login page
When user insert problem user in the user name text box
And user insert password in the password text box
And user click on the login button
Then user able to login


Scenario: login using locked out user credentials

#Given user is in login page
When user insert locked out user in the user name text box
And user insert password in the password text box
And user click on the login button
Then user able to login

@mehdi
Scenario: login using performance glitch user credentials

#Given user is in login page
When user insert performance glitch user in the user name text box
And user insert password in the password text box
And user click on the login button
Then user able to login

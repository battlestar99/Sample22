#Author: zakir
#Date: 09/26/2022
#Gherkin
@mehdi @regression
Feature: Login functionality with data
  Description: Testing the login functionality with data

  Scenario Outline: login using all user credentials
    Given user is in login page using "<browser>"
    When user insert "<username>" in the user name text box
    And user insert "<password>" in the password text box
    And user click on the login button
    Then user able to login

    Examples: 
      | username                | password     |browser|
      | standard_user           | secret_sauce |chrome|
      | locked_out_user         | secret_sauce |chrome|
      | problem_user            | secret_sauce |firefox|
      | performance_glitch_user | secret_sauce |chrome|

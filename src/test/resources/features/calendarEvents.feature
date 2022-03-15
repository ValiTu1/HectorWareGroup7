Feature: Calendar functionality
  Background:
    Given user is on the login page
    And user enters valid username "Employee1" and password "Employee123"
    And user navigates to Calendar page

  Scenario: User should check the daily calendar functionality
    When user clicks on hamburger button
    And user clicks on daily calendar button
    Then user should be on the daily calendar

  Scenario: User should check the weekly calendar functionality
    When user clicks on hamburger button
    And user clicks on weekly calendar button
    Then user should be on the daily calendar

  Scenario: User should check the monthly calendar functionality
    When user clicks on hamburger button
    And user clicks on monthly calendar button
    Then user should be on the daily calendar
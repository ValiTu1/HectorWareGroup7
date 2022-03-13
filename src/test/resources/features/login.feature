
Feature: Login functionality

  @smoke
  Scenario: registered users can login
    Given user is on the login page
    When user enters valid username "Employee1" and password "Employee123"
    Then index page should be displayed
@HECW-234
Feature: Upload File functionality

  @HECW-234
  Scenario: registered users can login
    Given user is on the login page
    When user enters valid username "Employee1" and password "Employee123"
    Then user clicks addButton
    And user chooses "Upload file" option
    Then user selects a file from directory
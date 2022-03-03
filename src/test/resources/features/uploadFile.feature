@xyz123
Feature: Upload File functionality
  @xyz123

  Scenario: registered users can login
    Given user is on the login page
    When user enters valid username "Employee1" and password "Employee123"
    Then user clicks addButton
    And user chooses "Upload file" option
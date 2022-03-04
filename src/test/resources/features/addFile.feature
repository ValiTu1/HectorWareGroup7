@HECW-181
Feature: Add File functionality
  Background:
    Given user is on the login page
    And user enters valid username "Employee1" and password "Employee123"
    And user navigates to "Files" page
    Given user is on the "Files" page
    When user clicks on plus sign button
    Then user should see three options
  | Upload file       |
  | New folder        |
  | New text document |

  Scenario: users can upload file
    When user clicks on "Upload file"
    And user selects a file from directory

  Scenario:user can create new folder
    When user clicks on "New folder"
    Then user should give new folder name and click on arrow sign
    And user should able to created a "file"

  Scenario: user should not create new folder same name
    When user clicks on "New folder"
    Then user should give folder name
    Then user should not create new folder same name with existing one and should get error message name "already exist"

  Scenario: user can create new text document
    When user clicks on "New text document"
    Then user should give new text document name and click on arrow sign


  Scenario: user should not create new text document same name
    When user clicks on "New text document"
    Then user should give new text document name
    Then user should not create new text document same name with existing one and should get error message name "already exist"



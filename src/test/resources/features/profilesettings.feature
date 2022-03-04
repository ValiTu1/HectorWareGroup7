
Feature: Profile Settings Functionality

  Background:
    Given user is on the login page
    And user enters valid username "Employee1" and password "Employee123"
    And user navigates to "Menu"
    And user select "Settings" option
    Then the "Settings" page should be displayed

  @wip_esra
  Scenario: Verify chosen picture is displayed
    When user click on select avatar button
    Then user choose the picture
    And user click on Choose as a profile picture
    And user crop the picture and click the button

@smoke
Feature: contacts functionality

  Background:
    Given user is on the login page
    And user enters valid username "Employee1" and password "Employee123"
    And user navigates to "Contacts" page
    And user is on the "Contacts" page


  Scenario: users can create new groups
    When user clicks on new group button
    And user enters group name "cydeo3"
    And user clicks to create the new group
    Then "cydeo3" group should be displayed

    Scenario: users cannot create new groups having existing names
      When user clicks on new group button
      And user enters group name "cydeo"
      And user clicks to create the new group
      Then "This group already exists" should be displayed

    Scenario: Users can create new contacts and add them to groups
      When user clicks on create new contact button
      And user enters contact details "Cydeo5"
      And user assigns the contact to a group "Univerty"
      Then new contact "Cydeo5" will be displayed as part of the selected group "Univerty"

    Scenario: Users can User can edit any selected contact
      When user select a contact "Cydeo5"
      And user is editing a property "Post office" "012345"
      Then new property "Post office" value "012345" should be displayed

      @wip
      Scenario: Users can delete any contact
        When user select a contact "Cydeo5"
        And user clicks on the contact dropdown menu
        And user clicks on Delete button
        Then Contact "Cydeo5" is deleted


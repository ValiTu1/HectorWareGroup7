Feature:

  Background:
    Given user is on the login page
    And user enters valid username "Employee1" and password "Employee123"
    When the user clicks the profile icon

  @wip
  Scenario:view Online Status
    And the user sees profile drop down icons
    When the user clicks the status bar
    And the user should see "status options"
      |Online|
      |Away  |
      |Do not disturb|
      |Invisible      |
    Then the user should be able view Online Status

  @wip
  Scenario:change Online Status
    And the user sees four different status options
    When the user clicks the “Away” status option
    Then the user should be able change Online Status

  @wip
  Scenario:set Status massage
    And the user is on the status setting page
    And the user sees five different status message options
    When the user clicks the “in a meeting” status message options
    Then the user should be able to set Status massage


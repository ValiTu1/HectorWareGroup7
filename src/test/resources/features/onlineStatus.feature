Feature:

  Background:
    Given user is on the login page
    And user enters valid username "Employee1" and password "Employee123"
    When the user clicks the profile icon

  Scenario:view Online Status
    And the user sees profile drop down icons
    When the user clicks the status bar
    Then the user should see the following options
      | Online         |
      | Away           |
      | Do not disturb |
      | Invisible      |

  Scenario:change Online Status
    And the user sees profile drop down icons
    When the user clicks the status bar
    And the user clicks the "Away" status option
    Then the status should be changed to "Away"

  @wip
  Scenario:set Status massage
    And the user clicks the status bar
    And the user sees the following status message options
      | In a meeting     |
      | Commuting        |
      | Working remotely |
      | Out sick         |
      | Vacationing     |
    When the user clicks the "meeting" status message options
    Then the user should be able to set Status massage


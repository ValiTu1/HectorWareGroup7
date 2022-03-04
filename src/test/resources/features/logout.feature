Feature:Log-out
	  @HECW-205
  Scenario: user can log-out
		Given Navigate to webpage
		Then Verify login page is displayed
		When user enters valid username "Employee1" and password "Employee123"
		Then Verify profile window is displayed
		And Click on settings button
		Then Verify options are displayed
		And Click on Log out button
		Then Verify that user logged out and lands on login page
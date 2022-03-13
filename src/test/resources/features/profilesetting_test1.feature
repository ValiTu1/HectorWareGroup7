Feature: Default

	#User should able to change their profile picture from uploaded files
	@HECW-245
	Scenario: Authorized user can upload the profile picture from the file-test1
		Given user is on the login page
		And user enters valid username "Employee1" and password "Employee123"
		And user navigates to "Menu"
		And user select "Settings" option
		Then the "Settings" page should be displayed
		When user click on select avatar button
		Then user choose the picture
		And user click on Choose as a profile picture
		And user crop the picture and click the button
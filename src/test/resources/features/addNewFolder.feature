Feature: Default

	Background:
		#@HECW-241
		Scenario: Login with valid credentials
			Given user is on the login page
			When user enters valid username "Employee1" and password "Employee123"
		

	#After clicking on the add button (plus sign) at the left top of the page, three options - upload file, new folder, new text document- will appear.
	#
	#By clicking new folder, a new folder will be created.
	#
	# 
	@HECW-247
	Scenario: Add New Folder
		Scenario: registered users can login
		    ##Given user is on the login page
		    ##When user enters valid username "Employee1" and password "Employee123"
		    Then user clicks addButton
		    And user chooses "New folder" option
		    Then user creates New folder in the page
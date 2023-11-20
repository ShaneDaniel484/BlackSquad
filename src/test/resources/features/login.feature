Feature: User use to login the Thomascook Login page

	@ValidScenario
  Scenario: user navigates to the ThomasCook Loginpage
    Given user is in the Thomascook page from Login
    When user clicks the login button on top right corner of homepage.
    When Again user clicks login button shows in drop down.
    And user enters the valid email id in popup which shown
    And user enters the valid password.
    Then Finally user clicks the loginbutton and user in homepage of Registered user

	@InvalidScenario
  Scenario Outline:
		Given user is in the Thomascook page
    When user clicks the login button on top right corner of homepage.
    When Again user clicks login button shows in drop down.
    And user enters the <Email>
     |		Email|
    |fake123@hotmail.com|
    #|karthick@gmail.com|
    #|									 |
    And user enters the <Password>
    |Password|
    |qwerty!23.|
    #|killbill|
    #|				 |
    Then Finally user clicks the loginbutton and user in homepage of Registered user
    
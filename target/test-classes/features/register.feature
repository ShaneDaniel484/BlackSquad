Feature: Register an user in thomascook application

  @register
  Scenario: Register user and get successful messege
    Given user is on thomascook homepage
    When user clicks on loginbutton
    And clicks on register
    And user fills in their details
      | firstname | lastname | email                 | mobile     | password    | cpassword   |
      | tzet      | userone  | jopsezamli2@gufum.com | 9878675645 | Welcome@123 | Welcome@123 |
    And user clicks register button
    Then user is navigated to homepage with user logged in

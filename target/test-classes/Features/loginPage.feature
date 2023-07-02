Feature: Feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given browser is opened
    And user is on login page
    When user enters <username> and <password>
    And click on login button
    Then user is navigated to the home page
    And click on logout button

    Examples: 
      | username  | password |
      | Buggy1234 | Abcd@123 |
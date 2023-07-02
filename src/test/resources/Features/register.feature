Feature: Feature to test Page Registration functionality

  Scenario: Check registration is successful with valid credentials
    Given browser is invoked
    And user is on register page
    When user enters <username>, <firstname>, <lastname> <password> and <password>
    And click on register button
    Then user is registered
    
    Examples:
    | username | firstname | lastname | password | confirm password |
    | JohnDoe  | John      | Doe      | Abcd@123 | Abcd@123         |

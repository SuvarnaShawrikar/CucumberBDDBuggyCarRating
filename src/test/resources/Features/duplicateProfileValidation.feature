Feature: Feature to test duplicate profile registration

Scenario: Check duplicate profile validation for registration
    Given invoke browser
    And user is on registration page
    When user enters <username>, <firstname>, <lastname> <password> and <password>
    And click on the register button
    Then user is already registered
    
    Examples:
    | username | firstname | lastname | password | confirm password |
    | Buggy123 | John      | Doe      | Abcd@123 | Abcd@123         |

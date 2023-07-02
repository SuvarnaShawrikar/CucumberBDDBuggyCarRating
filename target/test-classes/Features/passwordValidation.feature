Feature: Feature to test Password Validation functionality

  Scenario Outline: Password validation during registration (missing Upper character)
    Given browser is open
    And user is on the registration page
    When user enters <username> and <password>
    And user click on the register button
    Then user see an error message indicating the password requirements

    Examples: 
      | username | password     |
      | JohnDoe1 | password@123 |
      
   Scenario Outline: Password validation during registration (missing special character)
    Given browser is open
    And user is on the registration page
    When user enters <username> and <password>
    And user click on the register button
    Then user see an error message indicating the password requirements
   
   Examples:
      | username | password     |
      | JohnDoe2 | Password123  |
      
   Scenario Outline: Password validation during registration (missing lowercase)
    Given browser is open
    And user is on the registration page
    When user enters <username> and <password>
    And user click on the register button
    Then user see an error message indicating the password requirements
    
    Examples:
    	| username | password     |
      | JohnDoe3 | PASSWORD@123 |
      
    Scenario Outline: Password validation during registration (less than 8 characters)
    Given browser is open
    And user is on the registration page
    When user enters <username> and <password>
    And user click on the register button
    Then user see an error message indicating the password requirements
    
    Examples:
      | username | password     |
      | JohnDoe4 | Pass@12      |

Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct credentials
    Given I navigate to the login page of the application
    And I enter the following credentials
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page

  Scenario: Login with correct credentials to fail
    Given I navigate to the login page of the application
    And I enter the following credentials
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page wrongly


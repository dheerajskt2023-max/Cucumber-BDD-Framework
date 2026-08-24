Feature: Login to saucedemo

  @positive
  Scenario: Login with valid credentials
    Given Browser is opened
    When User enters valid creds
    And User clicks on login_button
    Then User should be logged in successfully
    And Browser should be closed

  @negative
  Scenario: Login with invalid credentials
    Given Browser is opened
    When User enters invalid creds
    And User clicks on login_button
    Then User should not be logged in successfully
    And Browser should be closed
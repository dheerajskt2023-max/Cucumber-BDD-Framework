Feature: Login to saucedemo

  @positive
  Scenario: Login with valid credentials
    When User enters valid creds
    And User clicks on login_button
    Then User should be logged in successfully

  @positive
  Scenario: Login with invalid credentials
    When User enters invalid creds
    And User clicks on login_button
    Then User should not be logged in successfully

  @purchase
  Scenario: Complete product purchase successfully
    When User logs in with valid credentials
    And User selects a product
    And User adds the product to the cart
    And User opens the shopping cart
    And User clicks on checkout_button
    And User enters valid checkout information
    And User clicks on continue_button
    And User clicks on finish_button
    Then User should see the order confirmation message

  @dataproviderlogin
  Scenario Outline: Login with multiple valid credentials
    When User enters username "<username>" and password "<password>"
    And User clicks on login_button
    Then User should be logged in successfully
    
    Examples:
      | username                | pa  ssword   |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

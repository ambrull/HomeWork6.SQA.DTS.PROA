Feature: Failed Login saucedemo

  Scenario: Failed login
    Given User in login page saucedemo
    When Input invalid username
    And Input invalid password
    And Click login button
    Then User get error message
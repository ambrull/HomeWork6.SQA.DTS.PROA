Feature: Login page saucedemo

  Scenario: Succes login
    Given Login page saucedemo
    When Input username
    And Input password
    And Click login button
    Then User in dashboard page
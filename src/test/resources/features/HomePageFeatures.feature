Feature: this feature is to check features on Home page
  Check presence of critical features

  Background:
    Given user is on home page

  Scenario: Verify the page title
    Then validate title contains "Tokio Marine America – US Based Commercial Property and Casualty Insurance Provider"

  Scenario: User turns on color blind mode on
    When user turns on color blind mode
    Then page becomes black and white


  Scenario: Validates login page switch
    When user clicks on login button
    Then validate page title contains "Log In Tokio Marine America"

  Scenario: Verifies departments number to log in
    When user clicks on login button
    Then user can find 8 departments to login

  Scenario: Validates login links are not broken
    When user clicks on login button
    Then all login links are functioning


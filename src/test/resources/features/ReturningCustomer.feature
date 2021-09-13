Feature: validate returning customer cam pay bills

  Scenario: User attemps to login with invalid credentials
    Given user is on billpay log in page
    When user attempts to login with username "bulatkan" password "harDpa$$"
    Then user can see following error message "Invalid Credentials"

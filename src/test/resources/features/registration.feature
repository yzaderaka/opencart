Feature: new customer registration

  @smoke
  Scenario: new user registration
    When User click on MyAccount then Register button
    Then User enter his registration data
    And Click checkbox to agree with Privacy Policy
    Then Click registration button
    Then Account has been created confirmation



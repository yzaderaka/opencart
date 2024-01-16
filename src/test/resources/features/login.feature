Feature: Login Functionalities


  @smoke @regression @login
  Scenario: Valid customer login
    Given User click on MyAccount then Login Button
    When User enter valid login and password
    And Click on login button
    Then User enter into account

  @regression
    Scenario: Successful logout
      Given User click on MyAccount then Login Button
      When User enter valid login and password
      And Click on login button
      Then User enter into account
      Then User click on logout button
      Then User see logout confirmation message


  @regression @login
  Scenario Outline: Login with invalid credentials
    Given User click on MyAccount then Login Button
    When User enter "<username>" and "<password>"
    And Click on login button
    Then User see error message
    Examples:
      | username             | password |
      |                      | AA9882ip |
      | mail@gmail.com       | AA9882ip |
      | yzaderaka@icloud.com | 12345678 |
      | yzaderaka@icloud.com |          |




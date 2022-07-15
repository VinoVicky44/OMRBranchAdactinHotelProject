@Login
Feature: Verifying Adactin hotel Login functionality

  Background: 
    Given User is on the adactin login page

  @Valid
  Scenario Outline: Verifying Adactin hotel Login with valid credentials
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"

    Examples: 
      | userName       | password  |
      | vinothkumar008 | Vino@0440 |

  @EnterKey
  Scenario Outline: Verifying Adactin hotel Login with valid credentials by Enter Key functionality
    When User should perform login "<userName>" , "<password>" and press Enter key
    Then User should verify the login sucessfuly "Hello vinothkumar008!"

    Examples: 
      | userName       | password  |
      | vinothkumar008 | Vino@0440 |

  @Invalid
  Scenario Outline: Verifying Adactin hotel Login with Invalid credentials
    When User should perform login "<userName>" , "<password>"
    Then User should verify the error message after login contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName | password   |
      | Vino     | Vino@12345 |

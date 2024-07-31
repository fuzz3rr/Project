Feature: Managing user addresses
  As a user
  I want to add address
  So that I can book hotel

  @done
  Scenario Outline: Add new user address
    Given the user is on the authentication page
    When the user types "<email>" and "<password>" and clicks sign in button
    And the user clicks addresses button
    And the user clicks Create new address
    And the user fills the form with "<alias>", "<address>", "<city>", "<postalCode>", "<country>", "<phone>"
    Then the user saves
    And the page should display message "Address successfully added!"
    Examples:
      | email                        | password |alias | address | city | postalCode | country | phone |
      | ummdxgrujcboqmncgm@hthlm.com | 123321 |alias1 | address1 | city1 | postalCode1 | United Kingdom| 123123123   |



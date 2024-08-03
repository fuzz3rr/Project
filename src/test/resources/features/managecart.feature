Feature: Managing user cart
  As a user
  I want to add items to cart
  So that I can buy them

  Scenario Outline: Add new user address
    Given the user is on the authentication page
    When the user types "<email>" and "<password>" and clicks sign in button
    And the user returns to main page and clicks product and checks if it has discount of "<discount>"
    And the user chooses the size "<size>" of product
    And the uses chooses the amount "<amount>" of product
    And the user adds the products to a cart
    And the user proceeds to checkout
    And the user confirms the "<address>" and clicks continue
    And the user chooses pickup method
    And the user chooses Pay by check
    Then the user confirms the order
    And the page should display message "Your order is confirmed"
    And the script will take the screenshot of the order
    Examples:
      | email                        | password | discount | size | amount | address |
      | ummdxgrujcboqmncgm@hthlm.com | 123321 | SAVE 20% |  |  |  |


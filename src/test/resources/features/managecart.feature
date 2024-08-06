Feature: Managing user cart
  As a user
  I want to add items to cart
  So that I can buy them

  @done
  Scenario Outline: Making an order in shop
    Given the user is on the auth page
    When the user types "<email>" and "<password>" and clicks sign in
    And the user returns to main page
    And and clicks product and checks if it has discount of "<discount>" the user chooses the size "<size>" of product
    And the uses chooses the amount "<amount>" of product
    And the user adds the products to a cart
    And the user proceeds to checkout
    And the user confirms the "<address>" and clicks continue
    And the user chooses pickup method
    And the user chooses Pay by check
    Then the user confirms the order
    And the page should show message "YOUR ORDER IS CONFIRMED"
    And the script will take the screenshot of the order
    Examples:
      | email                        | password | discount | size | amount | address |
      | ummdxgrujcboqmncgm@hthlm.com | 123321   | SAVE 20% | M    | 5      | alias1  |


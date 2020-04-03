Feature: cart related opeartions

  Scenario Outline: cart product to cart
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When choose the product , quantity and made a post request for user <userID>
      | userId    |  1 |
      | productId |  4 |
      | quantity  | 1 |
    And responce code should be 201
    Then product should be added to cart

    Examples: 
      | userID |
      |      1 |

  Scenario Outline: updation of cart quantity
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made a post request for user <userID> and update quantity <quantity> for the cart <cartItemId>
    And responce code should be 200
    Then cart product quantity should be updated

    Examples: 
      | userID | cartItemId | quantity |
      |      1 |        733|        2 |

  Scenario Outline: updation of cart Invalid quantity
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made  post request for user <userID> and update quantity <quantity> for the cart <cartItemId>
    And responce code should be 200
    Then  should show warning message

    Examples: 
      | userID | cartItemId | quantity |
      |      1 |        733 |       -2 |

  Scenario Outline: Removal of product from cart
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made a delete request for users <userID>  cart <cartItemId>
    And responce code should be 200
    Then product should be removed from cart

    Examples: 
      | userID | cartItemId |
      |      1 |        733 |

  Scenario Outline: fetching the cart products
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made a get request for the cart products for user <userID>
    And responce code should be 200
    Then all products should be fetched

    Examples: 
      | userID |
      |      1 |

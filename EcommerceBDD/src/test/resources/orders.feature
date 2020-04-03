Feature: operation on  orders

@skip
  Scenario Outline: displaying order details
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made request for the user orders  <userID>
    And responce code should be 200
    Then it should display the order List
      | [Wrangler Jeans, Godrej Refridgirator, Samsung Galaxy s10, Voltas Ac, Lg QLED Tv, Oneplus 7T] |

    Examples: 
      | userID |
      |      1 |

@skip
  Scenario Outline: adding order to the user
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made post request  for the products  <userID>
      | cartItemId | 718 |
    And responce code should be 201
    Then order should be added to the user

    Examples: 
      | userID |
      |      1 |

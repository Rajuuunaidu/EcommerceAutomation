Feature: CheckOut feature

  Scenario Outline: To Order all the items in cart
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made a delete request for users <userID>  cart
    And responce code should be 201
    Then all the products should be placed

    Examples: 
      | userID |
      |      1 |

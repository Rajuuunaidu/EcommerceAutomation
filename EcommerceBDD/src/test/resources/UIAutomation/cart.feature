Feature: cart related operations

  Scenario: adding product to cart
    Given open the url
    When click on the desired category
    And select the product and quantity
    Then that product should be added to cart

  Scenario: adding invalid quantity
    Given open the url
    When click on the desired category
    And select the product and give invalid quantity
    Then it should show erro message

  Scenario: updating cart's product quantity
    Given open the url
    When click on cart
    And update the product's quantity
    Then quantity should be updated

 

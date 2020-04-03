Feature: displaying products

  Scenario Outline: displaying products under the sub-category
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made request products for the categories  <categoryID>
    And responce code should be 200
    Then it should display the products List
      | products                                                                                                                                                                                              |
			|[iPhone X, Oneplus 7T, Samsung Galaxy s10]|
			|[Godrej Refridgirator, Voltas Ac, Lg QLED Tv]|
			|[Wrangler Jeans, Raymond Shirt]|
			|[puma shoes]|
    Examples: 
      | categoryID |
      |          3 |
      |          4 |
      |          5 |
      |         10 |

      
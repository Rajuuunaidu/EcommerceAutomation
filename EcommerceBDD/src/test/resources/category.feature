Feature: displaying sub-categories

  Scenario Outline: display sub-category
    Given api are up and running for "http://10.71.9.158:8080/rest/"
    When made request for the categories  <categoryID>
    And responce code should be 200
    Then it should display the sub-categories List
      | subcategory                 |
      | [Mobiles, Home Applicances] |
      | [Men, Women, Kids]          |
      | [Pizza]                     |

    Examples: 
      | categoryID |
      |          1 |
      |          2 |
      |          8 |

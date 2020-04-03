Feature: category related operations

  Scenario Outline: checking category is available
    Given open the url
    When check is category <categoryName> is displayed
    Then it should be  displayed

    Examples: 
      | categoryName |
      | Electronics  |
      | fashion      |
      | mens_shoes   |

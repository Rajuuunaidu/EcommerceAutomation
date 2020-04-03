Feature: subCategory related operations

  Scenario Outline: checking subCategory is available
    Given open the url
    When check is category <categoryName> then <subCategoryName> is displayed
    Then subcategory should be displayed

    Examples: 
      | categoryName | subCategoryName        |
      | Electronics  | Mobiles,HomeAppliances |
      | fashion      | Men,Women,Kids         |

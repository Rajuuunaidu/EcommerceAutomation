Feature: Check out Opeartions

  Scenario: checkout of all products
    Given open the url
    When Navigate to cartPage and click on check out button
    Then all products need to be checked out

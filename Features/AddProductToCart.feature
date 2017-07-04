Feature: Add Product to the cart

  Scenario: Adding product to the cart in Ebay.com
    Given Chrome browser is open
    And Ebay Homepage is launched
    When we search for parker pen
    And add it to cart
    Then parker pen should be added and displayed in the cart

  Scenario Outline: Adding product to the cart in Ebay.com
    Given Chrome browser is open
    And Ebay Homepage is launched
    When we search for "<product>"
    And add it to cart
    Then "<product>" should be added and displayed in the cart

    Examples: 
      | product           |
      | wall poster		  |
      | ck perfume        |
Feature: Add Product to the cart

  Scenario: Adding product to the cart in Ebay.com
    Given Chrome browser is open
    And Ebay Homepage is launched
    When we search for fossil Mens Watch
    And add it to cart
    Then fossil Mens Watch should be added and displayed in the cart

  
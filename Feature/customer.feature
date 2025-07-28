Feature: Customers

  Scenario: Add a new Customer
    Given User Launch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And  User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers menu
    And  click on customers menu Item
    And  click on Add new button
    Then user can view Add new customer page
    When user enter customer info
    And  click on save button
   Then user can view confirmation message "The new customer has been added successfully."
    And close browser

    Scenario: search employee




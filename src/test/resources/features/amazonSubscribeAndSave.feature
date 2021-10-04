@wip

Feature: Subscribe and Save functionality

  Scenario: Sign in to the application
    Given User is on the "Dashboard" page
    When User hover over "Hello, Sign in" button
    And User clicks on "Sign in" button
    And User enters "amazon@hotmail.com" in the email input box
    And User clicks on "Continue" button
    And User enters "amazon" in the password input box
    And User clicks on "Sign-In" button


  Scenario: Subscribe and Save functionality verification

    Given User is on the "Dashboard" page
    When User signs in with correct credentials "amazon@hotmail.com" "amazon"
    And User searches for "Advil Pain Reliever and Fever Reducer, Ibuprofen 200mg for Pain Relief - 300 Count, Advil PM Pain Reliever and Nighttime Sleep Aid, Ibuprofen for Pain Relief and Diphenhydramine Citrate - 2 Count"
    And User clicks on the "Advil Pain Reliever and Fever Reducer, Ibuprofen 200mg for Pain Relief - 300 Count, Advil PM Pain Reliever and Nighttime Sleep Aid, Ibuprofen for Pain Relief and Diphenhydramine Citrate - 2 Count" product
    And User clicks on "Subscribe & Save" button
    And User adjusts quantity as "2"
    And User adjusts delivery frequency as "5 months"
    And User clicks on "Set Up Now" button
    And User successfully set up delivery for every "5 months"
    And User clicks on "Proceed to checkout" button
    And User clicks on "2" delivery option
    And User clicks on "Place your order" button






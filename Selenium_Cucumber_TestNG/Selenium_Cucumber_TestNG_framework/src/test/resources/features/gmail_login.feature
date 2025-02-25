Feature: Gmail Login

  Scenario: Login to Gmail with valid credentials
    Given I navigate to "https://mail.google.com"
    When I enter username from JSON data
    And I enter password from JSON data
    Then I should see the inbox page

Feature:
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account

  Scenario:
    Given I have an empty bank account
    When I withdraw 40 units of money
    Then I should see a final balance of -40 unit of money

  Scenario:
    Given I have an empty bank account
    When I withdraw 40 units of money
    When I withdraw 80 units of money
    Then I should see a final balance of -120 unit of money

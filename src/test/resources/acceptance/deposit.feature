Feature:
  In order to save money
  As a bank client
  I want to make a deposit in my account

  Scenario:
    Given I have an empty bank account
    When I depose 40 units of money
    Then I should see a final balance of 40 unit of money

  Scenario:
    Given I have an empty bank account
    When I depose 40 units of money
    And I depose 1234560 units of money
    Then I should see a final balance of 1234600 unit of money

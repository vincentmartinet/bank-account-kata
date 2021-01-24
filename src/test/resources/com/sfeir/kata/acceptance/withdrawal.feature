Feature: Withdrawal
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account

  Scenario Outline: A withdrawal subtracts money from my bank account
    Given my bank account has a balance of "<start_balance>"
    When I withdraw "<amount>"
    Then I should have a new balance of "<end_balance>"

    Examples:
      | start_balance | amount | end_balance |
      | 0             | 10     | -10         |
      | 2289.4        | 10     | 2279.4      |
      | 104.1         | 24.1   | 80          |
      | 0.2           | 0.1    | 0.1         |

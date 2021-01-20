Feature: Deposit
  In order to save money
  As a bank client
  I want to make a deposit in my account

  Scenario Outline: A deposit adds money to my bank account
    Given my bank account has a balance of "<start_balance>"
    When I depose "<amount>"
    Then I should have a new balance of "<end_balance>"

    Examples:
      | start_balance | amount | end_balance |
      | 0             | 10     | 10          |
      | 2289.4        | 10     | 2299.4      |
      | 0             | 104.1  | 104.1       |
      | 0.1           | 0.2    | 0.3         |

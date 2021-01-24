Feature: Print account statement
  In order to check my operations
  As a bank client
  I want to see the history (operation, date, amount, balance)  of my operations

  Scenario: I make a deposit to my account and then print statement
    Given my bank account has an empty balance
    And I have a deposit of 80 made the 2021-01-20 at 19:30
    When I ask for the statement
    Then I should see
      | date                 | operation | amount | balance |
      | 2021-01-20 19:30:00 | deposit   | 80     | 80      |

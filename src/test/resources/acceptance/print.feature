Feature:
  In order to check my operations
  As a bank client
  I want to see the history (operation, date, amount, balance) of my operations

  Scenario:
    Given I have a bank account with the following operations made
      | TYPE       | DATE       | AMOUNT |
      | DEPOSIT    | 2019-12-24 | 1500   |
      | WITHDRAWAL | 2020-01-09 | 40     |
      | WITHDRAWAL | 2021-01-14 | 1000   |
    When I ask to see the history of my operations
    Then I have the following statement printed
      | OPERATION  | DATE       | AMOUNT | BALANCE |
      | DEPOSIT    | 2019-12-24 | 1500   | 1500    |
      | WITHDRAWAL | 2020-01-09 | 40     | 1460    |
      | WITHDRAWAL | 2021-01-14 | 1000   | 460    |

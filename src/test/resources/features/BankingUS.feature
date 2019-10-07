Feature: Bank ops
  Scenario: Deposit action
Given a bank client with id 1 has 1000
When make an operation "DEPOSIT" of 500
Then Account has 1500

  Scenario: Withdrawal action
Given a bank client with id 1 has 1800
When make an operation "WITHDRAWAL" of 600
Then Account has 1200

  Scenario: Display history of operations
Given a bank client with id 1
Then the display has 4 operations
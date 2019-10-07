$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/BankingUS.feature");
formatter.feature({
  "name": "Bank ops",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Deposit action",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a bank client with id 1 has 1000",
  "keyword": "Given "
});
formatter.match({
  "location": "SpringDefinitions.account_with_id_has(long,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "make an operation \"DEPOSIT\" of 500",
  "keyword": "When "
});
formatter.match({
  "location": "SpringDefinitions.make_an_operation_of(String,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account has 1500",
  "keyword": "Then "
});
formatter.match({
  "location": "SpringDefinitions.account_has(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Withdrawal action",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a bank client with id 1 has 1800",
  "keyword": "Given "
});
formatter.match({
  "location": "SpringDefinitions.account_with_id_has(long,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "make an operation \"WITHDRAWAL\" of 600",
  "keyword": "When "
});
formatter.match({
  "location": "SpringDefinitions.make_an_operation_of(String,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account has 1200",
  "keyword": "Then "
});
formatter.match({
  "location": "SpringDefinitions.account_has(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Display history of operations",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a bank client with id 1",
  "keyword": "Given "
});
formatter.match({
  "location": "SpringDefinitions.a_bank_client_with_id(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the display has 4 operations",
  "keyword": "Then "
});
formatter.match({
  "location": "SpringDefinitions.the_display_has_operations(Integer)"
});
formatter.result({
  "status": "passed"
});
});
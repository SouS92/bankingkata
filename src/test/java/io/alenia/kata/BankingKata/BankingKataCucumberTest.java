package io.alenia.kata.BankingKata;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty", "json:target/cucumber-report.json","html:target/cucumber"})
public class BankingKataCucumberTest {
}

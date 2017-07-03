package com.epam.customrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features"
		,glue={"src/test/java/com/epam/stepDefinitions/AddToCart.java"}
		,plugin = {"html:target/cucumber-html-report"})
public class TestRunner {

}

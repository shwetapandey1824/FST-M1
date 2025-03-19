package testRunner;

import org.junit.platform.suite.api.ConfigurationParameter;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@SmokeTest",
	    plugin = {"html: test-reports"},
	    monochrome = true
	)
public class Activity6Runner1 {
	
}
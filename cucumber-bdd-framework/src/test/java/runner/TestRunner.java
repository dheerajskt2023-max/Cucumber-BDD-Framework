package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features = "src/test/resources/features",
					glue = {"step_definition","hooks"},
					tags = "@positive",
					plugin = {"pretty",
					  "html:target/cucumber-test.html",
				  	  "json:target/cucumber-test.json"}
				)
public class TestRunner extends AbstractTestNGCucumberTests {}
// Runs each cucumber scenario found in the features as separated test.
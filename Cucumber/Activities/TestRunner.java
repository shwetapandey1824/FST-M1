package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(
//	    features = "src/test/resources/features",
//	    glue = {"stepDefinitions"},
//	    tags = "@SimpleAlert",
//	    plugin = {"pretty"},
//	    monochrome = true
//		)


@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepDefinitions"},
	    tags = "@SimpleAlert",
	    plugin = {"html: test-reports1"},
	    monochrome = true
	)

//@CucumberOptions(
//	    features = "src/test/resources/features",
//	    glue = {"stepDefinitions"},
//	    tags = "@SimpleAlert",
//	    plugin = {"json: test-reports/json-report.json"},
//	    monochrome = true
//	)
public class TestRunner {
	
}

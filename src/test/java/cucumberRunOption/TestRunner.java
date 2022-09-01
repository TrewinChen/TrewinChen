package cucumberRunOption;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue="stepDefinitions",
//		tags="@Regression",
		dryRun=false,
		monochrome=true,
//		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-reports/Cucumber.json",
//				"junit:target/Cucumber.xml",
//				"html:target/Cucumber.html"}
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-reports/Cucumber.json",
				"junit:target/Cucumber.xml",
				"html:target/Cucumber.html"}
		)

public class TestRunner {

}

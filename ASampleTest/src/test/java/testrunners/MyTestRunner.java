package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {"src/test/resources/AppFeatures"},
		features = {"src\\test\\resources\\parallel\\LoginPage.feature"},
		glue = {"parallel"},
		plugin = {"pretty","html:target/cucumberreports"},
		monochrome=true

				
		
		
		)

public class MyTestRunner {

}

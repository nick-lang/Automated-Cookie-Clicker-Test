import cucumber.api.junit.Cucumber
import cucumber.api.CucumberOptions
import org.junit.runner.RunWith

//This file is necessary to run the test, but even with glue pointing to steps
//and hooks, the glue doesn't seem to do anything
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin=["pretty", "html:build/reports/cucumber"]
)
class RunCukesTest {

}
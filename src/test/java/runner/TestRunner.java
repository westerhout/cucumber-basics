package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by denni_6jm52yj on 18-Mar-17.
 */

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"} , glue = "steps")
public class TestRunner extends AbstractTestNGCucumberTests {
}

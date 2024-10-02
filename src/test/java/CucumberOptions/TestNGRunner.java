package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features",glue="stepDefinitions", monochrome=true,tags="@smoketest",plugin= {"pretty","html:src/target/Cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

}

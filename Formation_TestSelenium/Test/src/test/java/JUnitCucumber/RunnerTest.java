package JUnitCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/junitcucumber/", glue = {"JUnitCucumber"})
public class RunnerTest {
}

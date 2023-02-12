package runnerPackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/feature_files",
plugin = {"pretty", "html:target/cucumber.html",
        "json:target/cucumber-report.json",
        "junit:target/cucumber.xml"}, glue = {"stepDefs"},
tags = "@JPlaceHolder2")
public class TestRunner {
}

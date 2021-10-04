package com.interview.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
          "html:target/cucumber-report.html",
          "json:target/cucumber.json",
          "rerun:target/rerun.txt"
        },
        glue = "com/interview/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@wip"
)

public class CukesRunner {
}

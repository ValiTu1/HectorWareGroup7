package com.hectorware.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-html-reports"
        } ,
        features = "src/test/resources/features",
        glue = "com/hectorware/step_definitions",
        dryRun = false,
        tags = "@wip_esra"
)

public class TestsRunner {
}

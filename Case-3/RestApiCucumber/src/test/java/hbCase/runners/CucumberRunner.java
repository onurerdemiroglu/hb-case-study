package hbCase.runners;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty"
        },
        glue= {"hbCase.steps"},
        features = "src/test/java/hbCase/features",
        dryRun = false
)
public class CucumberRunner extends AbstractTestNGCucumberTests{

}

package com.interview.step_definitions;

import com.interview.utilities.BrowserUtils;
import com.interview.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDownScenario(Scenario scenario) {

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot ,"image/png", scenario.getName());

        }

        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

}

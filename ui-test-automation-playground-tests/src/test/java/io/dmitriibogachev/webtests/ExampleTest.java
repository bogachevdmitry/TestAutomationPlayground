package io.dmitriibogachev.webtests;

import com.google.inject.Inject;
import io.dmitriibogachev.webtests.annotations.GuiceModules;
import io.dmitriibogachev.webtests.extensions.annotations.StandardSeleniumExtensions;
import io.dmitriibogachev.webtests.modules.WebModule;
import io.dmitriibogachev.webtests.steps.TestingPlaygroundSteps;
import org.junit.jupiter.api.Test;

import static io.dmitriibogachev.webtests.constants.PlaygroundType.CLASS_ATTRIBUTE;

@StandardSeleniumExtensions
@GuiceModules(WebModule.class)
public class ExampleTest {

    @Inject TestingPlaygroundSteps testingPlaygroundSteps;

    @Test
    public void checkAlertWhenClickingOnPrimaryButton() {
        testingPlaygroundSteps
                .openPlayground(CLASS_ATTRIBUTE)
                .clickOnPrimaryButton()
                .checkAlertIsDisplayed()
                .checkAlertHasText("Primary button pressed");
    }
}

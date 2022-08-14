package io.dmitriibogachev.webtests;

import com.google.inject.Inject;
import io.dmitriibogachev.webtests.annotations.GuiceModules;
import io.dmitriibogachev.webtests.extensions.annotations.StandardSeleniumExtensions;
import io.dmitriibogachev.webtests.modules.WebModule;
import io.dmitriibogachev.webtests.webdriver.steps.WebDriverSteps;
import org.junit.jupiter.api.Test;

@StandardSeleniumExtensions
@GuiceModules(WebModule.class)
public class ExampleTest {

    @Inject WebDriverSteps webDriverSteps;

    @Test
    public void checkExample() {
        webDriverSteps.navigation().openUrl("https://google.com");
    }
}

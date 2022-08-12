package io.dmitriibogachev.webtests.webdriver.steps;

import com.google.inject.Inject;
import io.dmitriibogachev.webtests.webdriver.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverSteps {

    @Inject WebDriverManager webDriverManager;
    @Inject WebDriverNavigationSteps webDriverNavigationSteps;

    public WebDriverNavigationSteps navigation() {
        return webDriverNavigationSteps;
    }

    public WebDriver getDriver() {
        return webDriverManager.getWebDriver();
    }
}

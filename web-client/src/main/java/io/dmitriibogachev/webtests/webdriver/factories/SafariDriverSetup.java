package io.dmitriibogachev.webtests.webdriver.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverSetup implements DriverSetup {

    @Override
    public WebDriver getWebDriver() {
        return new SafariDriver();
    }
}

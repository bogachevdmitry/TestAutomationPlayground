package io.dmitriibogachev.webtests.webdriver.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.dmitriibogachev.webtests.webdriver.utils.DriverPathUtils.getFirefoxDriverPath;

public class FirefoxDriverSetup implements DriverSetup {

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.gecko.driver", getFirefoxDriverPath());
        return new FirefoxDriver();
    }
}

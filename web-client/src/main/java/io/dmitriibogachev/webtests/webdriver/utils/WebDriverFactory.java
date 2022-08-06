package io.dmitriibogachev.webtests.webdriver.utils;

import org.openqa.selenium.WebDriver;

public final class WebDriverFactory {

    private WebDriverFactory() {}

    private static WebDriver initWebDriver(DriverType driverType) {
        return driverType.getWebDriver(driverType.getOptions());
    }

    public static WebDriver createDriver() {
        return initWebDriver(DriverType.valueOf(EnvironmentVariables.getInstance().getBrowserType().name()));
    }
}

package io.dmitriibogachev.webtests.webdriver.utils;

import io.dmitriibogachev.webtests.webdriver.constants.DriverType;
import io.dmitriibogachev.webtests.webdriver.factories.ChromeDriverSetup;
import io.dmitriibogachev.webtests.webdriver.factories.EdgeDriverSetup;
import io.dmitriibogachev.webtests.webdriver.factories.FirefoxDriverSetup;
import io.dmitriibogachev.webtests.webdriver.factories.SafariDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;

import static io.dmitriibogachev.webtests.webdriver.constants.DriverType.CHROME;

public final class DriverInitUtils {

    private DriverInitUtils() {

    }

    public static WebDriver createDriver() {
        final String browser = System.getenv("browser");
        DriverType driverType = CHROME;

        if (browser != null) {
            driverType = DriverType.valueOf(browser.toUpperCase());
        }

        return switch (driverType) {
            case CHROME -> new ChromeDriverSetup().getWebDriver();
            case EDGE -> new EdgeDriverSetup().getWebDriver();
            case SAFARI -> new SafariDriverSetup().getWebDriver();
            case FIREFOX -> new FirefoxDriverSetup().getWebDriver();
        };
    }
}

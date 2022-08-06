package io.dmitriibogachev.webtests.webdriver;

import io.dmitriibogachev.webtests.webdriver.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverManager implements WebDriverManager {

    private WebDriver webDriver;

    @Override
    public void startWebDriver() {
        webDriver = WebDriverFactory.createDriver();
    }

    @Override
    public void stopWebDriver() {
        webDriver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}

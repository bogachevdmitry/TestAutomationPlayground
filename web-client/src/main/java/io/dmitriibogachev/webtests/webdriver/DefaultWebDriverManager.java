package io.dmitriibogachev.webtests.webdriver;

import org.openqa.selenium.WebDriver;

import static io.dmitriibogachev.webtests.webdriver.utils.DriverInitUtils.createDriver;

public class DefaultWebDriverManager implements WebDriverManager {

    private WebDriver webDriver;

    @Override
    public void startWebDriver() {
        webDriver = createDriver();
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

package io.dmitriibogachev.webtests.webdriver.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.dmitriibogachev.webtests.webdriver.utils.DriverPathUtils.getChromeDriverPath;

public class ChromeDriverSetup implements DriverSetup {

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        return new ChromeDriver();
    }
}

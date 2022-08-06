package io.dmitriibogachev.webtests.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {

    void startWebDriver();

    void stopWebDriver();

    WebDriver getWebDriver();
}

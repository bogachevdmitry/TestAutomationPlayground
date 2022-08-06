package io.dmitriibogachev.webtests.webdriver.utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface DriverSetup {

    <T extends MutableCapabilities> WebDriver getWebDriver(T options);

    <T extends MutableCapabilities> T getOptions();
}

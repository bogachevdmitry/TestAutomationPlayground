package io.dmitriibogachev.webtests.webdriver.utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public enum DriverType implements DriverSetup {

    CHROME {
        @Override
        public <T extends MutableCapabilities> WebDriver getWebDriver(T options) {
            System.setProperty("webdriver.chrome.driver", OSValidator.getChromeDriverPath());
            return new ChromeDriver((ChromeOptions) options);
        }

        @Override
        public ChromeOptions getOptions() {
            return new ChromeOptions();
        }
    },

    SAFARI {
        @Override
        public <T extends MutableCapabilities> WebDriver getWebDriver(T options) {
            return new SafariDriver((SafariOptions) options);
        }

        @Override
        public SafariOptions getOptions() {
            return new SafariOptions();
        }
    },

    FIREFOX {
        @Override
        public <T extends MutableCapabilities> WebDriver getWebDriver(T options) {
            System.setProperty("webdriver.gecko.driver", OSValidator.getFirefoxDriverPath());
            return new FirefoxDriver((FirefoxOptions) options);
        }

        @Override
        public FirefoxOptions getOptions() {
            return new FirefoxOptions();
        }
    }
}

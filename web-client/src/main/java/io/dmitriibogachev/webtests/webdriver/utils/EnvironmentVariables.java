package io.dmitriibogachev.webtests.webdriver.utils;

import static io.dmitriibogachev.webtests.webdriver.utils.BrowserType.CHROME;

public final class EnvironmentVariables {

    private static EnvironmentVariables environmentVariables;
    private final BrowserType browserType;

    private EnvironmentVariables() {
        this.browserType = parseBrowserType();
    }

    public static EnvironmentVariables getInstance() {
        if (environmentVariables == null) {
            environmentVariables = new EnvironmentVariables();
        }

        return environmentVariables;
    }

    private BrowserType parseBrowserType() {
        final String browser = System.getenv("browser");
        if (browser == null) {
            return CHROME;
        } else {
            return BrowserType.valueOf(browser.toUpperCase());
        }
    }

    public BrowserType getBrowserType() {
        return browserType;
    }
}

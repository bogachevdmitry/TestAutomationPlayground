package io.dmitriibogachev.webtests.webdriver.utils;

import io.dmitriibogachev.webtests.webdriver.WebDriverManager;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public final class WebDriverUtils {

    private WebDriverUtils() {

    }

    public static final String WEB_DRIVER_KEY = "webDriverKey";

    public static WebDriverManager getWebDriverManager(ExtensionContext context) {
        return (WebDriverManager) context.getStore(GLOBAL).get(WEB_DRIVER_KEY);
    }
}

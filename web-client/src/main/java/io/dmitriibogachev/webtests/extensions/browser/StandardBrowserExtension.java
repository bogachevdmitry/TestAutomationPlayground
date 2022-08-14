package io.dmitriibogachev.webtests.extensions.browser;

import io.dmitriibogachev.webtests.webdriver.WebDriverManager;
import org.junit.jupiter.api.extension.ExtensionContext;

public class StandardBrowserExtension extends AbstractBrowserExtension {

    @Override
    public void createBrowser(ExtensionContext context, WebDriverManager webDriverManager) {
        webDriverManager.startWebDriver();
    }
}

package io.dmitriibogachev.webtests.extensions.browser;

import com.google.inject.Injector;
import io.dmitriibogachev.webtests.webdriver.WebDriverManager;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.dmitriibogachev.webtests.extensions.utils.InjectUtils.INJECTOR_KEY;
import static io.dmitriibogachev.webtests.webdriver.utils.WebDriverUtils.WEB_DRIVER_KEY;
import static io.dmitriibogachev.webtests.webdriver.utils.WebDriverUtils.getWebDriverManager;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public abstract class AbstractBrowserExtension implements BeforeEachCallback, AfterEachCallback {

    public abstract void createBrowser(ExtensionContext context, WebDriverManager webDriverManager);

    @Override
    public void beforeEach(ExtensionContext context) {
        final Injector injector = (Injector) context.getStore(GLOBAL).get(INJECTOR_KEY);
        WebDriverManager webDriverManager = injector.getInstance(WebDriverManager.class);
        context.getStore(GLOBAL).put(WEB_DRIVER_KEY, webDriverManager);

        createBrowser(context, webDriverManager);
        if (webDriverManager.getWebDriver() == null) {
            throw new IllegalStateException("Browser wasn't created.");
        }
    }

    @Override
    public void afterEach(ExtensionContext context) {
        getWebDriverManager(context).stopWebDriver();
    }
}

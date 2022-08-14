package io.dmitriibogachev.webtests;

import com.google.inject.Inject;
import io.dmitriibogachev.webtests.webdriver.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    @Inject private WebDriverManager webDriverManager;

    public <T extends WebPage> T on(Class<T> webPage) {
        return getAtlas().create(getWebDriver(), webPage);
    }

    public WebDriver getWebDriver() {
        return webDriverManager.getWebDriver();
    }

    public Atlas getAtlas() {
        return new Atlas(new WebDriverConfiguration(getWebDriver()));
    }
}

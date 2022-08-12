package io.dmitriibogachev.webtests.webdriver.steps;

import com.google.inject.Inject;

public class WebDriverNavigationSteps {

    @Inject private WebDriverSteps webDriverSteps;

    public WebDriverSteps openUrl(String url) {
        webDriverSteps.getDriver().get(url);
        return webDriverSteps;
    }
}

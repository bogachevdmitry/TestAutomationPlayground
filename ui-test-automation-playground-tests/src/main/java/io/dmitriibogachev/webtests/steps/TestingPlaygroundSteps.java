package io.dmitriibogachev.webtests.steps;

import com.google.inject.Inject;
import io.dmitriibogachev.webtests.PageFactory;
import io.dmitriibogachev.webtests.constants.PlaygroundType;
import io.dmitriibogachev.webtests.page.TestingPlaygroundPage;
import io.dmitriibogachev.webtests.webdriver.steps.WebDriverNavigationSteps;
import io.dmitriibogachev.webtests.webdriver.steps.WebDriverWindowSteps;

public class TestingPlaygroundSteps {

    private static final String BASE_URL = "http://uitestingplayground.com/";

    @Inject private PageFactory pageFactory;
    @Inject private WebDriverNavigationSteps webDriverNavigationSteps;
    @Inject private WebDriverWindowSteps webDriverWindowSteps;

    private TestingPlaygroundPage onPlaygroundPage() {
        return pageFactory.on(TestingPlaygroundPage.class);
    }

    public TestingPlaygroundSteps openPlayground(PlaygroundType type) {
        webDriverNavigationSteps
                .openUrl(BASE_URL + type.toString());
        return this;
    }

    public TestingPlaygroundSteps clickOnPrimaryButton() {
        onPlaygroundPage().container().primaryButton().click();
        return this;
    }

    public TestingPlaygroundSteps checkAlertIsDisplayed() {
        webDriverWindowSteps
                .checkAlertIsDisplayed();
        return this;
    }

    public TestingPlaygroundSteps checkAlertHasText(String alertText) {
        webDriverWindowSteps
                .checkAlertHasText(alertText);
        return this;
    }
}

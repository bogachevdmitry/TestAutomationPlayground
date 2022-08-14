package io.dmitriibogachev.webtests.webdriver.steps;

import com.google.inject.Inject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class WebDriverWindowSteps {

    @Inject private WebDriverSteps webDriverSteps;

    public WebDriverSteps checkAlertIsDisplayed() {
        Alert alert = webDriverSteps.getDriver().switchTo().alert();
        assertThat(isAlertPresented())
                .as("Alert is displayed")
                .isTrue();
        return webDriverSteps;
    }

    public WebDriverSteps checkAlertHasText(String alertText) {
        Alert alert = webDriverSteps.getDriver().switchTo().alert();
        assertThat(alert.getText())
                .as("Alert text should be `%s`", alertText)
                .isEqualTo(alertText);
        return webDriverSteps;
    }

    private boolean isAlertPresented() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriverSteps.getDriver(), 1);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }
}

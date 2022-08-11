package io.dmitriibogachev.webtests.webdriver.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static io.dmitriibogachev.webtests.webdriver.utils.DriverPathUtils.getEdgeDriverPath;

public class EdgeDriverSetup implements DriverSetup {

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.edge.driver", getEdgeDriverPath());
        return new EdgeDriver();
    }
}

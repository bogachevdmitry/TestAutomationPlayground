package io.dmitriibogachev.webtests.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface TestingPlaygroundContainer extends AtlasWebElement<TestingPlaygroundContainer> {

    @FindBy(".//button[contains(@class, 'btn-primary')]")
    AtlasWebElement primaryButton();
}

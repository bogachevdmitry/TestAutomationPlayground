package io.dmitriibogachev.webtests.page;

import io.dmitriibogachev.webtests.elements.TestingPlaygroundContainer;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface TestingPlaygroundPage extends WebPage {

    @FindBy("//*[contains(@class, 'container')]")
    TestingPlaygroundContainer container();
}

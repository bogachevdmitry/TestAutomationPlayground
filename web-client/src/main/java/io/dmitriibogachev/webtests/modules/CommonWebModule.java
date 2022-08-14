package io.dmitriibogachev.webtests.modules;

import com.google.inject.AbstractModule;
import io.dmitriibogachev.webtests.webdriver.DefaultWebDriverManager;
import io.dmitriibogachev.webtests.webdriver.WebDriverManager;

public class CommonWebModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriverManager.class).toInstance(new DefaultWebDriverManager());
    }
}

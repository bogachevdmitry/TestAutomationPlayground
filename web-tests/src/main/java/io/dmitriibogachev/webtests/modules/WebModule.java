package io.dmitriibogachev.webtests.modules;

import com.google.inject.AbstractModule;

public class WebModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new CommonWebModule());
    }
}

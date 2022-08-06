package io.dmitriibogachev.webtests.webdriver.utils;

public enum BrowserType {

    CHROME,
    SAFARI;


    @Override
    public String toString() {
        return this.name().trim().toLowerCase();
    }
}

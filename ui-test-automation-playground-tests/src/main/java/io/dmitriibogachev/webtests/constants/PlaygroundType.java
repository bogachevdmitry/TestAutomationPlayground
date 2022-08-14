package io.dmitriibogachev.webtests.constants;

public enum PlaygroundType {

    CLASS_ATTRIBUTE("classattr");

    private final String type;

    PlaygroundType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

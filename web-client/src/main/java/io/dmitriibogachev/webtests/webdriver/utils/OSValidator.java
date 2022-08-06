package io.dmitriibogachev.webtests.webdriver.utils;

import io.dmitriibogachev.webtests.utils.ResourceUtils;

import static io.dmitriibogachev.webtests.utils.ResourceUtils.getDriverPath;

public final class OSValidator {

    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
    private static final String DRIVER_PATH_FORMAT = ResourceUtils.getDriverPath() + "/%s";

    private static final String NOT_SUPPORTED_OS = String.format("Your OS %s: is not supported", OS_NAME);

    private OSValidator() {}

    private static String getDriverPath(String driver) {
        final String windowsPath = String.format("windows/%s.exe", driver);
        final String macPath = String.format("mac/%s", driver);
        final String linuxPath = String.format("linux/%s", driver);

        if (isWindows()) {
            return String.format(DRIVER_PATH_FORMAT, windowsPath);
        } else if (isMac()) {
            return String.format(DRIVER_PATH_FORMAT, macPath);
        } else if (isUnix()) {
            return String.format(DRIVER_PATH_FORMAT, linuxPath);
        } else {
            throw new IllegalStateException(NOT_SUPPORTED_OS);
        }
    }

    public static String getChromeDriverPath() {
        return getDriverPath("chromedriver");
    }

    public static String getFirefoxDriverPath() {
        return getDriverPath("geckodriver");
    }

    public static boolean isWindows() {
        return OS_NAME.contains("win");
    }

    public static boolean isMac() {
        return OS_NAME.contains("mac");
    }

    public static boolean isUnix() {
        return OS_NAME.contains("nix") || OS_NAME.contains("nux") || OS_NAME.contains("aix");
    }

    public static String getOsName() {
        return OS_NAME;
    }
}

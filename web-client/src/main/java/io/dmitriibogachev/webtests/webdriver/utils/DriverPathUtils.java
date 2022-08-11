package io.dmitriibogachev.webtests.webdriver.utils;

import java.io.File;

public final class DriverPathUtils {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String MODULE_NAME = "web-client";
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();

    private DriverPathUtils() {

    }

    public static String getChromeDriverPath() {
        return getDriverPath("chromedriver");
    }

    public static String getFirefoxDriverPath() {
        return getDriverPath("geckodriver");
    }

    public static String getEdgeDriverPath() {
        return getDriverPath("msedgedriver");
    }

    private static String getDriverPath(String driverName) {
        String driverPath = getDriversDirectoryPath() + "/%s";

        if (isWindows()) {
            return String.format(driverPath, "windows/" + driverName + ".exe");
        } else if (isMac()) {
            return String.format(driverPath, "mac/" + driverName);
        } else if (isUnix()) {
            return String.format(driverPath, "linux/" + driverName);
        } else {
            throw new IllegalStateException(String.format("Your OS `%s` is not supported!", OS_NAME));
        }
    }

    private static Boolean isWindows() {
        return OS_NAME.contains("win");
    }

    private static Boolean isMac() {
        return OS_NAME.contains("mac");
    }

    private static Boolean isUnix() {
        return OS_NAME.contains("nix") || OS_NAME.contains("nux") || OS_NAME.contains("aix");
    }

    private static String getDriversDirectoryPath() {
        return findModule(new File(USER_DIR)).getAbsolutePath() + "/src/main/resources/drivers";
    }

    private static File findModule(File dir) {
        if (dir.getParentFile() == null) {
            throw new IllegalStateException(String.format("`%s` module was not found", MODULE_NAME));
        }

        File[] files = dir.listFiles();

        if (files == null) {
            throw new IllegalStateException(String.format("Can't get files or directory `%s`", dir.getAbsolutePath()));
        }

        for (File innerFile: files) {
            if (MODULE_NAME.equals(innerFile.getName())) {
                return innerFile;
            }
        }

        return findModule(dir.getParentFile());
    }
}

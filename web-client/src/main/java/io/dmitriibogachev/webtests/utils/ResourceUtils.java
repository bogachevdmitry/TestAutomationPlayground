package io.dmitriibogachev.webtests.utils;

import java.io.File;

public final class ResourceUtils {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String UTILS_MODULE_NAME = "web-client";

    private ResourceUtils() {
    }

    public static String getDriverPath() {
        return getWebClientModulePath() + "/src/main/resources/drivers";
    }

    public static String getWebClientModulePath() {
        return findUtilsFolder(new File(USER_DIR)).getAbsolutePath();
    }

    private static File findUtilsFolder(File dir) {
        if (dir.getParentFile() == null) {
            throw new IllegalStateException(String.format("`%s` module was not found", UTILS_MODULE_NAME));
        }

        File[] files = dir.listFiles();

        if (files == null) {
            throw new IllegalStateException(String.format("Can't get files of directory `%s`", dir.getAbsolutePath()));
        }

        for (File innerFile : files) {
            if (UTILS_MODULE_NAME.equals(innerFile.getName())) {
                return innerFile;
            }
        }

        return findUtilsFolder(dir.getParentFile());
    }
}

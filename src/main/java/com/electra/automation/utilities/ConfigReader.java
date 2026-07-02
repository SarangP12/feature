package com.electra.automation.utilities;

public final class ConfigReader {
    private static final PropertyReader CONFIG_READER = new PropertyReader("config/config.properties");

    private ConfigReader() {}

    public static String getValue(String key) {
        return CONFIG_READER.getValue(key);
    }
}

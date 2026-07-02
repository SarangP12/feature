package com.electra.automation.utilities;

import com.electra.automation.exceptions.FrameworkException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private final Properties properties;

    public PropertyReader(String filePath) {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath.replace(System.getProperty("user.dir") + "/", ""))) {
            if (inputStream == null) {
                throw new FrameworkException("Unable to locate properties file: " + filePath);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new FrameworkException("Error reading properties file: " + filePath, e);
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}

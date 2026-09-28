package com.electra.automation.utilities;

import com.electra.automation.exceptions.FrameworkException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    private final Properties properties;

    public PropertyReader(String filePath) {
        properties = new Properties();
        try (InputStream inputStream = openInputStream(filePath)) {
            if (inputStream == null) {
                throw new FrameworkException("Unable to locate properties file: " + filePath);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new FrameworkException("Error reading properties file: " + filePath, e);
        }
    }

    private InputStream openInputStream(String filePath) throws IOException {
        Path requestedPath = Paths.get(filePath);
        if (requestedPath.isAbsolute()) {
            return Files.exists(requestedPath) ? Files.newInputStream(requestedPath) : null;
        }

        String resourcePath = filePath.replace('\\', '/');
        while (resourcePath.startsWith("/")) {
            resourcePath = resourcePath.substring(1);
        }

        InputStream classpathStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (classpathStream != null) {
            return classpathStream;
        }

        Path sourceResource = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", resourcePath);
        if (Files.exists(sourceResource)) {
            return Files.newInputStream(sourceResource);
        }

        Path workingDirectoryFile = Paths.get(System.getProperty("user.dir"), resourcePath);
        return Files.exists(workingDirectoryFile) ? Files.newInputStream(workingDirectoryFile) : null;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}

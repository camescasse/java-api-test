package org.example.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesReader {
    private static final Logger LOGGER = Logger.getLogger(PropertiesReader.class.getName());
    private final Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(".properties")) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load properties file", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
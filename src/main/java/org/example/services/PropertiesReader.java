package org.example.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesReader {
    private static PropertiesReader instance;
    private final Properties properties;

    private PropertiesReader() {
        properties = new Properties();
        try (FileInputStream stream = new FileInputStream(".properties")) {
            properties.load(stream);
        } catch (IOException e) {
            System.err.println(".properties file not found");
        }
    }

    public static PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
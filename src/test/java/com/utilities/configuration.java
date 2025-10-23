package com.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configuration {
    public static String readPropertyFileData(String keyName, String fileName) {
        String returnValue = null;
        Properties properties = new Properties();

        try (FileReader fileReader = new FileReader("./configuration/" + fileName + ".properties")) {
            properties.load(fileReader);
            returnValue = properties.getProperty(keyName);
        } catch (IOException e) {
            System.err.println("Error reading property file: " + fileName + ".properties");
            e.printStackTrace();
        }

        return returnValue;
    }
}
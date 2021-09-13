package data_providers;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;
    private final String propertyFilePath = "src/test/resources/Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                e.getLocalizedMessage();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file is not found at " + propertyFilePath);
        }
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equals("safari")) return DriverType.SAFARI;
        else if (browserName.equals("firefox")) return DriverType.FIREFOX;

        else
            throw new RuntimeException("Driver is not specified in Configuration.properties at address: " + propertyFilePath);

    }

    public EnvironmentType getEnvironment() {
        String environmentType = properties.getProperty("environment");
        if (environmentType == null || environmentType.equals("local")) return EnvironmentType.LOCAL;
        else if (environmentType.equals("Remote")) return EnvironmentType.REMOTE;

        else
            throw new RuntimeException("Environment is not specified in Configuration.properties at address:" + propertyFilePath);
    }

    public boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximized");
        if (windowSize != null) return Boolean.parseBoolean(windowSize);

        return true;
    }

    public int getImplicitlyWait() {
        String waitTime = properties.getProperty("implicitlyWait");
        if (waitTime != null) return Integer.parseInt(waitTime);
        return 20;
    }

//    public String getReportConfigPath() {
//        String reportConfigPath = properties.getProperty("reportConfigPath");
//        if (reportConfigPath != null) return reportConfigPath;
//        else
//            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
//    }


}

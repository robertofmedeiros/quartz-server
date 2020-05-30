package org.roberto.medeiros.quartz.server.utils;

import java.util.Properties;

public class Config {

    private static Config instance;
    private Properties properties;

    private Config(){
        properties = new Properties();
    }

    public static Config getIntance(){
        if (null == instance) {
            instance = new Config();
        }

        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

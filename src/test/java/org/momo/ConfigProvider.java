package org.momo;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL1 = readConfig().getString("url1");
    String URL2 = readConfig().getString("url2");
    String ADMIN_NAME = readConfig().getString("userParams.admin.name");
    String ADMIN_EMAIL = readConfig().getString("userParams.admin.email");
    String ADMIN_PASSWORD = readConfig().getString("userParams.admin.password");
}

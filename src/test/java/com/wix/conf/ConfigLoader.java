package com.wix.conf;

import org.aeonbits.owner.ConfigFactory;

/**
 * Created by alpa on 2019-07-13
 */
public class ConfigLoader {

    private static Configuration conf;

    public static Configuration load() {
        if (conf == null) {
            conf = ConfigFactory.create(Configuration.class, System.getProperties());
        }
        return conf;
    }
}

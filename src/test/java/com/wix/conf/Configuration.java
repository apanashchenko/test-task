package com.wix.conf;

import org.aeonbits.owner.Config;

/**
 * Created by alpa on 2019-07-13
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:test.properties")
public interface Configuration extends Config {

    @Key("schema")
    @DefaultValue("http")
    String appSchema();

    @Key("appHost")
    @DefaultValue("georgel8.wixsite.com")
    String appHost();

    @Key("appPath")
    @DefaultValue("ait-interview/muejmjbiehrfs")
    String appPath();

}

package com.wix.extension;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.wix.conf.ConfigLoader.load;

/**
 * Created by alpa on 2019-07-11
 */
public class WebDriverExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {


    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.baseUrl = String.format("%s://%s/%s", load().appSchema(), load().appHost(), load().appPath());
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        open(baseUrl);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        close();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        SelenideLogger.removeListener("allure");
    }




}

package com.wix.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 2019-07-11
 */
public class LogInDialog extends BasePage {

    private SelenideElement logInViaEmailBtn = $("#memberLoginDialogswitchToEmailLink");
    private SelenideElement emailInput = $("#memberLoginDialogemailInputinput");
    private SelenideElement passwordInput = $("#memberLoginDialogpasswordInputinput");
    private SelenideElement loginBtn = $("#memberLoginDialogokButton");

    @Step
    public LogInDialog clickLogInViaEmailBtn() {
        logInViaEmailBtn.click();
        return this;
    }

    @Step
    public StartPage login(String email, String password) {
        setUserName(email).setPassword(password).clickLoginBtn();
        return new StartPage();
    }

    @Step
    public LogInDialog setUserName(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step
    public LogInDialog setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step
    public LogInDialog clickLoginBtn() {
        loginBtn.click();
        return this;
    }
}

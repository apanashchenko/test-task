package com.wix.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 2019-07-11
 */
public class SignUpDialog extends BasePage {

    private SelenideElement logInLink = $("#signUpDialogswitchDialogLink");
    private SelenideElement signInEmailBtn = $("#signUpDialogswitchToEmailLink");
    private SelenideElement emailInput = $("#signUpDialogemailInputinput");
    private SelenideElement passwordInput = $("#signUpDialogpasswordInputinput");
    private SelenideElement signInBtn = $("#signUpDialogokButton");

    @Step
    public LogInDialog openLoginDialog() {
        logInLink.click();
        return new LogInDialog();
    }

    @Step
    public SignUpDialog openSignInViaEmail() {
        signInEmailBtn.click();
        return new SignUpDialog();
    }

    @Step
    public StartPage signInViaEmail(String email, String password) {
        return setEmail(email)
                .setPassword(password)
                .clickSignInBtn();
    }

    @Step
    public SignUpDialog setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step
    public SignUpDialog setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step
    public StartPage clickSignInBtn() {
        clickByJs(signInBtn);
        return new StartPage();
    }
}

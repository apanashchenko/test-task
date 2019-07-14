package com.wix.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 2019-07-11
 */
public class WelcomePage extends BasePage {

    private SelenideElement logInLink = $("#comp-jxuhadd7login");

    @Step
    public SignUpDialog clickLogIn() {
        logInLink.click();
        return new SignUpDialog();
    }

    @Step
    public StartPage login(String email, String password) {
            return clickLogIn()
                    .openLoginDialog()
                    .clickLogInViaEmailBtn()
                    .login(email, password)
                    .userShouldBeLoggedIn();
    }

    public boolean isLogged() {
        return !logInLink.isDisplayed();
    }
}

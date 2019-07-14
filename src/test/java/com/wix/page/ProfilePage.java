package com.wix.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alpa on 2019-07-12
 */
public class ProfilePage extends BasePage {

    private static final String IFRAME_NAME = "comp-";
    private SelenideElement editBtn = $("[data-hook='editButton']>a");
    private SelenideElement memberNameInput = $("[data-hook='memberName'] input");
    private SelenideElement memberNameValue = $("[data-hook='memberName'] .ma-members-name-font");
    private SelenideElement saveBtn = $(".ma-pw-primary-button");

    @Step
    public ProfilePage clickEditBtn() {
        switchIframeByPartOfId(IFRAME_NAME);
        editBtn.click();
        return this;
    }

    @Step
    public ProfilePage inputMemberName(String name) {
        switchIframeByPartOfId(IFRAME_NAME);
        memberNameInput.setValue(name);
        return this;
    }

    @Step
    public ProfilePage clickSave() {
        switchIframeByPartOfId(IFRAME_NAME);
        saveBtn.click();
        return this;
    }

    @Step
    public ProfilePage memberShouldHaveName(String name) {
        memberNameValue.shouldHave(Condition.text(name));
        return this;
    }


}

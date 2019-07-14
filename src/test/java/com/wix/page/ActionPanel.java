package com.wix.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by alpa on 2019-07-12
 */
public class ActionPanel extends BasePage {

    private static final String IFRAME_NAME = "TPASection_jxuhagasiframe";
    private SelenideElement sortArrow = $("[data-hook='am-sort-field']");
    private SelenideElement memberSorting = $("[data-hook='am-filter-field']");
    private SelenideElement searchMemberFiled = $x("//*[@data-hook='am-search-field']/input");
    private SelenideElement searchMemberCount = searchMemberFiled.$x("./following-sibling::span");

    @Step
    public ActionPanel selectSortBy(String type) {
        switchIframe(IFRAME_NAME);
        sortArrow.click();
        $x("//span[contains(text(),'" + type + "')]").click();
        return this;
    }

    @Step
    public ActionPanel selectMemberSorting(String memberType) {
        switchIframe(IFRAME_NAME);
        memberSorting.click();
        $x("//span[contains(text(),'" + memberType + "')]").click();
        return this;
    }

    @Step
    public ActionPanel searchMember(String userName) {
        switchIframe(IFRAME_NAME);
        searchMemberFiled.setValue(userName).pressEnter();
        return this;
    }

    @Step
    public ActionPanel searchedMemberShouldBe(int number) {
        switchIframe(IFRAME_NAME);
        searchMemberCount.shouldHave(Condition.text(String.valueOf(number)));
        return this;
    }

}

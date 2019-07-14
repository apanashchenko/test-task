package com.wix.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.wix.page.modal.LeaveCommunityPopup;
import com.wix.page.modal.ReportMemberPopup;
import io.qameta.allure.Step;

/**
 * Created by alpa on 2019-07-11
 */
public class MemberBox {

    private SelenideElement parentElement;


    public MemberBox(SelenideElement parentElement) {
        this.parentElement = parentElement;
    }

    public String getName() {
        return parentElement.$x(".//*[@data-hook='memberBox.name']").text();
    }


    @Step
    public MemberBox clickFollow() {
        parentElement.$x(".//*[contains(@class,'ma-members-button-font-primary')]").click();
        return this;
    }

    @Step
    public MemberBox clickUnFollow() {
        getMemberBoxBtn().click();
        return this;
    }

    @Step
    public ProfilePage clickMyProfile() {
        getMemberBoxBtn().click();
        return new ProfilePage();
    }

    @Step
    public MemberBox shouldHaveFollowers(int followersNumber) {
        getFollowers().shouldHave(Condition.text(String.valueOf(followersNumber)));
        return this;
    }

    @Step
    public MemberBox shouldHaveFollowing(int followingNumber) {
        getFollowing().shouldHave(Condition.text(String.valueOf(followingNumber)));
        return this;
    }

    @Step
    public MemberBox openMoreActions() {
        getMoreActionsBtn().click();
        return this;
    }

    @Step
    public MemberBox moreActionsShouldBeAbsent() {
        getMoreActionsBtn().shouldNotBe(Condition.exist);
        return this;
    }

    @Step
    public ReportMemberPopup selectReportMember() {
        selectActions("Report Member");
        return (ReportMemberPopup) new ReportMemberPopup().isOpen();
    }

    @Step
    public LeaveCommunityPopup selectLeaveCommunity() {
        selectActions("Leave Community");
        return (LeaveCommunityPopup) new LeaveCommunityPopup().isOpen();
    }

    @Step
    private MemberBox selectActions(String action) {
        parentElement.$x(".//*[contains(text(),'" + action + "')]").click();
        return this;
    }

    public SelenideElement getMemberBoxBtn() {
        return parentElement.$x(".//*[contains(@class,'ma-members-button-font-secondary')]");
    }

    private SelenideElement getMoreActionsBtn() {
        return parentElement.$x(".//*[@aria-label='more-button.more-actions']");
    }

    private SelenideElement getFollowers() {
        return parentElement.$x(".//*[@data-hook='mb-followers']/span[1]");
    }

    private SelenideElement getFollowing() {
        return parentElement.$x(".//*[@data-hook='mb-following']/span[1]");
    }
}

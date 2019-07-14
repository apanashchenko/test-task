package com.wix.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.wix.data.MemberType;
import com.wix.data.SortingType;
import io.qameta.allure.Step;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by alpa on 2019-07-11
 */
public class StartPage extends BasePage {

    private static final String IFRAME_NAME = "TPASection_jxuhagasiframe";
    private SelenideElement menuArrow = $("#comp-jxuhadd7arrow");
    private SelenideElement avatar = $("#comp-jxuhadd7avatarimage");
    private ElementsCollection membersList = $$x("//*[@data-hook='memberBox']");

    private ActionPanel actionPanel = new ActionPanel();

    @Step
    public StartPage userShouldBeLoggedIn() {
        menuArrow.shouldBe(Condition.visible);
        avatar.shouldBe(Condition.exist);
        return this;
    }

    @Step
    public StartPage selectSortBy(SortingType sortingType) {
        return selectSortBy(sortingType.getType());
    }

    @Step
    public StartPage selectSortBy(String type) {
        actionPanel.selectSortBy(type);
        return this;
    }

    @Step
    public StartPage selectMemberSorting(MemberType memberType) {
        return selectMemberSorting(memberType.getType());
    }

    @Step
    public StartPage selectMemberSorting(String memberType) {
        actionPanel.selectMemberSorting(memberType);
        return this;
    }

    @Step
    public MemberBox getMember(String fullName) {
        return getMembers(1)
                .stream()
                .filter(memberBox ->fullName.equalsIgnoreCase(memberBox.getName()))
                .findFirst().orElseThrow(() -> new AssertionError("Member box for " + fullName + " not found!"));
    }

    @Step
    public List<MemberBox> getMembers() {
        return getMembers(1);
    }

    @Step
    public boolean isMemberPresent(String name) {
        return getMembers().stream().anyMatch(memberBox -> name.equalsIgnoreCase(memberBox.getName()));
    }

    @Step
    public ElementsCollection getMembersElementsCollection() {
        return membersList;
    }

    @Step
    public List<MemberBox> getMembers(int sizeGreaterThanOrEqual) {
        switchIframe(IFRAME_NAME);
        return membersList.shouldHave(sizeGreaterThanOrEqual(sizeGreaterThanOrEqual))
                .stream().map(MemberBox::new).collect(Collectors.toCollection(LinkedList::new));
    }

    @Step
    public StartPage searchMember(String userName) {
        actionPanel.searchMember(userName);
        return this;
    }

    @Step
    public StartPage searchedMemberShouldBe(int number) {
        actionPanel.searchedMemberShouldBe(number);
        return this;
    }

    @Step
    public StartPage followToUser(String name){
        findMemberBox(name).clickFollow();
        return this;
    }

    @Step
    public StartPage unFollowToUser(String name){
        findMemberBox(name).clickUnFollow();
        return this;
    }

    @Step
    public MemberBox findMemberBox(String name) {
        return getMembers().stream()
                .filter(m -> name.equalsIgnoreCase(m.getName()))
                .findFirst().orElseThrow(() -> new AssertionError("MemberBox " + name +" not found!"));
    }

}

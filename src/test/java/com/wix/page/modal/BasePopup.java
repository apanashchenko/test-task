package com.wix.page.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.wix.page.BasePage;
import com.wix.page.StartPage;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Created by alpa on 2019-07-12
 */
public abstract class BasePopup extends BasePage {

    private static final String IFRAME_ID_PART = "tpaPopup";
    protected SelenideElement popupModal = $x("//*[@data-hook='commonModal']");
    private SelenideElement confirmBtn = popupModal.$x("//*[@data-hook='common-modal-confirm']/span");
    private SelenideElement cancelBtn = popupModal.$x("//*[@data-hook='common-modal-cancel']/span");

    protected abstract void checkPopup();

    public BasePopup isOpen() {
        switchToPopupIframe();
        popupModal.waitUntil(Condition.exist, 5000L);
        checkPopup();
        return this;
    }

    public BasePopup selectRadioBtn(String item) {
        switchToPopupIframe();
        popupModal.$x("//label[starts-with(normalize-space(text()),'" + item + "')]").click();
        return this;
    }


    protected void switchToPopupIframe() {
        switchIframeByPartOfId(IFRAME_ID_PART);
    }

    public StartPage clickConfirm() {
        switchToPopupIframe();
        confirmBtn.click();
        return new StartPage().userShouldBeLoggedIn();
    }

    public StartPage clickCancel() {
        switchToPopupIframe();
        cancelBtn.click();
        return new StartPage().userShouldBeLoggedIn();
    }
}

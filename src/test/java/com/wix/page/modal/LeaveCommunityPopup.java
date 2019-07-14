package com.wix.page.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.wix.data.ReportReason;
import com.wix.page.StartPage;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Created by alpa on 2019-07-12
 */
public class LeaveCommunityPopup extends BasePopup {

    private static final String POPUP_NAME = "Sure You Want To Leave?";

    @Override
    protected void checkPopup() {
        popupModal.$x("./h1").shouldHave(Condition.text(POPUP_NAME));
    }

    public StartPage clickLeave() {
        return clickConfirm();
    }

    public StartPage clickStay() {
        return clickCancel();
    }
}

package com.wix.page.modal;

import com.codeborne.selenide.Condition;
import com.wix.data.ReportReason;
import com.wix.page.StartPage;

/**
 * Created by alpa on 2019-07-12
 */
public class ReportMemberPopup extends BasePopup {

    private static final String POPUP_NAME = "Report Member";

    @Override
    protected void checkPopup() {
        popupModal.$x("./h1").shouldHave(Condition.text(POPUP_NAME));
    }

    public ReportMemberPopup selectReason(ReportReason reportReason) {
        selectReason(reportReason.getReason());
        return this;
    }

    public ReportMemberPopup selectReason(String reason) {
        selectRadioBtn(reason);
        return this;
    }

    public StartPage clickReport() {
        return clickConfirm();
    }

    public StartPage clickCancel() {
        return super.clickCancel();
    }
}

package com.wix.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by alpa on 2019-07-11
 */
public abstract class BasePage {

    protected void switchIframe(String nameOrId) {
        switchTo().defaultContent();
        switchTo().frame(nameOrId);
    }

    protected void switchIframeByPartOfId(String idPart) {
        String iFrameId = getIframeId(idPart);
        switchIframe(iFrameId);
    }

    protected String getIframeId(String idPart) {
        switchTo().defaultContent();
        return $x("//iframe[contains(@id,'"+idPart+"')]").attr("id");
    }

    protected void clickByJs(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
    }
}

package com.wix.data;

/**
 * Created by alpa on 2019-07-11
 */
public enum ReportReason {

    OFFENCIVE_CONTENT("Offensive Content"),
    OFFENCIVE_MEDIA("Offensive Media"),
    SPAM("Spam");

    private String reason;

    ReportReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }



}

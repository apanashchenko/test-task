package com.wix.data;

/**
 * Created by alpa on 2019-07-11
 */
public enum MemberType {

    ALL_MEMBERS("All members"),
    ADMINS("Admins"),
    MODERATORS("Moderators");

    private String type;

    MemberType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }



}

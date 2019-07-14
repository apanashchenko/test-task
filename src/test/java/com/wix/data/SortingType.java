package com.wix.data;

/**
 * Created by alpa on 2019-07-11
 */
public enum SortingType {

    DEFAULT("Default"),
    NEWEST_TO_OLDEST("Newest to oldest"),
    NO_OF_FOLLOWERS("No. of followers"),
    OLDEST_TO_NEWEST("Oldest to newest"),
    NO_OF_FORUM_POST("No. of forum posts");

    private String type;

    SortingType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}

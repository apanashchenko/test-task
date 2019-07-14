package com.wix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by alpa on 2019-07-13
 */
@Data
public class SiteMemberDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("collectionId")
    private String collectionId;
    @JsonProperty("owner")
    private Boolean owner;
    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("name")
    private Object name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("status")
    private String status;
    @JsonProperty("dateCreated")
    private String dateCreated;
    @JsonProperty("dateUpdated")
    private String dateUpdated;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("memberRole")
    private String memberRole;
    @JsonProperty("contactId")
    private String contactId;
}

package com.wix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by alpa on 2019-07-13
 */
@Data
public class Payload {

    @JsonProperty("sessionToken")
    private String sessionToken;
    @JsonProperty("siteMemberDto")
    private SiteMemberDto siteMemberDto;
    @JsonProperty("rememberMe")
    private Boolean rememberMe;
    @JsonProperty("emailVerified")
    private Boolean emailVerified;
    @JsonProperty("expirationDate")
    private String expirationDate;
    @JsonProperty("cookieName")
    private String cookieName;
}

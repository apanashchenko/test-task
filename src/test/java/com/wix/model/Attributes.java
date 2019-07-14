package com.wix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by alpa on 2019-07-13
 */
@Data
public class Attributes {

    @JsonProperty("name")
    private Object name;
    @JsonProperty("firstName")
    private Object firstName;
    @JsonProperty("lastName")
    private Object lastName;
    @JsonProperty("imageUrl")
    private Object imageUrl;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("emailVerified")
    private Boolean emailVerified;
    @JsonProperty("privacyStatus")
    private String privacyStatus;

}

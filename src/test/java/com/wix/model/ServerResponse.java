package com.wix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by alpa on 2019-07-13
 */
@Data
public class ServerResponse {

    @JsonProperty("errorCode")
    private Integer errorCode;
    @JsonProperty("errorDescription")
    private String errorDescription;
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("payload")
    private Payload payload;
}

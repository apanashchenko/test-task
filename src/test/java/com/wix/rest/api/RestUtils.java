package com.wix.rest.api;

import com.wix.model.ServerResponse;
import okhttp3.Headers;
import org.openqa.selenium.Cookie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alpa on 2019-07-13
 */
public class RestUtils {

    public static Set<Cookie> getAuthorizationCookies(Headers headers, ServerResponse serverResponse) {
        Set<Cookie> authorizationCookies = new HashSet<>();
        Cookie smSessionCookie = new Cookie("smSession", serverResponse.getPayload().getSessionToken(), null, null);
        authorizationCookies.add(smSessionCookie);
        String svSessionName = "svSession";
        String svSession = RestUtils.getCookie(headers.values("Set-Cookie"), svSessionName);
        Cookie svSessionCookie = new Cookie(svSessionName, svSession, null, null);
        authorizationCookies.add(svSessionCookie);

        return authorizationCookies;
    }

    public static String getCookie(List<String> values, String name) {
        return values.stream()
                .filter(value -> value.contains(name))
                .findFirst().orElseThrow(() -> new RuntimeException("Cookie " + name + " not found in header!"))
                .split("=")[1]
                .split(";")[0]
                .trim();


    }
}

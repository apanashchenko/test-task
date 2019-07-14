package com.wix.rest.api;

import com.wix.conf.Configuration;
import com.wix.model.ServerResponse;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;

import static com.wix.conf.ConfigLoader.load;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 2019-07-13
 */
public class RestApiHelper {

    private static final String COLLECTION_ID = "a340d264-32b4-48a4-bfa9-5d1cdc0c114a";
    private static final String META_SITE_ID = "808e5c9a-4507-42bf-a088-320bf0b96a21";

    public ServerResponse login(String email, String password){
        Headers headers;
        Response<ServerResponse> loginUser = null;
        try {
            headers = getHeaders();

        String svSession = RestUtils.getCookie(headers.values("Set-Cookie"), "svSession");

        String appUrl = appUrl();

        LoginService loginService = RetrofitClient.createService(LoginService.class);
        loginUser = loginService.login(svSession, COLLECTION_ID, META_SITE_ID, appUrl,
                email, password).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(loginUser.code()).as("Bad login request status code!").isEqualTo(200);

        ServerResponse serverResponse = loginUser.body();

        assertThat(serverResponse.isSuccess()).as("Login is not success!").isNotNull().isTrue();
        assertThat(serverResponse.getPayload().getSessionToken())
                .as("sessionToken is not set!")
                .isNotNull()
                .isNotBlank()
                .isNotEmpty();

        return serverResponse;
    }

    public ServerResponse registerUserByEmail(String email, String password) {
        Headers headers = getHeaders();

        String svSession = RestUtils.getCookie(headers.values("Set-Cookie"), "svSession");

        String appUrl = appUrl();
        String privacyStatus = "PUBLIC";
        String lang = "en";

        RegisterService registerService = RetrofitClient.createService(RegisterService.class);
        Response<ServerResponse> registerUserResponse = null;
        try {
            registerUserResponse = registerService.registerUser(svSession, COLLECTION_ID, META_SITE_ID, appUrl,
                    email, password, privacyStatus, lang).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(registerUserResponse.code()).as("Bad registration request status code!").isEqualTo(200);

        ServerResponse serverResponse = registerUserResponse.body();

        assertThat(serverResponse.isSuccess()).as("Login is not success!").isNotNull().isTrue();
        assertThat(serverResponse.getPayload().getSessionToken())
                .as("sessionToken is not set!")
                .isNotNull()
                .isNotBlank()
                .isNotEmpty();

        return serverResponse;
    }

    public Headers getHeaders() {
        LoginService loginService = RetrofitClient.createService(LoginService.class);

        Response<ResponseBody> loginPage = null;
        try {
            loginPage = loginService.getLoginPage().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(loginPage.code()).as("Bad login page request status code!").isEqualTo(200);

        Headers headers = loginPage.headers();
        assertThat(headers).as("Headers is empty!").isNotNull();
        return headers;
    }

    private String appUrl() {
        Configuration config = load();
        return String.format("%s://%s/%s", config.appSchema(), config.appHost(), config.appPath());
    }


}

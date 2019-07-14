package com.wix.rest.api;

import com.wix.model.ServerResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by alpa on 2019-07-12
 */
public interface LoginService {

    @GET("/ait-interview/muejmjbiehrfs")
    @Headers("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
    Call<ResponseBody> getLoginPage();

    @POST("/_api/wix-sm-webapp/member/login")
    @FormUrlEncoded
    Call<ServerResponse> login(@Field("svSession") String svSession, @Field("collectionId") String collectionId,
                               @Field("metaSiteId") String metaSiteId, @Field("appUrl") String appUrl,
                               @Field("email") String email, @Field("password") String password);
}

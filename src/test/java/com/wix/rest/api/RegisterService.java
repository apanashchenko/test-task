package com.wix.rest.api;

import com.wix.model.ServerResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by alpa on 2019-07-12
 */
public interface RegisterService {

    @POST("/_api/wix-sm-webapp/member/register")
    @FormUrlEncoded
    Call<ServerResponse> registerUser(@Field("svSession") String svSession, @Field("collectionId") String collectionId,
                                    @Field("metaSiteId") String metaSiteId, @Field("appUrl") String appUrl,
                                    @Field("email") String email, @Field("password") String password,
                                    @Field("privacyStatus") String privacyStatus, @Field("lang") String lang);
}

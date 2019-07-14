package com.wix.rest.api;

import com.wix.conf.Configuration;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

import static com.wix.conf.ConfigLoader.load;

/**
 * Created by alpa on 2019-07-12
 */
public class RetrofitClient {

    public static <T> T createService(final Class<T> service) {
        return new Retrofit.Builder()
                .client(getClient().build())
                .baseUrl(restBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(service);
    }

    private static OkHttpClient.Builder getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.callTimeout(1000, TimeUnit.MILLISECONDS);
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        return httpClient;
    }

    private static String restBaseUrl() {
        Configuration config = load();
        return String.format("%s://%s", config.appSchema(), config.appHost());
    }

}

package com.example.redditdemo.webapi;

import com.google.gson.JsonElement;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Single;

public interface ApiCallMethods {

    @FormUrlEncoded
    @POST("access_token")
    Single<JsonElement> authorizeClient(
            @Field("grant_type") String grantType,
            @Field("code") String code,
            @Field("redirect_uri") String redirectUrl
    );
}

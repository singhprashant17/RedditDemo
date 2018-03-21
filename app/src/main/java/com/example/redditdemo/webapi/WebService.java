package com.example.redditdemo.webapi;

import android.support.annotation.NonNull;
import android.util.Base64;

import com.example.redditdemo.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.redditdemo.utility.Constants.Url.CLIENT_ID;

public final class WebService {

    private WebService() {
    }

    /**
     * basic retrofit instance generator
     */
    @NonNull
    private static Retrofit getRetrofitInstance() {

        final OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("User-Agent", "Sample App")
                    .addHeader("Authorization", "Basic " +
                            Base64.encodeToString((CLIENT_ID + ":").getBytes(), Base64.NO_WRAP))
                    .build();

            return chain.proceed(request);
        }).addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
    }

    public static ApiCallMethods createService() {
        return getRetrofitInstance().create(ApiCallMethods.class);
    }
}

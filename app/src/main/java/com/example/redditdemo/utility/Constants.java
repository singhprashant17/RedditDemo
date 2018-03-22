package com.example.redditdemo.utility;

public final class Constants {
    public static final String AUTHORIZATION_CODE = "authorization_code";

    public static final class Url {
        public static final String AUTH_URL =
                "https://www.reddit.com/api/v1/authorize.compact?client_id=%s" +
                        "&response_type=code&state=%s&redirect_uri=%s&" +
                        "duration=permanent&scope=identity";

        public static final String CLIENT_ID = "ujwbeu7jI5NyMQ";
        public static final String REDIRECT_URI = "http://127.0.0.1/callback";
        public static final String STATE = "MY_RANDOM_STRING_1";
    }

    public static final class SharedPrefs {
        public static final String AUTHORIZATION = "authorization";
    }
}

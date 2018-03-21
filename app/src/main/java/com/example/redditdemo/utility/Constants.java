package com.example.redditdemo.utility;

public final class Constants {
    public static final class Url {
        public static final String AUTH_URL =
                "https://www.reddit.com/api/v1/authorize.compact?client_id=%s" +
                        "&response_type=code&state=%s&redirect_uri=%s&" +
                        "duration=permanent&scope=identity";

        public static final String CLIENT_ID = "ujwbeu7jI5NyMQ";

        public static final String REDIRECT_URI = "http://127.0.0.1/callback";

        public static final String STATE = "MY_RANDOM_STRING_1";

        public static final String ACCESS_TOKEN_URL = "https://www.reddit.com/api/v1/access_token";
    }

    public static final class SharedPrefs {
        public static final String CODE = "code";
    }
}

package com.example.mock_instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("PM5yt8rbHDl5vSYFgtggMo6hTnWZDczT0RVWKylW")
            .clientKey("V06ZEcI9tnrfUR6FlW6VeAKcyIh0d3lqjQMo7dFZ")
            .server("https://parseapi.back4app.com")
            .build()
        );
    }
}

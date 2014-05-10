package com.hayav;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hayav.cache.LocalDatabase;

public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        /* New Handler to start the Menu-Activity 
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                LocalDatabase db = new LocalDatabase(getBaseContext());

                /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent(SplashActivity.this, HelloAndroidActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);



    }
}
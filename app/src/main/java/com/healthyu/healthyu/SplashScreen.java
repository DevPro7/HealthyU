package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Marina on 3/9/2017.
 */

public class SplashScreen extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ImageView imageView = (ImageView) findViewById(R.id.splashimageview);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        imageView.startAnimation(animation);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
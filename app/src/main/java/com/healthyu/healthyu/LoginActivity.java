package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Marina on 3/9/2017.
 */

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginRequest(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}

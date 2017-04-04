package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/**
 * Created by Marina on 3/9/2017.
 */

public class LoginActivity extends Activity {

    TextView usernameTV, passwordTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTV = (TextView) findViewById(R.id.loginUsername);
        passwordTV = (TextView) findViewById(R.id.loginPassword);

        usernameTV.setOnFocusChangeListener(hideKeyboardListener);
        passwordTV.setOnFocusChangeListener(hideKeyboardListener);
    }


    View.OnFocusChangeListener hideKeyboardListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                hideKeyboard(v);
            }
        }
    };

    public void onLoginRequest(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

        /**
         * Check session preferences  against the strings inside the password and username TextViews
         * startActivity if valid, throw a dialog box if invalid
         */
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

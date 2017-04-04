package com.healthyu.healthyu;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Marina on 3/9/2017.
 */

public class RegisterActivity extends Activity {

    TextView usernameTV, passwordTV, passwordConfirmTV;
    ImageView registerPasswordConfirmImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        View.OnFocusChangeListener hideKeyboardListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        };

        usernameTV = (TextView) findViewById(R.id.registerUsername);
        passwordTV = (TextView) findViewById(R.id.registerPassword);
        passwordConfirmTV = (TextView) findViewById(R.id.registerPasswordConfirm);
        registerPasswordConfirmImage = (ImageView) findViewById(R.id.registerPasswordConfirmImage);

        usernameTV.setOnFocusChangeListener(hideKeyboardListener);
        passwordTV.setOnFocusChangeListener(hideKeyboardListener);
        passwordConfirmTV.setOnFocusChangeListener(hideKeyboardListener);

        passwordConfirmTV.addTextChangedListener(new TextWatcher() {
            String currentString;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentString = passwordConfirmTV.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(currentString.equals(passwordTV.getText().toString())) {
                    registerPasswordConfirmImage.setImageResource(R.drawable.checkmark);
                }else {
                    registerPasswordConfirmImage.setImageResource(R.drawable.exclamation_red);
                }
            }
        });
    }

    public void onREgisterClick(View v) {
        String username, password, passwordConfirm;

        /**
         * Add the password and username to sessionpreferences
         */

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

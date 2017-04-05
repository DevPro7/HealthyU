package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


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

    public void onRegisterClick(View v) {

        String username, password, passwordConfirm;
        username=usernameTV.getText().toString();
        password=passwordTV.getText().toString();
        passwordConfirm=passwordConfirmTV.getText().toString();



        if (username.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        else if
         (password.matches("")) {
            Toast.makeText(this, "You did not enter a password", Toast.LENGTH_SHORT).show();
            return;
        }
        else if
                (passwordConfirm.matches("")) {
            Toast.makeText(this, "You did not enter a password confirmation", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (!password.contentEquals(passwordConfirm))
        {
            Toast.makeText(this, "passwords did not match", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            Util.putKey(username,password,PreferenceManager.getDefaultSharedPreferences(this));
            Toast.makeText(this, "Registered " +"  " + username +  Util.getValue(username,PreferenceManager.getDefaultSharedPreferences(this)), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }





        /**
         * Go To Main
         */

    }
    public void onRegisterSuccess (View v){
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

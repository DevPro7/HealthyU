package com.healthyu.healthyu;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserSettings extends AppCompatActivity {
    EditText userET;
    EditText emailET;
    EditText weightET;
    EditText ageET;
    EditText goalActivityET;
    EditText goalDietET;
    EditText dietTypeET;

    View mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);


        mv=findViewById(R.id.mainLayout);


        userET = (EditText) findViewById(R.id.userNameET );
        emailET=(EditText) findViewById(R.id.emailET);
        weightET=(EditText) findViewById(R.id.weightET );
        ageET=(EditText) findViewById(R.id.ageET );
        goalActivityET=(EditText) findViewById(R.id.userNameGoalActivity);
        goalDietET=(EditText) findViewById(R.id.goalDietET );
        dietTypeET=(EditText) findViewById(R.id.dietTypeET );



        if (!(Util.getValue("UserName", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            userET.setText(Util.getValue("UserName", PreferenceManager.getDefaultSharedPreferences(this)));
        }
        if (!(Util.getValue("UserEmail", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            emailET.setText(Util.getValue("UserEmail", PreferenceManager.getDefaultSharedPreferences(this)));
        }
        if (!(Util.getValue("UserWeight", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            weightET.setText(Util.getValue("UserWeight", PreferenceManager.getDefaultSharedPreferences(this)));
        }
        if (!(Util.getValue("UserAge", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            ageET.setText(Util.getValue("UserAge", PreferenceManager.getDefaultSharedPreferences(this)));
        }

        if (!(Util.getValue("UserAge", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            ageET.setText(Util.getValue("UserAge", PreferenceManager.getDefaultSharedPreferences(this)));
        }

        if (!(Util.getValue("UserGoalActivity", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            goalActivityET.setText(Util.getValue("UserGoalActivity", PreferenceManager.getDefaultSharedPreferences(this)));
        }

        if (!(Util.getValue("UserGoalDiet", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            goalDietET.setText(Util.getValue("UserGoalDiet", PreferenceManager.getDefaultSharedPreferences(this)));
        }



        if (!(Util.getValue("UserGoalDiet", PreferenceManager.getDefaultSharedPreferences(this))).equals("0"))
        {
            dietTypeET.setText(Util.getValue("UserDietType", PreferenceManager.getDefaultSharedPreferences(this)));
        }

        



    }

    //username
    public void onEditClick(View v)
    {
        Util.putKey("UserName",userET.getText().toString(),PreferenceManager.getDefaultSharedPreferences(this));
        mv.requestFocus();
        hideKeyboard(v);

    }


    //email
    public void onEditClickEmail(View v)
    {
        Util.putKey("UserEmail",emailET.getText().toString(),PreferenceManager.getDefaultSharedPreferences(this));
        mv.requestFocus();
        hideKeyboard(v);

    }


    //weight
    public void onEditClickWeight(View v)
    {
        Util.putKey("UserWeight", weightET.getText().toString(),PreferenceManager.getDefaultSharedPreferences(this));
        mv.requestFocus();
        hideKeyboard(v);

    }

    //age
    public void onEditClickAge(View v)
    {
        Util.putKey("UserAge",ageET.getText().toString(),PreferenceManager.getDefaultSharedPreferences(this));
        mv.requestFocus();
        hideKeyboard(v);

    }

    //gaoalA
    public void onEditClickgoalActivity(View v)
    {
        Util.putKey("UserGoalActivity",goalActivityET.getText().toString(),PreferenceManager.getDefaultSharedPreferences(this));
        mv.requestFocus();
        hideKeyboard(v);

    }
    //goald
    public void onEditClickGoalDiet(View v)
    {
        Util.putKey("UserGoalDiet",goalDietET.getText().toString(),PreferenceManager.getDefaultSharedPreferences(this));
        mv.requestFocus();
        hideKeyboard(v);

    }
    //diettype
    public void onEditClickDietType(View v)
    {
        Util.putKey("UserDietType",dietTypeET.getText().toString(),PreferenceManager.getDefaultSharedPreferences(this));
        mv.requestFocus();
        hideKeyboard(v);

    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
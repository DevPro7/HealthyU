package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Integer.*;

/**
 * Created by Marina on 3/9/2017.
 */

public class LogActivity extends Activity {
    public LogActivity(){}

    Spinner activities;
    EditText durationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText(My_Time.date_time());

        activities = (Spinner) findViewById(R.id.activitiesSpinner);
        durationEditText = (EditText) findViewById(R.id.durationEditText);


        Resources res = getResources();
        String[] activitiesArray = res.getStringArray(R.array.activities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, activitiesArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activities.setAdapter(adapter);
    }



    public void showTotal(View v) {
        /*
        handle saving information input
         */
        durationEditText = (EditText) findViewById(R.id.durationEditText);
        String duration = durationEditText.getText().toString();

        if (!(duration.isEmpty())) {
            Integer intDuration = Integer.parseInt(duration);
           ///stores values to Preferencess
           Util.putKey("MaxCal",duration,PreferenceManager.getDefaultSharedPreferences(this));
           //
            Util.getValue("MaxCal",PreferenceManager.getDefaultSharedPreferences(this));


        }


       final TextView maxTextView = (TextView) findViewById(R.id.textViewMaXCal);
       maxTextView.setText(Util.getValue("MaxCal",PreferenceManager.getDefaultSharedPreferences(this)));


    }
}

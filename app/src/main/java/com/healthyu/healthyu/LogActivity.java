package com.healthyu.healthyu;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.*;

/**
 * Created by Marina on 3/9/2017.
 */

public class LogActivity extends Activity {
    public LogActivity() {
    }

    Spinner activitiesSpinner;
    EditText durationEditText;
    TextView maxTextView;
    TextView totalCalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText(My_Time.date_time());

        activitiesSpinner = (Spinner) findViewById(R.id.activitiesSpinner);
        durationEditText = (EditText) findViewById(R.id.durationEditText);

        maxTextView = (TextView) findViewById(R.id.textViewMaXCal);
        maxTextView.setText(Util.getValue("MaxCal", PreferenceManager.getDefaultSharedPreferences(this)));
        totalCalTextView = (TextView) findViewById(R.id.activityCal);

        Resources res = getResources();
        String[] activitiesArray = res.getStringArray(R.array.activities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, activitiesArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitiesSpinner.setAdapter(adapter);
    }


    public void showTotal(View v) {
        /*
        handle saving information input
         */
        String activity;
        String activityCalories;
        String duration = durationEditText.getText().toString();
        int position = activitiesSpinner.getSelectedItemPosition();
        double activityTotal;
        double totalCal = 0;

        if ((position > 0) && (!(duration.isEmpty()))) {
            activityCalories = getResources().getStringArray(R.array.activities_cal)[activitiesSpinner.getSelectedItemPosition()];
            activityTotal = calcActivityD(activityCalories, duration);
            totalCal = Double.parseDouble(Util.getValue("MaxCal", PreferenceManager.getDefaultSharedPreferences(this))) + activityTotal;


            Util.putKey("MaxCal", String.valueOf(totalCal), PreferenceManager.getDefaultSharedPreferences(this));
            maxTextView.setText(Util.getValue("MaxCal", PreferenceManager.getDefaultSharedPreferences(this)));
            totalCalTextView.setText(String.valueOf(activityTotal)); // show toast select gender



        } else {
            Toast.makeText(this, "Please select Activity and duration", Toast.LENGTH_SHORT).show();

        }


    }

    private double calcActivityD(String activity, String duration) {
        Double total;
        try {

            total = Double.parseDouble(activity) * Double.parseDouble(duration);
            return total;
        } catch (NumberFormatException e) {

        }

        return 0;
    }


}

package com.healthyu.healthyu;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Marina on 3/9/2017.
 */

public class LogActivity extends Activity {

    Spinner activities;
    EditText durationEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        activities = (Spinner) findViewById(R.id.activitiesSpinner);
        durationEditText = (EditText) findViewById(R.id.durationEditText);



        Resources res = getResources();
        String[] activitiesArray = res.getStringArray(R.array.activities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, activitiesArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activities.setAdapter(adapter);
    }

    public void onSubmitClick(View v) {
        /*
        handle saving information input
         */
        Integer duration = Integer.valueOf(durationEditText.getText().toString());
        String activity = (String) activities.getSelectedItem();
        finish();
    }
}

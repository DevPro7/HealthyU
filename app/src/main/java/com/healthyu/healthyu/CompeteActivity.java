package com.healthyu.healthyu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Marina on 3/9/2017.
 */

public class CompeteActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compete);



        TextView mTextView = (TextView) findViewById(R.id.textView1);

         mTextView.setText(My_Time.date_time());

    }
}

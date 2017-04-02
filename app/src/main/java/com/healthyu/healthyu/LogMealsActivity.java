package com.healthyu.healthyu;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Marina on 3/9/2017.
 */

public class LogMealsActivity extends Activity {

    Spinner fruits;
    EditText amountEditText;


    Spinner vegi;
    EditText amountEditTextvegi;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText("Today :  " +My_Time.date_time());


        ///fruits
        fruits = (Spinner) findViewById(R.id.mealSpinner);
        amountEditText = (EditText) findViewById(R.id.amountEditText);

        Resources res = getResources();
        String[] activitiesArray = res.getStringArray(R.array.meals_Fruits);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, activitiesArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fruits.setAdapter(adapter);


        //vegi
        vegi = (Spinner) findViewById(R.id.vegiSpinner);
        amountEditTextvegi = (EditText) findViewById(R.id.vegiEditText);

        Resources res2 = getResources();
        String[] vegiArray = res.getStringArray(R.array.meals_Vegi);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, vegiArray);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vegi.setAdapter(adapter2);
       //meats




       //grains




    }
}

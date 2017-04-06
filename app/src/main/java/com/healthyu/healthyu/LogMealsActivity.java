package com.healthyu.healthyu;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Marina on 3/9/2017.
 */

public class LogMealsActivity extends Activity {

    Spinner fruitsSpinner;
    EditText amountEditText;


    Spinner vegiSpinner;
    EditText amountEditTextvegi;

    Spinner dairySpinner;
    EditText amountEditTextdairy;

    Spinner meatsSpinner;
    EditText amountEditTextmeats;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText("Today :  " +My_Time.date_time());


        ///fruits
        fruitsSpinner = (Spinner) findViewById(R.id.mealSpinner);
        amountEditText = (EditText) findViewById(R.id.amountEditText);

        Resources res = getResources();
        String[] activitiesArray = res.getStringArray(R.array.meals_Fruits);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, activitiesArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fruitsSpinner.setAdapter(adapter);
        ///Gets For fruit
        String selectedVal = getResources().getStringArray(R.array.meals_dairy_cal)[fruitsSpinner.getSelectedItemPosition()];
        Toast.makeText(this, selectedVal, Toast.LENGTH_SHORT).show();
        //vegi
        vegiSpinner = (Spinner) findViewById(R.id.vegiSpinner);
        amountEditTextvegi = (EditText) findViewById(R.id.vegiEditText);

        Resources res2 = getResources();
        String[] vegiArray = res2.getStringArray(R.array.meals_Vegi);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, vegiArray);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vegiSpinner.setAdapter(adapter2);

        //dairy
        dairySpinner = (Spinner) findViewById(R.id.dairySpinner);
        amountEditTextdairy = (EditText) findViewById(R.id.dairyEditText);

        Resources res3 = getResources();
        String[] dairyArray = res3.getStringArray(R.array.meals_dairy);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, dairyArray);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dairySpinner.setAdapter(adapter3);





       //meats
        meatsSpinner = (Spinner) findViewById(R.id.meatsSpinner);
        amountEditTextmeats = (EditText) findViewById(R.id.meatsEditText);

        Resources res4 = getResources();
        String[] meatsArray = res4.getStringArray(R.array.meals_meats);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, meatsArray);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meatsSpinner.setAdapter(adapter4);




       //grains




    }
}

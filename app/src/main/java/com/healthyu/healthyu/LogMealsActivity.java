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

/**
 * Created by Marina on 3/9/2017.
 */

public class LogMealsActivity extends Activity {

    Spinner vegiSpinner;
    EditText amountEditTextvegi;

    Spinner fruitsSpinner;
    EditText amountEditText;

    Spinner dairySpinner;
    EditText amountEditTextdairy;

    Spinner meatsSpinner;
    EditText amountEditTextmeats;

    TextView totalCalTV;
    TextView totalDailyCalTV;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText("Today :  " + My_Time.date_time());

        //totalCal
        totalCalTV =(TextView) findViewById(R.id.mealCalTotal);
        totalDailyCalTV =(TextView) findViewById(R.id.dailyCalTotal);


        ///fruits
        fruitsSpinner = (Spinner) findViewById(R.id.mealSpinner);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        totalCalTV =(TextView) findViewById(R.id.textViewMaXCal);

        Resources res = getResources();
        String[] activitiesArray = res.getStringArray(R.array.meals_Fruits);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, activitiesArray);
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
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vegiArray);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vegiSpinner.setAdapter(adapter2);

        //dairy
        dairySpinner = (Spinner) findViewById(R.id.dairySpinner);
        amountEditTextdairy = (EditText) findViewById(R.id.dairyEditText);

        Resources res3 = getResources();
        String[] dairyArray = res3.getStringArray(R.array.meals_dairy);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dairyArray);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dairySpinner.setAdapter(adapter3);


        //meats
        meatsSpinner = (Spinner) findViewById(R.id.meatsSpinner);
        amountEditTextmeats = (EditText) findViewById(R.id.meatsEditText);

        Resources res4 = getResources();
        String[] meatsArray = res4.getStringArray(R.array.meals_meats);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, meatsArray);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meatsSpinner.setAdapter(adapter4);
    }




       //grains

        public void submitAllActiviyies(View v)
    {
        Double summAll=0.0;
        Double  totalCalFoodDaily;
        Resources res = getResources();
        summAll+= calcTotal(v, amountEditTextvegi, vegiSpinner ,res.getStringArray(R.array.meals_Vegi_cal));
        summAll+= calcTotal(v, amountEditText, fruitsSpinner ,res.getStringArray(R.array.meals_Fruits_Cal));
        summAll+= calcTotal(v, amountEditTextdairy, dairySpinner ,res.getStringArray(R.array.meals_dairy_cal));
        summAll+= calcTotal(v, amountEditTextmeats, meatsSpinner ,res.getStringArray(R.array.meals_meats_cal));

        Toast.makeText(this, String.valueOf(summAll), Toast.LENGTH_SHORT).show();
      //  totalCalTV.setText(String.valueOf(summAll));
      //  totalCalTV.setText("hello");

       // totalCalFoodDaily = Double.parseDouble(Util.getValue("MaxCalFood", PreferenceManager.getDefaultSharedPreferences(this))) + summAll;

      //  totalCalTV.setText(String.valueOf(summAll));
       // totalCalTV.setText("hello");
       // totalDailyCalTV.setText(Util.getValue("MaxCalFood", PreferenceManager.getDefaultSharedPreferences(this)));

    }
    public double calcTotal(View v,EditText amountET, Spinner foodSpinner ,String [] calories) {


        String amount = amountET.getText().toString();
        int position = foodSpinner.getSelectedItemPosition();
        double activityTotal;
        double totalCal = 0;
        String mealCalories;

        if ((position > 0) && (!(amount.isEmpty()))) {
            mealCalories = calories[position];
            if(Double.parseDouble(mealCalories)>315.00)
            {
                Toast.makeText(this, "High Calories Item" , Toast.LENGTH_SHORT).show();
            }
            totalCal =calcActivityD(mealCalories,amount);

            return totalCal;

        } else {
           return 0;


        }
    }

    private double calcActivityD(String activity, String duration) {
        Double total;
        try {

            total = Double.parseDouble(activity) * Double.parseDouble(duration)*0.01;
            return total;
        } catch (NumberFormatException e) {

        }

        return 0;
    }


}

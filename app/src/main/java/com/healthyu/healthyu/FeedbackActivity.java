package com.healthyu.healthyu;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Marina on 3/9/2017.
 */

public class FeedbackActivity extends Activity {
    int goalActivity;
    int nowActivity;
    int goalDiet;
    int nowDiet;

    TextView workoutStatusTV;
    TextView workoutCal;
    TextView workoutMessage;
    TextView goalMessage;

    TextView dietStatusTV;
    TextView dietCal;
    TextView dietMessage;
    Boolean actGoalMet;
    Boolean dietGoalMet;



   // id/workoutStatus"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        workoutStatusTV =(TextView) findViewById(R.id.workoutStatus);
        workoutCal =(TextView) findViewById(R.id.workoutCal);
        workoutMessage=(TextView) findViewById(R.id.workoutMessage);

        dietStatusTV =(TextView) findViewById(R.id.dietStatus);
        dietCal =(TextView) findViewById(R.id.dietCal);
        dietMessage=(TextView) findViewById(R.id.dietMessage);
        goalMessage=(TextView) findViewById(R.id.goalMessage);

        workoutStatus();
        dietStatus();
        if(actGoalMet&&dietGoalMet)
        {
         goalMessage.setText("GOALS MET");
         goalMessage.setTextColor(getResources().getColor(R.color.colorGreen));
        }
        else{

            goalMessage.setText("GOALS NOT MET");
            goalMessage.setTextColor(getResources().getColor(R.color.colorAccent));

        }



    }


    public void workoutStatus() {
        goalActivity = (int) Double.parseDouble(Util.getValue("UserGoalActivity", PreferenceManager.getDefaultSharedPreferences(this)));
        nowActivity = (int) Double.parseDouble(Util.getValue("MaxCal", PreferenceManager.getDefaultSharedPreferences(this)));


        if (nowActivity <= goalActivity)


        {
            workoutStatusTV.setText("NEED TO BURN");
            workoutStatusTV.setBackgroundResource(R.color.colorAccent);
            workoutCal.setText(String.valueOf(goalActivity - nowActivity));
            workoutMessage.setText(" to meet the daily goal of " + String.valueOf(goalActivity) + " cal");
            workoutMessage.setText("You met todays goal" + String.valueOf(goalActivity) + " cal");
            actGoalMet=false;
        } else {

            workoutStatusTV.setText("GOAL MET");
            workoutStatusTV.setBackgroundResource(R.color.colorGreen);
            workoutCal.setText(String.valueOf(nowActivity - goalActivity));
            workoutMessage.setText("You met todays goal of" + String.valueOf(goalActivity) + " cal");
            actGoalMet=true;


        }
    }
    public void dietStatus()
    {
        goalDiet =(int)Double.parseDouble(Util.getValue("UserGoalDiet", PreferenceManager.getDefaultSharedPreferences(this)));
        nowDiet = (int)Double.parseDouble(Util.getValue("MaxCalFood", PreferenceManager.getDefaultSharedPreferences(this)));


        if (nowDiet >=goalDiet)


        {
            dietStatusTV.setText("Over limit");
            dietStatusTV.setBackgroundResource(R.color.colorAccent);
            dietCal.setText(String.valueOf(nowDiet-goalDiet));
            dietMessage.setText(" you are over the daily goal of "+ String.valueOf(goalDiet) + " Cal") ;
            dietGoalMet=false;
        }
        else
        {

            dietStatusTV.setText("on track ");
            dietStatusTV.setBackgroundResource(R.color.colorGreen);
            dietCal.setText(String.valueOf(goalDiet - nowDiet));
            dietMessage.setText("You are under the daily calories goal of " + String.valueOf(goalDiet) + " Cal" ) ;
            dietGoalMet=true;

        }




    }
}

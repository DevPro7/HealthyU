package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.healthyu.healthyu.models.ApiEndpointInterface;
import com.healthyu.healthyu.models.NetworkUtils;
import com.healthyu.healthyu.models.User;

import org.w3c.dom.Text;

import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Marina on 3/9/2017.
 */

public class CompeteActivity extends Activity {

    TextView caloriesIntake, caloriesBurn,usernameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compete);

        caloriesIntake = (TextView) findViewById(R.id.compete_caloriesIntake);
        caloriesBurn = (TextView) findViewById(R.id.compete_caloriesBurn);
        usernameTV=(TextView) findViewById(R.id.userName);
        String userName =  Util.getValue("UserName", PreferenceManager.getDefaultSharedPreferences(this));
        if(userName.equals("0"))
        {
            usernameTV.setText("SomeUser");
        } else
            {
                usernameTV.setText(userName);     }
        caloriesIntake.setText(Util.getValue("MaxCalFood", PreferenceManager.getDefaultSharedPreferences(this)));
        caloriesBurn.setText(Util.getValue("MaxCal", PreferenceManager.getDefaultSharedPreferences(this)));


    }

    public void onCompeteClick(View v) {
        double calBurned = Double.valueOf(caloriesBurn.getText().toString());
        double calIntake = Double.valueOf(caloriesIntake.getText().toString());

        User user = new User(usernameTV.getText().toString(), (int)calBurned,(int)calIntake, 3);

        TextView mTextView = (TextView) findViewById(R.id.textView1);

        mTextView.setText("Today : "+ My_Time.date_time());


        ApiEndpointInterface apiService = NetworkUtils.getApiService();
        Call<ResponseBody> call = apiService.postUser(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int statusCode = response.code();

                if(statusCode == 200) {
                    Toast.makeText(CompeteActivity.this, "Added user to database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void startStandingsActivity(View v) {
        Intent intent = new Intent(this, StandingActivity.class);
        startActivity(intent);
    }
}

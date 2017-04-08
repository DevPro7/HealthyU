package com.healthyu.healthyu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.healthyu.healthyu.models.ApiEndpointInterface;
import com.healthyu.healthyu.models.NetworkUtils;
import com.healthyu.healthyu.models.User;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Daniel on 4/4/17.
 */

public class AccountProfileActivity extends Activity {

    TextView welcomeTV, activityTV, caloriesTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);


        welcomeTV = (TextView) findViewById(R.id.account_welcome_text);
        activityTV = (TextView) findViewById(R.id.topactivity_textview);
        caloriesTV = (TextView) findViewById(R.id.topcal_textview);


        ApiEndpointInterface apiService = NetworkUtils.getApiService();
        String userid = new String("1000");
        Call<User> call = apiService.getUser(userid);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                    User user = response.body();

                    Integer activity, cal;
                    String name = user.getFriendlyName();
                    activity = user.getTopActivity();
                    cal = user.getTopCalories();

                    welcomeTV.setText("Welcome: "+ name);
                    activityTV.setText(String.valueOf(activity));
                    caloriesTV.setText(String.valueOf(cal));


                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


}

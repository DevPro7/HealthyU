package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Marina on 3/9/2017.
 */

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Resources res = getResources();
        String[] quotes = res.getStringArray(R.array.quotes);

        TextView quoteTextView = (TextView) findViewById(R.id.quoteTextView);

        Random random = new Random();
        quoteTextView.setText(quotes[random.nextInt(quotes.length - 1)]);
    }

    public void onProfileClick(View v) {
        Intent intent = new Intent(this, AccountProfileActivity.class);
        startActivity(intent);
    }
    public void onLogActivityClick(View v) {
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }
    public void onLogMealsClick(View v) {
        Intent intent = new Intent(this, LogMealsActivity.class);
        startActivity(intent);
    }
    public void onStatisticsClick(View v) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }
    public void onCompeteClick(View v) {
        Intent intent = new Intent(this, CompeteActivity.class);
        startActivity(intent);
    }
    public void onFeedbackClick(View v) {
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }
}

package com.healthyu.healthyu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.healthyu.healthyu.models.ApiEndpointInterface;
import com.healthyu.healthyu.models.NetworkUtils;
import com.healthyu.healthyu.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Daniel on 4/8/17.
 */

public class StandingActivity extends Activity{


    ArrayList<User> userArray = new ArrayList<>();
    ArrayList<User> userArray2 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        ApiEndpointInterface apiService = NetworkUtils.getApiService();
        Call<List<User>> call = apiService.topActivityUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                int statuscode = response.code();
                List<User> userList = response.body();

                if(statuscode == 200) {
                    for(User user: userList) {
                        userArray.add(user);
                    }
                    ListView ll = (ListView)findViewById(R.id.activityList);
                    ActivityAdapter aa = new ActivityAdapter();
                    ll.setAdapter(aa);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

        Call<List<User>> call2 = apiService.topCaloriesUsers();
        call2.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                int statuscode = response.code();
                List<User> userList = response.body();

                if(statuscode == 200) {
                    for(User user: userList) {
                        userArray2.add(user);
                    }
                    ListView ll = (ListView)findViewById(R.id.calorieList);
                    CaloriesAdapter aa = new CaloriesAdapter();
                    ll.setAdapter(aa);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }


    public class ActivityAdapter extends BaseAdapter {

        LayoutInflater mInflater;


        public ActivityAdapter() {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return userArray.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewHolder vh;
            vh = new ViewHolder();

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_element, parent, false);
                vh.rank = (TextView) convertView.findViewById(R.id.rankTV);
                vh.id = (TextView) convertView.findViewById(R.id.idTV);
                vh.name = (TextView) convertView.findViewById(R.id.nameTV);
                vh.activity = (TextView) convertView.findViewById(R.id.dataTV);

                //inflate custom layour

            } else {
                convertView.setTag(vh);
                vh.rank = (TextView) convertView.findViewById(R.id.rankTV);
                vh.id = (TextView) convertView.findViewById(R.id.idTV);
                vh.name = (TextView) convertView.findViewById(R.id.nameTV);
                vh.activity = (TextView) convertView.findViewById(R.id.dataTV);

            }

            vh.rank.setText(String.valueOf(position+1));
            vh.id.setText(String.valueOf(userArray.get(position).getUserId()));
            vh.name.setText(String.valueOf(userArray.get(position).getFriendlyName()));
            vh.activity.setText(String.valueOf(userArray.get(position).getTopCalories()));

            return convertView;
        }

        class ViewHolder {
            TextView rank, id, name, activity;
        }
    }

    public class CaloriesAdapter extends BaseAdapter {

        LayoutInflater mInflater;


        public CaloriesAdapter() {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return userArray2.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewHolder vh;
            vh = new ViewHolder();

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_element, parent, false);
                vh.rank = (TextView) convertView.findViewById(R.id.rankTV);
                vh.id = (TextView) convertView.findViewById(R.id.idTV);
                vh.name = (TextView) convertView.findViewById(R.id.nameTV);
                vh.activity = (TextView) convertView.findViewById(R.id.dataTV);

                //inflate custom layour

            } else {
                convertView.setTag(vh);
                vh.rank = (TextView) convertView.findViewById(R.id.rankTV);
                vh.id = (TextView) convertView.findViewById(R.id.idTV);
                vh.name = (TextView) convertView.findViewById(R.id.nameTV);
                vh.activity = (TextView) convertView.findViewById(R.id.dataTV);

            }

            vh.rank.setText(String.valueOf(position+1));
            vh.id.setText(String.valueOf(userArray.get(position).getUserId()));
            vh.name.setText(String.valueOf(userArray.get(position).getFriendlyName()));
            vh.activity.setText(String.valueOf(userArray.get(position).getTopActivity()));

            return convertView;
        }

        class ViewHolder {
            TextView rank, id, name, activity;
        }
    }
}

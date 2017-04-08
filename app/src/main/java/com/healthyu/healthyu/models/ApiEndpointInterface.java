package com.healthyu.healthyu.models;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Daniel on 4/8/17.
 */

public interface ApiEndpointInterface {

    @GET("allUsers")
    Call<List<User>> allUsers();

    @GET("user/{userid}")
    Call<User> getUser(@Path("userid") String userid);

    @GET("TopActivityUsers")
    Call<List<User>> topActivityUsers();

    @GET("TopCaloriesUsers")
    Call<List<User>> topCaloriesUsers();

    @POST("user")
    Call<ResponseBody> posrUser(@Body User user);


}

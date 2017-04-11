package com.healthyu.healthyu.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel on 4/8/17.
 */

public class NetworkUtils {

    public static final String BASE_URL = "http://healthyucompete20170318122657.azurewebsites.net/api/";

    public static ApiEndpointInterface getApiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging).followRedirects(false).followSslRedirects(false)
                .build();
        // add logging as last interceptor
        // <-- this is the important line!
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        ApiEndpointInterface apiService =
                retrofit.create(ApiEndpointInterface.class);

        return apiService;
    }

}

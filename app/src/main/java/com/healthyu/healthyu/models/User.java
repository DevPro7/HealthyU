package com.healthyu.healthyu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("friendly_name")
    @Expose
    private String friendlyName;
    @SerializedName("topActivity")
    @Expose
    private Integer topActivity;
    @SerializedName("topCalories")
    @Expose
    private Integer topCalories;
    @SerializedName("userId")
    @Expose
    private Integer userId;

    public User(String username, Integer activity, Integer calories, Integer id) {
        this.friendlyName = username;
        this.topActivity = activity;
        this.topCalories = calories;
        this.userId = id;
    }
    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public Integer getTopActivity() {
        return topActivity;
    }

    public void setTopActivity(Integer topActivity) {
        this.topActivity = topActivity;
    }

    public Integer getTopCalories() {
        return topCalories;
    }

    public void setTopCalories(Integer topCalories) {
        this.topCalories = topCalories;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
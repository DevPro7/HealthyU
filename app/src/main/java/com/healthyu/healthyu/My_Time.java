package com.healthyu.healthyu;

import java.util.Calendar;

/**
 * Created by Marina on 4/1/2017.
 */

public class My_Time {

    public static String date_time  (){
        Calendar rightNow = Calendar.getInstance();
        String time;
        int x=rightNow.get(Calendar.AM_PM);

        if(x==0)
            time=" AM";
            else
            time=" PM";

         return  rightNow.get(Calendar.MONTH)+"/"+rightNow.get(Calendar.DAY_OF_MONTH) +" " + rightNow.get(Calendar.HOUR_OF_DAY)+ ":"+ rightNow.get(Calendar.MINUTE)+ time ;
        }


}

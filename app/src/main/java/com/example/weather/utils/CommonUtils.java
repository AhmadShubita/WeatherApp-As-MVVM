package com.example.weather.utils;



import java.text.SimpleDateFormat;
import java.util.Date;



public final class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }


    public static String setDateText(long time) {
        Date date=new Date(time);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        return df2.format(date);

    }


}

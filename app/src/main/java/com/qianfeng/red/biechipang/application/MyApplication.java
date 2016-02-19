package com.qianfeng.red.biechipang.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by perbo on 2015-12-07.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
       context = getApplicationContext();
    }
    public static Context getContext(){

        return  context;
    }
}

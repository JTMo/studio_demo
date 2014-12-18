package com.example.myapplication.manager;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by new on 2014/12/18.
 */
public class BaseApplication extends Application {

    private static BaseApplication mInstance;
    private static List<Activity> activities=new ArrayList<Activity>();

    public List<Activity> getActivities(){
        return activities;
    }

    public static void addActivity(Activity a){
        activities.add(a);
    }

    public static void exit(){
        for(Activity a:activities){
                a.finish();
        }
    }

    @Override
    public void onCreate() {
        //TODO imageload初始化
        mInstance=this;
        super.onCreate();
    }


    public static BaseApplication getApplication(){
        return mInstance;
    }
}

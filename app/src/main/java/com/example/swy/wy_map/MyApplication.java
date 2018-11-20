package com.example.swy.wy_map;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.swy.wy_map.dao.GreenDaoManager;
import com.example.swy.wy_map.greendao.gen.DaoMaster;
import com.example.swy.wy_map.greendao.gen.DaoSession;

/**
 * Created by swy on 2018/11/6.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }
}
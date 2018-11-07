package com.example.swy.wy_map.dao;

import com.example.swy.wy_map.Entity.MyLocation;
import com.example.swy.wy_map.MyApplication;

/**
 * Created by swy on 2018/11/6.
 */

public class SaveLocation {
    public static void insertLocation(MyLocation myLocation) {
        MyApplication.getDaoSession().getMyLocationDao().insert(myLocation);
    }

}

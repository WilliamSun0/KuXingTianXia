package com.example.swy.wy_map.dao;

import com.example.swy.wy_map.Entity.MyLocation;
import com.example.swy.wy_map.Entity.Route;
import com.example.swy.wy_map.MyApplication;

import java.util.Date;

/**
 * Created by swy on 2018/11/7.
 */

public class SaveRoute {
    public static void insertRoute(Route route) {

        MyApplication.getDaoSession().getRouteDao().insert(route);
    }
}

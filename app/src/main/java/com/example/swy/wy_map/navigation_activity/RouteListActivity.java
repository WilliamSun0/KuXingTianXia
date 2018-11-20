package com.example.swy.wy_map.navigation_activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.swy.wy_map.R;
import com.example.swy.wy_map.adpter.RouteListAdapter;
import com.example.swy.wy_map.dao.GreenDaoManager;
import com.example.swy.wy_map.entity.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swy on 2018/11/19.
 */

public class RouteListActivity extends Activity {

    private RouteListAdapter routeListAdapter;
    private List<Route> mRouteList = new ArrayList<>();
    private ListView mRouteLv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_container);
        initData();
    }


    private void initData() {
        mRouteLv = findViewById(R.id.lv_route);
        mRouteList = GreenDaoManager.getInstance().getSession().getRouteDao().queryBuilder().build().list();
        routeListAdapter = new RouteListAdapter(this, mRouteList);
        mRouteLv.setAdapter(routeListAdapter);
    }

}

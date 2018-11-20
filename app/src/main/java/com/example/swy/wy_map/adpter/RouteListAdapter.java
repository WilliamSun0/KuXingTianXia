package com.example.swy.wy_map.adpter;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.swy.wy_map.R;
import com.example.swy.wy_map.entity.Route;

import java.util.List;

/**
 * Created by swy on 2018/11/19.
 */

public class RouteListAdapter extends BaseAdapter {

    private List<Route> mUserList;
    private Context mContext;

    public RouteListAdapter(Context mContext, List<Route> mUserList) {
        this.mUserList = mUserList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mUserList == null ? 0 : mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.items_tour_list, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_id = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_starttime = (TextView) convertView.findViewById(R.id.tv_starttime);
            viewHolder.tv_endtime = (TextView) convertView.findViewById(R.id.tv_endtime);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Route route = mUserList.get(position);

        viewHolder.tv_id.setText(String.valueOf(route.getRouteId()));
        viewHolder.tv_title.setText(route.getRouteTitle());
        Log.i("insertstaff: 3",route.getRouteTitle());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        viewHolder.tv_starttime.setText(df.format(route.getStartTime()));
        viewHolder.tv_endtime.setText(df.format(route.getEndTime()));


        return convertView;
    }

    class ViewHolder {
        TextView tv_id;
        TextView tv_title;
        TextView tv_starttime;
        TextView tv_endtime;

    }
}

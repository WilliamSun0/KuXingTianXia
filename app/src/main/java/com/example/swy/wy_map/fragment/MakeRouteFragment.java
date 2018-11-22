package com.example.swy.wy_map.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amap.api.services.share.ShareSearch;
import com.example.swy.wy_map.MyApplication;
import com.example.swy.wy_map.R;
import com.example.swy.wy_map.ShowMapActivity;
import com.example.swy.wy_map.service.LocationService;

/**
 * Created by swy on 2018/11/16.
 */

public class MakeRouteFragment extends Fragment {



    private Button cancelRouteButton;

    private Button startRouteButton;
    private EditText routeTitleET;

    private FloatingActionButton pauseButton;
    private FloatingActionButton endButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_route_fragment, container, false);
        cancelRouteButton = view.findViewById(R.id.cancel_route);
        startRouteButton = view.findViewById(R.id.confirm_route);
        routeTitleET = view.findViewById(R.id.route_title);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        cancelRouteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();

                ShowMapActivity activity = (ShowMapActivity)getActivity();

                activity.riseFabStart();
            }
        });
        startRouteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowMapActivity activity = (ShowMapActivity)getActivity();

                Toast.makeText(MyApplication.getContext(),routeTitleET.getText().toString() , Toast.LENGTH_SHORT).show();

                Log.d("swy",routeTitleET.getText().toString());

                activity.startReportRoute(routeTitleET.getText().toString());

                getFragmentManager().popBackStack();


            }
        });


    }
}

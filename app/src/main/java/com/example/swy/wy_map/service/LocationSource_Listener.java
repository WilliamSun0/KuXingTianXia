package com.example.swy.wy_map.service;

import android.annotation.TargetApi;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;

import java.util.Date;

/**
 * Created by swy on 2018/11/7.
 * 主界面定位源和监听
 */

public class LocationSource_Listener implements LocationSource,AMapLocationListener {

    private AMap aMap;

    public static AMapLocationClient mLocationClient = null;
    public static AMapLocationClientOption mLocationOption = null;

    private LocationSource.OnLocationChangedListener mListener;


    private static boolean isFirstLocation = true;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        // 解析AMapLocation对象
        // 判断AMapLocation对象不为空，当定位错误码类型为0时定位成功
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                aMapLocation.getLocationType(); // 获取当前定位结果来源，如网络定位结果，详见定位类型表
                aMapLocation.getLatitude(); // 获取纬度
                aMapLocation.getLongitude(); // 获取经度
                aMapLocation.getAccuracy(); // 获取精度信息
                aMapLocation.getAddress(); // 地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry(); // 国家信息
                aMapLocation.getProvince(); // 省信息
                aMapLocation.getCity(); // 城市信息
                aMapLocation.getDistrict(); // 城区信息
                aMapLocation.getStreet(); // 街道信息
                aMapLocation.getStreetNum(); // 街道门牌号信息
                aMapLocation.getCityCode(); // 城市编码
                aMapLocation.getAdCode(); // 地区编码
                aMapLocation.getAoiName(); // 获取当前定位点的AOI信息
                aMapLocation.getBuildingId(); // 获取当前室内定位的建筑物Id
                aMapLocation.getFloor(); // 获取当前室内定位的楼层
                aMapLocation.getGpsAccuracyStatus(); // 获取GPS的当前状态
                // 获取定位时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);

                Log.d("swy", "onLocationChanged: "+aMapLocation.getLocationType()+aMapLocation.getDistrict()+aMapLocation.getProvince());
                // 如果不设置标志位，拖动地图时，它会不断将地图移动到当前的位置

                if (isFirstLocation) {
                    // 设置缩放级别
                    aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
                    // 将地图移动到定位点
                    aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
                    // 点击定位按钮 能够将地图的中心移动到定位点
                    mListener.onLocationChanged(aMapLocation);
                    isFirstLocation = false;
                }
            } else {
                // 定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e("HLQ_Struggle", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {
        mListener = null;
    }
}

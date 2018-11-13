package com.example.swy.wy_map.Service;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.swy.wy_map.Entity.MyLocation;
import com.example.swy.wy_map.Entity.Route;
import com.example.swy.wy_map.dao.SaveLocation;
import com.example.swy.wy_map.dao.SaveRoute;

import java.util.Date;

/**
 * 包名： com.amap.locationservicedemo
 * <p>
 * 创建时间：2016/10/27
 * 项目名称：LocationServiceDemo
 *
 * @author guibao.ggb
 * @email guibao.ggb@alibaba-inc.com
 * <p>
 * 类说明：后台服务定位
 *
 * <p>
 *     modeified by liangchao , on 2017/01/17
 *     update:
 *     1. 只有在由息屏造成的网络断开造成的定位失败时才点亮屏幕
 *     2. 利用notification机制增加进程优先级
 * </p>
 */
public class LocationService extends Service {

    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;


    private Long locationId;

    //坐标发生的时间
    private Date pointTime;

    //属于那条路线的编号

    private Long routeId;

    //@ToOne(joinProperty = "route") //这个是注解绑定 hid就是上面一行的hid
    //照片地址
    private String pictureId;
    //文本
    private String note;

    private int LocationType; // 获取当前定位结果来源，如网络定位结果，详见定位类型表
    private           double Latitude; // 获取纬度
    private           double Longitude; // 获取经度
    private double Altitude;
    private           float Accuracy; // 获取精度信息
    private           String Address; // 地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
    private            String Country; // 国家信息
    private            String Province; // 省信息
    private            String City; // 城市信息
    private           String District; // 城区信息
    private          String Street; // 街道信息
    private            String StreetNum; // 街道门牌号信息
    private           String CityCode; // 城市编码
    private          String AdCode; // 地区编码
    private          String AoiName; // 获取当前定位点的AOI信息
    private          String BuildingId; // 获取当前室内定位的建筑物Id

    private          int GpsAccuracyStatus; // 获取GPS的当前状态
    /**
     * 处理息屏关掉wifi的delegate类
     */
    private IWifiAutoCloseDelegate mWifiAutoCloseDelegate = new WifiAutoCloseDelegate();

    /**
     * 记录是否需要对息屏关掉wifi的情况进行处理
     */
    private boolean mIsWifiCloseable = false;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        //applyNotiKeepMech(); //开启利用notification提高进程优先级的机制

        Log.i("swy", "onStartCommand: ");

        if (mWifiAutoCloseDelegate.isUseful(getApplicationContext())) {
            mIsWifiCloseable = true;
            mWifiAutoCloseDelegate.initOnServiceStarted(getApplicationContext());
        }

        startLocation();

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        //unApplyNotiKeepMech();
        stopLocation();

        Log.i("swy", "onDestroy: ");

        super.onDestroy();
    }

    /**
     * 启动定位
     */
    void startLocation() {
        stopLocation();

        if (null == mLocationClient) {
            mLocationClient = new AMapLocationClient(this.getApplicationContext());
        }

        mLocationOption = new AMapLocationClientOption();
        // 使用连续
        mLocationOption.setOnceLocation(false);
        mLocationOption.setLocationCacheEnable(false);
        // 每10秒定位一次
        mLocationOption.setInterval(10 * 1000);
        // 地址信息
        mLocationOption.setNeedAddress(true);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.setLocationListener(locationListener);
        mLocationClient.startLocation();
    }

    /**
     * 停止定位
     */
    void stopLocation() {
        if (null != mLocationClient) {
            mLocationClient.stopLocation();
        }
    }

    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            //发送结果的通知
            // 解析AMapLocation对象
            // 判断AMapLocation对象不为空，当定位错误码类型为0时定位成功
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {

                    LocationType = aMapLocation.getLocationType(); // 获取当前定位结果来源，如网络定位结果，详见定位类型表
                    Latitude = aMapLocation.getLatitude(); // 获取纬度
                    Longitude = aMapLocation.getLongitude(); // 获取经度
                    Altitude = aMapLocation.getAltitude();//海拔
                    Accuracy = aMapLocation.getAccuracy(); // 获取精度信息
                    Address = aMapLocation.getAddress(); // 地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    Country = aMapLocation.getCountry(); // 国家信息
                    Province = aMapLocation.getProvince(); // 省信息
                    City = aMapLocation.getCity(); // 城市信息
                    District = aMapLocation.getDistrict(); // 城区信息
                    Street = aMapLocation.getStreet(); // 街道信息
                    StreetNum = aMapLocation.getStreetNum(); // 街道门牌号信息
                    CityCode = aMapLocation.getCityCode(); // 城市编码
                    AdCode = aMapLocation.getAdCode(); // 地区编码
                    AoiName = aMapLocation.getAoiName(); // 获取当前定位点的AOI信息
                    BuildingId = aMapLocation.getBuildingId(); // 获取当前室内定位的建筑物Id

                    GpsAccuracyStatus = aMapLocation.getGpsAccuracyStatus(); // 获取GPS的当前状态
                    // 获取定位时间
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(aMapLocation.getTime());
                    df.format(date);
                    // 如果不设置标志位，拖动地图时，它会不断将地图移动到当前的位置


                    Route route = new Route(null,date,null,null);
                    SaveRoute.insertRoute(route);
                    MyLocation myLocation = new MyLocation(null,date,
route.getRouteId(),null,null,
                            LocationType,
                    Latitude,
                    Longitude,
                    Altitude,
                    Accuracy,
                    Address,
                    Country,
                    Province,
                    City,
                    District,
                    Street,
                    StreetNum,
                    CityCode ,
                    AdCode ,
                    AoiName,
                    BuildingId,

                    GpsAccuracyStatus);
                    SaveLocation.insertLocation(myLocation);


                } else {
                    // 定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("HLQ_Struggle", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }


            if (!mIsWifiCloseable) {
                return;
            }

            if (aMapLocation.getErrorCode() == AMapLocation.LOCATION_SUCCESS) {
                mWifiAutoCloseDelegate.onLocateSuccess(getApplicationContext(), PowerManagerUtil.getInstance().isScreenOn(getApplicationContext()), NetUtil.getInstance().isMobileAva(getApplicationContext()));
            } else {
                mWifiAutoCloseDelegate.onLocateFail(getApplicationContext() , aMapLocation.getErrorCode() , PowerManagerUtil.getInstance().isScreenOn(getApplicationContext()), NetUtil.getInstance().isWifiCon(getApplicationContext()));
            }

        }


    };



    public LocationServiceBinder mBinder;

    public class LocationServiceBinder extends Binder{
        public void onFinishBind(){
        }

        public void pauseLocate(){
            Log.d("ServiceTest","  ----->  getString");

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (mBinder == null) {
            mBinder = new LocationServiceBinder();
        }
        return mBinder;
    }



}

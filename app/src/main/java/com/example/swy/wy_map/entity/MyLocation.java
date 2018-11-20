package com.example.swy.wy_map.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Date;

/**
 * Created by swy on 2018/11/6.
 */

//位置信息表
@Entity
public class MyLocation {

    //主键
    @Id(autoincrement = true)
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

    @Generated(hash = 133712773)
    public MyLocation(Long locationId, Date pointTime, Long routeId, String pictureId, String note,
            int LocationType, double Latitude, double Longitude, double Altitude, float Accuracy, String Address,
            String Country, String Province, String City, String District, String Street, String StreetNum,
            String CityCode, String AdCode, String AoiName, String BuildingId, int GpsAccuracyStatus) {
        this.locationId = locationId;
        this.pointTime = pointTime;
        this.routeId = routeId;
        this.pictureId = pictureId;
        this.note = note;
        this.LocationType = LocationType;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Altitude = Altitude;
        this.Accuracy = Accuracy;
        this.Address = Address;
        this.Country = Country;
        this.Province = Province;
        this.City = City;
        this.District = District;
        this.Street = Street;
        this.StreetNum = StreetNum;
        this.CityCode = CityCode;
        this.AdCode = AdCode;
        this.AoiName = AoiName;
        this.BuildingId = BuildingId;
        this.GpsAccuracyStatus = GpsAccuracyStatus;
    }

    @Generated(hash = 1702583037)
    public MyLocation() {
    }

    public Long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Date getPointTime() {
        return this.pointTime;
    }

    public void setPointTime(Date pointTime) {
        this.pointTime = pointTime;
    }

    public Long getRouteId() {
        return this.routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getLocationType() {
        return this.LocationType;
    }

    public void setLocationType(int LocationType) {
        this.LocationType = LocationType;
    }

    public double getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public double getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public double getAltitude() {
        return this.Altitude;
    }

    public void setAltitude(double Altitude) {
        this.Altitude = Altitude;
    }

    public float getAccuracy() {
        return this.Accuracy;
    }

    public void setAccuracy(float Accuracy) {
        this.Accuracy = Accuracy;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCountry() {
        return this.Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getProvince() {
        return this.Province;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getDistrict() {
        return this.District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getStreet() {
        return this.Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getStreetNum() {
        return this.StreetNum;
    }

    public void setStreetNum(String StreetNum) {
        this.StreetNum = StreetNum;
    }

    public String getCityCode() {
        return this.CityCode;
    }

    public void setCityCode(String CityCode) {
        this.CityCode = CityCode;
    }

    public String getAdCode() {
        return this.AdCode;
    }

    public void setAdCode(String AdCode) {
        this.AdCode = AdCode;
    }

    public String getAoiName() {
        return this.AoiName;
    }

    public void setAoiName(String AoiName) {
        this.AoiName = AoiName;
    }

    public String getBuildingId() {
        return this.BuildingId;
    }

    public void setBuildingId(String BuildingId) {
        this.BuildingId = BuildingId;
    }

    public int getGpsAccuracyStatus() {
        return this.GpsAccuracyStatus;
    }

    public void setGpsAccuracyStatus(int GpsAccuracyStatus) {
        this.GpsAccuracyStatus = GpsAccuracyStatus;
    }



}

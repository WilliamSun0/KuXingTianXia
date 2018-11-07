package com.example.swy.wy_map.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by swy on 2018/11/6.
 */
@Entity
public class Route {
    //主键
    @Id(autoincrement = true)
    private Long routeId;


    private Date startTime;
    private Date endTime;

    private String routeTitle;

    @Generated(hash = 1008230227)
    public Route(Long routeId, Date startTime, Date endTime, String routeTitle) {
        this.routeId = routeId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.routeTitle = routeTitle;
    }

    @Generated(hash = 467763370)
    public Route() {
    }

    public Long getRouteId() {
        return this.routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRouteTitle() {
        return this.routeTitle;
    }

    public void setRouteTitle(String routeTitle) {
        this.routeTitle = routeTitle;
    }

//    @ToMany(referencedJoinProperty = "routeId") //指定目标实体的外键
//    @OrderBy("date ASC")
//    private List<MyLocation> locations; //目标实体的List

}

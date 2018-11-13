package com.example.swy.wy_map.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.DaoException;
import com.example.swy.wy_map.greendao.gen.DaoSession;
import com.example.swy.wy_map.greendao.gen.MyLocationDao;
import com.example.swy.wy_map.greendao.gen.RouteDao;

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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1028127557)
    public List<MyLocation> getLocationList() {
        if (locationList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MyLocationDao targetDao = daoSession.getMyLocationDao();
            List<MyLocation> locationListNew = targetDao
                    ._queryRoute_LocationList(routeId);
            synchronized (this) {
                if (locationList == null) {
                    locationList = locationListNew;
                }
            }
        }
        return locationList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 919672128)
    public synchronized void resetLocationList() {
        locationList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1333897230)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRouteDao() : null;
    }

    @ToMany(referencedJoinProperty = "routeId") //指定目标实体的外键
    @OrderBy("pointTime ASC")
    private List<MyLocation> locationList; //目标实体的List


    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;


    /** Used for active entity operations. */
    @Generated(hash = 1511175683)
    private transient RouteDao myDao;

}

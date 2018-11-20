package com.example.swy.wy_map.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.swy.wy_map.entity.Route;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ROUTE".
*/
public class RouteDao extends AbstractDao<Route, Long> {

    public static final String TABLENAME = "ROUTE";

    /**
     * Properties of entity Route.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property RouteId = new Property(0, Long.class, "routeId", true, "_id");
        public final static Property StartTime = new Property(1, java.util.Date.class, "startTime", false, "START_TIME");
        public final static Property EndTime = new Property(2, java.util.Date.class, "endTime", false, "END_TIME");
        public final static Property RouteTitle = new Property(3, String.class, "routeTitle", false, "ROUTE_TITLE");
    }

    private DaoSession daoSession;


    public RouteDao(DaoConfig config) {
        super(config);
    }
    
    public RouteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ROUTE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: routeId
                "\"START_TIME\" INTEGER," + // 1: startTime
                "\"END_TIME\" INTEGER," + // 2: endTime
                "\"ROUTE_TITLE\" TEXT);"); // 3: routeTitle
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ROUTE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Route entity) {
        stmt.clearBindings();
 
        Long routeId = entity.getRouteId();
        if (routeId != null) {
            stmt.bindLong(1, routeId);
        }
 
        java.util.Date startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindLong(2, startTime.getTime());
        }
 
        java.util.Date endTime = entity.getEndTime();
        if (endTime != null) {
            stmt.bindLong(3, endTime.getTime());
        }
 
        String routeTitle = entity.getRouteTitle();
        if (routeTitle != null) {
            stmt.bindString(4, routeTitle);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Route entity) {
        stmt.clearBindings();
 
        Long routeId = entity.getRouteId();
        if (routeId != null) {
            stmt.bindLong(1, routeId);
        }
 
        java.util.Date startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindLong(2, startTime.getTime());
        }
 
        java.util.Date endTime = entity.getEndTime();
        if (endTime != null) {
            stmt.bindLong(3, endTime.getTime());
        }
 
        String routeTitle = entity.getRouteTitle();
        if (routeTitle != null) {
            stmt.bindString(4, routeTitle);
        }
    }

    @Override
    protected final void attachEntity(Route entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Route readEntity(Cursor cursor, int offset) {
        Route entity = new Route( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // routeId
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // startTime
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // endTime
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // routeTitle
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Route entity, int offset) {
        entity.setRouteId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStartTime(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setEndTime(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setRouteTitle(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Route entity, long rowId) {
        entity.setRouteId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Route entity) {
        if(entity != null) {
            return entity.getRouteId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Route entity) {
        return entity.getRouteId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}

package com.example.kazanm1.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "welllayers")
public class WellLayerEntity {
    @PrimaryKey(autoGenerate = true)
    private long ID;
    private long WellID;
    private long RockTypeID;
    private long StartPoint;
    private long EndPoint;

    public WellLayerEntity(long ID, long WellID, long RockTypeID, long StartPoint, long EndPoint) {
        this.ID = ID;
        this.WellID = WellID;
        this.RockTypeID = RockTypeID;
        this.StartPoint = StartPoint;
        this.EndPoint = EndPoint;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getWellID() {
        return WellID;
    }

    public void setWellID(long wellID) {
        WellID = wellID;
    }

    public long getRockTypeID() {
        return RockTypeID;
    }

    public void setRockTypeID(long rockTypeID) {
        RockTypeID = rockTypeID;
    }

    public long getStartPoint() {
        return StartPoint;
    }

    public void setStartPoint(long startPoint) {
        StartPoint = startPoint;
    }

    public long getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(long endPoint) {
        EndPoint = endPoint;
    }
}

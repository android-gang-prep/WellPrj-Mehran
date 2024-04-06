package com.example.kazanm1.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wells")
public class WellEntity {
    @PrimaryKey(autoGenerate = true)
    private long ID;
    private long WellTypeID;
    private String WellName;
    private long GasOilDepth;
    private long Capacity;

    public WellEntity(long ID, long WellTypeID, String WellName, long GasOilDepth, long Capacity) {
        this.ID = ID;
        this.WellTypeID = WellTypeID;
        this.WellName = WellName;
        this.GasOilDepth = GasOilDepth;
        this.Capacity = Capacity;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getWellTypeID() {
        return WellTypeID;
    }

    public void setWellTypeID(long wellTypeID) {
        WellTypeID = wellTypeID;
    }

    public String getWellName() {
        return WellName;
    }

    public void setWellName(String wellName) {
        WellName = wellName;
    }

    public long getGasOilDepth() {
        return GasOilDepth;
    }

    public void setGasOilDepth(long gasOilDepth) {
        GasOilDepth = gasOilDepth;
    }

    public long getCapacity() {
        return Capacity;
    }

    public void setCapacity(long capacity) {
        Capacity = capacity;
    }
}

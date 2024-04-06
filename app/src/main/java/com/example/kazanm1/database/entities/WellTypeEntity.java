package com.example.kazanm1.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "welltypes")
public class WellTypeEntity {
    @PrimaryKey(autoGenerate = true)
    private long ID;

    private String Name;

    public WellTypeEntity(long ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

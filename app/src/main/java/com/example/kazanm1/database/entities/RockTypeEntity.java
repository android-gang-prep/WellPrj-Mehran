package com.example.kazanm1.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rocktypes")
public class RockTypeEntity {
    @PrimaryKey(autoGenerate = true)
    private long ID;
    private String Name;
    private String BackgroundColor;

    public RockTypeEntity(long ID, String Name, String BackgroundColor) {
        this.ID = ID;
        this.Name = Name;
        this.BackgroundColor = BackgroundColor;
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

    public String getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        BackgroundColor = backgroundColor;
    }
}

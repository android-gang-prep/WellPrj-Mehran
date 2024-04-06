package com.example.kazanm1.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.database.entities.WellTypeEntity;

@Dao
public interface WellTypeDao {
    @Insert
    void insert(WellTypeEntity... wellType);
}

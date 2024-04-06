package com.example.kazanm1.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.models.WellModel;

import java.util.List;

@Dao
public interface RockTypeDao {
    @Insert
    void insert(RockTypeEntity... rockType);

    @Query("SELECT * From rocktypes")
    LiveData<List<RockTypeEntity>> getRocks();
}

package com.example.kazanm1.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kazanm1.database.entities.WellEntity;
import com.example.kazanm1.models.WellModel;

import java.util.List;

@Dao
public interface WellDao {
    @Insert
    long[] insertWell(WellEntity... well);
    @Insert
    long insert(WellEntity well);
    @Update
    void updateWell(WellEntity well);


    @Query("SELECT * From wells")
    LiveData<List<WellModel>> getWells();
    @Query("SELECT * From wells where ID=:id")
    LiveData<WellModel> getWell(long id);
}

package com.example.kazanm1.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kazanm1.database.entities.WellEntity;
import com.example.kazanm1.database.entities.WellLayerEntity;
import com.example.kazanm1.models.WellModel;

import java.util.List;

@Dao
public interface WellLayerDao {
    @Insert
    long[] insertWell(WellLayerEntity... well);

    @Delete
    void deleteWell(WellLayerEntity well);

    @Query("DELETE FROM welllayers where WellID=:id")
    void delete(long id);
}

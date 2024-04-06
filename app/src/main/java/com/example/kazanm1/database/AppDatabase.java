package com.example.kazanm1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.kazanm1.database.dao.RockTypeDao;
import com.example.kazanm1.database.dao.WellDao;
import com.example.kazanm1.database.dao.WellLayerDao;
import com.example.kazanm1.database.dao.WellTypeDao;
import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.database.entities.WellEntity;
import com.example.kazanm1.database.entities.WellLayerEntity;
import com.example.kazanm1.database.entities.WellTypeEntity;

@Database(entities = {RockTypeEntity.class, WellEntity.class, WellLayerEntity.class, WellTypeEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract WellDao wellDao();

    public abstract WellLayerDao wellLayerDao();

    public abstract RockTypeDao rockTypeDao();

    public abstract WellTypeDao wellTypeDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "dataweel").allowMainThreadQueries().build();

        return appDatabase;
    }


}

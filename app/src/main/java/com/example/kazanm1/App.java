package com.example.kazanm1;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.kazanm1.database.AppDatabase;
import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.database.entities.WellEntity;
import com.example.kazanm1.database.entities.WellLayerEntity;
import com.example.kazanm1.database.entities.WellTypeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sharedPreferences = getSharedPreferences("DataApp", 0);
        if (sharedPreferences.getBoolean("first", true)) {
            Executors.newSingleThreadExecutor().submit(() -> {
                AppDatabase.getAppDatabase(getApplicationContext()).rockTypeDao().insert(new RockTypeEntity(1,"Argillite","#E52B50"),new RockTypeEntity(2,"Breccia","#FFBF00"),new RockTypeEntity(3,"Chalk","#9966CC"),new RockTypeEntity(4,"Chert","#FBCEB1"),new RockTypeEntity(5,"Coal","#7FFFD4"),new RockTypeEntity(6,"Conglomerate","#007FFF"),new RockTypeEntity(7,"Dolomite","#0095B6"),new RockTypeEntity(8,"Limestone","#800020"),new RockTypeEntity(9,"Marl","#DE3163"),new RockTypeEntity(10,"Mudstone","#F7E7CE"),new RockTypeEntity(11,"Sandstone","#7FFF00"),new RockTypeEntity(12,"Shale","#C8A2C8"),new RockTypeEntity(13,"Tufa","#BFFF00"),new RockTypeEntity(14,"Wackestone","#FFFF00"));
                AppDatabase.getAppDatabase(getApplicationContext()).wellTypeDao().insert(new WellTypeEntity(1,"Well"),new WellTypeEntity(2,"Section"));
                AppDatabase.getAppDatabase(getApplicationContext()).wellDao().insertWell(new WellEntity(1,1,"Yolka #12 ",4500,980000000),new WellEntity(2,1,"Kazan  #12",4230,1080000000),new WellEntity(3,1,"Kazan  #13",4830,780000000));
                AppDatabase.getAppDatabase(getApplicationContext()).wellLayerDao().insertWell(new WellLayerEntity(1,1,10,0,800),new WellLayerEntity(2,1,3,800,1430),new WellLayerEntity(3,1,2,1430,1982),new WellLayerEntity(4,1,11,1982,2648),new WellLayerEntity(5,1,6,2648,3312),new WellLayerEntity(6,1,7,3312,3839),new WellLayerEntity(7,1,1,3839,4450),new WellLayerEntity(8,2,9,0,755),new WellLayerEntity(9,2,11,755,1523),new WellLayerEntity(10,2,3,1523,2280),new WellLayerEntity(11,2,6,2280,2916),new WellLayerEntity(12,2,10,2916,3727),new WellLayerEntity(13,2,1,3727,4230),new WellLayerEntity(14,3,10,0,808),new WellLayerEntity(15,3,5,808,1605),new WellLayerEntity(16,3,1,1605,2129),new WellLayerEntity(17,3,6,2129,2770),new WellLayerEntity(18,3,9,2770,3738),new WellLayerEntity(19,3,8,3738,4670),new WellLayerEntity(20,3,4,4670,4830));
            });
            sharedPreferences.edit().putBoolean("first", false).apply();
        }
    }
}

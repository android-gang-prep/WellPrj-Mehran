package com.example.kazanm1.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kazanm1.database.AppDatabase;
import com.example.kazanm1.models.WellModel;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    private LiveData<List<WellModel>> wells;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getAppDatabase(application);
        wells=appDatabase.wellDao().getWells();
    }

    public LiveData<List<WellModel>> getWells() {
        return wells;
    }

}

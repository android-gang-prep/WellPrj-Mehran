package com.example.kazanm1.ui.add;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kazanm1.database.AppDatabase;
import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.database.entities.WellEntity;
import com.example.kazanm1.database.entities.WellLayerEntity;
import com.example.kazanm1.models.WellLayerItem;
import com.example.kazanm1.models.WellModel;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    private LiveData<WellModel> well;
    private LiveData<List<RockTypeEntity>> rock;

    public AddViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getAppDatabase(application);
        rock = appDatabase.rockTypeDao().getRocks();
    }

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public long addWell(WellEntity well) throws ExecutionException, InterruptedException {
        if (well.getID() != 0) {
            appDatabase.wellLayerDao().delete(well.getID());
            executorService.submit(() -> appDatabase.wellDao().updateWell(well));
            return well.getID();
        }
        Callable<Long> callable = () -> appDatabase.wellDao().insert(well);

        Future<Long> future = executorService.submit(callable);

        return future.get();
    }

    public void addLayerWell(List<WellLayerItem> list, long id) {
        executorService.submit(() -> {
            WellLayerEntity[] wellLayer = new WellLayerEntity[list.size()];

            for (int i = 0; i < list.size(); i++) {
                wellLayer[i] = new WellLayerEntity(0, id, list.get(i).getRock_id(), list.get(i).getFrom(), list.get(i).getTo());
            }
            appDatabase.wellLayerDao().insertWell(wellLayer);

        });
    }


    public void init(long id) {
        well = appDatabase.wellDao().getWell(id);
    }

    public LiveData<WellModel> getWell() {
        return well;
    }

    public LiveData<List<RockTypeEntity>> getRock() {
        return rock;
    }
}

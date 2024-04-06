package com.example.kazanm1.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.kazanm1.database.entities.WellEntity;
import com.example.kazanm1.database.entities.WellLayerEntity;
import com.example.kazanm1.database.entities.WellTypeEntity;

import java.util.List;

public class WellModel {
    @Embedded
    WellEntity well;


    @Relation(parentColumn = "ID", entityColumn = "WellID", entity = WellLayerEntity.class)
    List<WellLayerModel> wellLayers;


    @Relation(parentColumn = "WellTypeID", entityColumn = "ID")
    WellTypeEntity wellType;


    public WellModel(WellEntity well, List<WellLayerModel> wellLayers, WellTypeEntity wellType) {
        this.well = well;
        this.wellLayers = wellLayers;
        this.wellType = wellType;
    }


    public WellEntity getWell() {
        return well;
    }

    public void setWell(WellEntity well) {
        this.well = well;
    }

    public List<WellLayerModel> getWellLayers() {
        return wellLayers;
    }

    public void setWellLayers(List<WellLayerModel> wellLayers) {
        this.wellLayers = wellLayers;
    }

    public WellTypeEntity getWellType() {
        return wellType;
    }

    public void setWellType(WellTypeEntity wellType) {
        this.wellType = wellType;
    }

    public String getCapacity() {
        return well.getCapacity() + " m^3";
    }
}

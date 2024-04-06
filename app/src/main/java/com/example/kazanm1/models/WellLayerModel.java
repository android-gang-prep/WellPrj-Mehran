package com.example.kazanm1.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.database.entities.WellLayerEntity;

public class WellLayerModel {
    @Embedded
    WellLayerEntity wellLayer;

    @Relation(parentColumn = "RockTypeID", entityColumn = "ID")
    RockTypeEntity rockType;

    public WellLayerEntity getWellLayer() {
        return wellLayer;
    }

    public void setWellLayer(WellLayerEntity wellLayer) {
        this.wellLayer = wellLayer;
    }

    public RockTypeEntity getRockType() {
        return rockType;
    }

    public void setRockType(RockTypeEntity rockType) {
        this.rockType = rockType;
    }
}

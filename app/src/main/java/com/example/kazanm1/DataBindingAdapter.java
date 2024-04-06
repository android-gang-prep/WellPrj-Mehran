package com.example.kazanm1;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.example.kazanm1.models.WellModel;

public class DataBindingAdapter {

    @BindingAdapter("app:chart")
    public static void setDataChart(ChartView view, WellModel model) {
        if (model!=null)
        view.setData(model);
    }
}

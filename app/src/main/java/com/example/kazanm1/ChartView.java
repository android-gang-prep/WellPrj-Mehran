package com.example.kazanm1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.models.WellLayerModel;
import com.example.kazanm1.models.WellModel;

import java.util.ArrayList;
import java.util.List;

public class ChartView extends View {
    public ChartView(Context context) {
        super(context);
        init();
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private WellModel wellModel;
    private List<Paint> paints;
    private TextPaint whiteText;
    private TextPaint blackText;
    private TextPaint grayText;
    private Paint blackPaint;


    private void init() {
        paints = new ArrayList<>();

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);


        whiteText = new TextPaint();
        whiteText.setColor(Color.WHITE);
        whiteText.setTextSize(dpToPx(16));
        whiteText.setTextAlign(Paint.Align.CENTER);

        grayText = new TextPaint();
        grayText.setColor(Color.GRAY);
        grayText.setTextSize(dpToPx(14));

        blackText = new TextPaint();
        blackText.setColor(Color.BLACK);
        blackText.setTextSize(dpToPx(16));
        blackText.setTextAlign(Paint.Align.CENTER);

    }

    public void setData(WellModel wellModel) {
        this.wellModel = wellModel;
        paints = new ArrayList<>();

        for (int i = 0; i < wellModel.getWellLayers().size(); i++) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(wellModel.getWellLayers().get(i).getRockType().getBackgroundColor()));
            paints.add(paint);
        }
        invalidate();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (wellModel == null || paints.isEmpty())
            return;

        float m1 = (float) getHeight() / (float) wellModel.getWell().getGasOilDepth();

        float last = 0;

        for (int i = 0; i < wellModel.getWellLayers().size(); i++) {
            float top = wellModel.getWellLayers().get(i).getWellLayer().getStartPoint() * m1;
            float bottom = wellModel.getWellLayers().get(i).getWellLayer().getEndPoint() * m1;
            canvas.drawRect(0, top, getWidth() - dpToPx(50), bottom, paints.get(i));
            canvas.drawText(wellModel.getWellLayers().get(i).getWellLayer().getStartPoint() + " m",getWidth() - dpToPx(45) , top, grayText);
            canvas.drawText(wellModel.getWellLayers().get(i).getRockType().getName(),(getWidth() - dpToPx(50))/2 , top+((bottom-top)/2), blackText);

            if (wellModel.getWellLayers().get(i).getWellLayer().getEndPoint() > last)
                last = wellModel.getWellLayers().get(i).getWellLayer().getEndPoint();
        }
        if (wellModel.getWell().getGasOilDepth() - last > 0) {
            float top = last * m1;
            float bottom = wellModel.getWell().getGasOilDepth() * m1;
            canvas.drawRect(0, top, getWidth() - dpToPx(50), bottom, blackText);
            canvas.drawText("Oil/Gas",(getWidth() - dpToPx(50))/2 , top+((bottom-top)/2), whiteText);
        }

    }

    private float dpToPx(float dp) {
        return dp * getResources().getDisplayMetrics().density;
    }
}

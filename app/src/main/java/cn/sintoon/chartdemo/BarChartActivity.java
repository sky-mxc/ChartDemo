package cn.sintoon.chartdemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mxc on 2017/6/14.
 * description: 柱状图
 */

public class BarChartActivity extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        barChart = new BarChart(this);
        barChart.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(barChart);

        barChart.setFitBars(true);  //自适应柱宽

        barChart.setDrawBarShadow(false);    //灰色背景
        barChart.setDrawValueAboveBar(true);
        barChart.setPinchZoom(true);        //x,y缩放

        //x axis formart
        DateXAxisValueFormatter custome = new DateXAxisValueFormatter(DateXAxisValueFormatter.TYPE_MONTH);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(custome);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(12);
        xAxis.setGranularity(1f);//间隔

        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.setEnabled(true);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        axisLeft.setValueFormatter(new PerAxisValueFormatter());
        axisLeft.setTextColor(Color.BLUE);
        axisLeft.setAxisMinimum(0.0f);      //不设置最小值会在最下端多出一节
        axisLeft.setAxisMaximum(100);

        YAxis axisRight = barChart.getAxisRight();
        axisRight.setEnabled(true);
        axisRight.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        axisRight.setValueFormatter(new PerAxisValueFormatter());
        axisRight.setTextColor(Color.BLUE);
        axisRight.setAxisMinimum(0.0f);
        axisRight.setAxisMaximum(100);

        Description description = barChart.getDescription();
        description.setText("月度覆盖图");
        description.setTextColor(Color.RED);
        description.setTextSize(8f);
        description.setTextAlign(Paint.Align.CENTER);

        List<BarEntry> vals = new ArrayList<>();
        int count = 12;
        for (int i = 0; i < count; i++) {
            float v = (float) (Math.random() * 100);    //一个柱子
            BarEntry entry = new BarEntry(i, v);
            vals.add(entry);
        }

        BarDataSet dataSet = new BarDataSet(vals, "month");
        List<IBarDataSet> dataSetList = new ArrayList<>();
        dataSetList.add(dataSet);
        //五颜六色
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        BarData data = new BarData(dataSetList);
        data.setBarWidth(0.9f);
        barChart.setData(data);

        barChart.animateY(1000);
        barChart.invalidate();


    }
}

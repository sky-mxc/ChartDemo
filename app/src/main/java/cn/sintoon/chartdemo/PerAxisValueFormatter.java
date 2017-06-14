package cn.sintoon.chartdemo;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by mxc on 2017/6/14.
 * description:
 */

public class PerAxisValueFormatter implements IAxisValueFormatter {

    private DecimalFormat format ;
    public PerAxisValueFormatter(){
        format = new DecimalFormat("0.0");
    }
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return format.format(value)+"%";
    }
}

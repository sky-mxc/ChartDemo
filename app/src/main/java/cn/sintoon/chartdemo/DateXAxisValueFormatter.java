package cn.sintoon.chartdemo;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by mxc on 2017/6/14.
 * description: 时间格式化
 */

public class DateXAxisValueFormatter implements IAxisValueFormatter {

    public static final int TYPE_YEAR = 0;
    public static final int TYPE_MONTH = 1;
    public static final int TYPE_WEEK = 2;
    private int currentType = TYPE_YEAR;

    public DateXAxisValueFormatter(int type){
        currentType = type;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        String str = (int)value+"年";
        switch (currentType){
            case TYPE_WEEK:
                str = (int)value+"周";
                break;
            case TYPE_MONTH:
                str = (int)value+"月";
                break;
        }
        return str;
    }
}

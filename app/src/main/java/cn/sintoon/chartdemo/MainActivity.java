package cn.sintoon.chartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_bar_chart, R.id.main_pie_chart, R.id.main_line_chart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_bar_chart:
                Intent intent = new Intent(this,BarChartActivity.class);
                startActivity(intent);
                break;
            case R.id.main_pie_chart:
                break;
            case R.id.main_line_chart:
                break;
        }
    }
}

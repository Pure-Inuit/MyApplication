package com.pureinuit.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class View extends AppCompatActivity implements android.view.View.OnClickListener {

    private CheckBox footballChx;
    private CheckBox basketballChx;
    private CheckBox volleyballChx;
    private Switch switchForTest;
    private LinearLayout testLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent intentForString =getIntent();
        String stringFromPrevious = intentForString.getStringExtra("extra_data");
        Button GoToAlert = (Button) findViewById(R.id.GoToAlert);
        GoToAlert.setOnClickListener(this);

        //初始化switch组件
        //通过findViewById获得switch对象
        switchForTest = (Switch) findViewById(R.id.SwitchForTest);
        testLayout = (LinearLayout) findViewById(R.id.testLayout);
        //为switch组件添加事件监听器
        switchForTest.setOnCheckedChangeListener(listenerForBox);
        //初始化CheckBox组件
        // 通过findViewById获得CheckBox对象
        footballChx = (CheckBox) findViewById(R.id.footballChx);
        basketballChx = (CheckBox) findViewById(R.id.basketballChx);
        volleyballChx = (CheckBox) findViewById(R.id.volleyballChx);
        //注册事件监听器 ③
        footballChx.setOnCheckedChangeListener(listenerForBox);
        basketballChx.setOnCheckedChangeListener(listenerForBox);
        volleyballChx.setOnCheckedChangeListener(listenerForBox);
    }
    private OnCheckedChangeListener listenerForBox = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.SwitchForTest:
                    if (isChecked) {
                        // 设置LinearLayout垂直布局
                        testLayout.setOrientation(LinearLayout.VERTICAL);
                        switchForTest.setChecked(true);
                    } else {
                        // 设置LinearLayout水平布局
                        testLayout.setOrientation(LinearLayout.HORIZONTAL);
                        switchForTest.setChecked(false);
                    }
                    break;
                //选择足球
                case R.id.footballChx:
                    if (isChecked) {
                        //Toast的使用⑤
                        Toast.makeText(View.this, "你喜欢足球", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.basketballChx:
                    //选择篮球
                    if (isChecked) {
                        Toast.makeText(View.this, "你喜欢篮球",Toast.LENGTH_LONG).show();
                    }
                case R.id.volleyballChx:
                    //选择排球
                    if (isChecked) {
                        Toast.makeText(View.this, "你喜欢排球",Toast.LENGTH_LONG).show();
                    }
                default:
                    break;
            }
        }
    };


    @Override
    public void onClick(android.view.View view) {
        switch (view.getId()){
            case R.id.GoToAlert:
                AlertDialog.Builder Alert = new AlertDialog.Builder(View.this);
                Alert.setTitle("Alert!");
                Alert.setMessage("There is something you need to know.");
                Alert.setCancelable(false);
                Alert.setPositiveButton("All Right", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                Alert.setNegativeButton("Noooo!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                Alert.show();
                break;
            default:
                break;
        }
    }
}

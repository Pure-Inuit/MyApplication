package com.pureinuit.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreatStart");
        setContentView(R.layout.activity_main);
        //点击按钮跳转生命周期内容的活动
        Button GoToPeriod = (Button) findViewById(R.id.GoToPeriod);
        GoToPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked the first Button and you will go to watch something about period of Android activity.", Toast.LENGTH_LONG).show();
                Intent intentToPeriod = new Intent(MainActivity.this, Period.class);
                startActivity(intentToPeriod);
            }
        });
        //使用EditText保存内容
        EditText EditForPrint = (EditText) findViewById(R.id.EditForPrint);
        //点击按钮跳转控件内容的活动
        Button GoToView = (Button) findViewById(R.id.GoToView);
        GoToView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText EditForPrint = (EditText) findViewById(R.id.EditForPrint);
                String inputForPrint = EditForPrint.getText().toString();
                Toast.makeText(MainActivity.this, "You clicked the second Button and you will go to watch views and you input " + inputForPrint + " in editview below", Toast.LENGTH_SHORT).show();
                Intent intentToView = new Intent("activity.Action_Start");
                intentToView.putExtra("extra_data", inputForPrint);
                startActivity(intentToView);
            }
        });

        //点击按钮跳转浏览器活动，此处为前往Browser活动
        Button GoToBrowser = (Button) findViewById(R.id.GoToBrowser);
        GoToBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked the fourth Button and you will see a browser", Toast.LENGTH_LONG).show();
                ;
                Intent intentToBrowser = new Intent(Intent.ACTION_VIEW);
                intentToBrowser.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intentToBrowser);
            }
        });
        //点击按钮跳转打电话的活动，此处为调用系统action
        Button GoToTel = (Button) findViewById(R.id.GoToTel);
        GoToTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked the fifth Button and you will phone a number", Toast.LENGTH_LONG).show();
                Intent intentToTel = new Intent(Intent.ACTION_DIAL);
                intentToTel.setData(Uri.parse("tel:18960395275"));
                startActivity(intentToTel);
            }
        });
        //点击按钮跳转ImageView，此处为跳转到ImageView
        Button GoToImageView = (Button) findViewById(R.id.GoToImageView);
        GoToImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToImageView = new Intent(MainActivity.this, ImageView.class);
                startActivity(intentToImageView);
            }
        });
        //点击按钮跳转自制浏览器
        Button GoToWeb = (Button) findViewById(R.id.GoToWeb);
        GoToWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToWeb = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intentToWeb);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}

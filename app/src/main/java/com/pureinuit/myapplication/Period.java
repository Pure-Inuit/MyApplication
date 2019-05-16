package com.pureinuit.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Period extends AppCompatActivity  implements View.OnClickListener{

    public static final String TAG = "PeriodActivity";
    private ProgressBar BarForTest;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//      return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.for_period,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.FirstItem:
                Toast.makeText(this,"Add Clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.SecondItem:
                Toast.makeText(this,"Remove Clicked",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_period);
        //从生命周期活动中返回
        Button ComeBackFromPeriod = (Button) findViewById(R.id.ComeBackFromPeriod);
        ComeBackFromPeriod.setOnClickListener(this);
        //前往一个普通的活动，此处是前往View活动
        Button GoToNormal = (Button) findViewById(R.id.GoToNormal);
        GoToNormal.setOnClickListener(this);
        //前往一个对话框活动，此处前往的是DialogForPeriod
        Button GoToDialog = (Button)findViewById(R.id.GoToDialog);
        GoToDialog.setOnClickListener(this);
        //点击关闭ProgressBar
        Button TurnPorcgressBarDown = (Button)findViewById(R.id.TurnPBarDown);
        TurnPorcgressBarDown.setOnClickListener(this);
        BarForTest = (ProgressBar) findViewById(R.id.BarForTest);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.GoToNormal:
                Intent intentToNormal = new Intent("activity.Action_Start");
                startActivity(intentToNormal);
                break;
            case R.id.GoToDialog:
                Intent intentToDialog = new Intent(Period.this,DialogForPeriod.class);
                startActivity(intentToDialog);
                break;
            case R.id.ComeBackFromPeriod:
                Intent intentToPeriod = new Intent(Period.this,MainActivity.class);
                startActivity(intentToPeriod);
                break;
            case R.id.TurnPBarDown:
                if (BarForTest.getVisibility()==View.GONE){
                    BarForTest.setVisibility(View.VISIBLE);
                } else{
                    BarForTest.setVisibility(View.GONE);
                }
                    int progress = BarForTest.getProgress();
                    progress = progress+10;
                    BarForTest.setProgress(progress);
                break;
                default:
                    break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}

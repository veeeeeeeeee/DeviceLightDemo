package com.xw.device.light;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * @author xuwei
 * @name TestActivity
 * @description
 * @date 2019/3/21
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void doLightOn(View view) {
        Log.i("xuweiii", "###@ execute on");
    }

    public void doLightOff(View view) {
        Log.i("xuweiii", "###@ execute off");
    }
}

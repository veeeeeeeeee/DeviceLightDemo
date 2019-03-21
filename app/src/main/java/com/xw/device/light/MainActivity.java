package com.xw.device.light;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * @author xuwei
 * @name MainActivity
 * @description
 * @date 2019/3/21
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doLightOn(View view) {
        Log.i("xuweiii", "###@ execute on");
        ctrlFlash(true);
    }

    public void doLightOff(View view) {
        Log.i("xuweiii", "###@ execute off");
        ctrlFlash(false);
    }

    private void ctrlFlash(boolean enable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LollipopFlashUtil.doFlashOn(this, enable);
        } else {
            DownOsFlashUtil.doFlashOn(this, enable);
        }
    }
}

package com.xw.device.light;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;

/**
 * @author xuwei
 * @name LollipopFlashUtil
 * @description
 * @date 2019/3/21
 */
public class LollipopFlashUtil {

    public static void doFlashOn(Context ctx, boolean enable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.i("xuweiii", "###@ android os >=6.0 device");
            try {
                CameraManager cm = (CameraManager) ctx.getSystemService(Context.CAMERA_SERVICE);
                if (cm != null) {
                    cm.setTorchMode("0", enable);
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
                Log.i("xuweiii", e.getMessage());
            }
        }
    }

}

package com.xw.device.light;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;

/**
 * @author xuwei
 * @name DownOsFlashUtil
 * @description
 * @date 2019/3/21
 */
public class DownOsFlashUtil {

    private static Camera sCamera;

    public static void doFlashOn(Context ctx, boolean enable) {
        if (enable) {
            final PackageManager pm = ctx.getPackageManager();
            final FeatureInfo[] features = pm.getSystemAvailableFeatures();
            boolean hasFlashFeature = false;
            for (final FeatureInfo featureInfo : features) {
                if (PackageManager.FEATURE_CAMERA_FLASH.equals(featureInfo.name)) {
                    if (sCamera == null) {
                        sCamera = Camera.open();
                    }
                    if (sCamera != null) {
                        final Camera.Parameters parameters = sCamera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        sCamera.setParameters(parameters);
                        sCamera.startPreview();
                    }
                    hasFlashFeature = true;
                }
            }
            if (hasFlashFeature) {
                Log.i("xuweiii", "###@ the device has flash feature");
            } else {
                Log.i("xuweiii", "###@ the device no flash feature");
            }
        } else {
            Log.i("xuweiii", "###@ android os <6.0 device");
            if (sCamera != null) {
                sCamera.stopPreview();
                sCamera.release();
                sCamera = null;
            }
        }
    }

}

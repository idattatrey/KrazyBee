package com.krazy.bee.utils;

import android.app.Activity;
import android.app.ProgressDialog;


public class ProgressView {
    private static ProgressDialog progress;

    public static void showProgressDialog(Activity activity) {
        progress = new ProgressDialog(activity);
        progress.setMessage("Please wait ...");
        progress.setProgressStyle(0);
        progress.show();
    }

    public static void closeProgressDialog() {
        progress.hide();
    }

}

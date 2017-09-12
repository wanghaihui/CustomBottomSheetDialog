package com.wlwl.os.listbottomsheetdialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

/**
 * 解决BottomSheetDialog弹出后状态栏变黑的问题
 * Created by yanggeng on 2017/7/25.
 */

public class MyBottomSheepDialog extends BottomSheetDialog {
    private Activity activity;
    public MyBottomSheepDialog(@NonNull Context context) {
        super(context);
        if(context instanceof Activity) {
            activity = (Activity) context;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenHeight = getScreenHeight(activity);
        int statusBarHeight = getStatusBarHeight(activity);
        int dialogHeight = screenHeight - statusBarHeight;
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
    }

    private static int getScreenHeight(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    private static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

}

package com.wlwl.os.listbottomsheetdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 使用BottomSheetDialog做仿QQ底部弹出对话框
 * Created by yanggeng on 2017/9/12.
 */

public class BottomSheetDialogUtil {
    private static MyBottomSheepDialog mBottomSheetDialog;

    public static MyBottomSheepDialog init(Context context, String[] items, OnItemClickListener onItemClickListener) {

        mBottomSheetDialog = new MyBottomSheepDialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.c_layout_normal_bottom_sheet_dialog, null);
        // 强制隐藏键盘
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        view.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
            }
        });

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new MyDecoration(context));//添加分割线
        ItemAdapter adapter = new ItemAdapter(context, items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.setCanceledOnTouchOutside(true);
        setBehaviorCallback(mBottomSheetDialog);
        return mBottomSheetDialog;
    }

    /**
     * 处理bottomSheetDialog打开、关闭后，打不开的问题
     */
    public static void setBehaviorCallback(@Nullable final BottomSheetDialog bottomSheetDialog) {
        View view = bottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(view);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetDialog.dismiss();
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    public static void dismiss() {
        if (mBottomSheetDialog != null && mBottomSheetDialog.isShowing()) {
            mBottomSheetDialog.dismiss();
        }
    }

}

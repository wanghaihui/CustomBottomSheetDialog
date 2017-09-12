package com.wlwl.os.custombottomsheetdialog;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wlwl.os.listbottomsheetdialog.BottomSheetDialogUtil;
import com.wlwl.os.listbottomsheetdialog.OnItemClickListener;

public class MainActivity extends AppCompatActivity {
    
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        findViewById(R.id.btn_pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogUtil.init(context,
                        new String[]{"拍照", "从相册选取"},
                        new OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Toast.makeText(context, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}

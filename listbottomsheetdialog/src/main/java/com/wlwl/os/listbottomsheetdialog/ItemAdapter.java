package com.wlwl.os.listbottomsheetdialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 列表项adapter
 * Created by yanggeng on 2017/9/12.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private String[] data;
    private OnItemClickListener onItemClickListener;

    public ItemAdapter(Context context, String[] items) {
        this.context = context;
        this.data = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.c_layout_textview, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.item.setText(data[position]);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position);
                BottomSheetDialogUtil.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        public ItemViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

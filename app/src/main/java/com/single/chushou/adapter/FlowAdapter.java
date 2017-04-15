package com.single.chushou.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.single.chushou.R;
import com.single.chushou.activity.ChuShouScrollActivity;

import java.util.List;

class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ChuShouScrollActivity.ShowItem> arrays;
    Context context;


    public FlowAdapter(List<ChuShouScrollActivity.ShowItem> arrays, Context context) {
        this.arrays = arrays;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(context, R.layout.flow_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textView = ((MyHolder) holder).text;
        textView.setBackgroundDrawable(getBack(arrays.get(position).color));
        textView.setText(arrays.get(position).des);
    }

    private Drawable getBack(int color) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(8);
        drawable.setColor(color);
        return drawable;
    }

    @Override
    public int getItemCount() {
        return arrays.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public MyHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.flow_text);
        }
    }
}
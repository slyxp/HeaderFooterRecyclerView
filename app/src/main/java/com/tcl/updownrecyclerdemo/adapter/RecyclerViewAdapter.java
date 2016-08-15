package com.tcl.updownrecyclerdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tcl.updownrecyclerdemo.R;

import java.util.List;
import java.util.Map;

/**
 * @author Liyang Sun
 * @Description:
 * @date 2016/8/12 15:30
 * @copyright HAWK
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Map<String, String>> dataList;

    public RecyclerViewAdapter(List<Map<String, String>> dataList) {
        this.dataList = dataList;
    }

    public List<Map<String, String>> getDataList() {
        return dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cardTitle.setText(dataList.get(position).get("com.tcl.recycler.card.title"));
        holder.cardTitle.setHeight(Integer.parseInt(dataList.get(position).get("com.tcl.recycler.card.height")));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cardTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            cardTitle = (TextView) itemView.findViewById(R.id.card_title);
        }
    }
}

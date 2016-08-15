package com.tcl.updownrecyclerdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tcl.updownrecyclerdemo.adapter.RecyclerViewAdapter;
import com.tcl.updownrecyclerdemo.recycler.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private PullLoadMoreRecyclerView pullLoadMoreRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private int mCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.pullLoadMoreRecyclerView);
        pullLoadMoreRecyclerView.setStaggeredGridLayout(2);
        recyclerViewAdapter = new RecyclerViewAdapter(recyclerList());
        pullLoadMoreRecyclerView.setAdapter(recyclerViewAdapter);
        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                setRefresh();
                getData();
            }

            @Override
            public void onLoadMore() {
                mCount += 1;
                getData();
            }
        });

    }

    private void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerViewAdapter.getDataList().addAll(recyclerList());
                recyclerViewAdapter.notifyDataSetChanged();
                pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }
        }, 1000);
    }

    private List<Map<String, String>> recyclerList() {
        List<Map<String, String>> dataList = new ArrayList<>();
        int start = 30 * (mCount - 1);
        Map<String, String> map;
        for (int i = start; i < 30 * mCount; ++ i) {
            map = new HashMap<>();
            map.put("com.tcl.recycler.card.title", "HaHa" + i);
            map.put("com.tcl.recycler.card.height", (100 + 5 * i) + "");
            dataList.add(map);
        }

        return dataList;
    }

    private void setRefresh() {
        recyclerViewAdapter.getDataList().clear();

        mCount = 1;
    }
}

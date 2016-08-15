package com.tcl.updownrecyclerdemo.recycler;

import android.support.v4.widget.SwipeRefreshLayout;

import com.tcl.updownrecyclerdemo.recycler.*;

/**
 * @author Liyang Sun
 * @Description:
 * @date 2016/8/15 14:26
 * @copyright HAWK
 */

public class SwipeRefreshLayoutOnRefresh implements SwipeRefreshLayout.OnRefreshListener {
    private com.tcl.updownrecyclerdemo.recycler.PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;

    public SwipeRefreshLayoutOnRefresh(com.tcl.updownrecyclerdemo.recycler.PullLoadMoreRecyclerView pullLoadMoreRecyclerView) {
        this.mPullLoadMoreRecyclerView = pullLoadMoreRecyclerView;
    }

    @Override
    public void onRefresh() {
        if (!mPullLoadMoreRecyclerView.isRefresh()) {
            mPullLoadMoreRecyclerView.setIsRefresh(true);
            mPullLoadMoreRecyclerView.refresh();
        }
    }
}

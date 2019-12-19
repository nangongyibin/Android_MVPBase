package com.ngyb.mvpbase;

import android.widget.AbsListView;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/12/18 21:41
 */
public abstract class BaseLoadMoreListFragment extends BaseListFragment {
    @Override
    protected void initListView() {
        super.initListView();
        getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState ==SCROLL_STATE_IDLE){
                    if (shouldStartLoadMore()){
                        loadMoreData();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private boolean shouldStartLoadMore() {
        return getListView().getLastVisiblePosition()==getListAdapter().getCount()-1+getListView().getHeaderViewsCount();
    }

    protected abstract void loadMoreData();
}

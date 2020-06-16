package com.ngyb.mvpbase;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/12/18 21:33
 */
public abstract class BaseListFragment extends BaseLoadDataFragment {
    private ListView listView;
    private BaseAdapter listAdapter;

    @Override
    protected View onCreateContentView() {
        listView = new ListView(getContext());
        listAdapter = onCreateAdapter();
        View view = onCreateHeaderView();
        if (view!=null){
            listView.addHeaderView(view);
        }
        listView.setAdapter(listAdapter);
        initListView();
        return listView;
    }

    protected  void initListView(){
        listView.setDivider(null);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position = position-getListView().getHeaderViewsCount();
                onListItemClick(position);
            }
        });
    }

    protected void onListItemClick(int position) {
    }

    protected  View onCreateHeaderView(){
        return null;
    }

    public ListView getListView() {
        return listView;
    }

    public BaseAdapter getListAdapter() {
        return listAdapter;
    }

    protected abstract BaseAdapter onCreateAdapter();
}

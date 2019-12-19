package com.ngyb.mvpbase.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/12/18 21:48
 */
public abstract  class BaseListAdapter<T> extends BaseAdapter {
    private final Context context;
    private final List<T> dataList;

    public BaseListAdapter(Context context, List<T> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        if (dataList==null){
            return 0;
        }
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView==null){
            convertView = onCreateItemView(position);
            vh  = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        onBindItemView(vh.itemView,position);
        return convertView;
    }

    protected abstract void onBindItemView(View itemView, int position);

    protected abstract View onCreateItemView(int position);

    public static class ViewHolder{
        private View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }

    public Context getContext() {
        return context;
    }

    public List<T> getDataList() {
        return dataList;
    }
}

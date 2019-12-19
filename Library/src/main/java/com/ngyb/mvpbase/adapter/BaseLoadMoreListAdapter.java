package com.ngyb.mvpbase.adapter;

import android.content.Context;
import android.view.View;

import com.ngyb.mvpbase.view.LoadingView;

import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/12/18 21:56
 */
public abstract class BaseLoadMoreListAdapter<T> extends BaseListAdapter<T> {
    public static final int ITEM_TYPE_ZERO = 0;
    public static final int ITEM_TYPE_ONE = 1;

    public BaseLoadMoreListAdapter(Context context, List<T> dataList) {
        super(context, dataList);
    }

    @Override
    public int getCount() {
        if (getDataList() == null) {
            return 0;
        }
        return getDataList().size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getCount()-1){
            return ITEM_TYPE_ZERO;
        }else{
            return ITEM_TYPE_ONE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    protected void onBindItemView(View itemView, int position) {
        if (getItemViewType(position) ==ITEM_TYPE_ONE){
            onBindNormalItemView(itemView,position);
        }
    }

    protected abstract void onBindNormalItemView(View itemView, int position);

    @Override
    protected View onCreateItemView(int position) {
        if (getItemViewType(position) ==ITEM_TYPE_ONE){
            return onCreateOneItemView();
        }else{
            return new LoadingView(getContext());
        }
    }

    protected abstract View onCreateOneItemView();
}

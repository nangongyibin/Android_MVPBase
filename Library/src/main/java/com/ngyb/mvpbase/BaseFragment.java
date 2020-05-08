package com.ngyb.mvpbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/4/15 10:17
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(this.getLayoutId(), container, false);
        init(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        dealOnCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    protected void dealOnCreate(Bundle savedInstanceState) {
    }

    ;

    /**
     * 初始化视图
     *
     * @param view
     */
    protected abstract void init(View view);

    protected abstract int getLayoutId();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        dealOnActivityCreated(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    protected void dealOnActivityCreated(Bundle savedInstanceState) {
    }
}

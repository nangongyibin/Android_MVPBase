package com.ngyb.mvpbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
    public Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (getOnCreateView() == null) {
            view = inflater.inflate(this.getLayoutId(), container, false);
        } else {
            view = getOnCreateView();
        }
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        dealOnActivityCreated(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dealOnViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dealOnDestroyView();
    }

    protected void dealOnDestroyView() {
    }

    protected void dealOnViewCreated(View view, Bundle savedInstanceState) {
    }

    protected void dealOnActivityCreated(Bundle savedInstanceState) {
    }

    @Override
    public void onResume() {
        dealOnResume();
        super.onResume();
    }

    protected void dealOnResume() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        dealOnAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dealOnDetach();
        context = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        dealOnStart();
    }

    protected void dealOnStart() {
    }

    protected void dealOnDetach() {
    }

    protected void dealOnAttach(Context context) {
    }

    /**
     * 初始化视图
     *
     * @param view
     */
    protected abstract void init(View view);

    protected abstract int getLayoutId();

    protected View getOnCreateView() {
        return null;
    }
}

package com.ngyb.mvpbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/4/15 10:16
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context context;
    private static final String BUNDLE_FRAGMENTS_KEY = "android:support:fragments";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null && this.clearFragmentsTag()) {
            //重建时清除 fragment的状态
            savedInstanceState.remove(BUNDLE_FRAGMENTS_KEY);
        }
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(this.getLayoutId());
        dealOnCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null && this.clearFragmentsTag()) {
            //销毁时不保存fragment的状态
            outState.remove(BUNDLE_FRAGMENTS_KEY);
        }
        dealOnSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dealOnResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dealOnPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dealOnDestroy();
        context = null;
    }

    protected void dealOnCreate(Bundle savedInstanceState) {
    }

    protected void dealOnPause() {
    }

    protected void dealOnResume() {
    }

    /**
     * @param savedInstanceState
     */
    protected void dealOnSaveInstanceState(Bundle savedInstanceState) {
    }

    protected void dealOnDestroy() {
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图
     */
    public abstract void init();

    protected boolean clearFragmentsTag() {
        return true;
    }
}


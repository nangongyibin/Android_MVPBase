package com.ngyb.mvpbase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;


/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/12/18 21:16
 */
public abstract  class BaseLoadDataFragment extends BaseFragment {

    private ProgressBar progressBar;
    private Button retry;
    private LinearLayout errorLayout;
    private FrameLayout frameContent;

    @Override
    protected void init(View view) {
        initView(view);
        initListener();
    }

    private void initListener() {
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                errorLayout.setVisibility(View.GONE);
                startLoadData();
            }
        });
    }

    private  void initView(View view){
        progressBar = view.findViewById(R.id.progress_bar);
        retry = view.findViewById(R.id.retry);
        errorLayout = view.findViewById(R.id.error_layout);
        frameContent = view.findViewById(R.id.frame_content);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_base;
    }

    @Override
    protected void dealOnViewCreated(View view, Bundle savedInstanceState) {
        super.dealOnViewCreated(view, savedInstanceState);
        startLoadData();
    }

    protected void onLoadDataSuccess(){
        progressBar.setVisibility(View.GONE);
        errorLayout.setVisibility(View.GONE);
        frameContent.addView(onCreateContentView());
    }

    public void onDataLoadFailed(){
        if (progressBar!=null){
            progressBar.setVisibility(View.GONE);
        }
        if (errorLayout!=null){
            errorLayout.setVisibility(View.VISIBLE);
        }
    }

    protected abstract View onCreateContentView();

    protected abstract void startLoadData();
}

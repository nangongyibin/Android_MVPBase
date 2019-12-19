package com.ngyb.mvpbase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.ngyb.mvpbase.R;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/12/19 21:03
 */
public class LoadingView extends RelativeLayout {
    public LoadingView(Context context) {
        super(context,null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs,-1);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_loading,this);
    }
}

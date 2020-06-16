package com.ngyb.mvpbase;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/4/15 10:20
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {
    protected T presenter;

    @Override
    protected void dealOnDestroyView() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.dealOnDestroyView();
    }
}
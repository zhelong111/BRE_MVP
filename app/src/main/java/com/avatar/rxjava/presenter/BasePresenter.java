package com.avatar.rxjava.presenter;

import com.avatar.rxjava.view.base.BaseView;

/**
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 18:49
 */
public abstract class BasePresenter<T extends BaseView> {
    protected T baseView;
    public BasePresenter(T baseView) {
        this.baseView = baseView;
        init();
    }

    public T getBaseView() {
        return baseView;
    }

    /**
     * 子类可以实现，并执行相关操作，如资源回收，结束定时线程等
     */
    public void onDestory() {}

    public void onResume() {}

    public void onPause() {}

    /**
     * 初始化方法，进入本页面执行的初始方法
     */
    public abstract void init();
}

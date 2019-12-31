package com.bawei.liruilong.base;

/**
 * Time:2019/12/31
 * Author:天祈Aa
 * Description:
 */
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attach(V view) {
        this.view = view;
    }
    public void dttach() {
        view = null;
    }
}

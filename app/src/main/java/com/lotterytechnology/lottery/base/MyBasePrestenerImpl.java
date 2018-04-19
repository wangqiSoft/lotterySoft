package com.lotterytechnology.lottery.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by zns on 2017/4/14.
 */

public class MyBasePrestenerImpl<T extends BaseView> {
    protected CompositeDisposable mSubscriptions;
    protected T mView;
    protected BaseActivity mact;

    public MyBasePrestenerImpl(T mView) {
        this.mView = mView;
        mSubscriptions = new CompositeDisposable();
    }

    public MyBasePrestenerImpl(T mView, BaseActivity baseActivity) {
        this.mView = mView;
        this.mact = baseActivity;
        mSubscriptions = new CompositeDisposable();
    }

}

package com.lotterytechnology.lottery.presenter;

import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseActivity;
import com.lotterytechnology.lottery.base.MyBasePrestenerImpl;
import com.lotterytechnology.lottery.bean.RequestBean;
import com.lotterytechnology.lottery.bean.ResponseData;
import com.lotterytechnology.lottery.bean.UserBean;
import com.lotterytechnology.lottery.contract.LoginContract;
import com.lotterytechnology.lottery.net.ApiManager;
import com.orhanobut.logger.Logger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Ryder
 * create at 2018/4/11 9:39
 * package name:com.runshoptechnology.runshop.presenter
 * description: 登录的实现类
 **/
public class LoginPresenterImpl extends MyBasePrestenerImpl<LoginContract.loginView> implements LoginContract.loginPresenter {
    public LoginPresenterImpl(LoginContract.loginView mView) {
        super(mView);
    }

    public LoginPresenterImpl(LoginContract.loginView mView, BaseActivity baseActivity) {
        super(mView, baseActivity);
    }

    @Override
    public void login(RequestBean requestBean, boolean isShowLoading) {
        Disposable disposable = ApiManager.getApiService().Login(requestBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseData<UserBean>>() {
                    @Override
                    public void accept(@NonNull ResponseData<UserBean> msgBeanResponseData) throws Exception {
                        mView.hideProgress();
                        if (msgBeanResponseData != null && msgBeanResponseData.getCode().equals("30000")) {
                            if (msgBeanResponseData.getResult() != null) {
                                mView.loginSucess(msgBeanResponseData);
                            }else{
                                mView.fail(mact.getResources().getString(R.string.error_toast));
                            }
                        } else {
                            mView.fail("" + msgBeanResponseData.getMessage());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Logger.e(throwable,"message = "+throwable.getMessage());
                        mView.hideProgress();
                        mView.fail(mact.getResources().getString(R.string.error_toast));
                    }
                });
        mSubscriptions.add(disposable);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }
}

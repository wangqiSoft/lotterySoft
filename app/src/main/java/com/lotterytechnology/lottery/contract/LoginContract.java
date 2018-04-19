package com.lotterytechnology.lottery.contract;

import com.lotterytechnology.lottery.base.BasePresenter;
import com.lotterytechnology.lottery.base.BaseView;
import com.lotterytechnology.lottery.bean.RequestBean;
import com.lotterytechnology.lottery.bean.ResponseData;
import com.lotterytechnology.lottery.bean.UserBean;

/**
 * @author Ryder
 * create at 2018/4/11 9:29
 * package name:com.runshoptechnology.runshop.contract
 * description:  登录的contract
 **/
public interface LoginContract {

    interface loginPresenter extends BasePresenter {
        void login(RequestBean requestBean, boolean isShowLoading);
    }


    interface loginView extends BaseView {
        void loginSucess(ResponseData<UserBean> data);
    }
}

package com.lotterytechnology.lottery.ui.me;

import android.view.View;
import android.widget.Button;


import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseActivity;
import com.lotterytechnology.lottery.bean.ResponseData;
import com.lotterytechnology.lottery.bean.UserBean;
import com.lotterytechnology.lottery.contract.LoginContract;
import com.lotterytechnology.lottery.presenter.LoginPresenterImpl;
import com.lotterytechnology.lottery.widget.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
* @author Ryder
* create at 2018/4/11 9:50
 * package name:com.runshoptechnology.runshop.ui.me
* description: 登录界面
**/
public class LoginActivity extends BaseActivity<LoginContract.loginPresenter> implements LoginContract.loginView {

    @BindView(R.id.login_Topbar)
    TopBar loginTopbar;

    @BindView(R.id.login_btn)
    Button btnLogin;

    @Override
    protected int getlayoutContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginContract.loginPresenter generatePresenter() {
        return new LoginPresenterImpl(this,this);
    }

    @Override
    protected View setTopView() {
        return loginTopbar;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public void loginSucess(ResponseData<UserBean> data) {

    }



    @Override
    public void fail(String msg) {

    }

    @Override
    public void noData() {

    }

    @Override
    public void showProgress() {
        showProgressDialog("");
    }

    @Override
    public void hideProgress() {
        closeProgressDialog();
    }

    @OnClick(R.id.login_btn)
    public void onClick(){
//        mPresenter.login(new RequestBean(),false );
    }
}

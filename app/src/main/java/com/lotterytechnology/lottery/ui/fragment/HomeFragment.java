package com.lotterytechnology.lottery.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseFragment;
import com.lotterytechnology.lottery.widget.RippleBackground;
import com.lotterytechnology.lottery.widget.TopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

/**
 * @author Ryder
 * create at 2018/4/10 11:53
 * package name:com.runshoptechnology.runshop.fragment
 * description: 首页的fragment
 **/
public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_fragment_topbar)
    TopBar homeTopbar;

    @BindView(R.id.home_rippbag)
    RippleBackground rippleBackground;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        super.initView();
        homeTopbar.setLeftButtonNoPic();
        homeTopbar.setRightTextGone();
        rippleBackground.startRippleAnimation();
    }

    @Override
    protected View setTopView() {
        return homeTopbar;
    }

    public HomeFragment() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            if (null != rippleBackground){
                rippleBackground.startRippleAnimation();
            }else {
                rippleBackground.stopRippleAnimation();
            }
        }
    }

    @OnClick()
    public void onClick() {
//        StartActivityUtil.GoLoginActivity(getActivity(), new Bundle());
    }


}

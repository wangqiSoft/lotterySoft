package com.lotterytechnology.lottery.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseFragment;
import com.lotterytechnology.lottery.utils.StartActivityUtil;
import com.lotterytechnology.lottery.widget.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Ryder
 * create at 2018/4/10 12:02
 * package name:com.runshoptechnology.runshop.fragment
 * description: 我的fragment
 **/
public class MeFragment extends BaseFragment {
    @BindView(R.id.me_topbar)
    TopBar meTopbar;

    public MeFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        super.initView();
        meTopbar.setLeftButtonNoPic();
        meTopbar.setTitle(R.string.me_name);
        meTopbar.setRightTextGone();
    }

    @Override
    protected View setTopView() {
        return meTopbar;
    }

    @OnClick(R.id.btn_goregist)
    public void onClick(View view) {
        StartActivityUtil.GoToRegistActivity(getContext(), new Bundle());
    }

}

package com.lotterytechnology.lottery.ui.fragment;

import android.text.format.DateUtils;
import android.view.View;

import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseFragment;
import com.lotterytechnology.lottery.bean.WinInfoBean;
import com.lotterytechnology.lottery.widget.CustomTouchRecyclerView;
import com.lotterytechnology.lottery.widget.RippleBackground;
import com.lotterytechnology.lottery.widget.TopBar;

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

    @BindView(R.id.home_win_information_rv)
    CustomTouchRecyclerView customTouchRecyclerView;
    private List<WinInfoBean> winInfoBeanList;

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
        winInfoBeanList = new ArrayList<>();
        for (int i = 0; i< 30 ;i++){
            WinInfoBean winInfoBean = new WinInfoBean();
            winInfoBean.setUserName("用户"+123+i*3+"***");
            winInfoBean.setBetAmt(""+10+i*2);
            winInfoBean.setCreateTime(TimeUtils.getNowString());
            winInfoBean.setGameName("大乐透");
            winInfoBean.setId("3127541564");
            winInfoBean.setLink("http://www.baidu.com");
            winInfoBean.setPlatform("彩票平台");
            winInfoBean.setPrize(""+100*i);
            winInfoBean.setPrizeTime(TimeUtils.getNowString());
            winInfoBean.setStatus(1);
            winInfoBeanList.add(winInfoBean);
        }
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
        if (getUserVisibleHint()) {
            if (null != rippleBackground) {
                rippleBackground.startRippleAnimation();
            }
        }else {
            if (null != rippleBackground)
                rippleBackground.stopRippleAnimation();
        }
    }

    @OnClick(R.id.home_btn_buy)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_btn_buy:
                Toasty.info(getContext(),"您点击了购买按钮").show();
                break;
        }

    }


}

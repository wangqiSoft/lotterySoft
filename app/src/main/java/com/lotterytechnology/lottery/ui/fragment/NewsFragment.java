package com.lotterytechnology.lottery.ui.fragment;

import android.view.View;

import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseFragment;
import com.lotterytechnology.lottery.widget.TopBar;

import butterknife.BindView;

/**
 * @author Ryder
 * create at 2018/4/10 11:58
 * package name:com.runshoptechnology.runshop.fragment
 * description: 资讯的fragment
 **/
public class NewsFragment extends BaseFragment {
    @BindView(R.id.hot_fragment_topbar)
    TopBar hotTopbar;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        super.initView();
        hotTopbar.setLeftButtonNoPic();
        hotTopbar.setTitle(R.string.news_name);
        hotTopbar.setRightTextGone();
    }

    @Override
    protected View setTopView() {
        return hotTopbar;
    }

    public NewsFragment() {
    }
}

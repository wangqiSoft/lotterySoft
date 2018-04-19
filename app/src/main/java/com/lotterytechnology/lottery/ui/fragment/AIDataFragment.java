package com.lotterytechnology.lottery.ui.fragment;

import android.view.View;

import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseFragment;
import com.lotterytechnology.lottery.widget.TopBar;

import butterknife.BindView;

/**
 * @author Ryder
 * create at 2018/4/10 12:01
 * package name:com.runshoptechnology.runshop.fragment
 * description: AI大数据分析的fragment (忽悠AI的大数据的界面哈)
 **/
public class AIDataFragment extends BaseFragment {
    @BindView(R.id.chart_topbar)
    TopBar chartTopbar;

    public AIDataFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_ai_data;
    }

    @Override
    protected void initView() {
        super.initView();
        chartTopbar.setLeftButtonNoPic();
        chartTopbar.setTitle(R.string.AI_name);
        chartTopbar.setRightTextGone();
    }

    @Override
    protected View setTopView() {
        return chartTopbar;
    }
}
